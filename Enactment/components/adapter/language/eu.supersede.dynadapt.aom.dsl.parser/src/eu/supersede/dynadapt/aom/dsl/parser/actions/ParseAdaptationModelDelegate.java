/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A, Universitat Politécnica de Catalunya (UPC)
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.dynadapt.aom.dsl.parser.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

import eu.supersede.dynadapt.aom.dsl.parser.AdaptationParser;
import eu.supersede.dynadapt.aom.dsl.parser.IAdaptationParser;
//import eu.supersede.dynadapt.aom.dsl.resources.SupersedeDSLLibraryResourcesUtil;
//import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceSet;
//import eu.supersede.dynadapt.aom.dsl.util.SupersedeDSLResourceUtil;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.model.ModelManager;

public class ParseAdaptationModelDelegate implements IObjectActionDelegate{
	private IFile selectedFile;
	private IWorkbenchWindow window;
	private IAdaptationParser parser;
	private ModelManager modelManager;
	
	public ParseAdaptationModelDelegate() {
		modelManager = new ModelManager();
		parser = new AdaptationParser(modelManager);
	}

	@Override
	public void run(IAction action) {
		Aspect adaptation = loadAdaptationModel(selectedFile);
	}
	
	private Aspect loadAdaptationModel(IFile adaptationModelFile){
//		SupersedeDSLResourceSet set = SupersedeDSLLibraryResourcesUtil.createSupersedeDSLResourceSet();
//		URI fileURI = URI.createPlatformResourceURI(adaptationModelFile.getFullPath().toString(), true);
//		Aspect adaptationModel = set.loadAspectModel(SupersedeDSLResourceUtil.getPlatformResourceURI(fileURI.toString()));
		Aspect adaptation = parser.parseAdaptationModel(adaptationModelFile);
		return adaptation;
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
