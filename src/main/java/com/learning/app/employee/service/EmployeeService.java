package com.learning.app.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.app.employee.model.Employee;
import com.learning.app.exception.EmployeeNotFoundException;

@Service
public interface EmployeeService {

	public List<Employee> findAllEmployees();

	public List<Employee> findAllEmployeesByDept(String dept);

	public Employee findEmployee(Long id) throws EmployeeNotFoundException;

	public boolean deleteEmployee(Long empId);

	public Employee updateEmployee(Employee emp);

	public Employee saveEmployee(Employee emp);

}
