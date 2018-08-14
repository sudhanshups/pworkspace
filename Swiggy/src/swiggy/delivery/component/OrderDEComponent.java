package swiggy.delivery.component;

import java.util.List;

import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Order;
import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

public abstract class OrderDEComponent {
	public abstract void getOrderDERelationship(List<Order> orders, List<DeliveryExecutive> des, List<OrderDeliveryExcecutiveRel> relations);
}
