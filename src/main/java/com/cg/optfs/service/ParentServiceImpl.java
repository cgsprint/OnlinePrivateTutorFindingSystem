package com.cg.optfs.service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.ParentRepository;
import com.cg.optfs.repository.TutorRepository;

@Transactional
@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private TutorRepository tutorRepo;
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

}