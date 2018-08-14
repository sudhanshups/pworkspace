package com.javatpoint.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping("/service")
public class SpringRest {
	
	@RequestMapping("/hi")  
    public @ResponseBody String sayHello(){
    	return "Hello from spring controller";
    }

}
