package com.cg.optfs.entity;

import java.util.List;

public class MessageEntity {
	
	private String message;
	private int status;
	private List<Admin> adminLst;
	private List<Tutor> tutorLst;
	private List<Parent> parentLst;
	
	
	public MessageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MessageEntity(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}





	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	


	public List<Admin> getAdminLst() {
		return adminLst;
	}


	public void setAdminLst(List<Admin> adminLst) {
		this.adminLst = adminLst;
	}


	public List<Tutor> getTutorLst() {
		return tutorLst;
	}


	public void setTutorLst(List<Tutor> tutorLst) {
		this.tutorLst = tutorLst;
	}


	public List<Parent> getParentLst() {
		return parentLst;
	}


	public void setParentLst(List<Parent> parentLst) {
		this.parentLst = parentLst;
	}


	@Override
	public String toString() {
		return "MessageEntity [message=" + message + ", status=" + status + "]";
	}
	
	
	
	

}
