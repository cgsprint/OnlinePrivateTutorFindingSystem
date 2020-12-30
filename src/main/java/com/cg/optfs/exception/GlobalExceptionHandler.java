package com.cg.optfs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TutorNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleTutorNotFoundException(TutorNotFoundException ex)
	{
		ExceptionResponse er = new ExceptionResponse();
		er.setErrorCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
