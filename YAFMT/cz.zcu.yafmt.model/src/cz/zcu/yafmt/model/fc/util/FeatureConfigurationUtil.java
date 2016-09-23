package cz.zcu.yafmt.model.fc.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.BooleanValue;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.FeatureConfigurationFactory;
import cz.zcu.yafmt.model.fc.FeatureConfigurationPackage;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fc.StringValue;
import cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.Literals;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;

public class FeatureConfigurationUtil {

    private static Map<Object, Object> saveLoadOptions;

    // ===============================================================================================
    //  Save and load utilities
    // ===============================================================================================

    private static ExtendedMetaData createExtendedMetadata() {
        ExtendedMetaData emd = new BasicExtendedMetaData();
        // Rename some elements.
        emd.setName(Literals.FEATURE_CONFIGURATION__ROOT, "rootSelection");
        emd.setName(Literals.SELECTION__SELECTIONS, "selection");
        emd.setName(Literals.SELECTION__VALUES, "attributeValue");
        emd.setName(Literals.BOOLEAN_VALUE, "boolean");
        emd.setName(Literals.INTEGER_VALUE, "integer");
        emd.setName(Literals.DOUBLE_VALUE, "double");
        emd.setName(Literals.STRING_VALUE, "string");
        // Let comment be element instead of attribute.
        emd.setFeatureKind(Literals.FEATURE_CONFIGURATION__COMMENT, ExtendedMetaData.ELEMENT_FEATURE);
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
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("yafc",
                new XMIResourceFactoryImpl() {
                    @Override
                    public Resource createResource(URI uri) {
                        XMIResource resource = (XMIResource) super.createResource(uri);
                        resource.getDefaultLoadOptions().putAll(createSaveLoadOptions());
                        resource.getDefaultLoadOptions().putAll(FeatureModelUtil.createSaveLoadOptions());
                        resource.getDefaultSaveOptions().putAll(createSaveLoadOptions());
                        resource.getDefaultSaveOptions().putAll(FeatureModelUtil.createSaveLoadOptions());
                        return resource;
                    }
                }
                );
    }

    public static void hookPackageRegistry() {
        FeatureConfigurationPackage.eINSTANCE.eClass();
    }

    // ===============================================================================================
    //  Creation utilities
    // ===============================================================================================

    public static FeatureConfiguration createEmptyFeatureConfiguration(FeatureModel featureModel) {
        return createEmptyFeatureConfiguration(featureModel, (featureModel != null) ? featureModel.getName() : null);
    }

    public static FeatureConfiguration createEmptyFeatureConfiguration(FeatureModel featureModel, String name) {
        if(featureModel == null)
            throw new IllegalArgumentException("Feature model cannot be null");

        FeatureConfiguration featureConfig = FeatureConfigurationFactory.eINSTANCE.createFeatureConfiguration();
        featureConfig.setFeatureModel(featureModel);
        featureConfig.setFeatureModelCopy(EcoreUtil.copy(featureModel));
        featureConfig.setName(name);
        featureConfig.setRoot(createSelection(featureModel.getRoot()));

        return featureConfig;
    }

    public static Selection createSelection(Feature feature) {
        Selection selection = FeatureConfigurationFactory.eINSTANCE.createSelection();
        selection.setId(feature.getId());
        repairSelection(feature, selection);
        return selection;
    }

    public static AttributeValue createAttributeValue(Attribute attribute) {
        AttributeValue value = createAttributeValue(attribute.getType());
        value.setId(attribute.getId());
        return value;
    }

    public static AttributeValue createAttributeValue(AttributeType attributeType) {
        switch(attributeType) {
            case BOOLEAN:
                return FeatureConfigurationFactory.eINSTANCE.createBooleanValue();
            case INTEGER:
                return FeatureConfigurationFactory.eINSTANCE.createIntegerValue();
            case DOUBLE:
                return FeatureConfigurationFactory.eINSTANCE.createDoubleValue();
            case STRING:
                return FeatureConfigurationFactory.eINSTANCE.createStringValue();
            default:
                return FeatureConfigurationFactory.eINSTANCE.createStringValue();
        }
    }

    // ===============================================================================================
    //  Selection repair utilities
    // ===============================================================================================

