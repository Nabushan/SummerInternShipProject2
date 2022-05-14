package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.CategoryEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CategoryClassInterface.CategoryClassRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;

public class CategoryClass implements CategoryClassRequiredObjects,ScannerObject{
	private int categoryId;
	private String categoryName;
	private String usedFor;
	private String averageCost;
	private CategoryEntity categoryEntity;
	
	//The below constructor will create a new Category Entity and it will pass its reference
	//to the necessary Classes.
	public CategoryClass() {
		categoryEntity = new CategoryEntity();
		
		categoryClassAdders.setCategoryEntityObject(categoryEntity);
		categoryClassUpdaters.setCategoryEntityObject(categoryEntity);
		categoryClassDisplayers.setCategoryEntityObject(categoryEntity);
		categoryClassRemovers.setCategoryEntityObject(categoryEntity);
	}
	
	//The below method is used to get the Category details and call a respective method to 
	//add them into the CategoryDataBase.
	public void addCategoryDetails() {
		System.out.println("Enter the Categroy Name : ");
		input.nextLine();
		categoryName = input.nextLine();
		categoryEntity.setCategoryName(categoryName);
		System.out.println("Enter the usage Criteria for this Category : ");
		usedFor = input.nextLine();
		categoryEntity.setUsedFor(usedFor);
		System.out.println("Enter the AverageCost of the Medicine Produced : ");
		averageCost = input.nextLine();
		categoryEntity.setAverageCost(averageCost);
		categoryClassAdders.addCategoryDetails();
	}
	
	//The below method is used to update the Category details and call a respective method to 
	//update them into the CategoryDataBase.
	public void updateCategoryDetails() {
		categoryClassDisplayers.displayAllCategoryDetails();
		System.out.println("Enter the Id of the Category which you would like to edit : ");
		categoryId = input.nextInt();
		System.out.println("1 -> To set Category Name\n"
				+ "2 -> To set the Usage details the Category\n"
				+ "3 -> To set Average cost");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the new Category Name : ");
			input.nextLine();
			categoryName = input.nextLine();
			categoryClassUpdaters.updateCategoryName(categoryId, categoryName);
			break;
		case 2:
			System.out.println("Enter the new Usage Details : ");
			input.nextLine();
			usedFor = input.nextLine();
			categoryClassUpdaters.updateUsedForDetails(categoryId, usedFor);
			break;
		case 3:
			System.out.println("Enter the new Average Cost : ");
			input.nextLine();
			averageCost = input.nextLine();
			categoryClassUpdaters.updateAverageCost(categoryId, averageCost);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to remove the Category details and call a respective method to 
	//remove them from the CategoryDataBase.
	public void removeCategory() {
		System.out.println("1 -> To remove Category using Id\n"
				+ "2 -> To remove Category using Category Name");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Category Id to remove : ");
			categoryId = input.nextInt();
			categoryClassRemovers.removeCategoryDetails(categoryId);
			break;
		case 2:
			System.out.println("Enter the Category Name to remove : ");
			input.nextLine();
			categoryName = input.nextLine();
			categoryClassRemovers.removeCategoryDetails(categoryName);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to display the Category details and call a respective method to 
	//display them.
	public void displayDetails() {
		System.out.println("1 -> To dispaly using Category Id\n"
				+ "2 -> To display using Category Name\n"
				+ "3 -> To display all Category details");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the Category you want to display : ");
			categoryId = input.nextInt();
			categoryClassDisplayers.displayCategoryDetails(categoryId);
			break;
		case 2:
			System.out.println("Enter the name of the Category you want to display : ");
			categoryName = input.nextLine();
			categoryClassDisplayers.displayCategoryDetails(categoryName);
			break;
		case 3:
			categoryClassDisplayers.displayAllCategoryDetails();
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
}
