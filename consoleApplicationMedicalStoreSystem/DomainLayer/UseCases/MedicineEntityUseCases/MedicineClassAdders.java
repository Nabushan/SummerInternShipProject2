package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases;

import java.sql.Statement;
import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.MedicineEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class MedicineClassAdders implements DataBaseRequiredObjects{
	private MedicineEntity medicineEntityObject;
	private Statement statement;

	//The below method is used to set the Medicine Entity Object.
	public void setMedicineEntityObject(MedicineEntity object) {
		medicineEntityObject = object;
	}
	
	//The below method passes the query to the respective method.
	public void addMedicine() {
		String query = "insert into medicinedatabase(MedicineName,ProductionCompanyId,Dosage,"
				+ "ExpiryDate,MedicineCategoryId,PricePerMedicine) values('"+
				medicineEntityObject.getMedicineName()+"',"+medicineEntityObject.getMedicineSuppliedById()+
				",'"+medicineEntityObject.getMedicineDosage()+"','"+medicineEntityObject.getMedicineExpiryDate()
				+"',"+medicineEntityObject.getMedicineCategoryId()+",'"+medicineEntityObject.getPricePerMedicine()+"')";
		this.executePassedQuery(query);
	}
	
	//This method is used to execute the passed query
	public void executePassedQuery(String query) {
		statement = databaseObject.getStatement();
		try {
			statement.executeUpdate(query);
			System.out.println("Addition Successful");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Adding : "+e);
			System.out.println(query);
		}
	}
}
