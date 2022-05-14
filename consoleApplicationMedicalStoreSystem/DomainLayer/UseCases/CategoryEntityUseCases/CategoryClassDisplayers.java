package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CategoryEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class CategoryClassDisplayers implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	private CategoryEntity categoryEntityObject;
	private Statement statement;
	private ResultSet resultSet;

	//The below method is used to set the Category Entity Object which will be provided.
	public void setCategoryEntityObject(CategoryEntity object) {
		categoryEntityObject = object;
	}
	
	//The below method is used to display an entry from using Id the CategoryDataBase.
	public void displayCategoryDetails(int Id) {
		String query = "select * from categorydatabase \r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to display an entry from using Category Name the CategoryDataBase.
	public void displayCategoryDetails(String categoryName) {
		String query = "select * from categorydatabase \r\n"
				+ "where CategoryName = \""+categoryName+"\"";
		this.executePassedQuery(query);
	}
	
	//The below method is used to display all entries from the CategoryDataBase.	
	public void displayAllCategoryDetails() {
		System.out.println("Available Categories are :- ");
		String query = "select * from categorydatabase";
		this.executePassedQuery(query);
	}
	
	//The below method is used to display all entries(only Id and CategoryName) from CategoryDataBase.
	public void displayAllCategoryIdDetails() {
		System.out.println("Available Categories are :- ");
		String query = "select Id,CategoryName from categorydatabase;";
		this.executePassedQueryForId(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id",3 )+" | "
					+stringFormatter.getString("Category Name",20)+" | "
					+stringFormatter.getString("Used For",50)+" | "
					+stringFormatter.getString("Average Cost",12)+" |");
			System.out.println("--------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 20)+" | "
						+stringFormatter.getString(resultSet.getString(3), 50)+" | "
						+stringFormatter.getString(resultSet.getString(4), 12)+" |");
			}
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e){
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQueryForId(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("------------------------------");
			System.out.println("| "+stringFormatter.getString("Id",3 )+" | "
					+stringFormatter.getString("Category Name",20)+" |");
			System.out.println("------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 20)+" |");
			}
			System.out.println("------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e){
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
}
