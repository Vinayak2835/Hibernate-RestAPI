package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	// To get employeeList
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = employeeServiceImpl.getAll();

		if (employeeList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.of(Optional.of(employeeList));
		}

		// return employeeList;
	}

	// To post an employee
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee emp) {

		employeeServiceImpl.save(emp);
		System.out.println(emp);

		if (emp == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}

	}

	// To get an employee based on id
	@GetMapping("/getAll/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {

		Employee employee = null;
		employee = employeeServiceImpl.getById(id);

		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(employee));

		}

	}

	// To delete an employee
	@DeleteMapping("/getAll/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {

		try {
			employeeServiceImpl.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	// To update an employee

	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee emp) {
		
		try {
			employeeServiceImpl.save(emp);
			return ResponseEntity.of(Optional.of(emp));
		}
		 catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		 }
	}

}
