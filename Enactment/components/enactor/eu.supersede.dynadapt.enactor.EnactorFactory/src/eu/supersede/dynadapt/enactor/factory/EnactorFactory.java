package eu.supersede.dynadapt.enactor.factory;

import java.io.IOException;

import eu.supersede.dynadapt.enactor.HypervisorEnactor.HypervisorEnactor;
import eu.supersede.dynadapt.serviceCompositionEnactor.ServiceCompositionEnactor;
import eu.supersede.feedbackgathering.reconfiguration.enactor.FeedbackGatheringConfigurationProfile;
import eu.supersede.feedbackgathering.reconfiguration.enactor.FeedbackGatheringUpdateAttributes;
import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.monitor.reconfiguration.enactor.MonitoringEnactor;


public class EnactorFactory {
	public static IEnactor getEnactorForSystem(ModelSystem system) throws Exception{
		switch (system){
		case Atos:
		case Atos_HSK:
			return new HypervisorEnactor();
		case Siemens:
		case Siemens_Buildings:
		case Siemens_GetMinMaxDates:
		case Siemens_Types:
			return new ServiceCompositionEnactor();
		case SiemensMonitoring:
			return new MonitoringEnactor();
		case AtosMonitoringEnabling:
		case AtosMonitoringTimeSlot:
		case MonitoringReconfiguration:
			return new MonitoringEnactor();
		case AtosFG:
		case SiemensFG:
		case SenerconFG:
			return new FeedbackGatheringConfigurationProfile(system);
		case AtosFGcat:
		case SiemensFGcat:
		case SenerconFGcat:
			return new FeedbackGatheringUpdateAttributes(system);
		default:
			throw new UnsupportedOperationException();
		}
	}
}