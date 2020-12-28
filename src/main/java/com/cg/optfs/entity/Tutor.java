package com.cg.optfs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TUTOR")
public class Tutor {
    @Id
	private long  tutorId;
    private String username;
    private String password;
	private String name;
	private String subject;
	private String phoneNumber;
	private String address;
	public String qualifications;
	
	public long getTutorId() {
		return tutorId;
	}
	public void setTutorId(long tutorId) {
		this.tutorId = tutorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Tutor(long tutorId, String name, String subject, String phoneNumber, String address, String qualifications) {
		super();
		this.tutorId = tutorId;
		this.name = name;
		this.subject = subject;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.qualifications = qualifications;
	}
	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tutor [tutorId=" + tutorId + ", name=" + name + ", subject=" + subject + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", qualifications=" + qualifications + "]";
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	
	

}

