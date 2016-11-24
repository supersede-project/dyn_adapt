package cz.zcu.yafmt.ui.editors.fc.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import cz.zcu.yafmt.model.FeatureModelPlugin;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.util.FeatureConfigurationUtil;
import cz.zcu.yafmt.model.fm.Feature;
import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.ui.dialogs.WorkspaceDialog;
import cz.zcu.yafmt.ui.wizards.NewFileWizard;

public class NewFeatureConfigurationWizard extends NewFileWizard {

    private static final String FM_FILE_EXTENSION = "yafm";
    private static final String FC_FILE_EXTENSION = "yafc";

    private FeatureConfigurationPropertiesPage featureConfigurationPropertiesPage = new FeatureConfigurationPropertiesPage();

    public NewFeatureConfigurationWizard() {
        setWindowTitle("New Feature Model Wizard");
    }

    @Override
    protected void initNewFileCreationPage(WizardNewFileCreationPage page) {
        page.setTitle("Feature Configuration");
        page.setDescription("Create a new feature configuration.");
        page.setFileName("FeatureConfiguration");
        page.setFileExtension(FC_FILE_EXTENSION);

        IFile featureModelFile = getSelectedFeatureModelFile();
        if(featureModelFile != null) {
            String name = featureModelFile.getName();
            page.setFileName(name.substring(0, name.length() - FM_FILE_EXTENSION.length() - 1));
        }
    }

    @Override
    public void addPages() {
        super.addPages();
        addPage(featureConfigurationPropertiesPage);
    }

    private IFile getSelectedFeatureModelFile() {
        IStructuredSelection selection = getSelection();
        if((selection != null) && !selection.isEmpty()) {
            Object selectedObject = selection.getFirstElement();
            if(selectedObject instanceof IFile) {
                IFile selectedFile = (IFile) selectedObject;
                if(FM_FILE_EXTENSION.equals(selectedFile.getFileExtension()))
                    return selectedFile;
            }
        }
        return null;
    }

    private FeatureModel getFeatureModel() throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        String featureModelFile = featureConfigurationPropertiesPage.getFeatureModelFile();
        URI uri = URI.createPlatformResourceURI(featureModelFile, true);
        Resource resource = resourceSet.createResource(uri);
        resource.load(null);

        Object featureModelFileContents = resource.getContents().get(0);
        if(!(featureModelFileContents instanceof FeatureModel))
            throw new Exception(featureModelFile + " does not contain YAFMT feature model");

        FeatureModel featureModel = (FeatureModel) featureModelFileContents;
        Feature rootFeature = featureModel.getRoot();
        if((rootFeature == null) || (rootFeature.getId() == null) || (rootFeature.getId().isEmpty()))
            throw new Exception("Specified feature model does not have root feature");

