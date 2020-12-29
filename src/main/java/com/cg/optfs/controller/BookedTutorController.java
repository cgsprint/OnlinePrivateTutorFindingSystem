package com.cg.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.service.BookedTutorService;

@RestController
@RequestMapping("/bookedtutor")
public class BookedTutorController {

	@Autowired
	BookedTutorService service;
	
	@GetMapping(value="/getBookedTutor")
	public ResponseEntity<List<BookedTutor>> viewBookedTutor(){
		List<BookedTutor> viewBookedTutor = service.viewBookedTutor();
		if (viewBookedTutor.isEmpty()) {
			return new ResponseEntity("Booked Tutor not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BookedTutor>>(viewBookedTutor, HttpStatus.OK);

		
	}
	
	
}
