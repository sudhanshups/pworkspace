package com.javatpoint;  
import org.springframework.jdbc.core.JdbcTemplate;  
  
public class EmployeeDao {  
private JdbcTemplate jdbcTemplate;  
  
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}  
  
public int saveEmployee(Employee e){  
    String query="insert into testdb..employee values('"+e.getName()+"','"+e.getSalary()+"', 'eng')";
    System.out.println(query);
    return jdbcTemplate.update(query);
}  
public int updateEmployee(Employee e){  
    String query="update testdb..employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";  
    System.out.println(query);
    return jdbcTemplate.update(query);  
}  
public int deleteEmployee(Employee e){  
    String query="delete from testdb..employee where id='"+e.getId()+"' ";  
    System.out.println(query);
    return jdbcTemplate.update(query);  
}  
  
}  