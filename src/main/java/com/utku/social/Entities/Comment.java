package com.utku.social.Entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class Comment {
	@Id
	long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	User user;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Post post;
	

	
	@Lob
	@Column(columnDefinition = "text")
	String text;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Post getPost() {
		return post;
	}



	public void setPost(Post post) {
		this.post = post;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}
	
	
}
