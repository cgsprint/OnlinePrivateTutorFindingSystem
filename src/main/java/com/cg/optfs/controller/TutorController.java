package com.cg.optfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Tutor;
import com.cg.optfs.service.TutorService;

@RestController
public class TutorController {

	@Autowired
	public TutorService tutorservice;

	@PostMapping("/tutors")
	public Tutor updateProfile(@RequestBody Tutor tutor) {

		return tutorservice.updateProfile(tutor);
	}

	@GetMapping("/tutors/{tutorId}")
	public Tutor viewProfile(@PathVariable long tutorId) {

		return tutorservice.viewProfile(tutorId);
	}

}
