package com.example.Task.repository;

import com.example.Task.model.Event;
import com.example.Task.model.Organizer;
import com.example.Task.model.Venue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByVenue(Venue venue);

	List<Event> findByOrganizer(Organizer organizer);
}
