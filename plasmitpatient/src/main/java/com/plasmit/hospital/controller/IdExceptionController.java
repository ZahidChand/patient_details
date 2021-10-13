package com.plasmit.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.plasmit.hospital.exception.IdAlreadyExistException;


@ControllerAdvice
public class IdExceptionController 
{

	@ExceptionHandler(value = IdAlreadyExistException.class)
	public ResponseEntity<Object> exception(IdAlreadyExistException ex)
	{
		return new ResponseEntity<Object>("Id Already Exist Into The Database So Enter Different ID...." , HttpStatus.NOT_FOUND);
	}

}
