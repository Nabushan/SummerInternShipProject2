package consoleApplicationMedicalStoreSystem.DomainLayer.Interface.SalesRecordClassInterface;

import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases.SalesRecordClassAdders;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases.SalesRecordClassDisplayers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases.SalesRecordClassGetters;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases.SalesRecordClassRemovers;
import consoleApplicationMedicalStoreSystem.DomainLayer.UseCases.SalesRecordEntityUseCases.SalesRecordClassUpdaters;

public interface SalesRecordClassRequiredObjects {
	static final SalesRecordClassAdders salesRecordClassAdders = new SalesRecordClassAdders();
	static final SalesRecordClassUpdaters salesRecordClassUpdaters = new SalesRecordClassUpdaters();
	static final SalesRecordClassDisplayers salesRecordClassDisplayers = new SalesRecordClassDisplayers();
	static final SalesRecordClassRemovers salesRecordClassRemovers = new SalesRecordClassRemovers();
	static final SalesRecordClassGetters salesRecordClassGetters = new SalesRecordClassGetters();
}
