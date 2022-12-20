package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DaoC;
import com.model.Emp;

@WebServlet("/DeletServlet")
public class DeletServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	Emp e = new Emp();
    public DeletServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id1 = request.getParameter("id");
			int id = Integer.parseInt(id1);
			
			DaoC.delete(id);
			
			response.sendRedirect("View.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			
	}

}
