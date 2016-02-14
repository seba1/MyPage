package com.as.samples;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class pageOneProcess extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    	public void doPost (HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        String name = request.getParameter("name");
        String add = request.getParameter("add");
        String phone= request.getParameter("phone");
        
        System.out.println("The name is: "+name);
        System.out.println("The add is: "+add);
        System.out.println("The phone is: "+phone);
        
        request.getSession().setAttribute("name", name);
        request.getSession().setAttribute("add", add);
        request.getSession().setAttribute("phone", phone);
        
        response.sendRedirect("html/pageTwo.html");
        
    }
}