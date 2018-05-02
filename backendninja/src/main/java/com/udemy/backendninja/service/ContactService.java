package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ContactService {

	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact model
	 */
	ContactModel addContact(ContactModel contactModel);
	
	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	List<ContactModel> listAllContacts();
	
	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	Contact findContactById(int id);
	
	/**
	 * Find contact model by id.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	ContactModel  findContactModelById(int id);
	
	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	void removeContact(int id);
}
