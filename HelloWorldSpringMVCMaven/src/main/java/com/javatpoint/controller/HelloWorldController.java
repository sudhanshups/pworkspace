package com.javatpoint.controller;  

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.model.Employee;

@Controller  
public class HelloWorldController {  
    @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
        String message = "Hello World";  
        return new ModelAndView("hellopage", "message", message);  
    }  
    
    
    @RequestMapping("/test")  
    public String sayTest(ModelMap model){
    	model.addAttribute("message", "Hello Spring MVC Framework!!");//This attribute can be used in the view test.jsp
    	return "test";
    }
    
    @RequestMapping("/myform")  
    public String myform(){
    	return "myform";
    }
    
    // @RequestParam from previous request
    //Have to check if httpservlet request parameter can be set parameter in explicit way and can be accessed
    
    @RequestMapping("/form")  
    public @ResponseBody  String form(@RequestParam("name") String name, @RequestParam(required=false, defaultValue="lol", name="roll") String roll){
    	return "name is " + name + " roll is "+ roll;
    }
    
    
    //if we don't specify the response body the view resolver tries to find the corresponding view
    @RequestMapping("/sayhello")  
    public @ResponseBody String sayHello(){
    	return "Hello Heyy!!";
    }
    
    @RequestMapping("/cube/{id}")  
    public @ResponseBody String cube(@PathVariable int id){
    	int x = id;
    	return "Cube of the number is " + (x*x*x);
    }
    
    @RequestMapping("/power/{a}/{b}")  
    public @ResponseBody String power(@PathVariable int a, @PathVariable int b){
    	return "Cube of the number is " + (Math.pow(a, b));
    }
    
    @RequestMapping("{a}/add/{b}")  
    public @ResponseBody String add(@PathVariable int a, @PathVariable int b){
    	return "Addition of the number is " + (a+b);
    }
    
    // GET /pets/42;q=11;r=22
    //http://localhost:8080/SpringMVC/pets/42;q=11
    @GetMapping("/pets/{petId}")
    public @ResponseBody String findPet(@PathVariable String petId, @MatrixVariable int q) {

        // petId == 42
        // q == 11
        return "Found pet: " + petId + " And mmatrix param:  " + q;
    }
    
 // GET /owners/42;q=11/pets/21;q=22
    //http://localhost:8080/SpringMVC/owners/42;q=11/pets/21;q=22
    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public @ResponseBody String  findPet2(
            @MatrixVariable(name="q", pathVar="ownerId") int q1,
            @MatrixVariable(name="q", pathVar="petId") int q2) {

    	return "Matrix param first: " + q1 + " And mmatrix param second:  " + q2;

    }
    
    //A matrix variable may be defined as optional and a default value specified
    @GetMapping("/peepa/{petId}")
    public @ResponseBody String findPet3(@MatrixVariable(required=false, defaultValue="1") int q) {

        // petId == 42
        // q == 11
        return "Matrix default param:  " + q;
    }
    
    //All matrix variables may be obtained in a Map:
 // GET /owners/42;q=11;r=12/pets/21;q=22;s=23

    @GetMapping("/ownerss/{ownerId}/petss/{petId}")
    public @ResponseBody String findPet4(
            @MatrixVariable MultiValueMap<String, String> matrixVars, @MatrixVariable(pathVar="petId") MultiValueMap<String, String> petMatrixVars)
    {
        // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
        // petMatrixVars: ["q" : 11, "s" : 23]
        return "map\n" + matrixVars + "\n" + petMatrixVars;
    }
    
    // Producible Media Types
    //this will return object in json format
    //for this added dependency for json object
    //Similar to produces below we can have consumes that will take the corresponding media type as input
    @GetMapping(path = "/name/{nameId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Employee> getPet(@PathVariable String nameId, Model model) {
        // implementation omitted
    	List<Employee> emps = new ArrayList<>();
    	Employee e1 = new Employee("Shadab", 5);
    	Employee e2 = new Employee("Sud", 29);
    	emps.add(e1);
    	emps.add(e2);
    	return emps;
    }
    
    //
    @RequestMapping("/handle")  
    public @ResponseBody String handle(HttpServletRequest request, HttpServletResponse response) {  
    	
    	String name = request.getParameter("name");
    	String surname = (String) request.getSession().getAttribute("surname"); 
    	//respone object can be used to set cookie variable
    	
        return "hey " + name + " " + surname ; 
    }  
    
}  