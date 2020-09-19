package com.dxc.hibservice;

import java.util.List;


import com.dxc.beans.User;
import com.dxc.hibdao.UserHibDAO;

public class UserHibService implements StudentHibService<User> {

	public static boolean validate(String username, String password)  {

		UserHibDAO stHD=new UserHibDAO();
		try {
			return stHD.validate(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		

	}

	@Override
	public boolean save(User e) {
		// TODO Auto-generated method stub
		UserHibDAO stHD=new UserHibDAO();
		try {
			return stHD.save(e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User e) {
		// TODO Auto-generated method stub
		return false;
	}
}