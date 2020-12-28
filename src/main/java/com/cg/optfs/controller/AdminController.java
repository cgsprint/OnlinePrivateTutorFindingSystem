package com.cg.optfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminServ;
	
	@GetMapping("/hello")
	public String helloAdmin()
	{
		return "Hello";
		
	}
	
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
	public ResponseEntity<Admin> addTutor(@RequestBody Tutor tutor)
	{
		Tutor tutor1 = adminServ.addTutor(tutor);
		if(tutor1 != null)
		{
			return new ResponseEntity("Tutor registered...", HttpStatus.OK);
		}
		return new ResponseEntity("Tutor registration failed...", HttpStatus.NOT_FOUND);
		
	}

}
