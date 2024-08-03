package com.example.Task.controller;

import com.example.Task.model.Organizer;
import com.example.Task.service.OrganizerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {
	@Autowired
	private OrganizerService organizerService;

	@PostMapping
	public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
		return new ResponseEntity<>(organizerService.createOrganizer(organizer), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
		return new ResponseEntity<>(organizerService.getOrganizerById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizerDetails) {
		return new ResponseEntity<>(organizerService.updateOrganizer(id, organizerDetails), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
		organizerService.deleteOrganizer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
