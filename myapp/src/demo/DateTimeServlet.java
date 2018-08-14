
package demo;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class DateTimeServlet extends HttpServlet
{
 	protected void processRequest
	(HttpServletRequest request, HttpServletResponse response)
  	throws ServletException, IOException
  	{   response.setContentType("text/html");
 		response.setHeader("Cache-Control","no-store");
	  	response.setHeader("Pragma","no-cache");
	  	response.setDateHeader("Expires",0);

    	
    	PrintWriter out = response.getWriter();
    	out.print(new java.util.Date());
    	out.flush();
  	}
  	protected void doGet
	(HttpServletRequest request, HttpServletResponse response)
  	throws ServletException, IOException
  	{
    	processRequest(request, response);
  	}
  
  	protected void doPost
	(HttpServletRequest request, HttpServletResponse response)
  	throws ServletException, IOException
  	{
    	processRequest(request, response);
  	}
}

