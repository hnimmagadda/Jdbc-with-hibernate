package com.dxc.service;

import java.util.List;

import com.dxc.beans.Marks;

public interface MarksService<E> {
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(String examid,int id) throws Exception;
	E find(String examid,int id) throws Exception;
	List<E> findAll() throws Exception;
	

}