package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.TutorRepository;
import com.cg.optfs.service.TutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorServiceTest {

	@Autowired
	private TutorService tutorService;

	@MockBean
	private TutorRepository tutorRepo;

	@Test
	public void updateProfile() {

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
    @Ignore
	@Test
	public void viewTutor(long tutorId) {

		Tutor tutor = new Tutor();
		tutor.setUsername("man43");
		tutor.setPassword("man435");
		tutor.setTutorId(tutorId);
		tutor.setName("Mnaoj");
		tutor.setSubject("English");
		tutor.setQualifications("Bsc");
		tutor.setAddress("Bhiwandi");

		Mockito.when(tutorRepo.findById(tutorId).get()).thenReturn(tutor);
 
		assertThat(tutorService.viewProfile(tutorId)).isEqualTo(tutor);

	}
}
