/**
 */
package cz.zcu.yafmt.clang.bcl.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import cz.zcu.yafmt.clang.bcl.model.Expression;
import cz.zcu.yafmt.clang.bcl.model.ModelPackage;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.EXPRESSION;
    }
    
    public List<Selection> getSelections(FeatureConfiguration featureConfig, Selection context, String id) {
        List<Selection> allSelections = featureConfig.getSelectionsById(id);
        if(allSelections.isEmpty() || (context == null) || (context == featureConfig.getRoot()))
            return allSelections;
        
        List<Selection> contextualSelections = new ArrayList<Selection>(allSelections.size());
        for(Selection selection: allSelections) {
            for(Selection ancestor = selection; ancestor != null; ancestor = ancestor.getParent()) {
                if(ancestor == context)
                    contextualSelections.add(selection);
            }
        }
        return contextualSelections;
    }
    

} //ExpressionImpl
