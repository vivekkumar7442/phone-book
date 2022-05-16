package com.phone.book.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.book.beans.ResponseResources;
import com.phone.book.beans.Status;
import com.phone.book.constant.Constants;
import com.phone.book.constant.SwaggerConstants;
import com.phone.book.exception.PhoneBookCommonException;
import com.phone.book.request.ContactCreationRequest;
import com.phone.book.request.AccountInformationRequest;
import com.phone.book.response.ContactInformationResponse;
import com.phone.book.service.IAccountInformationSerive;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author vivek This class have all the api related to contact information
 */
@RestController
@RequestMapping("/v1/account")
public class ContactAccountDetails {

	@Autowired
	IAccountInformationSerive iAccountInformationSerive;

	/**
	 * This method is used to create contact details
	 * 
	 * @throws PhoneBookCommonException
	 * 
	 */
	@ApiOperation(value = SwaggerConstants.ApiOperations.ACCOUNTDETAILS.GET_ACCOUNT_INFO)
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constants.SUCCESS, response = ContactInformationResponse.class),
			@ApiResponse(code = 403, message = Constants.FORBIDDEN),
			@ApiResponse(code = 422, message = Constants.NOT_FOUND),
			@ApiResponse(code = 417, message = Constants.EXCEPTION_FAILED) })
	public ResponseResources<ContactInformationResponse> createContactDetails(
			@RequestBody ContactCreationRequest accountCreationRequest) throws PhoneBookCommonException {
		ContactInformationResponse response = iAccountInformationSerive.createContactDetails(accountCreationRequest);
		return new ResponseResources<>(ResponseResources.R_CODE_OK, ResponseResources.RES_SUCCESS, response,
				Status.SUCCESS);

	}

	/**
	 * This method is used to update contact details
	 * 
	 * @throws PhoneBookCommonException
	 * 
	 */

	@ApiOperation(value = SwaggerConstants.ApiOperations.ACCOUNTDETAILS.GET_ACCOUNT_INFO)
	@PostMapping(path = "/updateContactDetails", consumes = "application/json", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constants.SUCCESS, response = ContactInformationResponse.class),
			@ApiResponse(code = 403, message = Constants.FORBIDDEN),
			@ApiResponse(code = 422, message = Constants.NOT_FOUND),
			@ApiResponse(code = 417, message = Constants.EXCEPTION_FAILED) })
	public ResponseResources<ContactInformationResponse> updateContactDetails(
			@RequestBody ContactCreationRequest accountCreationRequest) throws PhoneBookCommonException {
		ContactInformationResponse response = iAccountInformationSerive.updateContactDetails(accountCreationRequest);
		return new ResponseResources<>(ResponseResources.R_CODE_OK, ResponseResources.RES_SUCCESS, response,
				Status.SUCCESS);

	}

	/**
	 * This method is used to delete contact details
	 * 
	 * @throws PhoneBookCommonException
	 * 
	 */

	@ApiOperation(value = SwaggerConstants.ApiOperations.ACCOUNTDETAILS.GET_ACCOUNT_INFO)
	@PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constants.SUCCESS, response = ContactInformationResponse.class),
			@ApiResponse(code = 403, message = Constants.FORBIDDEN),
			@ApiResponse(code = 422, message = Constants.NOT_FOUND),
			@ApiResponse(code = 417, message = Constants.EXCEPTION_FAILED) })
	public ResponseResources<ContactInformationResponse> deleteContactDetails(
			@RequestBody ContactCreationRequest accountCreationRequest) throws PhoneBookCommonException {
		ContactInformationResponse response = iAccountInformationSerive.deleteContactDetails(accountCreationRequest);
		return new ResponseResources<>(ResponseResources.R_CODE_OK, ResponseResources.RES_SUCCESS, response,
				Status.SUCCESS);

	}

	/**
	 * This method is used to get contact information search
	 * 
	 * @throws PhoneBookCommonException
	 * 
	 */

	@ApiOperation(value = SwaggerConstants.ApiOperations.ACCOUNTDETAILS.GET_ACCOUNT_INFO)
	@PostMapping(path = "/info", consumes = "application/json", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constants.SUCCESS, response = ContactInformationResponse.class),
			@ApiResponse(code = 403, message = Constants.FORBIDDEN),
			@ApiResponse(code = 422, message = Constants.NOT_FOUND),
			@ApiResponse(code = 417, message = Constants.EXCEPTION_FAILED) })
	public ResponseResources<ContactInformationResponse> getContactInformation(
			@RequestBody AccountInformationRequest accountInformationRequest) throws PhoneBookCommonException {
		ContactInformationResponse response = iAccountInformationSerive
				.getContactInformation(accountInformationRequest);
		return new ResponseResources<>(ResponseResources.R_CODE_OK, ResponseResources.RES_SUCCESS, response,
				Status.SUCCESS);

	}

}
