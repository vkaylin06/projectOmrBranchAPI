package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all TestRunnerClass information
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, dryRun = false, monochrome = true, plugin = { "pretty",
		"json:target/sample.json" }, features = "src\\test\\resources", glue = { "com.stepdefinition" })
public class TestRunnerClass {
	/**
	 * @Description for generation of jvm report that contains infomation  about passed and failed scenarios
	 */
	@AfterClass
	public static void afterclass() {
		Reporting.generateJVMReport(System.getProperty("user.dir") + "\\target\\sample.json");
	}
}
