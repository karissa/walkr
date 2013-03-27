package test;

import exceptions.ItemNotFoundException;
import flickr.Photo;
import graph.*;
import walkr.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class WalkrTest {
		
		private Photo p;
		private String tags;
		private Graph graph = new Graph("nodes.json");
		private Walkr walkr = new Walkr(graph);
		
		@Test
		public void testShortestPath() throws ItemNotFoundException {
			walkr.findShortestPath("BH", "WH");
			assertTrue(walkr.hasPath());
			assertTrue(walkr.getPath() != null);

			walkr.findShortestPath("RE", "ED");
			walkr.findShortestPath("JH", "WH");
			assertTrue(walkr.hasPath());
			
			walkr.findShortestPath("FF", "BH");
			assertTrue(walkr.hasPath());
			assertTrue(walkr.hasPath());
		}

}
