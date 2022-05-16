package com.phone.book.objectcreator;

import org.springframework.stereotype.Component;

import com.phone.book.request.ContactCreationRequest;

@Component
public class PhoneBookObjectCreator {

	public ContactCreationRequest getPhoneAccountCreationRequest() {
		ContactCreationRequest accountDetails = new ContactCreationRequest();
		accountDetails.setPhoneNumber("9700987651");
		accountDetails.setCountryCode("65");
		accountDetails.setFirstName("JOHN");
		accountDetails.setLastName("DEO");
		accountDetails.setMiddleName("L");
		return accountDetails;
	}
	
	public ContactCreationRequest updateContactInfo() {
		ContactCreationRequest accountDetails = new ContactCreationRequest();
		accountDetails.setPhoneNumber("9700987651");
		accountDetails.setCountryCode("65");
		accountDetails.setFirstName("Vivek");
		accountDetails.setLastName("Kumar");
		accountDetails.setMiddleName("L");
		return accountDetails;
	}


}
