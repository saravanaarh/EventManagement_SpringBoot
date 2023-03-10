package com.spring.EventManagement.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.spring.EventManagement.Entity.Events;

public interface EventsService {
	
	Events addEvent(Events event);
	
	ArrayList<Events> getAllEvents();
	
    Optional<Events> getEvent(long id);
	
	Events updateEvent(long id,Events event);
	
	String deleteEvent(long id);
	

}
