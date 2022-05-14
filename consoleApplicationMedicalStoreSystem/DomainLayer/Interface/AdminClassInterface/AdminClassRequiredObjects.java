package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.AdminClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases.AdminClassCheckers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases.AdminClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases.AdminClassGetters;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases.AdminClassFeeders;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.AdminEntityUseCases.AdminClassUpdaters;

public interface AdminClassRequiredObjects {
	static final AdminClassFeeders adminClassFeeders = new AdminClassFeeders();
	static final AdminClassCheckers adminClassCheckers = new AdminClassCheckers();
	static final AdminClassUpdaters adminClassUpdaters = new AdminClassUpdaters();
	static final AdminClassGetters adminClassGetters = new AdminClassGetters();
	static final AdminClassDisplayers adminClassDisplayers =new AdminClassDisplayers();
}
