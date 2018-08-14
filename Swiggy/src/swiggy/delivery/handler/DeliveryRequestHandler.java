package swiggy.delivery.handler;

import java.util.List;

import swiggy.delivery.manager.DeliveryManager;
import swiggy.delivery.pojo.DeliveryExecutive;
import swiggy.delivery.pojo.Order;
import swiggy.delivery.pojo.OrderDeliveryExcecutiveRel;

/**
 * @author ngoya2
 *	Handler for Delivery Requests
 */
public class DeliveryRequestHandler implements RequestHandler{
	
	//TODO: Inject validator to make sure correct order and de is taken in application and log error for rest.
	// Don't allow future dates to pass in request
	// Don't allow invalid location coordinate order or DE to pass
	// Don't allow orders with empty fields like orderId. 
	// Area of Order and DE shall be within limits.

	@Override
	public Response processRequest(Request req) {
		if(null == req) {
			System.out.println("NULL Request");
			return null;
		}
		OrderDeliverResponse res = new OrderDeliverResponse();
		if(req instanceof OrderDeliveryRequest) {
			OrderDeliveryRequest orderDeliveryRequest = (OrderDeliveryRequest) req;
			List<Order> orderList = orderDeliveryRequest.getOrderList();
			List<DeliveryExecutive> deList = orderDeliveryRequest.getDeList();
			if(orderList.size()==0 || deList.size() ==0 ) {
				System.out.println("Invalid Request: No orders/de available.");
				return null;
			}
			
			List<OrderDeliveryExcecutiveRel> odRelations = new DeliveryManager().getOrderDERelationship(orderList, deList);
			res.setResponse(odRelations);
		}else {
			System.out.println("Invalid Request");
			return null;
		}
		return res;
	}
	
}
