package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.services.exceptions;

public class ObjectnotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectnotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjectnotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
