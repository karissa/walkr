package flickr;

import graph.Coordinate;

/**
 * Photo is a class that contains the structure and organization of Photos.
 * Each photo has, most importantly, a title and imageID. A URL for this photo
 * may be constucted using the farm, server ID, and secret code.
 * 
 * @author krmckelv, Karissa McKelvey
 * @author fmackey, Frank Mackey
 * @author ppitzer, Phil Pitzer
 */

//TODO: We may want to create some type of method for this class that creates and 
//TODO: returns a URL object from a given XML string.

public class Photo implements Comparable<Photo> {

	private static String API_KEY = "e7027a5e1ea23330d7d79603cf366e35";
	private String farmID, serverID, secret, size, latitude, longitude, 
		original_format = "jpg", from, toward, title, imageID, nodeName;
	private Coordinate coords = new Coordinate();
	
	public String toString() {
		if(title != null && !title.equals(""))
			return title;
		else
			return "Untitled";
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.nodeName = null;
		this.from = from;
	}

	public void setToward(String to) {
		this.nodeName = null;
		this.toward = to;
	}
	
	public String getToward() {
		return toward;
	}
	
	public boolean isNode() {
		return toward == null && from == null;
	}
	/**
	 * A photo's node name is either the nodeName (i.e., "WH")
	 * or a concatenation of its from and toward (i.e., "WH BH")
	 * @return
	 */
	public String getNodeName() {
		if(nodeName == null)
			return from + " " + toward;
		return nodeName;
	}
	
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	
	public void setOriginalFormat(String original_format) {
		this.original_format = original_format;
	}

	/**
	 * Constructs a Photo object that holds all of the
	 * necessary meta data needed to access the Photo using HTTP 
	 * @param title the images title to set
	 * @param imageID the images ID to set
	 */
	public Photo(String title, String imageID) {
		this.title= title;
		this.imageID = imageID;
	}//Photo(title,imageID)
	
	
	/**
	 * Overridden hashCode method to ensure that if two Photos
	 * are considered equal then they return the same int.
	 */
	@Override
	public int hashCode() {
		return title.hashCode();
	}
	
	public boolean hasCooordinates() {
		  return (!latitude.equals("0") &&  latitude != null) &&
	  		(longitude != null && !longitude.equals("0"));
	}

	public Coordinate getCoordinates() {
		return coords;
	}
	
	public double getRange(double lat2, double lon2){
		double lat1 = Math.toRadians(Double.parseDouble(getLatitude()));
		double lon1 = Math.toRadians(Double.parseDouble(getLongitude()));
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);
		
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		
		double a = Math.pow(Math.sin(dlat / 2.0), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2.0), 2);
		double c = 2.0 * Math.asin(Math.min(1, Math.sqrt(a)));
		
		return 3956.0 * c;
	}
	/**
	 * Constructs a Photo object that holds all of the
	 * necessary meta data needed to access the Photo using HTTP 
	 * @param imageID the images to set
	 */
	public Photo(String imageID) {
		this.imageID = imageID;
	}//Photo(imageID)
	
	public Photo() {
	}

	/**
	 * Sets the title of this photo
	 * @param title the images title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}//setTitle(title)

	/**
	 * Gets the title of this photo
	 * @return the images title
	 */
	public String getTitle() {
		return title;
	}//getTitle()
	
	/**
	 * Sets the imageID for this photo
	 * @param imageID the images to set
	 */
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}//setImageID(String imageID)
	
	/**
	 * Gets the imageID for this photo
	 * @return the images ID
	 */
	public String getImageID() {
		return imageID;
	}//getImageID()
	
	/**
	 * Sets the API key for all photos that talk to flickr
	 * @param aPI_KEY the api key to set
	 */
	public static void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}//setAPI_KEY(String aPI_KEY)
	
	/** 
	 * Gets the API key for all photos that talk to flickr
	 * @return API_KEY the api key used to access Flickr
	 */
	public static String getAPI_KEY() {
		return API_KEY;
	}//getAPI_KEY()
	
	/**
	 * Sets the secret ID for this photo
	 * @param secret the secret value to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}//getSecret(String secret)

	/**
	 * Gets the secret ID for this photo
	 * @return the secret value
	 */
	public String getSecret() {
		return secret;
	}//getSecret()

	/**
	 * Sets the size of this photo as specified by Flickr
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}//setSize(String size)

	/**Gets the size of this photo
	 * @return the size
	 */
	public String getSize() {
		return size;
	}//getSize()

	/**Sets the Server ID for this photo
	 * @param serverID the serverID to set
	 */
	public void setServerID(String serverID) {
		this.serverID = serverID;
	}//setServerID(String serverID()

	/**Gets the server ID for this photo
	 * @return the serverID
	 */
	public String getServerID() {
		return serverID;
	}//getServerID()

	/**Sets the farmID for this photo
	 * @param farmID the farmID to set
	 */
	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}//setFarmID(String farmID)

	/**Gets the farmID for this photo
	 * @return the farmID
	 */
	public String getFarmID() {
		return farmID;
	}//getFarmID()

	public void setLatitude(String latitude) {
		this.coords.setLat(Double.valueOf(latitude));
	}

	public String getLatitude() {
		return String.valueOf(coords.getLat());
	}

	public void setLongitude(String longitude) {
		this.coords.setLon(Double.valueOf(longitude));
	}

	public String getLongitude() {
		return String.valueOf(coords.getLon());
	}

	public String getOriginalFormat() {
		return original_format;
	}

	public boolean isEdge() {
		return from != null && toward != null;
	}

	@Override
	public int compareTo(Photo arg0) {
		return (int) getCoordinates().getRange(arg0.getCoordinates());
	}
	

}
