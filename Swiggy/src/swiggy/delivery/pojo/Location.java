package swiggy.delivery.pojo;

import org.codehaus.jackson.annotate.JsonProperty;

import swiggy.delivery.helper.DeliveryHelper;

public final class Location {
	
	public Location(double lon, double lat) {
		this.lon = lon;
		this.lat = lat;
	}
	
	public Location(){};
	
	/**
	 * immutable longitude
	 */
	@JsonProperty("lon")
	private double lon;
	/**
	 * immutable longitude
	 */
	@JsonProperty("lat")
	private double lat;
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return lon;
	}
	
	public void setLongitude(double lon) {
		this.lon = lon;
	}
	/**
	 * @return the lattitude
	 */
	public double getLattitude() {
		return lat;
	}
	
	public void setLattitude(double lat) {
		this.lat = lat;
	}
	
	public double separatedBy(Location otherLoc) {
		return DeliveryHelper.getDistance(this, otherLoc);
	}
}
