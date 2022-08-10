package com.stepdefinition;

import org.testng.Assert;

import com.base.BaseClass;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all CommonStep information
 *
 */
public class CommonStep extends BaseClass {
	/**
	 * @Description verifying the status code
	 * @param expected
	 */
	@Then("User should verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(Integer expected) {
		Assert.assertEquals(TC1_LoginStep.statusCode, expected.intValue(), "verify response code");
		Assert.assertEquals(TC2_AddressStep.statusCode, expected.intValue(), "verify response code");
		Assert.assertEquals(TC3_ChangeProfilePicStep.statusCode, expected.intValue(), "verify response code");
	}

}
