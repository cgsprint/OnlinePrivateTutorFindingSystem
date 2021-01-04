package com.cg.optfs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin entity class
 * @author TEJAS HATLE
 * 
 */
@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	private int adminId;
	
	
	private String adminName;
	private String adminUsername;
	private String adminPassword;
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String adminName, String adminUsername, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminUsername=" + adminUsername
				+ ", adminPassword=" + adminPassword + "]";
	}
	
	
	
	

}
