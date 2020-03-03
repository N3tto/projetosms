package com.pitang.projetosms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pitang.projetosms.models.UserModel;
import com.pitang.projetosms.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findr(@PathVariable Integer id) {
		UserModel obj = service.find(id);
		return ResponseEntity.ok().body(obj);
				
	
	}

}
