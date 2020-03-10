package com.pitang.projetosms.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitang.projetosms.exceptions.ObjectNotFoundException;
import com.pitang.projetosms.models.Story;
import com.pitang.projetosms.repositories.StoryRepository;

@Service
public class StoryService {

	@Autowired
	private StoryRepository repo;
	
	public Story find(Integer id) {
		Optional<Story> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Story.class.getName()));
	}
	
	public Story insert(Story obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
