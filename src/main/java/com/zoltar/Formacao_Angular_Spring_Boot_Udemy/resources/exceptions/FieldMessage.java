package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;

	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
