package eu.supersede.dynadapt.enactor.factory;

import java.io.IOException;

import eu.supersede.dynadapt.enactor.HypervisorEnactor.HypervisorEnactor;
import eu.supersede.dynadapt.enactor.IEnactor;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class EnactorFactory {
	public static IEnactor getEnactorForSystem(ModelSystem system) throws IOException{
		switch (system){
		case Atos:
		case Atos_HSK:
			return new HypervisorEnactor();
		case Siemens:
			//Ask Srdjan to provide Siemens Enactor
			throw new UnsupportedOperationException();
		case MonitoringReconfiguration:
			//Ask Edith to provide Siemens Enactor
			throw new UnsupportedOperationException();
		case FeedbackGatheringReconfiguration:
			//Ask Denisse to provide Siemens Enactor
			throw new UnsupportedOperationException();
		default:
			throw new UnsupportedOperationException();
		}
	}
}