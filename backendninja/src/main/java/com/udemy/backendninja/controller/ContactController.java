package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private static final Log LOGGER = LogFactory.getLog(ContactController.class);

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showContacts";
	}

	@GetMapping("/contactForm")
	public String redirectContactForm(Model model) {

		model.addAttribute("contactModel", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("/addContact")
	public String addContacts(Model model, @ModelAttribute(name = "contactModel") ContactModel contactModel) {

		LOGGER.info("Method: addContact() -- PARAMS: contactModel=" + contactModel);

		if(contactService.addContact(contactModel) != null) {
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/contacts/showContacts";
	}
	
	@GetMapping("/showContacts")
	public ModelAndView showContacts() {

		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
}
