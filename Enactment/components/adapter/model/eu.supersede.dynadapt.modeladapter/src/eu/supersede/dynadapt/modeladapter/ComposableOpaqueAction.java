/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC), ATOS Spain S.A
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * 	Quim Motger (UPC) - main development
 *  Yosu Gorroñogoitia (Atos) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/

package eu.supersede.dynadapt.modeladapter;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.ActivityImpl;
import org.eclipse.uml2.uml.internal.impl.OpaqueActionImpl;

class ComposableOpaqueAction extends OpaqueActionImpl implements Composable{
	
	private final static Logger log = LogManager.getLogger(ComposableOpaqueAction.class);
	
	@Override
	public void applyAddComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		//TODO 
	}
	
	@Override
	public void applyDeleteComposition(Model inBaseModel, Element jointpointBaseModelElement,
			Model usingVariantModel, Element jointpointVariantModelElement) {
		//TODO
	}

	@Override
	public void applyReplaceComposition(Model inBaseModel, Element jointpointBaseModelElement, Model usingVariantModel,
			Element jointpointVariantModelElement) {
		
		Action baseModelAction = (Action) jointpointBaseModelElement;
		OpaqueAction variantModelAction = (OpaqueAction) jointpointVariantModelElement;
		ActivityImpl activity = (ActivityImpl) baseModelAction.getOwner();
		
		List<ActivityEdge> incomingEdges = baseModelAction.getIncomings();
		List<ActivityEdge> outgoingEdges = variantModelAction.getOutgoings();
		
		//Apply profiles
		for (Profile p : usingVariantModel.getAppliedProfiles()) {
			log.debug("Applying " + p.getName());
			if (!inBaseModel.getAppliedProfiles().contains(p)) inBaseModel.applyProfile(p);
		}
		
		//Starting from the already created incomingEdges in baseModel, appends the new
		//variantModelAction and creates the new outgoingEdges from the variantModel
		List<ActivityNode> finalNodes = appendElementToBaseModel(activity, variantModelAction, incomingEdges, outgoingEdges);
				
		//For every final node in the new variant, appends it to the references of the previous Element
		for (ActivityNode node : finalNodes) {
			List<ActivityEdge> edges = ModelAdapterUtilities.setOutgoingEdges(activity, baseModelAction.getOutgoings(), (OpaqueAction) node);
			for (ActivityEdge edge : baseModelAction.getOutgoings()) ModelAdapterUtilities.setIncomingEdges(edges, edge.getTarget());
		}
						
		log.debug("Destroying " + baseModelAction.getName());
		baseModelAction.destroy();
		
	}

	/**
	 * Returns the list of nodes defining the final activity diagram
	 */
	private List<ActivityNode> appendElementToBaseModel(ActivityImpl activity, OpaqueAction variantModelAction,
			List<ActivityEdge> incomingEdges, List<ActivityEdge> outgoingEdges) {
		
		List<ActivityNode> finalNodes = new ArrayList<>();
		
		OpaqueAction originAction;
		//Check if the action was already created by another call
		if (activity.getNode(variantModelAction.getName()) != null) {
			originAction = (OpaqueAction) activity.getNode(variantModelAction.getName());
			ModelAdapterUtilities.setIncomingEdges(incomingEdges, originAction);
		} else {
		
			originAction = (OpaqueAction) activity.createOwnedNode(variantModelAction.getName(), variantModelAction.eClass());
			log.debug("Appending " + originAction.getName());
			ModelAdapterUtilities.setIncomingEdges(incomingEdges, originAction);
			
			for (Stereotype s : variantModelAction.getAppliedStereotypes()) {
				log.debug("... with stereotype " + s.getName());
				originAction.applyStereotype(s);
			}
			
			//Recursive call for appending following actions
			for (int i = 0; i < variantModelAction.getOutgoings().size(); ++i) {
				ActivityEdge edge = variantModelAction.getOutgoings().get(i);
				if (edge.getTarget() instanceof ActivityFinalNode) {
					finalNodes.add(originAction);
				} else {
					ModelAdapterUtilities.setOutgoingEdges(activity, outgoingEdges, originAction);
					OpaqueAction node = (OpaqueAction) edge.getTarget();
					List<ActivityEdge> incoming = new ArrayList<>();
					incoming.add(originAction.getOutgoings().get(i));
					finalNodes.addAll(appendElementToBaseModel(activity, node, incoming, edge.getTarget().getOutgoings()));
				}
			}
		}
		return finalNodes;
	}
}