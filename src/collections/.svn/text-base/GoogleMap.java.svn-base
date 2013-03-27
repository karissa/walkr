package collections;

public class GoogleMap {
	
	private double centerLat;
	private double centerLon;
	private int width;
	private int height;
	
	private double pixelsPerDegree;
	private double pixelsPerRadian;
	
	public GoogleMap(double centerLat, double centerLon, int zoom, int width, int height)
	{
		this.centerLat = centerLat;
		this.centerLon = centerLon;
		this.width = width;
		this.height = height;

		double realWidth = 256.00 * Math.pow(2, zoom);

		pixelsPerDegree = realWidth / 360.00;
		pixelsPerRadian = realWidth / (2.00 * Math.PI);
	}
	
	private double atanh(double rad)
	{
		return Math.log((1 + rad) / (1 - rad)) / 2;
	}
	
	public int longitudeToX(double lon)
	{
		return (int)Math.floor((lon - centerLon) * pixelsPerDegree) + (width / 2);		
	}
	
	public int latitudeToY(double lat)
	{
		double centerY = atanh(Math.sin(Math.toRadians(centerLat))) * pixelsPerRadian;
		double localAtanh = atanh(Math.sin(Math.toRadians(lat)));
		return (int)Math.floor(centerY - (localAtanh * pixelsPerRadian)) + (height / 2);
	}
	
	public static void main(String[] args)
	{
		double lat = 40.702147;
		double lon = -73.9986;
		GoogleMap map = new GoogleMap(lat, lon, 2, 256, 256);
		
		System.out.println("X: " + map.longitudeToX(lon));
		System.out.println("Y: " + map.latitudeToY(lat + 1));
		
	}

}