package com.utku.social.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utku.social.Entities.Like;

public interface ILikeRepository extends JpaRepository<Like, Long> {

	List<Like> findByPostIdAndUserId(Long postId, Long userId);

	List<Like> findByPostId(Long postId);

	List<Like> findByUserId(Long userId);

}
