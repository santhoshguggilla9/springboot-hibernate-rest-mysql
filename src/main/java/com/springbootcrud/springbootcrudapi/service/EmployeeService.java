package com.springbootcrud.springbootcrudapi.service;

import java.util.List;

import com.springbootcrud.springbootcrudapi.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployee();

	Employee getEmployee(int id);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(int id);
	
	public void updateEmployee(Employee employee);
}
