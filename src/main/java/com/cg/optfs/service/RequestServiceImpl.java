package com.cg.optfs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Request;
import com.cg.optfs.repository.RequestRepository;

@Service
@Transactional
public class RequestServiceImpl implements RequestService{

	@Autowired
	RequestRepository requestRepo;
	
	@Override
	public List<Request> getRequestList(){
		List<Request> req= requestRepo.findAll();
		return req;
	}

	
}
