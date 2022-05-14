package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicalStore;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminClassInterface.AdminObjectInterface;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.MedicalClassInterface.MedicalClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.StoreInchargeUseCases.StoreInchargeClass;

public class MedicalStoreFactory implements AdminObjectInterface,ScannerObject,MedicalClass{
	private boolean mainFlag = true;
	private int displayId;
	private StoreInchargeClass storeIncharge = new StoreInchargeClass();

	//The below method shows the console options to be used by the user.
	public void access() {
		while(mainFlag) {
			System.out.println("1 -> Admin\n"
					+ "2 -> Store Incharge\n"
					+ "3 -> To Quit");
			int val = input.nextInt();
			switch(val) {
			case 1:
				boolean adminFlag = admin.checkAdmin();
				if(!adminFlag) break;
				boolean adminPersistFlag = true;
				while(adminPersistFlag) {
					System.out.println("1 -> To add Details\n"
							+ "2 -> To update Details\n"
							+ "3 -> To display Details\n"
							+ "4 -> To reset Passwod\n"
							+ "5 -> To Enter new Admin Details\n"
							+ "6 -> To log out Admin");
					int choice = input.nextInt();
					switch(choice) {
					case 1:
						System.out.println("1 -> To add Medicine Details\n"
								+ "2 -> To add Company Details\n"
								+ "3 -> To add Category Details\n"
								+ "4 -> To add Sales Record Details\n"
								+ "5 -> To go Back");
						
						int addChoice = input.nextInt();
						switch(addChoice) {
						case 1:
							admin.feedMedicineDetails();
							break;
						case 2:
							admin.feedCompanyDetails();
							break;
						case 3:
							admin.feedCategoryDetails();
							break;
						case 4:
							admin.feedSalesDetails();
							break;
						case 5:
							break;
						default:
							System.out.println("Entered Option not available, Please select a valid Option.");
							break;
						}
						break;
					case 2:
						System.out.println("1 -> To update Medicine Details\n"
								+ "2 -> To update Company Details\n"
								+ "3 -> To update Category Details\n"
								+ "4 -> To update Sales Record Details\n"
								+ "5 -> To go Back");
						
						int updateChoice = input.nextInt();
						switch(updateChoice) {
						case 1:
							admin.updateMedicineDetails();
							break;
						case 2:
							admin.updateCompanyDetails();
							break;
						case 3:
							admin.updateCategoryDetails();
							break;
						case 4:
							admin.updateSalesDetails();
							break;
						case 5:
							break;
						default:
							System.out.println("Entered Option not available, Please select a valid Option.");
							break;
						}
						break;
					case 3:
						System.out.println("1 -> To display Medicine Details\n"
								+ "2 -> To display Company Details\n"
								+ "3 -> To display Category Details\n"
								+ "4 -> To display Sales Record Details\n"
								+ "5 -> To display All the details of Medicine,Category and Company\n"
								+ "6 -> To display details of Medicine,Category and Company for a particular Id of Medicine\n"
								+ "7 -> To display All the details of Company and Category Details\n"
								+ "8 -> To display details of the Company and Category for a particular Id of Company\n"
								+ "9 -> To go Back");
						
						int displayChoice = input.nextInt();
						switch(displayChoice) {
						case 1:
							admin.displayMedicineDetails();
							break;
						case 2:
							admin.displayCompanyDetails();
							break;
						case 3:
							admin.displayCategoryDetails();
							break;
						case 4:
							admin.displaySalesDetails();
							break;
						case 5:
							admin.displayAllMedicineCompanyAndCategoryDetails();
							break;
						case 6:
							System.out.println("Enter the Id of the Details which you want to View : ");
							displayId = input.nextInt();
							admin.displayAllMedicineCompanyAndCategoryDetails(displayId);
							break;
						case 7:
							admin.displayAllCompanyAndCategoryDetails();;
							break;
						case 8:
							System.out.println("Enter the Id of the Details which you want to View : ");
							displayId = input.nextInt();
							admin.displayAllCompanyAndCategoryDetails(displayId);
						case 9:
							break;
						default:
							System.out.println("Entered Option not available, Please select a valid Option.");
							break;
						}
						break;
					case 4:
						admin.updateAdminPassword();
						break;
					case 5:
						admin.setAdminDetails();
					case 6:
						adminPersistFlag = false;
						break;
					default:
						System.out.println("Entered Option not available, Please select a valid Option.");
						break;
					}
				}
				break;
			case 2:
				boolean storeInchargePersistFlag = true;
				while(storeInchargePersistFlag) {
					System.out.println("1 -> To add Sales Entry\n"
							+ "2 -> To update Sales Entry\n"
							+ "3 -> To display the Medicine Availability\n"
							+ "4 -> To display Medicine Along with Category Details\n"
							+ "5 -> To log out as Store Incharge.");
					int storeOption = input.nextInt();
					switch(storeOption) {
					case 1:
						storeIncharge.addSalesEntry();
						break;
					case 2:
						storeIncharge.updateSalesEntry();
						break;
					case 3:
						storeIncharge.showMedicineAvailability();
						break;
					case 4:
						storeIncharge.showMedicineDetailsAlongWithCategoryDetails();
						break;
					case 5:
						storeInchargePersistFlag = false;
						break;
					default:
						System.out.println("Entered Option not available, Please select a valid Option.");
						break;
					}
				}
				break;
			case 3:
				mainFlag = false;
				break;
			default:
				System.out.println("Entered Option not available, Please select a valid Option.");
				break;
			}	
		}
	}
}
