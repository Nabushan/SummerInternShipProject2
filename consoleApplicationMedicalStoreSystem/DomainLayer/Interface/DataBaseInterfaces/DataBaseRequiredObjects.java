package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.DataBaseInterfaces;

import consoleApplicationMedicalStoreSystem.DataLayer.JDBC;

public interface DataBaseRequiredObjects {
	static final JDBC databaseObject = new JDBC();
}
