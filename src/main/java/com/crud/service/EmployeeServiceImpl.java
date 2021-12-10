package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.dao.EmployeeDAOImpl;
import com.crud.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;

	@Transactional
	@Override
	public List<Employee> getAll() {

		List<Employee> empList = employeeDAOImpl.getAll();
		return empList;
	}

	@Transactional
	@Override
	public void save(Employee emp) {
		employeeDAOImpl.save(emp);

	}

	@Transactional
	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeDAOImpl.getById(id);
		return employee;
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeDAOImpl.delete(id);
	}

}
