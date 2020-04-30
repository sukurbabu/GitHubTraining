package com.cigniti.common.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class DataUtil {
	public static void checkExecution(String testSuiteName, String testCaseName, String dataRunMode,ExcelReader excel) {
		if (!isSuiteRunnable(testSuiteName)) {
			throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Suite : "
					+ testSuiteName + " is NO");
		}
		if (!isTestRunnable(testCaseName,excel)) {
			throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Case : "
					+ testCaseName + " is NO");
		}
		if(dataRunMode.equalsIgnoreCase(Constants.RUNMODE_NO)){			
			throw new SkipException("Skipping the test : "+testCaseName+" as the Run mode to Data set is NO");
		}
	}
	public static boolean isSuiteRunnable(String suiteName) {
		ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH);
		int rows = excel.getRowCount(Constants.SUITE_SHEET);
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			String data = excel.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COL, rowNum);
			if (data.equals(suiteName)) {
				String runmode = excel.getCellData(Constants.SUITE_SHEET, Constants.RUNMODE_COL, rowNum);
				if (runmode.equals(Constants.RUNMODE_YES))
					return true;
				else
					return false;

			}

		}
		return false;
	}

	@DataProvider(name="mdp")
	public Object[][] getData(Method m)
	{
		String sheetName=m.getName();
		
		int rowCnt=ExcelReader.getRowCount(sheetName);
		int colCnt=ExcelReader.getColumnCount(sheetName);
		Object[][] data=null;
		//Object[][] data=new Object[rowCnt-1][1];
		//Hashtable<String,String> table=null;
		try {
		if(rowCnt==1) {
			data=new Object[rowCnt-1][1];
			Hashtable<String,String> table=null;
			table=new Hashtable<String,String>();
			table.put(ExcelReader.getCellData(sheetName, 1, 1), ExcelReader.getCellData(sheetName, 1, 1));
		}
		else if(rowCnt>1){
			for(int row=2;row<=rowCnt;row++)
			{
				data=new Object[rowCnt-1][1];
				Hashtable<String,String> table=null;
				table=new Hashtable<String,String>();
				for(int col=0;col<colCnt;col++)
				{
					//data[,]=excel.getCellData(sheetName, col, row);
					table.put(ExcelReader.getCellData(sheetName, col, 1), ExcelReader.getCellData(sheetName, col, row));
					data[row-2][0]=table;
				}
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="Test_suite";
		int rows = excel.getRowCount(sheetName);
		
		
		for(int rNum=2; rNum<=rows; rNum++){
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName.replace(" ", ""))){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
			
		}
		return false;
	}
}
