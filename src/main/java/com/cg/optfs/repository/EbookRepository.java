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
	public Ebook getEbookbyTitle(@Param("title") String title);
	
	@Query("SELECT ebook FROM Ebook ebook WHERE ebook.authorname= :authorname")
	public Ebook getEbookbyAuthor(@Param("authorname") String authorname);

}
