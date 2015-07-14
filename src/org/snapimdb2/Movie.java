package org.snapimdb2;

import java.util.ArrayList;

public class Movie {
	
	private MovieMetaData movieMetaData;
	private String movieId;
	private Rating rating;
	private ArrayList<Review> reviews;
	public MovieMetaData getMovieMetaData() {
		return movieMetaData;
	}
	public void setMovieMetaData(MovieMetaData movieMetaData) {
		this.movieMetaData = movieMetaData;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}


}
