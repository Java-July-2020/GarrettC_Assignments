package com.dojosAndNinjas.garrett.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojosAndNinjas.garrett.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	
	List<Dojo> findAll();

}
