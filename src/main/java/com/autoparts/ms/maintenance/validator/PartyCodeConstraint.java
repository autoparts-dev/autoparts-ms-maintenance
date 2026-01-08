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
@Constraint(validatedBy = PartyCodeConstraintValidator.class)
public @interface PartyCodeConstraint {
	
	String message() default "Invalid Party Code";
	
	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}