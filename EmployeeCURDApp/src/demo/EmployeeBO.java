package demo;

import java.util.List;

public class EmployeeBO
{
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	public void insert(Employee employee) throws DAOException
	{
		employeeDAO.insert(employee);
		//write code to send welcome email to the employee
	}
	
	public void update(Employee employee) throws DAOException
	{
		employeeDAO.update(employee);
	}
	
	public void delete(int empId) throws DAOException
	{
		employeeDAO.delete(empId);
	}
	
	public Employee getEmployee(int empId) throws DAOException
	{
		return employeeDAO.getEmployee(empId);
	}
	
	public List<Employee> getAllEmployees() throws DAOException
	{
		return employeeDAO.getAllEmployees();
	}	
}
