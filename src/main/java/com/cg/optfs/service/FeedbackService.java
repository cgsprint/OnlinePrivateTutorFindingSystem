package com.cg.optfs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Feedback;

@Service
public interface FeedbackService {

	public Feedback addFeedback(int parentId, int tutorId, String rating);
	public Feedback removeFeedback(int feedbackId);
	public List<Feedback> getFeedbacklist();
	public List<Feedback> getFeedback(int tutorId);
}
