package com.cg.optfs.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.optfs.entity.Ebook;
import com.cg.optfs.repository.EbookRepository;
import com.cg.optfs.service.EbookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EbookServiceTest {
	@Autowired
	private EbookService ebookService;
	@MockBean
	private EbookRepository ebookRepo;

	@Test
	public void testAddEbook() {
		Ebook ebook = new Ebook();
		ebook.setTitle("Data Science");
		ebook.setAuthorname("Pro. kale");
		ebook.setUrl("http://man536");

		Mockito.when(ebookRepo.save(ebook)).thenReturn(ebook);

		// assertThat(ebookService.addEbook("Data Science", "Pro. kale",
		// "http://man536")).isEqualTo(ebook);

		assertEquals("Data Science", ebook.getTitle());
	}

	
	@Test
	public void testGetByTitleEbook() {

		Ebook ebook = new Ebook();
		ebook.setTitle("Data");
		ebook.setAuthorname("Pro. kale");
		ebook.setUrl("http://man536");

		Mockito.when(ebookRepo.getEbookbyTitle("Data")).thenReturn(ebook);
		 assertThat(ebookService.getEbookbyTitle("Data")).isEqualTo(ebook);
		

	}
	
	
	@Test
	public void testGetByAuthorEbook() {

		Ebook ebook = new Ebook();
		ebook.setTitle("Data");
		ebook.setAuthorname("Kale");
		ebook.setUrl("http://man536");

		Mockito.when(ebookRepo.getEbookbyAuthor("Kale")).thenReturn(ebook);
		 assertThat(ebookService.getEbookbyAuthor("Kale")).isEqualTo(ebook);
		

	}
	
	@Test
	public void testUpdateEbook() {

		Ebook ebook = new Ebook();
		ebook.setTitle("Data Science");
		ebook.setAuthorname("Pro. kale");
		ebook.setUrl("http://man536");

		Mockito.when(ebookRepo.save(ebook)).thenReturn(ebook);
		 assertThat(ebookService.updateEbook(ebook)).isEqualTo(ebook);
		

	}
	
    @Test
	public void testGetEbookList() {
      
		List<Ebook> list = new ArrayList<>();
		Mockito.when(ebookRepo.findAll()).thenReturn(list);
		assertThat(ebookService.getEbooklist()).isEqualTo(list);
		
	}

}