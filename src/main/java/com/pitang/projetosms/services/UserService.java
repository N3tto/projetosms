package com.pitang.projetosms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.projetosms.models.UserModel;
import com.pitang.projetosms.repositories.UserRepository;
import com.pitang.projetosms.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public UserModel find(Integer id) {
		Optional<UserModel> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + UserModel.class.getName()));
	
}
}
