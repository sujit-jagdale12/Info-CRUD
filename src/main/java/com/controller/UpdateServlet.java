package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.DaoC;
import com.model.Emp;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Emp e = new Emp();
    public UpdateServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String id1 = request.getParameter("id");
			int id = Integer.parseInt(id1);
			
			e = DaoC.getEmployeeById(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("list",e);
			
			response.sendRedirect("update.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
					
					int status = DaoC.update(e);
					
					if (status > 0)
					{
						pw.println("Data Updated");
						RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
						rd.include(request, response);
						
						
					}
					else
					{
						pw.println("Data Not Updated");
						RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
						rd.include(request, response);
					}
					
	}

}
