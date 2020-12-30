package com.cg.optfs.exception;

public class ExceptionResponse {
	
	private int errorCode;
	private String errorMessage;
	
	
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ExceptionResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
