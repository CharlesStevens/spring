package com.stevens.spring_mvc_validation_jsr303.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone ph) {
	}

	@Override
	public boolean isValid(String phNo, ConstraintValidatorContext ctx) {
		if (phNo == null) {
			return false;
		}
		// validate phone numbers of format "1234567890"
		if (phNo.matches("\\d{10}"))
			return true;
		// validating phone number with -, . or spaces
		else if (phNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validating phone number where area code is in braces ()
		else if (phNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// return false if nothing matches the input
		else
			return false;
	}

}
