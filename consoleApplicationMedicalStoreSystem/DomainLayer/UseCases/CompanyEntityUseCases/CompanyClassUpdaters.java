package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CompanyEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class CompanyClassUpdaters implements DataBaseRequiredObjects{
	CompanyEntity companyEntityObject = new CompanyEntity();
	Statement statement;
	
	//The below method is used to set the Company Entity Object which will be passed.
	public void setCompanyEntityObject(CompanyEntity object) {
		companyEntityObject = object;
	}
	
	//The below method is used to update the Company Name in the Company data base.
	public void updateCompanyName(int Id,String newCompanyName) {
		String query = "update companydatabase\r\n"
				+ "set CompanyName = \""+ newCompanyName +"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to update the Medicine Name in the Company data base.
	public void updateMedicineManufactured(int Id,String newMedicineName) {
		String query = "update companydatabase\r\n"
				+ "set MedicineProduced = \""+newMedicineName+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}
	
	//The below method is used to update the Company Location in the Company data base.
	public void updateCompanyLocation(int Id,String newLocation) {
		String query = "update companydatabase\r\n"
				+ "set Location = \""+newLocation+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to update the production Category in the Company data base.
	public void updateProdutionCategory(int Id,int newCategoryId) {
		String query = "update companydatabase\r\n"
				+ "set CategoryId = "+ newCategoryId +"\r\n"
				+ "where Id = "+Id;
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
			System.out.println("Exception caught during Updation : "+e);
			System.out.println(query);
		}
	}
}
