package com.ScheduleGen.api.CustomValidations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotSpacesOnlyValidator.class)
public @interface NotSpacesOnly {
    String message() default "Field must not contain only spaces";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
