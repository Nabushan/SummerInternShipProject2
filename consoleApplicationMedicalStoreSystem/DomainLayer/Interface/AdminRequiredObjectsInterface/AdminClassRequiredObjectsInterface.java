package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminRequiredObjectsInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases.CategoryClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases.CompanyClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.JoinDisplayClasses.JoinCompanyAndCategoryDisplayClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.JoinDisplayClasses.JoinMedicineCategoryAndCompanyDisplayClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases.MedicineClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases.SalesRecordClass;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClass;

public interface AdminClassRequiredObjectsInterface {
	static final MedicineClass medicineClassObject = new MedicineClass();
	static final CompanyClass companyClassObject = new CompanyClass();
	static final CategoryClass categoryClassObject = new CategoryClass();
	static final SalesRecordClass salesRecordClassObject = new SalesRecordClass();
	static final JoinMedicineCategoryAndCompanyDisplayClass joinMedicineCategoryAndCompanyDisplayClass = new JoinMedicineCategoryAndCompanyDisplayClass();
	static final JoinCompanyAndCategoryDisplayClass joinCompanyAndCategoryDisplayClass = new JoinCompanyAndCategoryDisplayClass();
}
