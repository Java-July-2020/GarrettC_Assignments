package com.eventBelts.garrett.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventBelts.garrett.model.User;
import com.eventBelts.garrett.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findById(Long id) {
		return this.userRepo.findById(id).orElse(null);
	}
	
	public List<User> allUser(){
		return this.userRepo.findAll();
	}
	
	public User getByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = this.userRepo.findByEmail(email);
		if(user == null) {
			return false;
		} else {
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
