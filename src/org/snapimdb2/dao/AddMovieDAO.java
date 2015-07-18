/*
 *  @version     1.0, 17-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMovieDAO {
    
    private Connection connection;
    private PreparedStatement pStatement;
    private PreparedStatement pStatement2;
    
    public AddMovieDAO(){
        try {
           this.connection = DBConnection.getConnection();
           pStatement = connection.prepareStatement("insert into movie" +
                   "(movie_id, duration, movieName, director) values (?,?,?,?);");
           pStatement2 = connection.prepareStatement("insert into movie" +
                   "(movie_id, duration, movieName, director, contentRating, genre, description) values (?,?,?,?,?,?,?);");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addMovie(int movie_id, int duration, String movieName, String director) {
        try{      
            pStatement.setInt(1, movie_id);
            pStatement.setInt(2, duration);
            pStatement.setString(3, movieName);
            pStatement.setString(4, director);
            pStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addMovie(int movie_id, String duration, String movieName, String director, String contentRating
            , String genre, String description) {
        try{      
            pStatement2.setInt(1, movie_id);
            pStatement2.setString(2, duration);
            pStatement2.setString(3, movieName);
            pStatement2.setString(4, director);
            pStatement2.setString(5, contentRating);
            pStatement2.setString(6, genre);
            pStatement2.setString(7, description);
            pStatement2.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    void close(){
        try {
            pStatement.close();
            pStatement2.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void finalize(){
        try {
            if(!pStatement.isClosed())
                pStatement.close();          
            if(!connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
