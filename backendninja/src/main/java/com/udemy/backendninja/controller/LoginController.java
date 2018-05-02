package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.constant.ViewConstant;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The Constant LOGGER. */
	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	/**
	 * Show login form.
	 *
	 * @param model the model
	 * @param error the error
	 * @param logout the logout
	 * @return the string
	 */
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {

		LOGGER.info("Method: showLoginForm() -- PARAMS: error= " + error + ", logout= " + logout);
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);

		LOGGER.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping({"/loginSuccess","/"})
	public String loginCheck() {

		LOGGER.info("Method: loginCheck()");

		LOGGER.info("Returning to contacts view");
		return "redirect:/contacts/showContacts";
	}
}
