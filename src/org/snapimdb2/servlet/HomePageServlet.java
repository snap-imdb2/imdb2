/*
 *  @version     1.0, 17-Jul-2015
 *  @author tanuj
 */

package org.snapimdb2.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.snapimdb2.dao.FetchMovieDAO;

public class HomePageServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");

        // Actual logic goes here.
        //PrintWriter out = response.getWriter();
        //out.println("<h1>" + "Sample JSP" + "</h1>");
        
        try {
            request.setAttribute("movies", (new FetchMovieDAO()).fetchMovies() );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }             
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home");
        requestDispatcher.forward(request, response);
        
        //response.sendRedirect("login.jsp");
    }
}
