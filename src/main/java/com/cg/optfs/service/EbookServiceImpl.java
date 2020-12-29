package com.cg.optfs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Ebook;
import com.cg.optfs.repository.EbookRepository;

@Service
@Transactional
public class EbookServiceImpl implements EbookService{

	@Autowired
	EbookRepository erepository;

	

	@Override
	public Ebook addEbook(String title, String authorname, String url) {
		// TODO Auto-generated method stub
		Ebook ebook= new Ebook();
		ebook.setTitle(title);
		ebook.setAuthorname(authorname);
		ebook.setUrl(url);
		erepository.save(ebook);
		return null;
	}
	@Override
	public Ebook getEbook(int ebookId) {
		// TODO Auto-generated method stub
		Ebook ebook=erepository.getOne(ebookId);
		return ebook;
	}

	@Override
	public Ebook removeEbook(int ebookId) {
		// TODO Auto-generated method stub
		Ebook ebook=erepository.getOne(ebookId);
		erepository.delete(ebook);
		return ebook;
	}

	@Override
	public Ebook updateEbook(Ebook ebook) {
		// TODO Auto-generated method stub
		erepository.saveAndFlush(ebook);
		return ebook;
	}

	@Override
	public List<Ebook> getEbooklist() {
		// TODO Auto-generated method stub
		List<Ebook> list=erepository.findAll();
		return list;
	}
	@Override
	public List<Ebook> getEbookbyTitle(String title) {
		// TODO Auto-generated method stub
		List<Ebook> elist= erepository.getEbooksbyTitle(title);
		return elist;
	}
	@Override
	public List<String> getEbookbyAuthor(String authorname) {
		// TODO Auto-generated method stub
		List<String> elist= erepository.getEbooksbyAuthor(authorname);
		return elist;
	}

	
}
