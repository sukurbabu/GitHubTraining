package com.cigniti.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cigniti.ExtentReportUtilities.ExtentListeners;
import com.cigniti.driver.factory.DriverExeFactory;
import com.cigniti.driver.factory.DriverFactory;
import com.cigniti.driver.factory.DriverManagerOne;
import com.cigniti.driver.factory.DriverType;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.Listeners;

public class TestBase {

	private WebDriver driver;
	public static Properties config = new Properties();
	private FileInputStream fis;
	public Logger log = LogManager.getLogger(TestBase.class);

	@BeforeSuite
	@Parameters("Browser")
	public void setUpFramework(@Optional("Chrome") String browser) {
		// configureLogging();
		DriverExeFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverExeFactory.setConfigPropertyFile(
				System.getProperty("user.dir") + "//src//test//resources//properties//config.properties");
		if (System.getProperty("os.name").contains("mac")) {
			DriverExeFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");
			DriverExeFactory.setGecoDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//gecodriver");

		} else {
			DriverExeFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
			DriverExeFactory.setGecoDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
			DriverExeFactory.setIeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");
		}
		try {
			fis = new FileInputStream(DriverExeFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			//log.info("Configuration file loaded!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!browser.equalsIgnoreCase("Android"))
			launchBrowser(browser);
	}

	public void configureLogging() {
		// String
		// log4jConfigFile=System.getProperty("user.dir")+"//src//test//resources//properties//log4j.properties";
		String log4jConfigFile = System.getProperty("user.dir") + "//src/main//logback.xml";
		PropertyConfigurator.configure(log4jConfigFile);
	}

	public void launchBrowser(String browser) {
		driver = DriverFactory.getDriver(DriverType.valueOf(browser));
		
		//log.info("Browser launched {}");
		DriverManagerOne.setWebDriverOne(driver);
		DriverManagerOne.getWebDriverOne().manage().window().maximize();
		DriverManagerOne.getWebDriverOne().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// DriverManagerOne.getWebDriver().navigate().to(config.getProperty("testurl"));
	}

	public void logInfo(String message) {
		ExtentListeners.testReport.get().info(message);
	}

	public void quit() {
		DriverManagerOne.getWebDriverOne().quit();
	}

}
