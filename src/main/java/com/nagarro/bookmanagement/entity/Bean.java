package com.nagarro.bookmanagement.entity;

import java.io.Serializable;

public class Bean implements Serializable {
	@Override
	public String toString() {
		return "Bean [username=" + username + ", password=" + password + "]";
	}

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

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

}