        return featureModel;
    }

    @Override
    protected Resource getNewResource(IFile file) throws Exception {
        FeatureModelPlugin.getPlugin(); // Resource factory and package registration.
        FeatureModel featureModel = getFeatureModel();
        String name = featureConfigurationPropertiesPage.getFeatureConfigurationName();
        String version = featureConfigurationPropertiesPage.getFeatureConfigurationVersion();
        String description = featureConfigurationPropertiesPage.getFeatureConfigurationDescription();
        String comment = featureConfigurationPropertiesPage.getFeatureConfigurationComment();

        FeatureConfiguration featureConfig = FeatureConfigurationUtil.createEmptyFeatureConfiguration(featureModel, name);
        if(!version.isEmpty())
            featureConfig.setVersion(version);
        if(!description.isEmpty())
            featureConfig.setDescription(description);
        if(!comment.isEmpty())
            featureConfig.setComment(comment);

        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        Resource resource = featureModel.eResource().getResourceSet().createResource(uri);
        resource.getContents().add(featureConfig);
        return resource;
    }

    private class FeatureConfigurationPropertiesPage extends WizardPage {

        private Text featureModelFileText;
        private Text nameText;
        private Text versionText;
        private Text descriptionText;
        private Text commentText;

        protected FeatureConfigurationPropertiesPage() {
            super("Feature Model Properties Page");
            setTitle("Feature Model");
            setDescription("Set feature model properties.");
        }

        @Override
        public void createControl(Composite parent) {
            Composite panel = new Composite(parent, SWT.NONE);
            panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL));

            GridLayout layout = new GridLayout();
            layout.numColumns = 3;
            panel.setLayout(layout);

            createFeatureModelRow(panel);
            createNameRow(panel);
            createVersionRow(panel);
            createDescriptionRow(panel);
            createCommentRow(panel);

            // Must be called after creation of all controls
            IFile featureModelFile = getSelectedFeatureModelFile();
            if(featureModelFile != null)
                featureModelFileText.setText(featureModelFile.getFullPath().toString());

            setControl(panel);
            revalidatePage();
        }

        private void createFeatureModelRow(Composite parent) {
            Label featureModelFileLabel = new Label(parent, SWT.NONE);
            featureModelFileLabel.setText("Feature Model:");

            featureModelFileText = new Text(parent, SWT.SINGLE | SWT.BORDER);
            featureModelFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            featureModelFileText.addModifyListener(new ModifyListener() {
                @Override
                public void modifyText(ModifyEvent e) {
                    revalidatePage();
                }
            });

            Button browseButton = new Button(parent, SWT.NONE);
            browseButton.setText("Browse");
            browseButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    openFeatureModelOpenDialog();
                }
            });
        }

        private void createNameRow(Composite parent) {
            Label nameLabel = new Label(parent, SWT.NONE);
            nameLabel.setText("Name:");

            GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
            gridData.horizontalSpan = 2;

            nameText = new Text(parent, SWT.SINGLE | SWT.BORDER);
            nameText.setLayoutData(gridData);
            nameText.addModifyListener(new ModifyListener() {
                @Override
                public void modifyText(ModifyEvent e) {
                    revalidatePage();
                }
            });
        }

        private void createVersionRow(Composite parent) {
            Label versionLabel = new Label(parent, SWT.NONE);
            versionLabel.setText("Version:");

            GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
            gridData.horizontalSpan = 2;

            versionText = new Text(parent, SWT.SINGLE | SWT.BORDER);
            versionText.setText("1.0.0");
            versionText.setLayoutData(gridData);
        }
        
        private void createDescriptionRow(Composite parent) {
            Label descriptionLabel = new Label(parent, SWT.NONE);
            descriptionLabel.setText("Description:");

            GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
            gridData.horizontalSpan = 2;

            descriptionText = new Text(parent, SWT.SINGLE | SWT.BORDER);
            descriptionText.setLayoutData(gridData);
        }

        private void createCommentRow(Composite parent) {
            Label commentLabel = new Label(parent, SWT.NONE);
            commentLabel.setLayoutData(new GridData(SWT.TOP, SWT.LEFT, false, false));
            commentLabel.setText("Comment:");
            
            GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
            gridData.horizontalSpan = 2;
            
            commentText = new Text(parent, SWT.MULTI | SWT.BORDER);
            commentText.setLayoutData(gridData);
        }

        @Override
        public void setVisible(boolean visible) {
            if(visible && nameText.getText().isEmpty()) {
                String name = getFile().getName();
                String extension = getFile().getFileExtension();
                nameText.setText(name.substring(0, name.length() - extension.length() - 1));
            }

            super.setVisible(visible);
        }

        private void openFeatureModelOpenDialog() {
            String path = WorkspaceDialog.openFile(getShell(), "Feature Model Selection", "Select the feature model for configuration.", FM_FILE_EXTENSION);
            if(path != null)
                featureModelFileText.setText(path);
        }

        private void revalidatePage() {
            setPageComplete(validatePage());
        }

        private boolean validatePage() {
            IPath path = new Path(featureModelFileText.getText());
            if(path.isEmpty() || !ResourcesPlugin.getWorkspace().getRoot().exists(path)) {
                setErrorMessage("The selected file does not exist.");
                return false;
            }

            if(!FM_FILE_EXTENSION.equals(path.getFileExtension())) {
                setErrorMessage("The selected file in not a YAFMT feature model.");
                return false;
            }

            if(nameText.getText().trim().isEmpty()) {
                setErrorMessage("Empty feature configuration name.");
                return false;
            }

            setErrorMessage(null);
            return true;
        }

        public String getFeatureModelFile() {
            return featureModelFileText.getText();
        }

        public String getFeatureConfigurationName() {
            return nameText.getText();
        }

        public String getFeatureConfigurationVersion() {
            return versionText.getText();
        }

        public String getFeatureConfigurationDescription() {
            return descriptionText.getText();
        }
        
        public String getFeatureConfigurationComment() {
            return commentText.getText();
        }

    }

}
