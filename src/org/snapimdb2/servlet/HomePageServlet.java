/*
 *  @version     1.0, 17-Jul-2015
 *  @author tanuj
 */

package org.snapimdb2.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        

        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "Sample JSP" + "</h1>");
        
        response.sendRedirect("home.jsp");
    }
}
