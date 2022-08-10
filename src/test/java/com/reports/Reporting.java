package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all Reporting class information
 *
 */
public class Reporting {
	/**
	 * @Description for producing jvm report
	 * @param jsonFile
	 */
	public static void generateJVMReport(String jsonFile) {

		File file = new File("C:\\Users\\ACER\\eclipse-workspace\\OMRBranchAPIAutomation\\target");

		Configuration c = new Configuration(file, "OMRBranchAPIAutomation");
		c.addClassifications("BrowserName", "Chrome");
		c.addClassifications("BrowserVersion", "103");
		c.addClassifications("OS", "WIN10");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, c);
		builder.generateReports();

	}
}
