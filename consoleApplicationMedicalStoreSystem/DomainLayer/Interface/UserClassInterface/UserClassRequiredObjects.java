package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.UserClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClassAdders;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClassRemovers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.UserEntityUseCases.UserClassUpdaters;

public interface UserClassRequiredObjects {
	static final UserClassAdders userClassAdders = new UserClassAdders();
	static final UserClassUpdaters userClassUpdaters = new UserClassUpdaters();
	static final UserClassDisplayers userClassDisplayers = new UserClassDisplayers();
	static final UserClassRemovers userClassRemovers = new UserClassRemovers();
}
