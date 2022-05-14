package consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.DisplayBeautifyingClass;

import java.sql.Date;

public class StringFormatter {
	//The below method is used to get the formatted String.
	public String getString(String str,int len) {
		return String.format("%-"+len+"s",str);
	}
	
	//The below method is used to get the formatted String.
	public String getString(Date date,int len) {
		return String.format("%-"+len+"s",date.toString());
	}	
}
