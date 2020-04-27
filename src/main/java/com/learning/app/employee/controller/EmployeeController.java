package com.learning.app.employee.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.app.employee.model.Employee;
import com.learning.app.employee.service.EmployeeService;
import com.learning.app.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/")
	public List<Employee> getEmployees() {
		List<Employee> list = employeeService.findAllEmployees();
		return list;
	}

	@PostMapping(value = "/")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}

	@PutMapping(value = "/")
	public Employee updateEmployee(@RequestBody Employee emp) throws EmployeeNotFoundException {
		return employeeService.updateEmployee(emp);
	}

	@DeleteMapping(value = "/{empId}")
	public boolean deleteEmployee(@PathVariable Long empId) {
		return employeeService.deleteEmployee(empId);
	}

	@GetMapping(value = "/{empId}")
	public Employee getEmployee(@PathVariable Long empId) throws EmployeeNotFoundException {
		return employeeService.findEmployee(empId);
	}

	@PostMapping(value = "/dept")
	public List<Employee> getEmployeesByDept(@RequestBody String json) {
		JSONObject obj = new JSONObject(json);
		return employeeService.findAllEmployeesByDept(obj.getString("dept"));
	}

}
