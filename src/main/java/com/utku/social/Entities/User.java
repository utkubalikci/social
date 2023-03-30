package com.utku.social.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	@Id
	long id;
	
	String userName;
	String password;
	String mail;
}
