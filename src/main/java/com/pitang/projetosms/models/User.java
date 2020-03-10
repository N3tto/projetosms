package com.pitang.projetosms.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String password;
	
	@OneToOne
	private Profile profile;

	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<HistoryPassword> historyPassword = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "owner")
	private List<Story> story = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "des")
	private List<Message> messageDes = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "src")
	private List<Message> messageSrc = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "owner")
	private List<Contact> contactOwner = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "target")
	private List<Contact> contactTarget = new ArrayList<>();
	
	
	public User() {
		
	}

	public User(Integer id, String name, String username, String email, String password, Profile profile) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
	public List<HistoryPassword> getHistoryPassword() {
		return historyPassword;
	}

	public void setHistoryPassword(List<HistoryPassword> historyPassword) {
		this.historyPassword = historyPassword;
	}
	
	
	public List<Story> getStory() {
		return story;
	}

	public void setStory(List<Story> story) {
		this.story = story;
	}

	public List<Message> getMessageDes() {
		return messageDes;
	}

	public void setMessageDes(List<Message> messageDes) {
		this.messageDes = messageDes;
	}

	public List<Message> getMessageSrc() {
		return messageSrc;
	}

	public void setMessageSrc(List<Message> messageSrc) {
		this.messageSrc = messageSrc;
	}

	public List<Contact> getContactOwner() {
		return contactOwner;
	}

	public void setContactOwner(List<Contact> contactOwner) {
		this.contactOwner = contactOwner;
	}

	public List<Contact> getContactTarget() {
		return contactTarget;
	}

	public void setContactTarget(List<Contact> contactTarget) {
		this.contactTarget = contactTarget;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
