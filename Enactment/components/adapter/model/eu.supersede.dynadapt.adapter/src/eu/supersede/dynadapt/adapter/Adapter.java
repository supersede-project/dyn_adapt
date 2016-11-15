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

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;

import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.modeladapter.ModelAdapter;
import eu.supersede.dynadapt.aom.dsl.parser.AdaptationParser;
import eu.supersede.dynadapt.dsl.aspect.ActionOptionType;
import eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl;
import eu.supersede.dynadapt.featuremodel.fc.FeatureConfigSUPERSEDE;
import eu.supersede.dynadapt.featuremodel.selection.SelectionSUPERSEDE;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.Composition;
import eu.supersede.dynadapt.dsl.aspect.Pointcut;
import eu.supersede.dynadapt.model.ModelManager;
import eu.supersede.dynadapt.model.query.ModelQuery;
import eu.supersede.dynadapt.modelrepository.repositoryaccess.ModelRepository;

public class Adapter implements IAdapter {
	
	ModelRepository mr;
	AdaptationParser parser;
	ModelManager mm;
	ModelQuery mq;
	ModelAdapter ma;
	
	Map<String, String> modelsLocation;
		
	public Adapter(ModelRepository mr, ModelManager mm, Map<String, String> modelsLocation) throws Exception {
		this.mr = mr;
		this.parser = new AdaptationParser();
		this.ma = new ModelAdapter(mm);
		this.mm = mm;
		this.mq = new ModelQuery(mm);
		this.modelsLocation = modelsLocation;
	}
	
	@Override
	public Model adapt(FeatureModel variability, FeatureConfiguration featureConfig, Aspect adaptationModel, Model baseModel) throws Exception {
		
		List<Feature> features = new ArrayList<>();
		features.add(adaptationModel.getFeature());
		Model model = null;
		
		for (Feature f : features) {
			
			List<String> enabledFeatureIds = new ArrayList<>();
			for (Selection selection : featureConfig.getSelectionsById(f.getId())) {
				if (selection.isEnabled()) enabledFeatureIds.add(selection.getFeature().getId());
			}
			
			System.out.println("Feature ID: " + f.getId());
			List<Aspect> aspects = mr.getAspectModels(f.getId(), modelsLocation);
			System.out.println("Adaptations for feature: " + aspects.size());
			for (Aspect a : aspects) {
				System.out.println("	Aspect name: " + a.getName());
				Stereotype role = null;
				List<Pointcut> pointcuts = a.getPointcuts();
				
				HashMap<Stereotype, List<Element>> elements = new HashMap<>();
				
				for (Pointcut p : pointcuts) {
					role = p.getRole();
					elements.put(role, new ArrayList<>());
					System.out.println("		Role: " + role.getName());
					Collection<? extends IPatternMatch> matches = mq.query(p.getPattern()); 
					for (IPatternMatch i : matches) {
						Element e = (Element) i.get(0);
						System.out.println("			Element: " + e);
						elements.get(role).add(e);
					}
				}
				Model variant = a.getAdvice();
				
				for (Composition c : a.getCompositions()) {
					boolean enabled = c.getFeature_enabled();
					if (enabled && enabledFeatureIds.contains(f.getId())
							|| !enabled && !enabledFeatureIds.contains(f.getId())) {
						ActionOptionType actionOptionType = c.getAction();
						if (actionOptionType instanceof UpdateValueImpl) {
							String value = actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("value")).toString();
							model = ma.applyUpdateCompositionDirective(baseModel, elements, value);
						} else {
							model = ma.applyCompositionDirective(a.getCompositions().get(0).getAction(), baseModel, elements, c.getAdvice(), variant);
						}
					}
				}
			}
		}
			
		return model;
		
	}

	@Override
	public Model adapt(List<Selection> selections, Model baseModel) throws Exception {
		
		Model model = null;
		
		for (Selection selection : selections) {
			Feature feature = selection.getFeature();
			boolean featureEnabled = selection.isEnabled();
						
			System.out.println("Feature <" + feature.getId() + ">" + (featureEnabled?" Enabled":" Disabled"));
			List<Aspect> aspects = mr.getAspectModels(feature.getId(), modelsLocation);
			System.out.println("Adaptations for feature: " + aspects.size());
			
			for (Aspect aspect : aspects) {
				System.out.println("\tAspect name: " + aspect.getName());
				Stereotype role = null;
				List<Pointcut> pointcuts = aspect.getPointcuts();
				
				HashMap<Stereotype, List<Element>> matchingElements = new HashMap<>();
				
				for (Pointcut p : pointcuts) {
					role = p.getRole();
					matchingElements.put(role, new ArrayList<>());
					System.out.println("\t\tRole: " + role.getName());
					Collection<? extends IPatternMatch> matches = mq.query(p.getPattern()); 
					for (IPatternMatch i : matches) {
						Element e = (Element) i.get(0);
						System.out.println("\t\t\tMatching Element: " + e);
						matchingElements.get(role).add(e);
					}
				}
				Model variant = aspect.getAdvice();
				
				for (Composition c : aspect.getCompositions()) {
					boolean compositionEnabled = c.getFeature_enabled();
					if (featureEnabled == compositionEnabled){
						ActionOptionType actionOptionType = c.getAction();
						if (actionOptionType instanceof UpdateValueImpl) {
							String value = actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("value")).toString();
							model = ma.applyUpdateCompositionDirective(baseModel, matchingElements, value);
						} else {
							model = ma.applyCompositionDirective(c.getAction(), baseModel, matchingElements, c.getAdvice(), variant);
						}
					}
				}
			}
		}
			
		return model;
		
	}

	private List<Feature> listFeatures(Feature root, String featureId) {
		List<Feature> features = new ArrayList<>();
		System.out.println(root.getId());
		if (root.getId().equals(featureId)) features.add(root);
		if (root.getFeatures().size() > 0) 
			for (Feature f : root.getFeatures()) features.addAll(listFeatures(f, featureId));
		return features;
	}

}
