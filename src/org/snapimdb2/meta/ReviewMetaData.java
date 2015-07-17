package org.snapimdb2.meta;

import java.util.Calendar;

public class ReviewMetaData {
	private String review;
	private Calendar reviewDateTime;
	//sdf
	public String getReview() {
		return review;
	}

	public Calendar getReviewDate() {
		return reviewDateTime;
	}

	public void setReviewDate(Calendar reviewDate) {
		this.reviewDateTime = reviewDate;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
