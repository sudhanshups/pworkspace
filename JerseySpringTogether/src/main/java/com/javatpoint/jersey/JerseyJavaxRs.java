package com.javatpoint.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javatpoint.model.Employee;

@Component
@Path("service")
public class JerseyJavaxRs {

	@Autowired
	Employee emp;
	
	@GET
	@Path("/hi")
	public String hi() {
		return emp.greeting();
	}
}
