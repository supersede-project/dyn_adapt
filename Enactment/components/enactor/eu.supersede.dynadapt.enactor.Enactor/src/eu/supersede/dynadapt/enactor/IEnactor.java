package eu.supersede.dynadapt.enactor;

import org.eclipse.uml2.uml.Model;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;

public interface IEnactor {
	void enactAdaptedModel (Model adaptedModel, boolean demo) throws Exception;
	void enactAdaptedModel (Model adaptedModel, Model originalModel, boolean demo) throws Exception;
	void enactFeatureConfiguration(FeatureConfiguration newFeatureConfig, boolean demo);
}
