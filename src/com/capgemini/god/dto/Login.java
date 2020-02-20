package com.capgemini.god.dto;

public class Login {
	@Override
	public String toString() {
		return "Login [id=" + id + ", password=" + password + ", userType=" + userType + "]";
	}

	private String id;
	private String password;
	private String userType;
	private String phoneNo;
	private String Email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Login() {
	}
	
	public Login(String id, String password, String userType) {
		super();
		this.id = id;
		this.password = password;
		this.userType = userType;
	}
	
}
