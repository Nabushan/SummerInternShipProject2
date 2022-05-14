package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.UserEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class UserClassAdders implements DataBaseRequiredObjects{
	UserEntity userEntityObject;
	Statement statement;
	ResultSet resultSet;
	
	//The below method is used to set the User Entity Object.
	public void setUserEntityObject(UserEntity object) {
		userEntityObject = object;
	}
	
	//The below method is used to add the User Details. 
	public void addUser() {
		//The below query is used to find the existence of the user details.
		String fetchQuery = "select exists(select * from userdatebase \r\n"
				+ "where UserName = \""+ userEntityObject.getUserName() +"\" and \r\n"
				+ "UserNumber = \""+userEntityObject.getContactNumber()+"\");";
		int check = 0;
		
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(fetchQuery);
			if(resultSet.next()) {
				check = resultSet.getInt(1);
			}
			if(check == 1) {
				System.out.println("User Already Exists.");
				return;
			}
		}
		catch(Exception e) {
			System.out.println("Exception caught during Retrieval : "+e);
			System.out.println(fetchQuery);
		}
		
		//The below query is used to insert values into the Uase Data Base.
		String query = "insert into userdatebase(UserName,UserNumber,PurchaseDate) \r\n"
				+ "values (\""+userEntityObject.getUserName()+"\",\""+userEntityObject.getContactNumber()
				+"\",\""+userEntityObject.getPurchaseDate()+"\");";
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
			System.out.println("Exception caught during Addition.");
			System.out.println(query);
		}
	}
}
