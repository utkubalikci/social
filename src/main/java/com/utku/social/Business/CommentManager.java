package com.utku.social.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.utku.social.DataAccess.ICommentRepository;
import com.utku.social.Entities.Comment;
import com.utku.social.Entities.Post;
import com.utku.social.Entities.User;
import com.utku.social.requests.CommentCreateRequest;
import com.utku.social.requests.CommentUpdateRequest;

@Service
public class CommentManager {

	private ICommentRepository commentRepo;
	private UserManager userManager;
	private PostManager postManager;
	
	public CommentManager(ICommentRepository commentRepo, UserManager userManager, PostManager postManager) {
		this.commentRepo = commentRepo;
		this.userManager = userManager;
		this.postManager = postManager;
	}

	public List<Comment> getAllComments(Optional<Long> postId, Optional<Long> userId) {
		boolean p = postId.isPresent();
		boolean u = userId.isPresent();
		
		if (u && p) {
			return commentRepo.findByPostIdAndUserId(postId.get(),userId.get());
		}
		if (u) {
			return commentRepo.findByUserId(userId.get());
		}
		if (p) {
			return commentRepo.findByPostId(postId.get());
		}
		return commentRepo.findAll();
	}

	public Comment getCommentById(Long commentId) {
		return commentRepo.findById(commentId).orElse(null);
	}




	public Comment addComment(CommentCreateRequest comment) {
		User user = userManager.getUserById(comment.getUserId());
		Post post = postManager.getPostById(comment.getPostId());
		if (user == null || post == null)
			return null;
		Comment newComment = new Comment();
		newComment.setId(comment.getId());
		newComment.setText(comment.getText());
		newComment.setPost(post);
		newComment.setUser(user);
		return commentRepo.save(newComment);
	}




	public Comment updateCommentById(Long commentId, CommentUpdateRequest comment) {
		Comment newComment = getCommentById(commentId);
		if (newComment == null)
			return null;
		newComment.setText(comment.getText());
		return commentRepo.save(newComment);
	}




	public void deleteCommentById(Long commentId) {
		commentRepo.deleteById(commentId);
		
	}


}
