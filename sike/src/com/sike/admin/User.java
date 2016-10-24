package com.sike.admin;

public class User {

	String username;
	String password;
	String email;
	String subjectFocus;
	String cityFocus;
	public User(){}
	
	public User(String userName, String password, String email) {
		super();
		this.username = userName;
		this.password = password;
		this.email = email;
	}

	public String getUserName() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSubjectFocus() {
		return subjectFocus;
	}

	public void setSubjectFocus(String subjectFocus) {
		this.subjectFocus = subjectFocus;
	}

	public String getCityFocus() {
		return cityFocus;
	}

	public void setCityFocus(String cityFocus) {
		this.cityFocus = cityFocus;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + ", subjectFocus=" + subjectFocus
				+ ", cityFocus=" + cityFocus + "]";
	}

	
	
}
