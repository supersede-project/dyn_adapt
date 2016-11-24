package cz.zcu.yafmt.ui.editors.fm.util;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.swt.widgets.Composite;

import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.model.fm.provider.util.FeatureModelProviderUtil;

public class AttributeTypeCellEditor extends ExtendedComboBoxCellEditor {

    public AttributeTypeCellEditor(Composite composite) {
        super(composite, AttributeType.VALUES, FeatureModelProviderUtil.getLabelProvider());
    }

}