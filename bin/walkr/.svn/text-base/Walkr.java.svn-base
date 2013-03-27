package walkr;

import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import collections.GoogleMap;

import exceptions.ItemNotFoundException;

import graph.Edge;
import graph.Graph;
import graph.Node;
import graph.Path;

/**
 * @author krmckelv, Karissa McKelvey
 * @author fmackey, Frank Mackey
 * @author ppitzer, Phil Pitzer
 */
public class Walkr {

	private Graph g;
	private Path shortestPath;
	private GoogleMap map;
	private HashMap<Node, Node> predecessors;
	PriorityQueue<Node> unsettledNodes;
	
	public Walkr(Graph g) {
		this.g = g;
	}
	

	public Path findShortestPath(Node from, Node toward) throws ItemNotFoundException {
		if(from == null || toward == null)
			throw new ItemNotFoundException("No node found.");
		System.out.println("Finding shortest path between " + from + " and " + toward);
		Edge whenAdjacent = from.getDirectedEdge(toward);
		if(whenAdjacent != null) {
			shortestPath = new Path();
			shortestPath.addEdge(whenAdjacent);
			shortestPath.setMap(map);
			return shortestPath;
		}
		reset();
		
		unsettledNodes = new PriorityQueue<Node>();
		predecessors = new HashMap<Node,Node>();
		from.setDistance(0);
		unsettledNodes.add(from);
		
		while(!unsettledNodes.isEmpty()) {
			Node node = unsettledNodes.remove(); // removes the Node with the smallest distance(PriorityQueue structure)
				unsettledNodes.remove(node);
				System.out.println("minimum of unsettledNodes is " + node);
				updateDistances(node);
		}
		shortestPath =  new Path(getPath(toward));
		System.out.println(shortestPath);
		shortestPath.setMap(map);
		return shortestPath;
	}
	
	public LinkedList<Node> getPath(Node target) throws ItemNotFoundException {
		LinkedList<Node> path = new LinkedList<Node>();
		Node step = target;
		// Check if a path exists
		if (predecessors.get(step) == null) {
			throw new ItemNotFoundException("no path found");
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.addFirst(step); //make sure to add to the front because we are working our way backwards
		}
		return path;
	}
	
	private void updateDistances(Node node) {
		Iterator<Edge> it = node.getAdjacentEdges().iterator();
		
		Edge currentEdge;
		Node target = null;
		
		while(it.hasNext()) {
			currentEdge = it.next();
			target = currentEdge.getToward();	
			double tentativeDistance = node.getDistance() + node.getDirectedEdge(target).getLength();
			System.out.println("Checking if " + target.getDistance() + " > " + tentativeDistance);
			if (target.getDistance() > tentativeDistance) {
				target.setDistance(tentativeDistance);
				predecessors.put(target, node);
				if (!unsettledNodes.contains(target))
					unsettledNodes.add(target);
				System.out.println("setting distance of node "+ target + " to " + tentativeDistance);
			}
		}
		return;
	}
	
	public void setMap(GoogleMap map) {
		this.map = map;
	}
	
	public Path findShortestPath(String from, String toward) throws ItemNotFoundException {
		Node start = g.getNode(from.toUpperCase());
		Node end = g.getNode(toward.toUpperCase());
		return findShortestPath(start, end);
	}

	public Path findShortestPath(Point from, Point toward) throws ItemNotFoundException {
		Node start = g.getNode(from);
		Node end = g.getNode(toward);
		return findShortestPath(start, end);
	}
	
	public Graph getGraph() {
		return g;
	}
	
	public void setGraph(Graph g) {
		this.g = g;
	}
	
	public boolean hasPath() {
		return shortestPath != null && !shortestPath.isEmpty();
	}
	
	public Path getPath() {
		return shortestPath;
	}
	
	public void reset(){
		Iterator<Node> itr = g.iterator();
		Node cur;
		while(itr.hasNext()){
			cur = itr.next();
			cur.setDistance(Double.POSITIVE_INFINITY);
			cur.setVisited(false);
			cur.setPrevious(null);
		}
	}
	
	public GoogleMap getMap() {
		return map;
	}
	
}
