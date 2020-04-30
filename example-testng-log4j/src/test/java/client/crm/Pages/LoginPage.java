package client.crm.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cigniti.ExtentReportUtilities.ExtentListeners;
import com.cigniti.ExtentReportUtilities.ExtentManager;
import com.cigniti.driver.factory.DriverManagerOne;
import com.cigniti.pageobjects.WebBasePage;

public class LoginPage extends WebBasePage{

	
	@FindBy(how=How.XPATH, using="//input[@name='email']")
	public WebElement UsernameTextbox;
	
	
	@FindBy(how=How.XPATH, using="//input[@name='password']")
	public WebElement PasswordTextbox;
	
	@FindBy(how=How.XPATH, using="//div[text()='Login']")
	public WebElement LoginButton;
		
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//***************************************************************************************************************************///
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(UsernameTextbox);
	}
	

	public LoginPage open(String url,String sTitle) {
		try {
			//if(!DriverManagerOne.getWebDriver().getTitle().equalsIgnoreCase(sTitle)) {
				DriverManagerOne.getWebDriverOne().navigate().to(url);
				log.info("Navigating to the URL "+url);
				ExtentListeners.testReport.get().log(Status.PASS,"Launched CRM page");
			//}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (LoginPage) OpenPage(LoginPage.class);
	}

	public void enterUserName(String userName) throws IOException {
		try {
			//DriverManagerOne.getWebDriver().findElement(UsernameTextbox).sendKeys(userName);
			UsernameTextbox.sendKeys(userName);
			log.info("Entered "+userName+" in Username text field");
			ExtentListeners.testReport.get().log(Status.PASS,"Entered user name in "+userName+" User name text field");
		}catch(Exception e) {
			ExtentListeners.testReport.get().log(Status.FAIL,"Failed while entering Username, because of exception. Please refer the message "+e.getMessage());
			ExtentManager.captureScreenshot(); 
			ExtentListeners.testReport.get().fail(
					  "<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" +
					  "</b>",
					  MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).
					  build());
			log.fatal("Exception occoured during entering the value in User Name Text Field. Following is the exception message...");
			log.error(e.getMessage());
		}
	}
	
	public void enterPassword(String password) throws IOException {
		try {
			//DriverManagerOne.getWebDriver().findElement(PasswordTextbox).sendKeys(password);
			PasswordTextbox.sendKeys(password);
			log.info("Entered "+password+" in Password text field");
			ExtentListeners.testReport.get().log(Status.PASS,"Entered password in "+password+" password text field");
		}catch(Exception e) {
			ExtentListeners.testReport.get().log(Status.FAIL,"Failed while entering password, because of exception. Please refer the message "+e.getMessage());
			ExtentManager.captureScreenshot(); 
			ExtentListeners.testReport.get().fail(
					  "<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" +
					  "</b>",
					  MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).
					  build());
			log.fatal("Exception occoured during entering the value in Password Text Field. Following is the exception message...");
			log.error(e.getMessage());
		}
	}
	
	public void clickLoginButton() throws IOException {
		try {
			//DriverManagerOne.getWebDriver().findElement(LoginButton).click();
			LoginButton.click();
			log.info("Clicked SignInLink button");
			ExtentListeners.testReport.get().log(Status.PASS,"Clicked Sign in Link to login");
		}catch(Exception e) {
			ExtentListeners.testReport.get().log(Status.FAIL,"Clicking on SignInLink button failed because of exception. Please refer the message "+e.getMessage());
			ExtentManager.captureScreenshot(); 
			ExtentListeners.testReport.get().fail(
					  "<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" +
					  "</b>",
					  MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).
					  build());
			log.fatal("Exception occoured while clicking SignInLink Button. Following is the exception message...");
			log.error(e.getMessage());
		}
	}
	
	
	public HomePage Login(String userName,String password) throws IOException {
		try {
			enterUserName(userName);
			enterPassword(password);
			clickLoginButton();
			ExtentListeners.testReport.get().log(Status.PASS,"Login successful");
		}catch(Exception e) {
			//e.printStackTrace();
			ExtentListeners.testReport.get().log(Status.FAIL,"Login failed because of exception. Please refer the message "+e.getMessage());
			ExtentManager.captureScreenshot(); 
			ExtentListeners.testReport.get().fail(
					  "<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" +
					  "</b>",
					  MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).
					  build());
			log.fatal("Exception occoured while login to application. Following is the exception message...");
			log.error(e.getMessage());
		}
		return (HomePage) OpenPage(HomePage.class);
	}
}
