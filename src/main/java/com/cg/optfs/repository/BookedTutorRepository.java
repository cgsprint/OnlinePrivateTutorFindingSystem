package com.cg.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import com.cg.optfs.entity.BookedTutor;



public interface BookedTutorRepository extends JpaRepository<BookedTutor, Integer>{

//	@Query("SELECT t FROM BookedTutor t WHERE t.tutorId= :tId")
	List<BookedTutor> findByTutorId(int tutorId);

	List<BookedTutor> findByParentId(int parentId);

	//@Query("SELECT bookedtutor.parentId FROM BookedTutor bookedtutor WHERE bookedtutor.subject>= : sub")
	//public List<BookedTutor> getBookedTutorList();
}
