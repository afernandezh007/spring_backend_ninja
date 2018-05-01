package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.UserCredential;

@Controller
public class LoginController {

	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		
		LOGGER.info("Method: redirectToLogin()");
		
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		LOGGER.info("Method: showLoginForm() -- PARAMS: error= " + error + ", logout= " + logout);
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredential());

		LOGGER.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential) {

		LOGGER.info("Method: loginCheck() -- PARAMS: userCredential= " + userCredential);
		
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			LOGGER.info("Returning to contacts view");
			return "redirect:/contacts/showContacts";
		}
		LOGGER.info("Redirect to login?error");
		return "redirect:/login?error";
	}
}
