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

public class ContactsPage{

		
	@FindBy(how=How.XPATH, using="//div[text()='Contacts']")
	public WebElement ContactsText;
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//***************************************************************************************************************************///
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
