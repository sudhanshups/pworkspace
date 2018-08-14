package swiggy.delivery.pojo;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import swiggy.delivery.helper.JsonDateDeserializer;

public class DeliveryExecutive {
	
	public DeliveryExecutive(String id, Location loc, Date d) {
		this.id= id;
		this.currentLoc = loc;
		this.lastOrderTime = d;
	}
	
	public DeliveryExecutive() {}
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("location")
	private Location currentLoc;
	
	@JsonDeserialize(using=JsonDateDeserializer.class)
	@JsonProperty("lastOrderTime")
	private Date lastOrderTime;
	public String getId() {
		return id;
	}
	public Location getCurrentLoc() {
		return currentLoc;
	}
	public Date getLastOrderTime() {
		return (Date)this.lastOrderTime.clone();
	}
}
