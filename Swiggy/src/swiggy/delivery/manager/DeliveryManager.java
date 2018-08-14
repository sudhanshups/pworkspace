package swiggy.delivery.manager;

import java.util.ArrayList;
import java.util.List;

import order.delivery.strategy.DEWaitTimeOptimizer;
import order.delivery.strategy.FirstMileStrategy;
import order.delivery.strategy.OrderTimeOptimizer;
import swiggy.delivery.component.OrderDEComponent;
import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Order;
import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

/**
 * @author ngoya2
 * Delivery Manager Response for managing all the delivery actions.
 */
public class DeliveryManager {

	public List<OrderDeliveryExcecutiveRel> getOrderDERelationship(List<Order> orderList,
			List<DeliveryExecutive> deList) {
		
		List<OrderDeliveryExcecutiveRel> odrList = new ArrayList<>();
		OrderDEComponent orderDEComp = new OrderTimeOptimizer(new DEWaitTimeOptimizer(new FirstMileStrategy()));
		orderDEComp.getOrderDERelationship(orderList, deList, odrList);
		return odrList;
	}

	
}
