package com.pitang.projetosms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.projetosms.exceptions.ObjectNotFoundException;
import com.pitang.projetosms.models.Message;
import com.pitang.projetosms.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository repo;
	
	public Message find(Integer id) {
		Optional<Message> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Message.class.getName()));
	
}
}
