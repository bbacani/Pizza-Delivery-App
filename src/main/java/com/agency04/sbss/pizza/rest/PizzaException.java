package com.agency04.sbss.pizza.rest;

public class PizzaException extends RuntimeException {

	public PizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PizzaException(String message) {
		super(message);
	}

	public PizzaException(Throwable cause) {
		super(cause);
	}
	
}
