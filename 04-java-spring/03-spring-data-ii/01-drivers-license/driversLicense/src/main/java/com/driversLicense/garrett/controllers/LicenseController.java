package com.driversLicense.garrett.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.driversLicense.garrett.models.License;
import com.driversLicense.garrett.models.Person;
import com.driversLicense.garrett.services.LicenseService;
import com.driversLicense.garrett.services.PersonService;

@Controller
public class LicenseController {
	
	private LicenseService licenseService;
	private PersonService personService;

	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("License") License license, Model model) {
		List<Person> person = this.personService.allPersons();
		model.addAttribute("persons", person);
		return "newLicense.jsp";
	}
	
	@RequestMapping("/licenses")
	public String index(Model model) {
		List<License> license = licenseService.allLicenses();
		model.addAttribute("licenses", license);
		return "license.jsp";
	}
	
	@RequestMapping(value = "/licenses", method = RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return"newLicense.jsp";
		}
		else {
			this.licenseService.createLicense(license);
			return "redirect:/licenses";
		}
	}
}
