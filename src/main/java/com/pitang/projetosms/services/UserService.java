package com.pitang.projetosms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pitang.projetosms.dto.UserDto;
import com.pitang.projetosms.exceptions.DataIntegrityExcpetion;
import com.pitang.projetosms.exceptions.ObjectNotFoundException;
import com.pitang.projetosms.models.User;
import com.pitang.projetosms.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public List<User> findAll() {
		return repo.findAll();
	}

	public User insert(User obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public User update(User obj) {
		User newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setUsername(obj.getUsername());
		newObj.setPassword(obj.getPassword());
	}
	
	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getUsername(), objDto.getEmail(), objDto.getPassword(), null);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
			}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExcpetion("Não é possivel excluir pois há entidades relacionadas");
		}
	}
}
