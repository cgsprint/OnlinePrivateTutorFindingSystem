package com.cg.optfs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parentId")
	private int parentId;
	
	@Column(name = "subject")
	private String subject;

	
	public Booking(int parentId, String subject) {
		super();
		this.parentId = parentId;
		this.subject = subject;
	}
	

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	

	@Override
	public String toString() {
		return "Booking [parentId=" + parentId + ", subject=" + subject + "]";
	}

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date.toString());
	}
}
