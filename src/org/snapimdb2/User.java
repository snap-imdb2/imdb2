package org.snapimdb2;

import java.util.List;

import org.snapimdb2.meta.UserMetaData;

public class User {
	private long userId;
	private List<Long> listOfRatingsAndReviewIds;
	private UserMetaData userMetaData;
	private boolean isAdmin;
	
	public List<Long> getListOfRatingsAndReviewIds() {
		return listOfRatingsAndReviewIds;
	}
	
	public UserMetaData getUserMetaData() {
		return userMetaData;
	}
	
	public void setUserMetaData(UserMetaData userMetaData) {
		this.userMetaData = userMetaData;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
