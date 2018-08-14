package swiggy.delivery.helper;

import swiggy.delivery.pojo.Location;

public class DeliveryHelper {
	/**
	 * 
	 * @param start
	 * @param end
	 * @return distance in meter.
	 */
	public static double getDistance(Location start, Location end) {
		final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(start.getLattitude() - end.getLattitude());
	    double lonDistance = Math.toRadians(start.getLongitude() - end.getLongitude());
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(end.getLattitude())) * Math.cos(Math.toRadians(start.getLattitude()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);

	    return roundDouble(Math.sqrt(distance));
	}
	
	public static double roundDouble(double d) {
		return Math.round(d);
	}
}
