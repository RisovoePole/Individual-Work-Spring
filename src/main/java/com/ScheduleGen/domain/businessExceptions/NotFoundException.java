package com.ScheduleGen.domain.businessExceptions;

public class NotFoundException extends BaseDomainException {
    public NotFoundException(String message) {
        super(message, 404);
    }
}
