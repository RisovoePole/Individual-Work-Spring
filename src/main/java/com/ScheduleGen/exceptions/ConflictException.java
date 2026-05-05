package com.ScheduleGen.exceptions;

public class ConflictException extends BaseDomainException{
    public ConflictException(String message) { super(message, 409);}
}
