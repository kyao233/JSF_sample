package com.jsfdemo.bean;

public class UserBean {

	private String password;
	
	private String userName;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String loginUser() {
		if ("hoho".equals(userName) && "hoho".equals(password)) {
			return "success";
		} else {
			return "fail";
		}
	}
	
}
