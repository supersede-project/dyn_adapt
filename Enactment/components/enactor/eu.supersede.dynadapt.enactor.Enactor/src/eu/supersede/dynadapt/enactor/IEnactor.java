package eu.supersede.dynadapt.enactor;

import org.eclipse.uml2.uml.Model;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;

public interface IEnactor {
	void enactAdaptedModel (Model adaptedModel, boolean demo) throws Exception;
	default void enactAdaptedModel (Model adaptedModel, Model originalModel, boolean demo) throws Exception{
		enactAdaptedModel(adaptedModel, demo);
	}
	default void enactFeatureConfiguration(FeatureConfiguration newFeatureConfig, boolean demo){
		throw new UnsupportedOperationException();
	}
}
