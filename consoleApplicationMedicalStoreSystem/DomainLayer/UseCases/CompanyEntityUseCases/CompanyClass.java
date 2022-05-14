package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CompanyEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CategoryClassInterface.OtherClassRequiredCategoryDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CompanyClassInterface.CompanyClassRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CompanyClassInterface.OtherClassRequiredCompanyDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases.CategoryClassDisplayers;

public class CompanyClass implements CompanyClassRequiredObjects,OtherClassRequiredCategoryDisplayers,ScannerObject{
	private CompanyEntity companyEntityObject;
	private String companyName;
	private String medicineManufactured;
	private String companyLocation;
	private int productionCategoryId;
	private int companyId;
	
	//The below constructor will create a new Company Entity and it will pass its reference
	//to the necessary Classes.
	public CompanyClass() {
		companyEntityObject = new CompanyEntity();
		
		companyClassAdders.setCompanyEntityObject(companyEntityObject);
		companyClassUpdaters.setCompanyEntityObject(companyEntityObject);
		companyClassRemovers.setCompanyEntityObject(companyEntityObject);
		companyClassDisplayers.setCompanyEntityObject(companyEntityObject);
	}
	
	//The below method is used to get the Company details and call a respective method to 
	//add them into the CompanyDataBase.
	public void addCompany() {
		System.out.println("Enter the company Name : ");
		input.nextLine();
		companyName = input.nextLine();
		companyEntityObject.setCompanyName(companyName);
		System.out.println("Enter the Medicine manufactured by the Company : ");
		medicineManufactured = input.nextLine();
		companyEntityObject.setMedicineManufactured(medicineManufactured);
		System.out.println("Enter the location of the Company : ");
		companyLocation = input.nextLine();
		companyEntityObject.setCompanyLocation(companyLocation);
		categoryClassDisplayers.displayAllCategoryDetails();
		System.out.println("Enter the Production category Id of the Company : ");
		productionCategoryId = input.nextInt();
		companyEntityObject.setProductionCategoryId(productionCategoryId);
		
		companyClassAdders.addCompany();
	}
	
	//The below method is used to update the Company details and call a respective method to 
	//update them into the CompanyDataBase.
	public void updateCompany() {
		companyClassDisplayers.displayAllCompanyIdDetails();
		System.out.println("Enter the Company Id that you would like to update : ");
		companyId = input.nextInt();
		System.out.println("1 -> To update the Company Name\n"
				+ "2 -> To update Medicine Manufactured\n"
				+ "3 -> To update Company Location\n"
				+ "4 -> To update prodcution Category\n");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the new Company Name : ");
			input.nextLine();
			companyName = input.nextLine();
			companyClassUpdaters.updateCompanyName(companyId, companyName);
			break;
		case 2:
			System.out.println("Enter the new Medicine Name : ");
			input.nextLine();
			medicineManufactured = input.nextLine();
			companyClassUpdaters.updateMedicineManufactured(companyId, medicineManufactured);
			break;
		case 3:
			System.out.println("Enter the new Company Location : ");
			input.nextLine();
			companyLocation = input.nextLine();
			companyClassUpdaters.updateCompanyLocation(companyId, companyLocation);
			break;
		case 4:
			categoryClassDisplayers.displayAllCategoryIdDetails();
			System.out.println("Enter the new Produtcion Category Id: ");
			productionCategoryId = input.nextInt();
			companyClassUpdaters.updateProdutionCategory(companyId, productionCategoryId);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to remove the Company details and call a respective method to 
	//remove them from the CompanyDataBase.
	public void removeCompany() {
		System.out.println("1 -> To remove Company details using Id\n"
				+ "2 -> To remove Company details using Company Name");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the Company : ");
			companyId = input.nextInt();
			companyClassRemovers.removeCompanyDetails(companyId);
			break;
		case 2:
			System.out.println("Enter the Name of the of the Company : ");
			companyName = input.nextLine();
			companyClassRemovers.removeCompanyDetails(companyName);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to display the Company details and call a respective method to 
	//display them.
	public void displayCompany() {
		System.out.println("1 -> Display Company Details using Id\n"
				+ "2 -> Dispaly Company Details Using Company Name\n"
				+ "3 -> Display all Company Details\n");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the Company : ");
			companyId = input.nextInt();
			companyClassDisplayers.displayCompanyDetails(companyId);
			break;
		case 2:
			System.out.println("Enter the name of the Company : ");
			input.nextLine();
			companyName = input.nextLine();
			companyClassDisplayers.displayCompanyDetails(companyName);
			break;
		case 3:
			companyClassDisplayers.displayAllCompanyDetails();
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
}
