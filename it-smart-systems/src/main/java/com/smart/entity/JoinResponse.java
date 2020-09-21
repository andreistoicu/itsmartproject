package com.smart.entity;

public class JoinResponse {
	
	private String customerId;
	private String userRole;
	private String vfssoUserName;
	private String vfssoStatus;
	private String contactId;
	private String lastLogin;
	private String lastLogout;

	public JoinResponse() {
	}

	public JoinResponse(String customerId, String userRole, String vfssoUserName, String vfssoStatus,
			String contactId, String lastLogin, String lastLogout) {
		this.customerId = customerId;
		this.userRole = userRole;
		this.vfssoUserName = vfssoUserName;
		this.vfssoStatus = vfssoStatus;
		this.contactId = contactId;
		this.lastLogin = lastLogin;
		this.lastLogout = lastLogout;
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

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastLogout() {
		return lastLogout;
	}

	public void setLastLogout(String lastLogout) {
		this.lastLogout = lastLogout;
	}

	@Override
	public String toString() {
		return "JoinResponse [customerId=" + customerId + ", userRole=" + userRole + ", vfssoUserName="
				+ vfssoUserName + ", vfssoStatus=" + vfssoStatus + ", contactId=" + contactId + ", lastLogin="
				+ lastLogin + ", lastLogout=" + lastLogout + "]";
	}
	
		
}
