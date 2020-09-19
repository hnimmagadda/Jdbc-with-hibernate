package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Marks;


public class MarksJdbcDAO extends JdbcDAO implements MarksDAO<Marks> {
	
	PreparedStatement p=null;
	ResultSet rs=null;
	
	public MarksJdbcDAO() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		super();
	
	}

	@Override
	public boolean save(Marks e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		
		p=con.prepareStatement("insert into exam values(?,?,?,?,?)");
		p.setString(1, e.getExamid());
		p.setInt(2,e.getId());
		p.setInt(3,e.getSub1());
		p.setInt(4,e.getSub2());
		p.setInt(5,e.getSub3());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public boolean edit(Marks e) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("update exam set mark1=?,mark2=?,mark3=? where examid=? and id=?");
		p.setInt(1,e.getSub1());
		p.setInt(2,e.getSub2());
		p.setInt(3,e.getSub3());
		p.setString(4, e.getExamid());
		p.setInt(5, e.getId());
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}


	@Override
	public boolean delete(String examid, int id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		boolean res=false;
		p=con.prepareStatement("delete from mark where examid=? and id=?");
		p.setString(1, examid);
		p.setInt(2,id);
		if(1==p.executeUpdate())
		{
			res=true;
		}
		con.commit();
		con.close();
		return res;
	}

	@Override
	public Marks find(String examid, int id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		Marks mark=null;
		try {
			p=con.prepareStatement("select * from mark where examid=? and id=?");
		p.setString(1, examid);
		p.setInt(2,id);
		
		rs=p.executeQuery();
		
		if(rs.next())
		{
			int mark1=rs.getInt(3);
			int mark2=rs.getInt(4);
			int mark3=rs.getInt(5);
		
			mark=new Marks(examid, id, mark1, mark2, mark3);
		}
		}
		finally
		{
			con.close();
		}
		return mark;
	}


	@Override
	public List<Marks> findAll() throws Exception {
		List<Marks> marks=new ArrayList<>();
		Marks mark=null;
		Statement s= con.createStatement();
		rs=s.executeQuery("select * from mark");
		while(rs.next())
		{
			String examid=rs.getString("examid");
			int id=rs.getInt(2);
			int mark1=rs.getInt(3);
			int mark2=rs.getInt(4);
			int mark3=rs.getInt(5);
			mark=new Marks(examid, id, mark1, mark2, mark3);
			marks.add(mark);
		}
		return marks;
		}
}