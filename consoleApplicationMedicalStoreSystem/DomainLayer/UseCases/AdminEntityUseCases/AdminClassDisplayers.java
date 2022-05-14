package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.AdminEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminRequiredObjectsInterface.AdminClassRequiredObjectsInterface;

public class AdminClassDisplayers implements AdminClassRequiredObjectsInterface{
	private AdminEntity adminEntityObject;
	
	//The below method is used to set the Admin Entity Object.
	public void setAdminObjectEntityObject(AdminEntity object) {
		adminEntityObject = object;
	}
	
	//The below method calls the respective methods of the other class.
	public void displayMedicineDetails() {
		medicineClassObject.displaymedicine();
	}
	
	//The below method calls the respective methods of the other class.
	public void displayCategoryDetails() {
		categoryClassObject.displayDetails();
	}
	
	//The below method calls the respective methods of the other class.
	public void displayCompanyDetails() {
		companyClassObject.displayCompany();
	}
	
	//The below method calls the respective methods of the other class.
	public void displaySalesDetails() {
		salesRecordClassObject.displaySalesRecord();
	}
	
	//The below method calls the respective methods of the other class.
	public void displayAllMedicineCompanyAndCategoryDetails() {
		joinMedicineCategoryAndCompanyDisplayClass.displayMedicineCompanyAndCategoryDetails();
	}
	
	//The below method calls the respective methods of the other class.
	public void displayAllMedicineCompanyAndCategoryDetails(int Id) {
		joinMedicineCategoryAndCompanyDisplayClass.displayMedicineCompanyAndCategoryDetails(Id);
	}
	
	//The below method calls the respective methods of the other class.
	public void displayAllCompanyAndCategoryDetails() {
		joinCompanyAndCategoryDisplayClass.displayCompanyAndCategoryDetails();
	}
	
	//The below method calls the respective methods of the other class.
	public void displayAllCompanyAndCategoryDetails(int Id) {
		joinCompanyAndCategoryDisplayClass.displayCompanyAndCategoryDetails(Id);
	}
}
