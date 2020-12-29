package com.cg.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Feedback;
import com.cg.optfs.service.FeedbackService;

@RestController
@RequestMapping(value="/feedback")
public class FeedbackController {


	@Autowired
	FeedbackService fservice;
	
	@PostMapping(value="/add")
	public ResponseEntity<Feedback> addFeedback(@RequestParam("parentId") int parentId, @RequestParam("tutorId") int tutorId, @RequestParam("rating") String rating)
	{
		Feedback addFeedback= fservice.addFeedback(parentId, tutorId, rating);
		if (addFeedback == null) {
			return new ResponseEntity("Feedback not added", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Feedback>(addFeedback, HttpStatus.OK);
	}
	
	@GetMapping(value="/delete")
	public ResponseEntity<Feedback> removeFeedback(@RequestParam("feedbackId") int feedbackId)
	{
		Feedback feedback= fservice.removeFeedback(feedbackId);
		if (feedback == null) {
			return new ResponseEntity("No Such Feedback Found with this Id!", HttpStatus.NOT_FOUND);
		}

		return new  ResponseEntity<Feedback>(feedback, HttpStatus.OK);
	}
	
	@GetMapping(value="/feedbacklist")
	public ResponseEntity<List<Feedback>> getFeedbacklist()
	{
		List<Feedback> flist= fservice.getFeedbacklist();
		if (flist.isEmpty()) {
			return new ResponseEntity("No Feedbacks Found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Feedback>>(flist, HttpStatus.OK);
	}
	
	@GetMapping(value="/getlist/{tutorId}")
	public ResponseEntity<List<Feedback>> getFeedback(@PathVariable("tutorId") int tutorId)
	{
		List<Feedback> flist= fservice.getFeedback(tutorId);
		if (flist.isEmpty()) {
			return new ResponseEntity("No Feedbacks Found with this Id", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Feedback>>(flist, HttpStatus.OK);
	}
	
}
