package com.cg.optfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ebook")
public class Ebook {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EbookId")
	private int ebookId;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="AuthorName")
	private String authorname;
	
	@Column(name="Url")
	private String url;

	public Ebook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ebook(int ebookId, String title, String authorname, String url) {
		super();
		this.ebookId = ebookId;
		this.title = title;
		this.authorname = authorname;
		this.url = url;
	}

	public int getEbookId() {
		return ebookId;
	}

	public void setEbookId(int ebookId) {
		this.ebookId = ebookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Ebook [ebookId=" + ebookId + ", title=" + title + ", authorname=" + authorname + ", url=" + url + "]";
	}
	

}
