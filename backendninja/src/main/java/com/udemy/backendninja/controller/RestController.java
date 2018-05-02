package com.udemy.backendninja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkRest")
	public ResponseEntity<ContactModel> checkRest() {
		ContactModel cm = new ContactModel("Mikel", 2, "Perez", "123", "Madrid");
		return new ResponseEntity<>(cm, HttpStatus.OK);
	}
}
