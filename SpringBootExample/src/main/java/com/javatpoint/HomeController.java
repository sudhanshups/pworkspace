package com.javatpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	@RequestMapping(value = {"/hello","GET"}) 
	public @ResponseBody String hello() {
		return "Hello World !";
	}
}