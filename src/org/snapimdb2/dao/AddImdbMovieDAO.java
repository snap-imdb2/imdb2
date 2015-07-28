/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 19-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class AddImdbMovieDAO extends AddMovie{
    
    /** Currently not thread-safe */
    
    private PreparedStatement pStatement;
    private PreparedStatement pStatement2;
    public static long maxImdbId;
    public static long maxMovieId;
    
    private AddMovieDAO addMovieDAO;

    public AddImdbMovieDAO() throws ClassNotFoundException, SQLException {
        super();
        pStatement = connection.prepareStatement("insert into imdb_movies values (?,?);");
        
        Statement st = (Statement) connection.createStatement();
        
        ResultSet resultSet = st.executeQuery("select max(imdb_id) from imdb_movies;");
              
        while(resultSet.next())
            maxImdbId = resultSet.getInt(1);
        
        resultSet = st.executeQuery("select max(movie_id) from movie;");
        
        while(resultSet.next())
            maxMovieId = resultSet.getInt(1);
        
        st.close();
        
        addMovieDAO = new AddMovieDAO();
    }
    
    public void addImdbMovie(int movie_id, String duration, String movieName, String director, String contentRating
            , String genre, String description) throws SQLException {
        addMovieDAO.addMovie(movie_id, duration, movieName, director, contentRating, genre, description);
        pStatement.setInt(1, (int) ++maxImdbId);
        pStatement.setInt(2, movie_id);
    }
}
