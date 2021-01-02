package com.cg.optfs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.cg.optfs.entity.Feedback;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.exception.TutorNotFoundException;
import com.cg.optfs.service.ParentService;

@RestController
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	private ParentService parentServ;
	
	@GetMapping("/hello")
	public String helloParent()
	{
		return "hello";
	}
	
	@PostMapping("/login")
	public ResponseEntity<Parent> loginParent(@RequestParam("username") String Username,@RequestParam("password") String Password)
	{
		Parent parent = parentServ.loginParent(Username,Password);
		if(parent != null)
		{
			return new ResponseEntity("Login successfull", HttpStatus.OK);
		}
		return new ResponseEntity("Login Failed", HttpStatus.NOT_FOUND);	
	}
	
	@PostMapping("/register")
	public ResponseEntity<Parent> addParent(@RequestBody Parent parent)
	{
		Parent parent1 = parentServ.addParent(parent);
		if(parent1 != null)
		{
			return new ResponseEntity("Parent registered...", HttpStatus.OK);
		}
		return new ResponseEntity("Parent registration failed...", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{parentId}")
	public Parent viewParent(@PathVariable Integer parentId)
	{
		return parentServ.viewParent(parentId);
	}
	
	@PutMapping("/updateParent")
	public Parent updateParent(@RequestParam("id") Integer Id,@RequestBody Parent parent)
	{
		Parent pa =parentServ.getParentById(Id);
			pa.setFirstName(parent.getFirstName());
			pa.setLastName(parent.getLastName());
			pa.setMobileNo(parent.getMobileNo());
			pa.setAddress(parent.getAddress());
			pa.setEmail(parent.getEmail());
			pa.setUsername(parent.getUsername());
			pa.setPassword(parent.getPassword());
			Parent pa1=parentServ.updateParent(pa);
			return pa1;
	}
	@GetMapping("/viewAllTutor")
	public List<Tutor> viewAllTutor(){
		return parentServ.viewAllTutor();
	}
	
	@GetMapping("/viewEbook")
	public List<Ebook> viewEbook(){
		return parentServ.viewEbook();
	}
	
	@PostMapping("/giveFeedback/{parentId}")
	public Feedback giveFeedback(@PathVariable int parentId,@RequestBody Feedback feedback)
	{
		Feedback add=parentServ.giveFeedback(feedback,parentId);
		return add;
	}
	
}
