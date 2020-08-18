package com.controllerViews.garrett.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controllerViews.garrett.models.User;
import com.controllerViews.garrett.services.UserService;
import com.controllerViews.garrett.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private UserValidator validator;
 
 public UserController(UserService userService, UserValidator validator) {
     this.userService = userService;
     this.validator = validator;
 }
 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser( @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	
	validator.validate(user, result);
	if(result.hasErrors()) {
		return "registration.jsp";
	}
	User u = this.userService.registerUser(user);
	session.setAttribute("user_id", u.getId());
	return"redirect:/home";
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
     boolean isAuthenticated = userService.authenticateUser(email, password);
     if(isAuthenticated) {
    	 User user = userService.findByEmail(email);
    	 session.setAttribute("user_id", user.getId());
    	 return "redirect:/home";
     } else {
    	 model.addAttribute("error", "Invalid Credentials.");
    	 return "loginPage.jsp";
     }
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
     Long userId = (Long) session.getAttribute("user_id");
     User user = userService.findUserById(userId);
     model.addAttribute("user", user);
     return "homepage.jsp";
 }
 
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     session.invalidate();
     return "redirect:/login";
 }
}
