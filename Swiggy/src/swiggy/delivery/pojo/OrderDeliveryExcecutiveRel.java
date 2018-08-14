package swiggy.delivery.pojo;

public class OrderDeliveryExcecutiveRel {
	
	private String orderId;
	private String deId;
	
	public OrderDeliveryExcecutiveRel(String orderId, String deId) {
		super();
		this.orderId = orderId;
		this.deId = deId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDeId() {
		return deId;
	}
	public void setDeId(String deId) {
		this.deId = deId;
	}
}
