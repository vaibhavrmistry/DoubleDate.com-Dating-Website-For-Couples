package com.neu.edu.Validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mysql.jdbc.Field;
import com.neu.edu.Model.CoupleSignUp;

public class LoginValidator implements Validator {

	private static final int MINIMUM_PASSWORD_LENGTH = 6;

	@Override
	public boolean supports(Class<?> clazz) {
		return CoupleSignUp.class.isAssignableFrom(clazz);
	}



	@Override
	public void validate(Object target, Errors errors) {

		CoupleSignUp csu = (CoupleSignUp) target;
		ValidationUtils.rejectIfEmpty(errors, "coupleName", "required.coupleName", "Please fill the email field");
		ValidationUtils.rejectIfEmpty(errors, "password", "required.password", "Please fill the password field");


		if(csu.getPassword()!=null && csu.getPassword().trim().length()<MINIMUM_PASSWORD_LENGTH){
			errors.rejectValue("password", "Minimum length of fields is ", new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
					"The password must be atleast ["+ MINIMUM_PASSWORD_LENGTH +"] characters in lenth");
		}
	}
}
