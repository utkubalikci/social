package com.utku.social.restApi;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utku.social.Business.PostManager;
import com.utku.social.Entities.Post;
import com.utku.social.requests.PostCreateRequest;
import com.utku.social.requests.PostUpdateRequest;

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
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postManager.createOnePost(newPostRequest);
	}
	
	@PutMapping("/{postId}")
	public Post updateById(@PathVariable long postId, @RequestBody PostUpdateRequest updatePost) {
		return postManager.updateById(postId,updatePost);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteById(@PathVariable long postId) {
		postManager.deleteById(postId);
	}
}
