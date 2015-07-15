package org.snapimdb2;

import java.util.ArrayList;

import org.snapimdb2.meta.MovieMetaData;

public class Movie {
    
    private class Rating {
        
        private long totalNumberOfRatings;
        private long totalSumOfRatings;
        
        public Rating() {
            totalNumberOfRatings = 0;
            totalSumOfRatings = 0;
        }
        
    }
	
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
	
	public void addRating(int rating) {
	    this.rating.totalNumberOfRatings++;
        this.rating.totalSumOfRatings+=rating;
	}
	
	public long getTotalNumberOfRatings() {
        return rating.totalNumberOfRatings;
    }
	
	public double getRating(){
        return (((double)rating.totalSumOfRatings)/rating.totalNumberOfRatings);
    }
}
