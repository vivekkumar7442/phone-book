package com.phone.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phone.book.constant.ContactStatusConstant;
import com.phone.book.service.IPhoneNumberValidation;
import com.phone.book.service.IPhoneValidationHelperService;
import com.phone.book.validation.PhoneNumberValidation;

/**
 * @author vivek
 * 
 *         PhoneValidationFactory to give the respective class to handle the
 *         validation
 *
 */

@Component
public class PhoneValidationFactory implements IPhoneValidationHelperService {

	@Autowired
	private PhoneNumberValidation phoneNumberValidation;

	@Override
	public IPhoneNumberValidation getValidationType(String type) {

		switch (type) {
		case ContactStatusConstant.PHONE_NUMBER_VALIDATION:

			return phoneNumberValidation;

		default:
			break;
		}

		return null;
	}

}
