/**
 * 
 * @author Edith Zavala
 */

package eu.supersede.dynadapt.featuremodel.fm;

import java.util.List;

import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import eu.supersede.dynadapt.featuremodel.feature.FeatureSUPERSEDE;

public class FeatureModelSUPERSEDE implements IFeatureModelSUPERSEDE {

	private String name;
	private List<FeatureSUPERSEDE> features;
	private List<Constraint> constraints;

	/**
	 * Creates an instance of FeatureModelSUPERSEDE
	 * 
	 * @param name, features, constraints
	 */
	public FeatureModelSUPERSEDE(String name, List<FeatureSUPERSEDE> features, List<Constraint> constraints) {
		super();
		this.name = name;
		this.features = features;
		this.constraints = constraints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FeatureSUPERSEDE> getFeatures() {
		return features;
	}

	public void setFeatures(List<FeatureSUPERSEDE> features) {
		this.features = features;
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}
	
	

}
