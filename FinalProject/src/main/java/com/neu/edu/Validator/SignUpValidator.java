package com.neu.edu.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.Model.CoupleSignUp;

public class SignUpValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CoupleSignUp.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CoupleSignUp csu = (CoupleSignUp) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"coupleName", "required.coupleName", "Please enter the couplename");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "required.emailId", "Please enter the emailId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "required.password", "Please enter the correct password");

	}
}
