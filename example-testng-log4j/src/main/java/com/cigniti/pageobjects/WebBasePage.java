package com.cigniti.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cigniti.ExtentReportUtilities.ExtentListeners;
import com.cigniti.driver.factory.DriverManagerOne;
import com.cigniti.testbase.TestBase;

public abstract  class WebBasePage<T> {

	protected WebDriver driver;
	public Logger log =Logger.getLogger(WebBasePage.class);
	public WebBasePage() {
		this.driver=DriverManagerOne.getWebDriverOne();
		//this.driver=driver;
	}
	
	public T OpenPage(Class <T> clazz) {
		T page=null;
		driver=DriverManagerOne.getWebDriverOne();
		AjaxElementLocatorFactory ajaxElementFactory=new AjaxElementLocatorFactory(driver,10);
		page=PageFactory.initElements(driver, clazz);
		PageFactory.initElements(ajaxElementFactory, page);
		ExpectedCondition pageLoadCondition=((WebBasePage) page).getPageLoadCondition();
		waitForPageToLoad(pageLoadCondition);
		
		return page;
		
	}
	
	protected abstract ExpectedCondition getPageLoadCondition() ;

	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(pageLoadCondition);
		
	}
		
}
