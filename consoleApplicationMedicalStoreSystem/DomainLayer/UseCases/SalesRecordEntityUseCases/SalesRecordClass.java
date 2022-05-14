package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.SalesRecordEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.SalesRecordClassInterface.SalesRecordClassRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StoreInchargeRequiredObjectsInterface.StoreInchargeClassRequiredDisplayersObjectsInterface;

public class SalesRecordClass implements SalesRecordClassRequiredObjects,ScannerObject,StoreInchargeClassRequiredDisplayersObjectsInterface{
	private String individualName;
	private String individualMobileNumber;
	private String prescribedBy;
	private int medicineId;
	private int quantityPurchased;
	private int medicineCategoryId;
	private int medicinePrice;
	private String totalCost;
	private String purchaseDate;
	private int salesRecordId;
	private SalesRecordEntity salesRecordEntityObject;
	
	/*
	 * The below constructor creates a new Sales Record entity class for each and every class creation and it sets the 
	 * Sales Record Entity attributes in those respective classes using the methods provided by those respective
	 * classes.
	 * */
	public SalesRecordClass() {
		salesRecordEntityObject = new SalesRecordEntity();
		
		salesRecordClassAdders.setSalesRecordEntity(salesRecordEntityObject);
		salesRecordClassUpdaters.setSalesRecordEntity(salesRecordEntityObject);
		salesRecordClassDisplayers.setSalesRecordEntity(salesRecordEntityObject);
		salesRecordClassRemovers.setSalesRecordEntity(salesRecordEntityObject);
	}
	
	//The below method is used to get the values from the user and also to store those into the Sales
	//Data Base.
	public void addSalesRecord(String name,String contactNumber,String purchaseDate) {
		salesRecordEntityObject.setIndividualName(name);
		salesRecordEntityObject.setIndividualMobileNumber(contactNumber);
		System.out.println("Enter the prescribed Doctor's Name : ");
		prescribedBy = input.nextLine();
		salesRecordEntityObject.setPrescribedBy(prescribedBy);
		medicineClassDisplayers.displayMedicineWithId();
		System.out.println("Enter the Medicine Id : ");
		medicineId = input.nextInt();
		salesRecordEntityObject.setMedicineId(medicineId);
		//System.out.println("Enter the Medicine Category Id : ");
		//medicineCategoryId = input.nextInt();
		//salesRecordEntityObject.setMedicineCategory(medicineCategoryId);
		System.out.println("Enter the Quantity of Medicine Purchased : ");
		quantityPurchased = input.nextInt();
		salesRecordEntityObject.setQuantityPurchased(quantityPurchased);
		//System.out.println("Enter the Price of the Medicine : ");
		//medicinePrice = input.nextInt();
		//salesRecordEntityObject.setMedicinePrice(medicinePrice);
		//totalCost = "Rs."+(quantityPurchased*medicinePrice);
		//salesRecordEntityObject.setTotalCost(totalCost);
		salesRecordEntityObject.setPurchaseDate(purchaseDate);
		salesRecordClassAdders.addSalesRecord();
	}
	
