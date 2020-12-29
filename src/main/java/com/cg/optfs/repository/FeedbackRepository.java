package com.cg.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.optfs.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{


	@Query("SELECT feedback FROM Feedback feedback WHERE feedback.tutorId= :tutorId")
	public List<Feedback> getFeedback(@Param("tutorId") int tutorId);

}
