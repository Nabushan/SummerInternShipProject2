package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases;

import java.sql.Statement;
import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.MedicineEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class MedicineClassUpdaters implements DataBaseRequiredObjects{
	private MedicineEntity medicineEntityObject;
	private Statement statement;
	
	//The below method is used to set the Medicine Entity Object.
	public void setMedicineEntityObject(MedicineEntity object) {
		medicineEntityObject = object;
	}
	
	//The below method is used to pass the query to the respective method.
	public void updateMedicineName(int Id,String newName){
		medicineEntityObject.setMedicineName(newName);
		String query = "update medicinedatabase\r\n"
				+ "set MedicineName = \""+ newName +"\"\r\n"
				+ "where Id =" +Id;
		
		this.executePassedQuery(query);
	}
	
	//The below method is used to pass the query to the respective method.
	public void updateMedicineExpiryDate(int Id,String newDate) {
		medicineEntityObject.setMedicineExpiryDate(newDate);
		String query = "update medicinedatabase\r\n"
				+ "set ExpiryDate = \""+ newDate +"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to pass the query to the respective method.
	public void updateMedincinDosage(int Id,String newDosage) {
		medicineEntityObject.setMedicineDosage(newDosage);
		String query = "update medicinedatabase\r\n"
				+ "set Dosage = \""+ newDosage +"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to pass the query to the respective method.
	public void updateMedincineSupplierId(int Id,int newSupplierId) {
		medicineEntityObject.setMedicineSuppliedById(newSupplierId);
		String query = "update medicinedatabase\r\n"
				+ "set ProductionCompanyId = "+ newSupplierId +"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
		
	//The below method is used to pass the query to the respective method.
	public void updatePricePerMedicine(int Id,String newPrice) {
		medicineEntityObject.setPricePerMedicine(newPrice);
		String query = "update medicinedatabase\r\n"
				+ "set PricePerMedicine = \"Rs."+newPrice
				+ "\" where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to pass the query to the respective method.
	public void updateMedincineCategoryId(int Id,int newCategoryId) {
		medicineEntityObject.setMedicineCategoryId(newCategoryId);
		String query = "update medicinedatabase\r\n"
				+ "set MedicineCategoryId = "+ newCategoryId +"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//This method is used to execute the passed query
	public void executePassedQuery(String query) {
		statement = databaseObject.getStatement();
		try {
			statement.executeUpdate(query);
			System.out.println("Updation Successful");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Updation : "+e);
			System.out.println(query);
		}
	}
}
