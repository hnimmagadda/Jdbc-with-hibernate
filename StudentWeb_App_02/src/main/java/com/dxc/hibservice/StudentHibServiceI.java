package com.dxc.hibservice;

import java.util.List;


import com.dxc.beans.Student;
import com.dxc.hibdao.StudentHibDAO;

public class StudentHibServiceI implements StudentHibService<Student> {

	@Override
	public boolean save(Student student) {
		// TODO Auto-generated method stub

		try {
			StudentHibDAO stHD=new StudentHibDAO();
			return stHD.save(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student find(int id) {
		// TODO Auto-generated method stub
		Student student=null;
		StudentHibDAO stHD=new StudentHibDAO();
		try {
			student= stHD.find(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		List<Student> students=null;
		StudentHibDAO stHD=new StudentHibDAO();
		try {
			students=stHD.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public boolean update(Student student) {
		// TODO Auto-generated method stub
		boolean res=false;
		StudentHibDAO stHD=new StudentHibDAO();
		try {
			return stHD.update(student);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean res=false;
		StudentHibDAO stHD=new StudentHibDAO();
		try {
			res=stHD.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}