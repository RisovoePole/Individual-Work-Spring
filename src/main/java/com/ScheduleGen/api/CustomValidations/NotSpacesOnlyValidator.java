package com.ScheduleGen.api.CustomValidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotSpacesOnlyValidator implements ConstraintValidator<NotSpacesOnly, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // null разрешён
        if (value == null) {
            return true;
        }
        // проверяем, что строка не состоит только из пробелов
        return value.trim().isEmpty()
                ? false
                : true;
    }
}
