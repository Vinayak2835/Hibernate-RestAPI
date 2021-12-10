package com.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("FROM Employee", Employee.class);
		List<Employee> empList = query.getResultList();
		return empList;
	}

	@Override
	public void save(Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);

	}

	@Override
	public Employee getById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);

		return employee;
	}

	@Override
	public void delete(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);

		currentSession.delete(employee);

	}

}
