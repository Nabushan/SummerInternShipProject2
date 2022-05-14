package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases;

import java.sql.Statement;

import consoleApplicationMedicalStoreSystem.DomainLayer.Entity.SalesRecordEntity;
import consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces.DataBaseRequiredObjects;

public class SalesRecordClassRemovers implements DataBaseRequiredObjects{
	private SalesRecordEntity salesRecordEntityObject;
	private Statement statement;
	
	//The below method is used to set the Sales Record Entity Object.
	public void setSalesRecordEntity(SalesRecordEntity object) {
		salesRecordEntityObject = object;
	}
	
	//The below method is used to remove the Sales details based on Id.
	public void removeSalesRecordDetails(int Id) {
		String query = "delete from salesrecorddatabase\r\n"
				+ "where Id = "+Id;
		this.executePassedQuery(query);
	}
	
	//The below method is used to remove the Sales details based on Name and Number.
	public void removeSalesRecordDetails(String Name,String Number) {
		String query = "delete from salesrecorddatabase\r\n"
				+ "where CustomerName = \""+Name+"\" and CustomerNumber = \""+Number+"\";";
		this.executePassedQuery(query);
	}
	
	//The below method is used to remove the Sales details based on Name.
	public void removeSalesRecordDetails(String Name) {
		String query = "delete from salesrecorddatabase\r\n"
				+ "where CustomerName = \""+Name+"\";";
		this.executePassedQuery(query);	
	}
	
	//The below method is used to execute the passed query.
	public void executePassedQuery(String query) {
		try {
			statement = databaseObject.getStatement();
			statement.executeUpdate(query);
			System.out.println("Removal Successful.");
		}
		catch(Exception e) {
			System.out.println("Exception caught during removal : "+e);
			System.out.println(query);
		}
	}
}
