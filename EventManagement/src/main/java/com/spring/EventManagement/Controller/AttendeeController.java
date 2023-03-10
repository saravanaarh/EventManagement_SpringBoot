package com.spring.EventManagement.Controller;

import java.util.ArrayList;

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

import com.spring.EventManagement.Entity.Attendees;
import com.spring.EventManagement.Entity.Events;
import com.spring.EventManagement.Service.ServiceImpl.AttendeesServiceImpl;
import com.spring.EventManagement.Service.ServiceImpl.EventsServiceImpl;

@RestController
@RequestMapping("/api/attendee")
public class AttendeeController {

	AttendeesServiceImpl attendeeService;
	EventsServiceImpl eventService;
	
	public AttendeeController(AttendeesServiceImpl attendeeService, EventsServiceImpl eventService) {
		super();
		this.attendeeService = attendeeService;
		this.eventService = eventService;
	}
	
	@GetMapping("/getEvents")
	public ArrayList<Events> getEvents(){
		ArrayList<Events> events = eventService.getAllEvents();
		return events;
	}

	@GetMapping("/getAttendees")
	public ArrayList<Attendees> getAllAttendees(){
		ArrayList<Attendees> attendee = attendeeService.getAllAttendees();
		return attendee;
	}
	
	@PostMapping("/AddAttendee")
	public ResponseEntity<String> addAttendee(@RequestBody Attendees attendee){
		Attendees response = attendeeService.addAttendee(attendee);
		if(response != null) {
			return new ResponseEntity<>("Attendee Added Successfully", HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>("Please Enter proper Details", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/UpdateAttendees/{id}")
	public ResponseEntity<String> updateAttendee(@PathVariable Long id, @RequestBody Attendees attendee){
		Attendees response = attendeeService.updateAttendee(id, attendee);
		if(response != null) {
			return new ResponseEntity<>("Attendee Updated Successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Please Enter valid Details", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/DeleteAttendee/{id}")
	public String deleteAttendee(@PathVariable long id) {
		return attendeeService.deleteAttendee(id);
	}

}
