package org.snapimdb2;

import org.snapimdb2.meta.ReviewMetaData;

public class RatingAndReview {
	private long userId;
	private long movieId;
	private int ratingValue;
	private ReviewMetaData reviewMetaData;
	
	public RatingAndReview(long userId, long movieId, int ratingValue) {
	    this.userId = userId;
	    this.movieId = movieId;
	    this.ratingValue = ratingValue;
    }
	
	public RatingAndReview(long userId, long movieId, int ratingValue,ReviewMetaData reviewMetaData) {
        this.userId = userId;
        this.movieId = movieId;
        this.ratingValue = ratingValue;
        this.reviewMetaData = reviewMetaData;
    }
	
	public ReviewMetaData getReviewMetaData() {
		return reviewMetaData;
	}
	
	public void setReviewMetaData(ReviewMetaData reviewMetaData) {
		this.reviewMetaData = reviewMetaData;
	}
	
}
