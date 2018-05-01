package com.udemy.backendninja.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		
		Contact contact = contactConverter.convertModelToEntity(contactModel);
		
		contact = contactRepository.save(contact);
		
		return contactConverter.convertEntityToModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contactList = contactRepository.findAll();

		List<ContactModel> contacts = contactList.stream()
				.map(contact -> contactConverter.convertEntityToModel(contact))
				.collect(Collectors.toList());
		
		return contacts;
		
	}

}
