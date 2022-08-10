package com.base;

import java.io.File;

import com.config.Configuration;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all the Reusable codes in one class
 *
 */
public class BaseClass {
	public RequestSpecification reqSp;
	public static Response response;
	public static int statusCode;

	/**
	 * @Description reusable code for adding one header
	 * @param key
	 * @param value
	 */
	public void addHeader(String key, String value) {
		reqSp = RestAssured.given().header(key, value);
	}

	/**
	 * @Description reusable code for adding multiple header
	 * @param headers
	 */
	public void addHeaders(Headers headers) {
		reqSp = RestAssured.given().headers(headers);
	}

	/**
	 * @Description reusable code for adding basic authentication
	 * @param username
	 * @param password
	 */
	public void basicAuth(String username, String password) {
		reqSp = reqSp.auth().preemptive().basic(username, password);

	}

	/**
	 * @Description reusable code for query param
	 * @param key
	 * @param value
	 */
	public void queryParam(String key, String value) {
		reqSp = reqSp.queryParam(key, value);

	}

	/**
	 * @Description reusable code for path param
	 * @param key
	 * @param value
	 */
	public void pathParam(String key, String value) {
		reqSp = reqSp.pathParam(key, value);

	}

//body to send //the method body specifies a string request body that will be send with the request
	/**
	 * @Description reusable code for adding String body
	 * @param body
	 */
	public void addBody(String body) {
		reqSp = reqSp.body(body);

	}

	/**
	 * @Description reusable code for adding object body
	 * @param body
	 */
	public void addBody(Object body) {
		reqSp = reqSp.body(body);

	}

	/**
	 * @Description reusable code for form data
	 */
	public void formData() {
		reqSp.multiPart("profile_picture", new File(System.getProperty("user.dir") + Configuration.PROFILEPICPATH));
	}

	/**
	 * @Description reusable code for Response type
	 * @param type
	 * @param endPoint
	 * @return Response
	 */
	public Response responseType(String type, String endPoint) {

		switch (type) {
		case "GET":
			response = reqSp.log().all().get(endPoint);
			break;
		case "POST":
			response = reqSp.log().all().post(endPoint);

			break;

		case "PUT":
			response = reqSp.log().all().put(endPoint);
			break;

		case "DELETE":
			response = reqSp.log().all().delete(endPoint);

			break;

		default:
			System.out.println("Invalid method Type");
			break;
		}

		return response;
	}

	/**
	 * @Description reusable code for status code
	 * @param response
	 * @return int
	 */
	public int getResponseCode(Response response) {

		statusCode = response.getStatusCode();
		return statusCode;
	}

	/**
	 * @Description reusable code for getResBodyAsString
	 * @param response
	 * @return String
	 */
	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;

	}

	/**
	 * @Description reusable code for getResBodyAsPrettyString
	 * @param response
	 * @return String
	 */
	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}

}
