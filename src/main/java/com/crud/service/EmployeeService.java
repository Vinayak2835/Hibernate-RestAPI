package com.crud.service;

import java.util.List;

import com.crud.model.Employee;

public interface EmployeeService {
	List<Employee> getAll();

	void save(Employee emp);

	Employee getById(int id);

	void delete(int id);

}
