package com.cg.optfs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.exception.EbookNotFoundException;
import com.cg.optfs.exception.TutorNotFoundException;
import com.cg.optfs.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminServ;
	
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestParam("username") String Username,
			@RequestParam("password") String Password)
	{
		LOGGER.trace("Entering into method loginAdmin");
		
		
		Admin admin = adminServ.loginAdmin(Username,Password);
		if(admin != null)
		{
			LOGGER.info("Login successfull");
			return new ResponseEntity("Login successfull", HttpStatus.OK);
		}
		LOGGER.error("Error: Enter correct username and password.");
		return new ResponseEntity("Login Failed", HttpStatus.NOT_FOUND);
		
	}
	

	@PostMapping("/addTutor")
	public ResponseEntity<Tutor> addTutor(@RequestBody Tutor tutor)
	{
		LOGGER.trace("Entering into method addTutor");
		
		Tutor tutor1 = adminServ.addTutor(tutor);
		if(tutor1 != null)
		{
			LOGGER.info("Tutor added");
			
			return new ResponseEntity<Tutor>(tutor1, HttpStatus.OK);
		}
		
		LOGGER.error("Error 404");
		return new ResponseEntity("Tutor registration failed...", HttpStatus.NOT_FOUND);
		
	}
	
	
	@PutMapping("/updateTutor")
	public ResponseEntity<Tutor> updateTutor(@RequestParam("id") Long Id,@RequestBody Tutor tutor)throws TutorNotFoundException
	{
		LOGGER.trace("Entering into method updateTutor");
		
		LOGGER.error("Error: Enter correct tutorId");
		
//		Optional<Tutor> tu =  adminServ.getTutorById(Id); 
		Tutor tu = adminServ.getTutorById(Id).orElseThrow(()-> new TutorNotFoundException("Tutor does not exist with id"+Id));
		if(tu != null)
		{
			LOGGER.info("Tutor updated successfully");
			
			tu.setName(tutor.getName());
			tu.setUsername(tutor.getUsername());
			tu.setPassword(tutor.getPassword());
			tu.setAddress(tutor.getAddress());
			tu.setPhoneNumber(tutor.getPhoneNumber());
			tu.setQualifications(tutor.getQualifications());
			tu.setSubject(tutor.getSubject());
			Tutor tu1 = adminServ.updateTutor(tu);
			if(tu1 == null)
			{
				LOGGER.error("Error 404");
				
				return new ResponseEntity("Failed to update tutor", HttpStatus.NOT_FOUND);
			}
			LOGGER.info("Tutor updated successfully");
			return new ResponseEntity<Tutor>(tu1, HttpStatus.OK);
		}
		
		return new ResponseEntity("No Such Tutor Found!", HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/deleteTutor")
	public String deleteTutor(@RequestParam("id") Long Id)throws TutorNotFoundException
	{
		LOGGER.trace("Entering into method deleteTutor");
		
		LOGGER.error("Error: Enter correct tutorId");
		
		Tutor tu = adminServ.getTutorById(Id).orElseThrow(()->new TutorNotFoundException("Tutor does not exist with id "+Id));
		adminServ.deleteTutor(tu);
		
		LOGGER.info("Tutor deleted successfully");
		
		return "Tutor deleted...";
	}
	
	@PostMapping("/addEbook")
	public ResponseEntity<Ebook> addEbook(@RequestBody Ebook ebook)
	{
		LOGGER.trace("Entering into method addEbook");
		
		Ebook ebook1 = adminServ.addEbook(ebook);
		if(ebook1 != null)
		{
			LOGGER.info("Ebook added succesfully");
			
			return new ResponseEntity<Ebook>(ebook1, HttpStatus.OK);
		}
		
		LOGGER.error("Error 404");
		
		return new ResponseEntity("Failed to add ebook", HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/updateEbook")
	public ResponseEntity<Ebook> updateEbook(@RequestParam("id") int Id,@RequestBody Ebook ebook)throws EbookNotFoundException
	{
		LOGGER.trace("Entering into method updateEbook");
		
		LOGGER.error("Error: Entered correct EbookId");
		
		Ebook eb = adminServ.getEbookById(Id).orElseThrow(()-> new EbookNotFoundException("Ebook does not exist with id "+Id));
		if(eb != null)
		{
			
			eb.setTitle(ebook.getTitle());
			eb.setAuthorname(ebook.getAuthorname());
			eb.setUrl(ebook.getUrl());
			Ebook eb2 = adminServ.updateEbook(eb);
			if(eb2 == null)
			{
				LOGGER.error("Error 404");
				
				return new ResponseEntity("Failed to update ebook", HttpStatus.NOT_FOUND);
			}
			LOGGER.info("Ebook updated");
			
			return new ResponseEntity<Ebook>(eb2, HttpStatus.OK);
		}
		
		
		return new ResponseEntity("No Such Ebook Found!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteEbook")
	public String deleteEbook(@RequestParam("id") int Id)throws EbookNotFoundException
	{
		LOGGER.trace("Entering into method deleteEbook");
		
		LOGGER.error("Error 404");
		
		Ebook eb = adminServ.getEbookById(Id).orElseThrow(()->new EbookNotFoundException("Ebook does not exist with id "+Id));
		adminServ.deleteEbook(eb);
		
		LOGGER.info("Ebook deleted");
		
		return "Ebook deleted...";
	}
	
	@GetMapping("/viewParents")
	public List<Parent> viewParents()
	{
		LOGGER.trace("Entering into method viewParent");
		
		List<Parent> parents = adminServ.viewParents();
		
		LOGGER.info("Parent list");
		
		return parents;
	}
	

}
