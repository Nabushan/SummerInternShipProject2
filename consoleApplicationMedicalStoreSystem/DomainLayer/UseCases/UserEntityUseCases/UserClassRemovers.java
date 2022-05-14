package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.UserEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class UserClassRemovers implements DataBaseRequiredObjects{
	UserEntity userEntityObject;
	Statement statement;
	
	//The below method is used to set the User Entity Object.
	public void setUserEntityObject(UserEntity object) {
		userEntityObject = object;
	}
	
	//The below method is used to remove the User Details using Id.
	public void removeUser(int Id) {
		String query = "delete from userdatebase\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to remove the User Details using Name and Number.
	public void removeUser(String name,String number) {
		String query = "delete from userdatebase\r\n"
				+ "where UserName = \""+name+"\" and UserNumber = \""+number+"\";";
		this.executePassedQuery(query);
	}

	//The below method is used to remove the User Details using Name.
	public void removeUser(String name) {
		String query = "delete from userdatebase\r\n"
				+ "where UserName = \""+name+"\";";
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Removal Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Removal.");
			System.out.println(query);
		}
	}
}
