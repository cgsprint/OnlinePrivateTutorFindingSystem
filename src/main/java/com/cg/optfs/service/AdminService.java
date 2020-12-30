package com.cg.optfs.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Tutor;


public interface AdminService {
	
	public Admin loginAdmin(String username, String password);

	public Tutor addTutor(Tutor tutor1);

	public Optional<Tutor> getTutorById(Long id);

	/**
	 * This method is used to update tutor 
	 * @return Tutor
	 */
	public Tutor updateTutor(Tutor tu1);

	public void deleteTutor(Tutor tu);

	public Ebook addEbook(Ebook ebook);

	public Optional<Ebook> getEbookById(int id);

	public Ebook updateEbook(Ebook eb);

	public void deleteEbook(Ebook eb);

	
	
}
