package consoleApplicationMedicalStoreSystem.DataLayer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	DatabaseMetaData databaseMetaData;
	String query = null;
	
	//The below constructor gets the MetaData of the respective Schema and create's tables if no 
	//table has been created
	public JDBC() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/consoleapplicationmedicalstore","root","prinab1801");
			statement = connection.createStatement();
			databaseMetaData = connection.getMetaData();
			
			resultSet = databaseMetaData.getTables(null, null, "UserDateBase", null);
			if(!resultSet.next()) {
				query = "create table UserDateBase(Id int AUTO_INCREMENT,UserName varchar(100),UserNumber varchar(100),PurchaseDate date,primary key(Id));";
				statement.executeUpdate(query);
				System.out.println("Successfully created table for User Details.");
			}
			
			resultSet = databaseMetaData.getTables(null, null, "CategoryDataBase", null);
			if(!resultSet.next()) {
				query = "create table CategoryDataBase(Id int AUTO_INCREMENT,CategoryName varchar(100),UsedFor varchar(100),AverageCost varchar(100),primary key(Id));";
				statement.executeUpdate(query);
				System.out.println("Successfully created table for Category Details.");
			}
			
			resultSet = databaseMetaData.getTables(null, null, "CompanyDataBase", null);
			if(!resultSet.next()) {
				query = "create table CompanyDataBase(Id int AUTO_INCREMENT,CompanyName varchar(100),MedicineProduced varchar(100),CategoryId int,Location varchar(100),\r\n"
						+ "primary key(Id),\r\n"
						+ "foreign key(CategoryId) references categorydatabase(Id));";
				statement.executeUpdate(query);
				System.out.println("Successfully created table for Company Details.");
			}
			
			resultSet = databaseMetaData.getTables(null, null, "MedicineDataBase", null);
			if(!resultSet.next()) {
				query = "create table medicinedatabase(Id int AUTO_INCREMENT,MedicineName varchar(100),ProductionCompanyId int,Dosage varchar(6),ExpiryDate date,MedicineCategoryId int,PricePerMedicine varchar(10),\r\n"
						+ "primary key(id),\r\n"
						+ "foreign key(ProductionCompanyId) references companydatabase(Id),\r\n"
						+ "foreign key(MedicineCategoryId) references categorydatabase(Id));";
				statement.executeUpdate(query);
				System.out.println("Successfully created table for Medicine Details.");
			}
			
			resultSet = databaseMetaData.getTables(null, null, "SalesRecordDataBase", null);
			if(!resultSet.next()) {
				
				/*
				query = "create table SalesRecordDataBase(Id int AUTO_INCREMENT,CustomerName varchar(100),CustomerNumber varchar(100),PrescribedBy varchar(100),MedicineId int,MedicineCategoryId int,QuantityPurchased int,MedicinePrice int,TotalCost varchar(10),PurchasedDate date,\r\n"
						+ "primary key(Id),\r\n"
						+ "foreign key(Id) references userdatebase(Id),\r\n"
						+ "foreign key(MedicineId) references medicinedatabase(Id),\r\n"
						+ "foreign key(MedicineCategoryId) references categorydatabase(Id));";
				*/
				
				query = "create table SalesRecordDataBase(Id int AUTO_INCREMENT,CustomerId int,PrescribedBy varchar(100),MedicineId int,MedicineCategoryId int,QuantityPurchased int,MedicinePrice int,TotalCost varchar(10),PurchasedDate date,\r\n"
						+ "primary key(Id),\r\n"
						+ "foreign key(CustomerId) references userdatebase(Id),\r\n"
						+ "foreign key(MedicineId) references medicinedatabase(Id),\r\n"
						+ "foreign key(MedicineCategoryId) references categorydatabase(Id));";
				statement.executeUpdate(query);
				System.out.println("Successfully created table for Sales Record Details.");
			}
			
			resultSet = databaseMetaData.getTables(null, null, "AdminDataBase", null);
			if(!resultSet.next()) {
				query = "create table AdminDataBase(Id int auto_increment,AdminName varchar(100),\r\n"
						+ "Password varchar(100),primary key(Id));";
				statement.executeUpdate(query);
				System.out.println("Successfully created table for Admin Details.");
			}
			//TODO:
			//Yet to create other tables.
		}
		catch(Exception e) {
			System.out.println("Exception caught while table creation : "+e);
			System.out.println(query);
		}
	}
	
	//The below method is used to get the statement Object Reference.
	public Statement getStatement() {
		return statement;
	}
	
	//The below method is used to get the resultSet Object Reference.
	public ResultSet getResultSet() {
		return resultSet;
	}
}
