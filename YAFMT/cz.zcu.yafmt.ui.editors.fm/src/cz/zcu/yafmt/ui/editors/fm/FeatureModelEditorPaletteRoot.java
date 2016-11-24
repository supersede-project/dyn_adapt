package cz.zcu.yafmt.ui.editors.fm;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.tools.AbstractTool;
import org.eclipse.gef.tools.ConnectionDragCreationTool;
import org.eclipse.jface.resource.ImageDescriptor;

import cz.zcu.yafmt.model.fm.Attribute;
import cz.zcu.yafmt.model.fm.AttributeType;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModelFactory;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.tools.CreationToolWithReactivation;
import cz.zcu.yafmt.ui.tools.CreationToolWithReactivationAndDirectEdit;
import cz.zcu.yafmt.ui.tools.MiddleButtonPanningSelectionTool;

public class FeatureModelEditorPaletteRoot extends PaletteRoot {

    private ToolEntry selectionToolEntry;
    
    public FeatureModelEditorPaletteRoot() {
        add(createSelectionToolsDrawer());
        add(createCreationToolsDrawer());
        setDefaultEntry(selectionToolEntry);
    }
    
    // =======================================================================
    //  Selection Tools
    // =======================================================================
    
    private PaletteDrawer createSelectionToolsDrawer() {
        PaletteDrawer drawer = new PaletteDrawer("Selection Tools");
        drawer.add(createSelectionToolEntry());
        return drawer;
    }
    
    private ToolEntry createSelectionToolEntry() {
        selectionToolEntry = new PanningSelectionToolEntry();
        selectionToolEntry.setToolClass(MiddleButtonPanningSelectionTool.class);
        return selectionToolEntry;
    }

    // =======================================================================
    //  Creation Tools
    // =======================================================================
    
    private PaletteDrawer createCreationToolsDrawer() {
        PaletteDrawer drawer = new PaletteDrawer("Creation Tools");
        drawer.add(createOptionalFeatureCreationToolEntry());
        drawer.add(createMandatoryFeatureCreationToolEntry());
        drawer.add(createAttributeCreationToolEntry());
        drawer.add(createConnectionCreationToolEntry());
        return drawer;
    }
    private ToolEntry createOptionalFeatureCreationToolEntry() {
        // Use CombinedTemplateCreationEntry instead of CreationToolEntry to support drag and drop
        // via TemplateTransferDragSourceListener and TemplateTransferDropTargetListener.
        ImageDescriptor img = FeatureModelEditorPlugin.getAccess().getImageDescriptor("feature-opt.png");
        CreationToolEntry entry = new CombinedTemplateCreationEntry("Optional Feature", "Create optional feature (hold shift for reuse).", new FeatureFactory(false), img, img);
        entry.setToolClass(CreationToolWithReactivationAndDirectEdit.class);
        return entry;
    }

    private ToolEntry createMandatoryFeatureCreationToolEntry() {
        ImageDescriptor img = FeatureModelEditorPlugin.getAccess().getImageDescriptor("feature-man.png");
        ToolEntry entry = new CombinedTemplateCreationEntry("Mandatory Feature", "Create mandatory feature (hold shift for reuse).", new FeatureFactory(true), img, img);
        entry.setToolClass(CreationToolWithReactivationAndDirectEdit.class);
        return entry;
    }

    private ToolEntry createAttributeCreationToolEntry() {
        ImageDescriptor img = FeatureModelEditorPlugin.getAccess().getImageDescriptor("attribute.png");
        ToolEntry entry = new CombinedTemplateCreationEntry("Attribute", "Add atribute to a feature (hold shift for reuse).", new AttributeFactory(), img, img);
        entry.setToolClass(CreationToolWithReactivation.class);
        return entry;
    }

    private ToolEntry createConnectionCreationToolEntry() {
        ImageDescriptor img = FeatureModelEditorPlugin.getAccess().getImageDescriptor("connection.png");
        ToolEntry entry = new ConnectionCreationToolEntry("Connection", "Create connection (from feature to sub-feature).", null, img, img);
        entry.setToolClass(ConnectionDragCreationTool.class); // Replace ConnectionCreationTool.
        entry.setToolProperty(AbstractTool.PROPERTY_UNLOAD_WHEN_FINISHED, Boolean.FALSE); // Keep it selected after user finishes operation.
        return entry;
    }
    
    // =======================================================================
    //  Creation Factories
    // =======================================================================

    private static class FeatureFactory extends SimpleFactory {

        private boolean mandatoryFeatures;

        public FeatureFactory(boolean mandatoryFeatures) {
            super(Feature.class);
            this.mandatoryFeatures = mandatoryFeatures;
        }

        @Override
        public Object getNewObject() {
            Feature feature = FeatureModelFactory.eINSTANCE.createFeature();
            feature.setId(FeatureModelUtil.generateFeatureId());
            feature.setName("New feature");
            feature.setMandatory(mandatoryFeatures);
            return feature;
        }

    }

    private static class AttributeFactory extends SimpleFactory {

        public AttributeFactory() {
            super(Attribute.class);
        }

        @Override
        public Object getNewObject() {
            Attribute atttribute = FeatureModelFactory.eINSTANCE.createAttribute();
            atttribute.setId(FeatureModelUtil.generateAttributeId());
            atttribute.setName("New Attribute");
            atttribute.setType(AttributeType.STRING);
            return atttribute;
        }

    }

}
