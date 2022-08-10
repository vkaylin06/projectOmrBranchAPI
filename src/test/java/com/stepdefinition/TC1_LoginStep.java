package com.stepdefinition;

import org.testng.Assert;
import com.base.BaseClass;
import com.config.Configuration;
import com.endpoints.Endpoints;
import com.pojo.Login_Output_pojo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all LoginStep information
 *
 */
public class TC1_LoginStep extends BaseClass {

	public static String logToken;

	/**
	 * @Description adding header
	 */
	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}

	/**
	 * @Description adding basic authentication
	 */
	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() {
		basicAuth(Configuration.EMAILADDRESS, Configuration.PASSWORD);
	}

	/**
	 * @Description send post request
	 * @return int
	 */
	@When("User send post request for login endpoint")
	public int userSendPostRequestForLoginEndpoint() {
		response = responseType("POST", Endpoints.POSTMANBASICAUTHLOGIN);
		statusCode = getResponseCode(response);
		return statusCode;
	}

	/**
	 * @Description verifying the response body first_name
	 * @param expected
	 * @return int
	 */
	@Then("User verify the login response body first name is {string} and get logtoken should be saved")
	public String userVerifyTheLoginResponseBodyFirstNameIsAndGetLogtokenShouldBeSaved(String expected) {

		Login_Output_pojo output_pojo = response.as(Login_Output_pojo.class);
		String first_name = output_pojo.getData().getFirst_name();
		Assert.assertEquals(first_name, expected, "verify first name");
		logToken = output_pojo.getData().getLogtoken();
		System.out.println(logToken);
		return logToken;
	}
}
