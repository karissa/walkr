package flickr;

import java.util.Comparator;

public class PhotoDistanceComparator implements Comparator<Photo>{
	
	private double baseLat;
	private double baseLon;
	
	public PhotoDistanceComparator(String lat, String lon) {
		baseLat = Double.parseDouble(lat);
		baseLon = Double.parseDouble(lon);
	}
		
	public int compare(Photo p1, Photo p2){
		return (int)Math.signum(p1.getRange(baseLat, baseLon) - p2.getRange(baseLat, baseLon));
	}

}