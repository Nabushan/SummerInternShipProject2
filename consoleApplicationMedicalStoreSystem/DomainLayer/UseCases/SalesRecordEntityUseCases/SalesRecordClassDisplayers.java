package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.SalesRecordEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class SalesRecordClassDisplayers implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	private SalesRecordEntity salesRecordEntityObject;
	private Statement statement;
	private ResultSet resultSet;
	
	//The below method is used to set the Sales Record Entity Object.
	public void setSalesRecordEntity(SalesRecordEntity object) {
		salesRecordEntityObject = object;
	}
	
	//The below method passes the query to the respective function.
	public void displayAllSalesRecordDetails() {
		String query = "select salesrecorddatabase.Id as id,\r\n"
				+ "userdatebase.UserName as userName,\r\n"
				+ "userdatebase.UserNumber as userNumber,\r\n"
				+ "salesrecorddatabase.PrescribedBy as prescribedBy,\r\n"
				+ "salesrecorddatabase.MedicineId as medicineId,\r\n"
				+ "salesrecorddatabase.MedicineCategoryId as medicineCategoryId,\r\n"
				+ "salesrecorddatabase.QuantityPurchased as quantityPurchased,\r\n"
				+ "salesrecorddatabase.MedicinePrice as medicinePrice,\r\n"
				+ "salesrecorddatabase.TotalCost as totalCost,\r\n"
				+ "salesrecorddatabase.PurchasedDate as purchaseDate\r\n"
				+ "from salesrecorddatabase\r\n"
				+ "inner join userdatebase on salesrecorddatabase.CustomerId = userdatebase.Id;";
		this.executePassedQuery(query);	
	}
	
	//The below method passes the query to the respective function.
	public void displaySalesRecordDetails(int Id) {
		String query = "select salesrecorddatabase.Id as id,\r\n"
				+ "userdatebase.UserName as userName,\r\n"
				+ "userdatebase.UserNumber as userNumber,\r\n"
				+ "salesrecorddatabase.PrescribedBy as prescribedBy,\r\n"
				+ "salesrecorddatabase.MedicineId as medicineId,\r\n"
				+ "salesrecorddatabase.MedicineCategoryId as medicineCategoryId,\r\n"
				+ "salesrecorddatabase.QuantityPurchased as quantityPurchased,\r\n"
				+ "salesrecorddatabase.MedicinePrice as medicinePrice,\r\n"
				+ "salesrecorddatabase.TotalCost as totalCost,\r\n"
				+ "salesrecorddatabase.PurchasedDate as purchaseDate\r\n"
				+ "from salesrecorddatabase\r\n"
				+ "inner join userdatebase on salesrecorddatabase.CustomerId = userdatebase.Id\r\n"
				+ "where salesrecorddatabase.Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method passes the query to the respective function.
	public void displaySalesRecordDetails(String Name,String Number) {
		String query = "select salesrecorddatabase.Id as id,\r\n"
				+ "userdatebase.UserName as userName,\r\n"
				+ "userdatebase.UserNumber as userNumber,\r\n"
				+ "salesrecorddatabase.PrescribedBy as prescribedBy,\r\n"
				+ "salesrecorddatabase.MedicineId as medicineId,\r\n"
				+ "salesrecorddatabase.MedicineCategoryId as medicineCategoryId,\r\n"
				+ "salesrecorddatabase.QuantityPurchased as quantityPurchased,\r\n"
				+ "salesrecorddatabase.MedicinePrice as medicinePrice,\r\n"
				+ "salesrecorddatabase.TotalCost as totalCost,\r\n"
				+ "salesrecorddatabase.PurchasedDate as purchaseDate\r\n"
				+ "from salesrecorddatabase\r\n"
				+ "inner join userdatebase on salesrecorddatabase.CustomerId = userdatebase.Id\r\n"
				+ "where userName = \""+Name+"\" and userNumber = \""+Number+"\";";
		this.executePassedQuery(query);
	}
	
	//The below method passes the query to the respective function.
	public void displaySalesRecordDetails(String Name) {
		String query = "select salesrecorddatabase.Id as id,\r\n"
				+ "userdatebase.UserName as userName,\r\n"
				+ "userdatebase.UserNumber as userNumber,\r\n"
				+ "salesrecorddatabase.PrescribedBy as prescribedBy,\r\n"
				+ "salesrecorddatabase.MedicineId as medicineId,\r\n"
				+ "salesrecorddatabase.MedicineCategoryId as medicineCategoryId,\r\n"
				+ "salesrecorddatabase.QuantityPurchased as quantityPurchased,\r\n"
				+ "salesrecorddatabase.MedicinePrice as medicinePrice,\r\n"
				+ "salesrecorddatabase.TotalCost as totalCost,\r\n"
				+ "salesrecorddatabase.PurchasedDate as purchaseDate\r\n"
				+ "from salesrecorddatabase\r\n"
				+ "inner join userdatebase on salesrecorddatabase.CustomerId = userdatebase.Id\r\n"
				+ "where userName = \""+Name+"\";";
		this.executePassedQuery(query);	
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Customer Name", 30)+" | "
					+stringFormatter.getString("Contact Number", 14)+" | "
					+stringFormatter.getString("Prescribed By", 30)+" | "
					+stringFormatter.getString("Medicine Id", 11)+" | "
					+stringFormatter.getString("Category Id", 11)+" | "
					+stringFormatter.getString("Quantity", 8)+" | "
					+stringFormatter.getString("Medicine Price", 14)+" | "
					+stringFormatter.getString("Total Cost", 10)+" | "
					+stringFormatter.getString("Puschased Date", 14)+" |");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 30)+" | "
						+stringFormatter.getString(resultSet.getString(3), 14)+" | "
						+stringFormatter.getString(resultSet.getString(4), 30)+" | "
						+stringFormatter.getString(resultSet.getInt(5)+"", 11)+" | "
						+stringFormatter.getString(resultSet.getInt(6)+"", 11)+" | "
						+stringFormatter.getString(resultSet.getInt(7)+"", 8)+" | "
						+stringFormatter.getString(resultSet.getInt(8)+"", 14)+" | "
						+stringFormatter.getString(resultSet.getString(9), 10)+" | "
						+stringFormatter.getString(resultSet.getString(10), 14)+" |");
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Dispaly Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during displaying : "+e);
			System.out.println(query);
		}
	}
}
