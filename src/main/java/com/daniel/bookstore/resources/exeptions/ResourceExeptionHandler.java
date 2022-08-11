package com.daniel.bookstore.resources.exeptions;

import javax.servlet.ServletRequest;

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
}
