/**
 *
 * @author edithzavala
 */

package eu.supersede.dynadapt.modelrepository.repositoryaccess;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import eu.supersede.dynadapt.aom.dsl.parser.AdaptationParser;
import eu.supersede.dynadapt.aom.dsl.parser.IAdaptationParser;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public class ModelRepository {

	private String repository;

	public ModelRepository(String repository) {
		super();
		this.repository = repository;
	}

	/**
	 * This method returns a list of aspect models linked to an specific
	 * featureSUPERSEDE given the featureSUPERSEDE id and the models' location
	 * required for loading the aspects
	 * 
	 * @param featureSUPERSEDEId,
	 *            modelsLocation
	 */
	public List<Aspect> getAspectModels(String featureSUPERSEDEId, Map<String, String> modelsLocation) {
		List<Aspect> aspects = new ArrayList<Aspect>();

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"));

		IAdaptationParser ap = loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
				Aspect a = getAspectModel(ap, repository + modelsLocation.get("aspects") + aspectsFiles[i].getName());
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					aspects.add(a);
				}
			}
		}
		return aspects;
	}
	
	/**
	 * This method returns a list of aspect models URIs linked to an specific
	 * featureSUPERSEDE given the featureSUPERSEDE id and the models' location
	 * required for loading the aspects
	 * 
	 * The URIs returned are of the form: platform:/resource/eclipse_project/aspect.aspect
	 * 
	 * @param featureSUPERSEDEId,
	 *            modelsLocation
	 */

	public List<URI> getAspectModelsURIs(String featureSUPERSEDEId, Map<String, String> modelsLocation) {
		List<URI> uris = new ArrayList<URI>();

		File[] aspectsFiles = getFiles(modelsLocation.get("aspects"));

		IAdaptationParser ap = loadModels(modelsLocation);

		if (aspectsFiles != null) {
			for (int i = 0; i < aspectsFiles.length; i++) {
				String aspectModelPath = repository + modelsLocation.get("aspects") + aspectsFiles[i].getName();
				Aspect a = getAspectModel(ap, aspectModelPath);
				if (a.getFeature().getId().equalsIgnoreCase(featureSUPERSEDEId)) {
					uris.add(URI.createURI(aspectModelPath));
				}
			}
		}
		return uris;
	}

	private IAdaptationParser loadModels(Map<String, String> modelsLocation) {
		IAdaptationParser parser = new AdaptationParser();

		File[] variants = getFiles(modelsLocation.get("variants"));
		for (int i = 0; i < variants.length; i++) {
			parser.loadUMLResource(URI.createURI(repository + modelsLocation.get("variants") + variants[i].getName()));
		}

		File[] profiles = getFiles(modelsLocation.get("profiles"));
		for (int i = 0; i < profiles.length; i++) {
			parser.loadProfileResource(
					URI.createURI(repository + modelsLocation.get("profiles") + profiles[i].getName()));
		}

		File[] patterns = getFiles(modelsLocation.get("patterns"));
		for (int i = 0; i < patterns.length; i++) {
			parser.loadPatternResource(
					URI.createURI(repository + modelsLocation.get("patterns") + patterns[i].getName()));
		}

		File[] features = getFiles(modelsLocation.get("features"));
		for (int i = 0; i < features.length; i++) {
			parser.loadFeatureResource(
					URI.createURI(repository + modelsLocation.get("features") + features[i].getName()));
		}

		return parser;
	}
	
	private Aspect getAspectModel(IAdaptationParser parser, String aspectModelPath) {
		URI aspectModelURI = URI.createURI(aspectModelPath);

		Aspect adaptation = parser.parseAdaptationModel(aspectModelURI);

		return adaptation;
	}
	
	private File[] getFiles(String folderPath) {
		/*
		 * Models in class path
		 */
		URL url = getClass().getResource("/" + folderPath);
		File[] files = null;
		File folder = null;

		try {
			folder = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return files = folder.listFiles();
	}
}
