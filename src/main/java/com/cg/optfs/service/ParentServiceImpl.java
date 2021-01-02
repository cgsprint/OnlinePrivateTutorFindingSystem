package com.cg.optfs.service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Feedback;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.EbookRepository;
import com.cg.optfs.repository.FeedbackRepository;
import com.cg.optfs.repository.ParentRepository;
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

}