package com.springbootcrud.springbootcrudapi.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.springbootcrudapi.model.Employee;
import com.springbootcrud.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> getEmployee(){
		return employeeService.getEmployee();

	}
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employeeObj){
		employeeService.saveEmployee(employeeObj);
		return employeeObj;
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> get(@PathVariable int id) {
		
		Employee employee=employeeService.getEmployee(id);
		if(employee!=null) {
			return ResponseEntity.ok(employee);
		}
		else {
			String e="No Employee found with ID:" +id;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}
			
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		Employee employee=employeeService.getEmployee(id);
		if(employee!=null) {
			employeeService.deleteEmployee(id);
			String e="Employee with ID:" + id +" has been deleted";
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		else {
			String e="No Employee found with ID:" +id;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		}
			
	}
	@PutMapping("/employee/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Employee updatedEmployee) {
	    Employee existingEmployee = employeeService.getEmployee(id);
	    if (existingEmployee != null) {
	        existingEmployee.setEname(updatedEmployee.getEname());
	        existingEmployee.setGender(updatedEmployee.getGender());
	        existingEmployee.setDept(updatedEmployee.getDept());
	        existingEmployee.setDob(updatedEmployee.getDob());
	        
	        employeeService.updateEmployee(existingEmployee); // Update the employee
	        
	        String message = "Employee with ID " + id + " has been updated";
	        return ResponseEntity.status(HttpStatus.OK).body(message);
	        
	    } else {
	        String errorMessage = "No Employee found with ID: " + id;
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	    }
	}
}
