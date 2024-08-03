package com.example.Task.controller;

import com.example.Task.model.Venue;
import com.example.Task.service.VenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venues")
public class VenueController {
	@Autowired
	private VenueService venueService;

	@PostMapping
	public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
		return new ResponseEntity<>(venueService.createVenue(venue), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
		return new ResponseEntity<>(venueService.getVenueById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venueDetails) {
		return new ResponseEntity<>(venueService.updateVenue(id, venueDetails), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
		venueService.deleteVenue(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

