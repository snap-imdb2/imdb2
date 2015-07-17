package org.snapimdb2.meta;

import java.util.ArrayList;
import java.util.List;

import org.snapimdb2.enums.ContentRating;
import org.snapimdb2.enums.Genres;


public class MovieMetaData {
    
    private String movieName;
    private int durationInMinutes;
    //fsa
    private String directorName;
    private ContentRating contentRating;
    private List<Genres> genres = new ArrayList<>();
    
    public MovieMetaData(String movieName, int durationInMinutes, String directorName, ContentRating contentRating, List<Genres> genres) {
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
        this.directorName = directorName;
        this.contentRating = contentRating;
        this.genres = genres;
    }
    
    public MovieMetaData(String movieName, String directorName){
        this.movieName = movieName;
        this.directorName = directorName;
        durationInMinutes = 0;
        contentRating = ContentRating.U;
    }
    
    public MovieMetaData(String movieName, int durationInMinutes, String directorName) {
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
        this.directorName = directorName;
        contentRating = ContentRating.U;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public ContentRating getContentRating() {
        return contentRating;
    }

    public void setContentRating(ContentRating contentRating) {
        this.contentRating = contentRating;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }
}
