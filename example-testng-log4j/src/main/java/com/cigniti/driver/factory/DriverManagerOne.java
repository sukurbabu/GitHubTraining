package com.cigniti.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverManagerOne {

		public static ThreadLocal<WebDriver> wDriver = new ThreadLocal<WebDriver>();
		
		public static WebDriver getWebDriverOne() {
			return wDriver.get();
		}
		public static void setWebDriverOne(WebDriver driver) {
			wDriver.set(driver);
		}
		
}
