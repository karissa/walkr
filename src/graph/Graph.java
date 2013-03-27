package graph;

import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.json.*;

import collections.GoogleMap;

import flickr.Flickr;
import flickr.Photo;

public class Graph {

	private HashMap<String, Node> nodes = new HashMap<String, Node>();
	private Flickr flickr = new Flickr(this);
	private double leftmost = 0, rightmost = 0, topmost = 0, bottommost = 0;
	private GoogleMap map;
	private boolean firstPhoto = true;
	
	public Graph() {
		flickr.findPhotosByTag("c343_fall2010");
	}
	
	public Graph(String jsonFile) {
		JSONObject json = null;
		JSONObject json2 = null;
		File fis = null;
		fis = new File(jsonFile);

		try {
			json = new JSONObject(new JSONTokener(new FileReader(fis)));
			json2 = new JSONObject(new JSONTokener(new FileReader(new File("edges.json"))));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			parseJSON(json);
			parseJSON2(json2);
		} catch (JSONException e) {
			System.out.println("couldn't parse json");
			e.printStackTrace();
		}
		finally{
		flickr.findPhotosByTag("c343_fall2010");
		}
	}
	
	public int getSize(){
		return nodes.size();
	}
	
	
	private void parseJSON(JSONObject json) throws JSONException {
		JSONArray nodes = json.getJSONArray("nodes");
		JSONObject node = null;
		Node toAdd = null;
		for(int i = 0; i < nodes.length(); i++) {
			toAdd = new Node();
			node = nodes.getJSONObject(i);
			toAdd.setID(String.valueOf(node.getInt("id")));
			toAdd.setName(node.getString("name"));
			toAdd.setLat(node.getDouble("lat"));
			toAdd.setLon(node.getDouble("lon"));
			addNode(toAdd);
			findMapBounds(toAdd);
		}
		System.out.println("JSON PARSED");
	}
	
	private void parseJSON2(JSONObject json) throws JSONException {
		JSONArray edges = json.getJSONArray("edges");
		JSONArray towardLocations;
		JSONObject edge = null;
		Node toward;
		Node from; 
		
		Edge toAdd = null;
		for(int i = 0; i < edges.length(); i++) {
			edge = edges.getJSONObject(i);
			from = nodes.get(edge.getString("from"));
			if (from != null) { // can we change to allow for other nodes outside of JSON or something
				towardLocations = edge.getJSONArray("toward");
				for (int j = 0; j < towardLocations.length(); j++) {
					toward = nodes.get(towardLocations.getString(j));
					if (toward != null) {
						if (from.getDirectedEdge(toward) == null) {
							toAdd = new Edge(from, toward);
							from.addAdjacentEdge(toAdd);
						}
					}
				}
			}
		}
	}
	
	public void parsePhotos(ArrayList<Photo> photos){
		Iterator<Photo> itr = photos.iterator();
		Photo photo;
		while(itr.hasNext()){
			photo = itr.next();
			parse(photo);
		}
		
	}
	
	public void parse(Photo photo) {
		if (photo.isNode()){ //if the photo represents a node, put it in the node hashmap
			Node thisNode = nodes.get(photo.getNodeName());
			if(thisNode != null){
				thisNode.addPhoto(photo);
			}else {}
				//nodes.put(photo.getNodeName(),new Node(photo));
		} else {//else the photo represents an edge
		String fromstr = photo.getFrom(), towardstr = photo.getToward(); 
		Edge tempEdge = null;
		Node from = nodes.get(fromstr);
		Node toward = nodes.get(towardstr);
		if(from == null || toward == null) //if there isn't a node with this photo's from, create a new one
			return;
		tempEdge = from.getDirectedEdge(towardstr);
		
		if (tempEdge != null){//edge exists
			tempEdge.addItem(photo);
		}
		 else {//need to create a new edge
			Edge toAdd = new Edge(from, toward);
			toAdd.addItem(photo);
			from.addAdjacentEdge(toAdd);
		 }

		}
	}
	
	private void findMapBounds(Photo photo) {
		//compare photo's lat & lon with the Strings
		double lat = Double.parseDouble(photo.getLatitude());
		double lon = Double.parseDouble(photo.getLongitude());
		if(firstPhoto){
			leftmost = lat;
			rightmost = lat;
			topmost = lon;
			bottommost = lon;
			firstPhoto= false;
		}
		if(lat == 0 || lon == 0)
			return;
		if(lat < leftmost) 
			leftmost = lat;
		if(lat > rightmost) 
			rightmost = lat;
		if(lon > topmost)
			topmost = lon;
		if(lon < bottommost)
			bottommost = lon;
	}
	private void findMapBounds(Node node) {
		//compare photo's lat & lon with the Strings
		double lat = node.getLat();
		double lon = node.getLon();
		if(firstPhoto){
			leftmost = lat;
			rightmost = lat;
			topmost = lon;
			bottommost = lon;
			firstPhoto= false;
		}
		if(lat == 0 || lon == 0)
			return;
		if(lat < leftmost) 
			leftmost = lat;
		if(lat > rightmost) 
			rightmost = lat;
		if(lon > topmost)
			topmost = lon;
		if(lon < bottommost)
			bottommost = lon;
	}

	public Node getNode(String name) {
		return nodes.get(name);
	}
	
	public void addNode(Node node) {
		nodes.put(node.getName(), node);
	}

	public String toString() {
		return nodes.toString();
	}

	public String getCenter() {
		String lat, lon;
		lat = String.valueOf((leftmost + rightmost) / 2);
		lon = String.valueOf((topmost + bottommost) / 2);
		System.out.println(lat + "," + lon);
		return lat + "," + lon;
	}
	
	
	public Iterator<Node> iterator(){
		return nodes.values().iterator();
	}

	public Node getNode(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	/** Sets the map to the given map
	 * @param map the map to set
	 */
	public void setMap(GoogleMap map) {
		this.map = map;
	}

	/** Returns the map for this Walkr
	 * @return the map
	 */
	public GoogleMap getMap() {
		return map;
	}

	public void paint(Graphics2D g2, GoogleMap map2) {
		for(Node n : nodes.values()) {
			n.paint(g2, map2);
		}
		
	}

	public Collection<Node> getNodes() {
		return nodes.values();
	}
}
