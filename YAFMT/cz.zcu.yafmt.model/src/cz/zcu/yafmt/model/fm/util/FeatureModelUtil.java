package cz.zcu.yafmt.model.fm.util;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.FeatureModelFactory;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.FeatureModelPackage.Literals;

public class FeatureModelUtil {

    private static final Random random = new Random();
    private static Map<Object, Object> saveLoadOptions;

    // ===============================================================================================
    //  Save and load utilities
    // ===============================================================================================

    private static ExtendedMetaData createExtendedMetadata() {
        ExtendedMetaData emd = new BasicExtendedMetaData();
        // Rename some elements.
        emd.setName(Literals.FEATURE_MODEL, "featureModel");
        emd.setName(Literals.FEATURE_MODEL__CONSTRAINTS, "constraint");
        emd.setName(Literals.FEATURE_MODEL__ORPHANS, "orphanedFeature");
        emd.setName(Literals.FEATURE_MODEL__ROOT, "rootFeature");
        emd.setName(Literals.FEATURE__ATTRIBUTES, "attribute");
        emd.setName(Literals.FEATURE__FEATURES, "feature");
        emd.setName(Literals.FEATURE__GROUPS, "group");
        emd.setName(Literals.GROUP__FEATURES, "feature");
        // Let comment be element instead of attribute.
        emd.setFeatureKind(Literals.FEATURE_MODEL__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.FEATURE__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.GROUP__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.ATTRIBUTE__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        emd.setFeatureKind(Literals.CONSTRAINT__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
        return emd;
    }

    public static Map<Object, Object> createSaveLoadOptions() {
        if(saveLoadOptions == null) {
            saveLoadOptions = new HashMap<Object, Object>();
            saveLoadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
            saveLoadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, createExtendedMetadata());
            saveLoadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE); // Allows proper loading of renamed XML elements.
            saveLoadOptions.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE); // Persist even attributes with default value.
        }
        return saveLoadOptions;
    }

    public static void hookResourceFactoryRegistry() {
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("yafm",
                new XMIResourceFactoryImpl() {
                    @Override
                    public Resource createResource(URI uri) {
                        XMIResource resource = (XMIResource) super.createResource(uri);
                        resource.getDefaultLoadOptions().putAll(createSaveLoadOptions());
                        resource.getDefaultSaveOptions().putAll(createSaveLoadOptions());
                        return resource;
                    }
                }
                );
    }

    public static void hookPackageRegistry() {
        FeatureModelPackage.eINSTANCE.eClass();
    }

    // ===============================================================================================
    //  Creation utilities
    // ===============================================================================================

    public static FeatureModel createEmptyFeatureModel(String name) {
        if((name == null) || name.isEmpty())
            throw new IllegalArgumentException("Feature model name cannot be empty");

        FeatureModelFactory factory = FeatureModelFactory.eINSTANCE;

        Feature rootFeature = factory.createFeature();
        rootFeature.setId(generateIdFromName(name));
        rootFeature.setName(name);
        rootFeature.setLower(1);
        rootFeature.setUpper(1);

        FeatureModel featureModel = factory.createFeatureModel();
        featureModel.setName(name);
        featureModel.setRoot(rootFeature);
        return featureModel;
    }
    
    public static String generateFeatureId() {
        return "f_" + Math.abs(random.nextInt());
    }
    
    public static String generateAttributeId() {
        return "a_" + Math.abs(random.nextInt());
    }
    
    public static String generateIdFromName(String name) {
        String id = Normalizer.normalize(name, Normalizer.Form.NFD);
        id = id.replaceAll("^\\s+", "").replaceAll("\\s+$", "").replaceAll("\\s+", "_");
        return id.replaceAll("[^a-zA-Z0-9_]+", "").toLowerCase();
    }

    // ===============================================================================================
    //  Query utilities
    // ===============================================================================================

    public static String getName(EObject object) {
        if(object == null)
            return "null";
        if(object instanceof FeatureModel)
            return ((FeatureModel) object).getName();
        if(object instanceof Feature)
            return ((Feature) object).getName();
        if(object instanceof Group)
            return "Group";
        if(object instanceof Attribute)
            return ((Attribute) object).getName();
        return object.toString();
    }

    public static String getParentName(EObject parent) {
        if(parent == null)
            return "null";
        if(parent instanceof Group)
            return getName(((Group) parent).getParent());
        return getName(parent);
    }

    public static void removeUnneededGroup(EObject object) {
        if(!(object instanceof Group))
            return;

        Group group = (Group) object;
        List<Feature> features = group.getFeatures();
        if(features.size() <= 1) {
            if(features.size() == 1)
                features.get(0).setParent(group.getParent());
            group.setParent(null);
        }
    }

    public static String getCardinality(Feature feature) {
        if(feature == null)
            return null;

        int lower = feature.getLower();
        int upper = feature.getUpper();
        return "[" + lower + ".." + ((upper == -1) ? "*" : upper) + "]";
    }

    public static String getCardinality(Group group) {
        if(group == null)
            return null;

        int lower = group.getLower();
        int upper = group.getUpper();
        return "<" + lower + "-" + ((upper == -1) ? "*" : upper) + ">";
    }
    
    public static String getTranslatedCardinality(Group group) {
        if(group == null)
            return null;
        
        if(group.isOr())
            return "OR";
        else if(group.isXor())
            return "XOR";
        else
            return getCardinality(group);
    }

    public static TreeInfo analyzeTree(FeatureModel featureModel) {
        if(featureModel == null)
            return new TreeInfo();
        return analyzeTree(featureModel.getRoot());
    }

    public static TreeInfo analyzeTree(Feature feature) {
        TreeInfo info = new TreeInfo();
        if(feature != null)
            analyzeTreeNode(feature, info, 0);
        return info;
    }
    
    private static void analyzeTreeNode(Feature feature, TreeInfo info, int currentHeight) {
        info.size++;
        
        currentHeight++;
        if(currentHeight > info.height)
            info.height = currentHeight;

        for(Feature child: feature.getFeatures())
            analyzeTreeNode(child, info, currentHeight);

        for(Group group: feature.getGroups()) {
            for(Feature child: group.getFeatures())
                analyzeTreeNode(child, info, currentHeight);
        }
    }
    
    public static class TreeInfo {
        
        public int size = 0;
        public int height = 0;
        
    }
    
    // ===============================================================================================
    //  Comparison utilities 
    // ===============================================================================================
    
    // Of course we could use EMF compare, but why another dependency when we just need to test if
    // models are the same.

    public static boolean compareFeatureModels(FeatureModel featureModelA, FeatureModel featureModelB, boolean compareOrphanedFeatures) {
        if(featureModelA == featureModelB)
            return true;
        if((featureModelA == null) || (featureModelB == null))
            return false;
        
        if(!compareStrings(featureModelA.getName(), featureModelB.getName()))
            return false;
        if(!compareStrings(featureModelA.getVersion(), featureModelB.getVersion()))
            return false;
        if(!compareStrings(featureModelA.getDescription(), featureModelB.getDescription()))
            return false;
        if(!compareStrings(featureModelA.getComment(), featureModelB.getComment()))
            return false;
        if(!compareFeatures(featureModelA.getRoot(), featureModelB.getRoot(), true))
            return false;
        if(compareOrphanedFeatures && !compareFeatures(featureModelA.getOrphans(), featureModelB.getOrphans(), true))
            return false;
        if(!compareConstraints(featureModelA.getConstraints(), featureModelB.getConstraints()))
            return false;       
            
        return true;
    }
    
    public static boolean compareFeatures(Feature featureA, Feature featureB, boolean recursive) {
        if(featureA == featureB)
            return true;
        if((featureA == null) || (featureB == null))
            return false;
        
        if(!compareStrings(featureA.getId(), featureB.getId()))
            return false;
        if(!compareStrings(featureA.getName(), featureB.getName()))
            return false;
        if(!compareStrings(featureA.getDescription(), featureB.getDescription()))
            return false;
        if(!compareStrings(featureA.getComment(), featureB.getComment()))
            return false;
        if(featureA.getLower() != featureB.getLower())
            return false;
        if(featureA.getUpper() != featureB.getUpper())
            return false;
        if(!compareAttributes(featureA.getAttributes(), featureB.getAttributes()))
            return false;
        if(recursive && !compareFeatures(featureA.getFeatures(), featureB.getFeatures(), recursive))
            return false;
        if(recursive && !compareGroups(featureA.getGroups(), featureB.getGroups(), recursive))
            return false;
        
        return true;
    }
    
    public static boolean compareFeatures(List<Feature> featuresA, List<Feature> featuresB, boolean recursive) {
        if(featuresA == featuresB)
            return true;
        if((featuresA == null) || (featuresB == null))
            return false;
        
        if(featuresA.size() != featuresB.size())
            return false;
        for(int i = 0; i < featuresA.size(); i++) {
            if(!compareFeatures(featuresA.get(i), featuresB.get(i), recursive))
                return false;
        }
        
        return true;
    }
    
    private static boolean compareAttributes(Attribute attributeA, Attribute attributeB) {
        if(attributeA == attributeB)
            return true;
        if((attributeA == null) || (attributeB == null))
            return false;
        
        if(!compareStrings(attributeA.getId(), attributeB.getId()))
            return false;
        if(!compareStrings(attributeA.getName(), attributeB.getName()))
            return false;
        if(attributeA.getType() != attributeB.getType())
            return false;
        if(!compareStrings(attributeA.getDescription(), attributeB.getDescription()))
            return false;
        if(!compareStrings(attributeA.getComment(), attributeB.getComment()))
            return false;
        
        return true;
    }
    
    public static boolean compareAttributes(List<Attribute> attributesA, List<Attribute> attributesB) {
        if(attributesA == attributesB)
            return true;
        if((attributesA == null) || (attributesB == null))
            return false;
        
        if(attributesA.size() != attributesB.size())
            return false;
        for(int i = 0; i < attributesA.size(); i++) {
            if(!compareAttributes(attributesA.get(i), attributesB.get(i)))
                return false;
        }
        
        return true;
    }
    
    public static boolean compareGroups(Group groupA, Group groupB, boolean recursive) {
        if(groupA == groupB)
            return true;
        if((groupA == null) || (groupB == null))
            return false;
        
        if(groupA.getLower() != groupB.getLower())
            return false;
        if(groupA.getUpper() != groupB.getUpper())
            return false;
        if(!compareStrings(groupA.getDescription(), groupB.getDescription()))
            return false;
        if(!compareStrings(groupA.getComment(), groupB.getComment()))
            return false;
        if(recursive && !compareFeatures(groupA.getFeatures(), groupB.getFeatures(), recursive))
            return false;
        
        return true;
    }
    
    public static boolean compareGroups(EList<Group> groupsA, EList<Group> groupsB, boolean recursive) {
        if(groupsA == groupsB)
            return true;
        if((groupsA == null) || (groupsB == null))
            return false;
        
        if(groupsA.size() != groupsB.size())
            return false;
        for(int i = 0; i < groupsA.size(); i++) {
            if(!compareGroups(groupsA.get(i), groupsB.get(i), recursive))
                return false;
        }
        
        return true;
    }

    public static boolean compareConstraints(Constraint constraintA, Constraint constraintB) {
        if(constraintA == constraintB)
            return true;
        if((constraintA == null) || (constraintB == null))
            return false;
        
        if(!compareStrings(constraintA.getLanguage(), constraintB.getLanguage()))
            return false;
        if(!compareStrings(constraintA.getValue(), constraintB.getValue()))
            return false;
        if(!compareStrings(constraintA.getDescription(), constraintB.getDescription()))
            return false;
        if(!compareStrings(constraintA.getComment(), constraintB.getComment()))
            return false;
        
        return true;
    }
    
    public static boolean compareConstraints(List<Constraint> constraintsA, List<Constraint> constraintsB) {
        if(constraintsA == constraintsB)
            return true;
        if((constraintsA == null) || (constraintsB == null))
            return false;
        
        if(constraintsA.size() != constraintsB.size())
            return false;
        for(int i = 0; i < constraintsA.size(); i++) {
            if(!compareConstraints(constraintsA.get(i), constraintsB.get(i)))
                return false;
        }
        
        return true;
    }
    
    private static boolean compareStrings(String stringA, String stringB) {
        if(stringA == stringB)
            return true;
        if((stringA == null) || (stringB == null))
            return false;
        
        return stringA.equals(stringB);
    }
        
}
