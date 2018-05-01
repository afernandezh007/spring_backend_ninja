package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.model.ContactModel;

public interface ContactService {

	ContactModel addContact(ContactModel contactModel);
	
	List<ContactModel> listAllContacts();
}
