package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CategoryEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class CategoryClassAdders implements DataBaseRequiredObjects{
	private CategoryEntity categoryEntityObject;
	private Statement statement;

	//The below method is used to set the Category Entity Object which will be passed.
	public void setCategoryEntityObject(CategoryEntity object) {
		categoryEntityObject = object;
	}
	
	//The below method is used to add the details into the database by dereferencing the respective Object
	public void addCategoryDetails() {
		String query = "insert into categorydatabase(CategoryName,UsedFor,AverageCost)"
				+ " values (\""+ categoryEntityObject.getCategoryName() +"\",\""
				+ categoryEntityObject.getUsedFor() +"\",\"" +"Rs."+categoryEntityObject.getAverageCost() + "\");";
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Addition Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Adding : "+e);
			System.out.println(query);
		}
	}
}
