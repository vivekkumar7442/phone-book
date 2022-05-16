package com.phone.book.service;

import java.util.List;

import com.phone.book.beans.ValidationContext;
import com.phone.book.beans.ValidationResult;

/**
 * @author vivek
 * 
 *  interface for Phone number Service
 *
 */
public interface IPhoneNumberValidation {
	
	 ValidationResult validate(ValidationContext validationContext);
	 
	 List<IValidationRules> getValidationRulesList();
	 

}
