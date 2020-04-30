package com.cigniti.driver.factory;

public class DriverExeFactory {

		private static String chromeDriverExePath;
		private static String gecoDriverExePath;
		private static String ieDriverExePath;
		private static String configPropertyFile;
		private static String gridPath;
		private static boolean isRemote;
		
		public static void setChromeDriverExePath(String chromeDriverExePath) {
			DriverExeFactory.chromeDriverExePath = chromeDriverExePath;
		}
		public static String getGecoDriverExePath() {
			return gecoDriverExePath;
		}
		public static void setGecoDriverExePath(String gecoDriverExePath) {
			DriverExeFactory.gecoDriverExePath = gecoDriverExePath;
		}
		public static String getIeDriverExePath() {
			return ieDriverExePath;
		}
		public static void setIeDriverExePath(String ieDriverExePath) {
			DriverExeFactory.ieDriverExePath = ieDriverExePath;
		}
		public static String getConfigPropertyFile() {
			return configPropertyFile;
		}
		public static void setConfigPropertyFile(String configPropertyFile) {
			DriverExeFactory.configPropertyFile = configPropertyFile;
		}
		public static String getGridPath() {
			return gridPath;
		}
		public static void setGridPath(String gridPath) {
			DriverExeFactory.gridPath = gridPath;
		}
		public static boolean getIsRemote() {
			return isRemote;
		}
		public static void setIsRemote(boolean isRemote) {
			DriverExeFactory.isRemote = isRemote;
		}
		public static String getChromeDriverExePath() {
			// TODO Auto-generated method stub
			return chromeDriverExePath;
		}
		
}
