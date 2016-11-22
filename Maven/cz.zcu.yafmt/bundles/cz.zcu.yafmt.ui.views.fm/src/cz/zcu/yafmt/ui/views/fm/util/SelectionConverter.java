package cz.zcu.yafmt.ui.views.fm.util;

import static cz.zcu.yafmt.model.fm.FeatureModelPackage.ATTRIBUTE;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.FEATURE;
import static cz.zcu.yafmt.model.fm.FeatureModelPackage.GROUP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.FeatureConfigurationPackage;
import cz.zcu.yafmt.model.fc.Selection;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModelPackage;
import cz.zcu.yafmt.model.fm.Group;

// Converts between feature model and feature configuration elements selection.
public class SelectionConverter {

    public static ISelection toFeatureModelSelection(ISelection selection) {
        if(!(selection instanceof IStructuredSelection))
            return null;
        if(selection.isEmpty())
            return selection;

        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        Object firstElement = structuredSelection.getFirstElement();
        if(!(firstElement instanceof EObject))
            return null;
        
        EPackage elementPackage = ((EObject) firstElement).eClass().getEPackage();
        if(elementPackage == FeatureModelPackage.eINSTANCE)
            return selection;
        if(elementPackage == FeatureConfigurationPackage.eINSTANCE)
            return new StructuredSelection(toFeatureModelElements(structuredSelection.toArray()));
        return null;
    }
    
    private static Object[] toFeatureModelElements(Object[] elements) {
        Set<Object> featureModelElements = new HashSet<Object>();
        
        for(Object element: elements) {
            if(element instanceof Selection) {
                Feature feature = ((Selection) element).getFeature();
                if(feature != null)
                    featureModelElements.add(feature);
            }
        }
        
        return featureModelElements.toArray();
    }
    
    public static ISelection fromFeatureModelSelection(ISelection selection, FeatureConfiguration featureConfig) {
        if(featureConfig == null)
            return selection;
        
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        return new StructuredSelection(toFeatureConfigurationElements(structuredSelection.toArray(), featureConfig));
    }

    private static List<Object> toFeatureConfigurationElements(Object[] elements, FeatureConfiguration featureConfig) {
        List<Object> featureConfigElements = new ArrayList<Object>(elements.length);
        
        for(Object element: elements) {
            switch(((EObject) element).eClass().getClassifierID()) {
                case FEATURE:
                    featureConfigElements.addAll(featureConfig.getSelectionsById(((Feature) element).getId()));
                    break;

                case GROUP:
                    for(Feature feature: ((Group) element).getFeatures())
                        featureConfigElements.addAll(featureConfig.getSelectionsById(feature.getId()));
                    break;
                
                case ATTRIBUTE: {
                    Attribute attribute = (Attribute) element;
                    String attributeId = attribute.getId();
                    for(Selection selection: featureConfig.getSelectionsById(attribute.getFeature().getId())) {
                        for(AttributeValue value: selection.getValues()) {
                            if(value.getId().equals(attributeId))
                                featureConfigElements.add(value);
                        }
                    }
                    break;
                }
            }
        }
        
        return featureConfigElements;
    }
    
}
