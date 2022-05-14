package consoleApplicationMedicalStoreSystem.PresentationLayer.UserInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminClassInterface.AdminObjectInterface;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.MedicalClassInterface.MedicalClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicalStore.MedicalStoreFactory;

public class MainProgram implements AdminObjectInterface,ScannerObject{
	public static void main(String args[]) {
		
		MedicalClass store1 = new MedicalStoreFactory();
		store1.access();
		
		MedicalClass store2 = new MedicalStoreFactory();
		store2.access();
		
	}
}
