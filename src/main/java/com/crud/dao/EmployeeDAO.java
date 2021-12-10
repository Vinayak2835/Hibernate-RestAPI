package com.crud.dao;

import java.util.List;

import com.crud.model.Employee;

public interface EmployeeDAO {

	List<Employee> getAll();

	void save(Employee emp);

	Employee getById(int id);

	void delete(int id);

}
