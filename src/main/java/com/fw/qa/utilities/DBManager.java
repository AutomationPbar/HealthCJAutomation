package com.fw.qa.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {

	private Connection con = null;
	private Statement stmt = null;
	ResultSet res;

	public void DBConnection(String DBPath, String Username, String Password) throws Exception {
		try {

			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

			System.out.println("Driver Registered");
			con = DriverManager.getConnection(DBPath, Username, Password);
			System.out.println("Database Connected");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Stm created");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet GetResultSet(String DBQuery) throws Exception {

		try {

			res = stmt.executeQuery(DBQuery);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return res;
	}

	public String[][] GetResultSet1(String DBQuery, int bookingCount, String[] ColumnNames) throws Exception {

		String[][] ResultSets = new String[bookingCount][5];

		try {

			res = stmt.executeQuery(DBQuery);

			int j = 0;

			while (res.next()) {
				int i = 1;

				System.out.println(" ");

				for (i = 1; i <= 5; i++) {

					ResultSets[j][i - 1] = res.getString(i);
					System.out.print(res.getString(i) + " ");

				}
				j++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResultSets;
	}

	public ArrayList<String> GetResultSetArrayList(String DBQuery, String[] ColumnNames) throws Exception {

		ArrayList<String> ResultSets = new ArrayList<String>();

		try {

			res = stmt.executeQuery(DBQuery);

			while (res.next()) {

				for (int i = 0; i < ColumnNames.length; i++) {

					ResultSets.add(res.getString(ColumnNames[i]));

				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ResultSets;
	}

	public void InsertData(ArrayList<String> data, String tableName) throws SQLException {

		String val = "";
		for (int i = 0; i < data.size(); i++) {

			val = val + "," + data.get(i);

		}

		stmt.executeUpdate("INSERT INTO " + tableName + " values " + val);

	}

	public void SetData(String leadId, String policyNo, String appNo, String ProductId, String PolicyURL,
			String SupplierId, String Reason, String tableName) throws SQLException {

		int isProcessed = 1;
		int isActive = 1;

		try {
			
			String datam = "(" + leadId + ",'" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "',"
					+ isProcessed + "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason +"');";

			System.out.println("DataM " + datam);

		} catch (Exception e) {
			System.out.println(e);
		}

		stmt.executeUpdate("INSERT INTO " + tableName
				+ "(LeadId, PolicyNo, ApplicationNo, ProductId, PolicyURL, IsPRocessed, IsActive, SupplierId, ProcessedBy, Reason) values ('"
				+ leadId + "','" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "'," + isProcessed
				+ "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason + "');");

		tear();

	}

	public void SetDataCigna(String leadId, String policyNo, String appNo, String ProductId, String PolicyURL,
			String SupplierId, String Reason, String PortalPolicy, String tableName) throws SQLException {

		int isProcessed = 1;
		int isActive = 1;

		try {
			String datam = "(" + leadId + ",'" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "',"
					+ isProcessed + "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason + "','"
					+ PortalPolicy + "');";

			System.out.println("DataM " + datam);

		} catch (Exception e) {
			System.out.println(e);
		}

		stmt.executeUpdate("INSERT INTO " + tableName
				+ "(LeadId, PolicyNo, ApplicationNo, ProductId, PolicyURL, IsPRocessed, IsActive, SupplierId, ProcessedBy, Reason, PortalPolicyNo) values ('"
				+ leadId + "','" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "'," + isProcessed
				+ "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason + "','" + PortalPolicy + "');");

		tear();

	}

	
	public void SetDataReligare(String leadId, String policyNo, String appNo, String ProductId, String PolicyURL,
			String SupplierId, String Reason, String PolicyStartDate, String PortalPolicyNo, String SearchedBy,
			String tableName) throws SQLException {

		int isProcessed = 1;
		int isActive = 1;

		try {
			String datam = "(" + leadId + ",'" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "',"
					+ isProcessed + "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason + "','"
					+ PolicyStartDate + "');";

			System.out.println("DataM " + datam);

		} catch (Exception e) {
			System.out.println(e);
		}

		stmt.executeUpdate("INSERT INTO " + tableName
				+ "(LeadId, PolicyNo, ApplicationNo, ProductId, PolicyURL, IsPRocessed, IsActive, SupplierId, ProcessedBy, Reason, PolicyStartDate, PortalPolicyNo, SearchedBy) values ('"
				+ leadId + "','" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "'," + isProcessed
				+ "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason + "','" + PolicyStartDate + "','"
				+ PortalPolicyNo + "','" + SearchedBy + "');");

		tear();

	}

	public void UpdatePolicyDetails(String leadId, String policyNo, String appNo, String ProductId, String PolicyURL,
			String SupplierId, String Reason, String tableName) throws SQLException {

		int isProcessed = 1;
		int isActive = 1;

		try {
			String datam = "(" + leadId + ",'" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "',"
					+ isProcessed + "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason + "');";

			System.out.println("DataM " + datam);

		} catch (Exception e) {
			System.out.println(e);
		}

		stmt.executeUpdate("INSERT INTO " + tableName
				+ "(LeadId, PolicyNo, ApplicationNo, ProductId, PolicyURL, IsPRocessed, IsActive, SupplierId, ProcessedBy, Reason) values ('"
				+ leadId + "','" + policyNo + "','" + appNo + "','" + ProductId + "','" + PolicyURL + "'," + isProcessed
				+ "," + isActive + ",'" + SupplierId + "','AllCasesBatch','" + Reason + "');");

		tear();

	}

	public int UpdateQuery(String DBQuery) throws Exception {

		int i = 0;
		try {
			i = stmt.executeUpdate(DBQuery);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return i;
	}

	public void tear() {
		con = null;
	}

}
