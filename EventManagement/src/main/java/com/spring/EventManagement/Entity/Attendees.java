package com.spring.EventManagement.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Attendees")
public class Attendees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AttendeeID")
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	@NotNull
	@Column(name = "Email", unique = true, nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "PhoneNum", unique = true, nullable = false)
	private Long phone;
	
	@ManyToMany
	@JoinTable(
			name="registered_events",
			joinColumns = @JoinColumn(name = "AttendeeID"),
			inverseJoinColumns = @JoinColumn(name = "EventID"))
	private Set<Events> events = new HashSet<>();
	
	public Attendees() {
		
	}
	
	public Attendees(String name, String email, Long phone, Set<Events> events) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.events = events;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Set<Events> getEvents() {
		return events;
	}

	public void setEvents(Set<Events> events) {
		this.events = events;
	}
	

}