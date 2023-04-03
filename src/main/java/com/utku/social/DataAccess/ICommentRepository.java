package com.utku.social.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utku.social.Entities.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByUserId(Long userId);

	List<Comment> findByPostId(Long postId);

	List<Comment> findByPostIdAndUserId(Long postId, Long l);

}
