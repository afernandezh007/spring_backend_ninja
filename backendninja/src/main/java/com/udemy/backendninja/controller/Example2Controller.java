package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	public static final String EXAMPLE2_VIEW = "example2";

	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "null") String name) {

		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model", name);

		return mav;
	}
	
	/**
	 * Using PathVariable the default value doesn't exist. The only way to solve this it's overloading the method
	 * without params to manage this situation
	 * @param name
	 * @return
	 */
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable(name = "nm") String name) {

		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model", name);

		return mav;
	}
	
	/**
	 * Overloaded version to manage a request without params
	 * @return
	 */
	@GetMapping("/request2")
	public ModelAndView request2() {

		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		return mav;
	}
}
