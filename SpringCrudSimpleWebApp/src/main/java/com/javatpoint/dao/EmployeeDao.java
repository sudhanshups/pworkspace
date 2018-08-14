package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.beans.Emp;

public class EmployeeDao {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void sayHello() {
		System.out.println("Hello from  dao class....................................................");
	}

	public int saveEmployee(Emp e) {
		String query = "insert into testdb..employee values('" + e.getName() + "','" + e.getSalary() + "','"
				+ e.getDesignation() + "')";
		return template.update(query);
	}

	public Emp getEmpById(int id) {
		String sql = "select * from testdb..employee where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public int update(Emp p) {
		String sql = "update testdb..employee set name='" + p.getName() + "', salary=" + p.getSalary()
				+ ", designation='" + p.getDesignation() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public List<Emp> getAllEmployeesRowMapper() {
		return template.query("select * from testdb..employee", new RowMapper<Emp>() {

			public Emp mapRow(ResultSet rs, int rownumber) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}
}
