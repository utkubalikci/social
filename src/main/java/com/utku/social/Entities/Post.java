package com.utku.social.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {
	@Id
	long id;
	
	long user_id;
	
	String title;
	
	@Lob
	@Column(columnDefinition = "text")
	String text;
}
