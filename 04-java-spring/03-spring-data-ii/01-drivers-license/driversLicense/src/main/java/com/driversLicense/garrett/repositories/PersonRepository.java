package com.driversLicense.garrett.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driversLicense.garrett.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	List<Person> findAll();

}
