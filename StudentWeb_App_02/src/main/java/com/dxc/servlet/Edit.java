package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.beans.Student;
import com.dxc.dao.StudentjdbcDAO;
import com.dxc.service.StudentServiceI;

/**
 * Servlet implementation class Edit
 */
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id")) ;
		String name=request.getParameter("name");
		String dob=(request.getParameter("dob"));
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		Student student=null;
		boolean bool=false;
		try {
			 student =new Student(id, name, dob, email, mobile);
			 StudentServiceI s=new StudentServiceI();
			bool= s.update(student);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool) {
			PrintWriter out=response.getWriter();
			out.println("edited successfully");
			RequestDispatcher rd = request.getRequestDispatcher("DisplayStudents.jsp");
			rd.include(request, response);
		}
		
		
	}

}
