package com.back_barber_system.exception;

public class EmailInUseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public EmailInUseException(String message) {
        super(message);
    }
}