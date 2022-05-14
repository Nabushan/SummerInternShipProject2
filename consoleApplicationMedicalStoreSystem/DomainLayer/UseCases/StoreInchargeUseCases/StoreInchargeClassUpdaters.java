package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.StoreInchargeUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StoreInchargeRequiredObjectsInterface.StoreInchargeClassRequiredAdderObjectsInterface;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClass;

public class StoreInchargeClassUpdaters implements StoreInchargeClassRequiredAdderObjectsInterface{
	private UserClass userClassObject;
	
	//The below method is used to set the User Class Object.
	public void setUserClassObject(UserClass object) {
		userClassObject = object;
	}
	
	//The below method is used to call the respective method.
	public void updateSalesDetails() {
		salesRecordClass.updateSalesRecord();
	}
}
