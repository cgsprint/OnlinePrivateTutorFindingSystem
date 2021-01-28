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
/**
 * Request Entity Class
 * @author CHANCHAL
 *
 */
@Entity
@Table(name="Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="requestId", length=10)
	private int requestId;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(foreignKey = @ForeignKey(name = "parent_id"), name = "parentId")
//	@JsonIgnore
//	private Parent parent;

	@Column(name="parentId")
	private int parentId;

	@Column(name="parentName")
	private String parentName;
	
	@Column(name="tutorId")
	private int tutorId;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name = "local_time")
	private String localTime;

	@Column(name = "local_date")
	private String localDate;
	
	

	public Request() {
		super();
		
	}

	public Request(int requestId, int parentId, String parentName, int tutorId, String subject, String localTime,
			String localDate) {
		super();
		this.requestId = requestId;
		this.parentId = parentId;
		this.parentName = parentName;
		this.tutorId = tutorId;
		this.subject = subject;
		this.localTime = localTime;
		this.localDate = localDate;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestID) {
		this.requestId = requestID;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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

	public void setTutorId(int tutorID) {
		this.tutorId = tutorID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLocalTime() {
		return localTime;
	}

	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	public String getLocalDate() {
		return localDate;
	}

	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}

	@Override
	public String toString() {
		return "Request [requestID=" + requestId + ", parentId=" + parentId + ", parentName=" + parentName
				+ ", tutorID=" + tutorId + ", subject=" + subject + ", localTime=" + localTime + ", localDate="
				+ localDate + "]";
	}

	
	

		
}
