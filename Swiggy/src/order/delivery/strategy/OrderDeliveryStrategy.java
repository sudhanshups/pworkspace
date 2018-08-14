package order.delivery.strategy;

import swiggy.delivery.component.OrderDEComponent;

public abstract class OrderDeliveryStrategy extends OrderDEComponent {
	
	public OrderDEComponent orderDE;
	
	OrderDeliveryStrategy(OrderDEComponent newOrderDEStrategy){
		this.orderDE = newOrderDEStrategy;
	}


}
