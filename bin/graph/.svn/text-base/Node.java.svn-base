package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import collections.GoogleMap;
import exceptions.ItemNotFoundException;
import flickr.Photo;

/**
 * @author krmckelv, Karissa McKelvey
 * @author fmackey, Frank Mackey
 * @author ppitzer, Phil Pitzer
 */
public class Node implements Comparable<Node>{

  private Photo photo;
 // private ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();
  private LinkedList<Edge> adjacentEdges = new LinkedList<Edge>();
  private ArrayList<Photo> photos = new ArrayList<Photo>();
  private String id, name;
  private Double lat, lon;
  private Coordinate coords = new Coordinate();
  private boolean visited = false;
  private boolean selected = false;
  private double distance = Double.POSITIVE_INFINITY;
  private Node previous = null;



public Node() {
	  
  }
  
  public Node(Photo p) {
    addPhoto(p);
    this.name = p.getNodeName();
    setLat(Double.parseDouble(photo.getLatitude()));
    setLon(Double.parseDouble(photo.getLongitude()));
  }
  
  public Node(String nodeName) {
	  this.name = nodeName;
  }
  
  public void addPhoto(Photo photo) {
	  if(photos.size() == 0)
		  this.photo = photo; //if this is the first photo to be added, set it as the node photo
	  photos.add(photo);
		  
  }
  /** Returns the photo for this Node
   * @return the photo
   */
  public Photo getPhoto() {
    return photo;
  }
  
  public void setCoordinates(double lat, double lon) {
	  this.lat = lat;
	  this.lon = lon;
	  this.coords = new Coordinate(lat,lon);
  }

  public void setMap(GoogleMap map) {
	  coords.setMap(map);
  }
  
  public Point getPoint(GoogleMap map) {
	  setMap(map);
	  return new Point((int)getX(),(int)getY());
  }
  public void setCoordinates(double lat, double lon, GoogleMap map) {
	  this.lat = lat;
	  this.lon = lon;
	  this.coords = new Coordinate(lat,lon, map);
  }

  public boolean hasCoordinates() {
	  return (lat != null && lat != 0) &&
  		(lon != null && lon != 0);
  }
  
  public double distanceFrom(Node n) {
    Photo that = n.getPhoto();
    if(hasCoordinates() && n.hasCoordinates())
    	return Math.sqrt(Math.pow(lat - n.getLat(), 2) + Math.pow(lon - n.getLon(), 2));
    else {
    	if(hasPhoto() && that != null)
        	return this.photo.getCoordinates().getRange(that.getCoordinates());
        else return 1; //Double.POSITIVE_INFINITY;
    }
  }
  
  private boolean hasPhoto() {
	return photo != null;
  }

  public String getName() {
    return name;
  }
  
  public void addAdjacentEdge(Edge e) {
    adjacentEdges.add(e);
  }

  public LinkedList<Edge> getAdjacentEdges() {
	    return adjacentEdges;
	  }
  /**
   * Returns the edge with the given ID that is
   * adjacent to this node. 
   */
  public Edge lookupByID(String ID) throws ItemNotFoundException {
    Photo photo;
    for(Edge e : getAdjacentEdges()) {
    	photo = e.getToward().getPhoto();
    	if(id.equals(ID))
    		return e;
    }
    throw new ItemNotFoundException("No adjacent edge found between " + getID() + " and " + ID);
  }
  
  public boolean equals(Node that) {
	  return name.trim().equals(that.getName().trim());
  }
  /**
   * Returns the edge with the given nodeName that is
   * adjacent to this node. 
   */
  public Edge lookupByName(String nodeName) throws ItemNotFoundException {
    Photo photo;
    for(Edge e : getAdjacentEdges()) {
    	photo = e.getFrom().getPhoto();
    	if(photo.getNodeName().equals(nodeName))
    		return e;
    }
    throw new ItemNotFoundException("No adjacent edge found between " + this + " and " + nodeName);
  }
  
  public String toString() {
		  return name + " with Edges: " + adjacentEdges.toString() + "\n";
	  }
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public Edge getDirectedEdge(String toward){
		if(adjacentEdges.size() == 0)
			return null;
		Iterator<Edge> itr = adjacentEdges.iterator();
		Edge cur;
		while(itr.hasNext()){
			cur = itr.next();
			if (cur.getToward().getName().equals(toward)){
				return cur;
			}
		}	

	return null;
	}
	public Edge getDirectedEdge(Node toward){	
		return getDirectedEdge(toward.getName());
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
		coords.setLat(lat);
	}
	
	public double getLon() {
		return lon;
	}
	
	public void setLon(double lon) {
		this.lon = lon;
		coords.setLon(lon);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void paint(Graphics g, GoogleMap map) {
		Graphics2D g2 = (Graphics2D) g;
		double x = getX(map)-5; double y = getY(map)-5;
		Ellipse2D.Double circle = new Ellipse2D.Double(x,y, 10, 10);
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	        RenderingHints.VALUE_ANTIALIAS_ON);

		System.out.println("painting Node "+ name + " with lat " + lat + " and lon " + lon +" at (" + x + "," + y + ")");
	    g2.setStroke(new BasicStroke(2.0f));
	    g2.setColor(Color.BLACK);
	    g2.draw(circle);

	    g2.setColor(getColor());
	    g2.fill(circle);
	    g2.drawString(name, (int)x,(int)y);
	}

	private Color getColor() {
		if(isSelected())
			return Color.BLUE;
		else
			return Color.GRAY;
	}

	/** Sets the visited to the given visited
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/** Returns the visited for this Walkr
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/** Sets the selected to the given selected
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/** Returns the selected for this Walkr
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/** Sets the distance to the given distance
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/** Returns the distance for this Walkr
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	public ArrayList<Edge> getUnvisitedNeighbors(){
		ArrayList<Edge> toReturn = new ArrayList<Edge>();
		for (Edge e: adjacentEdges){
			if(!e.getToward().isVisited()){
				toReturn.add(e);
			}
		}
		return toReturn;
	}
	
	public double getX(){
		return coords.getX();
	}
	
	public double getY(){
		return coords.getY();
	}
	
	public double getX(GoogleMap map){
		return coords.getX(map);
		
	}
	
	public double getY(GoogleMap map){
		return coords.getY(map);
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getPrevious() {
		return previous;
	}
	
	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public Point getPoint() {
		return new Point((int)getX(),(int)getY());
	}

	/** Sets the coords to the given coords
	 * @param coords the coords to set
	 */
	public void setCoordinates(Coordinate coords) {
		this.coords = coords;
	}

	/** Returns the coords for this Walkr
	 * @return the coords
	 */
	public Coordinate getCoordinates() {
		return coords;
	}

	public Image getImage(String skin) {
		Image img = null;
		String file;
		if(isSelected())
			file = "images/" + skin + "/node_selected.png";
		else
			file = "images/" + skin + "/node_unselected.png";
		try { 
			img = ImageIO.read(new FileInputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

	public int compareTo(Node other) {
		return (int) (this.distance - other.getDistance());
	}
}
