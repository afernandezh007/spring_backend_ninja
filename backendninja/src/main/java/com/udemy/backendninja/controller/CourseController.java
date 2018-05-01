package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSE_VIEW = "courses";

	private static final Log LOGGER = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listCourses")
	public ModelAndView listAllCourses() {

		LOGGER.info("Call: listAllCourses()");

		ModelAndView mav = new ModelAndView(COURSE_VIEW);
		
		mav.addObject("course",new Course());//empty object to use in the form
		
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}

	/**
	 * Insert and redirect to list
	 * @return
	 */
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Course course) {

		LOGGER.info("Call: addCourse() -- PARAM:" + course);

		courseService.addCourse(course);
		return "redirect:/courses/listCourses";
	}
}
