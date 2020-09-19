package com.dxc.service;

import java.util.List;

public interface ExamService<E> {
	boolean save(E e);
	E find(String id);
	List<E> findAll();
	boolean update(E e);
	boolean delete(String id);


}