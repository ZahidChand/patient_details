package com.plasmit.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.hospital.exception.PatientNotFoundException;

@ControllerAdvice
public class PatientExceptionController 
{
	@ExceptionHandler(value = PatientNotFoundException.class)
	public ResponseEntity<Object> exception (PatientNotFoundException ex)
	{
		return new ResponseEntity<Object>("patient Entered Not Found In The Database...",HttpStatus.NOT_FOUND);
		
	}
}
