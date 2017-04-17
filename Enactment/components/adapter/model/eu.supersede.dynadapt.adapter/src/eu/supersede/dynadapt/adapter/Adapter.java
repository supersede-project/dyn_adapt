/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC), ATOS Spain S.A
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Quim Motger (UPC) - main development
 *  Yosu Gorroñogoitia (Atos)
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.adapter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.junit.Assert;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import eu.supersede.dynadapt.modeladapter.ModelAdapter;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.kpi.AdapterKPIComputer;
import eu.supersede.dynadapt.adapter.system.ModelRepositoryMapping;
import eu.supersede.dynadapt.adapter.system.ModelRepositoryResolver;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceTimestamp;
import eu.supersede.dynadapt.adapter.system.RepositoryMetadata.ResourceType;
import eu.supersede.dynadapt.dsl.aspect.ActionOptionType;
import eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl;
import eu.supersede.dynadapt.enactor.factory.EnactorFactory;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.Composition;
import eu.supersede.dynadapt.dsl.aspect.Pointcut;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;

public class Adapter implements IAdapter {
	private final static Logger log = LogManager.getLogger(Adapter.class);

	private ModelRepository mr;
	private ModelManager mm;
	private ModelQuery mq;
	private ModelAdapter ma;
	private ModelRepositoryResolver mrr;

	private Map<String, String> modelsLocation;
	
	private AdapterKPIComputer kpiComputer = new AdapterKPIComputer();

	// FIXME: Currently two ResourceSets are managed, one by ModelManager,
	// another one by AdaptationParser
	// FIXME: Manage a single ResourceSet

	public Adapter(ModelRepository mr, ModelManager mm, Map<String, String> modelsLocation, String repositoryRelativePath) throws Exception {
		this.mr = mr;
		this.ma = new ModelAdapter(mm);
		this.mm = mm;
		this.mq = new ModelQuery(mm);
		this.modelsLocation = modelsLocation;
		this.mrr = new ModelRepositoryResolver(mm, repositoryRelativePath);
		log.debug("Adapter set up");
	}

//	public Model adapt(FeatureModel variability, FeatureConfiguration featureConfig, Aspect adaptationModel,
//			Model baseModel) throws Exception {
//
//		List<Feature> features = new ArrayList<>();
//		features.add(adaptationModel.getFeature());
//		Model model = null;
//
//		for (Feature f : features) {
//
//			List<String> enabledFeatureIds = new ArrayList<>();
//			for (Selection selection : featureConfig.getSelectionsById(f.getId())) {
//				if (selection.isEnabled())
//					enabledFeatureIds.add(selection.getFeature().getId());
//			}
//
//			log.debug("Feature ID: " + f.getId());
//			List<Aspect> aspects = mr.getAspectModels(f.getId(), modelsLocation);
//			log.debug("Found " + aspects.size() + " adaptations for feature: " + f.getId());
//			for (Aspect a : aspects) {
//				log.debug("\tAspect name: " + a.getName());
//				Stereotype role = null;
//				List<Pointcut> pointcuts = a.getPointcuts();
//
//				HashMap<Stereotype, List<Element>> elements = new HashMap<>();
//
//				for (Pointcut p : pointcuts) {
//					role = p.getRole();
//					elements.put(role, new ArrayList<>());
//					log.debug("		Role: " + role.getName());
//					Collection<? extends IPatternMatch> matches = mq.query(p.getPattern());
//					for (IPatternMatch i : matches) {
//						Element e = (Element) i.get(0);
//						log.debug("\t\tElement: " + e);
//						elements.get(role).add(e);
//					}
//				}
//				Model variant = a.getAdvice();
//				for (Composition c : a.getCompositions()) {
//					boolean enabled = c.getFeature_enabled();
//					if (enabled && enabledFeatureIds.contains(f.getId())
//							|| !enabled && !enabledFeatureIds.contains(f.getId())) {
//						ActionOptionType actionOptionType = c.getAction();
//						if (actionOptionType instanceof UpdateValueImpl) {
//							String value = actionOptionType
//									.eGet(actionOptionType.eClass().getEStructuralFeature("value")).toString();
//							model = ma.applyUpdateCompositionDirective(baseModel, elements, value);
//						} else {
//							model = ma.applyCompositionDirective(a.getCompositions().get(0).getAction(), baseModel,
//									elements, c.getAdvice(), variant);
//						}
//					}
//				}
//			}
//		}
//
//		return model;
//
//	}

	@Override
	public void enactAdaptationDecisionAction(ModelSystem system, String adaptationDecisionActionId,
			String featureConfigurationId) throws EnactmentException {
		List<String> adaptationDecisionActionIds = new ArrayList<>();
		adaptationDecisionActionIds.add (adaptationDecisionActionId);
		enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
	}

