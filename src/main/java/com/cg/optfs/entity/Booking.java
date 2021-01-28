package com.cg.optfs.entity;

import java.time.LocalDate;
import java.time.LocalTime;
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
	private int bookingId;
	
	@Column(name = "parentId")
	private int parentId;
	
	@Column(name="parentName", length=10)
	private String parentName;
	
	@Column(name="tutorId", length=10)
	private int tutorId;
	
	@Column(name = "subject")
	private String subject;

	@Column(name = "local_time", columnDefinition = "TIME")
	private LocalTime localTime;

	@Column(name = "local_date", columnDefinition = "DATE")
	private LocalDate localDate;

	
	

	


	public Booking(int bookingId, int parentId, String parentName, int tutorId, String subject, LocalTime localTime,
			LocalDate localDate) {
		super();
		this.bookingId = bookingId;
		this.parentId = parentId;
		this.parentName = parentName;
		this.tutorId = tutorId;
		this.subject = subject;
		this.localTime = localTime;
		this.localDate = localDate;
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
	
	
	

	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public int getTutorId() {
		return tutorId;
	}


	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}


	public LocalTime getLocalTime() {
		return localTime;
	}


	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}


	public LocalDate getLocalDate() {
		return localDate;
	}


	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", parentId=" + parentId + ", parentName=" + parentName
				+ ", tutorId=" + tutorId + ", subject=" + subject + ", localTime=" + localTime + ", localDate="
				+ localDate + "]";
	}


	
	
}
