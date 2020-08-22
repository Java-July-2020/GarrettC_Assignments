package com.eventBelts.garrett.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventBelts.garrett.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findAll();
	User findByEmail(String email);
	boolean existsByEmail(String email);
}
