package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases;

import java.sql.Statement;
import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.AdminEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminRequiredObjectsInterface.AdminClassRequiredObjectsInterface;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClass;

public class AdminClassFeeders implements AdminClassRequiredObjectsInterface,DataBaseRequiredObjects{
	private AdminEntity adminEntityObject;
	private Statement statement;
	
	//The below method is used to set the Admin Entity Object.
	public void setAdminObjectEntityObject(AdminEntity object) {
		adminEntityObject = object;
	}
	
	//The below method calls the respective method of the other class.
	public void feedAdminName(String adminName) {
		adminEntityObject.setAdminName(adminName);
	}
	
	//The below method calls the respective method of the other class.
	public void feedAdminPassword(String password) {
		adminEntityObject.setPassword(password);
	}
	
	//The below method calls the respective method of the other class.
	public void feedMedicineDetails() {
		medicineClassObject.addMedicine();
	}
	
	//The below method calls the respective method of the other class.
	public void feedCategoryDetails() {
		categoryClassObject.addCategoryDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void feedCompanyDetails() {
		companyClassObject.addCompany();
	}
	
	//The below method is used to enter the admin details into the AdminDataBase Table.
	public void addAdminToTable(String adminName,String password) {
		String query = "";
		try {
			query = "insert into admindatabase(AdminName,Password)\r\n"
					+ "values (\""+adminName+"\",\""+password+"\");";
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("Exception Caught during Admin Adding : "+e);
			System.out.println(query);
		}
	}
	
	//The below method is used to call the respective methods which can be used to populate
	//the Sales details.
	public void feedSalesDetails() {
		UserClass userClassObject = new UserClass();
		userClassObject.addUser();
		salesRecordClassObject.addSalesRecord(userClassObject.getUserName(), userClassObject.getContactNumber(), userClassObject.getPurchaseDate());
	}
}
