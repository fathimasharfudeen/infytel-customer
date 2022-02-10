package com.example.infytelcustomer.exception;

import java.util.stream.Collectors;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private Environment environment;

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> customernotFoundExceptionHandler(CustomerNotFoundException ex) {

		ErrorMessage error = new ErrorMessage();

		error.setErrorcode(HttpStatus.BAD_REQUEST.value());
		error.setMessage("customer not found,enter a different id");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex) {

		ErrorMessage error = new ErrorMessage();

		error.setErrorcode(HttpStatus.BAD_REQUEST.value());
		error.setMessage("customer not found,enter a different id");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> methodArgumentExceptionHandler(MethodArgumentNotValidException ex) {

		ErrorMessage error = new ErrorMessage();

		error.setErrorcode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(",")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> constraintViolationExceptionHandler(ConstraintViolationException ex) {

		ErrorMessage error = new ErrorMessage();

		error.setErrorcode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(",")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
