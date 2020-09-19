package com.dxc.dao;

import java.util.List;

public interface MarksDAO<E> {
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(String examid,int studentid) throws Exception;
	E find(String examid,int studentid) throws Exception;
	List<E> findAll() throws Exception;	
}