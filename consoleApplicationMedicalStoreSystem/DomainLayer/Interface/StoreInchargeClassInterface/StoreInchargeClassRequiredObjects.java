package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.StoreInchargeClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.StoreInchargeUseCases.StoreInchargeClassAdders;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.StoreInchargeUseCases.StoreInchargeClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.StoreInchargeUseCases.StoreInchargeClassUpdaters;

public interface StoreInchargeClassRequiredObjects {
	static final StoreInchargeClassAdders storeInchargeClassAdders = new StoreInchargeClassAdders();
	static final StoreInchargeClassUpdaters storeInchargeClassUpdaters = new StoreInchargeClassUpdaters();
	static final StoreInchargeClassDisplayers storeInchargeClassDisplayers = new StoreInchargeClassDisplayers();
}
