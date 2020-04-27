package com.learning.app.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.app.employee.dao.EmployeeDao;
import com.learning.app.employee.model.Employee;
import com.learning.app.employee.service.EmployeeService;
import com.learning.app.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public List<Employee> findAllEmployeesByDept(String dept) {
		return employeeDao.findByEmpDept(dept);
	}

	@Override
	public Employee findEmployee(Long id) throws EmployeeNotFoundException {
		Employee emp = employeeDao.findById(id).orElse(new Employee());
		if (emp.getId() > 0)
			return emp;
		else
			throw new EmployeeNotFoundException(id);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeDao.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return employeeDao.save(emp);
	}

	@Override
	public boolean deleteEmployee(Long empId) {
		try {
			employeeDao.delete(findEmployee(empId));
		} catch (EmployeeNotFoundException e) {
			return false;
		}

		return true;
	}
}
