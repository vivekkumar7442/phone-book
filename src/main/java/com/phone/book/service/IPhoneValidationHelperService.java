package com.phone.book.service;

/**
 * @author vivek
 * 
 * helper interface for the validation type locator
 *
 */
public interface IPhoneValidationHelperService {
	
	IPhoneNumberValidation getValidationType(String type);

}
