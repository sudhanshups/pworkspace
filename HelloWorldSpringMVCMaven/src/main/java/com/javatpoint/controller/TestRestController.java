package com.javatpoint.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.model.Employee;


/*
 * 
 * @RestController is a stereotype annotation that combines @ResponseBody and @Controller.  instead of annotating all your 
 * @RequestMapping methods with @ResponseBody
 * More than that, it gives more meaning  to your Controller and also may carry additional semantics in future
 *  releases of the framework.
 */
@RestController
public class TestRestController {
	
	@RequestMapping("/heyy")  
    public ModelAndView helloWorld() {  
        String message = "Hello World!!";  
        return new ModelAndView("hellopage", "message", message);  
    }  
	
	@RequestMapping("/resthello")  
    public String sayHello(){
    	return "Hello Heyy!!";
    }
	
	/*
	 * @ModelAttribute on a method argument
	 * @ModelAttribute on a method argument indicates the argument should be retrieved from the model. 
	 * If not present in the model, the argument should be instantiated first and then added to the model.
	 * Once present in the model, the argument’s fields should be populated from all request parameters
	 *  that have matching names.
	 * Model clas should have default constructor
	 */
	@RequestMapping("/name/{name}/id/{id}/show")
	public String processSubmit(@ModelAttribute Employee e) { 
		
		return e.toString();
	}

}
