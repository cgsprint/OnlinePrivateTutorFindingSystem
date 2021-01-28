package com.cg.optfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Booking;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.BookedTutorRepository;
import com.cg.optfs.repository.BookingRepository;
import com.cg.optfs.repository.EbookRepository;
import com.cg.optfs.repository.RequestRepository;
import com.cg.optfs.repository.TutorRepository;

/**
 * This is TutorService Implementations Class
 * @author Manoj
 *
 */
@Service
public class TutorServiceImpl implements TutorService{

	@Autowired
	public TutorRepository tutorRepo;
	@Autowired
	public RequestRepository requestRepo;
	@Autowired
	public BookingRepository bookedRepo;
	@Autowired
	public BookedTutorRepository bookedTutorRepo;
	@Autowired
	public EbookRepository ebookRepo;
	
	/**
	 * @param username
	 * @param password
	 * @return Tutor
	 */
	@Override
	public List<Tutor> loginTutor(String username,String password) {
		// TODO Auto-generated method stub
		return tutorRepo.loginTutor(username, password);
	}
     
     /**
      * @param tutor
      * @return Tutor
      */
	@Override
	public Tutor updateProfile(Tutor tutor) {
		// TODO Auto-generated method stub
		return tutorRepo.save(tutor);
	}
	
	 /**
     * @param tutorId
     * @return Tutor
     */
	
	@Override
	public Tutor viewProfile(long tutorId) {
		// TODO Auto-generated method stub
		return tutorRepo.findById(tutorId).get();
	}

	 /**
     * 
     * @return Request
     */
	
	@Override
	public List<Request> getAllRequests(int tutorId) {
		// TODO Auto-generated method stub
		return requestRepo.findByTutorId(tutorId);
	}
	
    /**
     * @return BookedTutor
     */

	@Override
	public List<BookedTutor> getBooking(int tutorId) {
		// TODO Auto-generated method stub
		return bookedTutorRepo.findByTutorId(tutorId);
	}

	@Override
	public List<Ebook> getAllEbooks() {
		// TODO Auto-generated method stub
		return ebookRepo.findAll();
	}

}
