package com.eventBelts.garrett.validators;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eventBelts.garrett.model.User;
import com.eventBelts.garrett.repositories.UserRepository;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if(this.userRepo.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Unique");
        }
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}
