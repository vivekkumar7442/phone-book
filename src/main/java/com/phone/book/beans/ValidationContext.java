package com.phone.book.beans;

/**
 * @author vivek Validation contest input used store the input for validation
 *         rules
 *
 */
public class ValidationContext {

	private String phoneNumber;

	private String countryCode;

	private String validationType;

	public String getValidationType() {
		return validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
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

}
