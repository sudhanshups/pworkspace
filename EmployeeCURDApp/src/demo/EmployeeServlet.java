package demo;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	EmployeeBO employeeBO = new EmployeeBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nextView = null;
		boolean redirect = false;
		
		String action = request.getParameter("action");
		
		if(action == null)
			action = "";
		
		switch (action)
		{
		case "Add":
			Employee employee = new Employee();
			request.setAttribute("employee", employee);
			nextView = "/employeeForm.jsp";
			redirect = false;
			break;
		case "Edit":
			int empId = Integer.parseInt(request.getParameter("empId"));
			employee = employeeBO.getEmployee(empId);
			request.setAttribute("employee", employee);
			nextView = "/employeeForm.jsp";
			redirect = false;
			break;
		case "Save":
			String strEmpId = request.getParameter("empId");
			
			if(strEmpId != null && strEmpId.trim().length() != 0)
				empId = Integer.parseInt(strEmpId);
			else
				empId = -1;
			
			String empName = request.getParameter("empName");
			double empSalary = Double.parseDouble(request.getParameter("empSalary"));
			Date dateOfJoin = Date.valueOf(request.getParameter("dateOfJoin"));
			boolean active = request.getParameter("active") != null;
			
			employee = new Employee(empId, empName, empSalary, dateOfJoin, active);
			
			if(strEmpId != null && strEmpId.trim().length() != 0)
				employeeBO.update(employee);
			else
				employeeBO.insert(employee);
			
			nextView = "EmployeeServlet";
			redirect = true;
			break;
		case "Delete":
			empId = Integer.parseInt(request.getParameter("empId"));
			employeeBO.delete(empId);
			nextView = "EmployeeServlet";
			redirect = true;
			break;
		default:
			List<Employee> employees = employeeBO.getAllEmployees();
			request.setAttribute("employees", employees);
			nextView = "/employees.jsp";
			redirect = false;
			break;
		}
		
		if(redirect)
		{
			response.sendRedirect(nextView);
		}
		else
		{
			ServletContext application = getServletContext();
			RequestDispatcher dispatcher = application.getRequestDispatcher(nextView);
			dispatcher.forward(request, response);
		}
	}
}
