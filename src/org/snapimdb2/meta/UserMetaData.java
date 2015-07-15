package org.snapimdb2.meta;

import java.util.Calendar;

public class UserMetaData {
	private String username;
	private String password;
	private Calendar dateOfJoining;
	
	public UserMetaData(String username, String password, Calendar dateOfJoining){
		this.username = username;
		this.password = password;
		this.dateOfJoining = dateOfJoining;
	}
	
	public Calendar getDateOfJoining() {
		return dateOfJoining;
	}
	
	public void setDateOfJoining(Calendar dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
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