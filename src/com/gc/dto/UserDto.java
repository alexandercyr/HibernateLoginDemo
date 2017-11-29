package com.gc.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	private int ID;
	private String UserName;
	private String Password;
	private String FirstName;
	private String LastName;
	
	public UserDto() {
		
	}
	
	public UserDto(int iD, String userName, String password, String firstName, String lastName) {
		ID = iD;
		UserName = userName;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	
}
