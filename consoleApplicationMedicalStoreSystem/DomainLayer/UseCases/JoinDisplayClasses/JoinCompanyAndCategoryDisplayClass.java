package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.JoinDisplayClasses;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class JoinCompanyAndCategoryDisplayClass implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	private Statement statement;
	private ResultSet resultSet;
	
	//The below method is used to display all the Company and its related Category Details. 
	public void displayCompanyAndCategoryDetails() {
		String query = "select companydatabase.Id as id,\r\n"
				+ "companydatabase.CompanyName as companyName,\r\n"
				+ "companydatabase.Location as location,\r\n"
				+ "companydatabase.MedicineProduced as medicineProduced,\r\n"
				+ "categorydatabase.CategoryName as categoryName,\r\n"
				+ "categorydatabase.UsedFor as usedFor,\r\n"
				+ "categorydatabase.AverageCost as averageCost\r\n"
				+ "from companydatabase\r\n"
				+ "inner join categorydatabase on companydatabase.CategoryId = categorydatabase.Id;";
		this.executePassedQuery(query);
	}
	
	//The below method is used to displays the Company and its related Category Details for a respective Id.
	public void displayCompanyAndCategoryDetails(int Id) {
		String query = "select companydatabase.Id as id,\r\n"
				+ "companydatabase.CompanyName as companyName,\r\n"
				+ "companydatabase.Location as location,\r\n"
				+ "companydatabase.MedicineProduced as medicineProduced,\r\n"
				+ "categorydatabase.CategoryName as categoryName,\r\n"
				+ "categorydatabase.UsedFor as usedFor,\r\n"
				+ "categorydatabase.AverageCost as averageCost\r\n"
				+ "from companydatabase\r\n"
				+ "inner join categorydatabase on companydatabase.CategoryId = categorydatabase.Id\r\n"
				+ "where companydatabase.Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Company Name", 50)+" | "
					+stringFormatter.getString("Location", 20)+" | "
					+stringFormatter.getString("Medicine Produced", 30)+" | "
					+stringFormatter.getString("Category Name",20)+" | "
					+stringFormatter.getString("Used For",40)+" | "
					+stringFormatter.getString("Average Cost",12)+" |");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 50)+" | "
						+stringFormatter.getString(resultSet.getString(3), 20)+" | "
						+stringFormatter.getString(resultSet.getString(4), 30)+" | "
						+stringFormatter.getString(resultSet.getString(5), 20)+" | "
						+stringFormatter.getString(resultSet.getString(6), 40)+" | "
						+stringFormatter.getString(resultSet.getString(7), 12)+" |");
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
}
