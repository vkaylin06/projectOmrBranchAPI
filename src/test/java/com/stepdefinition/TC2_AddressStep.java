package com.stepdefinition;

import java.util.ArrayList;
/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all AddressStep information
 *
 */
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.GetAddress_Output_pojo;
import com.pojo.UpdateAddress_Input_pojo;
import com.pojo.UpdateAndDeleteAddress_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all AddressStep information
 *
 */
public class TC2_AddressStep extends BaseClass {
	public static String addId;

	/**
	 * @Description adding multiple headers
	 */
	@Given("User add headers")
	public void userAddHeaders() {

		// Headers
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		// provide space after Bearer
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logToken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * @Description adding address
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */
	@Given("User passes payload for adding address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userPassesPayloadForAddingAddress(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {
		AddAddress_Input_pojo input_pojo = new AddAddress_Input_pojo(first_name, last_name, mobile, apartment,
				Integer.parseInt(state), Integer.parseInt(city), Integer.parseInt(country), zipcode, address,
				address_type);
		addBody(input_pojo);
	}

	/**
	 * @Description send post request
	 * @return int
	 */
	@When("User send post request for addUserAddress endpoint")
	public int userSendPostRequestForAddUserAddressEndpoint() {
		response = responseType("POST", Endpoints.ADDADDRESS);
		statusCode = getResponseCode(response);
		return statusCode;
	}

	/**
	 * @Description verifying the actual and the expected message
	 * @param expected
	 * @return String
	 */

	@Then("User should verify the addUserAddress response body has message {string} and get address_Id")
	public String userShouldVerifyTheAddUserAddressResponseBodyHasMessageAndGetAddress_Id(String expected) {
		AddAddress_Output_pojo output_pojo = response.as(AddAddress_Output_pojo.class);
		String message = output_pojo.getMessage();
		Assert.assertEquals(message, expected, "verify Address added sucessfully");
		int address_id = output_pojo.getAddress_id();
		// covert the datatype of id to string // in AddAddress_Output_pojo only state,
		// city ,country have integer values
		addId = String.valueOf(address_id);
		return addId;
	}

	/**
	 * 
	 * @Description updating address
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */
	@Given("User passes payload for updating address{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userPassesPayloadForUpdatingAddress(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		UpdateAddress_Input_pojo input_pojo = new UpdateAddress_Input_pojo(addId, first_name, last_name, mobile,
				apartment, Integer.parseInt(state), Integer.parseInt(city), Integer.parseInt(country), zipcode, address,
				address_type);
		addBody(input_pojo);
	}

	/**
	 * @Description send put request
	 * @return int
	 */
	@When("User send put request for updateUserAddress endpoint")
	public int userSendPutRequestForUpdateUserAddressEndpoint() {
		response = responseType("PUT", Endpoints.UPDATEADDRESS);
		statusCode = getResponseCode(response);
		return statusCode;
	}

	/**
	 * @Description verifying the actual and the expected message
	 * @param expected
	 */
	@Then("User should verify the updateUserAddress response body has message {string}")
	public void userShouldVerifyTheUpdateUserAddressResponseBodyHasMessage(String expected) {
		UpdateAndDeleteAddress_Output_pojo output_pojo = response.as(UpdateAndDeleteAddress_Output_pojo.class);
		String message = output_pojo.getMessage();
		Assert.assertEquals(message, expected, "verify update address");
	}

	/**
	 * @Description deleting the address
	 */
	@Given("User passes payload for deleting address")
	public void userPassesPayloadForDeletingAddress() {
		DeleteAddress_Input_pojo input_pojo = new DeleteAddress_Input_pojo(addId);
		addBody(input_pojo);
	}

	/**
	 * @Description send delete request
	 * @return int
	 */
	@When("User send delete request for deleteAddress endpoint")
	public int userSendDeleteRequestForDeleteAddressEndpoint() {
		response = responseType("DELETE", Endpoints.DELETEADDRESS);
		statusCode = getResponseCode(response);
		return statusCode;

	}

	/**
	 * @Description verifying the actual and the expected message
	 * @param expected
	 */
	@Then("User should verify the deleteAddress response body has message {string}")
	public void userShouldVerifyTheDeleteAddressResponseBodyHasMessage(String expected) {
		UpdateAndDeleteAddress_Output_pojo output_pojo = response.as(UpdateAndDeleteAddress_Output_pojo.class);
		String message = output_pojo.getMessage();
		Assert.assertEquals(message, expected, "verify delete address");
	}

	/**
	 * @Description send get request
	 * @return int
	 */
	@When("User send get request for getUserAddress endpoint")
	public int userSendGetRequestForGetUserAddressEndpoint() {
		response = responseType("GET", Endpoints.GETADDRESS);
		statusCode = getResponseCode(response);
		return statusCode;
	}

	/**
	 * @Description verifying the actual and the expected message
	 * @param expected
	 */
	@Then("User should verify the getUserAddress response body has message {string}")
	public void userShouldVerifyTheGetUserAddressResponseBodyHasMessage(String expected) {
		GetAddress_Output_pojo output_pojo = response.as(GetAddress_Output_pojo.class);
		String message = output_pojo.getMessage();
		Assert.assertEquals(message, expected, "verify get address");
	}
}
