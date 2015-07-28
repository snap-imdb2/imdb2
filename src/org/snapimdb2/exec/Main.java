/*
 *  @version     1.0, 17-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.exec;

import java.sql.SQLException;

import org.snapimdb2.dao.AddMovieDAO;

public class Main {
    public static void main(String[] args){
        try {
            AddMovieDAO addMovieDAO = new AddMovieDAO();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //addMovieDAO.addMovie(1, 113, "Dabang", "Abhinav Kashyap");
    }
}
