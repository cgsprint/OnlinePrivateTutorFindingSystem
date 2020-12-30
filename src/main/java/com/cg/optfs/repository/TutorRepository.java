package com.cg.optfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cg.optfs.entity.Tutor;
@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
	
	@Query("SELECT t FROM Tutor t WHERE t.tutorUsername= :username AND t.tutorPassword= :password")
	public Tutor loginTutor(@Param("username") String username, @Param("password") String password);


}
