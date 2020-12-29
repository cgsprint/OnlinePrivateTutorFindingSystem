package com.cg.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Ebook;
import com.cg.optfs.service.EbookService;

@RestController
@RequestMapping(value="/Ebook")
public class EbookController {

	@Autowired
	EbookService eservice;
	
	@PostMapping(value="/addEbook")
	public ResponseEntity<Ebook> addEbook(@RequestParam("title") String title, @RequestParam("authorname") String authorname, @RequestParam("url") String url) 
	{
		Ebook addEbook= eservice.addEbook(title, authorname, url);
		if (addEbook == null) {
			return new ResponseEntity("Ebook not added", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Ebook>(addEbook, HttpStatus.OK);
	}
	
	@GetMapping(value="/getebook/{ebookId}")
	public ResponseEntity<Ebook> getEbook(@PathVariable("ebookId") int ebookId)
	{
		Ebook getEbook= eservice.getEbook(ebookId);
		if (getEbook == null) {
			return new ResponseEntity("Ebook not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Ebook>(getEbook, HttpStatus.OK);
	}
	
	@GetMapping(value="/deleteEbook")
	public ResponseEntity<Ebook> removeEbook(@RequestParam("ebookId") int ebookId)
	{
		Ebook removeEbook= eservice.removeEbook(ebookId);
		if (removeEbook == null) {
			return new ResponseEntity("No Such Ebook Found with this ebookId!", HttpStatus.NOT_FOUND);
		}

		return new  ResponseEntity<Ebook>(removeEbook, HttpStatus.OK);
	}
	
	@PostMapping(value="/updateEbook")
	public ResponseEntity<Ebook> updateEbook(@RequestBody Ebook ebook)
	{
		Ebook updateEbook= eservice.updateEbook(ebook);
		if (updateEbook == null) {
			return new ResponseEntity("No Such Ebook Found!", HttpStatus.NOT_FOUND);
		}

		return new  ResponseEntity<Ebook>(updateEbook, HttpStatus.OK);
	}
	
	@GetMapping(value="/getEbooklist")
	public ResponseEntity<List<Ebook>> getEbooklist()
	{
		List<Ebook> getEbooklist= eservice.getEbooklist();
		if (getEbooklist.isEmpty()) {
			return new ResponseEntity("Ebooks not Found", HttpStatus.NOT_FOUND);
		}

		return new  ResponseEntity<List<Ebook>>(getEbooklist, HttpStatus.OK);
	}
	
	@GetMapping(value="/getEbook/{title}")
	public ResponseEntity<List<Ebook>> getEbookbyTitle(@PathVariable("title") String title)
	{
		List<Ebook> getEbookbyTitle= eservice.getEbookbyTitle(title);
		
		return new  ResponseEntity<List<Ebook>>(getEbookbyTitle, HttpStatus.OK);
	}
}
