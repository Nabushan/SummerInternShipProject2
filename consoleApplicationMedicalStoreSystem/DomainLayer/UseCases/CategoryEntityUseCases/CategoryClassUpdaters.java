package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CategoryEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class CategoryClassUpdaters implements DataBaseRequiredObjects{
	private CategoryEntity categoryEntityObject;
	private Statement statement;
	
	//The below method is used to set the Category Entity Object which will be provided.
	public void setCategoryEntityObject(CategoryEntity object) {
		categoryEntityObject = object;
	}
	
	//The below method is used to update the Name field in the CategoryDataBase.
	public void updateCategoryName(int Id,String newName) {
		String query = "update categorydatabase\r\n"
				+ "set CategoryName = \""+ newName +"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to update the Used For in the CategoryDataBase.
	public void updateUsedForDetails(int Id,String newUsedFor) {
		String query = "update categorydatabase\r\n"
				+ "set UsedFor = \""+ newUsedFor +"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to update the New Average Cost field in the CategoryDataBase.
	public void updateAverageCost(int Id,String newAverageCost) {
		String query = "update categorydatabase\r\n"
				+ "set AverageCost = \""+"Rs."+newAverageCost+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Update Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Updation : "+e);
			System.out.println(query);
		}
	}
}
