package com.dojoOverflow.garrett.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoOverflow.garrett.models.Answer;
import com.dojoOverflow.garrett.models.NewQuestion;
import com.dojoOverflow.garrett.services.MainService;

@Controller
public class QuestionController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("questions", this.mainService.getQuestions());
		return "index.jsp";
	}
	@GetMapping("/new")
	public String New(@ModelAttribute("newQuestion") NewQuestion newQuestion) {
		return "new.jsp";
	}
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, @ModelAttribute("newanswer") Answer answer, Model model) {
		model.addAttribute("question", this.mainService.getQuestion(id));
		return "show.jsp";
	}
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, 
		BindingResult result) {
		if(result.hasErrors())
			return "new.jsp";
		this.mainService.createQuestion(newQuestion);
		return "redirect:/";
	}
	@PostMapping("/answers")
	public String CreateAnswer(@Valid @ModelAttribute("newanswer") Answer answer, BindingResult result) {
		if(result.hasErrors())
			return "show.jsp";
		Answer newAnswer = this.mainService.createAnswer(answer);
		return "redirect:/" + newAnswer.getQuestion().getId();
	}
}
