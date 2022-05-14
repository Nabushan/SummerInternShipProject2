package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CompanyClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases.CompanyClassAdders;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases.CompanyClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases.CompanyClassRemovers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CompanyEntityUseCases.CompanyClassUpdaters;

public interface CompanyClassRequiredObjects {
	static final CompanyClassAdders companyClassAdders = new CompanyClassAdders();
	static final CompanyClassUpdaters companyClassUpdaters = new CompanyClassUpdaters();
	static final CompanyClassDisplayers companyClassDisplayers = new CompanyClassDisplayers();
	static final CompanyClassRemovers companyClassRemovers = new CompanyClassRemovers();
}
