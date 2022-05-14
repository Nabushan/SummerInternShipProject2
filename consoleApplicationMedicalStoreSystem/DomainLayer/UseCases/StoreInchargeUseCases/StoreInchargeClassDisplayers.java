package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.StoreInchargeUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StoreInchargeRequiredObjectsInterface.StoreInchargeClassRequiredDisplayersObjectsInterface;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClass;

public class StoreInchargeClassDisplayers implements StoreInchargeClassRequiredDisplayersObjectsInterface{
	private UserClass userClassObject;
	
	//The below method is used to set the UserClass Object
	public void setUserClassObject(UserClass object) {
		userClassObject = object;
	}
	
	//The below method is used to call the respective method.
	public void displayAllAvailableMedicines() {
		medicineClassDisplayers.displayAllMedicinesDetails();
	}
	
	//The below method is used to call the respective method.
	public void showMedicineDetailsAlongWithCategoryDetails() {
		joinMedicineAndCategoryDisplayClass.displayMedicineAndCategoryDetails();
	}
}
