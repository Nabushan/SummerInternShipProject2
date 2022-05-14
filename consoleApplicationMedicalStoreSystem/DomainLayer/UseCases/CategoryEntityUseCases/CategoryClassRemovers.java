package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CategoryEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class CategoryClassRemovers implements DataBaseRequiredObjects{
	private CategoryEntity categoryEntityObject;
	private Statement statement;

	//The below method is used to set the Category Entity object which will be provided.
	public void setCategoryEntityObject(CategoryEntity object) {
		categoryEntityObject = object;
	}
	
	//The below method is used to remove an entry from using Id the CategoryDataBase.
	public void removeCategoryDetails(int Id) {
		String query = "delete from categorydatabase\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to remove an entry from using CategoryName the CategoryDataBase.
	public void removeCategoryDetails(String categoryName) {
		String query = "delete from categorydatabase\r\n"
				+ "where CategoryName = \""+ categoryName +"\"";
		this.executePassedQuery(query);
	}
	
	//The below method is used for executing the passed Query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Removal Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Removal : "+e);
			System.out.println(query);
		}
	}
}
