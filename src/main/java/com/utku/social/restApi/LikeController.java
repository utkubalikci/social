package com.utku.social.restApi;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utku.social.Business.LikeManager;
import com.utku.social.Entities.Like;
import com.utku.social.requests.LikeCreateRequest;

@RestController
@RequestMapping("/likes")
public class LikeController {

	private LikeManager likeManager;

	public LikeController(LikeManager likeManager) {
		this.likeManager = likeManager;
	}
	
	@GetMapping
	public List<Like> getAllLikes(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){
		return likeManager.getAllLikes(postId,userId);
	}
	
	@PostMapping
	public Like addLike(@RequestBody LikeCreateRequest newLike) {
		return likeManager.addLike(newLike);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteLike(@PathVariable Long commentId) {
		likeManager.deleteLikeById(commentId);
	}
}
