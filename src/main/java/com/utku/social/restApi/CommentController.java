package com.utku.social.restApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utku.social.Business.CommentManager;
import com.utku.social.Entities.Comment;
import com.utku.social.requests.CommentCreateRequest;
import com.utku.social.requests.CommentUpdateRequest;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentManager commentManager;

	@Autowired
	public CommentController(CommentManager commentManager) {
		this.commentManager = commentManager;
	}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){
		return commentManager.getAllComments(postId,userId);
	}
	
	@GetMapping("/{commentId}")
	public Comment getCommentById(@PathVariable Long commentId) {
		return commentManager.getCommentById(commentId);
	}
	
	@PostMapping
	public Comment addComment(@RequestBody CommentCreateRequest comment) {
		return commentManager.addComment(comment);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateCommentById(@PathVariable Long commentId,@RequestBody CommentUpdateRequest comment) {
		return commentManager.updateCommentById(commentId,comment);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteCommentById(@PathVariable Long commentId) {
		commentManager.deleteCommentById(commentId);
	}

}
