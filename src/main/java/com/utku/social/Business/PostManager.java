package com.utku.social.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.utku.social.DataAccess.IPostRepository;
import com.utku.social.Entities.Post;

@Service
public class PostManager {

	private IPostRepository postRepo;

	public PostManager(IPostRepository postRepo) {
		this.postRepo = postRepo;
	}

	public List<Post> getAllPosts(Optional<Long> userId) {
		if (userId.isPresent())
			return postRepo.findByUserId(userId.get());
		return postRepo.findAll();
	}

	public Post getPostById(Long postId) {
		return postRepo.findById(postId).orElse(null);
	}
}
