package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CompanyEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class CompanyClassDisplayers implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	CompanyEntity companyEntityObject = new CompanyEntity();
	Statement statement;
	ResultSet resultSet;
	
	//The below method is used to set the Company Entity Object which will be passed.
	public void setCompanyEntityObject(CompanyEntity object) {
		companyEntityObject = object;
	}
	
	//The below method is used to display the Company details using Id.
	public void displayCompanyDetails(int Id) {
		String query = "select * from companydatabase\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to display the Company details using Company Name.
	public void displayCompanyDetails(String companyName) {
		String query = "select * from companydatabase\r\n"
				+ "where CompanyName = \""+ companyName +"\";";
		this.executePassedQuery(query);
	}
	//The below method is used to display all the Company details.
	public void displayAllCompanyDetails() {
		System.out.println("Avalilable Companies Are : ");
		String query = "select * from companydatabase";
		this.executePassedQuery(query);
	}
	
	//The below method is used to display only the Id and Company Name the Company details. 
	public void displayAllCompanyIdDetails() {
		System.out.println("Avalilable Companies Are : ");
		String query = "select Id,CompanyName,CategoryId from companydatabase;";
		this.executePassedQueryForId(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Company Name", 50)+" | "
					+stringFormatter.getString("Medicine Produced", 30)+" | "
					+stringFormatter.getString("Category Id", 11)+" | "
					+stringFormatter.getString("Location", 20)+" |");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 50)+" | "
						+stringFormatter.getString(resultSet.getString(3), 30)+" | "
						+stringFormatter.getString(resultSet.getInt(4)+"", 11)+" | "
						+stringFormatter.getString(resultSet.getString(5), 20)+" |");
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQueryForId(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Company Name", 50)+" |");
			System.out.println("------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 50)+" |");
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
}
