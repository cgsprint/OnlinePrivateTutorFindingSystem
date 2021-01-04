package com.cg.optfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.BookedTutorRepository;
import com.cg.optfs.repository.RequestRepository;
import com.cg.optfs.repository.TutorRepository;
@Service
public class TutorServiceImpl implements TutorService{

	@Autowired
	public TutorRepository tutorRepo;
	@Autowired
	public RequestRepository requestRepo;
	@Autowired
	public BookedTutorRepository bookedRepo;
	
	@Override
	public Tutor loginTutor(String username,String password) {
		// TODO Auto-generated method stub
		return tutorRepo.loginTutor(username, password);
	}


	@Override
	public Tutor updateProfile(Tutor tutor) {
		// TODO Auto-generated method stub
		return tutorRepo.save(tutor);
	}

	@Override
	public Tutor viewProfile(long tutorId) {
		// TODO Auto-generated method stub
		return tutorRepo.findById(tutorId).get();
	}

	@Override
	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return requestRepo.findAll();
	}


	@Override
	public List<BookedTutor> getBookedTutor() {
		// TODO Auto-generated method stub
		return bookedRepo.findAll();
	}

}
