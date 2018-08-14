package order.delivery.strategy;

import java.util.Collections;
import java.util.List;

import swiggy.delivery.comparator.OrderTimeComparator;
import swiggy.delivery.component.OrderDEComponent;
import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Order;
import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

public class OrderTimeOptimizer extends OrderDeliveryStrategy {

	public OrderTimeOptimizer(OrderDEComponent newOrderDEStrategy) {
		super(newOrderDEStrategy);
		orderDE = newOrderDEStrategy;
	}

	@Override
	public void getOrderDERelationship(List<Order> orders, List<DeliveryExecutive> des,
			List<OrderDeliveryExcecutiveRel> relations) {
		System.out.println("Executing OrderTimeOptimizer Strategy");
		Collections.sort(orders,OrderTimeComparator.instance);
		orderDE.getOrderDERelationship(orders, des, relations);
	}


}