    public static void repairConfiguration(FeatureModel featureModel, FeatureConfiguration featureConfig) {
        if((featureModel == null) || (featureConfig == null))
            return;
        
        Feature rootFeature = featureModel.getRoot();
        if(rootFeature == null)
            return;
        
        Selection rootSelection = featureConfig.getRoot();
        if(rootSelection == null) {
            // Should not happen.
            rootSelection = createSelection(rootFeature);
            featureConfig.setRoot(rootSelection);
        }
        else if(!rootSelection.getId().equals(rootFeature.getId())) {
            // Fix ID when changed.
            rootSelection.setId(rootFeature.getId());
        }
        
        repairSelection(rootFeature, rootSelection);
    }
    
    public static void repairSelection(Feature feature, Selection selection) {
        // Check attributes.
        repairAttributeValues(feature, selection);

        // Repair solitary features.
        int expectedIndex = 0;
        EList<Selection> childrenSelections = selection.getSelections();
        expectedIndex = repairSelections(feature.getFeatures(), expectedIndex, childrenSelections);

        // Repair grouped features.
        for(Group group: feature.getGroups())
            expectedIndex = repairSelections(group.getFeatures(), expectedIndex, childrenSelections);

        // Remove unnecessary selections from the right to left.
        for(int i = childrenSelections.size() - 1; i >= expectedIndex; i--)
            childrenSelections.remove(i);
    }

    private static int repairSelections(EList<Feature> features, int startingIndex, EList<Selection> selections) {
        int expectedIndex = startingIndex;

        for(Feature feature: features) {
            int lower = feature.getLower();
            int upper = feature.getUpper();

            // Add or move mandatory selections.
            for(int i = 0; i < lower; i++) {
                if(repairSelectionPosition(feature, expectedIndex, selections, true))
                    repairSelection(feature, selections.get(expectedIndex));
                expectedIndex++;
            }

            // Move optional selections.
            for(int i = (upper == -1) ? Integer.MAX_VALUE : (upper - lower); i > 0; i--) {
                if(repairSelectionPosition(feature, expectedIndex, selections, false)) {
                    repairSelection(feature, selections.get(expectedIndex));
                    expectedIndex++;
                }
                else {
                    break;
                }
            }
        }

        return expectedIndex;
    }

    private static boolean repairSelectionPosition(Feature feature, int expectedIndex, EList<Selection> selections, boolean shouldExist) {
        String id = feature.getId();

        if(expectedIndex < selections.size()) {
            // Selection is on the expected position. OK.
            if(selections.get(expectedIndex).getId().equals(id))
                return true;

            for(int i = expectedIndex + 1; i < selections.size(); i++) {
                // Selection is on different position. Move it.
                if(selections.get(i).getId().equals(id)) {
                    selections.move(expectedIndex, i);
                    return true;
                }
            }
        }

        // Selection does not exist and must be present. Create it.
        if(shouldExist)
            selections.add(expectedIndex, createSelection(feature));

        // Selection was not present.
        return false;
    }

    // ===============================================================================================
    //  Attribute repair utilities
    // ===============================================================================================

    public static void repairAttributeValues(Feature feature, Selection selection) {
        EList<Attribute> attributes = feature.getAttributes();
        EList<AttributeValue> values = selection.getValues();

        // Add or move existing attribute values.
        for(int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            if(repairAttributeValuePosition(attribute, i, values))
                repairAttributeValueType(attribute, i, values);
        }

        // Remove unnecessary attribute values from the right to left.
        for(int i = values.size() - 1; i >= attributes.size(); i--)
            values.remove(i);
    }

    private static boolean repairAttributeValuePosition(Attribute attribute, int expectedIndex, EList<AttributeValue> values) {
        String id = attribute.getId();

        if(expectedIndex < values.size()) {
            // Attribute value is on the expected position. OK.
            if(values.get(expectedIndex).getId().equals(id))
                return true;

            for(int i = expectedIndex + 1; i < values.size(); i++) {
                // Attribute value is on different position. Move it.
                if(values.get(i).getId().equals(id)) {
                    values.move(expectedIndex, i);
                    return true;
                }
            }
        }

        // Attribute value does not exist. Create it.
        values.add(expectedIndex, createAttributeValue(attribute));

        // Attribute value was not present.
        return false;
    }

    private static void repairAttributeValueType(Attribute attribute, int index, EList<AttributeValue> values) {
        boolean sameType = false;

        switch(attribute.getType()) {
            case BOOLEAN:
                sameType = values.get(index) instanceof BooleanValue;
                break;
            case INTEGER:
                sameType = values.get(index) instanceof IntegerValue;
                break;
            case DOUBLE:
                sameType = values.get(index) instanceof DoubleValue;
                break;
            case STRING:
                sameType = values.get(index) instanceof StringValue;
                break;
        }

        if(!sameType)
            values.set(index, createAttributeValue(attribute));
    }

}
