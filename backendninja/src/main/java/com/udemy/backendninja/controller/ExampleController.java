package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	
	// First way
	@GetMapping("/exampleString")
	//@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model) {
		
		exampleComponent.sayHello();
		
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}

	// Second way
	@GetMapping("/exampleMAV") //short way
	//@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}

	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		
		people.add(new Person("Jon", 23));
		people.add(new Person("Mikel", 30));
		people.add(new Person("Eva", 43));
		people.add(new Person("Peter", 18));
		
		return people;	
	}
	
	
}
