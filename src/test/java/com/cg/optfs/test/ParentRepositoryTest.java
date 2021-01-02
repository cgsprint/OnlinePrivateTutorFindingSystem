package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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

import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.ParentRepository;
import com.cg.optfs.repository.TutorRepository;
import com.cg.optfs.service.ParentService;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest

public class ParentRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private TutorRepository tutorRepo;
	
	@Autowired
	private ParentService parentService;
	
	@Test
	public void testAddParent() {
		
		Parent parent=new Parent();
		parent.setFirstName("Manoj");
		parent.setLastName("Chaudhary");
		parent.setUsername("man43");
		parent.setPassword("man453");
		parent.setAddress("Thane");
		parent.setMobileNo("7040760465");
		parent.setEmail("manojc@gmail.com");
		
		Parent savedInDB=entityManager.persist(parent);
		Parent getFromDB=parentRepo.findById(savedInDB.getParentId()).get();
		assertThat(getFromDB).isEqualTo(savedInDB);
		
	}
	
	//@Test
	public void testGetAllTutor() {
		
		Tutor tutor = new Tutor();
		tutor.setUsername("man43");
		tutor.setPassword("man43");
		tutor.setName("man43");
		tutor.setSubject("man43");
		tutor.setQualifications("man43");
		tutor.setAddress("thane");
		
		Tutor tutor1 = new Tutor();
		tutor1.setUsername("man43");
		tutor1.setPassword("man43");
		tutor1.setName("man43");
		tutor1.setSubject("man43");
		tutor1.setQualifications("man43");
		tutor1.setAddress("thane");
		
		 
	    Iterable<Tutor> allEbookFromDb=tutorRepo.findAll();
	    List<Tutor>userList=new ArrayList<>();
	    
	    for(Tutor request:allEbookFromDb) 
	    {
	    	userList.add(request);
	    }
	    
	    assertThat(userList.size()).isGreaterThan(0);
	    
	}
		
	
	
	//@Test
	public void testViewParent() {
		
		Parent parent=new Parent();
		parent.setFirstName("Vinod");
		parent.setLastName("Chaudhary");
		parent.setUsername("vin43");
		parent.setPassword("vin453");
		parent.setAddress("Thane");
		parent.setMobileNo("7040760465");
		parent.setEmail("manojc@gmail.com");
		
		Parent savedInDB=entityManager.persist(parent);
		Parent getFromDB=parentRepo.findById(savedInDB.getParentId()).get();
		assertThat(getFromDB).isEqualTo(savedInDB);
		
	}
	
	//@Test
	public void testUpdateParent() {
		
		Parent parent=new Parent();
		parent.setFirstName("Karan");
		parent.setLastName("Chaudhary");
		parent.setUsername("karan43");
		parent.setPassword("karan453");
		parent.setAddress("Thane");
		parent.setMobileNo("7040760465");
		parent.setEmail("manojc@gmail.com");
		
		Parent savedInDB=entityManager.persist(parent);
		Parent getFromDB=parentRepo.findById(savedInDB.getParentId()).get();
		assertThat(getFromDB).isEqualTo(savedInDB);
		
	}
	

}
