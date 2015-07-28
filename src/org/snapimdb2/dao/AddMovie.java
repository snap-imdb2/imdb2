/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 19-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2.dao;

import java.sql.Connection;
import java.sql.SQLException;

abstract public class AddMovie {
    
    protected Connection connection;
    
    public AddMovie() throws ClassNotFoundException, SQLException{
           this.connection = DBConnection.getConnection();                 
    }
}
