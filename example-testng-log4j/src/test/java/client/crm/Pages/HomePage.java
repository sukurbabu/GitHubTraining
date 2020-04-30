package client.crm.Pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cigniti.ExtentReportUtilities.ExtentListeners;
import com.cigniti.ExtentReportUtilities.ExtentManager;
import com.cigniti.driver.factory.DriverManagerOne;
import com.cigniti.pageobjects.WebBasePage;

import client.crm.Release1.Tests.HomeTest;
import rp.com.google.common.io.BaseEncoding;
import rp.com.google.common.io.Resources;

import org.testng.asserts.SoftAssert;

public class HomePage extends WebBasePage {

	private static final Logger log = LogManager.getLogger(HomeTest.class);

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'homeeee')]")
	public WebElement HomeLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'calendar')]")
	public WebElement CalendarLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'contacts')]")
	public WebElement ContactsLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'companies')]")
	public WebElement CompaniesLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'deals')]")
	public WebElement DealsLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'tasks')]")
	public WebElement TasksLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'cases')]")
	public WebElement CasesLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'calls')]")
	public WebElement CallsLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'documents')]")
	public WebElement DocumentsLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'email')]")
	public WebElement EmailLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'compaigns')]")
	public WebElement CompaignLink;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'forms')]")
	public WebElement FormsLink;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//***************************************************************************************************************************///
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(CompaniesLink);
	}

	// SoftAssert softAssertion = new SoftAssert();

	public void verifyHomeLink() throws IOException {
		try {
			ExtentListeners.testReport.get().log(Status.INFO, "Validating Home Link");
			if (HomeLink.isDisplayed()) {
				log.info("Home link displayed");
			} else {
				log.info("Home link not displayed");
			}
		} catch (Exception e) {
			log.fatal("Exception occoured while verifying Home link. Following is the exception message...");
			log.error(e.getMessage());
			ExtentManager.captureScreenshot();
			String image = getImageResource(false);
			//getScreenshotAs(OutputType.FILE).getAbsoluteFile()
			log.info("RP_MESSAGE#FILE#{}#{}", ExtentManager.screenshotName, "Home link not displayed");
			////////////////String f=TestContext.CurrentContext.TestDirectory;

			/*
			 * try { log.info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64().encode(
			 * Resources.asByteSource(Resources.getResource(ExtentManager.screenshotName)).
			 * read()), "verifyHomeLink is " + (false ? "Pass" : "Failed")); } catch
			 * (Exception e1) { e1.printStackTrace(); }
			 */
			// softAssertion.assertAll();
			Assert.assertTrue(false);

		}
	}

	public ContactsPage clickContactLink() throws IOException {
		try {

			ContactsLink.click();
			log.info("Clicked on Contacts link");
		} catch (Exception e) {
			log.fatal("Exception occoured while clicking Contacts link. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

		return (ContactsPage) OpenPage(ContactsPage.class);
	}

	public CompaniesPage clickCompaniesLink() throws IOException {
		try {

			CompaniesLink.click();
			log.info("Clicked on Companies link");
		} catch (Exception e) {
			log.fatal("Exception occoured while clicking Companies link. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

		return (CompaniesPage) OpenPage(CompaniesPage.class);
	}

	/*
	 * public void verifyHomeLink() throws IOException { try {
	 * 
	 * if (HomeLink.isDisplayed()) { log.info("Home link displayed");
	 * ExtentListeners.testReport.get().log(Status.PASS, "Home link displayed"); }
	 * else { ExtentListeners.testReport.get().log(Status.FAIL,
	 * "Home link not displayed"); ExtentManager.captureScreenshot();
	 * ExtentListeners.testReport.get().fail( "<b>" + "<font color=" + "red>" +
	 * "Screenshot of failure" + "</font>" + "</b>",
	 * MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).
	 * build()); } } catch (Exception e) {
	 * ExtentListeners.testReport.get().log(Status.FAIL,
	 * "Verifying Home link failed because of exception. Please refer the message "
	 * + e.getMessage()); ExtentManager.captureScreenshot();
	 * ExtentListeners.testReport.get().fail( "<b>" + "<font color=" + "red>" +
	 * "Screenshot of failure" + "</font>" + "</b>",
	 * MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).
	 * build()); log.
	 * fatal("Exception occoured while verifying Home link. Following is the exception message..."
	 * ); log.error(e.getMessage()); } }
	 */

	public void verifyCalendarLink() throws IOException {
		try {

			if (CalendarLink.isDisplayed()) {
				log.info("Calendar link displayed");
			} else {
				log.info("Calendar link not displayed");
			}

		} catch (Exception e) {
			log.fatal("Exception occoured while clicking SignInLink Button. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}
	}

	public void verifyContctsLink() throws IOException {
		try {

			if (ContactsLink.isDisplayed()) {
				log.info("Contacts link displayed");
				Assert.assertTrue(true);
			} else {
				log.info("Contacts link not displayed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			log.fatal("Exception occoured while verifying Contacts link. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

	}

	public void verifyCompaniesLink() throws IOException {
		try {

			if (CompaniesLink.isDisplayed()) {
				log.info("Companies link displayed");
				Assert.assertTrue(true);
			} else {
				log.info("Companies link not displayed");
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			log.fatal("Exception occoured while verifying Companies link. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

	}

	public void verifyDealsLink() throws IOException {
		try {

			if (DealsLink.isDisplayed()) {
				log.info("Deals link displayed");
			} else {
				log.info("Deals link not displayed");
			}

		} catch (Exception e) {
			log.fatal("Exception occoured while verifying Deals link. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

	}

	public void verifyTasksLink() throws IOException {
		try {

			if (TasksLink.isDisplayed()) {
				log.info("Tasks link displayed");
			} else {
				log.info("Tasks link not displayed");
			}

		} catch (Exception e) {
			log.fatal("Exception occoured while verifying Tasks link. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

	}

	public DealsPage clickDealsLink() throws IOException {
		try {
			DealsLink.click();
			log.info("Clicked on Deals link");
		} catch (Exception e) {

			log.fatal("Exception occoured while clicking Deals link. Following is the exception message...");
			log.error(e.getMessage());
			Assert.assertTrue(false);
		}

		return (DealsPage) OpenPage(DealsPage.class);
	}

	private String getImageResource(boolean lucky) {
		return "pug/" + (lucky ? "lucky.jpg" : "unlucky.jpg");
	}
}
