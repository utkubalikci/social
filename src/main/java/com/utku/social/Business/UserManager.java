package com.utku.social.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utku.social.DataAccess.IUserRepository;
import com.utku.social.Entities.User;

@Service
public class UserManager {

	private IUserRepository userRepo;

	@Autowired
	public UserManager(IUserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Transactional
	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	@Transactional
	public void addUser(User newUser) {
		userRepo.save(newUser);
	}
	
	@Transactional
	public User getUserById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	@Transactional
	public void updateUserById(long id,User newUser) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			User tempUser = user.get();
			tempUser.setUserName(newUser.getUserName());
			tempUser.setPassword(newUser.getPassword());
			tempUser.setMail(newUser.getMail());
			userRepo.save(tempUser);
		}
	}
	
	@Transactional
	public void deleteUserById(long id) {
		userRepo.deleteById(id);
	}
}
