package com.pitang.projetosms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pitang.projetosms.models.Contact;
import com.pitang.projetosms.services.ContactService;


@RestController
@RequestMapping(value = "/contacts")
public class ContactController {
	
	@Autowired
	private ContactService service;
	
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findr(@PathVariable Integer id) {
		Contact obj = service.find(id);
		return ResponseEntity.ok().body(obj);
				
	
	}

}
