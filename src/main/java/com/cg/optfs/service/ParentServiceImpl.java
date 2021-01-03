package com.cg.optfs.service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Feedback;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.BookedTutorRepository;
import com.cg.optfs.repository.EbookRepository;
import com.cg.optfs.repository.FeedbackRepository;
import com.cg.optfs.repository.ParentRepository;
import com.cg.optfs.repository.RequestRepository;
import com.cg.optfs.repository.TutorRepository;

@Transactional
@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private TutorRepository tutorRepo;
	
	@Autowired
	private EbookRepository ebookRepo;
	
	@Autowired
	private FeedbackRepository feedbackRepo;
	
	@Autowired
	private RequestRepository requestRepo;
	
	@Autowired 
	private BookedTutorRepository bookedRepo;
	@Override
	public Parent loginParent(String username, String password) {
		// TODO Auto-generated method stub
		return parentRepo.loginParent(username,password);
	}

	@Override
	public Parent addParent(Parent parent) {
		// TODO Auto-generated method stub
		parentRepo.save(parent);
		return parent;
	}

	@Override
	public Parent viewParent(Integer parentId) {
		// TODO Auto-generated method stub
		return parentRepo.findById(parentId).get();
	}

	@Override
	public Parent updateParent(Parent parent) {
		// TODO Auto-generated method stub
		parentRepo.save(parent);
		return parent;
	}

	@Override
	public List<Tutor> viewAllTutor() {
		// TODO Auto-generated method stub
		return tutorRepo.findAll();
	}

	@Override
	public Parent getParentById(Integer id) {
		// TODO Auto-generated method stub
		return parentRepo.findById(id).get();
	}

	@Override
	public List<Ebook> viewEbook() {
		// TODO Auto-generated method stub
		return ebookRepo.findAll();
	}

	@Override
	public Feedback giveFeedback(Feedback feedback, int parentId) {
		// TODO Auto-generated method stub
		Parent parent=parentRepo.getOne(parentId);
		Feedback feed=new Feedback();
		feed.setTutorId(feedback.getTutorId());
		feed.setRating(feedback.getRating());
		feed.setParent(parent);
		Feedback addFeedback=feedbackRepo.save(feed);
		return addFeedback;
	}

	@Override
	public Request demoRequest(Request request, int parentId) {
		// TODO Auto-generated method stub
		Parent parent=parentRepo.getOne(parentId);
		Request demo=new Request();
		demo.setTutorID(request.getTutorID());
		demo.setSubject(request.getSubject());
		demo.setLocalDate(request.getLocalDate());
		demo.setLocalTime(request.getLocalTime());
		demo.setLocalDateTime(request.getLocalDateTime());
		demo.setParent(parent);
		Request addDemo=requestRepo.save(demo);
		return addDemo;
	}

	@Override
	public BookedTutor bookTutor(BookedTutor booking, int parentId) {
		// TODO Auto-generated method stub
		Parent parent=parentRepo.getOne(parentId);
		BookedTutor booking1=new BookedTutor();
		booking1.setTutorId(booking.getTutorId());
		booking1.setSubject(booking.getSubject());
		booking1.setLocalDate(booking.getLocalDate());
		booking1.setLocalTime(booking.getLocalTime());
		booking1.setLocalDateTime(booking.getLocalDateTime());
		booking1.setParent(parent);
		BookedTutor addBooking=bookedRepo.save(booking1);
		return addBooking;
	}

}