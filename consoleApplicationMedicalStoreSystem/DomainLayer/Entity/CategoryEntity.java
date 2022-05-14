package consoleApplicationMedicalStoreSystem.DomainLayer.Entity;

public class CategoryEntity {
	private String categoryName;
	private String usedFor;
	private String averageCost;
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getUsedFor() {
		return usedFor;
	}
	
	public void setUsedFor(String usedFor) {
		this.usedFor = usedFor;
	}
	
	public String getAverageCost() {
		return averageCost;
	}
	
	public void setAverageCost(String averageCost) {
		this.averageCost = averageCost;
	}

	public String toString() {
		return "CategoryEntity [categoryName = " + categoryName + "\n"
				+ "usedFor = " + usedFor + "\n"
				+ "averageCost = " + averageCost + "]";
	}
}
