package com.cg.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.optfs.entity.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Integer> {
	
	@Query("SELECT p FROM Parent p WHERE p.username= :username AND p.password= :password")
	public List<Parent> loginParent(@Param("username") String username, @Param("password") String password);

}
