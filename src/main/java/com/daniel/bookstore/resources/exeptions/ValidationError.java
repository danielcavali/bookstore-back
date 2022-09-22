package com.daniel.bookstore.resources.exeptions;

import java.util.ArrayList;
import java.util.List;

import com.daniel.bookstore.services.exeptions.FieldMessage;

public class ValidationError extends StandartError {
	
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String erro) {
		super(timestamp, status, erro);
		// TODO Auto-generated constructor stub
	
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

	
	
}
