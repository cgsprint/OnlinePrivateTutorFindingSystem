package com.cg.optfs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Feedback;
import com.cg.optfs.repository.FeedbackRepository;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService{


    @Autowired
	FeedbackRepository frepository;

	@Override
	public Feedback addFeedback(int parentId, int tutorId, String rating) {
		// TODO Auto-generated method stub
		Feedback feedback= new Feedback();
		//feedback.setParentId(parentId);
		//feedback.setTutorId(tutorId);
		//feedback.setRating(rating);
		frepository.save(feedback);
		return feedback;
	}

	@Override
	public Feedback removeFeedback(int feedbackId) {
		// TODO Auto-generated method stub
		Feedback feedback= frepository.getOne(feedbackId);
		frepository.delete(feedback);
		return feedback;
	}

	@Override
	public List<Feedback> getFeedbacklist() {
		// TODO Auto-generated method stub
		List<Feedback> flist= frepository.findAll();
		return flist;
	}

	@Override
	public List<Feedback> getFeedback(int tutorId) {
		// TODO Auto-generated method stub
		List<Feedback> flist= frepository.getFeedback(tutorId);
		return flist;
	}
	
}
