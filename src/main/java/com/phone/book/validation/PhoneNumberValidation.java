package com.phone.book.validation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.book.beans.ValidationContext;
import com.phone.book.beans.ValidationResult;
import com.phone.book.constant.ValidationConstants;
import com.phone.book.service.IPhoneNumberValidation;
import com.phone.book.service.IValidationRules;

@Service
public class PhoneNumberValidation implements IPhoneNumberValidation {

	@Autowired
	private NumberFormatValidation numberFormatValidation;

	@Override
	public ValidationResult validate(ValidationContext validationContext) {

		for (IValidationRules rules : getValidationRulesList()) {
			ValidationResult validationResult = rules.validate(validationContext);

			if (validationResult.notValid()) {
				return validationResult;
			}
		}
		return new ValidationResult(true, ValidationConstants.PHONE_NUMBER);
	}

	@Override
	public List<IValidationRules> getValidationRulesList() {

		return Arrays.asList(numberFormatValidation);
	}

}
