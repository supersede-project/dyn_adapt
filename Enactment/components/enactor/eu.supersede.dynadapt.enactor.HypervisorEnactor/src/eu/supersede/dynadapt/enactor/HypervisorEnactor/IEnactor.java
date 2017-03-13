package eu.supersede.dynadapt.enactor.HypervisorEnactor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.uml2.uml.Model;

public interface IEnactor {
	List<Path> enactAdaptedModel (Model adaptedModel) throws IOException;
}
