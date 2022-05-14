package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.JoinDisplayClasses;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StringFormatterClassInterface.StringFormatterObjectInterface;

public class JoinMedicineCategoryAndCompanyDisplayClass implements DataBaseRequiredObjects,StringFormatterObjectInterface{
	private Statement statement;
	private ResultSet resultSet;
	
	//The below method is used to display all the Medicine,Company and its related Category Details.
	public void displayMedicineCompanyAndCategoryDetails() {
		String query = "select medicinedatabase.Id as id, \r\n"
				+ "medicinedatabase.MedicineName as medicineName,\r\n"
				+ "medicinedatabase.Dosage as medicineDosage,\r\n"
				+ "medicinedatabase.ExpiryDate as expiryDate,\r\n"
				+ "medicinedatabase.PricePerMedicine as pricePerMedicine,\r\n"
				+ "categorydatabase.CategoryName as categoryName,\r\n"
				+ "categorydatabase.UsedFor as usedFor,\r\n"
				+ "categorydatabase.AverageCost as averageCost,\r\n"
				+ "companydatabase.CompanyName as companyName,\r\n"
				+ "companydatabase.Location as Location\r\n"
				+ "from medicinedatabase\r\n"
				+ "inner join categorydatabase on medicinedatabase.MedicineCategoryId = categorydatabase.Id\r\n"
				+ "inner join companydatabase on medicinedatabase.ProductionCompanyId = companydatabase.Id;";
		this.executePassedQuery(query);
	}
	
	//The below method is used to display the Medicine,Company and its related Category Details for a respective Id.
	public void displayMedicineCompanyAndCategoryDetails(int Id) {
		String query = "select medicinedatabase.Id as id, \r\n"
				+ "medicinedatabase.MedicineName as medicineName,\r\n"
				+ "medicinedatabase.Dosage as medicineDosage,\r\n"
				+ "medicinedatabase.ExpiryDate as expiryDate,\r\n"
				+ "medicinedatabase.PricePerMedicine as pricePerMedicine,\r\n"
				+ "categorydatabase.CategoryName as categoryName,\r\n"
				+ "categorydatabase.UsedFor as usedFor,\r\n"
				+ "categorydatabase.AverageCost as averageCost,\r\n"
				+ "companydatabase.CompanyName as companyName,\r\n"
				+ "companydatabase.Location as Location\r\n"
				+ "from medicinedatabase\r\n"
				+ "inner join categorydatabase on medicinedatabase.MedicineCategoryId = categorydatabase.Id\r\n"
				+ "inner join companydatabase on medicinedatabase.ProductionCompanyId = companydatabase.Id\r\n"
				+ "where medicinedatabase.Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("| "+stringFormatter.getString("Id", 3)+" | "
					+stringFormatter.getString("Medicine Name", 30)+" | "
					+stringFormatter.getString("Dosage", 10)+" | "
					+stringFormatter.getString("Expiry Date", 11)+" | "
					+stringFormatter.getString("Price", 10)+" | "
					+stringFormatter.getString("Category Name",20)+" | "
					+stringFormatter.getString("Used For",40)+" | "
					+stringFormatter.getString("Average Cost",12)+" | "
					+stringFormatter.getString("Company Name", 50)+" | "
					+stringFormatter.getString("Location", 20)+" |");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				System.out.println("| "+stringFormatter.getString(resultSet.getInt(1)+"", 3)+" | "
						+stringFormatter.getString(resultSet.getString(2), 30)+" | "
						+stringFormatter.getString(resultSet.getString(3), 10)+" | "
						+stringFormatter.getString(resultSet.getDate(4), 11)+" | "
						+stringFormatter.getString(resultSet.getString(5), 10)+" | "
						+stringFormatter.getString(resultSet.getString(6), 20)+" | "
						+stringFormatter.getString(resultSet.getString(7), 40)+" | "
						+stringFormatter.getString(resultSet.getString(8), 12)+" | "
						+stringFormatter.getString(resultSet.getString(9), 50)+" | "
						+stringFormatter.getString(resultSet.getString(10), 20)+" |");
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Display Successful.\n");
		}
		catch(Exception e) {
			System.out.println("Exception caught during Displaying : "+e);
			System.out.println(query);
		}
	}
}
