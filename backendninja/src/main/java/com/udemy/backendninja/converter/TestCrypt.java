package com.udemy.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));
		
		/**
		 * INSERT INTO `mydb`.`user` (`enabled`, `password`, `username`) VALUES (1, '$2a$10$qQki9yP1v49tqX7xWRXH6O8k/A1D.5yMKbMwLJG/iXNf3o7Ysi1fq', 'user');
			INSERT INTO `mydb`.`user_roles` (`role`, `username`) VALUES ('ROLE_USER', 'user')
		 */
	}

}
