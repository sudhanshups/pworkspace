package com.javatpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.Emp;
import com.javatpoint.dao.EmployeeDao;

@Controller
public class EmpController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(value = "/addemp", method = RequestMethod.GET)
	public ModelAndView save() {
		employeeDao.sayHello();
		List<Emp> empList = employeeDao.getAllEmployeesRowMapper();
		empList.forEach(item -> System.out.println(item.getName()));
		System.out.println("Hello...................");
		return new ModelAndView("addemp", "command", new Emp());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp) {
		System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getDesignation());
		employeeDao.saveEmployee(emp);
		return new ModelAndView("redirect:/addemp");
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(@ModelAttribute("emp") Emp emp) {
		System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getDesignation());
		// employeeDao.saveEmployee(emp);
		return new ModelAndView("redirect:/addemp");
	}

	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		List<Emp> list = employeeDao.getAllEmployeesRowMapper();
		return new ModelAndView("viewemp", "list", list);
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Emp emp = employeeDao.getEmpById(id);
		return new ModelAndView("empeditform", "command", emp);
	}
	
	/* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") Emp emp){  
    	employeeDao.update(emp);  
        return new ModelAndView("redirect:/viewemp");  
    }  
}
