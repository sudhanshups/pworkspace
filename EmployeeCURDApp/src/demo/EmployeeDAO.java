
package demo;

import java.util.List;

public interface EmployeeDAO 
{
	public void insert(Employee employee) throws DAOException;
	public void update(Employee employee) throws DAOException;
	public void delete(int empId) throws DAOException;
	
	public Employee getEmployee(int empId) throws DAOException;	
	public List<Employee> getAllEmployees() throws DAOException;
}
