
package graph;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

import collections.GoogleMap;

import flickr.Photo;

/**
 * @author krmckelv, Karissa McKelvey
 * @author fmackey, Frank Mackey
 * @author ppitzer, Phil Pitzer
 */

public class Path {

	private LinkedList<Edge> edges = new LinkedList<Edge>();
	private GoogleMap map;

	public Path() {
		
	}
	
	public Path(LinkedList<Node> nodes) {
		buildPath(nodes);
	}

	/** Sets the edges to the given edges
	 * @param edges the edges to set
	 */
	public void setEdges(LinkedList<Edge> edges) {
		this.edges = edges;
	}
	

	public void buildPath(LinkedList<Node> nodes) {
		Node prevNode = nodes.remove(0);
		for(Node node : nodes) {
			edges.add(prevNode.getDirectedEdge(node));
			prevNode = node;
		}
	}

	/** Returns the edges for this Walkr
	 * @return the edges
	 */
	public LinkedList<Edge> getEdges() {
		return edges;
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}

	public ArrayList<Photo> getPhotos() {
		final Node start = edges.get(0).getFrom(); //get the very first start node
		ArrayList<Photo> photos = new ArrayList<Photo>(); //we will sort and then return this list??
		PriorityQueue<Photo> curEdgePhotos = null;//the photos along this edge. Edge photos could probably just be an 
		photos.add(start.getPhoto());
		for(Edge e : edges) { //Arraylist because they don't need to be sorted until now
			curEdgePhotos = e.getPhotos();  
			photos.addAll(curEdgePhotos);//sort and then add these photos to our running list of all photos, which we will return
			photos.add(e.getToward().getPhoto());
		}
		return photos;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		if(map != null)
			paint(g2,map);
	}
	public void paint(Graphics g, GoogleMap map) {
		Graphics2D g2 = (Graphics2D)g;
		System.out.println("painting Path");
		for(Edge e : edges) {
			System.out.println("painting edge " + e);
			e.paint(g2, map);
		}
	}
	public boolean isEmpty() {
		return edges.isEmpty();
	}
	public String toString() {
		return edges.toString();
	}

	public void setMap(GoogleMap map) {
		this.map = map;
	}
	public GoogleMap getMap(){
		return this.map;
	}

	public Node getStart() {
		if(edges.size() > 0)
			return edges.get(0).getFrom();
		else 
			return null;
	}

	public Node getEnd() {
		if(edges.size() > 0)
			return edges.getLast().getToward();
		else 
			return null;
	}
	
}
