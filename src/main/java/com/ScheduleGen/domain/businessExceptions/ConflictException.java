package com.ScheduleGen.domain.businessExceptions;

public class ConflictException extends BaseDomainException{
    public ConflictException(String message) { super(message, 409);}
}
