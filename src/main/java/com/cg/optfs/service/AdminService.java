package com.cg.optfs.service;

import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Tutor;


public interface AdminService {
	
	public Admin loginAdmin(String username, String password);

	public Tutor addTutor(Tutor tutor1);
	
	
}
