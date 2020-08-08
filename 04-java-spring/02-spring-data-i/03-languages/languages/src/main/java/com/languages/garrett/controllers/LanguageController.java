package com.languages.garrett.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.languages.garrett.models.Languages;
import com.languages.garrett.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Languages> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping("/new")
	public String newLanguage(@ModelAttribute("languages") Languages languages) {
		return "new.jsp";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("languages") Languages languages, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		else {
			languageService.createLanguage(languages);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("languages", languageService.findLanguage(id));
		return "show.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	   public String editLanguages(@PathVariable("id") Long id, Model model) {
	       Languages languages = languageService.findLanguage(id);
	       if (languages != null){
	           model.addAttribute("languages", languages);
	           return "edit.jsp";
	       }else{
	           return "redirect:/";
	       }
	   }
	   
	   @PostMapping("/edit/{id}")
	   public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("languages") Languages languages, BindingResult result) {
	       if (result.hasErrors()) {
	           return "edit.jsp";
	       }
	       else{
	           languageService.updateLanguage(id, languages);
	           return "redirect:/";
	       }
	   }
	@RequestMapping(value="/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
}
