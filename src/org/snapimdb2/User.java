package org.snapimdb2;

import java.util.ArrayList;

import org.snapimdb2.meta.UserMetaData;

public class User {
	private String userId;
	private ArrayList<RatingAndReview> listOfRatingsAndReviews;
	private UserMetaData userMetaData;
	private boolean isAdmin;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public ArrayList<RatingAndReview> getListOfRatingsAndReviews() {
		return listOfRatingsAndReviews;
	}
	
	public void setListOfRatingsAndReviews(ArrayList<RatingAndReview> listOfRatingsAndReviews) {
		this.listOfRatingsAndReviews = listOfRatingsAndReviews;
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
