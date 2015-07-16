package org.snapimdb2;

import org.snapimdb2.meta.ReviewMetaData;

public class RatingAndReview {
	private String reviewId;
	private String userId;
	private String movieId;
	private ReviewMetaData reviewMetaData;
	
	public String getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getMovieId() {
		return movieId;
	}
	
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public ReviewMetaData getReviewMetaData() {
		return reviewMetaData;
	}
	
	public void setReviewMetaData(ReviewMetaData reviewMetaData) {
		this.reviewMetaData = reviewMetaData;
	}
	
}
