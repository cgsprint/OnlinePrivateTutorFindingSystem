package com.cg.optfs.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.AdminRepository;
import com.cg.optfs.repository.EbookRepository;
import com.cg.optfs.repository.ParentRepository;
import com.cg.optfs.repository.TutorRepository;

/**
 * This is AdminServiceImpl class 
 * @author TEJAS HATLE
 *
 */

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private TutorRepository tutorRepo;

	@Autowired
	private EbookRepository ebookRepo;
	
	@Autowired
	private ParentRepository parentRepo;
	
	// ===================================================
	// 					Login admin
	// ===================================================
	@Override
	public List<Admin> loginAdmin(String username, String password) {
		return adminRepo.findByAdminUsernameAndAdminPassword(username,password);
	}

	// ===================================================
	// 					Add tutor
	// ===================================================
	@Override
	public Tutor addTutor(Tutor tutor) {
		tutorRepo.save(tutor);
		return tutor;
	}

	// ===================================================
	// 					get Tutor By id
	// ===================================================
	@Override
	public Optional<Tutor> getTutorById(Long id) {
		return tutorRepo.findById(id);
		
	}


	// ===================================================
	// 					Update tutor
	// ===================================================
	@Override
	public Tutor updateTutor(Tutor tu1) {
		Tutor tu = tutorRepo.save(tu1);
		return tu;
	}

	// ===================================================
	// 			delete tutor using tutor entity
	// ===================================================
	@Override
	public List<Tutor> deleteTutor(Tutor tu) {
		tutorRepo.delete(tu);
		List<Tutor> tutors = tutorRepo.findAll();
		return tutors;
	}

	// ===================================================
	// 					Add ebook
	// ===================================================
	@Override
	public Ebook addEbook(Ebook ebook) {
		ebookRepo.save(ebook);
		return ebook;
	}

	// ===================================================
	// 					get ebook by id
	// ===================================================
	@Override
	public Optional<Ebook> getEbookById(int id) {
		return ebookRepo.findById(id);
	}

	
	// ===================================================
	// 					update ebook
	// ===================================================
	@Override
	public Ebook updateEbook(Ebook eb) {
		Ebook eb2 = ebookRepo.save(eb);
		return eb2;
	}

	// ===================================================
	// 					delete ebook
	// ===================================================
	@Override
	public List<Ebook> deleteEbook(Ebook eb) {
		ebookRepo.delete(eb);
		List<Ebook> ebooks = ebookRepo.findAll();
		return ebooks;
	}

	
	// ===================================================
	// 					view parents
	// ===================================================
	@Override
	public List<Parent> viewParents() {
		List<Parent> parents = parentRepo.findAll();
		return parents;
	}

	@Override
	public Admin getAdminByUsername(@Valid String username) {
		Admin admin = adminRepo.getAdminByUsername(username);
		return admin;
	}

	@Override
	public List<Tutor> viewTutors() {
		List<Tutor> tutors = tutorRepo.findAll();
		return tutors;
	}

	@Override
	public List<Ebook> viewEbook() {
		List<Ebook> ebooks = ebookRepo.findAll();
		return ebooks;
	}
	
	
}
