package com.plasmit.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.hospital.exception.CountryNotFoundException;

@ControllerAdvice
public class CountryExceptionController 
{
	@ExceptionHandler(value = CountryNotFoundException.class)
	public ResponseEntity<Object> exception(CountryNotFoundException ex)
	{
		return new ResponseEntity<Object>("Entered Country Not Found Into The Database .Please Enter Correct Country",HttpStatus.NOT_FOUND);
		
	}

}
