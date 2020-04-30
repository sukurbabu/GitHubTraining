package client.crm.Release1.Tests;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cigniti.ExtentReportUtilities.ExtentListeners;
import com.cigniti.ExtentReportUtilities.ExtentManager;
import com.cigniti.common.utilities.Constants;
import com.cigniti.common.utilities.DataUtil;
import com.cigniti.common.utilities.ExcelReader;
import com.cigniti.driver.factory.DriverFactory;
import com.cigniti.driver.factory.DriverManagerOne;
import com.cigniti.driver.factory.DriverType;
import com.cigniti.testbase.TestBase;

import client.crm.Pages.HomePage;
import client.crm.Pages.LoginPage;

public class HomeTest extends TestBase {

	private static final Logger log = LogManager.getLogger(HomeTest.class);
	public static ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);

	@Test()
	public void verifyHomeLinksideNavigationLink() throws IOException {
		if (!(DataUtil.isTestRunnable("verifyHomeLinksideNavigationLink", excel))) {
			throw new SkipException(
					"Skipping the test " + "verifyHomeLinksideNavigationLink".toUpperCase() + " as the Run mode is NO");
		}
		try {
			HomePage home = (HomePage) new HomePage().OpenPage(HomePage.class);
			home.verifyHomeLink();

		} catch (Exception e) {

		}
	}

	@Test()
	public void verifyCalendarLinksideNavigationLink() throws IOException {
		if (!(DataUtil.isTestRunnable("verifyCalendarLinksideNavigationLink", excel))) {
			throw new SkipException("Skipping the test " + "verifyCalendarLinksideNavigationLink".toUpperCase()
					+ " as the Run mode is NO");
		}
		try {
			HomePage home = (HomePage) new HomePage().OpenPage(HomePage.class);
			home.verifyCalendarLink();

		} catch (Exception e) {

		}
	}

	@Test()
	public void verifyContactsLinksideNavigationLink() throws IOException {
		if (!(DataUtil.isTestRunnable("verifyContactsLinksideNavigationLink", excel))) {
			throw new SkipException("Skipping the test " + "verifyContactsLinksideNavigationLink".toUpperCase()
					+ " as the Run mode is NO");
		}
		try {
			HomePage home = (HomePage) new HomePage().OpenPage(HomePage.class);
			home.verifyContctsLink();

		} catch (Exception e) {

		}
	}

	@Test()
	public void verifyCompaniesLinksideNavigationLink() throws IOException {
		if (!(DataUtil.isTestRunnable("verifyCompaniesLinksideNavigationLink", excel))) {
			throw new SkipException("Skipping the test " + "verifyCompaniesLinksideNavigationLink".toUpperCase()
					+ " as the Run mode is NO");
		}
		try {
			HomePage home = (HomePage) new HomePage().OpenPage(HomePage.class);
			home.verifyCompaniesLink();

		} catch (Exception e) {

		}
	}

	@Test()
	public void verifyDealsLinksideNavigationLink() throws IOException {
		if (!(DataUtil.isTestRunnable("verifyDealsLinksideNavigationLink", excel))) {
			throw new SkipException("Skipping the test " + "verifyDealsLinksideNavigationLink".toUpperCase()
					+ " as the Run mode is NO");
		}
		try {
			HomePage home = (HomePage) new HomePage().OpenPage(HomePage.class);
			home.verifyDealsLink();

		} catch (Exception e) {

		}
	}

	@Test()
	public void verifyTasksLinksideNavigationLink() throws IOException {
		if (!(DataUtil.isTestRunnable("verifyTasksLinksideNavigationLink", excel))) {
			throw new SkipException("Skipping the test " + "verifyTasksLinksideNavigationLink".toUpperCase()
					+ " as the Run mode is NO");
		}
		try {
			HomePage home = (HomePage) new HomePage().OpenPage(HomePage.class);
			home.verifyTasksLink();

		} catch (Exception e) {

		}
	}
	
	//@Test()
	public void verifyHomePagesideNavigationLinks() throws IOException {
		if (!(DataUtil.isTestRunnable("verifyHomePagesideNavigationLinks", excel))) {
			throw new SkipException("Skipping the test " + "verifyHomePagesideNavigationLinks".toUpperCase()
					+ " as the Run mode is NO");
		}
		HomePage home = (HomePage) new HomePage().OpenPage(HomePage.class);
		try {
			home.verifyHomeLink();
			home.verifyCalendarLink();
			home.verifyContctsLink();
			home.verifyCompaniesLink();
			home.verifyDealsLink();
			home.verifyTasksLink();
		} catch (Exception e) {

		}
	}
	
	
}
