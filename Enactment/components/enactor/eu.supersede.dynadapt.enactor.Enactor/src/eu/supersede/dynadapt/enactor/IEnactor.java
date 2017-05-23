package eu.supersede.dynadapt.enactor;

import org.eclipse.uml2.uml.Model;

public interface IEnactor {
	void enactAdaptedModel (Model adaptedModel, boolean demo) throws Exception;
	void enactAdaptedModel (Model adaptedModel, Model originalModel, boolean demo) throws Exception;
}
