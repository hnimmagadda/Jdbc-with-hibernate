package com.dxc.hibdao;

import java.util.List;

public interface UserDao<E> {
	boolean update(E e);
	boolean save(E e);
	boolean delete(String id);
	E find(String id);
	List<E> findAll();	

}