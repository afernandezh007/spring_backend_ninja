package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	public static final String MY_404 ="404";
	public static final String MY_500 ="500";

	
	@GetMapping("my404")
	public String my404() {
		return MY_404;
	}
	
	@GetMapping("my500")
	public String my500() {
		return MY_500;
	}
}
