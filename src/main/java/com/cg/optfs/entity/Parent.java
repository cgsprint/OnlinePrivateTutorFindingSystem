package com.cg.optfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Parent")
public class Parent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="parent_id")
	private int parentId;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="Username")
	private String parentUsername;
	@Column(name="Password")
	private String parentPassword;
	@Column(name="mob_no")
	private String mobileNo;
	@Column
	private String email;
	@Column
	private String address;
	
	public Parent() {
		
	}
	
	public Parent(String firstName, String lastName, String username, String password, String mobileNo,
			String email, String address) {
		super();
//		this.parentId = parentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parentUsername = username;
		this.parentPassword = password;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return parentUsername;
	}
	public void setUsername(String username) {
		this.parentUsername = username;
	}
	public String getPassword() {
		return parentPassword;
	}
	public void setPassword(String password) {
		this.parentPassword = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Parent [parentId=" + parentId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ parentUsername + ", password=" + parentPassword + ", mobileNo=" + mobileNo + ", email=" + email + ", address="
				+ address + "]";
	}
}
