package com.eventBelts.garrett.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventBelts.garrett.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	
	List<Event> findAll();
	List<Event> findByState(String state);
	List<Event> findByStateIsNot(String state);
}
