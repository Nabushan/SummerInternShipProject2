package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.SalesRecordEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class SalesRecordClassAdders implements DataBaseRequiredObjects{
	private SalesRecordEntity salesRecordEntityObject;
	private Statement statement;
	private ResultSet resultSet;
	
	//The below method is used to set the Sales Record Entity Object.
	public void setSalesRecordEntity(SalesRecordEntity object) {
		salesRecordEntityObject = object;
	}
	
	//The below method is used to pass the query to the Respective method.
	public void addSalesRecord() {
		String fetchQuery = "select MedicineCategoryId from medicinedatabase\r\n"
				+ "where Id = "+salesRecordEntityObject.getMedicineId();
		try {
			//this block is used to get the Medicine Category Id from the medicine DataBase
			statement = databaseObject.getStatement(); 
			resultSet = statement.executeQuery(fetchQuery);
			if(resultSet.next()) {
				salesRecordEntityObject.setMedicineCategory(resultSet.getInt(1));
			}
			
			//Used to fetch the price per medicine and calculate the total cost.
			fetchQuery = "select PricePerMedicine from medicinedatabase\r\n"
					+ "where Id = "+salesRecordEntityObject.getMedicineId();
			resultSet = statement.executeQuery(fetchQuery);
			if(resultSet.next()) {
				String temp = resultSet.getString(1);
				//System.out.println(temp);
				String str = temp.substring(3,temp.length());
				//System.out.println(str);
				int val = Integer.parseInt(str);
				salesRecordEntityObject.setMedicinePrice(val);
				int totalCost = val * salesRecordEntityObject.getQuantityPurchased();
				salesRecordEntityObject.setTotalCost("Rs."+totalCost);
			}
			
			//The below query is used to get the USer Id with the name and number provided during the entry.
			fetchQuery = "select Id from userdatebase\r\n"
					+ "where UserName = \""+salesRecordEntityObject.getIndividualName()+"\"\r\n"
					+ "and UserNumber = \""+salesRecordEntityObject.getIndividualMobileNumber()+"\"";
			resultSet = statement.executeQuery(fetchQuery);
			if(resultSet.next()) {
				int customerId = resultSet.getInt(1);
				salesRecordEntityObject.setIndividualId(customerId);
			}
		}
		catch(Exception e) {
			System.out.println("Exception caught during retireval of Category Id : "+e);
			System.out.println(fetchQuery);
		}
		
		//The below query is used to enter the value into the Sales Data base.
		String query = "insert into SalesRecordDataBase(CustomerId,PrescribedBy,MedicineId,MedicineCategoryId,\r\n"
				+ "QuantityPurchased,MedicinePrice,TotalCost,PurchasedDate)\r\n"
				+ "values("+salesRecordEntityObject.getIndividualId()+
				",\""+salesRecordEntityObject.getPrescribedBy()+"\","+
				salesRecordEntityObject.getMedicineId()+","+
				salesRecordEntityObject.getMedicineCategoryId()+","+
				salesRecordEntityObject.getQuantityPurchased()+","+
				salesRecordEntityObject.getMedicinePrice()+",\""+
				salesRecordEntityObject.getTotalCost()+"\",\""+
				salesRecordEntityObject.getPurchaseDate()+"\");";
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Addition Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Adding : "+e);
			System.out.println(query);
		}
	}
}
