package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO 
{
	private static final String INSERT = "INSERT INTO Employeesud VALUES(?,?,?,?)";
	
	private static final String UPDATE = 
			"UPDATE Employeesud SET " + 
			"EmpName = ?, EmpSalary = ?, DateOfJoin = ? , IsActive = ? WHERE EmpId = ?";
	
	private static final String DELETE = "DELETE FROM Employeesud WHERE EmpId = ?";
	
	private static final String GetEmployee = 
			"Select EmpId, EmpName, EmpSalary, DateOfJoin, IsActive FROM Employeesud WHERE EmpId = ?";

	private static final String GetAllEmployees = 
			"Select EmpId, EmpName, EmpSalary, DateOfJoin, IsActive FROM Employeesud";
	
	public void insert(Employee employee) throws DAOException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(INSERT);
			DBUtil.fillStatement(ps, employee.getEmpName(),employee.getEmpSalary(), 
									 employee.getDateOfJoin(), employee.isActive());
		
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			throw new DAOException(e.getMessage());
		}	
		finally{
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}

	public void update(Employee employee) throws DAOException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(UPDATE);
			DBUtil.fillStatement(ps, employee.getEmpName(),employee.getEmpSalary(), 
									 employee.getDateOfJoin(), employee.isActive(),
									 employee.getEmpId());
		
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			throw new DAOException(e.getMessage());
		}	
		finally{
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}

	public void delete(int empId) throws DAOException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(DELETE);
			DBUtil.fillStatement(ps, empId);
		
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			throw new DAOException(e.getMessage());
		}	
		finally{
			DBUtil.close(ps);
			DBUtil.close(conn);
		}	
	}

	public Employee getEmployee(int empId) throws DAOException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		Employee employee = null;

		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(GetEmployee);
			DBUtil.fillStatement(ps, empId);
			ResultSet rs = ps.executeQuery();			
			if(rs.next())			
			{
				employee = new Employee
							(empId, rs.getString("EmpName"),rs.getDouble("EmpSalary"),
									rs.getDate("DateOfJoin"),rs.getBoolean("IsActive"));
			}			
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}	
		finally{
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		return employee;
	}

	public List<Employee> getAllEmployees() throws DAOException 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<>();

		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(GetAllEmployees);			
			rs = ps.executeQuery();
			while(rs.next())
			{
				Employee employee = 
					new Employee(rs.getInt("EmpId"), rs.getString("EmpName"),
								rs.getDouble("EmpSalary"), rs.getDate("DateOfJoin"),
								rs.getBoolean("IsActive"));
			
				employees.add(employee);
			}			
		}
		catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}	
		finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		return employees;
	}
}