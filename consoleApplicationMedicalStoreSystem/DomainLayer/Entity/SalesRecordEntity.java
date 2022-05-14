package consoleApplicationMedicalStoreSystem.DomainLayer.Entity;

public class SalesRecordEntity {
	private String individualName;
	private String individualMobileNumber;
	private int individualId;
	private String prescribedBy;
	private int medicineId;
	private int quantityPurchased;
	private int medicineCategoryId;
	private int medicinePrice;
	private String totalCost;
	private String purchaseDate;
	
	public String getIndividualName() {
		return individualName;
	}
	
	public void setIndividualName(String individualName) {
		this.individualName = individualName;
	}
	
	public String getIndividualMobileNumber() {
		return individualMobileNumber;
	}
	
	public void setIndividualMobileNumber(String individualMobileNumber) {
		this.individualMobileNumber = individualMobileNumber;
	}
	
	public int getIndividualId() {
		return individualId;
	}

	public void setIndividualId(int individualId) {
		this.individualId = individualId;
	}
	
	public String getPrescribedBy() {
		return prescribedBy;
	}
	
	public void setPrescribedBy(String prescribedBy) {
		this.prescribedBy = prescribedBy;
	}
	
	public int getMedicineId() {
		return medicineId;
	}
	
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	
	public int getQuantityPurchased() {
		return quantityPurchased;
	}
	
	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	
	public int getMedicineCategoryId() {
		return medicineCategoryId;
	}
	
	public void setMedicineCategory(int medicineCategoryId) {
		this.medicineCategoryId = medicineCategoryId;
	}
	
	public int getMedicinePrice() {
		return medicinePrice;
	}
	
	public void setMedicinePrice(int medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	
	public String getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String toString() {
		return "SalesRecordEntity [individualName = " + individualName + "\n"
				+ "individualMobileNumber = "+ individualMobileNumber + "\n"
				+ "prescribedBy = " + prescribedBy + "\n"
				+ "medicineName = " + medicineId + "\n"
				+ "quantityPurchased = " + quantityPurchased + "\n"
				+ "medicineCategory = " + medicineCategoryId + "\n"
				+ "medicinePrice = " + medicinePrice + "\n"
				+ "totalCost = " + totalCost + "\n"
				+ "purchaseDate = " + purchaseDate + "]";
	}
}
