package com.javatpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.Emp;
import com.javatpoint.dao.EmployeeDao;

@Controller
@RequestMapping("/spring")
public class EmpController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/hello")  
    public @ResponseBody  String helloWorld() {  
        String message = "Hello World";  
        return message;
    }  
	
	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<Emp> list = employeeDao.getAllEmployees();
		return new ModelAndView("viewemp", "list", list);
	}
}
