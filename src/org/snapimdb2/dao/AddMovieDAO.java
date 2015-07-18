/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 17-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.dao;

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
                    "(movie_id, duration, movieName, director, contentRating, genre, description) values (?,?,?,?,?,?,?);");
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void addMovie(int movie_id, String duration, String movieName, String director, String contentRating
    		, String genre, String description) {
        try{      
            pStatement.setInt(1, movie_id);
            pStatement.setString(2, duration);
            pStatement.setString(3, movieName);
            pStatement.setString(4, director);
            pStatement.setString(5, contentRating);
            pStatement.setString(6, genre);
            pStatement.setString(7, description);
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
