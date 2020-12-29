package com.cg.optfs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.repository.BookedTutorRepository;

@Service
@Transactional
public class BookedTutorServiceImpl  implements BookedTutorService {

	@Autowired
	BookedTutorRepository bookedtutorRepo;

	@Override
	public List<BookedTutor> viewBookedTutor() {
		List<BookedTutor> bookt=bookedtutorRepo.findAll();
		return bookt ;
	}

	
	
	

}
