package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CompanyClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases.CategoryClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases.CompanyClassDisplayers;

public interface OtherClassRequiredCompanyDisplayers {
	static final CompanyClassDisplayers companyClassDisplayers = new CompanyClassDisplayers();
}
