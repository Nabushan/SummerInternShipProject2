package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.AdminEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminRequiredObjectsInterface.AdminClassRequiredObjectsInterface;

public class AdminClassCheckers implements AdminClassRequiredObjectsInterface{
	private AdminEntity adminEntityObject;
	
	//The below method is used to set the Admin Entity Object.
	public void setAdminObjectEntityObject(AdminEntity object) {
		adminEntityObject = object;
	}
	
	//The below method is a password checker which checks the available password with the provided
	//password.
	public boolean checkPassword(String password) {
		if(adminEntityObject.getPassword().equals(password)) return true;
		return false;
	}
}
