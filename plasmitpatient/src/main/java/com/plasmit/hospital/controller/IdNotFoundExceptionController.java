package com.plasmit.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.hospital.exception.IdNotFoundException;

@ControllerAdvice
public class IdNotFoundExceptionController 
{
	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<Object> exception (IdNotFoundException ex)
	{
		return new ResponseEntity<Object>("Id Entered Not Found in Database So Please Enter Correct Id",HttpStatus.NOT_FOUND);
	}

}
