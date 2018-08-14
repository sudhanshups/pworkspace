package demo;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Employee implements Serializable 
{
	private Integer empId;
	private String empName;
	private Double empSalary;
	private Date dateOfJoin;
	private boolean isActive;
	
	public Employee()
	{ }
	
	public Employee(int empId, String empName, double empSalary,
								Date dateOfJoin, boolean isActive)
	{
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.dateOfJoin = dateOfJoin;
		this.isActive = isActive;
	}

	public Integer getEmpId() 
	{
		return empId;
	}
	
	public void setEmpId(Integer empId) 
	{
		this.empId = empId;
	}
	
	public String getEmpName() 
	{
		return empName;
	}
	
	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}
	
	public Double getEmpSalary() 
	{
		return empSalary;
	}
	
	public void setEmpSalary(Double empSalary) 
	{
		this.empSalary = empSalary;
	}
	
	public Date getDateOfJoin() 
	{
		return dateOfJoin;
	}
	
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}	
}