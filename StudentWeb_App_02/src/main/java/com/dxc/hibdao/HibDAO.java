package com.dxc.hibdao;

import java.util.List;

public interface HibDAO<E>{
	
	boolean update(E e);
	boolean save(E e);
	boolean delete(int id);
	E find(int id);
	List<E> findAll();	

}