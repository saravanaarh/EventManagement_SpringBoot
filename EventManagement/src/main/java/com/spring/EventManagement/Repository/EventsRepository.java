package com.spring.EventManagement.Repository;


import org.springframework.data.repository.CrudRepository;

import com.spring.EventManagement.Entity.Events;

public interface EventsRepository extends CrudRepository<Events, Long>{
	

}
