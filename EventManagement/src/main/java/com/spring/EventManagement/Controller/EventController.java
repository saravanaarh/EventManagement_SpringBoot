package com.spring.EventManagement.Controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.EventManagement.Entity.Events;
import com.spring.EventManagement.Service.EventsService;


@RestController
@RequestMapping("/api/event")
public class EventController {
	
	private EventsService eventService;   
	 
	public EventController(EventsService eventService) {
		super();
		this.eventService = eventService;
	}

	@GetMapping("/getEvents")
	public ArrayList<Events> getAllEvents(){
		ArrayList<Events> events = eventService.getAllEvents();
		return events;
	}
	
	@PostMapping("/addEvent")
	public ResponseEntity<String> addEvents(@RequestBody Events event){
		 eventService.addEvent(event);
		 return new ResponseEntity<>("Event Created", HttpStatus.CREATED);
	}
	
	@SuppressWarnings("null")
	@GetMapping("/getEvent/{id}")
	public Optional<Events> getEvent(@PathVariable long id){
		Optional<Events> response = (eventService.getEvent(id));
		return response;
	}
	
	@PutMapping("/UpdateEvent/{id}")
	public ResponseEntity<String> updateEvent(@PathVariable long id, @RequestBody Events event){
		Events response = eventService.updateEvent(id, event);
		if(response!=null)
			return new ResponseEntity<>("Event Updated Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Please Enter valid Event ID", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/DeleteEvent/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable long id){
		String response = eventService.deleteEvent(id);
		if(response != null)
			return new ResponseEntity<>("Event Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Please Enter valid Event ID", HttpStatus.BAD_REQUEST);
	}

}
