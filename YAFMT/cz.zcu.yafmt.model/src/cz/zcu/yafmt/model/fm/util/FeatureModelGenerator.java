package cz.zcu.yafmt.model.fm.util;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.FeatureModelFactory;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureModelGenerator {

    private static final Random random = new Random();

    private static boolean chance(double value) {
        return random.nextDouble() <= value;
    }

    private static int randomInt(int from, int to) {
        return from + random.nextInt(to - from + 1);
    }
    
    public static void main(String[] args) throws IOException {
        FeatureModelUtil.hookPackageRegistry();
        FeatureModelUtil.hookResourceFactoryRegistry();
        
        for(int numberOfFeatures = 32; numberOfFeatures <= 1024; numberOfFeatures *= 2) {
            ResourceSet resourceSet = new ResourceSetImpl();
            URI uri = URI.createFileURI(String.format("testing_fm_%04d.yafm", numberOfFeatures));
            System.out.println("Generating '" + uri + "'...");
            Resource resource = resourceSet.createResource(uri);
            resource.getContents().add(generateFeatureModel(numberOfFeatures));
            resource.save(null);
        }
        
        System.out.println("Done.");
    }

    public static FeatureModel generateFeatureModel(int totalFeatures) {
        FeatureModel featureModel = FeatureModelUtil.createEmptyFeatureModel("Feature Model");
        int featuresLeft = totalFeatures;

        List<Feature> features = new ArrayList<Feature>(totalFeatures);
        Queue<EObject> queue = new ArrayDeque<EObject>();
        queue.add(featureModel.getRoot());

        while(featuresLeft > 0) {
            EObject element = queue.poll();
            
            if(element instanceof Feature) {
                int numberOfFeatures = randomInt(1, 5);
                int numberOfGroups = randomInt(0, 2);
                
                for(int i = 0; i < numberOfFeatures; i++) {
                    Feature feauture = generateFeature();
                    feauture.setParent(element);
                    queue.add(feauture);
                    features.add(feauture);
                    featuresLeft--;
                }
                
                for(int i = 0; i < numberOfGroups; i++) {
                    Group group = generateGroup();
                    group.setParent((Feature) element);
                    queue.add(group);
                }
            }
            else if(element instanceof Group) {
                int numberOfFeatures = randomInt(2, 4);
                
                for(int i = 0; i < numberOfFeatures; i++) {
                    Feature feauture = generateFeature();
                    feauture.setParent(element);
                    queue.add(feauture);
                    features.add(feauture);
                    featuresLeft--;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            EObject element = queue.poll();
            if(element instanceof Group)
                ((Group) element).setParent(null);
        }
        
        int numberOfConstraints = (int) (3 * Math.sqrt(totalFeatures));
        for(int i = 0; i < numberOfConstraints; i++)
            featureModel.getConstraints().add(generateConstraint(features));
        
        return featureModel;
    }

    private static Feature generateFeature() {
        Feature feature = FeatureModelFactory.eINSTANCE.createFeature();
        feature.setId(FeatureModelUtil.generateFeatureId());
        feature.setName(feature.getId());
        feature.setLower(chance(0.75) ? 0 : 1);
        feature.setUpper(randomInt(1, chance(0.75) ? 1 : 3));

        if(chance(0.2)) {
            int numberOfAttributes = randomInt(1, 4);
            for(int i = 0; i < numberOfAttributes; i++)
                feature.getAttributes().add(generateAttribute());
        }

        return feature;
    }

    private static Group generateGroup() {
        Group group = FeatureModelFactory.eINSTANCE.createGroup();
        group.setLower(0);
        group.setUpper(-1);
        return group;
    }

    private static final Attribute generateAttribute() {
        Attribute attribute = FeatureModelFactory.eINSTANCE.createAttribute();
        attribute.setId(FeatureModelUtil.generateAttributeId());
        attribute.setName(attribute.getId());
        attribute.setType(generateAttributeType());
        return attribute;
    }

    private static AttributeType generateAttributeType() {
        switch(randomInt(0, 3)) {
            case 0:
                return AttributeType.BOOLEAN;
            case 1:
                return AttributeType.INTEGER;
            case 2:
                return AttributeType.DOUBLE;
            default:
                return AttributeType.STRING;
        }
    }
    
    private static Constraint generateConstraint(List<Feature> features) {
        Constraint constraint = FeatureModelFactory.eINSTANCE.createConstraint();
        constraint.setLanguage("cz.zcu.yafmt.clang.BooleanConstraintLanguage");
        
        StringBuilder builder = new StringBuilder(chooseRandomFeatureId(features));
        int numberOfFeatures = randomInt(1, 4);
        for(int i = 0; i < numberOfFeatures; i++)
            builder.append(" or ").append(chooseRandomFeatureId(features));
        constraint.setValue(builder.toString());
        
        return constraint;
    }
    
    private static String chooseRandomFeatureId(List<Feature> features) {
        return features.get(randomInt(0, features.size() - 1)).getId();
    }

}
