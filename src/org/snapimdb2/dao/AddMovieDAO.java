/*
 *  @version     1.0, 17-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMovieDAO extends AddMovie {

    private PreparedStatement pStatement = null;
    private PreparedStatement pStatement2 = null;
    
    public AddMovieDAO() throws ClassNotFoundException, SQLException {
        super();
    }
    
    void pStatementInit() throws SQLException{
        pStatement = connection.prepareStatement("insert into movie" +
                "(movie_id, duration, movieName, director) values (?,?,?,?);");
    }
    
    void pStatement2Init() throws SQLException{
        pStatement2 = connection.prepareStatement("insert into movie" +
            "(movie_id, duration, movieName, director, contentRating, genre, description) values (?,?,?,?,?,?,?);");
    }
    
    public void addMovie(int movie_id, int duration, String movieName, String director) {
        try{
            if(pStatement == null)
                pStatementInit();
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
            if(pStatement2 == null)
                pStatement2Init();
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
            if(pStatement!=null)
                pStatement.close();
            if(pStatement2!=null)
                pStatement2.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void finalize(){
        try {
            if(pStatement!=null && !pStatement.isClosed())
                pStatement.close();
            if(pStatement2!=null && !pStatement2.isClosed())
                pStatement2.close();
            if(!connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
