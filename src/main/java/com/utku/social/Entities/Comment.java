package com.utku.social.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class Comment {
	@Id
	long id;
	
	long post_id;
	long user_id;

	
	@Lob
	@Column(columnDefinition = "text")
	String text;
}
