package cz.zcu.yafmt.ui.editors.fm.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import cz.zcu.yafmt.model.fm.FeatureModel;
import cz.zcu.yafmt.model.fm.util.FeatureModelUtil;
import cz.zcu.yafmt.ui.wizards.NewFileWizard;

public class NewFeatureModelWizard extends NewFileWizard {

    private static final String FM_FILE_EXTENSION = "yafm";

    private FeatureModelPropertiesPage featureModelPropertiesPage = new FeatureModelPropertiesPage();

    public NewFeatureModelWizard() {
        setWindowTitle("New Feature Model Wizard");
    }

    @Override
    protected void initNewFileCreationPage(WizardNewFileCreationPage page) {
        page.setTitle("Feature Model");
        page.setDescription("Create a new feature model.");
        page.setFileName("FeatureModel");
        page.setFileExtension(FM_FILE_EXTENSION);
    }

    @Override
    public void addPages() {
        super.addPages();
        addPage(featureModelPropertiesPage);
    }

    @Override
    protected Resource getNewResource(IFile file) throws Exception {
        String name = featureModelPropertiesPage.getFeatureModelName();
        String version = featureModelPropertiesPage.getFeatureModelVersion();
        String description = featureModelPropertiesPage.getFeatureModelDescription();
        String comment = featureModelPropertiesPage.getFeatureModelComment();

        FeatureModel featureModel = FeatureModelUtil.createEmptyFeatureModel(name);
        if(!version.isEmpty())
            featureModel.setVersion(version);
        if(!description.isEmpty())
            featureModel.setDescription(description);
        if(!comment.isEmpty())
            featureModel.setComment(comment);

        URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = resourceSet.createResource(uri);
        resource.getContents().add(featureModel);
        return resource;
    }

    private class FeatureModelPropertiesPage extends WizardPage {

        private Text nameText;
        private Text versionText;
        private Text descriptionText;
        private Text commentText;

        protected FeatureModelPropertiesPage() {
            super("Feature Model Properties Page");
            setTitle("Feature Model");
            setDescription("Set feature model properties.");
        }

        @Override
        public void createControl(Composite parent) {
            Composite panel = new Composite(parent, SWT.NONE);
            panel.setLayoutData(new GridData(SWT.FILL, SWT.FILL));

            GridLayout layout = new GridLayout();
            layout.numColumns = 2;
            panel.setLayout(layout);

            createNameRow(panel);
            createVersionRow(panel);
            createDescriptionRow(panel);
            createCommentRow(panel);

            setControl(panel);
            revalidatePage();
        }

        private void createNameRow(Composite parent) {
            Label nameLabel = new Label(parent, SWT.NONE);
            nameLabel.setText("Name:");

            nameText = new Text(parent, SWT.SINGLE | SWT.BORDER);
            nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
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

            versionText = new Text(parent, SWT.SINGLE | SWT.BORDER);
            versionText.setText("1.0.0");
            versionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        }

        private void createDescriptionRow(Composite parent) {
            Label descriptionLabel = new Label(parent, SWT.NONE);
            descriptionLabel.setText("Description:");
            
            descriptionText = new Text(parent, SWT.SINGLE | SWT.BORDER);
            descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        }
        
        private void createCommentRow(Composite parent) {
            Label commentLabel = new Label(parent, SWT.NONE);
            commentLabel.setLayoutData(new GridData(SWT.TOP, SWT.LEFT, false, false));
            commentLabel.setText("Comment:");
            
            commentText = new Text(parent, SWT.MULTI | SWT.BORDER);
            commentText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
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

        private void revalidatePage() {
            setPageComplete(validatePage());
        }

        private boolean validatePage() {
            if(nameText.getText().trim().isEmpty()) {
                setErrorMessage("Empty feature model name.");
                return false;
            }

            setErrorMessage(null);
            return true;
        }

        public String getFeatureModelName() {
            return nameText.getText();
        }

        public String getFeatureModelVersion() {
            return versionText.getText();
        }

        public String getFeatureModelDescription() {
            return descriptionText.getText();
        }
        
        public String getFeatureModelComment() {
            return commentText.getText();
        }

    }

}
