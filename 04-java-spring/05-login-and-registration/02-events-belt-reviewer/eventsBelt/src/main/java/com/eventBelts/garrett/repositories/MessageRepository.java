package com.eventBelts.garrett.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventBelts.garrett.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
