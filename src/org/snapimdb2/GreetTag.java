/*
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 29-Jul-2015
 *  @author tanuj
 */
package org.snapimdb2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class GreetTag extends TagSupport{
    
    private static final long serialVersionUID = -3338757225832073392L;    
    private String userName, city;    
    private JspWriter jw = pageContext.getOut();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            jw.println("End tag is writing");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("doEndTag called");
        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        System.out.println("doStartTag called");
        return EVAL_BODY_INCLUDE;
    }


    @Override
    public void release() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPageContext(PageContext arg0) {
        // TODO Auto-generated method stub
        
    }

}
