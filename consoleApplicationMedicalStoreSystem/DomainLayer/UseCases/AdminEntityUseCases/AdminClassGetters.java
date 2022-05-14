package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.AdminEntity;

public class AdminClassGetters {
	private AdminEntity adminEntityObject;
	
	//The below method is used to set the Admin Entity Object.
	public void setAdminObjectEntityObject(AdminEntity object) {
		adminEntityObject = object;
	}
	
	//The below method calls the respective method of the other class.
	public String getAdminName() {
		return adminEntityObject.getAdminName();
	}
	
	//The below method calls the respective method of the other class.
	public String getPassword() {
		return adminEntityObject.getPassword();
	}
}
