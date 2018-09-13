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

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.junit.Assert;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import eu.supersede.dynadapt.adapter.exception.EnactmentException;
import eu.supersede.dynadapt.adapter.kpi.AdapterKPIComputer;
import eu.supersede.dynadapt.dsl.aspect.ActionOptionType;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.Composition;
import eu.supersede.dynadapt.dsl.aspect.Pointcut;
import eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl;
import eu.supersede.dynadapt.enactor.factory.EnactorFactory;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.modeladapter.ModelAdapter;
import eu.supersede.dynadapt.modeladapter.ModelAdapterUtilities;
import eu.supersede.dynadapt.modelrepository.populate.PopulateRepositoryManager;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;
import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.GenericModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.TypedModelId;

public class Adapter implements IAdapter {

	private static final double DEFAULT_ADAPTATION_RANK = 1.0;
	private static final String DEFAULT_ADAPTATION_ID = "FC_1";
	private static final String MODELS_AUTHOR = "Adapter";
	private final static Logger log = LogManager.getLogger(Adapter.class);
	protected AdaptationDashboardProxy<?, ?> adaptationDashboardProxy;

	private ModelRepository mr;
	private ModelManager mm;
	private ModelQuery mq;
	private ModelAdapter ma;

	private Map<String, String> modelsLocation;

	public AdapterKPIComputer kpiComputerAdapter = new AdapterKPIComputer("Enactment KPI: Adapter Enactment Time");
	public AdapterKPIComputer kpiComputerEnactor = new AdapterKPIComputer("Enactment KPI: Enactor Enactment Time");

	private String repositoryRelativePath;
	private boolean demo = false;

	public Adapter(ModelRepository mr, ModelManager mm, Map<String, String> modelsLocation,
			String repositoryRelativePath) throws Exception {
		this(mr, mm, modelsLocation, repositoryRelativePath, false);
	}

	public Adapter(ModelRepository mr, ModelManager mm, Map<String, String> modelsLocation,
			String repositoryRelativePath, boolean demo) throws Exception {
		this.mr = mr;
		this.ma = new ModelAdapter(mm);
		this.mm = mm;
		this.mq = new ModelQuery(mm);
		this.modelsLocation = modelsLocation;
		this.repositoryRelativePath = repositoryRelativePath;
		this.demo = demo;
		// FIXME To avoid FE session expires, create the proxy upon the
		// reception of the alarm
		// this.adaptationDashboardProxy = new
		// AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
		log.debug("Adapter set up");
	}

	@Override
	public void enactAdaptationDecisionAction(ModelSystem system, String adaptationDecisionActionId,
			String featureConfigurationId) throws EnactmentException {
		List<String> adaptationDecisionActionIds = new ArrayList<>();
		adaptationDecisionActionIds.add(adaptationDecisionActionId);
		enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
	}

