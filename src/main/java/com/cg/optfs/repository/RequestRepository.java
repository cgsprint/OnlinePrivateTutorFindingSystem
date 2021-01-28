package com.cg.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.cg.optfs.entity.Request;

public interface RequestRepository  extends JpaRepository<Request, Integer>{

	List<Request> findByTutorId(int tutorId);


	//@Query("SELECT request.requestId FROM Request request WHERE request.subject>= : sub")
	//public List<Request> getRequestList();

}
