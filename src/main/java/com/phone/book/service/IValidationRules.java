package com.phone.book.service;

import com.phone.book.beans.ValidationContext;
import com.phone.book.beans.ValidationResult;

/**
 * @author vivek
 * 
 *  interface for validation Rules
 *
 */
public interface IValidationRules {

	ValidationResult validate(ValidationContext validationContext);

}
