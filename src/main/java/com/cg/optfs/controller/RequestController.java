package com.cg.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Request;
import com.cg.optfs.service.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {

	@Autowired
	RequestService service;
	
	@GetMapping(value="/getRequest")
	public ResponseEntity<List<Request>> viewRequest(){
		List<Request> getTraineeList = service.viewRequest();
		if (getTraineeList.isEmpty()) {
			return new ResponseEntity("Request not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Request>>(getTraineeList, HttpStatus.OK);
	}
}
