package com.cg.optfs.service;

import java.util.List;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;



public interface TutorService {
	public Tutor loginTutor(String username,String password);
	public List<Request> getAllRequests();
	public Tutor viewProfile(long tutorId);
	public Tutor updateProfile(Tutor tutor);
	public List<BookedTutor> getBookedTutor();
	
	
	

}
