package com.example.Task.service;

import com.example.Task.exception.ResourceNotFoundException;
import com.example.Task.model.Event;
import com.example.Task.model.Organizer;
import com.example.Task.model.Venue;
import com.example.Task.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Event getEventById(Long id) {
		return eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
	}

	public Event updateEvent(Long id, Event eventDetails) {
		Event event = getEventById(id);
		event.setEventName(eventDetails.getEventName());
		event.setEventDate(eventDetails.getEventDate());
		event.setDescription(eventDetails.getDescription());
		event.setOrganizer(eventDetails.getOrganizer());
		event.setVenue(eventDetails.getVenue());
		return eventRepository.save(event);
	}

	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

	public List<Event> getEventsByVenue(Venue venue) {
		return eventRepository.findByVenue(venue);
	}

	public List<Event> getEventsByOrganizer(Organizer organizer) {
		return eventRepository.findByOrganizer(organizer);
	}
}

