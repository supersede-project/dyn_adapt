package eu.supersede.dynadapt.enactor;

import org.eclipse.uml2.uml.Model;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;

public interface IEnactor {
	default Model enactAdaptedModel (Model adaptedModel, boolean demo) throws Exception{
		throw new UnsupportedOperationException();
	}
	default Model enactAdaptedModel (Model adaptedModel, Model originalModel, boolean demo) throws Exception{
		return enactAdaptedModel(adaptedModel, demo);
	}
	default void enactFeatureConfiguration(FeatureConfiguration newFeatureConfig, boolean demo) throws Exception{
		throw new UnsupportedOperationException();
	}
}
