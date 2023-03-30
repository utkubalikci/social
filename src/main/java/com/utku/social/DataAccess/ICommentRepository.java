package com.utku.social.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utku.social.Entities.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long> {

}
