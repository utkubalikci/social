package com.utku.social.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="like")
@Data
public class Like {
	@Id
	long id;
	
	long post_id;
	long user_id;
}
