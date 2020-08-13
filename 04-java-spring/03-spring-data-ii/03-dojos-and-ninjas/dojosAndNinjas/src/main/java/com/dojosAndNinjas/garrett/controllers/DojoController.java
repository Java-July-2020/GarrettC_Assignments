package com.dojosAndNinjas.garrett.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojosAndNinjas.garrett.models.Dojo;
import com.dojosAndNinjas.garrett.services.MainService;

@Controller
public class DojoController {
	private final MainService mainService;
	public DojoController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/")
	public String Index() {
		return "redirect:/dojos";
	}
	
	@RequestMapping("/dojos")
	public String Index(Model model) {
		model.addAttribute("dojos", mainService.allDojos());
		return "/dojos/index.jsp";
	}
	
	@RequestMapping("/dojos/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", this.mainService.findDojo(id));
		return "/dojos/show.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String New(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors())
			return "/dojos/new.jsp";
		this.mainService.createDojo(dojo);
		return "redirect:/dojos";
	}
	
}