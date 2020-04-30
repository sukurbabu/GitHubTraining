package com.cigniti.common.utilities;

public class Constants {

	public static String RUNMODE_COL = "Runmode";
	public static String DATA_SHEET = "TestData";
	
	public static String SUITE_SHEET = "Suite";
	public static String SUITENAME_COL ="SuiteName";
	
	
	public static String TESTCASE_SHEET = "TestCases";
	public static String TESTCASE_COL = "TestCases";
	
	public static String RUNMODE_YES = "Y";
	public static String RUNMODE_NO = "N";
	
	public static String SUITE_XL_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Smoke.xlsx";
	//public static String SUITE1_XL_PATH=System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Master.xlsx";
	public static String SUITE1_XL_PATH=System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx";
	

	//Database Constants
	public static final String dbDriver_Oracle =  "oracle.jdbc.driver.OracleDriver";
	public static final String dbDriver_SQLServer =  "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String dbDriver_MySQL =  "com.mysql.cj.jdbc.Driver";
	public static final String dbDriver_ACCESS =  "net.ucanaccess.jdbc.UcanaccessDriver";
}
