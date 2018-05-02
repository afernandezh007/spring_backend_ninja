package com.udemy.backendninja.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactModel.
 */
public class ContactModel {

	/** The first name. */
	private String firstName;

	/** The id. */
	private int id;

	/** The last name. */
	private String lastName;

	/** The telephone. */
	private String telephone;

	/** The city. */
	private String city;

	/**
	 * Instantiates a new contact model.
	 */
	public ContactModel() {

	}

	/**
	 * Instantiates a new contact model.
	 *
	 * @param firstName the first name
	 * @param id the id
	 * @param lastName the last name
	 * @param telephone the telephone
	 * @param city the city
	 */
	public ContactModel(String firstName, int id, String lastName, String telephone, String city) {
		super();
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
		this.telephone = telephone;
		this.city = city;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the telephone.
	 *
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Sets the telephone.
	 *
	 * @param telephone the new telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContactModel [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", telephone="
				+ telephone + ", city=" + city + "]";
	}
}
