package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.AdminEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminRequiredObjectsInterface.AdminClassRequiredObjectsInterface;

public class AdminClassUpdaters implements AdminClassRequiredObjectsInterface{
	private AdminEntity adminEntityObject;
	
	//The below method is used to set the Admin Entity Object. 
	public void setAdminObjectEntityObject(AdminEntity object) {
		adminEntityObject = object;
	}
	
	//The below method calls the respective method of the other class.
	public void changePassword(String newPassword) {
		adminEntityObject.setPassword(newPassword);
	}
	
	//The below method calls the respective method of the other class.
	public void updateMedicineDetails() {
		medicineClassObject.updateMedicine();
	}
	
	//The below method calls the respective method of the other class.
	public void updateCategoryDetails() {
		categoryClassObject.updateCategoryDetails();
	}
	
	//The below method calls the respective method of the other class.
	public void updateCompanyDetails() {
		companyClassObject.updateCompany();
	}
	
	//The below method calls the respective method of the other class.
	public void updateSalesDetails() {
		salesRecordClassObject.updateSalesRecord();
	}
}
