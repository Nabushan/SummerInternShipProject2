package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.UserEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class UserClassUpdaters implements DataBaseRequiredObjects{
	UserEntity userEntityObject;
	Statement statement;
	
	//The below method is used to set the User Entity Object. 
	public void setUserEntityObject(UserEntity object) {
		userEntityObject = object;
	}
	
	//The below method is used to update the User Name. 
	public void updateUserName(int Id,String newName) {
		String query = "update userdatebase\r\n"
				+ "set UserName = \""+newName+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to update the User Number.
	public void updateUserContactNumber(int Id,String newNumber) {
		String query = "update userdatebase\r\n"
				+ "set UserNumber = \""+newNumber+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}

	//The below method is used to update the User Date.
	public void updatePurchasedDate(int Id,String newDate) {
		String query = "update userdatebase\r\n"
				+ "set PurchaseDate = \""+newDate+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);		
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Updation Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Updation.");
			System.out.println(query);
		}
	}
}
