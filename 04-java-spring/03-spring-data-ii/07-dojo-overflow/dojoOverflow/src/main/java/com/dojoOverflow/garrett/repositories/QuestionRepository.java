package com.dojoOverflow.garrett.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojoOverflow.garrett.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findAll();

}
