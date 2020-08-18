package com.controllerViews.garrett.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.controllerViews.garrett.models.User;
import com.controllerViews.garrett.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository userRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getPassword())) {
			errors.rejectValue("password", "Passwords do not match!");
		}
		
		if(this.userRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email is already taken");
		}
	}
}