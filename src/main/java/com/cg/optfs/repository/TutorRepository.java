package com.cg.optfs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cg.optfs.entity.Tutor;
//@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
	
	@Query("SELECT t FROM Tutor t WHERE t.username= :username AND t.password= :password")
	public List<Tutor> loginTutor(@Param("username") String username, @Param("password") String password);

	
	

	

	
	

	


}
