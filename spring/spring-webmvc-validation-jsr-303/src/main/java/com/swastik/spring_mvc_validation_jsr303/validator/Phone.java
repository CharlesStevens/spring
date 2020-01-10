package com.swastik.spring_mvc_validation_jsr303.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.swastik.spring_mvc_validation_jsr303.validator.PhoneValidator;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

	String message()

	default "{Phone number not valid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload()default{};

}
