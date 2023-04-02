package com.utku.social.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utku.social.Business.UserManager;
import com.utku.social.DataAccess.IUserRepository;
import com.utku.social.Entities.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserManager userManager;
	private IUserRepository userRepo;

	@Autowired
	public UserController(UserManager userManager,IUserRepository userRepo) {
		this.userManager = userManager;
		this.userRepo = userRepo;
	}
	
	@GetMapping("/")
	public List<User> getAll(){
		return userManager.getAll();
	}
	
	@PostMapping
	public void add(@RequestBody User user) {
		userManager.addUser(user);
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		//return userRepo.findById(id).orElse(null);
		return userManager.getUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public void update(@PathVariable long userId, @RequestBody User newUser) {
		userManager.updateUserById(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void delete(@PathVariable long userId) {
		userManager.deleteUserById(userId);
	}
}
