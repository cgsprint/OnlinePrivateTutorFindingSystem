package com.cg.optfs.service;

import java.util.List;

import com.cg.optfs.entity.Tutor;



public interface TutorService {
	
	public List<Tutor> getAllTutor();
	public Tutor addTutor(Tutor tutor);
	public Tutor updateProfile(Tutor tutor);
	public Tutor getTutorBySubject(Tutor tutor);
	public Tutor deleteTutor(long tutorid);
	

}
