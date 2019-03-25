package com.fw.qa.utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fw.qa.utilities.DBManager;


public class GetReports {
	
	static String QADB_Path = "jdbc:sqlserver://10.0.10.43:1433;DatabaseName=PBCroma";
	private static String QAusename = "UATUser";
	private static String QApassword = "UAT123User";
	
	static String tableName1 = "PRODUCTDB.HI.MobileBasedCreateLeads";
	static String tableName2 = "PBCROMA.CRM.Leaddetails";
	static String tableName3 = "ProductDB.HI.HealthProposers";
	static String tableName4 = "ProductDB.HI.CoveredMembers";
	static String tableName5 = "ProductDB.HI.ContactInformation";
	
	static DBManager dbm = new DBManager();
	
	static String DBQuery1 = "select top 1 Name,Gender,CityID,StateID,PostCode,Country,MaritalStatus, AnnualIncome,Utm_source,UTM_Medium,Utm_term,Utm_campaign,LeadSource from PBCROMA.CRM.Leaddetails where LeadSource='PB'";
	static String DBQuery2 = "select Gender,MaritalStatusId,Title from ProductDB.HI.CoveredMembers";
	static String DBQuery3 = "select Name,CountryId,Pincode from ProductDB.HI.ContactInformation";
	
	
	static boolean result = true;
	
	public static void connect(){
		
		try {
			
			dbm.DBConnection(QADB_Path, QAusename, QApassword);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	 public static void main(String[] args){
		try{
		connect();
		ResultSet resultSet = dbm.GetResultSet(DBQuery1);
		int resultSetSize = 0;

		do {
			resultSet.beforeFirst();
			resultSet.last();
			resultSetSize = resultSet.getRow();
		} while (resultSet.next());

		System.out.println("Result Count :" + resultSetSize);
		int resultCounter = 0;
		resultSet.first();
		if (resultSetSize > 0) {
			do {
				resultCounter = resultCounter + 1;
				
		System.out.println("Name  " + resultSet.getString(1));
		System.out.println("Gender  " + resultSet.getString(2));
		System.out.println("CityID  " + resultSet.getString(3));
		
			
		} while (resultSet.next());

		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	

}
