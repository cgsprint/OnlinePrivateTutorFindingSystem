package com.cg.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.optfs.entity.Booking;
import com.cg.optfs.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

		@Autowired
		BookingService service;
		
		@GetMapping(value="/getBooking")
		public ResponseEntity<List<Booking>> viewBooking(){
			List<Booking> viewBooking = service.viewBooking();
			if (viewBooking.isEmpty()) {
				return new ResponseEntity("Booking not found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Booking>>(viewBooking, HttpStatus.OK);

			
		}
		
		
	}
