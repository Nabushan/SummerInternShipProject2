package consoleApplicationMedicalStoreSystem.DomainLayer.Entity;

public class CompanyEntity {
	private String companyName;
	private String medicineManufactured;
	private String companyLocation;
	private int productionCategoryId;
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getMedicineManufactured() {
		return medicineManufactured;
	}
	
	public void setMedicineManufactured(String medicineManufactured) {
		this.medicineManufactured = medicineManufactured;
	}
	
	public String getCompanyLocation() {
		return companyLocation;
	}
	
	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}
	
	public int getProductionCategoryId() {
		return productionCategoryId;
	}
	
	public void setProductionCategoryId(int productionCategoryId) {
		this.productionCategoryId = productionCategoryId;
	}

	public String toString() {
		return "CompanyEntity [companyName = " + companyName + "\nmedicineManufactured = " + medicineManufactured
				+ "\ncompanyLocation = " + companyLocation + "\nproductionCategoryId = " + productionCategoryId + "]";
	}
	
	
}
