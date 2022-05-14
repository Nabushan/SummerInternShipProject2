package consoleApplicationMedicalStoreSystem.DomainLayer.Entity;

public class UserEntity {
	private String userName;
	private String contactNumber;
	private String purchaseDate;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String toString() {
		return "UserEntity [userName = " + userName + "\n"
				+ "contactNumber = " + contactNumber + "\n"
				+ "purchaseDate = " + purchaseDate + "]";
	}
}
