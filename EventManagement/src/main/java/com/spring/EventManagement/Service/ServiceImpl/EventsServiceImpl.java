package com.spring.EventManagement.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.EventManagement.Entity.Events;
import com.spring.EventManagement.Repository.EventsRepository;
import com.spring.EventManagement.Service.EventsService;

@Service
public class EventsServiceImpl implements EventsService{
	
	private EventsRepository eventsRepo;
	
	public EventsServiceImpl(EventsRepository eventsRepo) {
		super();
		this.eventsRepo = eventsRepo;
	}

	@Override
	public Events addEvent(Events event) {
		return eventsRepo.save(event);
	}

	@Override
	public ArrayList<Events> getAllEvents() {
		return (ArrayList<Events>) eventsRepo.findAll();
	}

	@Override
	public Optional<Events> getEvent(long id) {
		if(eventsRepo.existsById(id))
			return eventsRepo.findById(id);
		else
			return null;
	}

	@Override
	public Events updateEvent(long id, Events event) {
		if(eventsRepo.existsById(id)) {
			return eventsRepo.save(event);
		}
		else {
			return null;
		}
	}

	@Override
	public String deleteEvent(long id) {
		if(eventsRepo.existsById(id)) {
			eventsRepo.deleteById(id);
			return "Success";
		}
		else {
			return null;
		}
	}

}
