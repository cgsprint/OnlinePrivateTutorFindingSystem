package com.cg.optfs.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public BookingNotFoundException(String message) {
		super(message);
	}
}
