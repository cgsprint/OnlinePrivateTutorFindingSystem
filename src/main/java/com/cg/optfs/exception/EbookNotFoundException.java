package com.cg.optfs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class EbookNotFoundException extends Exception{

	
	public EbookNotFoundException(String message)
	{
		super(message);
	}

}
