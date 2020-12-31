package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.optfs.entity.Ebook;
import com.cg.optfs.repository.EbookRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class EbookRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EbookRepository  userJpaRepository ;
	@Ignore
	@Test
	public void testAddEbook() 
	{
		Ebook ebook=new Ebook();
		ebook.setTitle("Data Science");
		ebook.setAuthorname("Pro. kale");
		ebook.setUrl("http://man536");
		Ebook savedInDb=entityManager.persist(ebook);
		//Ebook getFromDb=userJpaRepository.findOne(savedInDb.getEbookId());
		
		//assertThat(getFromDb).isEqualTo(savedInDb);
		
	}
	
	
	@Test
	public void testGetAllEbooks()
	{
		Ebook ebook1=new Ebook();
		ebook1.setTitle("Data Science");
		ebook1.setAuthorname("Pro. kale");
		ebook1.setUrl("http://man536");
	    
		Ebook ebook2=new Ebook();
		ebook2.setTitle("Data Science");
		ebook2.setAuthorname("Pro. kale");
		ebook2.setUrl("http://man536");
	    
	    entityManager.persist(ebook1);
	    entityManager.persist(ebook2);
	    
	    Iterable<Ebook> allEbookFromDb=userJpaRepository.findAll();
	    List<Ebook>userList=new ArrayList<>();
	    
	    for(Ebook ebook:allEbookFromDb) 
	    {
	    	userList.add(ebook);
	    }
	    
	    assertThat(userList.size()).isGreaterThan(0);
	    
	}
	
	
}
