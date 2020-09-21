package com.smart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id ;
	
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="user_role")
	private String userRole;
	
	@Column(name="vfsso_username")
	private String vfssoUserName;
	
	@Column(name="vfsso_status")
	private String vfssoStatus;
	
	@Column(name="contact_id")
	private String contactId;

	public User() {
	}
	
	public User(String customerId, String userRole, String vfssoUserName, String vfssoStatus, String contactId) {
		this.customerId = customerId;
		this.userRole = userRole;
		this.vfssoUserName = vfssoUserName;
		this.vfssoStatus = vfssoStatus;
		this.contactId = contactId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getVfssoUserName() {
		return vfssoUserName;
	}

	public void setVfssoUserName(String vfssoUserName) {
		this.vfssoUserName = vfssoUserName;
	}

	public String getVfssoStatus() {
		return vfssoStatus;
	}

	public void setVfssoStatus(String vfssoStatus) {
		this.vfssoStatus = vfssoStatus;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", customerId=" + customerId + ", userRole=" + userRole + ", vfssoUserName="
				+ vfssoUserName + ", vfssoStatus=" + vfssoStatus + ", contactId=" + contactId + "]";
	}

	
}
