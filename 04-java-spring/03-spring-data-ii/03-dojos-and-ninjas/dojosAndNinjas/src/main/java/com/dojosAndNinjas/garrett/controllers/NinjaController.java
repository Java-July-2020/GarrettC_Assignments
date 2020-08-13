package com.dojosAndNinjas.garrett.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojosAndNinjas.garrett.models.Ninja;
import com.dojosAndNinjas.garrett.services.MainService;

@Controller
public class NinjaController {
	private MainService mainService;
	public NinjaController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/ninjas")
	public String Index(Model model) {
		model.addAttribute("ninjas", this.mainService.allNinjas());
		return "/ninjas/index.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String New(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", this.mainService.allDojos());
		return "/ninjas/new.jsp";
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.mainService.allDojos());
			return "/ninjas/new.jsp";
		}
		this.mainService.createNinja(ninja);
		return "redirect:/ninjas";
	}
}