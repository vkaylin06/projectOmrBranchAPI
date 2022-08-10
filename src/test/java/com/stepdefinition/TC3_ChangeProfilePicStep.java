package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all ChangeProfilePicStep information
 *
 */
public class TC3_ChangeProfilePicStep extends BaseClass {
	/**
	 * @Description adding multiple headers
	 */
	@Given("User adds headers for form data")
	public void userAddsHeadersForFormData() {
		// Headers
		List<Header> h = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		// provide space after Bearer
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logToken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * @Description passing form data
	 */
	@Given("User passes form data as payload to change profile picture")
	public void userPassesFormDataAsPayloadToChangeProfilePicture() {
		formData();
	}

	/**
	 * @Description send post request
	 * @return int
	 */
	@When("User send post request for changeProfilePic endpoint")
	public int userSendPostRequestForChangeProfilePicEndpoint() {
		response = responseType("POST", Endpoints.POSTPROFILEPIC);
		statusCode = getResponseCode(response);
		return statusCode;
	}

	/**
	 * @Description verifying the actual and the expected message
	 * @param expected
	 */
	@Then("User verify the changeProfilePic response body message {string}")
	public void userVerifyTheChangeProfilePicResponseBodyMessage(String expected) {
		ChangeProfilePic_Output_pojo output_pojo = response.as(ChangeProfilePic_Output_pojo.class);
		String message = output_pojo.getMessage();
		Assert.assertEquals(message, expected, "verify Profile updated Successfully");
	}

}
