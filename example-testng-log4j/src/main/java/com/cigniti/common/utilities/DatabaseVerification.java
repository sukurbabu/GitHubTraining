package com.cigniti.common.utilities;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
import org.json.JSONObject;

import com.google.common.base.CaseFormat;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import gtl.config.gblConstants;
import gtl.core.logs.LogManager;
*/
public class DatabaseVerification {

	String strDBDriverName = "";
	String strDBConnectString = "";
	String strDBServerName = "";
	String strDBName = "";
	String strDBUser = "";
	String strPassword = "";
	String strDBType = "";
	String strDBFile="";
	Connection connection = null;

	public DatabaseVerification(String strDBType, String strDBServer, String strDBName, String strUserName,	String strPassword,String strDBFIle) {
		this.strDBType = strDBType;
		switch (strDBType.toLowerCase()) {
		case "oracle":
			this.strDBDriverName = Constants.dbDriver_Oracle;
			break;
		case "sqlserver":
			this.strDBDriverName = Constants.dbDriver_SQLServer;
			break;
		case "mysql":
			this.strDBDriverName = Constants.dbDriver_MySQL;
			break;
		case "access":
			this.strDBDriverName = Constants.dbDriver_ACCESS;
			break;
		}
		this.strDBServerName = strDBServer.trim();
		this.strDBName = strDBName.trim();
		this.strDBUser = strUserName.trim();
		this.strPassword = strPassword.trim();
		this.strDBFile=strDBFIle.trim();
	}

	/*
	 * public DatabaseVerification(String strDBType, String strDBServer, String
	 * strUserName, String strPassword,String strDBf) { this.strDBType = strDBType;
	 * switch (strDBType.toLowerCase()) { case "oracle": this.strDBDriverName =
	 * Constants.dbDriver_Oracle; break; case "sqlserver": this.strDBDriverName =
	 * Constants.dbDriver_SQLServer; break; case "mysql": this.strDBDriverName =
	 * Constants.dbDriver_MySQL; break; case "access": this.strDBDriverName =
	 * Constants.dbDriver_ACCESS; break; } this.strDBServerName =
	 * strDBServer.trim(); this.strDBName = strDBName.trim(); this.strDBUser =
	 * strUserName.trim(); this.strPassword = strPassword.trim();
	 * this.strDBFile=strDBf.trim(); }
	 * 
	 */	public Connection getConnection(String strDBType, String strDBFile) {
		try {
			Class.forName(strDBDriverName);
			if (strDBType.equalsIgnoreCase("SQLSERVER")) {
				String connectionUrl = strDBServerName + "; databaseName=" + strDBName + ";" + "user=" + this.strDBUser
						+ ";" + "password= " + this.strPassword;
				connection = DriverManager.getConnection(connectionUrl);
			} else if (strDBType.equalsIgnoreCase("Oracle") || strDBType.equalsIgnoreCase("MySQL")) {
				connection = DriverManager.getConnection(strDBServerName, strDBUser, strPassword);
			} else if (strDBType.equalsIgnoreCase("access")) {

				String connectionUrl = "jdbc:ucanaccess://" + strDBFile;

				connection = DriverManager.getConnection(connectionUrl);
			} else {
				System.out.println("Check for correct Database Type....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public boolean closeConnection() {

		try {
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * public synchronized ResultSet getQueryResponse(String queryString) throws
	 * Exception { //Statement statement =
	 * getConnection(strDBType).createStatement(); int maxAttempts = 2; int
	 * retryCntr=1; ResultSet rs = null; try { if(connection == null ) { connection
	 * = getConnection(this.strDBType); } Statement statement =
	 * connection.createStatement(); rs = statement.executeQuery(queryString);
	 * }catch(Exception e) {
	 * 
	 * } catch(CommunicationsException ce) { closeConnection(); retryCntr++;
	 * if(retryCntr<=maxAttempts) { return getQueryResponse(queryString); } } return
	 * rs; }
	 * 
	 * 
	 * public List<Map<String, String>> getResultAsList(ResultSet rs) {
	 * List<Map<String, String>> resultSet = new ArrayList<Map<String, String>>();
	 * try { ResultSetMetaData rsmd = rs.getMetaData(); while (rs.next()) {
	 * Map<String, String> rowData= new HashMap<String, String>(); for (Integer i =
	 * 1; i <= rsmd.getColumnCount(); i++) { rowData.put(rsmd.getColumnLabel(i),
	 * rs.getString(i)); } resultSet.add(rowData); } } catch (Exception e) {
	 * e.printStackTrace(); } return resultSet; }
	 */
	public void insertInToDataBase(String insertStatement) throws Exception {
		Statement statement = getConnection(strDBType,strDBFile).createStatement();
		statement.executeUpdate(insertStatement);
	}

	public int executeUpdateQuery(String strUpdateStatement) throws Exception {
		int rowAffected;
		Statement statement = getConnection(strDBType,strDBFile).createStatement();
		rowAffected = statement.executeUpdate(strUpdateStatement);
		return rowAffected;
	}

	public int executeUpdateQuery(String strServerName, String strDB, String strUpdateStatement) throws Exception {
		int rowAffected;
		Statement statement = getConnection(strDBType,strDBFile).createStatement();
		rowAffected = statement.executeUpdate(strUpdateStatement);
		return rowAffected;
	}

}