package com.niit.collabration2.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collabration2.model.Event;



@Repository
public interface EventDAO {
	
	public boolean save(Event event);

	public boolean update(Event event);

	public boolean delete(Event event);

	public Event get(int eventid);

	public List<Event> list();
}
