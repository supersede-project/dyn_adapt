package cz.zcu.yafmt.ui.views.fm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import cz.zcu.yafmt.clang.ConstraintLanguageException;
import cz.zcu.yafmt.clang.ConstraintLanguagePlugin;
import cz.zcu.yafmt.clang.ConstraintLanguageRegistry;
import cz.zcu.yafmt.clang.IConstraintLanguage;
import cz.zcu.yafmt.clang.IEvaluator;
import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.Constraint;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.Group;

public class FeatureModelContentProvider implements IGraphEntityContentProvider {

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public Object[] getElements(Object input) {
        if(input == null)
            return null;

        FeatureModel featureModel = (FeatureModel) input;
        List<Object> objects = new ArrayList<Object>();
        objects.add(featureModel.getRoot());

        Iterator<EObject> it = featureModel.getRoot().eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(!(object instanceof Attribute))
                objects.add(object);
        }

        objects.addAll(featureModel.getConstraints());
        return objects.toArray();
    }

    @Override
    public Object[] getConnectedTo(Object element) {
        if(element instanceof Feature)
            return getConnectedToFeature((Feature) element);
        if(element instanceof Group)
            return getConnectedToGroup((Group) element);
        if(element instanceof Constraint)
            return getConnectedToConstraint((Constraint) element);
        return null;
    }

    private Object[] getConnectedToFeature(Feature feature) {
        List<Object> objects = new ArrayList<Object>();
        objects.addAll(feature.getFeatures());

        for(Group group: feature.getGroups())
            objects.addAll(group.getFeatures());

        return objects.toArray();
    }
    
    private Object[] getConnectedToGroup(Group group) {
        return group.getFeatures().toArray();
    }

    private Object[] getConnectedToConstraint(Constraint constraint) {
        ConstraintLanguageRegistry registry = ConstraintLanguagePlugin.getDefault().getConstraintLanguageRegistry();
        IConstraintLanguage language = registry.getLanguage(constraint.getLanguage());
        if(language == null)
            return null;

        try {
            IEvaluator evaluator = language.createEvaluator(constraint.getValue());
            return evaluator.getAffectedFeatures(constraint.getFeatureModel()).toArray();
        }
        catch(ConstraintLanguageException ex) {
            return null; // Just ignore problematic constraint.
        }
    }



}
