package com.pitang.projetosms.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	private String message;
	private StatusMessage statusSrc;
	private StatusMessage statusDes;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "des_id")
	private User des;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "src_id")
	private User src;
	
	public Message() {
	}

	public Message(Integer id, Date date, String message, StatusMessage statusSrc, StatusMessage statusDes, User src,
			User des) {
		super();
		this.id = id;
		this.date = date;
		this.message = message;
		this.statusSrc = statusSrc;
		this.statusDes = statusDes;
		this.des = des;
		this.src = src;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusMessage getStatusSrc() {
		return statusSrc;
	}

	public void setStatusSrc(StatusMessage statusSrc) {
		this.statusSrc = statusSrc;
	}

	public StatusMessage getStatusDes() {
		return statusDes;
	}

	public void setStatusDes(StatusMessage statusDes) {
		this.statusDes = statusDes;
	}

	public User getDes() {
		return des;
	}

	public void setDes(User des) {
		this.des = des;
	}

	public User getSrc() {
		return src;
	}

	public void setSrc(User src) {
		this.src = src;
	}
	
	
}
