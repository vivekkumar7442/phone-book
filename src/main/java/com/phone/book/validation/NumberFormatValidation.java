package com.phone.book.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.phone.book.beans.ValidationContext;
import com.phone.book.beans.ValidationResult;
import com.phone.book.constant.ValidationConstants;
import com.phone.book.service.IValidationRules;

@Service
public class NumberFormatValidation implements IValidationRules {
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	@Override
	public ValidationResult validate(ValidationContext validationContext) {

		if (isNumeric(validationContext.getPhoneNumber())) {
			return new ValidationResult(true, ValidationConstants.VALID_NUMBER);

		} else {
			return new ValidationResult(false, "Phone number is invalid");

		}

	}

	public boolean isNumeric(String phoneNumber) {
		if (phoneNumber == null) {
			return false;
		}
		return pattern.matcher(phoneNumber).matches();
	}

}