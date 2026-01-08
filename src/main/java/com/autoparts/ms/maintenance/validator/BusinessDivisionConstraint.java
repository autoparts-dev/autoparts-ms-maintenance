package com.autoparts.ms.maintenance.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BusinessDivisionConstraintValidator.class)
public @interface BusinessDivisionConstraint {
	
	String message() default "Invalid Business Division";
	
	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}