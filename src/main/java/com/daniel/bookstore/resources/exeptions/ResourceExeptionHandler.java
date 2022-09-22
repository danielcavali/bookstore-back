

package com.daniel.bookstore.resources.exeptions;

import javax.servlet.ServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	public ResponseEntity<StandartError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request ){
		StandartError error = new StandartError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> validationError(MethodArgumentNotValidException e, ServletRequest request ){
		ValidationError error = new ValidationError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"erro na validaçao dos campos");
		
		for(FieldError x :e.getBindingResult().getFieldErrors()) {
			error.addErrors(x.getField(),x.getDefaultMessage());
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
}
