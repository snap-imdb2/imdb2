package org.snapimdb2.meta;

import java.util.ArrayList;
import java.util.List;

import org.snapimdb2.enums.ContentRating;
import org.snapimdb2.enums.Genres;


public class MovieMetaData {
    
    private String movieName;
    private String durationInMinutes;
    private String directorName;
    private ContentRating contentRating;
    private Genres genres;
    
    public MovieMetaData(String movieName, String string, String directorName, ContentRating contentRating, Genres genres2) {
        this.movieName = movieName;
        this.durationInMinutes = string;
        this.directorName = directorName;
        this.contentRating = contentRating;
        this.setGenres(genres2);
    }
    
    public MovieMetaData(String movieName, String directorName){
        this.movieName = movieName;
        this.directorName = directorName;
        durationInMinutes = "";
        contentRating = ContentRating.U;
    }
    
    public MovieMetaData(String movieName, String durationInMinutes, String directorName) {
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

    public String getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(String durationInMinutes) {
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

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

}
