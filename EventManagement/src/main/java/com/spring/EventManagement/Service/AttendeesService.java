package com.spring.EventManagement.Service;

import java.util.ArrayList;

import com.spring.EventManagement.Entity.Attendees;

public interface AttendeesService {
	
	ArrayList<Attendees> getAllAttendees();
	
	Attendees addAttendee(Attendees attendee);
	
	Attendees updateAttendee(Long attenId, Attendees attendees);
	
	String deleteAttendee(Long id);

}
