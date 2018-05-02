package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

	/** The Constant LOGGER. */
	private static final Log LOGGER = LogFactory.getLog(ContactController.class);

	/** The contact service. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	/**
	 * Cancel.
	 *
	 * @return the string
	 */
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showContacts";
	}

	/**
	 * Redirect contact form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@PreAuthorize("hasRole('ROLE_USER')") //this annotation can be in method or in class even in services
	@GetMapping("/contactForm")
	public String redirectContactForm(@RequestParam(name="id", required = false) int id, Model model) {

		ContactModel contact = new ContactModel();
		if (id != 0) {
			contact = contactService.findContactModelById(id);
		}
		
		model.addAttribute("contactModel", contact);
		return ViewConstant.CONTACT_FORM;
	}

	/**
	 * Adds the contacts.
	 *
	 * @param model the model
	 * @param contactModel the contact model
	 * @return the string
	 */
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
	
	/**
	 * Show contacts.
	 *
	 * @return the model and view
	 */
	@GetMapping("/showContacts")
	public ModelAndView showContacts() {

		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		mav.addObject("contacts", contactService.listAllContacts());
		mav.addObject("userName", user.getUsername());
		return mav;
	}
	
	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/removeContact")
	public ModelAndView removeContact(@RequestParam(name="id", required = true) int id) {

		contactService.removeContact(id);
		return showContacts();
	}
}
