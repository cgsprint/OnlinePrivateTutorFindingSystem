package com.cg.optfs.service;

import java.util.List;

import com.cg.optfs.entity.Tutor;



public interface TutorService {
	
	//public List<Tutor> getAllRequests();
	public Tutor viewProfile(long tutorId);
	public Tutor updateProfile(Tutor tutor);
	
	
	

}
