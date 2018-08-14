package com.javatpoint.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbcapplicationContext.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
		// int status = dao.saveEmployee(new Employee(102, "Amit", 35000));
		// Boolean status = dao.saveEmployeeByPreparedStatement(new
		// Employee(108, "Ram", 35000));
		// System.out.println(status);

		List<Employee> list = dao.getAllEmployees();
		for (Employee e : list)
			System.out.println(e);

		List<Employee> list1 = dao.getAllEmployeesRowMapper();

		for (Employee e : list1)
			System.out.println(e);

		/*
		 * int status=dao.updateEmployee(new Employee(102,"Sonoo",15000));
		 * System.out.println(status);
		 */

		/*
		 * Employee e=new Employee(); e.setId(102); int
		 * status=dao.deleteEmployee(e); System.out.println(status);
		 */
	}
}