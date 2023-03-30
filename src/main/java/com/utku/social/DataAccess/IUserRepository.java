package com.utku.social.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utku.social.Entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
