package com.ScheduleGen.exceptions;

public class BadRequestException extends BaseDomainException {
    public BadRequestException(String message) {
        super(message,400);
    }
}
