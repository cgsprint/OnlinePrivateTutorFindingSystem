package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.RequestRepository;
import com.cg.optfs.repository.TutorRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class TutorRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TutorRepository  tutorRepo ;
	@Autowired
	private RequestRepository  requestRepo ;
	
	
	
		@Test
		public void testUpdateTutor() 
		{
			Tutor tutor=new Tutor();
			tutor.setUsername("man43");
			tutor.setPassword("man43");
			tutor.setName("man43");
			tutor.setSubject("man43");
			tutor.setQualifications("man43");
			tutor.setAddress("thane");
		    
		    Tutor savedInDB=entityManager.persist(tutor);
		    Tutor getFromDb = tutorRepo.getOne(savedInDB.getTutorId());
			
			assertThat(getFromDb).isEqualTo(savedInDB);
		}
	
	
	//@Test
	public void testGetAllRequest()
	{
		//Request request=new Request();
		/*
*/
	    
	    Iterable<Request> allEbookFromDb=requestRepo.findAll();
	    List<Request>userList=new ArrayList<>();
	    
	    for(Request request:allEbookFromDb) 
	    {
	    	userList.add(request);
	    }
	    
	    assertThat(userList.size()).isGreaterThan(0);
	    
	}
	
	@Test
	public void testViewTutor() 
	{
		Tutor tutor=new Tutor();
		tutor.setUsername("man43");
		tutor.setPassword("man43");
		tutor.setName("man43");
		tutor.setSubject("man43");
		tutor.setQualifications("man43");
		tutor.setAddress("thane");
	    
	    Tutor savedInDB=entityManager.persist(tutor);
		Tutor getFromDB=tutorRepo.findById(savedInDB.getTutorId()).get();
		assertThat(getFromDB).isEqualTo(savedInDB);
	}
	

}
