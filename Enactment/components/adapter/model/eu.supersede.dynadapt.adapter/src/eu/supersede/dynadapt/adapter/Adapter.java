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

import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import eu.supersede.dynadapt.modeladapter.ModelAdapter;
import eu.supersede.dynadapt.aom.dsl.parser.AdaptationParser;
import eu.supersede.dynadapt.dsl.aspect.ActionOptionType;
import eu.supersede.dynadapt.dsl.aspect.impl.UpdateValueImpl;
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
	
	String repository = "platform:/resource/eu.supersede.monitor.reconfiguration.models/models/";
	
	public Adapter(ModelRepository mr, ModelManager mm) throws Exception {
		this.mr = mr;
		this.parser = new AdaptationParser();
		this.ma = new ModelAdapter(mm);
		this.mm = mm;
		this.mq = new ModelQuery(mm);
		modelsLocation = new HashMap<String, String>();
		modelsLocation.put("aspects", "adaptability_models/");
		modelsLocation.put("variants", "uml_models/variants/");
		modelsLocation.put("base", "uml_models/base/");
		modelsLocation.put("profiles", "uml_models/profiles/");
		modelsLocation.put("patterns", "patterns/");
		modelsLocation.put("features", "features/models/");
	}

	@Override
	public Model adapt(FeatureModel variability, Aspect adaptationModel, Model baseModel) throws Exception {
		
		List<Feature> features = listFeatures(variability.getRoot(), adaptationModel.getFeature().getId());
		
		Model model = null;
		
		for (Feature f : features) {
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
				
				//Select composition
				Composition c = a.getCompositions().get(0);
				
				ActionOptionType actionOptionType = c.getAction();
				if (actionOptionType instanceof UpdateValueImpl) {
					String value = actionOptionType.eGet(actionOptionType.eClass().getEStructuralFeature("value")).toString();
					model = ma.applyUpdateCompositionDirective(baseModel, elements, value);
				} else {
					model = ma.applyCompositionDirective(a.getCompositions().get(0), baseModel, elements, c.getAdvice(), variant);
				}

			}
		}
			
		return model;
		
	}

	private List<Feature> listFeatures(Feature root, String featureId) {
		List<Feature> features = new ArrayList<>();
		if (root.getId().equals(featureId)) features.add(root);
		if (root.getFeatures().size() > 0) 
			for (Feature f : root.getFeatures()) features.addAll(listFeatures(f, featureId));
		return features;
	}

}
