package com.workflex.workation.exception;

import lombok.Data;

@Data
public class EmailDoesNotValidate extends RuntimeException {
	private final String message;
	private final String details;
}
