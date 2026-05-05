package com.ScheduleGen.exceptions;

public class BaseDomainException extends RuntimeException {

    private final int status;

    public BaseDomainException(String message, int status) {
        super(message);
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }
}
