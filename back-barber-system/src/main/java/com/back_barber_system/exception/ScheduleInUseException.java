package com.back_barber_system.exception;

public class ScheduleInUseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public ScheduleInUseException(String message) {
        super(message);
    }
}
