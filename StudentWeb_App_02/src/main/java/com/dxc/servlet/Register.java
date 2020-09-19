package com.dxc.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.beans.User;
import com.dxc.dao.UserJdbcDAO;
import com.dxc.hibservice.UserHibService;
import com.dxc.service.UserServiceI;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	User user=new User(username, password);
	boolean bool=false;
	try {
		UserHibService userjdbcDao=new UserHibService();
		bool=userjdbcDao.save(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(bool) {
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	}
	}
}
	
	


