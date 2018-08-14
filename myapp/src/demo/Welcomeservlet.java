package demo;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Welcomeservlet
 */
@WebServlet("/Welcomeservlet")
public class Welcomeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("firstservlet init ()");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("firstservlet destroy ()");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String myname=request.getParameter("myname");
		PrintWriter out =response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Welcome Servlet </title>");
		
		
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>");
		out.println("Welcome  " + myname);
		
		
		out.println("Welcome to the servlet world!!");
		out.println("<br>");
		out.println("REQUEST METHOD: "+request.getMethod());
		out.println("<br><br>");
		out.println("Current Server Time <br>" +new java.util.Date());
		
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		
	}

	
}
