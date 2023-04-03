package com.utku.social.Business;

import java.util.List;
import java.util.Optional;

import com.utku.social.DataAccess.ILikeRepository;
import com.utku.social.Entities.Like;
import com.utku.social.requests.LikeCreateRequest;

public class LikeManager {

	private ILikeRepository likeRepo;
	private UserManager userManager;
	private PostManager postManager;
	
	
	public LikeManager(ILikeRepository likeRepo, UserManager userManager, PostManager postManager) {
		this.likeRepo = likeRepo;
		this.userManager = userManager;
		this.postManager = postManager;
	}

	public List<Like> getAllLikes(Optional<Long> postId, Optional<Long> userId) {
		if (postId.isPresent() && userId.isPresent())
			return likeRepo.findByPostIdAndUserId(postId.get(),userId.get());
		if (postId.isPresent())
			return likeRepo.findByPostId(postId.get());
		if (userId.isPresent())
			return likeRepo.findByUserId(userId.get());
		return likeRepo.findAll();
		
	}

	public Like addLike(LikeCreateRequest newLike) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteLikeById(Long commentId) {
		// TODO Auto-generated method stub
		
	}

}
