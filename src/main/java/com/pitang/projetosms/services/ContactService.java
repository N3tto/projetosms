package com.pitang.projetosms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.projetosms.exceptions.ObjectNotFoundException;
import com.pitang.projetosms.models.Contact;
import com.pitang.projetosms.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repo;
	
	public Contact find(Integer id) {
		Optional<Contact> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Contact.class.getName()));
	
}
}
