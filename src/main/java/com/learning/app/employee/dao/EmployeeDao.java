package com.learning.app.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.app.employee.model.Employee;

@Repository("postgres")
public interface EmployeeDao extends JpaRepository<Employee, Long> {
	 public List<Employee> findByEmpDept(String empDept);
}
