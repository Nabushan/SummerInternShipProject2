package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CompanyEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class CompanyClassAdders implements DataBaseRequiredObjects{
	CompanyEntity companyEntityObject = new CompanyEntity();
	Statement statement;
	
	//The below method is used to set the Company Entity Object which will be passed.
	public void setCompanyEntityObject(CompanyEntity object) {
		companyEntityObject = object;
	}
	
	//The below method is used to dereference the object and to add the details into the 
	//CompanyDataBase.
	public void addCompany() {
		String query = "insert into companydatabase(CompanyName,MedicineProduced,CategoryId,Location) "
			+ "values('"+companyEntityObject.getCompanyName()+"','"+companyEntityObject.getMedicineManufactured()
			+"',"+companyEntityObject.getProductionCategoryId()+",'"+companyEntityObject.getCompanyLocation()+"')";
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		statement = databaseObject.getStatement();
		try {
			statement.executeUpdate(query);
			System.out.println("Addition Successful");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Adding : "+e);
			System.out.println(query);
		}
	}
}
