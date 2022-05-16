package com.phone.book.response;

import java.util.ArrayList;
import java.util.List;

import com.phone.book.beans.ContactDetailsBean;

/**
 * @author vivek
 * 
 *         this class has all the attribute for contact info
 *         response
 *
 */
public class ContactInformationResponse extends BaseResponse {

	private String firstName;

	private String middleName;

	private String lastName;

	private String countryCode;

	private String phoneNumber;

	private List<ContactDetailsBean> contactDetails;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<ContactDetailsBean> getContactDetails() {
		
		if(contactDetails==null) {
			contactDetails=new ArrayList<>();
		}
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetailsBean> contactDetails) {
		this.contactDetails = contactDetails;
	}

}
