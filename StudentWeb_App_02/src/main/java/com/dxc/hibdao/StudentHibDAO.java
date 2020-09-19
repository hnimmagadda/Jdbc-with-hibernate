package com.dxc.hibdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.dxc.beans.Student;
import com.dxc.hibutil.HibernateUtil;


public class StudentHibDAO implements HibDAO<Student> {
	
	SessionFactory sessionFactory;
	Session session;
		
	
	public boolean update(Student e) {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(e);		
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean save(Student e) {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);		
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean delete(int id) {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		Student student=(Student)session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
		session.close();

		return true;
	}

	public Student find(int id) {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		Student s= (Student) session.get(Student.class,id);
		session.getTransaction().commit();
		session.close();
		return s;
	}

	public List<Student> findAll(){
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student");
		List<Student> e=query.list();
		session.getTransaction().commit();
		session.close();

		return e;
	}
}