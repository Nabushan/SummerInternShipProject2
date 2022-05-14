package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CompanyEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class CompanyClassRemovers implements DataBaseRequiredObjects{
	CompanyEntity companyEntityObject = new CompanyEntity();
	Statement statement;
	
	//The below method is used to set the Company Entity Object which will be passed.
	public void setCompanyEntityObject(CompanyEntity object) {
		companyEntityObject = object;
	}
	
	//The below method is used to remove an entry from the Company DataBase using Id and Company Name.
	public void removeCompanyDetails(int Id,String companyName){
		String query = "delete from companydatabase\r\n"
				+ "where Id = "+Id+" and CompanyName = \""+ companyName +"\"";
		this.executePassedQuery(query);
	}
	
	//The below method is used to remove an entry from the Company DataBase using Id.
	public void removeCompanyDetails(int Id){
		String query = "delete from companydatabase\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to remove an entry from the Company DataBase using Company Name.
	public void removeCompanyDetails(String companyName){
		String query = "delete from companydatabase\r\n"
				+ "where CompanyName = \""+ companyName +"\"";
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		statement = databaseObject.getStatement();
		try {
			statement.executeUpdate(query);
			System.out.println("Updation Successful");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Removal : "+e);
			System.out.println(query);
		}
	}
}
