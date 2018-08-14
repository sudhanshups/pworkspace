package swiggy.delivery.handler;

/**
 * @author ngoya2
 *	Request Handler for handling all requests in application.
 */
public interface RequestHandler {
	Response processRequest(Request req);
}
