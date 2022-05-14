package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.UserEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class UserClassDisplayers implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	UserEntity userEntityObject;
	Statement statement;
	ResultSet resultSet;
	
	//The below method is used to set the User Entity Object.
	public void setUserEntityObject(UserEntity object) {
		userEntityObject = object;
	}
	
	//The below method is used to display the User details using Id.
	public void displayUserDetail(int Id) {
		String query = "select * from userdatebase\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to display the User details using Name.
	public void displayUserDetail(String name) {
		String query = "select * from userdatebase\r\n"
				+ "where UserName = \""+ name +"\";";
		this.executePassedQuery(query);
	}
	
	//The below method is used to display the User details.
	public void displayAllUserDetails() {
		String query = "select * from userdatebase;";
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println(stringFormatter.getString("Id",3)+" "
					+stringFormatter.getString("User Name", 30)+" "
					+stringFormatter.getString("User Number", 11)+" "
					+stringFormatter.getString("Purchase Date", 13));
			while(resultSet.next()) {
				System.out.println(stringFormatter.getString(resultSet.getInt(1)+"", 3)+" "
					+stringFormatter.getString(resultSet.getString(2), 30)+" "
					+stringFormatter.getString(resultSet.getString(3), 11)+" "
					+stringFormatter.getString(resultSet.getDate(4), 13));
			}
			System.out.println("Display Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying.");
			System.out.println(query);
		}
	}
}
