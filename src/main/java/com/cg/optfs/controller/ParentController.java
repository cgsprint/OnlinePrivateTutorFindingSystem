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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Feedback;
import com.cg.optfs.entity.MessageEntity;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.exception.ParentNotFoundException;
import com.cg.optfs.exception.TutorNotFoundException;
import com.cg.optfs.service.ParentService;

@RestController
@RequestMapping("/parent")
@CrossOrigin("*")
public class ParentController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ParentController.class);

	@Autowired
	private ParentService parentServ;
	
	@GetMapping("/hello")
	public String helloParent()
	{
		return "hello";
	}
	
	@PostMapping("/login")
	public ResponseEntity<MessageEntity> loginParent(@Valid @RequestParam("username") String username,@RequestParam("password") String password)
	{
		LOGGER.trace("Entering into method loginParent");
		
		List<Parent> parent = parentServ.loginParent(username,password);
		if(parent != null)
		{
			LOGGER.info("Login succesfull for Parent.");
			MessageEntity msg = new MessageEntity("Login successfull",200);
			msg.setParentLst(parent);
			return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
		}
		
		LOGGER.error("Error: Enter correct username and password.");
		MessageEntity msg = new MessageEntity("Login failed",404);
		return new ResponseEntity<MessageEntity>(msg, HttpStatus.NOT_FOUND);	
	}
	
	@PostMapping("/register")
	public ResponseEntity<MessageEntity> addParent(@Valid @RequestBody Parent parent)
	{
		LOGGER.trace("Entering into method addParent.");
		
		Parent parent1 = parentServ.addParent(parent);
		if(parent1 != null)
		{
			LOGGER.info("Parent registered successfully.");
			MessageEntity msg = new MessageEntity("Registered successfully",200);
//			msg.setParentLst(parent);
			return new ResponseEntity<MessageEntity>(msg, HttpStatus.OK);
		}
		
		LOGGER.error("Error: Enter valid data.");
		
		return new ResponseEntity("Parent registration failed...", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{parentId}")
	public  ResponseEntity<Parent> viewParent(@PathVariable Integer parentId)throws ParentNotFoundException
	{
		LOGGER.trace("Entering into method viewParent.");
		
		
		
		Parent pa= parentServ.getParentById(parentId).orElseThrow(()-> new ParentNotFoundException("Parent does not exist with id"+parentId));
		if(pa!=null)
		{
			LOGGER.info("Parent profile viewed successfully..");
			return new ResponseEntity<Parent>(pa, HttpStatus.OK);
		}
		
		LOGGER.error("Error: Parent not found...");
		return new ResponseEntity("No Such Parent Found!", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateParent")
	public ResponseEntity<Parent> updateParent(@Valid @RequestParam("id") Integer id,@RequestBody Parent parent)throws ParentNotFoundException
	{
		LOGGER.trace("Entering into method updateParent.");
		
		
		Parent pa =parentServ.getParentById(id).orElseThrow(()-> new ParentNotFoundException("Parent does not exist with id"+id));
		if(pa!=null)
		{
			LOGGER.info("Updating Parent.");
			pa.setFirstName(parent.getFirstName());
			pa.setLastName(parent.getLastName());
			pa.setMobileNo(parent.getMobileNo());
			pa.setAddress(parent.getAddress());
			pa.setEmail(parent.getEmail());
			pa.setUsername(parent.getUsername());
			pa.setPassword(parent.getPassword());
			Parent pa1=parentServ.updateParent(pa);
			if(pa1==null)
			{
				LOGGER.error("Parent info not updated.");
				return new ResponseEntity("Failed to update parent", HttpStatus.NOT_FOUND);
				}
			LOGGER.info("Updated Parent successfully.");
			return new ResponseEntity<Parent>(pa1, HttpStatus.OK);
			}
			
			LOGGER.error("Error: Parent not found..");
			return new ResponseEntity("No Such Parent Found!", HttpStatus.NOT_FOUND);
		}
	@GetMapping("/viewAllTutor")
	public List<Tutor> viewAllTutor(){
		LOGGER.trace("Entering into method viewAllTutor");
		
		LOGGER.info("Tutor list is displayed..");
		return parentServ.viewAllTutor();
	}
	
	@GetMapping("/viewEbook")
	public List<Ebook> viewEbook(){
		LOGGER.trace("Entering into method viewEbook");
		
		LOGGER.info("Ebook list displayed..");
		return parentServ.viewEbook();
	}
	
	@PostMapping("/giveFeedback/{parentId}")
	public ResponseEntity<Feedback> giveFeedback(@PathVariable int parentId,@RequestBody Feedback feedback)
	{
		LOGGER.trace("Entering into method giveFeedback");
		
		Feedback add=parentServ.giveFeedback(feedback,parentId);
		if(add!=null)
		{
			LOGGER.info("Feedback added..");
			return new ResponseEntity<Feedback>(add, HttpStatus.OK);
		}
		
		LOGGER.error("Error: Feedback not added..");
		return new ResponseEntity("Unable to add a Feedback!", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/demoRequest")
	public ResponseEntity<Request> demoRequest(@RequestBody Request request)
	{
		LOGGER.trace("Entering into method demoRequest");
		
		Request add=parentServ.demoRequest(request);
		if(add!=null)
		{
			LOGGER.info("Requested for demo lecture.");
			return new ResponseEntity<Request>(add, HttpStatus.OK);
		}
		
		LOGGER.error("Error: Unable to request a demo lecture");
		return new ResponseEntity("Unable to request a demo lecture!", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/bookTutor")
	public ResponseEntity<BookedTutor> bookTutor(@RequestBody BookedTutor booking)
	{
		LOGGER.trace("Entering into method bookTutor");
		
		BookedTutor add=parentServ.bookTutor(booking);
		if(add!=null)
		{
			LOGGER.info("Booked Tutor");
			return new ResponseEntity<BookedTutor>(add, HttpStatus.OK);
		}
		
		LOGGER.error("Error: Unable to book a tutor");
		return new ResponseEntity("Unable to book a tutor!", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/getBookedTutors")
	public List<BookedTutor> getBookedTutors(@RequestParam("parentId") int parentId) {
		
		LOGGER.trace("Entering into method getAllRequest");
		
		LOGGER.info("Requests found for Tutor");
		
		return parentServ.getBookedTutors(parentId);
	}
}
