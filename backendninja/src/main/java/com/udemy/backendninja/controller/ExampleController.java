package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	
	// First way
	@GetMapping("/exampleString")
	//@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("name", "Gusi");
		return EXAMPLE_VIEW;
	}

	// Second way
	@GetMapping("/exampleMAV") //short way
	//@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("name", "GusiMAV");
		return mav;
	}

}
