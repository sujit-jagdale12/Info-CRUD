package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DaoC;
import com.model.Emp;
 
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public SaveServlet() {
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emp e = new Emp();
		DaoC dao=new DaoC();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		
		e.setName(name);
		e.setEmail(email);
		e.setAddress(address);
		e.setCity(city);
		
	     int status = dao.insertdata(e);
		
		if(status > 0)
		{
			pw.println("Data Recorded");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}
		else
		{
			pw.println("Sorry Unable to Save Data");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}
