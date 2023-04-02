package com.utku.social.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.utku.social.DataAccess.IPostRepository;
import com.utku.social.Entities.Post;
import com.utku.social.Entities.User;
import com.utku.social.requests.PostCreateRequest;
import com.utku.social.requests.PostUpdateRequest;

@Service
public class PostManager {

	private IPostRepository postRepo;
	private UserManager userManager;
	
	

	public PostManager(IPostRepository postRepo, UserManager userManager) {
		this.postRepo = postRepo;
		this.userManager = userManager;
	}

	public List<Post> getAllPosts(Optional<Long> userId) {
		if (userId.isPresent())
			return postRepo.findByUserId(userId.get());
		return postRepo.findAll();
	}

	public Post getPostById(Long postId) {
		return postRepo.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userManager.getUserById(newPostRequest.getUserId());
		if (user == null)
			return null;
		Post post = new Post();
		post.setId(newPostRequest.getId());
		post.setText(newPostRequest.getText());
		post.setTitle(newPostRequest.getTitle());
		post.setUser(user);
		return postRepo.save(post);
	}

	public Post updateById(long postId, PostUpdateRequest updatePost) {
		Post post = getPostById(postId);
		if (post == null)
			return null;
		post.setText(updatePost.getText());
		post.setTitle(updatePost.getTitle());
		return postRepo.save(post); 
	}

	public void deleteById(long postId) {
		postRepo.deleteById(postId);
	}
}
