package com.cigniti.ExtentReportUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.*;
import com.cigniti.driver.factory.DriverFactory;
import com.cigniti.driver.factory.DriverManagerOne;

public class ExtentManager {

	private static ExtentReports extent;
	    public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	              
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	       // htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setDocumentTitle("Application Results");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("Test Execution Report");
	       
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Sukur Babu");
	        extent.setSystemInfo("Organization", "Cigniti Technologies");
	        extent.setSystemInfo("Build no", "Sample Application");
	                
	        return extent;
	    }
	    
	    public static String screenshotPath;
		public static String screenshotName;
		public static String timeStamp;
		public static void captureScreenshot() {
			    
			File scrFile = ((TakesScreenshot) DriverManagerOne.getWebDriverOne()).getScreenshotAs(OutputType.FILE);
			Date d = new Date();
			timeStamp= d.toString().replace(":", "_").replace(" ", "_");
			screenshotName = System.getProperty("user.dir") + "\\Reports\\" +timeStamp+ "\\"+ timeStamp + ".jpg";

			try {
				//FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\Reports\\" +timeStamp+ "\\"+ screenshotName));
				FileUtils.copyFile(scrFile, new File(screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}
	}
