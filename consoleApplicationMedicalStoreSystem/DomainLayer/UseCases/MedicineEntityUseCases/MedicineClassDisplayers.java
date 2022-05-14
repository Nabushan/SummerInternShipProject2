package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;
import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.MedicineEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class MedicineClassDisplayers implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	private MedicineEntity medicineEntityObject;
	private Statement statement;
	private ResultSet resultSet;
	
	//The below method is used to set the Medicine Entity Object.
	public void setMedicineEntityObject(MedicineEntity object) {
		medicineEntityObject = object;
	}
	
	//The below method passes the query to the respective method.
	public void displayMedicineDetails(int medicineId,String medicineName) {
		String query = "select * from medicinedatabase\r\n"
				+ "where Id = "+ medicineId +"and MedicineName = \""+medicineName+"\"";
		this.executePassedQuery(query);
	}
	
	//The below method passes the query to the respective method.
	public void displayMedicineDetails(int medicineId) {
		String query = "select * from medicinedatabase\r\n"
				+ "where Id = "+medicineId;
		this.executePassedQuery(query);
	}
	
	//The below method passes the query to the respective method.
	public void displayMedicineDetails(String medicineName) {
		String query = "select * from medicinedatabase\r\n"
				+ "where MedicineName = \""+medicineName+"\"";
		this.executePassedQuery(query);
	}
	
	//The below method passes the query to the respective method.
	public void displayAllMedicinesDetails() {
		String query = "select * from medicinedatabase;";
		this.executePassedQuery(query);
	}
	
	//The below method passes the query to the respective method.
	public void displayMedicineWithId() {
		String query = "select Id,MedicineName from medicinedatabase;";
		this.executePassedQueryForMedicineWithId(query);
	}
	
	//This method is used to execute the passed query
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Medicine Name", 30)+" | "
					+stringFormatter.getString("Company Id", 10)+" | "
					+stringFormatter.getString("Dosage", 10)+" | "
					+stringFormatter.getString("Expiry Date", 11)+" | "
					+stringFormatter.getString("Category Id", 11)+" | "
					+stringFormatter.getString("Price", 10)+" |");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 30)+" | "
						+stringFormatter.getString(resultSet.getInt(3)+"", 10)+" | "
						+stringFormatter.getString(resultSet.getString(4), 10)+" | "
						+stringFormatter.getString(resultSet.getDate(5), 11)+" | "
						+stringFormatter.getString(resultSet.getInt(6)+"", 11)+" | "
						+stringFormatter.getString(resultSet.getString(7), 10)+" |");
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
	
	public void executePassedQueryForMedicineWithId(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Medicine Name", 30)+" |");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 30)+" |");
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
}
