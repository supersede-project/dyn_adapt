package main;

import org.eclipse.uml2.uml.Model;

public interface IEnactor {
	void enactAdaptedModel (Model adaptedModel) throws Exception;
	void enactAdaptedModel (Model adaptedModel, Model originalModel) throws Exception;
}
