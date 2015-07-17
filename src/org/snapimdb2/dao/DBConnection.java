/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 17-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/dbimdb";
    final static String USER = "root";
    final static String PASS = "admin";

    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection==null){
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;         
        }
        return connection;
    }

}
