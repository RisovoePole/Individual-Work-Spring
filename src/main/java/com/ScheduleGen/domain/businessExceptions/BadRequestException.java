package com.ScheduleGen.domain.businessExceptions;

public class BadRequestException extends BaseDomainException {
    public BadRequestException(String message) {
        super(message,400);
    }
}
