package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.MedicineClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases.MedicineClassAdders;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases.MedicineClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases.MedicineClassRemovers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.MedicineEntityUseCases.MedicineClassUpdaters;

public interface MedicineClassRequiredObjects {
	static final MedicineClassAdders medicineClassAdders = new MedicineClassAdders();
	static final MedicineClassUpdaters medicineClassUpdaters = new MedicineClassUpdaters();
	static final MedicineClassDisplayers medicineClassDisplayers = new MedicineClassDisplayers();
	static final MedicineClassRemovers medicineClassRemovers = new MedicineClassRemovers();
}
