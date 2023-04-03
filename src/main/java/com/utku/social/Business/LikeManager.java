package com.utku.social.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.utku.social.DataAccess.ILikeRepository;
import com.utku.social.Entities.Like;
import com.utku.social.Entities.Post;
import com.utku.social.Entities.User;
import com.utku.social.requests.LikeCreateRequest;

@Service
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
		User user = userManager.getUserById(newLike.getUser_id());
		Post post = postManager.getPostById(newLike.getPost_id());
		if (user == null || post == null)
			return null;
		Like like = new Like();
		like.setId(newLike.getId());
		like.setPost(post);
		like.setUser(user);
		return likeRepo.save(like);
	}

	public void deleteLikeById(Long commentId) {
		likeRepo.deleteById(commentId);
		
	}

}
