package client.crm.Release1.Tests;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

import client.crm.Pages.ContactsPage;
import client.crm.Pages.HomePage;
import client.crm.Pages.LoginPage;

public class ContactsTest extends TestBase {

	public static ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);

	
	@Test()
	public void ValidateNewContactsFunctionality() throws IOException {
		if (!(DataUtil.isTestRunnable("ValidateNewContactsFunctionality", excel))) {
			throw new SkipException("Skipping the test " + "ValidateNewContactsFunctionality".toUpperCase() + " as the Run mode is NO");
		}
		try {
			 HomePage home=(HomePage) new HomePage().OpenPage(HomePage.class);
			 ContactsPage contacts=home.clickContactLink();
			
		} catch (Exception e) {
			
		}
	}
	
}
