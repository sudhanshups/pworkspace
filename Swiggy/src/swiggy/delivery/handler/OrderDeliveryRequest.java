package swiggy.delivery.handler;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Order;

public class OrderDeliveryRequest extends Request {
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public List<DeliveryExecutive> getDeList() {
		return deList;
	}
	public void setDeList(List<DeliveryExecutive> deList) {
		this.deList = deList;
	}
	public OrderDeliveryRequest(List<Order> orderList, List<DeliveryExecutive> deList) {
		super();
		this.orderList = orderList;
		this.deList = deList;
		this.setName("OrderDelivery");
	}
	
	public OrderDeliveryRequest() {}
	
	@JsonProperty("orders")
	List<Order> orderList;
	@JsonProperty("des")
	List<DeliveryExecutive> deList;
}
