package com.udemy.backendninja.component;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {

	/**
	 * Convert model to entity.
	 *
	 * @param model the model
	 * @return the contact
	 */
	public Contact convertModelToEntity(ContactModel model) {
		Contact entity = new Contact();

		entity.setId(model.getId());
		entity.setCity(model.getCity());
		entity.setFirstName(model.getFirstName());
		entity.setLastName(model.getLastName());
		entity.setTelephone(model.getTelephone());

		return entity;
	}

	/**
	 * Convert entity to model.
	 *
	 * @param entity the entity
	 * @return the contact model
	 */
	public ContactModel convertEntityToModel(Contact entity) {
		ContactModel model = new ContactModel();

		model.setId(entity.getId());
		model.setCity(entity.getCity());
		model.setFirstName(entity.getFirstName());
		model.setLastName(entity.getLastName());
		model.setTelephone(entity.getTelephone());

		return model;
	}
}
