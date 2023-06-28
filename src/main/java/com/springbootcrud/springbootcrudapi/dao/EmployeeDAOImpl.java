package com.springbootcrud.springbootcrudapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootcrud.springbootcrudapi.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployee() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;

	}

	@Override
	public Employee getEmployee(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employeeObj=currentSession.get(Employee.class,id);
		return employeeObj;
	}

	@Override
	public void saveEmployee(Employee employee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.persist(employee);

	}

	@Override
	public void deleteEmployee(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employeeObj=currentSession.get(Employee.class,id);
		currentSession.remove(employeeObj);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.merge(employee);
		
	}

}
