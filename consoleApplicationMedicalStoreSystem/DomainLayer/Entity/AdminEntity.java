package consoleApplicationMedicalStoreSystem.DomainLayer.Entity;

public class AdminEntity {
	private String adminName;
	private String password;
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "AdminEntity [adminName = " + adminName + "\n"
				+ "password = " + password + "]";
	}	
}
