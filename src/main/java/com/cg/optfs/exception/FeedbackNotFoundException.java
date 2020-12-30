package com.cg.optfs.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class FeedbackNotFoundException extends Exception{

	public FeedbackNotFoundException(String message) {
		super(message);
	}
	
}