	@Override
	public void enactAdaptationDecisionActions(ModelSystem system, List<String> adaptationDecisionActionIds,
			String featureConfigurationId) throws EnactmentException {
		try {

			kpiComputer.startComputingKPI();
			
			//FIXME Before FCs computed by DM are stored in the model repository and FC is retrieved by id
			//We use FC id as name of latest computed one, to override default, located in standard local repository
			RepositoryMetadata metadata = new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.NEWEST);
			ModelRepositoryMapping.setModelURI(system, metadata, "/features/configurations/" + featureConfigurationId + ".yafc");
			log.debug("Using as latest computed FC: " + "/features/configurations/" + featureConfigurationId + ".yafc");
			
			FeatureConfiguration newFeatureConfig = mrr.getConfigurationForSystem(system,
					new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.NEWEST));
			
			doEnactment(system, adaptationDecisionActionIds, newFeatureConfig);
			
			kpiComputer.stopComputingKPI();
			kpiComputer.reportComputedKPI();

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnactmentException(e);
		}
	}
	
	@Override
	public void enactAdaptationDecisionActionsInFCasString(ModelSystem system, List<String> adaptationDecisionActionIds,
			String featureConfigurationAsString) throws EnactmentException {
		try {

			kpiComputer.startComputingKPI();
			
			//FIXME Read feature configuration from string
			FeatureConfiguration newFeatureConfig = mr.readModelFromString(featureConfigurationAsString, ModelType.FeatureConfiguration, FeatureConfiguration.class);
			Assert.assertNotNull("Passed feature configuration could not be loaded", newFeatureConfig);
			
			doEnactment(system, adaptationDecisionActionIds, newFeatureConfig);
			
			kpiComputer.stopComputingKPI();
			kpiComputer.reportComputedKPI();

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnactmentException(e);
		}
	}

	private void doEnactment(ModelSystem system, List<String> adaptationDecisionActionIds,
			FeatureConfiguration newFeatureConfig) throws EnactmentException, Exception, IOException {
		
		// TODO Get BaseModel, original feature configuration and new
		// feature configuration (by id) from Model Repository
		// FIXME Provisional: using ModelRepositoryResolver (ModelManager)
		// to simulate their retrieval given a systemId

		//FIXME Base model was already loaded by Model Manager during initialization
		//In order to avoid loading it twice, get it from Model Manager
//			Model baseModel = mrr.getModelForSystem(system,
//					new RepositoryMetadata(ResourceType.BASE, ResourceTimestamp.CURRENT));
		Model baseModel = mrr.getModelForSystem(system,
				new RepositoryMetadata(ResourceType.BASE, ResourceTimestamp.CURRENT));
		mm.setTargetModel(baseModel);

		//FIXME featureConfigurationId not used to retrieve the feature configuration
		//This implementation gets the latest configuration
		//URI fcUri = URI.createURI (featureConfigurationId);
		
		FeatureConfiguration originalFeatureConfig = mrr.getConfigurationForSystem(system,
				new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.CURRENT));
		
		//FIXME Next invocation gets FC by id (this one should be used once Model Repository is available
