package com.cg.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.optfs.entity.Ebook;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Integer>{

	@Query("SELECT ebook FROM Ebook ebook WHERE ebook.title= :title")
	public List<Ebook> getEbooksbyTitle(@Param("title") String title);
	
	@Query("SELECT ebook.title FROM Ebook ebook WHERE ebook.authorname= :authorname")
	public List<String> getEbooksbyAuthor(@Param("authorname") String authorname);
   
	
	
}
