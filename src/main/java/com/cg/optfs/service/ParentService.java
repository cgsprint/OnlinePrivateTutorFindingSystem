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
	/**
	 * This method is used to validate parent with login credentials
	 * @param username
	 * @param password
	 * @return parent
	 * @author SHRUTIKA
	 */
	public List<Parent> loginParent(String username, String password);
	/**
	 * This method is used to add a parent
	 * @param parent
	 * @return parent
	 * @author SHRUTIKA
	 */
	public Parent addParent(Parent parent);
	/**
	 * This method is used to view parent by using parent Id
	 * @param parentId
	 * @return parent
	 * @author SHRUTIKA
	 */
	public Parent viewParent(Integer parentId);
	/**
	 * This method is used to update a parent using parentId
	 * @param parent
	 * @return parent
	 * @author SHRUTIKA
	 */
	public Parent updateParent(Parent parent);
	/**
	 * This method is used to view all the tutors
	 * @return tutor
	 * @author SHRUTIKA
	 */
	public List<Tutor> viewAllTutor();
	/**
	 * This method is used to get the parent using parent Id
	 * @param id
	 * @return parent
	 * @author SHRUTIKA
	 */
	public Optional<Parent> getParentById(Integer id);
	/**
	 * This method is used to view the Ebook
	 * @return Ebook
	 * @author SHRUTIKA
	 */
	public List<Ebook> viewEbook();
	/**
	 * This method is used to give feedback to a tutor using parent ID
	 * @param feedback
	 * @param parentId
	 * @return feedback
	 * @author SHRUTIKA
	 */
	public Feedback giveFeedback(Feedback feedback, int parentId);
	/**
	 * This method is used to request a Demo lecture using parent Id
	 * @param request
	 * @param parentId
	 * @return request
	 * @author SHRUTIKA
	 */
	public Request demoRequest(Request request);
	/**
	 * This method is used to book a tutor using parent Id
	 * @param booking
	 * @param parentId
	 * @return booking
	 * @author SHRUTIKA
	 */
	public BookedTutor bookTutor(BookedTutor booking);
	
	public List<BookedTutor> getBookedTutors(int parentId);

}