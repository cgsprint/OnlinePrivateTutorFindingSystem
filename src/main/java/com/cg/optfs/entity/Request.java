package com.cg.optfs.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="requestId", length=10)
	private int requestID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "parent_id"), name = "parentId")
	@JsonIgnore
	private Parent parent;

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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
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

	public Request(int requestID, Parent parent, int tutorID, String subject, LocalTime localTime, LocalDate localDate,
			LocalDateTime localDateTime) {
		super();
		this.requestID = requestID;
		this.parent = parent;
		this.tutorID = tutorID;
		this.subject = subject;
		this.localTime = localTime;
		this.localDate = localDate;
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "Request [requestID=" + requestID + ", parent=" + parent + ", tutorID=" + tutorID + ", subject="
				+ subject + ", localTime=" + localTime + ", localDate=" + localDate + ", localDateTime=" + localDateTime
				+ "]";
	}

	
	
	
	
}
