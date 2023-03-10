package com.spring.EventManagement.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.EventManagement.Entity.Attendees;
import com.spring.EventManagement.Entity.Events;
import com.spring.EventManagement.Repository.AttendeesRepository;
import com.spring.EventManagement.Repository.EventsRepository;
import com.spring.EventManagement.Service.AttendeesService;


@Service
public class AttendeesServiceImpl implements AttendeesService{
	
	private AttendeesRepository attendeesRepo;
	private EventsRepository eventRepo;
	
	@Override
	public ArrayList<Attendees> getAllAttendees() {
		return (ArrayList<Attendees>) attendeesRepo.findAll();
	}

	public AttendeesServiceImpl(AttendeesRepository attendeesRepo, EventsRepository eventRepo) {
		super();
		this.attendeesRepo = attendeesRepo;
		this.eventRepo = eventRepo;
	}

	@Override
	public Attendees addAttendee(Attendees attendee) {
		try {
			boolean eventFlag = true;
			Set<Events> event =new HashSet<>(attendee.getEvents());
			for(Events e : event) {
				if(!eventRepo.existsById(e.getId()))
					eventFlag = false;
			}
			if(eventFlag)
				return attendeesRepo.save(attendee);
			else
				return null;
		}
		catch(Exception e) {
			e.printStackTrace();
	        return null;
		}
			
	}

	@Override
	public Attendees updateAttendee(Long attenId, Attendees attendees) {
		if(attendeesRepo.existsById(attenId)) {
			return this.addAttendee(attendees);
		}
		else {
			return null;
		}
	}

	@Override
	public String deleteAttendee(Long id) {
		if(attendeesRepo.existsById(id)) {
			attendeesRepo.deleteById(id);
			return "Deleted Successfully";
		}
		else {
			return "Please Enter valid Attendee ID";
		}
		
	}
	

}
