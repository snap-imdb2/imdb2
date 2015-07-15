package org.snapimdb2;

import java.util.ArrayList;

import org.snapimdb2.meta.MovieMetaData;

public class Movie {
	
	private MovieMetaData movieMetaData;
	private Long movieId;
	private Rating rating;
	private ArrayList<Long> ratingAndReviewIds;
	
	public MovieMetaData getMovieMetaData() {
		return movieMetaData;
	}
	
	public void setMovieMetaData(MovieMetaData movieMetaData) {
		this.movieMetaData = movieMetaData;
	}
	
	public Rating getRating() {return rating;}
	
	public void addRating(int rating) {
	    this.rating.addRating(rating);
	}

}
