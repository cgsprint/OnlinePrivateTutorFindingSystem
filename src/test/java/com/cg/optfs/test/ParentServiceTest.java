package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.optfs.entity.Parent;
import com.cg.optfs.repository.ParentRepository;
import com.cg.optfs.service.ParentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentServiceTest {
     
	@Autowired
	private ParentService parentService;
	@MockBean
	private ParentRepository parentRepo;
	
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
		
		Mockito.when(parentRepo.save(parent)).thenReturn(parent);
		 assertThat(parentService.addParent(parent)).isEqualTo(parent);
	
	}
	
	@Test
	public void testUpdateParent() {
		Parent parent=new Parent();
		parent.setFirstName("Vinod");
		parent.setLastName("Chaudhary");
		parent.setUsername("vin43");
		parent.setPassword("vin43");
		parent.setAddress("Bhiwandi");
		parent.setMobileNo("7040760465");
		parent.setEmail("vinodc@gmail.com");
		
		Mockito.when(parentRepo.save(parent)).thenReturn(parent);
		 assertThat(parentService.addParent(parent)).isEqualTo(parent);
	
	}
	@Ignore
	 @Test
	 public void testGetTutorList() {
	      
			List<Parent> list = new ArrayList<>();
			Mockito.when(parentRepo.findAll()).thenReturn(list);
			assertThat(parentService.viewAllTutor()).isEqualTo(list);
			
		}
	
}