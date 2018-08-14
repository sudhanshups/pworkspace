package order.delivery.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import swiggy.delivery.comparator.OrderDistanceComparator;
import swiggy.delivery.component.OrderDEComponent;
import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Location;
import swiggy.delivery.pojo.Order;
import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

public class FirstMileStrategy extends OrderDEComponent {
	
	
	private static final double MIN_DISTANCE = 100d;//de should serve request.
	private static final double MAX_DISTANCE = 15000d;//oos area

	@Override
	public void getOrderDERelationship(List<Order> orders, List<DeliveryExecutive> des,
			List<OrderDeliveryExcecutiveRel> relations) {
		System.out.println("Executing First Mile Strategy....");
		for(int i=0; i<orders.size(); i++) {
			Order o = orders.get(i);
			Location orderLoc = o.getRestaurant().getLocation();
			List<DeliveryExecutive> deDistances = new ArrayList<DeliveryExecutive>(des);
			Collections.sort(deDistances, new OrderDistanceComparator(orderLoc));
			String orderId = o.getId();
			String deId = "NULL";
			int bestDEIndex = -1;
			double minDistance = Double.MAX_VALUE;
			for(int j=0; j<1+des.size()/2; j++) {
				double distance = o.getRestaurant().getLocation().separatedBy(des.get(j).getCurrentLoc());
				if(distance < MIN_DISTANCE) {
					bestDEIndex = j;
					break;
				}
				if(distance < minDistance  && distance<MAX_DISTANCE) {
					minDistance=distance;
					bestDEIndex = j;
				}
			}
			if(bestDEIndex != -1) {
				deId = des.get(bestDEIndex).getId();
				des.remove(bestDEIndex);
			}
			
			OrderDeliveryExcecutiveRel odRel = new OrderDeliveryExcecutiveRel(orderId, deId);
			relations.add(odRel);
		
		}
	}

}
