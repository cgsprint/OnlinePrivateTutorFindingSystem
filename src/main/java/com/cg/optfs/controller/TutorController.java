package com.cg.optfs.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Booking;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.MessageEntity;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.service.TutorService;

/**
 * This is Tutor Controller class
 * @author Manoj
 * 
 */

@RestController
@CrossOrigin("*")
public class TutorController {

	private static final Logger LOGGER=LoggerFactory.getLogger(TutorController.class);
	
	@Autowired
	public TutorService tutorservice;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	
	@PostMapping("/logintutor")
	public ResponseEntity<MessageEntity> loginTutor(@Valid @RequestParam("username") String username,
			@RequestParam("password") String password)
	{
		LOGGER.trace("Entering into method loginTutor");
		
		List<Tutor> tutor = tutorservice.loginTutor(username,password);
		if(tutor != null)
		{
			LOGGER.info("Login successful for Tutor..");
			MessageEntity msg = new MessageEntity("Login successfull",200);
			msg.setTutorLst(tutor);
			return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
		}
		
		LOGGER.error("Error: Enter correct username and password..");
		MessageEntity msg = new MessageEntity("Login failed",404);
		return new ResponseEntity<MessageEntity>(msg, HttpStatus.NOT_FOUND);
		
	}
	
	/**
	 * 
	 * @param tutor
	 * @return Tutor
	 */
	
	@PutMapping("/updateTutor")
	public ResponseEntity<Tutor> updateProfile(@Valid @RequestBody Tutor tutor) {
		
		LOGGER.trace("Entering into method updateProfile");
		
		Tutor tutor2= tutorservice.updateProfile(tutor);
          if(tutor2!=null) {
        	  
        	  LOGGER.info("Tutor updated successfully");
        	  
        	  return new ResponseEntity<Tutor>(tutor2, HttpStatus.OK);
          }
          
          LOGGER.error("Error 404");
          
		return new ResponseEntity("Tutor update failed...", HttpStatus.NOT_FOUND);
	}
     
	/**
	 * 
	 * @param tutorId
	 * @return Tutor
	 */
	@GetMapping("/tutor/viewTutor")
	public Tutor viewProfile(@RequestParam("id") long tutorId) {

		LOGGER.trace("Entering into method viewProfile");
		
		LOGGER.info("Tutorprofile is found");
		return tutorservice.viewProfile(tutorId);
	}
	
    /**
     * 
     * @return Request
     */
	@GetMapping("/getDemoRequest")
	public List<Request> getAllRequest(@RequestParam("tutorId") int tutorId) {
		
		LOGGER.trace("Entering into method getAllRequest");
		
		LOGGER.info("Requests found for Tutor");
		
		return tutorservice.getAllRequests(tutorId);
	}
	
	@GetMapping("/getBookedTutor")
	public List<BookedTutor> getBooking(@RequestParam("tutorId") int tutorId) {
		
		LOGGER.trace("Entering into method getAllRequest");
		
		LOGGER.info("Requests found for Tutor");
		
		return tutorservice.getBooking(tutorId);
	}
	
	@GetMapping("/viewEbooks")
	public List<Ebook> getAllEbooks() {
		
		LOGGER.trace("Entering into method getAllRequest");
		
		LOGGER.info("Requests found for Tutor");
		
		return tutorservice.getAllEbooks();
	}
	

}
