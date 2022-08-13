package com.daniel.bookstore.resources.exeptions;

import javax.servlet.ServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.daniel.bookstore.services.exeptions.ObjectNotFoundExeption;

@ControllerAdvice
public class ResourceExeptionHandler {
	 
	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundExeption e, ServletRequest request ){
		StandartError error = new StandartError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(com.daniel.bookstore.services.exeptions.DataIntegrityViolationException.class)
	public ResponseEntity<StandartError> dataIntegrityViolationException(com.daniel.bookstore.services.exeptions.DataIntegrityViolationException e, ServletRequest request ){
		StandartError error = new StandartError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	
	
	
	
}
