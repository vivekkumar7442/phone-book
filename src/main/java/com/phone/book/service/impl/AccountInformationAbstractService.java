package com.phone.book.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.phone.book.entity.ContactDetails;
import com.phone.book.repository.ContactRepository;
import com.phone.book.request.ContactCreationRequest;

/**
 * @author vivek
 * 
 *         AccountInformationAbstractService for reusing the common methods
 *
 */
public abstract class AccountInformationAbstractService {

	@Autowired
	protected ContactRepository accountRepository;

	protected ContactDetails createAccounDetails(ContactCreationRequest accountCreationRequest) {
		ContactDetails accountDetails = new ContactDetails();
		accountDetails.setPhoneNumber(accountCreationRequest.getPhoneNumber());
		accountDetails.setCountryCode(accountCreationRequest.getCountryCode());
		accountDetails.setFirstName(accountCreationRequest.getFirstName());
		accountDetails.setLastName(accountCreationRequest.getLastName());
		accountDetails.setMiddleName(accountCreationRequest.getMiddleName());
		accountDetails.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		accountDetails.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		accountRepository.save(accountDetails);
		return accountDetails;
	}
	
	protected ContactDetails updateContactDetails(ContactCreationRequest accountCreationRequest,
			ContactDetails accountDetails) {

		accountDetails.setPhoneNumber(accountCreationRequest.getPhoneNumber());
		accountDetails.setCountryCode(accountCreationRequest.getCountryCode());
		if (accountCreationRequest.getFirstName() != null) {
			accountDetails.setFirstName(accountCreationRequest.getFirstName());
		}
		if (accountCreationRequest.getLastName() != null) {
			accountDetails.setLastName(accountCreationRequest.getLastName());
		}
		if (accountCreationRequest.getMiddleName() != null) {
			accountDetails.setMiddleName(accountCreationRequest.getMiddleName());
		}
		accountDetails.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		accountRepository.save(accountDetails);
		return accountDetails;
	}

}
