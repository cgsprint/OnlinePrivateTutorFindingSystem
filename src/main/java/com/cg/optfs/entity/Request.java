package com.cg.optfs.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="requestId", length=10)
	private int requestID;
	@Column(name="parentId", length=10)
	private int parentID;
	@Column(name="tutorId", length=10)
	private int tutorID;
	@Column(name="subject", length=10)
	private String subject;
	@Column(name = "local_time", columnDefinition = "TIME")
	private LocalTime localTime;

	@Column(name = "local_date", columnDefinition = "DATE")
	private LocalDate localDate;

	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime localDateTime;

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public int getTutorID() {
		return tutorID;
	}

	public void setTutorID(int tutorID) {
		this.tutorID = tutorID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int requestID, int parentID, int tutorID, String subject, LocalTime localTime, LocalDate localDate,
			LocalDateTime localDateTime) {
		super();
		this.requestID = requestID;
		this.parentID = parentID;
		this.tutorID = tutorID;
		this.subject = subject;
		this.localTime = localTime;
		this.localDate = localDate;
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", parentID=" + parentID + ", tutorID=" + tutorID + ", subject="
				+ subject + ", localTime=" + localTime + ", localDate=" + localDate + ", localDateTime=" + localDateTime
				+ "]";
	}
	
	
	
	
}
