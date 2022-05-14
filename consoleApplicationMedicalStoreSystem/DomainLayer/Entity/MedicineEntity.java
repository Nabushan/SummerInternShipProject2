package consoleApplicationMedicalStoreSystem.DomainLayer.Entity;

public class MedicineEntity {
	private String medicineName;
	private String medicineExpiryDate;
	private String medicineDosage;
	private int medicineSuppliedById;
	private String medicineUsage;
	private String pricePerMedicine;
	private int medicineCategoryId;
	
	public String getMedicineName() {
		return medicineName;
	}
	
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public String getMedicineExpiryDate() {
		return medicineExpiryDate;
	}
	
	public void setMedicineExpiryDate(String medicineExpiryDate) {
		this.medicineExpiryDate = medicineExpiryDate;
	}
	
	public String getMedicineDosage() {
		return medicineDosage;
	}
	
	public void setMedicineDosage(String medicineDosage) {
		this.medicineDosage = medicineDosage;
	}
	
	public int getMedicineSuppliedById() {
		return medicineSuppliedById;
	}
	
	public void setMedicineSuppliedById(int medicineSuppliedById) {
		this.medicineSuppliedById = medicineSuppliedById;
	}
	
	public String getMedicineUsage() {
		return medicineUsage;
	}
	
	public void setMedicineUsage(String medicineUsage) {
		this.medicineUsage = medicineUsage;
	}
	
	public String getPricePerMedicine() {
		return pricePerMedicine;
	}
	
	public void setPricePerMedicine(String pricePerMedicine) {
		this.pricePerMedicine = pricePerMedicine;
	}
	
	public int getMedicineCategoryId() {
		return medicineCategoryId;
	}
	
	public void setMedicineCategoryId(int medicineCategoryId) {
		this.medicineCategoryId = medicineCategoryId;
	}
	
	public String toString() {
		return "MedicineEntity [medicineName = " + medicineName + "\nmedicineExpiryDate = " + medicineExpiryDate
				+ "\nmedicineDosage = " + medicineDosage + "\nmedicineSuppliedById = " + medicineSuppliedById
				+ "\nmedicineUsage = " + medicineUsage + "\npricePerMedicine = " + pricePerMedicine + "\nmedicineCategoryId = "
				+ medicineCategoryId + "]\n";
	}
}
