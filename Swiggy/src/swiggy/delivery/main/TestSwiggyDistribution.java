package swiggy.delivery.main;

import java.util.List;
import java.util.Scanner;

import swiggy.delivery.handler.DeliveryRequestHandler;
import swiggy.delivery.handler.OrderDeliverResponse;
import swiggy.delivery.handler.OrderDeliveryRequest;
import swiggy.delivery.handler.RequestHandler;
import swiggy.delivery.helper.FileReaderHelper;
import swiggy.delivery.helper.JacksonHelper;
import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Order;
import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

public class TestSwiggyDistribution {

	public static void main(String[] args) {
		//"/Users/sudhanshu.singh/Documents/pworkspace/Swiggy/order.txt"
		String orders = FileReaderHelper.readFile( "/Users/sudhanshu.singh/Documents/pworkspace/Swiggy/order.txt");
		OrderDeliveryRequest req = JacksonHelper.jsonToObject(orders, OrderDeliveryRequest.class);
		
		List<Order> orderList = req.getOrderList();
		List<DeliveryExecutive> deList = req.getDeList();
		
		RequestHandler handler = new DeliveryRequestHandler();
		
		OrderDeliverResponse response = (OrderDeliverResponse) handler.processRequest(new OrderDeliveryRequest(orderList, deList));
		
//		System.out.println(JacksonHelper.objectToJSON(response));
		for(OrderDeliveryExcecutiveRel rel: response.getResponse()) {
			if(null == rel) continue;
			
			if("NULL" == rel.getDeId()) {
				System.out.println("There is NO DE available to serve this "+rel.getOrderId()+". Kindly add more DE. Regret Inconvinience.");
				continue;
			}
			
			System.out.println(rel.getDeId()+" IS SERVING "+rel.getOrderId());
		}
		
		
		for(DeliveryExecutive de: deList) {
			System.out.println(de.getId()+" Is Available for More Orders.");
		}
		
	}

}
