package com.workflex.workation.exception;

import lombok.Data;

@Data
public class EmployeeNotFoundException extends RuntimeException {
	private final String message;
	private final String details;
}
