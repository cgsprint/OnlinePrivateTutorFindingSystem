package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

import com.cg.optfs.entity.Request;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.RequestRepository;
import com.cg.optfs.repository.TutorRepository;
import com.cg.optfs.service.RequestService;
import com.cg.optfs.service.TutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorServiceTest {

	@Autowired
	private TutorService tutorService;

	@MockBean
	private TutorRepository tutorRepo;
	@MockBean
	private RequestRepository requestRepo;
	@Autowired
	private RequestService requestService;
	
	@Test
	public void testLoginTutor() 
	{
		Tutor tutor = new Tutor();
		tutor.setUsername("man43");
		tutor.setPassword("man435");
		tutor.setName("Manoj");
		tutor.setSubject("MAths");
		tutor.setQualifications("BscIt");
		tutor.setAddress("thane");
		
		Mockito.when(tutorRepo.loginTutor("man43", "man435")).thenReturn((List<Tutor>) tutor);

		assertThat(tutorService.loginTutor("man43", "man435")).isEqualTo(tutor);
	}

	@Test
	public void testUpdateProfile() {

		Tutor tutor = new Tutor();
		tutor.setUsername("man43");
		tutor.setPassword("man43");
		tutor.setName("man43");
		tutor.setSubject("man43");
		tutor.setQualifications("man43");
		tutor.setAddress("thane");

		Mockito.when(tutorRepo.save(tutor)).thenReturn(tutor);

		assertThat(tutorService.updateProfile(tutor)).isEqualTo(tutor);

	}


	@Test
	public void testViewTutor() {

		Tutor tutor = new Tutor();
		tutor.setUsername("man43");
		tutor.setPassword("man435");
		tutor.setName("Mnaoj");
		tutor.setSubject("English");
		tutor.setQualifications("Bsc");
		tutor.setAddress("Bhiwandi");
		
		Mockito.when(tutorRepo.getOne((long) 1)).thenReturn(tutor);
		Mockito.when(tutorRepo.existsById(tutor.getTutorId())).thenReturn(false);
	    assertFalse(tutorRepo.existsById(tutor.getTutorId()));

		
	}

	@Test
	public void testGetAllRequest() {
		// when(requestRepo.findAll()).thenReturn(Stream.of(new Request()))

		List<Request> list = new ArrayList<>();
		Mockito.when(requestRepo.findAll()).thenReturn(list);
		assertThat(requestService.viewRequest()).isEqualTo(list);

	}
	
	
	@Test
	public void testFailLoginTutor() 
	{
		Tutor tutor = new Tutor();
		tutor.setUsername("man433");
		tutor.setPassword("man435");
		tutor.setName("Manoj");
		tutor.setSubject("Maths");
		tutor.setQualifications("BSc");
		tutor.setAddress("thane");
		
		Mockito.when(tutorRepo.loginTutor("man43", "man435")).thenReturn(null);

		assertThat(tutorService.loginTutor("man43", "man435")).isNull();
	}

}
