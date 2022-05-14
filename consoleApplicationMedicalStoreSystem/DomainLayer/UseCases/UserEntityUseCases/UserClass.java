package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.UserEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.ScannerInterface.ScannerObject;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.UserClassInterface.UserClassRequiredObjects;

public class UserClass implements UserClassRequiredObjects,ScannerObject{
	private UserEntity userEntityObject;
	private int userId;
	private String userName;
	private String contactNumber;
	private String purchaseDate;
	
	/*
	 * The below constructor creates a new User entity class for each and every class creation and it sets the 
	 * User Entity attributes in those respective classes using the methods provided by those respective
	 * classes.
	 * */
	public UserClass() {
		userEntityObject = new UserEntity();
		
		userClassAdders.setUserEntityObject(userEntityObject);
		userClassUpdaters.setUserEntityObject(userEntityObject);
		userClassDisplayers.setUserEntityObject(userEntityObject);
		userClassRemovers.setUserEntityObject(userEntityObject);
	}	
	
	//The below method is used to get the values from the user and also to store those into the User
	//Data Base.
	public void addUser() {
		System.out.println("Enter the Name of the User : ");
		input.nextLine();
		userName = input.nextLine();
		userEntityObject.setUserName(userName);
		System.out.println("Enter the Number of the User : ");
		contactNumber = input.nextLine();
		userEntityObject.setContactNumber(contactNumber);
		System.out.println("Enter the Date of Purchase(yyyy-mm-dd) : ");
		purchaseDate = input.nextLine();
		userEntityObject.setPurchaseDate(purchaseDate);
		userClassAdders.addUser();
	}
	
	//The below method is used to get the values from the user and update those into the User
	//Data Base.
	public void updateUser() {
		System.out.println("Enter the Id of the User that you'd like to Update : ");
		userId = input.nextInt();
		System.out.println("1 -> To update the Name of the User\n"
				+ "2 -> To update the Contact Number of the User\n"
				+ "3 -> To  update the Purchase Date of the User");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the New Name of the User to be Updated : ");
			input.nextLine();
			userName = input.nextLine();
			userClassUpdaters.updateUserName(userId, userName);
			break;
		case 2:
			System.out.println("Enter the New Contact Number of the User to be Updated : ");
			input.nextLine();
			contactNumber = input.nextLine();
			userClassUpdaters.updateUserContactNumber(userId, contactNumber);
			break;
		case 3:
			System.out.println("Enter the New Purchased Date to be Updated : ");
			input.nextLine();
			purchaseDate = input.nextLine();
			userClassUpdaters.updatePurchasedDate(userId, purchaseDate);
			break;
		default:
			System.out.println("Entered Option is Unavailable, Please select a proper Option.");
			break;
		}
	}
	
	//The below method is used to remove an entry from the User Data Base.
	public void removeUser() {
		System.out.println("1 -> To remove User Details using Id\n"
				+ "2 -> To remove User Details using Name\n"
				+ "3 -> To remove User Details using Name and Number\n");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the User to Remove : ");
			userId = input.nextInt();
			userClassRemovers.removeUser(userId);
			break;
		case 2:
			System.out.println("Enter the Name of the user you want to Remove : ");
			input.nextLine();
			userName = input.nextLine();
			userClassRemovers.removeUser(userName);
			break;
		case 3:
			System.out.println("Enter the Name of the User you want to Remove : ");
			input.nextLine();
			userName = input.nextLine();
			System.out.println("Enter the Number of the User you want to Remove : ");
			contactNumber = input.nextLine();
			userClassRemovers.removeUser(userName, contactNumber);
			break;
		default:
			break;
		}
	}
	
	//The below method is used to display the Details from the User Data Base.
	public void displayUser() {
		System.out.println("1 -> To Display User Detials using Id\n"
				+ "2 -> To Display User Detials using Name\n"
				+ "3 -> To Display all User Detials");
		int val = input.nextInt();
		switch(val) {
		case 1:
			System.out.println("Enter the Id of the User you'd like to display : ");
			userId = input.nextInt();
			userClassDisplayers.displayUserDetail(userId);
			break;
		case 2:
			System.out.println("Enter the Name of the User you'd like to display : ");
			input.nextLine();
			userName = input.nextLine();
			userClassDisplayers.displayUserDetail(userName);
			break;
		case 3:
			userClassDisplayers.displayAllUserDetails();
			break;
		default:
			break;
		}
	}
	
	//The below method is used to call the respective method of other class.
	public String getUserName() {
		return userEntityObject.getUserName();
	}
	
	//The below method is used to call the respective method of other class.
	public String getContactNumber() {
		return userEntityObject.getContactNumber();
	}
	
	//The below method is used to call the respective method of other class.
	public String getPurchaseDate() {
		return userEntityObject.getPurchaseDate();
	}
}
