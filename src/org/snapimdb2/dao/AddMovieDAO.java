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
    
    public AddMovieDAO(){
        try {
           this.connection = DBConnection.getConnection();
           pStatement = connection.prepareStatement("insert into movie" +
                   "(movie_id, duration, movieName, director) values (?,?,?,?);");
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
    
    void close(){
        try {
            pStatement.close();
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
