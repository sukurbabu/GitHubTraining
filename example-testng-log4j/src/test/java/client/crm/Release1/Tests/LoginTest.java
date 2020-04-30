package client.crm.Release1.Tests;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.crm.Pages.HomePage;
import client.crm.Pages.LoginPage;

public class LoginTest extends TestBase {

	private static final Logger log = LogManager.getLogger(LoginTest.class);
	public static ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);

	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "mdp")
	public void loginCRMTest(Hashtable<String, String> data) {
		
		if (!(DataUtil.isTestRunnable("loginCRMTest", excel))) {
			throw new SkipException("Skipping the test " + "loginCRMTest".toUpperCase() + " as the Run mode is NO");
		}
		if (!data.get("Runmode").equalsIgnoreCase("Y")) {
			throw new SkipException("Skipping the iteration as the test data Run Mode is No");
		}
		try 
		{
			LoginPage login = new LoginPage().open(config.getProperty("testurl"),config.getProperty("LoginTitle"));
			log.info("Test URL : {}",config.getProperty("testurl"));
			log.info("Login Title : {}",config.getProperty("LoginTitle"));
			HomePage home = login.Login(data.get("Username"), data.get("Password"));
			log.info("User Name : {}",data.get("Username"));
			log.info("Password : {}",data.get("Password"));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @AfterTest public void teardown() { DriverManagerOne.getWebDriver().close(); }
	 */
}
