package com.driversLicense.garrett.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.driversLicense.garrett.models.Person;
import com.driversLicense.garrett.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService (PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getOnePerson(Long id) {
		Person set = this.personRepository.findById(id).orElse(null);
		return set;
	}
}
