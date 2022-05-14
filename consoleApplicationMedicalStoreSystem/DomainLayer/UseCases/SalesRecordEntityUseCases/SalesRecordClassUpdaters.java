package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.SalesRecordEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class SalesRecordClassUpdaters implements DataBaseRequiredObjects{
	private SalesRecordEntity salesRecordEntityObject;
	private Statement statement;
	private ResultSet resultSet;
	
	//The below method is used to set the Sales Record Entity Object.
	public void setSalesRecordEntity(SalesRecordEntity object) {
		salesRecordEntityObject = object;
	}
	
	//The below method is used to update the Individual Name.
	public void updateIndividualName(int Id,String newName) {
		String query="";
		int userId = 0;
		try {
			statement = databaseObject.getStatement();
			//The below query is used to fetch the CustomerId from the Sales record database 
			//which will later be used to update the user details in the User Data Base.
			query = "select CustomerId from salesrecorddatabase\r\n"
					+ "where Id = "+Id;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				userId = resultSet.getInt(1);
			}
			
		}
		catch(Exception e) {
			System.out.println("Exception Caught during Fetching : "+e);
			System.out.println(query);
		}
		
		//The below details is used to update the value in the user data base
		query = "update userdatebase\r\n"
				+ "set UserName = \""+newName+"\"\r\n"
				+ "where Id = "+userId;
		this.executePassedQuery(query);
	}
	
	//The below method is used to update the Individual Number.
	public void updateIndividualMobileNumber(int Id,String newMobileNumber) {
		String query="";
		int userId = 0;
		try {
			statement = databaseObject.getStatement();
			//The below query is used to fetch the CustomerId from the Sales record database 
			//which will later be used to update the user details in the User Data Base.
			query = "select CustomerId from salesrecorddatabase\r\n"
					+ "where Id = "+Id;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				userId = resultSet.getInt(1);
			}
			
		}
		catch(Exception e) {
			System.out.println("Exception Caught during Fetching : "+e);
			System.out.println(query);
		}
		//The below details is used to update the value in the user data base
		query = "update userdatebase\r\n"
				+ "set UserNumber = \""+newMobileNumber+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}
	
	//The below method is used to update the doctors name.
	public void updatePrescribedDoctorName(int Id,String newDoctorName) {
		String query = "update salesrecorddatabase\r\n"
				+ "set PrescribedBy = \""+ newDoctorName +"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}
	
	//The below method is used to update the Quantity details.
	public void updateQuantity(int Id,int newQuantity) {
		//The below query is used to update the quantity.
		String query = "update salesrecorddatabase\r\n"
				+ "set QuantityPurchased = "+ newQuantity +"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
		
		try {
			//The below query is used to fetch the medicine price inorder to update the total cost in the data base.
			query = "select MedicinePrice from salesrecorddatabase\r\n"
					+ "where Id = "+Id;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				int cost = resultSet.getInt(1);
				this.updateTotalCost(Id, "Rs."+(cost*newQuantity));
			}
		}
		catch(Exception e) {
			System.out.println("Error caught during Updation retrieval : "+e);
			System.out.println(query);
		}
	}
	
	//The below method is used to update the medicine Id.
	public void updateMedicineId(int Id,int newMedicineId) {
		String query = "update salesrecorddatabase\r\n"
				+ "set MedicineId = "+ newMedicineId +"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}
	
	//The below method is used to update the medicine Category Id.
	public void updateMedicineCategoryId(int Id,int newMedicineCategoryId) {
		String query = "update salesrecorddatabase\r\n"
				+ "set MedicineCategoryId = "+ newMedicineCategoryId +"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}
	
	//The below method is used to update the medicine Price.
	public void updateMedicinePrice(int Id,int newMedicinePrice) {
		//The below query is used to update the Medicine Price.
		String query = "update salesrecorddatabase\r\n"
				+ "set MedicinePrice = "+ newMedicinePrice +"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
		
		try {
			//The below query is used to fetch the quantity inorder to update the total cost in the data base.
			query = "select QuantityPurchased from salesrecorddatabase\r\n"
					+ "where Id = "+Id;
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				int quantity = resultSet.getInt(1);
				this.updateTotalCost(Id, "Rs."+(quantity*newMedicinePrice));
			}
		}
		catch(Exception e) {
			System.out.println("Error caught during Updation retrieval : "+e);
			System.out.println(query);
		}
	}
	
	//The below method is used to update the total cost
	public void updateTotalCost(int Id,String newTotalCost) {
		String query = "update salesrecorddatabase\r\n"
				+ "set TotalCost = \""+newTotalCost+"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}
	
	//The below method is used to update the purchase date.
	public void updatePurchaseDate(int Id,String newPurchaseDate) {
		String query = "update salesrecorddatabase\r\n"
				+ "set PurchasedDate = \""+ newPurchaseDate +"\"\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);	
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Update Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Updating : "+e);
			System.out.println(query);
		}
	}
}
