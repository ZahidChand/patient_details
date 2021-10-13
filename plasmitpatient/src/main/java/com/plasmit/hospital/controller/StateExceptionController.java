package com.plasmit.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.hospital.exception.StateNotFoundException;

@ControllerAdvice
public class StateExceptionController 
{
	@ExceptionHandler(value = StateNotFoundException.class)
	public ResponseEntity<Object> exception (StateNotFoundException ex)
	{
		return new ResponseEntity<Object>("State Entered Not Found Into The Database Please Enter Correct State Name",HttpStatus.NOT_FOUND);
	}

}
