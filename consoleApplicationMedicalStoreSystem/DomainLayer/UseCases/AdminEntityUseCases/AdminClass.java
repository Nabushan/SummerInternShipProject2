package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.AdminEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminClassInterface.AdminClassRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;

public class AdminClass implements AdminClassRequiredObjects,DataBaseRequiredObjects,ScannerObject{
	private AdminEntity adminEntityObject;
	private Statement statement;
	private ResultSet resultSet;
	private String adminName;
	private String password,reEnteredPassword;
	private boolean flag = true;
	private int check = 0;
	
	//The below constructor is used to pass the Admin Entity reference to all the necessary
	//Classes through the defined method.
	public AdminClass() {
		adminEntityObject = new AdminEntity();
		
		adminClassFeeders.setAdminObjectEntityObject(adminEntityObject);
		adminClassUpdaters.setAdminObjectEntityObject(adminEntityObject);
		adminClassCheckers.setAdminObjectEntityObject(adminEntityObject);
		adminClassGetters.setAdminObjectEntityObject(adminEntityObject);
		adminClassDisplayers.setAdminObjectEntityObject(adminEntityObject);
	}
	
	//The below method is used to add the admin details into the AdminDataBase.
	public void setAdminDetails() {
		System.out.println("Enter the Admin Name : ");
		input.nextLine();
		adminName = input.nextLine();
		adminClassFeeders.feedAdminName(adminName);
		System.out.println("Enter Password : ");
		password = input.nextLine();
		System.out.println("Re-Enter the Password for verification : ");
		reEnteredPassword = input.nextLine();
		if(password.equals(reEnteredPassword)) {
			adminClassFeeders.feedAdminPassword(password);
			String query = "";
			try {
				query = "select exists(select * from admindatabase \r\n"
						+ "where AdminName = \""+adminName+"\" and Password = \""+password+"\");";
				statement = databaseObject.getStatement();
				resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					check = resultSet.getInt(1);
				}
				
				if(check == 0) {
					adminClassFeeders.addAdminToTable(adminName, password);
					System.out.println("Password Set Successfully.");
				}
				else {
					System.out.println("Admin Already Exists.");
				}
			}
			catch(Exception e) {
				System.out.println("Exception caught during Admin Details Additon : "+e);
				System.out.println(query);
			}
		}
		else {
			System.out.println("Password Doesn't match");
		}
	}
	
	//The below method is used to update the details present in the AdminDataBase.
	public void updateAdminPassword() {
		System.out.println("Enter the password to reset : ");
		input.nextLine();
		password = input.nextLine();
		System.out.println("Re-Enter the password to reset : ");
		reEnteredPassword = input.nextLine();
		if(password.equals(reEnteredPassword)) {
			adminClassFeeders.feedAdminPassword(password);
			System.out.println("Password Set Successfully.");
		}
		else {
			System.out.println("Password Doesn't match");
		}
	}
	
	//The below method is used to check the admin details when entering into the program
	//(Kind of similar to Log-In) 
	public boolean checkAdmin() {
		if(flag) {
			this.setAdminDetails();
			flag = false;
		}
		else {
			System.out.println("Enter the Admin Name : ");
			input.nextLine();
			adminName = input.nextLine();
			System.out.println("Enter the passord to Log In : ");
			password = input.nextLine();
			String query = "";
			try {
				query = "select exists(select * from admindatabase \r\n"
						+ "where AdminName = \""+adminName+"\" and Password = \""+password+"\");";
				statement = databaseObject.getStatement();
				resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					check = resultSet.getInt(1);
				}
				
				if(check == 1) return true;
			}
			catch(Exception e) {
				System.out.println("Exception caught during Admin Details Additon : "+e);
				System.out.println(query);
			}
		}
		return false;
	}
	
	//The below method checks the Details provided by the user during the entry.
	public boolean validateAdmin(String userName,String password) {
		if(userName.equals(adminClassGetters.getAdminName()) && adminClassCheckers.checkPassword(password))
			return true;
		return false;
	}
	
	//The below method calls the respective method of the other class.
	public void feedMedicineDetails() {
		adminClassFeeders.feedMedicineDetails();;
	}
	
	//The below method calls the respective method of the other class.
	public void feedCategoryDetails() {
		adminClassFeeders.feedCategoryDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void feedCompanyDetails() {
		adminClassFeeders.feedCompanyDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void feedSalesDetails() {
		adminClassFeeders.feedSalesDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void updateMedicineDetails() {
		adminClassUpdaters.updateMedicineDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void updateCategoryDetails() {
		adminClassUpdaters.updateCategoryDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void updateCompanyDetails() {
		adminClassUpdaters.updateCompanyDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void updateSalesDetails() {
		adminClassUpdaters.updateSalesDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void displayMedicineDetails() {
		adminClassDisplayers.displayMedicineDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void displayCategoryDetails() {
		adminClassDisplayers.displayCategoryDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void displayCompanyDetails() {
		adminClassDisplayers.displayCompanyDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void displaySalesDetails() {
		adminClassDisplayers.displaySalesDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void displayAllMedicineCompanyAndCategoryDetails() {
		adminClassDisplayers.displayAllMedicineCompanyAndCategoryDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void displayAllMedicineCompanyAndCategoryDetails(int Id) {
		adminClassDisplayers.displayAllMedicineCompanyAndCategoryDetails(Id);
	}
	
	//The below method calls the respective method of the other class.
	public void displayAllCompanyAndCategoryDetails() {
		adminClassDisplayers.displayAllCompanyAndCategoryDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void displayAllCompanyAndCategoryDetails(int Id) {
		adminClassDisplayers.displayAllCompanyAndCategoryDetails(Id);
	}
}
