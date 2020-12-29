package com.cg.optfs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TUTOR")
public class Tutor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long  tutorId;
    private String name;
    private String username;
    private String password;
	private String subject;
	private String phoneNumber;
	private String address;
	private String qualifications;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="rId",referencedColumnName="tutorId")
    private List<Request> requestList;
	
	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tutor(long tutorId, String username, String password, String name, String subject, String phoneNumber,
			String address, String qualifications, List<Request> requestList) {
		super();
		this.tutorId = tutorId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.subject = subject;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.qualifications = qualifications;
		this.requestList = requestList;
	}
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	public List<Request> getRequestList() {
		return requestList;
	}
	public void setRequestList(List<Request> requestList) {
		this.requestList = requestList;
	}
	
	@Override
	public String toString() {
		return "Tutor [tutorId=" + tutorId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", subject=" + subject + ", phoneNumber=" + phoneNumber + ", address=" + address + ", qualifications="
				+ qualifications + ", requestList=" + requestList + "]";
	}

}

