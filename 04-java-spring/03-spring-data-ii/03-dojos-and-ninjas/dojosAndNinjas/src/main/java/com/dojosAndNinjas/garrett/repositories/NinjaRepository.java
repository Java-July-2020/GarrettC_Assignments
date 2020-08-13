package com.dojosAndNinjas.garrett.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojosAndNinjas.garrett.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	List<Ninja> findAll();
}
