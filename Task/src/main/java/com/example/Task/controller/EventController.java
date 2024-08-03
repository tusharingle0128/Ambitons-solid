package com.example.Task.controller;

import com.example.Task.model.Event;
import com.example.Task.model.Organizer;
import com.example.Task.model.Venue;
import com.example.Task.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventService eventService;

	@PostMapping
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
		return new ResponseEntity<>(eventService.updateEvent(id, eventDetails), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/venue/{venueId}")
	public List<Event> getEventsByVenue(@PathVariable Long venueId) {
		Venue venue = new Venue();
		venue.setId(venueId);
		return eventService.getEventsByVenue(venue);
	}

	@GetMapping("/organizer/{organizerId}")
	public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
		Organizer organizer = new Organizer();
		organizer.setId(organizerId);
		return eventService.getEventsByOrganizer(organizer);
	}
}
