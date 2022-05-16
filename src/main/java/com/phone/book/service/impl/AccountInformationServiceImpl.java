package com.phone.book.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.book.beans.ResponseResources;
import com.phone.book.beans.ValidationContext;
import com.phone.book.beans.ValidationResult;
import com.phone.book.constant.ContactStatusConstant;
import com.phone.book.entity.ContactDetails;
import com.phone.book.exception.ExceptionConstants;
import com.phone.book.exception.PhoneBookCommonException;
import com.phone.book.request.ContactCreationRequest;
import com.phone.book.request.AccountInformationRequest;
import com.phone.book.response.ContactInformationResponse;
import com.phone.book.service.IAccountInformationSerive;
import com.phone.book.service.IPhoneNumberValidation;
import com.phone.book.service.IPhoneValidationHelperService;
import com.phone.book.specification.ContactSpecification;

/**
 * @author vivek
 * 
 *         AccountInformationServiceImpl for exposing contact related
 *         information
 *
 */
@Service
public class AccountInformationServiceImpl extends AccountInformationAbstractService
		implements IAccountInformationSerive {

	@Autowired
	private IPhoneValidationHelperService iTransactionHelperService;

	@Override
	@Transactional
	public ContactInformationResponse createContactDetails(ContactCreationRequest accountCreationRequest)
			throws PhoneBookCommonException {

		ContactInformationResponse accountInformationResponse = new ContactInformationResponse();

		accountCreationInputValidation(accountCreationRequest);

		ValidationContext validationContext = construcValidationContext(accountCreationRequest.getPhoneNumber(),
				accountCreationRequest.getCountryCode());
		IPhoneNumberValidation transactionValidation = iTransactionHelperService
				.getValidationType(validationContext.getValidationType());

		ValidationResult validationResult = transactionValidation.validate(validationContext);

		if (validationResult.notValid()) {
			throw new PhoneBookCommonException(validationResult.getErrorMsg(), ResponseResources.R_CODE_ERROR);
		}

		ContactDetails existingContact = accountRepository.findByCountryCodeAndPhoneNumber(
				accountCreationRequest.getCountryCode(), accountCreationRequest.getPhoneNumber());

		if (existingContact != null) {
			throw new PhoneBookCommonException(ExceptionConstants.ACCOUNT_ALREADY_EXIST,
					ResponseResources.R_CODE_ERROR);
		}

		ContactDetails accountDetails = createAccounDetails(accountCreationRequest);
		BeanUtils.copyProperties(accountDetails, accountInformationResponse);

		return accountInformationResponse;
	}

	@Override
	@Transactional
	public ContactInformationResponse updateContactDetails(ContactCreationRequest accountCreationRequest)
			throws PhoneBookCommonException {

		ContactInformationResponse accountInformationResponse = new ContactInformationResponse();

		accountCreationInputValidation(accountCreationRequest);

		ContactDetails existingContact = accountRepository.findByCountryCodeAndPhoneNumber(
				accountCreationRequest.getCountryCode(), accountCreationRequest.getPhoneNumber());

		if (existingContact != null) {
			throw new PhoneBookCommonException(ExceptionConstants.ACCOUNT_ALREADY_EXIST,
					ResponseResources.R_CODE_ERROR);
		}

		ContactDetails accountDetails = updateContactDetails(accountCreationRequest, existingContact);
		BeanUtils.copyProperties(accountDetails, accountInformationResponse);

		return accountInformationResponse;
	}

	@Override
	@Transactional
	public ContactInformationResponse deleteContactDetails(ContactCreationRequest accountCreationRequest)
			throws PhoneBookCommonException {

		ContactInformationResponse accountInformationResponse = new ContactInformationResponse();

		accountCreationInputValidation(accountCreationRequest);

		ContactDetails existingContact = accountRepository.findByCountryCodeAndPhoneNumber(
				accountCreationRequest.getCountryCode(), accountCreationRequest.getPhoneNumber());

		if (existingContact != null) {
			throw new PhoneBookCommonException(ExceptionConstants.ACCOUNT_ALREADY_EXIST,
					ResponseResources.R_CODE_ERROR);
		}
		accountRepository.delete(existingContact);
		return accountInformationResponse;
	}

	@Override
	public ContactInformationResponse getContactInformation(AccountInformationRequest accountInformationRequest)
			throws PhoneBookCommonException {
		ContactInformationResponse accountInformationResponse = new ContactInformationResponse();

		List<ContactDetails> contactDetails = accountRepository
				.findAll(ContactSpecification.getContactFilter(accountInformationRequest.getFirstName(),
						accountInformationRequest.getLastName(), accountInformationRequest.getMiddleName(),
						accountInformationRequest.getPhoneNumber(), accountInformationRequest.getCountryCode()));

		return constructAccounResponse(contactDetails, accountInformationResponse);

	}

	private ContactInformationResponse constructAccounResponse(List<ContactDetails> contactDetails,
			ContactInformationResponse accountInformationResponse) {

		contactDetails.forEach(contact -> {
			com.phone.book.beans.ContactDetailsBean contactBean = new com.phone.book.beans.ContactDetailsBean();
			BeanUtils.copyProperties(contactDetails, contactBean);
			accountInformationResponse.getContactDetails().add(contactBean);
		});
		return accountInformationResponse;
	}

	private void accountCreationInputValidation(ContactCreationRequest accountCreationRequest)
			throws PhoneBookCommonException {

		if (accountCreationRequest == null) {
			throw new PhoneBookCommonException(ExceptionConstants.REQUEST_CANNOT_BE_NULL,
					ResponseResources.R_CODE_BAD_REQUEST);
		}

		if (accountCreationRequest.getPhoneNumber() == null) {
			throw new PhoneBookCommonException(ExceptionConstants.PHONE_NUMBER_CANNOT_BE_NULL,
					ResponseResources.R_CODE_ERROR);
		}
	}

	private ValidationContext construcValidationContext(String phoneNumber, String countryCode) {
		ValidationContext validationContext = new ValidationContext();
		validationContext.setPhoneNumber(phoneNumber);
		validationContext.setCountryCode(countryCode);
		validationContext.setValidationType(ContactStatusConstant.PHONE_NUMBER_VALIDATION);
		return validationContext;
	}

}
