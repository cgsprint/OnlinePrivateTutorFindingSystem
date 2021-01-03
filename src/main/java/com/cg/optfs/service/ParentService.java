package com.cg.optfs.service;

import java.util.List;
import java.util.Optional;

import com.cg.optfs.entity.BookedTutor;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Feedback;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;

public interface ParentService {

	public Parent loginParent(String username, String password);

	public Parent addParent(Parent parent);

	public Parent viewParent(Integer parentId);

	public Parent updateParent(Parent parent);

	public List<Tutor> viewAllTutor();

	public Parent getParentById(Integer id);

	public List<Ebook> viewEbook();

	public Feedback giveFeedback(Feedback feedback, int parentId);

	public Request demoRequest(Request request, int parentId);

	public BookedTutor bookTutor(BookedTutor booking, int parentId);

}