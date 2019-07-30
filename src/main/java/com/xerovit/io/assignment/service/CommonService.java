package com.xerovit.io.assignment.service;

import java.util.List;

public interface CommonService<T> {
	T insert(T object);
	void delete(int id);
	T get(int id);
	List<T> getAll();
}
