package com.cg.optfs.service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.repository.ParentRepository;

@Transactional
@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepository parentRepo;
	
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

}