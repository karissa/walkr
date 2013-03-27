package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import collections.GoogleMap;

import flickr.Photo;

/**
 * @author krmckelv, Karissa McKelvey
 * @author fmackey, Frank Mackey
 * @author ppitzer, Phil Pitzer
 */

public class Edge implements Comparable<Edge>{

	private final Node from, toward;
	private PriorityQueue<Photo> photos = new PriorityQueue<Photo>(1, new Comparator<Photo>() {

		@Override
		public int compare(Photo o1, Photo o2) {
			if(o1.getCoordinates().getRange(from.getCoordinates()) < o2.getCoordinates().getRange(from.getCoordinates()))
				return -1;
			else
				return 1;
		}});
	private double length;
	
	public Edge(Node start, Node end) {
		this.from = start;
		this.toward = end;
		calculateLength();
	}


	public Edge(Node start, Node end, ArrayList<Photo> arrayPhotos) {
		this(start, end);
		buildEdgePhotos(arrayPhotos);
	}

	
	private void buildEdgePhotos(ArrayList<Photo> arrayPhotos) {
		this.photos = new PriorityQueue<Photo>();
		photos.addAll(arrayPhotos);
	}
	
	public PriorityQueue<Photo> getPhotos() {
		return photos;
	}
	
	
	public void sortPhotos() {
		//sort photos by distance to start, with least distance first
	}

	public Node getFrom() {
		return from;
	}
	
	public Node getToward() {
		return toward;
	}

	public void calculateLength() {
		this.length = from.distanceFrom(toward);
	}

	public double getLength() {
		return length;
	}
	
	public void addItem(Photo p){
		photos.add(p);
	}
	
	public String toString() {
		return from.getName() + " " + toward.getName();
	}
	
	public Color getColor() {
		return new Color(255,255,255,125);
	}
	
	public void paint(Graphics g, GoogleMap map) {
		Graphics2D g2 = (Graphics2D) g;
		Point pf = from.getPoint(map);
		Point pt = toward.getPoint(map);
		pt.move((int)pt.getX()+7,(int)pt.getY()+7);
		pf.move((int)pf.getX()+7,(int)pf.getY()+7);
		Line2D.Double line = new Line2D.Double(pf, pt);
		g2.setColor(getColor());
		g2.setStroke(new BasicStroke(11.0f, BasicStroke.CAP_ROUND,
		          BasicStroke.JOIN_ROUND)); 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		        	        RenderingHints.VALUE_ANTIALIAS_ON);
		g2.draw(line);
		
		g2.setColor(Color.black); // Now use black
	    g2.setStroke(new BasicStroke(3.0f, 
	    		BasicStroke.CAP_BUTT,
	    		BasicStroke.JOIN_BEVEL, 1.0f,
	    		new float[] { 8.0f, 3.0f, 2.0f, 3.0f },
	    	      	0.0f)); 
	    g2.draw(line); // And draw the shape again.

	}


	@Override
	public int compareTo(Edge other) {
		return (int) (this.length - other.getLength());
	}

}
