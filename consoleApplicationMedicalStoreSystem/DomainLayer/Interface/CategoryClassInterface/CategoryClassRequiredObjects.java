package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.CategoryClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases.CategoryClassAdders;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases.CategoryClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases.CategoryClassRemovers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.CategoryEntityUseCases.CategoryClassUpdaters;

public interface CategoryClassRequiredObjects {
	static final CategoryClassAdders categoryClassAdders = new CategoryClassAdders();
	static final CategoryClassUpdaters categoryClassUpdaters = new CategoryClassUpdaters();
	static final CategoryClassDisplayers categoryClassDisplayers = new CategoryClassDisplayers();
	static final CategoryClassRemovers categoryClassRemovers = new CategoryClassRemovers();
}
