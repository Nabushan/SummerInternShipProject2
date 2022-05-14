package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases;

import java.sql.ResultSet;
import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.SalesRecordEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class SalesRecordClassGetters implements DataBaseRequiredObjects{
	private SalesRecordEntity salesRecordEntityObject;
	private Statement statement;
	private ResultSet resultSet;
	String query = null;
	
	//The below method is used to set the Sales Record Entity Object.
	public void setSalesRecordEntity(SalesRecordEntity object) {
		salesRecordEntityObject = object;
	}
	
	//The below method is used to get the Quantity Purchased.
	public int getQuantityPurchased(int Id) {
		try {
			query = "select * from salesrecorddatabase\r\n"
					+ "where Id = "+Id;
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				return resultSet.getInt(7);
			}
		}
		catch(Exception e) {
			System.out.println("Exception caught during Retrieval : "+e);
			System.out.println(query);
		}
		return -1;
	}
	
	//The below method is used to get the Medicine Price.
	public int getMedicinePrice(int Id) {
		try {
			query = "select * from salesrecorddatabase\r\n"
					+ "where Id = "+Id;
			statement = databaseObject.getStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				return resultSet.getInt(8);
			}
		}
		catch(Exception e) {
			System.out.println("Exception caught during Retrieval : "+e);
			System.out.println(query);
		}
		return -1;
	}
}
