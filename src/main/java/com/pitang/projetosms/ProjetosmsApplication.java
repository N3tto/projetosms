package com.pitang.projetosms;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pitang.projetosms.models.Contact;
import com.pitang.projetosms.models.HistoryPassword;
import com.pitang.projetosms.models.Message;
import com.pitang.projetosms.models.Profile;
import com.pitang.projetosms.models.StatusMessage;
import com.pitang.projetosms.models.Story;
import com.pitang.projetosms.models.User;
import com.pitang.projetosms.repositories.ContactRepository;
import com.pitang.projetosms.repositories.HistoryPasswordRepository;
import com.pitang.projetosms.repositories.MessageRepository;
import com.pitang.projetosms.repositories.ProfileRepository;
import com.pitang.projetosms.repositories.StoryRepository;
import com.pitang.projetosms.repositories.UserRepository;

@SpringBootApplication
public class ProjetosmsApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private HistoryPasswordRepository historyPasswordRepository;
	@Autowired
	private StoryRepository storyRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired 
	ProfileRepository profileRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetosmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Profile prof1 = new Profile(null, "img.com/img1");
		Profile prof2 = new Profile(null, "img.com/img2");
		
		
		User user1 = new User(null, "Neto", "N3tto", "antonio.araujo@pitang.com", "123456", prof1);
		User user2 = new User(null, "Antonio", "4ntonio", "antonioaraujo99@gmail.com", "senha", prof2);
		 
		
		
		HistoryPassword hp1 = new HistoryPassword(null, "654321", user1);
		HistoryPassword hp2 = new HistoryPassword(null, "6543", user1);
		HistoryPassword hp3 = new HistoryPassword(null, "651", user2);
		
		user1.getHistoryPassword().addAll(Arrays.asList(hp1, hp2));
		user2.getHistoryPassword().addAll(Arrays.asList(hp3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Story s1 = new Story(null, "Olá mundo", sdf.parse("30/03/2019 10:43"), 2, user1);
		Story s2 = new Story(null, "Eu odeio Java", sdf.parse("05/02/2020 23:37"), 4, user2);
		Story s3 = new Story(null, "Python é muito melhor", sdf.parse("05/02/2020 23:40"), 1, user2);
		
		user1.getStory().addAll(Arrays.asList(s1));
		user2.getStory().addAll(Arrays.asList(s2, s3));
		
		Message mes1 = new Message(null, sdf.parse("30/03/2019 10:43"), "Oi, tudo bem?", StatusMessage.ONLINE, StatusMessage.OFFLINE, user1, user2);
		Message mes2 = new Message(null, sdf.parse("30/03/2019 10:50"), "Tudo bem, e com você?", StatusMessage.ONLINE, StatusMessage.OFFLINE, user2, user1);
		Message mes3 = new Message(null, sdf.parse("30/03/2019 10:51"), "Eu vou bem", StatusMessage.ONLINE, StatusMessage.ONLINE, user1, user2);

		user1.getMessageSrc().addAll(Arrays.asList(mes1, mes3));
		user1.getMessageDes().addAll(Arrays.asList(mes2));
		user2.getMessageSrc().addAll(Arrays.asList(mes3));
		user2.getMessageDes().addAll(Arrays.asList(mes1, mes3));
		
		Contact con = new Contact(null, user1, user2);
		
		user1.getContactOwner().addAll(Arrays.asList(con));
		user2.getContactTarget().addAll(Arrays.asList(con));
		
		profileRepository.saveAll(Arrays.asList(prof1, prof2));
		userRepository.saveAll(Arrays.asList(user1, user2));
		historyPasswordRepository.saveAll(Arrays.asList(hp1, hp2, hp3));
		storyRepository.saveAll(Arrays.asList(s1, s2, s3));
		messageRepository.saveAll(Arrays.asList(mes1, mes2, mes3));
		contactRepository.saveAll(Arrays.asList(con));

		
		
	}

}
