package com.cg.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.service.TutorService;



@RestController
public class TutorController {

	@Autowired
	public TutorService tutorservice;
	
	@PostMapping("/logintutor")
	public ResponseEntity<Tutor> loginTutor(@RequestParam("username") String Username,
			@RequestParam("password") String Password)
	{
		Tutor tutor = tutorservice.loginTutor(Username,Password);
		if(tutor != null)
		{
			return new ResponseEntity("Login successfull", HttpStatus.OK);
		}
		return new ResponseEntity("Login Failed", HttpStatus.NOT_FOUND);
		
	}
	

	
	
	@PostMapping("/tutors")
	public Tutor updateProfile(@RequestBody Tutor tutor) {

		return tutorservice.updateProfile(tutor);
	}

	@GetMapping("/tutors/{tutorId}")
	public Tutor viewProfile(@PathVariable long tutorId) {

		return tutorservice.viewProfile(tutorId);
	}

	@GetMapping("/request")
	public List<Request> getAllRequest() {

		return tutorservice.getAllRequests();
	}
}
