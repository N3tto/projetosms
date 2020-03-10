package com.pitang.projetosms.dto;

import java.util.Date;

import com.pitang.projetosms.models.Story;

public class StoryDto {

	private Integer id;
	private String message;
	private Date postDate;
	private Integer type;
	
	public StoryDto() {
	}
	
	public StoryDto(Story story) {
		this.id = story.getId();
		this.message = story.getMessage();
		this.postDate = story.getPostDate();
		this.type = story.getType();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
