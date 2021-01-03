package com.cg.optfs.repository.test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Tutor;
import com.cg.optfs.repository.EbookRepository;
import com.cg.optfs.repository.TutorRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
class AdminRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TutorRepository tutorRepo;
	
	@Autowired
	private EbookRepository ebookRepo;
	
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testSaveTutor()
	{
		Tutor tutor = getTutor();
		Tutor savedTutor = entityManager.persist(tutor);
		Tutor getFromDb = tutorRepo.getOne(savedTutor.getTutorId());
		
		assertThat(getFromDb).isEqualTo(savedTutor);
		
	}
	
	@Test
	@Rollback(false)
	@Order(2)
	public void testDeleteTutor()
	{
		Tutor tutor = getTutor();
		entityManager.remove(tutor);

		assertThat(tutor.getTutorId()).isZero();
	}
	
	@Test
	@Rollback(false)
	@Order(3)
	public void testSaveEbook()
	{
		Ebook ebook = getEbook();
		Ebook savedEbook = entityManager.persist(ebook);
		Ebook getFromDb = ebookRepo.getOne(savedEbook.getEbookId());
		
		assertThat(getFromDb).isEqualTo(savedEbook);
		
	}
	
	@Test
	@Order(4)
	public void testViewAllEbooks()
	{
		List<Ebook> ebookList = ebookRepo.findAll();
		assertNotNull(ebookList);
		assertThat(ebookList).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(5)
	public void testDeleteEbook()
	{
		Ebook ebook = new Ebook();
		entityManager.remove(ebook);

		assertThat(ebook.getEbookId()).isZero();
	}
	
	
	
	private Tutor getTutor()
	{
		Tutor tutor = new Tutor();
		tutor.setName("Vijay");
		tutor.setUsername("vijay");
		tutor.setPassword("vijay123");
		tutor.setAddress("Jogeshwari");
		tutor.setPhoneNumber("9090808998");
		tutor.setQualifications("Bcom");
		tutor.setSubject("Science");
		return tutor;
	}
	
	private Ebook getEbook()
	{
		Ebook ebook = new Ebook();
		ebook.setTitle("10th Maths Part-1");
		ebook.setAuthorname("Mumbai University");
		ebook.setUrl("https://drive.google.com/file/d/1J1jwYr_VpSVxD8mquw6GPjh_Ws-9xPQf/view?usp=sharing");
		return ebook;
	}

}
