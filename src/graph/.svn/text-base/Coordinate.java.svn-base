package graph;

import java.awt.Point;

import collections.GoogleMap;

public class Coordinate {

	private double lat;
	private double lon;
	private GoogleMap map;
	private int x, y;
	
	public Coordinate(double lat, double lon) {
		this.lat = lat; this.lon = lon;
	}

	public Coordinate(double lat, double lon, GoogleMap map) {
		this.lat = lat; this.lon = lon; setMap(map);
	}
	
	public Coordinate(GoogleMap map) {
		setMap(map);
	}
	
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}

	/** Sets the lat to the given lat
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/** Returns the lat for this Walkr
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	public double getRange(Coordinate c) {
		if(c == null || !c.hasCooordinates())
			return Double.POSITIVE_INFINITY;
		double lat2 = c.getLat();
		double lon2 = c.getLon();
		double lat1 = lat;
		double lon1 = lon;
		return Math.sqrt(Math.pow(lat1 - lat2, 2) + Math.pow(lon1- lon2, 2));
	}
	
	private boolean hasCooordinates() {
		return lat != 0 && lon != 0;
	}

	/** Sets the lon to the given lon
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}
	/** Returns the lon for this Walkr
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/** Sets the map to the given map
	 * @param map the map to set
	 */
	public void setMap(GoogleMap map) {
		this.map = map;
		this.setX(map.longitudeToX(lon));
		this.setY(map.latitudeToY(lat));
	}

	/** Returns the map for this Walkr
	 * @return the map
	 */
	public GoogleMap getMap() {
		return map;
	}

	/** Sets the x to the given x
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/** Returns the x for this Walkr
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/** Sets the y to the given y
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/** Returns the y for this Walkr
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	public int getX(GoogleMap map) {
		return map.longitudeToX(lon);
	}
	
	public int getY(GoogleMap map) {
		return map.latitudeToY(lat);
	}

	public Point getPoint() {
		return new Point(getX(), getY());
	}
	
	
}
