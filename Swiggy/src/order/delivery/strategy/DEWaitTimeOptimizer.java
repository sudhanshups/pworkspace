package order.delivery.strategy;

import java.util.Collections;
import java.util.List;

import swiggy.delivery.comparator.DeliveryTimeComparator;
import swiggy.delivery.component.OrderDEComponent;
import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Order;
import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

public class DEWaitTimeOptimizer extends OrderDeliveryStrategy {

	public DEWaitTimeOptimizer(OrderDEComponent newOrderDEStrategy) {
		super(newOrderDEStrategy);
		orderDE = newOrderDEStrategy;
	}

	@Override
	public void getOrderDERelationship(List<Order> orders, List<DeliveryExecutive> des,
			List<OrderDeliveryExcecutiveRel> relations) {
		System.out.println("Executing DE Wait Time Strategy....");
		Collections.sort(des,DeliveryTimeComparator.instance);
		orderDE.getOrderDERelationship(orders, des, relations);
	}

}
