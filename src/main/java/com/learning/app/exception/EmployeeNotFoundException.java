package com.learning.app.exception;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 4994684784413457442L;

	public EmployeeNotFoundException(Long id) {
		super("Employee not found with id=" + id);
	}
	
}
