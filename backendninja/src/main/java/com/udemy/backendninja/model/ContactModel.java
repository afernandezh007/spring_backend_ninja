package com.udemy.backendninja.model;

public class ContactModel {

	private String firstName;

	private int id;

	private String lastName;

	private String telephone;

	private String city;

	public ContactModel() {

	}

	public ContactModel(String firstName, int id, String lastName, String telephone, String city) {
		super();
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.telephone = telephone;
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ContactModel [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", telephone="
				+ telephone + ", city=" + city + "]";
	}
}