//			newFeatureConfig = mrr.getConfigurationForSystem(system,
//					new RepositoryMetadata(fcUri));

		//Only leaf selections are included
		List<Selection> changedSelections = diffFeatureConfigurations(originalFeatureConfig, newFeatureConfig);

		if (adaptationDecisionActionIds!=null && !adaptationDecisionActionIds.isEmpty()){
			// Filter out changedSelections not included in adaptationDecisionActionIds
			List<Selection> droppedSelections = new ArrayList<>();
			for (Selection s: changedSelections){
				if (!adaptationDecisionActionIds.contains(s.getId())){
					log.debug("Selection " + s.getId() + " not required for enactment. Dropped from list of changed selections");
					droppedSelections.add (s);
				}
			}
			changedSelections.removeAll(droppedSelections);
		}

		Model model = adapt(changedSelections, baseModel);

		if (model != null){
			URI uri = mm.saveModelInTemporaryFolder(model, "_" + UUID.randomUUID() + ".uml");
			//URI uri = URI.createFileURI("repository/models/adapted/" + model.getName() + ".uml");
			//mm.saveModel(model.eResource(), uri, ".uml");
			log.debug("Saved updated model in " + uri);
		}
		
		//Ask Enactor to enact adapted model
		log.debug("Invoking enactor for system " + system);
		EnactorFactory.getEnactorForSystem(system).enactAdaptedModel(model, baseModel);
		
		//TODO Store adapted model as current base model in Model Repository
		log.debug("Storing adapted model as current based model in ModelRepository");
		//mr.storeBaseModel(model, bmMetadata);
		
		//TODO Store new feature configuration model as current current feature configuration in Model Repository
		log.debug("Storing FC model as current FC model in ModelRepository");
		//mr.storeFeatureConfigurationModel(newFeatureConfig, fcMetadata);
		
		//TODO Notified back to DM that adaptation actions have been enacted
		log.debug("Notifing back to DM that adaptation actions have been enacted");
	}
	
	@Override
	public void enactAdaptationDecisionActionsForFC(ModelSystem system, 
			String featureConfigurationId) throws EnactmentException {
		
		try {
			
			kpiComputer.startComputingKPI();
		
			Model baseModel = mm.getTargetModel();
			
			FeatureConfiguration featureConfig = mrr.getConfigurationForSystem(system,
					new RepositoryMetadata(ResourceType.FEATURE_CONFIGURATION, ResourceTimestamp.CURRENT));
			
			List<Selection> changedSelections = getSelections(featureConfig);
	
			Model model = adapt(changedSelections, baseModel);
	
			if (model != null){
				//URI uri = mm.saveModelInTemporaryFolder(model, "_" + UUID.randomUUID() + ".uml");
				//log.debug("Saved updated model in " + uri);
				URI uri = URI.createFileURI("repository/models/adapted/" + model.getName() + ".uml");
				mm.saveModel(model.eResource(), uri, ".uml");
				log.debug("Saved updated model in " + uri);
			}
			
			//Ask Enactor to enact adapted model
			EnactorFactory.getEnactorForSystem(system).enactAdaptedModel(model, baseModel);
			
			//TODO Store adapted model as current base model in Model Repository
			log.debug("Storing adapted model as current based model in ModelRepository");
			//mr.storeBaseModel(model, bmMetadata);
			
			//TODO Store new feature configuration model as current current feature configuration in Model Repository
			log.debug("Storing FC model as current FC model in ModelRepository");
			//mr.storeFeatureConfigurationModel(newFeatureConfig, fcMetadata);
			
			//TODO Notified back to DM that adaptation actions have been enacted
			log.debug("Notifing back to DM that adaptation actions have been enacted");
			
			kpiComputer.stopComputingKPI();
			kpiComputer.reportComputedKPI();

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnactmentException(e);
		}
		
	};

	private Model adapt(List<Selection> selections, Model baseModel) throws Exception {

		Model model = null;
		//Clone base model
		Model clonnedModel = (Model) EcoreUtil.copy( baseModel );
		//Create a model manager targeting cloned model
		ModelManager clonedModelManager = new ModelManager(clonnedModel, mm.getTargetModelAsResource().getURI());
		//Create modelQuery targeting cloned Model
		this.mq = new ModelQuery(clonedModelManager);

		for (Selection selection : selections) {
			Feature feature = selection.getFeature();
			boolean featureEnabled = selection.isEnabled();

			log.debug("Feature <" + feature.getId() + ">" + (featureEnabled ? " Enabled" : " Disabled"));
			List<Aspect> aspects = mr.getAspectModels(feature.getId(), modelsLocation);
			log.debug("Found " + aspects.size() + " adaptations for feature: " + feature.getId());

			for (Aspect aspect : aspects) {
				log.debug("\tAspect name: " + aspect.getName());
				Stereotype role = null;
				List<Pointcut> pointcuts = aspect.getPointcuts();

				HashMap<Stereotype, List<Element>> matchingElements = new HashMap<>();

				for (Pointcut p : pointcuts) {
					role = p.getRole();
					matchingElements.put(role, new ArrayList<>());
					log.debug("\tRole: " + role.getName());
					//FIXME matching elements (elements stereotyped with jointpoint must be found in cloned model, not in baseModel
					Collection<? extends IPatternMatch> matches = mq.query(p.getPattern());
					for (IPatternMatch i : matches) {
						Element e = (Element) i.get(0);
						log.debug("\tMatching Element: " + e);
						matchingElements.get(role).add(e);
					}
				}
				Model variant = aspect.getAdvice();

				for (Composition c : aspect.getCompositions()) {
					boolean compositionEnabled = c.getFeature_enabled();
					if (featureEnabled == compositionEnabled) {
						ActionOptionType actionOptionType = c.getAction();
						if (actionOptionType instanceof UpdateValueImpl) {
							String value = actionOptionType
									.eGet(actionOptionType.eClass().getEStructuralFeature("value")).toString();
							model = ma.applyUpdateCompositionDirective(clonnedModel, matchingElements, value);
						} else {
							model = ma.applyCompositionDirective(c.getAction(), clonnedModel, matchingElements,
									c.getAdvice(), variant);
						}
					}
				}
			}
		}

		return model;

	}

	//Calculate leaf selection changes among provided feature configurations
	private List<Selection> diffFeatureConfigurations(FeatureConfiguration originalFeatureConfig,
			FeatureConfiguration newFeatureConfig) {
		FeatureModel fm = originalFeatureConfig.getFeatureModelCopy();
		Feature root = fm.getRoot();

		return diffFeatureConfigurationsInFeature(root, originalFeatureConfig, newFeatureConfig);
	}
	
	private List<Selection> diffFeatureConfigurationsInFeature(Feature feature,
			FeatureConfiguration originalFeatureConfig, FeatureConfiguration newFeatureConfig) {
		
		List<Selection> selections = new ArrayList<Selection>();
		
		//Only computes differences for leaf features
		if (isLeafFeature(feature)){
			selections = diffFeatureConfigurationsInFeature(feature.getId(), originalFeatureConfig,
				newFeatureConfig);
		}

		for (Feature child : feature.getFeatures()) {
			selections.addAll(diffFeatureConfigurationsInFeature(child, originalFeatureConfig, newFeatureConfig));
		}

		for (Group group : feature.getGroups()) {
			for (Feature childInGroup : group.getFeatures()) {
				selections.addAll(
						diffFeatureConfigurationsInFeature(childInGroup, originalFeatureConfig, newFeatureConfig));
			}
		}
		return selections;
	}

	private boolean isLeafFeature(Feature feature) {
		return feature.getFeatures().isEmpty() && feature.getGroups().isEmpty();
	}

	private List<Selection> diffFeatureConfigurationsInFeature(String featureId,
			FeatureConfiguration originalFeatureConfig, FeatureConfiguration newFeatureConfig) {
		List<Selection> selections = new ArrayList<Selection>();

		List<Selection> originalSelections = originalFeatureConfig.getSelectionsById(featureId);
		List<Selection> newSelections = newFeatureConfig.getSelectionsById(featureId);

		for (Selection s1 : originalSelections) {
			if (!selectionExistsInList(s1, newSelections)) {
				s1.setEnabled(false);
				selections.add(s1);
			}
		}

		for (Selection s1 : newSelections) {
			if (!selectionExistsInList(s1, originalSelections)) {
				selections.add(s1);
			}
		}
		
		/**
		 * Monitoring UC testing
		 */
		for (Selection s1 : originalSelections) {
			if (selectionIsModified(s1, newSelections)) {
				selections.add(s1);
			}
		}

		return selections;
	}

	private List<Selection> getSelections(FeatureConfiguration featureConfig) {
		FeatureModel fm = featureConfig.getFeatureModelCopy();
		Feature root = fm.getRoot();

		return selectionsInFeature(root, featureConfig);
	}

