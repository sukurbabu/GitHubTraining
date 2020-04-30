package com.cigniti.driver.factory;

public enum DriverType {
	
	  CHROME("CHROME"),
	  FIREFOX("FIREFOX"),
	  IE("IE"),
	  RCHROME("RCHROME"),
	  RFIREFOX("RFIREFOX"), 
	  RIE("RIE"), 
	  Android("Android"), 
	  iOS("iOS");
	 
	
	private String browser;
	DriverType(String browserType){
		browser=browserType;
	}
	
	String getBrowser() {
	      return browser;
	} 
}
