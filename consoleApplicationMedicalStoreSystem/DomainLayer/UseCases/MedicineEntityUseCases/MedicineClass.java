package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.MedicineEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CategoryClassInterface.OtherClassRequiredCategoryDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CompanyClassInterface.OtherClassRequiredCompanyDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.MedicineClassInterface.MedicineClassRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;

public class MedicineClass implements MedicineClassRequiredObjects,OtherClassRequiredCompanyDisplayers,OtherClassRequiredCategoryDisplayers,ScannerObject{
	private MedicineEntity medicineEntityObject;
	private String medicineName;
	private String medicineExpiryDate;
	private String medicineDosage;
	private int medicineSuppliedById;
	private String pricePerMedicine;
	private int medicineCategoryId;
	private int medicineId;
	
	/*
	 * The below constructor creates a new Medical entity class for each and every class creation and it sets the 
	 * Medical Entity attributes in those respective classes using the methods provided by those respective
	 * classes.
	 * */
	public MedicineClass() {
		medicineEntityObject = new MedicineEntity();
		
		medicineClassAdders.setMedicineEntityObject(medicineEntityObject);
		medicineClassUpdaters.setMedicineEntityObject(medicineEntityObject);
		medicineClassDisplayers.setMedicineEntityObject(medicineEntityObject);
		medicineClassRemovers.setMedicineEntityObject(medicineEntityObject);
	}
	
	//The below method is used to get the values from the user and also to store those into the Medicine
	//Data Base.
	public void addMedicine() {
		System.out.println("Enter the Medicine Name : ");
		input.nextLine();
		medicineName = input.nextLine();
		medicineEntityObject.setMedicineName(medicineName);
		System.out.println("Enter the Medicine Expiry Date(yyyy-mm-dd) : ");
		medicineExpiryDate = input.nextLine();
		medicineEntityObject.setMedicineExpiryDate(medicineExpiryDate);
		System.out.println("Enter the Medicine Dosage : ");
		medicineDosage = input.nextLine();
		medicineEntityObject.setMedicineDosage(medicineDosage);
		
		//The below line is used to display the Company details.
		companyClassDisplayers.displayAllCompanyIdDetails();
		
		System.out.println("Enter the Medicine Supplier Id : ");
		medicineSuppliedById = input.nextInt();
		medicineEntityObject.setMedicineSuppliedById(medicineSuppliedById);
		System.out.println("Enter the Price Per medicine : ");
		input.nextLine();
		pricePerMedicine = "Rs."+input.nextLine();
		medicineEntityObject.setPricePerMedicine(pricePerMedicine);
		
		//The below line is used to display the Category details.
		categoryClassDisplayers.displayAllCategoryIdDetails();
		
		System.out.println("Enter the Medicine Category Id : ");
		medicineCategoryId = input.nextInt();
		medicineEntityObject.setMedicineCategoryId(medicineCategoryId);
		
		medicineClassAdders.addMedicine();
	}
	
	//The below method is used to get the values from the user and update those into the Medicine
	//Data Base.
	public void updateMedicine() {
		//The below line is used to display the medicine details.
		medicineClassDisplayers.displayAllMedicinesDetails();
		System.out.println("Enter the Id of the Medicine that you would like to change : ");
		medicineId = input.nextInt();
		System.out.println("1 -> To update Medicine Name\n"
				+ "2 -> To update Expiry Date\n"
				+ "3 -> To update Dosage\n"
				+ "4 -> To update Supplier Id\n"
				+ "5 -> To update Price Per Medicine\n"
				+ "6 -> To update Medicine Category Id\n");
		
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the new Medicine Name to be updated : ");
			input.nextLine();
			medicineName = input.nextLine();
			medicineClassUpdaters.updateMedicineName(medicineId, medicineName);
			break;
		case 2:
			System.out.println("Enter the new Expiry Date(yyyy-mm-dd) : ");
			input.nextLine();
			medicineExpiryDate = input.nextLine();
			medicineClassUpdaters.updateMedicineExpiryDate(medicineId, medicineExpiryDate);
			break;
		case 3:
			System.out.println("Enter the new Dosage : ");
			input.nextLine();
			medicineDosage = input.nextLine();
			medicineClassUpdaters.updateMedincinDosage(medicineId, medicineDosage);
			break;
		case 4:
			companyClassDisplayers.displayAllCompanyIdDetails();
			System.out.println("Enter the Medicine Supplier Id : ");
			medicineSuppliedById = input.nextInt();
			medicineClassUpdaters.updateMedincineSupplierId(medicineId, medicineSuppliedById);
			break;
		case 5:
			System.out.println("Enter new Price Per Medicine : ");
			input.nextLine();
			pricePerMedicine = input.nextLine();
			medicineClassUpdaters.updatePricePerMedicine(medicineId, pricePerMedicine);
			break;
		case 6:
			categoryClassDisplayers.displayAllCategoryIdDetails();
			System.out.println("Enter new Medicine Category Id : ");
			medicineCategoryId = input.nextInt();
			medicineClassUpdaters.updateMedincineCategoryId(medicineId, medicineCategoryId);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to remove an entry from the Medicine Data Base.
	public void removeMedicine() {
		System.out.println("1 -> To remove by Medicine Id\n"
				+ "2 -> To remove by Medicine Name\n");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the Medicine to remove : ");
			medicineId = input.nextInt();
			medicineClassRemovers.removeMedicine(medicineId);
			break;
		
		case 2:
			System.out.println("Enter the Name of the medicine to remove : ");
			medicineName = input.nextLine();
			medicineClassRemovers.removeMedicine(medicineName);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to display the Details from the Medicine Data Base.
	public void displaymedicine() {
		System.out.println("1 -> To display by Medicine Id\n"
				+ "2 -> To display by Medicine Name\n"
				+ "3 -> To display all Medicines");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the Medicine you would like to display : ");
			medicineId = input.nextInt();
			medicineClassDisplayers.displayMedicineDetails(medicineId);
			break;
		case 2:
			System.out.println("Enter the name of the Medicine you would like to display : ");
			input.nextLine();
			medicineName = input.nextLine();
			medicineClassDisplayers.displayMedicineDetails(medicineName);
			break;
		case 3:
			medicineClassDisplayers.displayAllMedicinesDetails();
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
}
