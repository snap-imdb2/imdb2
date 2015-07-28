/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 19-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.snapimdb2.crawler.ImdbSpider;
import org.snapimdb2.dao.AddImdbMovieDAO;

public class MovieManagementServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        

        response.setContentType("text/html");
        
        String message = "";
        
        Enumeration<String> x = req.getParameterNames();//getAttribute()
        if(x.hasMoreElements()){
            int n = Integer.parseInt(req.getParameter("numberOfMoviesToFetch"));
            AddImdbMovieDAO addImdbMovieDAO;
            try {
                addImdbMovieDAO = new AddImdbMovieDAO();
                for(int i = 0; i < n; i++){
                    try {
                        ImdbSpider.parseAndStoreMovie(addImdbMovieDAO);
                    } catch (Exception e) {
                        message += e.getMessage()+"<br/>";
                        e.printStackTrace();
                    }
                }
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        }
        
        PrintWriter out = response.getWriter();
        
        out.println("<h1>" + message + "</h1>");

        out.flush();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.sendRedirect("adminPage");
    }

}
