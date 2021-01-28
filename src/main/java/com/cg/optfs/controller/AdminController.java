package com.cg.optfs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.MessageEntity;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.exception.EbookNotFoundException;
import com.cg.optfs.exception.TutorNotFoundException;
import com.cg.optfs.service.AdminService;


/**
 * This is Admin Controller class
 * @author TEJAS HATLE
 * 
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminServ;
	
	// =======================================================
	//						Admin Login
	// =======================================================
	
	@PostMapping("/login")
	public ResponseEntity<MessageEntity> loginAdmin(@Valid @RequestParam("username") String username,
			@RequestParam("password") String password)
	{
		LOGGER.trace("Entering into method loginAdmin");
//		Admin admin1 = adminServ.getAdminByUsername(username);
//		if(admin1 != null)
//		{
		/*
		 * Admin admin = adminServ.loginAdmin(username,password); if(admin != null) {
		 * LOGGER.info("Login successfull"); MessageEntity msg = new
		 * MessageEntity("Login successfull", 200); return new
		 * ResponseEntity<MessageEntity>(msg, HttpStatus.OK); }
		 * LOGGER.error("Error: Enter correct username and password."); MessageEntity
		 * msg = new MessageEntity("Username or password invalid", 404); return new
		 * ResponseEntity<MessageEntity>(msg, HttpStatus.NOT_FOUND);
		 */
		
		List<Admin> aList = adminServ.loginAdmin(username,password);
		if(aList != null)
		{
			LOGGER.info("Login successfull");
			MessageEntity msg = new MessageEntity("Login successfull",200);
			msg.setAdminLst(aList);
			return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
		}
		LOGGER.error("Error: Enter correct username and password.");
		MessageEntity msg = new MessageEntity("Username or password invalid", 404);
		return new ResponseEntity<MessageEntity>(msg, HttpStatus.NOT_FOUND);
		
//		}
//		else
//		{
//			MessageEntity msg = new MessageEntity("User does not exist", 404);
//			return new ResponseEntity<MessageEntity>(msg, HttpStatus.NOT_FOUND);
//		}
	}
	
	
	// =======================================================
	//						Add tutor
	// =======================================================
		
	@PostMapping("/addTutor")
	public ResponseEntity<MessageEntity> addTutor(@Valid @RequestBody Tutor tutor)
	{
		LOGGER.trace("Entering into method addTutor");
		
		Tutor tutor1 = adminServ.addTutor(tutor);
		if(tutor1 != null)
		{
			LOGGER.info("Tutor added");
			MessageEntity msg = new MessageEntity("Tutor registered successfully",200);
			
			return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
		}
		
		LOGGER.error("Error 404");
		return new ResponseEntity("Tutor registration failed...", HttpStatus.NOT_FOUND);
		
	}
	
	// =======================================================
	//						Update Tutor
	// =======================================================
		
	
	@PutMapping("/updateTutor")
	public ResponseEntity<MessageEntity> updateTutor(@Valid @RequestBody Tutor tutor)throws TutorNotFoundException
	{
		LOGGER.trace("Entering into method updateTutor");
		
		Tutor tu1 = adminServ.updateTutor(tutor);
		if(tu1 == null)
		{
			LOGGER.error("Error 404");
			return new ResponseEntity("Failed to update tutor", HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Tutor updated successfully");
		MessageEntity msg = new MessageEntity("Tutor updated successfully",200);
		return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
	}
		
	
	// =======================================================
	//						Delete Tutor
	// =======================================================
		
	@DeleteMapping("/deleteTutor")
	public List<Tutor> deleteTutor(@RequestParam("id") Long id)throws TutorNotFoundException
	{
		LOGGER.trace("Entering into method deleteTutor");
		
		
		Tutor tu = adminServ.getTutorById(id).orElseThrow(()->new TutorNotFoundException("Tutor does not exist with id "+id));
		List<Tutor> tutorListAfterDel = adminServ.deleteTutor(tu);
		
		LOGGER.info("Tutor deleted successfully");
		
		return tutorListAfterDel;
	}
	
	// =======================================================
	//						Add Ebook
	// =======================================================
		
	
	@PostMapping("/addEbook")
	public ResponseEntity<MessageEntity> addEbook(@RequestBody Ebook ebook)
	{
		LOGGER.trace("Entering into method addEbook");
		
		Ebook ebook1 = adminServ.addEbook(ebook);
		if(ebook1 != null)
		{
			MessageEntity msg = new MessageEntity("Ebook added successfully",200);
			LOGGER.info("Ebook added succesfully");
			
			return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
		}
		
		LOGGER.error("Error 404");

		MessageEntity msg = new MessageEntity("Failed to add ebook",404);
		return new ResponseEntity<MessageEntity>(msg, HttpStatus.NOT_FOUND);
		
	}
	
	// =======================================================
	//						Update Ebook
	// =======================================================
		
	
	@PutMapping("/updateEbook")
	public ResponseEntity<MessageEntity> updateEbook(@RequestBody Ebook ebook)throws EbookNotFoundException
	{
		LOGGER.trace("Entering into method updateEbook");
		
		Ebook eb2 = adminServ.updateEbook(ebook);
		if(eb2 == null)
		{
			LOGGER.error("Error 404");
			return new ResponseEntity("Failed to update ebook", HttpStatus.NOT_FOUND);
		}
		LOGGER.info("Ebook updated");
		MessageEntity msg = new MessageEntity("Ebook updated successfully",200);
		return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
	}
	
	// =======================================================
	//						Delete Ebook
	// =======================================================
		
	@DeleteMapping("/deleteEbook")
	public List<Ebook> deleteEbook(@RequestParam("id") int id)throws EbookNotFoundException
	{
		LOGGER.trace("Entering into method deleteEbook");
		
		LOGGER.error("Error 404");
		
		Ebook eb = adminServ.getEbookById(id).orElseThrow(()->new EbookNotFoundException("Ebook does not exist with id "+id));
		List<Ebook> ebookListAfterDel = adminServ.deleteEbook(eb);
		
		LOGGER.info("Ebook deleted");
		
		return ebookListAfterDel;
	}
	
	
	
	// =======================================================
	//						View Parents
	// =======================================================
		
	
	@GetMapping("/viewParents")
	public List<Parent> viewParents()
	{
		LOGGER.trace("Entering into method viewParent");
		
		List<Parent> parents = adminServ.viewParents();
		
		LOGGER.info("Parent list");
		
		return parents;
	}
	
	// ===============================================
	// 					Get tutors list
	// ===============================================
	
	@GetMapping("/viewTutors")
	public List<Tutor> viewTutors()
	{
		LOGGER.trace("Entering into method viewTutors");
		
		List<Tutor> tutors = adminServ.viewTutors();
		
		LOGGER.info("Parent list");
		
		return tutors;
	}
	
	// ===============================================
		// 					Get ebook list
		// ===============================================
		
		@GetMapping("/viewEbooks")
		public List<Ebook> viewEbooks()
		{
			
			List<Ebook> ebooks = adminServ.viewEbook();
			
			LOGGER.info("Parent list");
			
			return ebooks;
		}
	
	@GetMapping("/getTutorById")
	public Optional<Tutor> getTutorById(@RequestParam("id") long tutorId) {

		LOGGER.trace("Entering into method viewProfile");
		
		LOGGER.info("Tutorprofile is found");
		Optional<Tutor> tut = adminServ.getTutorById(tutorId);
		return tut;
	}
	
	

}
