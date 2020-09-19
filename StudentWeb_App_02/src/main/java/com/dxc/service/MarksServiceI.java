package com.dxc.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;



import com.dxc.beans.Marks;
import com.dxc.dao.MarksJdbcDAO;
import com.dxc.service.MarksService;

public class MarksServiceI implements MarksService<Marks> {

	@Override
	public boolean save(Marks marks) throws Exception {
		// TODO Auto-generated method stub
		boolean res=false;
		try {
		 MarksJdbcDAO MarksJdbcDAO=new MarksJdbcDAO();
			return MarksJdbcDAO.save(marks);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return res;
		
	}

	@Override
	public boolean edit(Marks marks) throws Exception {
		boolean res=false;
		try {
			MarksJdbcDAO MarksJdbcDAO =new MarksJdbcDAO();
			res=MarksJdbcDAO.edit(marks);
			if(res)
			{
				MarksJdbcDAO.save();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return res;
	}

	@Override
	public boolean delete(String examid, int id) throws Exception {
		// TODO Auto-generated method stub
		boolean res = false;
		MarksJdbcDAO MarksJdbcDAO;
			try {
				MarksJdbcDAO = new MarksJdbcDAO ();
				res = MarksJdbcDAO.delete(examid,id);
				if(res)
				{
					MarksJdbcDAO.save();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return res;
		}
	

	@Override
	public Marks find(String examid,int id) throws Exception {
		// TODO Auto-generated method stub
      Marks marks=null;
		
		try {
			MarksJdbcDAO MarksJdbcDAO=new MarksJdbcDAO();
			marks=MarksJdbcDAO.find(examid,id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return marks;
		
	}

	@Override
	public List<Marks> findAll() throws Exception {
		List<Marks> marks=null;
		try {
			MarksJdbcDAO MarksjdbcDAO = new MarksJdbcDAO();
			marks=MarksjdbcDAO.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marks;

	}

	
}