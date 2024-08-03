package com.example.Task.repository;

import com.example.Task.model.Organizer;
import com.example.Task.repository.OrganizerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
