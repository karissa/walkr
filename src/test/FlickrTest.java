package test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import flickr.Flickr;
import flickr.Photo;
import graph.Graph;

public class FlickrTest {
	
	private Photo p;
	private String tags;
	private Flickr flickr;
	
	@Before
	public void setUp() throws Exception {
		flickr = new Flickr(new Graph());
		p = new Photo();
		tags = "c343fall2010 nodeWH";
	}

	@Test
	public void testProcessPhotos() {
		flickr.processTags(p, tags);
		assertTrue(p.isNode());
		assertEquals("WH", p.getNodeName());
		flickr.processTags(p, "c343fall2010 fromWH towardBH");
		assertFalse(p.isNode());
		assertEquals("WH",p.getFrom());
		assertEquals("BH", p .getToward());
		flickr.processTags(p, "c343fall2010 towardWH fromBH");
		assertFalse(p.isNode());
		assertEquals("BH",p.getFrom());
		assertEquals("WH", p .getToward());
	}
	
	@Test
	public void testFlickrSearch() {
		flickr.findPhotosByTag("c343_fall2010");
		ArrayList<Photo> photos = flickr.getGeoPhotos();
		assertTrue(photos.size() > 0);
		
	}

}
