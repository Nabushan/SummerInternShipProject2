package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.JoinDisplayClasses;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class JoinMedicineAndCategoryDisplayClass implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	private Statement statement;
	private ResultSet resultSet;
	
	//The below method is used to display all the Medicine and its related Category Details. 
	public void displayMedicineAndCategoryDetails() {
		String query = "select medicinedatabase.Id as id, \r\n"
				+ "medicinedatabase.MedicineName as medicineName,\r\n"
				+ "medicinedatabase.ProductionCompanyId as productionCompanyId,\r\n"
				+ "medicinedatabase.Dosage as medicineDosage,\r\n"
				+ "medicinedatabase.ExpiryDate as expiryDate,\r\n"
				+ "medicinedatabase.PricePerMedicine as pricePerMedicine,\r\n"
				+ "categorydatabase.CategoryName as categoryName,\r\n"
				+ "categorydatabase.UsedFor as usedFor,\r\n"
				+ "categorydatabase.AverageCost as averageCost\r\n"
				+ "from medicinedatabase\r\n"
				+ "inner join categorydatabase on medicinedatabase.MedicineCategoryId = categorydatabase.Id;";
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Medicine Name", 30)+" | "
					+stringFormatter.getString("Company Id", 10)+" | "
					+stringFormatter.getString("Dosage", 10)+" | "
					+stringFormatter.getString("Expiry Date", 11)+" | "
					+stringFormatter.getString("Price", 10)+" | "
					+stringFormatter.getString("Category Name",20)+" | "
					+stringFormatter.getString("Used For",50)+" | "
					+stringFormatter.getString("Average Cost",12)+" |");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 30)+" | "
						+stringFormatter.getString(resultSet.getInt(3)+"", 10)+" | "
						+stringFormatter.getString(resultSet.getString(4), 10)+" | "
						+stringFormatter.getString(resultSet.getDate(5), 11)+" | "
						+stringFormatter.getString(resultSet.getString(6), 10)+" | "
						+stringFormatter.getString(resultSet.getString(7), 20)+" | "
						+stringFormatter.getString(resultSet.getString(8), 50)+" | "
						+stringFormatter.getString(resultSet.getString(9), 12)+" |");
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
}
