package eu.supersede.dynadapt.aom.dsl.util.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

import eu.supersede.dynadapt.aom.dsl.resources.SupersedeDSLLibraryResourcesUtil;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;
import eu.supersede.dynadapt.dsl.aspect.Aspect;

public class ParseAdaptationModelDelegate implements IObjectActionDelegate{
	private IFile selectedFile;
	private IWorkbenchWindow window;

	public ParseAdaptationModelDelegate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(IAction action) {
		Aspect adaptationModel = loadAdaptationModel(selectedFile);
	}
	
	private Aspect loadAdaptationModel(IFile adaptationModelFile){
		SupersedeDSLResourceSet set = SupersedeDSLLibraryResourcesUtil.createMigrationResourceSet();
//		SupersedeDSLResourceSet set = SupersedeResources.createResourceSet();
		URI fileURI = URI.createPlatformResourceURI(adaptationModelFile.getFullPath().toString(), true);
		Aspect adaptationModel = set.loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(fileURI.toString()));
		return adaptationModel;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
	        IStructuredSelection ssel = (IStructuredSelection) selection;
	        Object obj = ssel.getFirstElement();
	        if (obj != null) {
		        IFile file = (IFile) Platform.getAdapterManager().getAdapter(obj, IFile.class);
		        if (file == null) {
		            if (obj instanceof IAdaptable) {
		                file = (IFile) ((IAdaptable) obj).getAdapter(IFile.class);
		            }
		        }
		        if (file != null) {
		        	selectedFile = file;
		        }
	        }
	    }
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		window = targetPart.getSite().getWorkbenchWindow();
	}

}
