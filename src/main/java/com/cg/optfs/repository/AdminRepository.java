package com.cg.optfs.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Tutor;

//@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

//	@Query("SELECT a FROM Admin a WHERE a.adminUsername= :username AND a.adminPassword= :password")
	public List<Admin> findByAdminUsernameAndAdminPassword(String username,String password);
	
//	@Param("username") String username, @Param("password") String password
	
	@Query("SELECT a FROM Admin a WHERE a.adminUsername= :username")
	public Admin getAdminByUsername(@Param("username") String username);


	

}

	