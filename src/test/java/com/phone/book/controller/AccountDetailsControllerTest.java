package com.phone.book.controller;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.phone.book.beans.ResponseResources;
import com.phone.book.beans.Status;
import com.phone.book.controller.v1.ContactAccountDetails;
import com.phone.book.exception.PhoneBookCommonException;
import com.phone.book.objectcreator.PhoneBookObjectCreator;
import com.phone.book.request.ContactCreationRequest;
import com.phone.book.request.AccountInformationRequest;
import com.phone.book.response.ContactInformationResponse;

/**
 * @author vivek
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration
public class AccountDetailsControllerTest {

	@Autowired
	private ContactAccountDetails accountDetailsController;

	@Autowired
	private PhoneBookObjectCreator phoneBookObjectCreator;

	@org.junit.Before
	public void init() throws PhoneBookCommonException {
		ContactCreationRequest accountCreationRequest = phoneBookObjectCreator.getPhoneAccountCreationRequest();
		accountDetailsController.createContactDetails(accountCreationRequest);
	}

	@Test
	public void testAccountCreation() throws PhoneBookCommonException {
		ContactCreationRequest accountCreationRequest = phoneBookObjectCreator.getPhoneAccountCreationRequest();
		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.createContactDetails(accountCreationRequest);
		assertTrue(response != null && response.getStatus() == Status.SUCCESS);
	}

	@Test
	public void testAccountCreationWithEmptyRequest() throws PhoneBookCommonException {
		ContactCreationRequest accountCreationRequest = new ContactCreationRequest();
		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.createContactDetails(accountCreationRequest);
		assertTrue(response != null && response.getStatus() == Status.FAILURE
				&& response.getMessage().equalsIgnoreCase("Account Name cannot be Empty"));
	}

	@Test
	public void testAccountCreationWithNullRequest() throws PhoneBookCommonException {
		ResponseResources<ContactInformationResponse> response = accountDetailsController.createContactDetails(null);
		assertTrue(response != null && response.getStatus() == Status.FAILURE
				&& response.getMessage().equalsIgnoreCase("Request cannot be null"));
	}

	@Test
	public void testAccountInformation() throws PhoneBookCommonException {
		AccountInformationRequest accountInformationRequest = new AccountInformationRequest();
		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.getContactInformation(accountInformationRequest);
		assertTrue(response != null && response.getStatus() == Status.SUCCESS);
	}

	@Test
	public void testAccountWithInvalidAccountNumber() throws PhoneBookCommonException {
		AccountInformationRequest accountInformationRequest = new AccountInformationRequest();
		accountInformationRequest.setPhoneNumber("9700987651");
		accountInformationRequest.setPhoneNumber("65");

		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.getContactInformation(accountInformationRequest);
		assertTrue(response != null && response.getStatus() == Status.FAILURE
				&& response.getMessage().equalsIgnoreCase("Account Not exists"));
	}

	@Test
	public void testAccountInformationWithEmptyRequest() throws PhoneBookCommonException {
		AccountInformationRequest accountInformationRequest = new AccountInformationRequest();
		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.getContactInformation(accountInformationRequest);
		assertTrue(response != null && response.getStatus() == Status.FAILURE
				&& response.getMessage().equalsIgnoreCase("Account Number cannot be Empty"));
	}

	@Test
	public void testAccountInformationWithNullRequest() throws PhoneBookCommonException {
		ResponseResources<ContactInformationResponse> response = accountDetailsController.getContactInformation(null);
		assertTrue(response != null && response.getStatus() == Status.FAILURE
				&& response.getMessage().equalsIgnoreCase("Request cannot be null"));
	}

	@Test
	public void testUpdateContactDetails() throws PhoneBookCommonException {
		ContactCreationRequest accountCreationRequest = phoneBookObjectCreator.getPhoneAccountCreationRequest();
		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.updateContactDetails(accountCreationRequest);
		assertTrue(response != null && response.getStatus() == Status.SUCCESS
				&& response.getData().getFirstName().equalsIgnoreCase("Vivek"));
	}

	@Test
	public void testdeleteContactDetails() throws PhoneBookCommonException {
		ContactCreationRequest accountCreationRequest = new ContactCreationRequest();
		accountCreationRequest.setPhoneNumber("9700987651");
		accountCreationRequest.setPhoneNumber("65");
		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.deleteContactDetails(accountCreationRequest);
		assertTrue(response != null && response.getStatus() == Status.SUCCESS
				&& response.getData().getFirstName().equalsIgnoreCase("Vivek"));
	}

	@Test
	public void searchContactInfor() throws PhoneBookCommonException {
		ContactCreationRequest accountCreationRequest = new ContactCreationRequest();
		accountCreationRequest.setPhoneNumber("9700987651");
		accountCreationRequest.setPhoneNumber("65");
		ResponseResources<ContactInformationResponse> response = accountDetailsController
				.deleteContactDetails(accountCreationRequest);
		assertTrue(response != null && response.getStatus() == Status.SUCCESS
				&& response.getData().getContactDetails().size() > 0);
	}

}