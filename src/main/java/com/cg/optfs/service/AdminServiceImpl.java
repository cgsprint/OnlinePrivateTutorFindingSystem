package com.cg.optfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.AdminRepository;
import com.cg.optfs.repository.TutorRepository;


@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private TutorRepository tutorRepo;

	@Override
	public Admin loginAdmin(String username, String password) {
		return adminRepo.loginAdmin(username,password);
	}

	@Override
	public Tutor addTutor(Tutor tutor) {
		tutorRepo.save(tutor);
		return tutor;
	}
	
	
}
