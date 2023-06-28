package com.springbootcrud.springbootcrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootcrud.springbootcrudapi.dao.EmployeeDAO;
import com.springbootcrud.springbootcrudapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional
	@Override
	public List<Employee> getEmployee() {
		
		return employeeDAO.getEmployee();
	}
	@Transactional
	@Override
	public Employee getEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}
	@Transactional
	@Override
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
		
	}
	@Transactional
	@Override
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
		
	}
	@Transactional
	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}

}
