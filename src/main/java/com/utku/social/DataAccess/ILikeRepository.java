package com.utku.social.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utku.social.Entities.Like;

public interface ILikeRepository extends JpaRepository<Like, Long> {

}
