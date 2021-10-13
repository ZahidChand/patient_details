package com.plasmit.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.hospital.exception.DistrictNotFoundException;

@ControllerAdvice
public class DistrictExceptionController 
{
	@ExceptionHandler (value = DistrictNotFoundException.class)
	public ResponseEntity<Object> exception(DistrictNotFoundException ex)
	{
		return new ResponseEntity<Object>("District Enterd Not Found Into The Database . Please Enter Correct District",HttpStatus.NOT_FOUND);
	}

}
