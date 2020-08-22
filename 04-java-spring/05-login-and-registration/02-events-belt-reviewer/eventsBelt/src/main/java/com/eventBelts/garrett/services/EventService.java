package com.eventBelts.garrett.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventBelts.garrett.model.Event;
import com.eventBelts.garrett.model.Message;
import com.eventBelts.garrett.model.User;
import com.eventBelts.garrett.repositories.EventRepository;
import com.eventBelts.garrett.repositories.MessageRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private MessageRepository messageRepo;
	
	public List<Event> getEvents() {
		return this.eventRepo.findAll();
	}
	
	public Event findById(Long id) {
		return this.eventRepo.findById(id).orElse(null);
	}
	
	public List <Event> allEventsWithState(String state){
		return this.eventRepo.findByState(state);
	}
	
	public List<Event> allEventsNotState(String state){
		return this.eventRepo.findByStateIsNot(state);
	}
	
	public Event create(Event event) {
		return this.eventRepo.save(event);
	}
	
	public Event update(Event updatedEvent) {
		return this.eventRepo.save(updatedEvent);
	}

	public void deleteEvent(Long id) {
		this.eventRepo.deleteById(id);
	}
	
	public void comment(User user, Event event, String comment) {
		this.messageRepo.save(new Message(user, event, comment));
	}
	
	public void manageAttendees(Event event, User user, boolean isJoining) {
		if(isJoining) {
			event.getAttendees().add(user);
		}else {
			event.getAttendees().remove(user);
		}
		this.eventRepo.save(event);
	}
}
