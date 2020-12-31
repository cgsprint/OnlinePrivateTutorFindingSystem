package com.cg.optfs.service;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Admin loginAdmin(String username, String password) {
		return adminRepo.loginAdmin(username,password);
	}

	@Override
	public Tutor addTutor(Tutor tutor) {
		tutorRepo.save(tutor);
		return tutor;
	}

	@Override
	public Optional<Tutor> getTutorById(Long id) {
		return tutorRepo.findById(id);
		
	}

	
	@Override
	public Tutor updateTutor(Tutor tu1) {
		Tutor tu = tutorRepo.save(tu1);
		return tu;
	}

	
	@Override
	public void deleteTutor(Tutor tu) {
		tutorRepo.delete(tu);
	}

	@Override
	public Ebook addEbook(Ebook ebook) {
		ebookRepo.save(ebook);
		return ebook;
	}

	@Override
	public Optional<Ebook> getEbookById(int id) {
		return ebookRepo.findById(id);
	}

	@Override
	public Ebook updateEbook(Ebook eb) {
		Ebook eb2 = ebookRepo.save(eb);
		return eb2;
	}

	@Override
	public void deleteEbook(Ebook eb) {
		ebookRepo.delete(eb);
	}

	@Override
	public List<Parent> viewParents() {
		List<Parent> parents = parentRepo.findAll();
		return parents;
	}
	
	
}
