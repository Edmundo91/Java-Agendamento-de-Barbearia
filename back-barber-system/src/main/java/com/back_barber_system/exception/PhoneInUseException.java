package com.back_barber_system.exception;

public class PhoneInUseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public PhoneInUseException(String message) {
        super(message);
    }
}
