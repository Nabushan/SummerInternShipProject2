package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.StoreInchargeUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StoreInchargeClassInterface.StoreInchargeClassRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClass;

public class StoreInchargeClass implements StoreInchargeClassRequiredObjects{
	private UserClass userClassObject;
	
	/*
	 * The below constructor creates a new User class for each and every class creation and it sets the 
	 * User object attributes in those respective classes using the methods provided by those respective
	 * classes.
	 * */
	public StoreInchargeClass() {
		userClassObject = new UserClass();
		
		storeInchargeClassAdders.setUserClassObject(userClassObject);
		storeInchargeClassUpdaters.setUserClassObject(userClassObject);
		storeInchargeClassDisplayers.setUserClassObject(userClassObject);
	}
	
	//The below method is used to call the respective methods of another class.
	public void addSalesEntry() {
		//storeInchargeClassDisplayers.displayAllAvailableMedicines();
		storeInchargeClassAdders.createPurchaseEntry();
	}
	
	//The below method is used to call the respective methods of another class.
	public void updateSalesEntry() {
		storeInchargeClassUpdaters.updateSalesDetails();
	}
	
	//The below method is used to call the respective methods of another class.
	public void showMedicineAvailability() {
		storeInchargeClassDisplayers.displayAllAvailableMedicines();
	}
	
	//The below method is used to call the respective methods of another class.
	public void showMedicineDetailsAlongWithCategoryDetails() {
		storeInchargeClassDisplayers.showMedicineDetailsAlongWithCategoryDetails();
	}
}