	//The below method is used to get the values from the user and update those into the Sales
	//Data Base.
	public void updateSalesRecord() {
		System.out.println("Enter the Id of the Sales Record that you would like to edit : ");
		salesRecordId = input.nextInt();
		System.out.println("1 -> To update User Name\n"
				+ "2 -> To update User Number\n"
				+ "3 -> To update the prescribed Doctor's Name\n"
				+ "4 -> To update the Quantity\n"
				+ "5 -> To update the Medicine Category Id\n"
				+ "6 -> To update the Medicine Id\n"
				+ "7 -> To update the Medicine Price\n"
				+ "8 -> To update the Purchase Date");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the User Name : ");
			input.nextLine();
			individualName = input.nextLine();
			salesRecordClassUpdaters.updateIndividualName(salesRecordId, individualName);
			break;
		case 2:
			System.out.println("Enter the User Contact Number : ");
			input.nextLine();
			individualMobileNumber = input.nextLine();
			salesRecordClassUpdaters.updateIndividualMobileNumber(salesRecordId, individualMobileNumber);
			break;
		case 3:
			System.out.println("Enter the prescribed Doctor's Name : ");
			input.nextLine();
			prescribedBy = input.nextLine();
			salesRecordClassUpdaters.updatePrescribedDoctorName(salesRecordId, prescribedBy);
			break;
		case 4:
			System.out.println("Enter the Quantity of Medicine Purchased : ");
			quantityPurchased = input.nextInt();
			salesRecordClassUpdaters.updateQuantity(salesRecordId, quantityPurchased);
			break;
		case 5:
			System.out.println("Enter the Medicine Category Id : ");
			medicineCategoryId = input.nextInt();
			salesRecordClassUpdaters.updateMedicineCategoryId(salesRecordId, medicineCategoryId);
			break;
		case 6:
			System.out.println("Enter the Medicine Id : ");
			medicineId = input.nextInt();
			salesRecordClassUpdaters.updateMedicineId(salesRecordId, medicineId);
			break;
		case 7:
			System.out.println("Enter the Price of the Medicine : ");
			medicinePrice = input.nextInt();
			salesRecordClassUpdaters.updateMedicinePrice(salesRecordId, medicinePrice);
			break;
		case 8:
			System.out.println("Enter the Purchased Date : ");
			input.nextLine();
			purchaseDate = input.nextLine();
			salesRecordClassUpdaters.updatePurchaseDate(salesRecordId, purchaseDate);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to remove an entry from the Sales Data Base.
	public void removeSalesRecord() {
		System.out.println("1 -> To remove Sales Record using Id\n"
				+ "2 -> To remove Sales Record using Name and Number\n"
				+ "3 -> To remove Sales Record using Name");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the Sales Record you'd like to remove : ");
			salesRecordId = input.nextInt();
			salesRecordClassRemovers.removeSalesRecordDetails(salesRecordId);
			break;
		case 2:
			System.out.println("Enter the Name of the Sales Record you'd like to remove : ");
			input.nextLine();
			individualName = input.nextLine();
			System.out.println("Enter the Number of the Sales Record you'd like to remove : ");
			individualMobileNumber = input.nextLine();
			salesRecordClassRemovers.removeSalesRecordDetails(individualName, individualMobileNumber);
			break;
		case 3:
			System.out.println("Enter the Name of the Sales Record you'd like to remove : ");
			input.nextLine();
			individualName = input.nextLine();
			salesRecordClassRemovers.removeSalesRecordDetails(individualName);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}

	//The below method is used to display the Details from the Sales Data Base.
	public void displaySalesRecord() {
		System.out.println("1 -> To display Sales Record using Id\n"
				+ "2 -> To display Sales Record using Name and Number\n"
				+ "3 -> To display Sales Record using Name\n"
				+ "4 -> To display All Sales Record.");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the Sales Record you'd like to display : ");
			salesRecordId = input.nextInt();
			salesRecordClassDisplayers.displaySalesRecordDetails(salesRecordId);
			break;
		case 2:
			System.out.println("Enter the Name of the Sales Record you'd like to display : ");
			input.nextLine();
			individualName = input.nextLine();
			System.out.println("Enter the Number of the Sales Record you'd like to display : ");
			individualMobileNumber = input.nextLine();
			salesRecordClassDisplayers.displaySalesRecordDetails(individualName, individualMobileNumber);
			break;
		case 3:
			System.out.println("Enter the Name of the Sales Record you'd like to display : ");
			input.nextLine();
			individualName = input.nextLine();
			salesRecordClassDisplayers.displaySalesRecordDetails(individualName);
			break;
		case 4:
			salesRecordClassDisplayers.displayAllSalesRecordDetails();
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
}
