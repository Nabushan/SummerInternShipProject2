package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.MedicineEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class MedicineClassRemovers implements DataBaseRequiredObjects{
	private MedicineEntity medicineEntityObject;
	private Statement statement;
	
	//The below method is used to set the Medicine Entity Object.
	public void setMedicineEntityObject(MedicineEntity object) {
		medicineEntityObject = object;
	}

	//The below method passes the query to the respective method.
	public void removeMedicine(int medicineId) {
		String query = "delete from medicinedatabase\r\n"
				+ "where Id = "+medicineId;
		this.executePassedQuery(query);
	}
	
	//The below method passes the query to the respective method.
	public void removeMedicine(String medicineName) {
		String query = "delete from medicinedatabase\r\n"
				+ "where MedicineName = "+medicineName;
		this.executePassedQuery(query);
	}
	
	//This method is used to execute the passed query
	public void executePassedQuery(String query) {
		try {
			statement.executeQuery(query);
			System.out.println("Removal Successful");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Removal : "+e);
			System.out.println(query);
		}
	}
}
