package org.snapimdb2.meta;

import java.util.Calendar;

public class UserMetaData {
    
	private String name;
    private String emailId;
	private String password;
	private Calendar dateOfJoining;
	
	public UserMetaData(String name, String email, String password, Calendar dateOfJoining) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.dateOfJoining = dateOfJoining;
    }
	
	
	public Calendar getDateOfJoining() {
		return dateOfJoining;
	}
	
	public void setDateOfJoining(Calendar dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	
	
}