package com.cg.optfs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.service.TutorService;



@RestController

public class TutorController {

	private static final Logger LOGGER=LoggerFactory.getLogger(TutorController.class);
	
	@Autowired
	public TutorService tutorservice;
	
	
	
	@PostMapping("/logintutor")
	public ResponseEntity<Tutor> loginTutor(@RequestParam("username") String Username,
			@RequestParam("password") String Password)
	{
		LOGGER.trace("Entering into method loginTutor");
		
		Tutor tutor = tutorservice.loginTutor(Username,Password);
		if(tutor != null)
		{
			LOGGER.info("Login successful for Tutor");
			
			return new ResponseEntity("Login successfull", HttpStatus.OK);
		}
		
		LOGGER.error("Error: Enter correct username and password");
		
		return new ResponseEntity("Login Failed", HttpStatus.NOT_FOUND);
		
	}
	

	
	
	@PostMapping("/updateTutor")
	public ResponseEntity<Tutor> updateProfile(@RequestBody Tutor tutor) {
		
		LOGGER.trace("Entering into method updateProfile");
		
		Tutor tutor2= tutorservice.updateProfile(tutor);
          if(tutor2!=null) {
        	  
        	  LOGGER.info("Tutor updated successfully");
        	  
        	  return new ResponseEntity<Tutor>(tutor2, HttpStatus.OK);
          }
          
          LOGGER.error("Error 404");
          
		return new ResponseEntity("Tutor update failed...", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/viewTutor/{tutorId}")
	public Tutor viewProfile(@PathVariable long tutorId) {

		LOGGER.trace("Entering into method viewProfile");
		
		LOGGER.info("Tutorprofile is found");
		return tutorservice.viewProfile(tutorId);
	}

	@GetMapping("/request")
	public List<Request> getAllRequest() {
		
		LOGGER.trace("Entering into method getAllRequest");
		
		LOGGER.info("Requests found for Tutor");
		
		return tutorservice.getAllRequests();
	}
	
	@GetMapping("/bookedTutor")
	public List<BookedTutor> getBookedTutor() {
		
		LOGGER.trace("Entering into method getAllRequest");
		
		LOGGER.info("Requests found for Tutor");
		
		return tutorservice.getBookedTutor();
	}
	

}
