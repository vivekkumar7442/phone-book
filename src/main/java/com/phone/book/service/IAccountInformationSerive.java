package com.phone.book.service;

import com.phone.book.exception.PhoneBookCommonException;
import com.phone.book.request.ContactCreationRequest;
import com.phone.book.request.AccountInformationRequest;
import com.phone.book.response.ContactInformationResponse;

/**
 * @author vivek
 * 
 * interface for contact information details
 *
 */
public interface IAccountInformationSerive {

	ContactInformationResponse getContactInformation(AccountInformationRequest accountInformationRequest)throws PhoneBookCommonException;

	ContactInformationResponse createContactDetails(ContactCreationRequest accountCreationRequest)throws PhoneBookCommonException;
	
	ContactInformationResponse updateContactDetails(ContactCreationRequest accountCreationRequest)throws PhoneBookCommonException;
	
	 ContactInformationResponse deleteContactDetails(ContactCreationRequest accountCreationRequest)
				throws PhoneBookCommonException;

}
