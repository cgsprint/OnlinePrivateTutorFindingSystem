package com.cg.optfs.service;

import java.util.List;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Booking;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;

/**
 * This Tutor Service Class
 * @author Manoj
 *
 */

public interface TutorService {
	public List<Tutor> loginTutor(String username,String password);
	public List<Request> getAllRequests(int tutorId);
	public Tutor viewProfile(long tutorId);
	public Tutor updateProfile(Tutor tutor);
	public List<BookedTutor> getBooking(int tutorId);
	List<Ebook> getAllEbooks();
	
	
	

}
