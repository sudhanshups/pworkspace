package swiggy.delivery.pojo;

import org.codehaus.jackson.annotate.JsonProperty;

public class Restaurant {
	
	public Restaurant(double lon, double lat) {
		this.location = new Location(lon, lat);
	}
	
	public Restaurant(Location loc) {
		this.location = loc;
	}
	
	public Restaurant() {}
	
	@JsonProperty("location")
	private Location location;

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

}