//	private List<Feature> listFeatures(Feature root, String featureId) {
//		List<Feature> features = new ArrayList<>();
//		log.debug(root.getId());
//		if (root.getId().equals(featureId))
//			features.add(root);
//		if (root.getFeatures().size() > 0)
//			for (Feature f : root.getFeatures())
//				features.addAll(listFeatures(f, featureId));
//		return features;
//	}

	private boolean selectionExistsInList(Selection s1, List<Selection> list) {
		boolean result = false;

		for (Selection s : list) {
			if (s.getId().equals(s1.getId())) {
				result = true;
				break;
			}
		}

		return result;
	}
	
	private boolean selectionIsModified(Selection s1, List<Selection> list) {
		boolean result = false;
		
		for (Selection s : list) {
			if (s.getId().equals(s1.getId()) && s.getValues().size() > 0) {
				if ( !s.getValues().get(0).eGet(s.getValues().get(0).eClass().getEStructuralFeature("value"))
						.equals( s1.getValues().get(0).eGet(s.getValues().get(0).eClass().getEStructuralFeature("value")))) result = true;
				break;
			}
		}
		
		return result;
	}

	private List<Selection> selectionsInFeature(Feature feature,
			FeatureConfiguration featureConfig) {
		List<Selection> selections = new ArrayList<>();
		selections.addAll(featureConfig.getSelectionsById(feature.getId()));

		for (Feature child : feature.getFeatures()) {
			selections.addAll(selectionsInFeature(child, featureConfig));
		}

		for (Group group : feature.getGroups()) {
			for (Feature childInGroup : group.getFeatures()) {
				selections.addAll(
						selectionsInFeature(childInGroup, featureConfig));
			}
		}
		return selections;
	}

	protected void save(Model model, org.eclipse.emf.common.util.URI uri) {

		ResourceSet resourceSet = new ResourceSetImpl();
		// UMLResourcesUtil.init(resourceSet);
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(null); // no save options needed
		} catch (IOException ioe) {
		}
	}

}
