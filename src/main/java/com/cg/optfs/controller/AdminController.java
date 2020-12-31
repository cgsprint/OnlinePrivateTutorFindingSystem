package com.cg.optfs.controller;

import java.util.List;

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
	
	@Autowired
	AdminService adminServ;
	
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestParam("username") String Username,
			@RequestParam("password") String Password)
	{
		Admin admin = adminServ.loginAdmin(Username,Password);
		if(admin != null)
		{
			return new ResponseEntity("Login successfull", HttpStatus.OK);
		}
		return new ResponseEntity("Login Failed", HttpStatus.NOT_FOUND);
		
	}
	

	@PostMapping("/addTutor")
	public ResponseEntity<Tutor> addTutor(@RequestBody Tutor tutor)
	{
		Tutor tutor1 = adminServ.addTutor(tutor);
		if(tutor1 != null)
		{
			return new ResponseEntity<Tutor>(tutor1, HttpStatus.OK);
		}
		return new ResponseEntity("Tutor registration failed...", HttpStatus.NOT_FOUND);
		
	}
	
	
	@PutMapping("/updateTutor")
	public ResponseEntity<Tutor> updateTutor(@RequestParam("id") Long Id,@RequestBody Tutor tutor)throws TutorNotFoundException
	{
//		Optional<Tutor> tu =  adminServ.getTutorById(Id); 
		Tutor tu = adminServ.getTutorById(Id).orElseThrow(()-> new TutorNotFoundException("Tutor does not exist with id"+Id));
		if(tu != null)
		{
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
				return new ResponseEntity("Failed to update tutor", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Tutor>(tu1, HttpStatus.OK);
		}
		
		return new ResponseEntity("No Such Tutor Found!", HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/deleteTutor")
	public String deleteTutor(@RequestParam("id") Long Id)throws TutorNotFoundException
	{
		Tutor tu = adminServ.getTutorById(Id).orElseThrow(()->new TutorNotFoundException("Tutor does not exist with id "+Id));
		adminServ.deleteTutor(tu);
		return "Tutor deleted...";
	}
	
	@PostMapping("/addEbook")
	public ResponseEntity<Ebook> addEbook(@RequestBody Ebook ebook)
	{
		Ebook ebook1 = adminServ.addEbook(ebook);
		if(ebook1 != null)
		{
			return new ResponseEntity<Ebook>(ebook1, HttpStatus.OK);
		}
		return new ResponseEntity("Failed to add ebook", HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/updateEbook")
	public ResponseEntity<Ebook> updateEbook(@RequestParam("id") int Id,@RequestBody Ebook ebook)throws EbookNotFoundException
	{
		Ebook eb = adminServ.getEbookById(Id).orElseThrow(()-> new EbookNotFoundException("Ebook does not exist with id "+Id));
		if(eb != null)
		{
			eb.setTitle(ebook.getTitle());
			eb.setAuthorname(ebook.getAuthorname());
			eb.setUrl(ebook.getUrl());
			Ebook eb2 = adminServ.updateEbook(eb);
			if(eb2 == null)
			{
				return new ResponseEntity("Failed to update ebook", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Ebook>(eb2, HttpStatus.OK);
		}
		
		return new ResponseEntity("No Such Ebook Found!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteEbook")
	public String deleteEbook(@RequestParam("id") int Id)throws EbookNotFoundException
	{
		Ebook eb = adminServ.getEbookById(Id).orElseThrow(()->new EbookNotFoundException("Ebook does not exist with id "+Id));
		adminServ.deleteEbook(eb);
		return "Ebook deleted...";
	}
	
	@GetMapping("/viewParents")
	public List<Parent> viewParents()
	{
		List<Parent> parents = adminServ.viewParents();
		return parents;
	}
	

}
