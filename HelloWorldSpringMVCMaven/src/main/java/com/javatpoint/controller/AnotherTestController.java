package com.javatpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Employee;

/**
 * 
 * @author hassan
 * If we write @requestMapping at controller level then we have to construct the rest call accordingly
 * in this case :  http://localhost:8080/SpringMVC/myrest/sayhello
 */
@RestController
@RequestMapping("/myrest")
public class AnotherTestController {
	
	@RequestMapping("/sayhello")  
    public String sayHello(){
    	return "Hello Heyy from another test controller!!";
    }
	
	/*
	 * Returns json object because we have already included the jackson dependency in pom
	 */
	@GetMapping("/emplist")
     public List<Employee> getEmp() {
    	List<Employee> emps = new ArrayList<>();
    	Employee e1 = new Employee("Shadab", 5);
    	Employee e2 = new Employee("Sud", 29);
    	emps.add(e1);
    	emps.add(e2);
    	return emps;
    }
    

}
