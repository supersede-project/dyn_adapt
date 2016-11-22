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
package eu.supersede.dynadapt.lang.yafmt.ui;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;

import cz.zcu.yafmt.model.fm.presentation.FeatureModelEditor;

public class YafmtEditorOpener extends LanguageSpecificURIEditorOpener {
	 @Override
	    protected void selectAndReveal(IEditorPart openEditor, URI uri,
	            EReference crossReference, int indexInList, boolean select) {
		 		FeatureModelEditor fmEditor = (FeatureModelEditor) openEditor.getAdapter(FeatureModelEditor.class);
	        if (fmEditor != null) {
	            EObject eObject = fmEditor.getEditingDomain().getResourceSet().getEObject(uri, true);
	            fmEditor.setSelectionToViewer(Collections.singletonList(eObject));
	        }
	    }
}
