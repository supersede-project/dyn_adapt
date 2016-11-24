package cz.zcu.yafmt.clang.bcl.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

import cz.zcu.yafmt.clang.bcl.ui.internal.BooleanConstraintLanguageActivator;
import cz.zcu.yafmt.clang.ui.EditingContext;
import cz.zcu.yafmt.clang.ui.EditingSupport;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import de.itemis.xtext.utils.jface.viewers.XtextStyledTextCellEditor;

public class BooleanConstraintLanguageEditingSupport extends EditingSupport {

    private static Map<String, String> editedFeatureModelIds = new HashMap<String, String>();

    public static Map<String, String> getEditedFeatureModelIds() {
        return editedFeatureModelIds;
    }

    private static void initializeEditedFeatureModelIds(FeatureModel featureModel) {
        editedFeatureModelIds.clear();

        Feature rootFeature = featureModel.getRoot();
        editedFeatureModelIds.put(rootFeature.getId(), rootFeature.getName());

        TreeIterator<EObject> it = featureModel.getRoot().eAllContents();
        while(it.hasNext()) {
            EObject object = it.next();
            if(object instanceof Feature) {
                Feature feature = (Feature) object;
                editedFeatureModelIds.put(feature.getId(), feature.getName());
            }
        }
    }

    @Override
    public CellEditor createCellEditor(Composite composite, EditingContext context) {
        initializeEditedFeatureModelIds(context.getFeatureModel());

        String languageId = BooleanConstraintLanguageActivator.CZ_ZCU_YAFMT_CLANG_BCL_BOOLEANCONSTRAINTLANGUAGE;
        Injector injector = BooleanConstraintLanguageActivator.getInstance().getInjector(languageId);

        XtextStyledTextCellEditor cellEditor = new XtextStyledTextCellEditor(SWT.SINGLE, injector) {
            @Override
            protected StyledText createStyledText(Composite parent) {
                // Very ugly hack that blocks throwing of SWTException
                // when StyledText.handleKey() is called on disposed widget
                // after pressing ENTER key.
                return new StyledText(parent, getStyle()) {

                    // Called inside handleKey().
                    @Override
                    public int getKeyBinding(int key) {
                        if(isDisposed())
                            return 123456; // This action code should not exist.
                        return super.getKeyBinding(key);
                    }
                    
                    // Called inside handleKey() after getKeyBinding() returns 123456.
                    @Override
                    public void invokeAction(int action) {
                        if(isDisposed())
                            return;
                        super.invokeAction(action);
                    }
                    
                    // This is also sometimes called when widget is disposed.
                    @Override
                    public int getCaretOffset() {
                        if(isDisposed())
                            return 0;
                        return super.getCaretOffset();
                    }
                    
                };
            }
        };
        cellEditor.create(composite);
        return cellEditor;
    }

}
