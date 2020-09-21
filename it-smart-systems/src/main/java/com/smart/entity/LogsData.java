package com.smart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_data")
public class LogsData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id ;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="last_login")
	private String lastLogin;
	
	@Column(name="last_logout")
	private String lastLogout;
	
	public LogsData() {
	}

	public LogsData(String userName, String lastLogin, String lastLogout) {
		this.userName = userName;
		this.lastLogin = lastLogin;
		this.lastLogout = lastLogout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "LogsData [userName=" + userName + ", lastLogin=" + lastLogin + ", lastLogout="
				+ lastLogout + "]";
	}

	
}
