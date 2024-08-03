package com.example.Task.service;

import com.example.Task.model.Venue;
import com.example.Task.repository.VenueRepository;
import com.example.Task.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VenueService {
	@Autowired
	private VenueRepository venueRepository;

	public Venue createVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	public Venue getVenueById(Long id) {
		return venueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
	}

	public Venue updateVenue(Long id, Venue venueDetails) {
		Venue venue = getVenueById(id);
		venue.setName(venueDetails.getName());
		venue.setLocation(venueDetails.getLocation());
		venue.setCapacity(venueDetails.getCapacity());
		return venueRepository.save(venue);
	}

	public void deleteVenue(Long id) {
		venueRepository.deleteById(id);
	}
}

