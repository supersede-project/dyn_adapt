package eu.supersede.dynadapt.model.compare;

import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

public interface ModelCompare{
	Map<DiffType, Set<Element>> computeDifferencesBetweenModels(Model adaptedModel, Model originalModel);
}
