package com.cigniti.driver.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {
	private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap();

	public Logger log = Logger.getLogger(DriverFactory.class);
	public static Properties config = new Properties();
	static DesiredCapabilities cap = null;

	// chrome driver supplier
	private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
		WebDriver driver = null;
		DriverExeFactory.setChromeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", DriverExeFactory.getChromeDriverExePath());
		driver = new ChromeDriver();
		DriverManagerOne.setWebDriverOne(driver);
		return driver;
	};

// firefox driver supplier
	private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
		WebDriver driver = null;
		DriverExeFactory.setChromeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", DriverExeFactory.getGecoDriverExePath());
		driver = new FirefoxDriver();
		DriverManagerOne.setWebDriverOne(driver);
		return driver;
	};
// IE driver supplier
	private static final Supplier<WebDriver> IEDriverSupplier = () -> {
		WebDriver driver = null;
		DriverExeFactory.setChromeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", DriverExeFactory.getIeDriverExePath());
		driver = new InternetExplorerDriver();
		DriverManagerOne.setWebDriverOne(driver);
		return driver;
	};
// Remote Chrome supplier
	private static final Supplier<WebDriver> remotechromeDriverSupplier = () -> {
		WebDriver driver = null;

		cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("disable-infobars");
		 * //cap.setCapability(ChromeOptions.CAPABILITY, options);
		 */
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.1.8:5555/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DriverManagerOne.setWebDriverOne(driver);
		return driver;
	};
// Remote firefox supplier
	private static final Supplier<WebDriver> remotefirfoxDriverSupplier = () -> {
		WebDriver driver = null;
		cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.ANY);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DriverManagerOne.setWebDriverOne(driver);
		return driver;
	};
// Remote IE supplier
	private static final Supplier<WebDriver> remoteieDriverSupplier = () -> {
		WebDriver driver = null;
		cap = DesiredCapabilities.internetExplorer();
		cap.setBrowserName("iexplore");
		cap.setPlatform(Platform.WIN8);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DriverManagerOne.setWebDriverOne(driver);
		return driver;
	};


	static {
		driverMap.put(DriverType.CHROME, chromeDriverSupplier);
		driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
		driverMap.put(DriverType.IE, IEDriverSupplier);
		driverMap.put(DriverType.RCHROME, remotechromeDriverSupplier);
		driverMap.put(DriverType.RFIREFOX, remotefirfoxDriverSupplier);
		driverMap.put(DriverType.RIE, remoteieDriverSupplier);
	}

// return a new driver from the map
	public static final WebDriver getDriver(DriverType type) {
		return driverMap.get(type).get();
	}


}
