package com.cg.optfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.optfs.entity.Tutor;
@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {

}
