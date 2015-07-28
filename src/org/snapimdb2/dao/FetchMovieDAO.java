/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 25-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.snapimdb2.Movie;
import org.snapimdb2.enums.ContentRating;
import org.snapimdb2.enums.Genres;
import org.snapimdb2.meta.MovieMetaData;

public class FetchMovieDAO {
    
    private Connection connection;
    
    public FetchMovieDAO() throws ClassNotFoundException, SQLException {
        connection = DBConnection.getConnection();
    }
    
    public List<Movie> fetchMovies() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from movie");
        List<Movie> movies = new ArrayList<>();
        while(resultSet.next()){
            
            ContentRating contentRating;
            Genres genres;
            
            try{
                contentRating = ContentRating.valueOf(resultSet.getString("contentRating"));               
            } catch (Exception e){                
                contentRating = ContentRating.UA;
            }
            
            try{
                genres = Genres.valueOf(resultSet.getString("genre"));
            } catch (Exception e){                
                genres = Genres.Drama;
            }
            
            MovieMetaData movieMetaData = new MovieMetaData(
                    resultSet.getString("movieName"), 
                    resultSet.getString("duration"), 
                    resultSet.getString("director"), 
                    contentRating, 
                    genres
                    );
            Movie movie = new Movie();
            movie.setMovieMetaData(movieMetaData);
            movie.setDescription(resultSet.getString("description"));
            
            movies.add(movie);
        }
        System.out.println("Size: "+movies.size());
        return movies;
    }
    
    void close(){
        try {          
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void finalize(){
        try {
            if(!connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
