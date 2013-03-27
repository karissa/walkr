package test;

import static org.junit.Assert.*;
import graph.Graph;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testGraph() {
		//Graph graph = new Graph();
		//assertTrue(graph != null);
	}

	@Test
	public void testGraphString() {
		Graph graph = new Graph("nodes.json");
		assertTrue(graph != null);
		assertTrue(null != graph.getNode("WH"));
		assertTrue(null != graph.getNode("ED"));
		System.out.println(graph.toString());
	}

}
