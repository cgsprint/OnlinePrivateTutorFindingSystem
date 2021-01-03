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
@Table(name="BookedTutor")
public class BookedTutor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookedId", length=10)
	private int bookedId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "parent_id"), name = "parentId")
	@JsonIgnore
	private Parent parent;
	
	@Column(name="tutorId", length=10)
	private int tutorId;
	@Column(name="subject", length=10)
	private String subject;
	@Column(name = "local_time", columnDefinition = "TIME")
	private LocalTime localTime;

	@Column(name = "local_date", columnDefinition = "DATE")
	private LocalDate localDate;

	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime localDateTime;

	public int getBookedId() {
		return bookedId;
	}

	public void setBookedId(int bookedId) {
		this.bookedId = bookedId;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
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

	public BookedTutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookedTutor(int bookedId, Parent parent, int tutorId, String subject, LocalTime localTime,
			LocalDate localDate, LocalDateTime localDateTime) {
		super();
		this.bookedId = bookedId;
		this.parent = parent;
		this.tutorId = tutorId;
		this.subject = subject;
		this.localTime = localTime;
		this.localDate = localDate;
		this.localDateTime = localDateTime;
	}

	@Override
	public String toString() {
		return "BookedTutor [bookedId=" + bookedId + ", parent=" + parent + ", tutorId=" + tutorId + ", subject="
				+ subject + ", localTime=" + localTime + ", localDate=" + localDate + ", localDateTime=" + localDateTime
				+ "]";
	}
	
	
	
	
	
}
