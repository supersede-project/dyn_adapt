package cz.zcu.yafmt.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;


public class FeatureModelingPerspectiveFactory implements IPerspectiveFactory {

    private static final String TOP_LEFT_FOLDER_ID = "TopLeftFolder";
    private static final String BOTTOM_LEFT_FOLDER_ID = "BottomLeftFolder";
    private static final String BOTTOM_FOLDER_ID = "BottomFolder";
    
    private static final String FM_VISUALIZER_ID = "cz.zcu.yafmt.ui.views.fm.FeatureModelVisualizer";
    private static final String NEW_FM_WIZARD_ID = "cz.zcu.yafmt.ui.editors.fm.wizards.NewFeatureModelWizard";
    private static final String NEW_FC_WIZARD_ID = "cz.zcu.yafmt.ui.editors.fc.wizards.NewFeatureConfigurationWizard";
    private static final String NEW_PROJECT_WIZARD_ID = "org.eclipse.ui.wizards.new.project";
    
    @Override
    public void createInitialLayout(IPageLayout layout) {
        layout.setEditorAreaVisible(true);
        layout.addShowViewShortcut(FM_VISUALIZER_ID);
        layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
        layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
        layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
        layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
        layout.addNewWizardShortcut(NEW_PROJECT_WIZARD_ID);
        layout.addNewWizardShortcut(NEW_FM_WIZARD_ID);
        layout.addNewWizardShortcut(NEW_FC_WIZARD_ID);
        
        IFolderLayout topLeftFolder = layout.createFolder(TOP_LEFT_FOLDER_ID, IPageLayout.LEFT, 0.2f, IPageLayout.ID_EDITOR_AREA);
        IFolderLayout bottomLeftFolder = layout.createFolder(BOTTOM_LEFT_FOLDER_ID, IPageLayout.BOTTOM, 0.5f, TOP_LEFT_FOLDER_ID);
        IFolderLayout bottomFolder = layout.createFolder(BOTTOM_FOLDER_ID, IPageLayout.BOTTOM, 0.7f, IPageLayout.ID_EDITOR_AREA);
        
        topLeftFolder.addView(IPageLayout.ID_PROJECT_EXPLORER);
        bottomLeftFolder.addView(IPageLayout.ID_OUTLINE);
        bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
        bottomFolder.addView(IPageLayout.ID_PROBLEM_VIEW);
        bottomFolder.addPlaceholder(FM_VISUALIZER_ID);
    }

}
