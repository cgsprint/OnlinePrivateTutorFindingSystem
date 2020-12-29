package com.cg.optfs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Ebook;

@Service
public interface EbookService {

	public Ebook addEbook(String title, String authorname, String url);
	public Ebook getEbook(int ebookId);
	public Ebook removeEbook(int ebookId);
	public Ebook updateEbook(Ebook ebook);
	public List<Ebook> getEbooklist();
	public List<Ebook> getEbookbyTitle(String title);
	public List<String> getEbookbyAuthor(String authorname);

}
