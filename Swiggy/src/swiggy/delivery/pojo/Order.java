package swiggy.delivery.pojo;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import swiggy.delivery.helper.JsonDateDeserializer;

/**
 * @author ngoya2
 * Immutable Order class. 
 */
public class Order {
	
	//past time is invalid order
	public Order(double lon, double lat, Date d, String id) {
		this.id = id;
		this.restaurant = new Restaurant(lon, lat);
		this.date = new Date(d.getTime());
	}
	
	public Order(Restaurant res, Date d, String id) {
		this.id = id;
		this.restaurant = res;
		this.date = new Date(d.getTime());
	}
	
	public Order() {}
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("restaurant")
	private Restaurant restaurant;
	@JsonDeserialize(using=JsonDateDeserializer.class)
	@JsonProperty("date")
	private Date date;
	
	
	public Restaurant getRestaurant() {
		return this.restaurant;
	}
	
	public Date getTime() {
		return (Date)this.date.clone();
	}

	public String getId() {
		return id;
	}

}
