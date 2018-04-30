package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.MyService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

	public final static String MY_VIEW = "myView";

	@Autowired
	@Qualifier("myService")
	private MyService myService;

	/**
	 * Redirect to getRedirected() method
	 * 
	 * @return
	 */
	@GetMapping("/get")
	public RedirectView get_1() {
		return new RedirectView("/ejercicio/getRedirected");
	}

	@GetMapping("/getRedirected")
	public ModelAndView getRedirected() {
		ModelAndView mav = new ModelAndView(MY_VIEW);

		myService.sayHello();
		mav.addObject("myData", "mensaje");

		return mav;
	}
}
