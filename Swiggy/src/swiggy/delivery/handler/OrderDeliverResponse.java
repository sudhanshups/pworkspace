package swiggy.delivery.handler;

import java.util.List;

import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

public class OrderDeliverResponse extends Response{
	public OrderDeliverResponse(List<OrderDeliveryExcecutiveRel> response) {
		super();
		this.response = response;
		this.setName("OrderDelivery");
	}

	public OrderDeliverResponse() {
		super();
		this.setName("OrderDelivery");
	}

	private List<OrderDeliveryExcecutiveRel> response;

	public List<OrderDeliveryExcecutiveRel> getResponse() {
		return response;
	}

	public void setResponse(List<OrderDeliveryExcecutiveRel> response) {
		this.response = response;
	}

}
