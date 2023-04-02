package com.utku.social.restApi;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utku.social.Business.PostManager;
import com.utku.social.Entities.Post;

@RestController
@RequestMapping("/posts")
public class PostController {

	private PostManager postManager;

	public PostController(PostManager postManager) {
		this.postManager = postManager;
	}
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		return postManager.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postManager.getPostById(postId);
	}
	
}
