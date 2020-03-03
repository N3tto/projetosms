package com.pitang.projetosms;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pitang.projetosms.models.UserModel;
import com.pitang.projetosms.repositories.UserRepository;

@SpringBootApplication
public class ProjetosmsApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetosmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		 UserModel user1 = new UserModel(null, "Neto", "N3tto", "antonio.araujo@pitang.com", "123456");
		 UserModel user2 = new UserModel(null, "Antonio", "4ntonio", "antonioaraujo99@gmail.com", "senha");
		 
		 userRepository.saveAll(Arrays.asList(user1, user2));
	}

}
