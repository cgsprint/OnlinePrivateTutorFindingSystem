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
	
	@ExceptionHandler(RequestNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleRequestNotFoundException(RequestNotFoundException ex)
	{
		ExceptionResponse er = new ExceptionResponse();
		er.setErrorCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EbookNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleEbookNotFoundException(EbookNotFoundException ex)
	{
		ExceptionResponse er = new ExceptionResponse();
		er.setErrorCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookedTutorNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleBookedTutorNotFoundException(BookedTutorNotFoundException ex)
	{
		ExceptionResponse er = new ExceptionResponse();
		er.setErrorCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleBookingNotFoundException(BookingNotFoundException ex)
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
	
	@ExceptionHandler(ParentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleParentNotFoundException(ParentNotFoundException ex)
	{
		ExceptionResponse er = new ExceptionResponse();
		er.setErrorCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
}
