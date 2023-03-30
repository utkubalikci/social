package com.utku.social.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utku.social.Entities.Post;

public interface IPostRepository extends JpaRepository<Post, Long> {

}
