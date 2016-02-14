package com.as.samples;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class pageTwoProcess extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public void doPost (HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        String id = request.getParameter("id");
        String course = request.getParameter("course");
        
        System.out.println("The id is: "+id);
        System.out.println("The course is: "+course);
        
        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("course", course);
        
        response.sendRedirect("jsp/printout.jsp");
        
    }
}