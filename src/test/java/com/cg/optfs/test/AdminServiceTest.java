package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.AdminRepository;
import com.cg.optfs.repository.EbookRepository;
import com.cg.optfs.repository.TutorRepository;
import com.cg.optfs.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {

	@Autowired
	private AdminService adminService;
	
	@MockBean
	private AdminRepository adminRepo;
	
	@MockBean
	private EbookRepository ebookRepo;
	
	@MockBean
	private TutorRepository tutorRepo;
	
	
	@Test
	public void testLoginAdmin() 
	{
		Admin admin = new Admin();
		admin.setAdminId(1);
		admin.setAdminName("Tejas");
		admin.setAdminUsername("tejas");
		admin.setAdminPassword("tejas123");
		
		Mockito.when(adminRepo.loginAdmin("tejas", "tejas123")).thenReturn(admin);

		assertThat(adminService.loginAdmin("tejas", "tejas123")).isEqualTo(admin);
	}
	
	@Test
	public void testAddTutor()
	{
		Tutor tutor = new Tutor();
//		tutor.setTutorId(4);
		tutor.setName("Jayesh");
		tutor.setUsername("jay");
		tutor.setPassword("jay123");
		tutor.setSubject("Maths");
		tutor.setAddress("Boriwali");
		tutor.setPhoneNumber("9090898972");
		tutor.setQualifications("Bsc");
		
		Mockito.when(tutorRepo.save(tutor)).thenReturn(tutor);
		
		assertThat(adminService.addTutor(tutor)).isEqualTo(tutor);
		
	}
	
	@Test
	public void testDeleteTutor()
	{
		Tutor tutor = new Tutor();
		tutor.setTutorId(4);
		tutor.setName("Jayesh");
		tutor.setUsername("jay");
		tutor.setPassword("jay123");
		tutor.setSubject("Maths");
		tutor.setAddress("Boriwali");
		tutor.setPhoneNumber("9090898972");
		tutor.setQualifications("Bsc");
		
		Mockito.when(tutorRepo.getOne((long) 4)).thenReturn(tutor);
		Mockito.when(tutorRepo.existsById(tutor.getTutorId())).thenReturn(false);
		assertFalse(tutorRepo.existsById(tutor.getTutorId()));
		
	}
	
	@Test
	public void testAddEbook()
	{
		Ebook ebook = new Ebook();
		ebook.setTitle("10th Science Part 1");
		ebook.setEbookId(7);
		ebook.setAuthorname("Mumbai University");
		ebook.setUrl("https://drive.google.com/file/d/18OOuNYytMr4j6HQ-iuncZpRHz3vCUVNx/view?usp=sharing");
	
	
		Mockito.when(ebookRepo.save(ebook)).thenReturn(ebook);
		
		assertThat(adminService.addEbook(ebook)).isEqualTo(ebook);
		
	}
	
	
	

}