	@Override
	public void enactFeatureConfiguration(ModelSystem system, String featureConfigurationId) throws EnactmentException {
		try {

			doEnactmentWithEnactor(system, featureConfigurationId, null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnactmentException(e);
		}
	}

	@Override
	public void enactAdaptationDecisionActions(ModelSystem system, List<String> adaptationDecisionActionIds,
			String featureConfigurationId) throws EnactmentException {
		try {

			doEnactment(system, adaptationDecisionActionIds, featureConfigurationId, null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnactmentException(e);
		}
	}

	@Override
	public void enactAdaptationDecisionActionsInFCasString(ModelSystem system, List<String> adaptationDecisionActionIds,
			String featureConfigurationAsString, String featureConfigurationId) throws EnactmentException {
		try {

			doEnactment(system, adaptationDecisionActionIds, featureConfigurationId, featureConfigurationAsString);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnactmentException(e);
		}
	}

	@Override
	public void enactAdaptationDecisionActionsForFC(ModelSystem system, String featureConfigurationId)
			throws EnactmentException {

		try {

			doEnactment(system, null, featureConfigurationId, null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnactmentException(e);
		}

	};

	// FIXME Divide this method in two: adaptModel(), enactModel()
	private void doEnactment(ModelSystem system, List<String> adaptationDecisionActionIds,
			String featureConfigurationId, String featureConfigurationAsString)
			throws EnactmentException, Exception, IOException {

		// Registering dashboard proxy to initialize Front-end session
		this.adaptationDashboardProxy = new AdaptationDashboardProxy<>(
			"adaptation", "adaptation", system.getTenant().getId());

		kpiComputerAdapter.startComputingKPI();

		// Preload Models from remote repository in temporal one
		mr.loadModelsFromRepository(system);

		FeatureConfiguration newFeatureConfig = null;

		if (featureConfigurationId == null && featureConfigurationAsString != null) {
			// Read feature configuration from string
			newFeatureConfig = mr.readModelFromString(featureConfigurationAsString, ModelType.FeatureConfiguration,
					FeatureConfiguration.class);
			Assert.assertNotNull("Passed feature configuration could not be loaded: ", featureConfigurationAsString);
		} else if (featureConfigurationId == null) {
			newFeatureConfig = mr.getLastComputedFeatureConfigurationForSystem(system);
		} else {
			newFeatureConfig = mr.getFeatureConfigurationModel(featureConfigurationId);
		}

		// Get currently enacted BaseModel
		Model baseModel = mr.getLastBaseModelForSystem(system);
		mm.setTargetModel(baseModel);

		// Get currently enacted FeatureConfiguration
		FeatureConfiguration originalFeatureConfig = mr.getLastEnactedFeatureConfigurationForSystem(system);

		// Select features that have suffered change. Only leaf selections are
		// included
		List<Selection> changedSelections = diffFeatureConfigurations(originalFeatureConfig, newFeatureConfig);

		// Filter out changedSelections not included in
		// adaptationDecisionActionIds
		if (adaptationDecisionActionIds != null && !adaptationDecisionActionIds.isEmpty()) {
			List<Selection> droppedSelections = new ArrayList<>();
			for (Selection s : changedSelections) {
				if (!adaptationDecisionActionIds.contains(s.getId())) {
					log.debug("Selection " + s.getId()
							+ " not required for enactment. Dropped from list of changed selections");
					droppedSelections.add(s);
				}
			}
			changedSelections.removeAll(droppedSelections);
		}

		if (changedSelections.isEmpty()) {
			// There are not adaptation changes to enact, reporting as an
			// exception
			throw new EnactmentException(
					"No adaptation changes for enactment between enacted and computed FCs have been detected");
		}

		// BASE MODEL ADAPTATION

		Model model = adapt(system, changedSelections, baseModel);
		kpiComputerAdapter.stopComputingKPI();
		kpiComputerAdapter.reportComputedKPI();

		// BASE MODEL ENACTMENT
		EnactmentException ee = null;
		if (model != null) {
			// NOTE adapted model must be placed in a folder at the same level
			// as the base model's folder
			// otherwise referenced models (e.g., profiles) are not resolved.
			String suri = repositoryRelativePath + "/" + modelsLocation.get("adapted") + model.getName() + ".uml";
			URI uri = URI.createFileURI(suri);
			String adaptation_suffix = "_" + UUID.randomUUID();
			uri = mm.saveModel(model.eResource(), uri, adaptation_suffix + ".uml");
			log.debug("Saved updated model in " + uri);

			// Ask Enactor to enact adapted model
			try {
				log.debug("Invoking enactor for system " + system);
				kpiComputerEnactor.startComputingKPI();
				Model enactedModel = null;
				try {
					enactedModel = EnactorFactory.getEnactorForSystem(system).enactAdaptedModel(model, baseModel,
							demo);
				} catch (UnsupportedOperationException ex) {
					log.info("There is not enactor registered for system: " + system + " . Skipping");
				}
				kpiComputerEnactor.stopComputingKPI();
				kpiComputerEnactor.reportComputedKPI();
				// Update enacted model into repository
				if (!demo && enactedModel != null) {
					String id = storeAdaptedModelInRepository(system, model);
					log.debug("Adapted model has been stored in the repository with id: " + id);

					// Update enacted FC
					eu.supersede.integration.api.adaptation.types.FeatureConfiguration fcMetadata = mr
							.getMetadataOfLastComputedFeatureConfigurationForSystem(system);
					id = mr.storeModel(newFeatureConfig, ModelType.FeatureConfiguration,
							createModelMetadata(fcMetadata, Status.Enacted), fcMetadata.getRelativePath());
					log.debug("Enacted FC has been stored in the repository with id: " + id);
				}
			} catch (Exception e) {
				e.printStackTrace();
				ee = new EnactmentException(e);
			}

			if (!demo) {
				// Recover the adaptation corresponding to the latest feature
				// configuration
				String adaptationId = featureConfigurationId;
				Adaptation adaptation = adaptationDashboardProxy.getAdaptation(adaptationId);
				if (adaptation == null) {
					log.warn("Adaptation with id " + adaptationId + " not found in dashboard");
					adaptation = createAdaptation(adaptationId,
							String.format("%s %s", system.toString(), featureConfigurationId), system,
							changedSelections, kpiComputerAdapter.getInitialProcessingTime());
					adaptation = adaptationDashboardProxy.addAdaptation(adaptation);
				}

				// Notify dashboard the enactment of the FC
				// TODO Do we need to report more data to dashboard in case of
				// failure?
				Enactment enactment = createEnactment(adaptationId, ee == null,
						kpiComputerAdapter.getInitialProcessingTime(), kpiComputerEnactor.getFinalProcessingTime());
				// Populate Enactment data
				adaptationDashboardProxy.addEnactment(enactment);
			}

			// TODO Notify DM that adaptation actions have been enacted
			log.debug("Notifing back to DM that adaptation actions have been enacted");
		}
		if ((model == null) || !(ee == null)) {
			// TODO Notify DM that adaptation actions have not been enacted
			log.debug("Notifing back to DM that adaptation actions have not been enacted");
			if (ee != null)
				throw ee;
			if (model == null)
				throw new EnactmentException("Adaptation model was not computed");
		}
	}

	private String storeAdaptedModelInRepository(ModelSystem system, Model model) throws Exception {
		BaseModel baseModelMetadata = mr.getMetadataOfLastBaseModelForSystem(system);
		// FIXME Use update based model instead of creating a new
		// one. Fix the problem found
		// mr.updateBaseModel(enactedModel,
		// createBaseModelUpdateMetadata(metadata), (String)
		// metadata.getValue("id"));
		String id = mr.storeModel(model, ModelType.BaseModel, createModelMetadata(baseModelMetadata, Status.Enacted),
				baseModelMetadata.getRelativePath());
		// Refresh adapted model for associated system.
		log.debug("Stored updated model for " + system);
		if (system == ModelSystem.AtosMonitoringEnabling) {
			log.debug("Stored updated model for AtosMonitoringTimeSlot");
			storeAdaptedModelInRepository(ModelSystem.AtosMonitoringTimeSlot, model);
		}
		return id;
	}

	private boolean isSiemensSystem(ModelSystem system) {
		// TODO Auto-generated method stub
		return system == ModelSystem.Siemens || system == ModelSystem.Siemens_Buildings
				|| system == ModelSystem.Siemens_Types || system == ModelSystem.Siemens_GetMinMaxDates;
	}

	private void doEnactmentWithEnactor(ModelSystem system, String featureConfigurationId,
			String featureConfigurationAsString) throws EnactmentException, Exception, IOException {

		// Registering dashboard proxy to initialize Front-end session
		this.adaptationDashboardProxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", system.getTenant().getId());

		kpiComputerAdapter.startComputingKPI();

		// Preload Models from remote repository in temporal one
		mr.loadModelsFromRepository(system);

		FeatureConfiguration newFeatureConfig = null;

		if (featureConfigurationId == null && featureConfigurationAsString != null) {
			// Read feature configuration from string
			newFeatureConfig = mr.readModelFromString(featureConfigurationAsString, ModelType.FeatureConfiguration,
					FeatureConfiguration.class);
			Assert.assertNotNull("Passed feature configuration could not be loaded: ", featureConfigurationAsString);
		} else if (featureConfigurationId == null) {
			newFeatureConfig = mr.getLastComputedFeatureConfigurationForSystem(system);
		} else {
			newFeatureConfig = mr.getFeatureConfigurationModel(featureConfigurationId);
		}

		// Get currently enacted FeatureConfiguration
		FeatureConfiguration originalFeatureConfig = mr.getLastEnactedFeatureConfigurationForSystem(system);

		kpiComputerAdapter.stopComputingKPI();
		kpiComputerAdapter.reportComputedKPI();

		// BASE MODEL ENACTMENT
		EnactmentException ee = null;
		String uploadedFeatureConfigurationId = null;
		if (newFeatureConfig != null) {

			// Ask Enactor to enact the new Feature Configuration
			kpiComputerEnactor.startComputingKPI();
			try {
				log.debug("Invoking enactor for system " + system);
				EnactorFactory.getEnactorForSystem(system).enactFeatureConfiguration(newFeatureConfig, demo);
			} catch (Exception e) {
				e.printStackTrace();
				ee = new EnactmentException(e);
			}

			kpiComputerEnactor.stopComputingKPI();
			kpiComputerEnactor.reportComputedKPI();

			// Recover the adaptation corresponding to the latest feature
			// configuration
			String adaptationId = featureConfigurationId != null ? featureConfigurationId
					: uploadedFeatureConfigurationId != null ? uploadedFeatureConfigurationId : DEFAULT_ADAPTATION_ID;
			Adaptation adaptation = adaptationDashboardProxy.getAdaptation(adaptationId);
			if (adaptation == null) {
				log.warn("Adaptation with id " + adaptationId + " not found in dashboard");
				List<Selection> changedSelections = new ArrayList<Selection>();
				adaptation = createAdaptation(adaptationId,
						String.format("%s %s", system.toString(), featureConfigurationId), system, changedSelections,
						kpiComputerAdapter.getInitialProcessingTime());
				adaptation = adaptationDashboardProxy.addAdaptation(adaptation);
			}

			// Notify dashboard the enactment of the FC
			Enactment enactment = createEnactment(adaptationId, ee == null,
					kpiComputerAdapter.getInitialProcessingTime(), kpiComputerEnactor.getFinalProcessingTime());
			// Populate Enactment data
			adaptationDashboardProxy.addEnactment(enactment);

			// TODO Notify DM that adaptation actions have been enacted
			log.debug("Notifing back to DM that adaptation actions have been enacted");
		}
		if ((newFeatureConfig == null) || !(ee == null)) {
			// TODO Notify DM that adaptation actions have not been enacted
			log.debug("Notifing back to DM that adaptation actions have not been enacted");
			if (ee != null)
				throw ee;
			if (newFeatureConfig == null)
				throw new EnactmentException("There was not found the computed feature configuration to be enacted");
		}
	}

	/**
	 * Load the latest adapted base model for the given system.
	 * 
	 * @param am
	 *            the latest adapted base {@link Model}
	 * @param amName
	 *            the name of the adapted mdel file
	 * @param system
	 *            the system owner of the adated model
	 * @return the id of the uploaded model in the model repository
	 * @throws IOException
	 * @throws Exception
	 */
	protected String uploadLatestAdaptedModel(Model am, String amName, ModelSystem system)
			throws IOException, Exception {
		// String userdir = System.getProperty("user.dir");
		// Path repositoryPath =
		// FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		PopulateRepositoryManager prm = new PopulateRepositoryManager(mm, mr);
		String modelId = prm.populateModel(
				// Paths.get(repositoryPath.toString(), "models/adapted",
				// amName),
				am, amName, MODELS_AUTHOR, system, Status.Enacted, modelsLocation.get("adapted"), Model.class,
				ModelType.BaseModel, BaseModel.class);
		return modelId;
	}

	/**
	 * Load the latest computed FeatureConfiguration for the given system.
	 * 
	 * @param fc
	 *            the latest {@link FeatureConfiguration} model
	 * @param fcName
	 *            the name of the feature configuration file
	 * @param system
	 *            the system owner of the adated model
	 * @return the id of the uploaded model in the model repository
	 * @throws IOException
	 * @throws Exception
	 */
	protected String uploadLatestComputedFC(FeatureConfiguration fc, String fcName, ModelSystem system)
			throws IOException, Exception {
		// String userdir = System.getProperty("user.dir");
		// Path repositoryPath =
		// FileSystems.getDefault().getPath(userdir,repositoryRelativePath);
		PopulateRepositoryManager prm = new PopulateRepositoryManager(mm, mr);
		String modelId = prm.populateModel(
				// Paths.get(repositoryPath.toString(),
				// "features/configurations", fcName),
				fc, fcName, MODELS_AUTHOR, system, Status.Computed, modelsLocation.get("configurations"),
				FeatureConfiguration.class, ModelType.FeatureConfiguration,
				eu.supersede.integration.api.adaptation.types.FeatureConfiguration.class);
		return modelId;
	}

	/**
	 * Create an {@link Adaptation} object related to the latest feature
	 * configuration id which is passed as parameter.
	 * 
	 * @param fc_id
	 *            id of the {@link Adaptation} whose enactment is required
	 * @param name
	 *            of the adaptation
	 * @param system
	 *            the {@link ModelSystem} the new adaptation belongs to
	 * @param features
	 *            the list of features that have changed in the latest feature
	 *            configuration
	 * @param inititialTime
	 *            is the enactment process initiation time
	 * @return the {@link Enactment}
	 */
	protected Adaptation createAdaptation(String fc_id, String name, ModelSystem system, List<Selection> features,
			Date inititialTime) {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id(fc_id);
		// adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
		adaptation.setComputation_timestamp(inititialTime);
		adaptation.setModel_system(system);
		adaptation.setName(name);
		adaptation.setRank(DEFAULT_ADAPTATION_RANK);
		adaptation.getActions().addAll(createAction(features));
		return adaptation;
	}

	/**
	 * TODO This is a dummy implementation of the action description
	 * 
	 * @param features
	 *            the list of features that have changed in the latest feature
	 *            configuration
	 * @return the list of enactment {@link Action}
	 */
	protected List<Action> createAction(List<Selection> features) {
		List<Action> actions = new ArrayList<Action>();
		for (Selection feature : features) {
			Action action = new Action();
			// action.setAction_id("vm2_b_high");
			// action.setDescription("Medium load configuration for HSK
			// service");
			// action.setName("VM2_B_HighConfiguration");
			// action.setEnabled(true);
			action.setAction_id(feature.getId());
			String description = feature.getDescription() != null ? feature.getDescription() : "N/A";
			action.setDescription(description);
			action.setName(feature.getName());
			action.setEnabled(feature.isEnabled());
			actions.add(action);
		}
		return actions;
	}

	/**
	 * Create an {@link Enactment} object related to the adaptation whose id
	 * which is passed as parameter.
	 * 
	 * @param fc_id
	 *            id of the {@link Adaptation} whose enactment is required
	 * @param status
	 *            true when the enactment was sucessful, false otherwise
	 * @param initialTime
	 *            is the enactment process initiation time
	 * @param finalTime
	 *            is the enactment process finalization time
	 * @return the {@link Enactment}
	 */
	protected Enactment createEnactment(String fc_id, boolean status, Date initialTime, Date finalTime) {

		Long duration = finalTime.getTime() - initialTime.getTime();
		Date durationDate = new Date(duration);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss.SS");// dd/MM/yyyy
		String durationDateString = df.format(durationDate);
		log.info("The enactment completion time was " + durationDateString);

		Enactment enactment = new Enactment();
		enactment.setFc_id(fc_id);
		// enactment.setEnactment_completion_time(Calendar.getInstance().getTime());
		// enactment.setEnactment_request_time(Calendar.getInstance().getTime());
		enactment.setEnactment_request_time(initialTime);
		enactment.setEnactment_completion_time(durationDate);
		enactment.setResult(status);
		return enactment;
	}

	private Model adapt(ModelSystem modelSystem, List<Selection> selections, Model baseModel) throws Exception {

		Model model = null;
		// Clone base model
		Model clonnedModel = (Model) EcoreUtil.copy(baseModel);

		// Create a model manager targeting cloned model
		ModelManager clonedModelManager = new ModelManager(clonnedModel, mm.getTargetModelAsResource().getURI());

		// Preserving stereotypes in cloned model
		// checkStereotypesInModel(baseModel);
		copyStereotypes(baseModel, clonnedModel);
		// checkStereotypesInModel(clonnedModel);

		// Create modelQuery targeting cloned Model
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
					Collection<? extends IPatternMatch> matches = mq.query(p.getPattern());
					for (IPatternMatch i : matches) {
						Element e = (Element) i.get(0);
						log.debug("\tMatching Element: " + e);
						log.debug("\tApplicable stereotypes: " + e.getApplicableStereotypes().size());
						matchingElements.get(role).add(e);
					}
				}
				Model variant = aspect.getAdvice();
				log.debug("\tVariant: " + (variant != null ? variant.getName() : "Null Variant - Not provided"));

				for (Composition c : aspect.getCompositions()) {
					log.debug("\tComposition " + c.getName());
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

		checkStereotypesInModel(model);
		return model;

	}

	// Calculate leaf selection changes among provided feature configurations
	private List<Selection> diffFeatureConfigurations(FeatureConfiguration originalFeatureConfig,
			FeatureConfiguration newFeatureConfig) {
		FeatureModel fm = originalFeatureConfig.getFeatureModelCopy();
		Feature root = fm.getRoot();

		return diffFeatureConfigurationsInFeature(root, originalFeatureConfig, newFeatureConfig);
	}

	private List<Selection> diffFeatureConfigurationsInFeature(Feature feature,
			FeatureConfiguration originalFeatureConfig, FeatureConfiguration newFeatureConfig) {

		List<Selection> selections = new ArrayList<Selection>();

		// Only computes differences for leaf features
		if (isLeafFeature(feature)) {
			selections = diffFeatureConfigurationsInFeature(feature.getId(), originalFeatureConfig, newFeatureConfig);
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
				if (!s.getValues().get(0).eGet(s.getValues().get(0).eClass().getEStructuralFeature("value")).equals(
						s1.getValues().get(0).eGet(s.getValues().get(0).eClass().getEStructuralFeature("value"))))
					result = true;
				break;
			}
		}

		return result;
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

	private ModelMetadata createModelMetadata(GenericModel model, Status status) throws Exception {
		ModelMetadata metadata = new ModelMetadata();
		metadata.setSender("Adapter");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = new ArrayList<>();
		// Update modification time
		model.setLastModificationDate(Calendar.getInstance().getTime());
		model.setValue("status", status.toString());
		modelInstances.add(model);
		metadata.setModelInstances(modelInstances);

		return metadata;
	}

	private ModelUpdateMetadata createBaseModelUpdateMetadata(BaseModel metadata) {
		ModelUpdateMetadata mum = new ModelUpdateMetadata();
		mum.setSender("Adapter");
		mum.setTimeStamp(Calendar.getInstance().getTime());

		Map<String, Object> values = new HashMap<>();
		values.put("authorId", metadata.getAuthorId());
		values.put("status", "Enacted");
		values.put("name", metadata.getName());
		values.put("creationDate", metadata.getCreationDate());
		values.put("LastModificationDate", Calendar.getInstance().getTime());
		values.put("fileExtension", ModelType.BaseModel.getExtension());
		values.put("systemId", metadata.getSystemId());
		values.put("relativePath", metadata.getRelativePath());
		values.put("dependencies", metadata.getDependencies());

		mum.setValues(values);

		return mum;
	}

	private void copyStereotypes(Model originalModel, Model clonedModel) {
		// Applying profiles
		for (Profile p : originalModel.getAppliedProfiles()) {
			log.debug("Applying " + p.getName());
			if (!clonedModel.getAppliedProfiles().contains(p))
				clonedModel.applyProfile(p);
		}

		// Applying stereotypes
		for (Element e : originalModel.getOwnedElements()) {
			if (e instanceof NamedElement)
				applyStereotypesInElement((NamedElement) e, clonedModel);
		}
	}

	private void applyStereotypesInElement(NamedElement element, Model clonedModel) {
		for (Element e : element.getOwnedElements()) {
			if (e instanceof NamedElement)
				applyStereotypesInElement((NamedElement) e, clonedModel);
		}
		if (element.getAppliedStereotypes().size() > 0) {
			List<String> stereotypes = element.getAppliedStereotypes().stream().map(Stereotype::getName)
					.collect(toList());
			log.debug("Model: " + element.getModel().getName() + ". Base element: " + element.getName()
					+ " is stereotyped with " + stereotypes);
			applyStereoTypesInModel(element, element.getAppliedStereotypes(), clonedModel);
		}
	}

	private void applyStereoTypesInModel(NamedElement element, EList<Stereotype> appliedStereotypes, Model model) {
		// Find element in model
		Element newElement = ModelAdapterUtilities.findElementInModel(element, model);

		// Apply stereotypes and properties
		for (Stereotype s : appliedStereotypes) {
			newElement.applyStereotype(s);
			for (Property p : s.getAllAttributes()) {
				if (p.getAssociation() == null) { // Skipping Stereotype
													// property associations.
					String propertyName = p.getName();
					newElement.setValue(s, propertyName, element.getValue(s, propertyName));
				}
			}
		}
	}

	private void checkStereotypesInModel(Model model) {
		for (Element e : model.getOwnedElements()) {
			if (e instanceof NamedElement)
				checkScheckStereotypesInElement((NamedElement) e);
		}
	}

	private void checkScheckStereotypesInElement(NamedElement element) {
		for (Element e : element.getOwnedElements()) {
			if (e instanceof NamedElement)
				checkScheckStereotypesInElement((NamedElement) e);
		}
		if (element.getAppliedStereotypes().size() > 0) {
			List<String> stereotypes = element.getAppliedStereotypes().stream().map(Stereotype::getName)
					.collect(toList());
			log.debug("Base element: " + element.getName() + " is stereotyped with " + stereotypes);
		}
	}
}
