package demo;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, 	HttpServletResponse response) 
	throws ServletException, 	IOException 
	{
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) 
	throws ServletException, 	IOException 
	{
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires",0);

		PrintWriter out = response.getWriter();
		String country = request.getParameter("country");
		System.out.println(country+ "");
		String[] states = CountryDB.getStates(country);

		out.print("[");	
		for (int i=0; i<states.length-1;i++) 
		{
			out.print("\"" + states[i] + "\",");
			System.out.println(states[i]);
		}
		out.print("\"" + states[states.length-1] + "\"");			
		out.print("]");
		out.flush();	
	}
}
