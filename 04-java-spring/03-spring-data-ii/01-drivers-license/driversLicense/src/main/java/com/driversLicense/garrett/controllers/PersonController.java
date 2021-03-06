package com.driversLicense.garrett.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.driversLicense.garrett.models.Person;
import com.driversLicense.garrett.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;

	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson.jsp";
	}
	
	@RequestMapping("/persons")
	public String index(Model model) {
		List<Person> person = personService.allPersons();
		model.addAttribute("persons", person);
		return "person.jsp";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public String creatPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}
		else {
			personService.createPerson(person);
			return "redirect:/persons";
		}
	}
	
	@RequestMapping("persons/{id}")
	public String viewPerson(@PathVariable("id") Long id, Model model) {
		Person person = personService.getOnePerson(id);
		model.addAttribute("person", person);
		return "show.jsp";
	}
}
