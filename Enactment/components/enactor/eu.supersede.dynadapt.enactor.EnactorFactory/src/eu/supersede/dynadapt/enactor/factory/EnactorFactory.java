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
	public static IEnactor getEnactorForSystem(ModelSystem system) throws IOException{
		switch (system){
		case Atos:
		case Atos_HSK:
			return new HypervisorEnactor();
		case Siemens:
			return new ServiceCompositionEnactor();
		case SiemensMonitoring:
			return new MonitoringEnactor();
		case AtosMonitoring:
			return new MonitoringEnactor();
		case MonitoringReconfiguration:
			return new MonitoringEnactor();
		case AtosFG:
		case SiemensFG:
		case SenerconFG:
			return new FeedbackGatheringConfigurationProfile();
		case AtosFGcat:
		case SiemensFGcat:
		case SenerconFGcat:
			return new FeedbackGatheringUpdateAttributes();
		default:
			throw new UnsupportedOperationException();
		}
	}
}