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
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.internal.impl.ActivityImpl;
import org.eclipse.uml2.uml.internal.impl.ActivityNodeImpl;
import org.eclipse.uml2.uml.internal.impl.NodeImpl;

class ComposableActivityNode extends ActivityNodeImpl implements Composable{
	
	private final static Logger log = LogManager.getLogger(ComposableActivityNode.class);
	
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
		
		ActivityNode baseModelAction = (ActivityNode) jointpointBaseModelElement;
		ActivityNode variantModelAction = (ActivityNode) jointpointVariantModelElement;
		ActivityImpl activity = (ActivityImpl) baseModelAction.getOwner();
		
		List<ActivityEdge> incomingEdges = baseModelAction.getIncomings();
		//log.debug("Incoming edges: " + incomingEdges.size());
		List<ActivityEdge> outgoingEdges = variantModelAction.getOutgoings();
		//log.debug("Outcoming edges: " + outgoingEdges.size());
		
		//Starting from the already created incomingEdges in baseModel, appends the new
		//variantModelAction and creates the new outgoingEdges from the variantModel
		List<ActivityNode> finalNodes = appendElementToBaseModel(activity, variantModelAction, incomingEdges, outgoingEdges);
				
		ActivityEdge deleteEdge = baseModelAction.getOutgoings().get(0);
		ActivityNode finalNode = deleteEdge.getTarget();
		deleteEdge.destroy();
		
		for (ActivityNode node : finalNodes) {
			for (ActivityEdge edge : node.getOutgoings()) {
				//log.debug("\tSet edge target to " + finalNode);
				edge.setTarget(finalNode);
			}
		}
		
		/*for (ActivityNode node : finalNodes) {
			List<ActivityEdge> edges = ModelAdapterUtilities.setOutgoingEdges(activity, baseModelAction.getOutgoings(), (ActivityNode) node);
			for (ActivityEdge edge : baseModelAction.getOutgoings()) ModelAdapterUtilities.setIncomingEdges(edges, edge.getTarget());
		}*/
		
		//log.debug("Destroying " + baseModelAction.getName());
		baseModelAction.destroy();
		
	}

	/**
	 * Returns the list of nodes defining the final activity diagram
	 */
	private List<ActivityNode> appendElementToBaseModel(ActivityImpl activity, ActivityNode variantModelAction,
			List<ActivityEdge> incomingEdges, List<ActivityEdge> outgoingEdges) {
		
		List<ActivityNode> finalNodes = new ArrayList<>();
		
		ActivityNode originAction;
		//Check if the action was already created by another call
		if (activity.getNode(variantModelAction.getName()) != null) {
			originAction = (ActivityNode) activity.getNode(variantModelAction.getName());
			ModelAdapterUtilities.setIncomingEdges(incomingEdges, originAction);
		} else {
		
			originAction = (ActivityNode) activity.createOwnedNode(variantModelAction.getName(), variantModelAction.eClass());
			log.debug("\t" + originAction.getName() + " node created");
			/*for (Stereotype s : variantModelAction.getAppliedStereotypes()) {
				originAction.applyStereotype(s);
				if (s.getName().equals("Service")) {
					originAction.setValue(s, "endpoint", variantModelAction.getValue(s, "endpoint"));
				}
				else if (s.getName().equals("Callback")) {
					originAction.setValue(s, "function", variantModelAction.getValue(s, "function"));
				}
			}*/
			ModelAdapterUtilities.setIncomingEdges(incomingEdges, originAction);

			ModelAdapterUtilities.setOutgoingEdges(activity, outgoingEdges, originAction);
			//Recursive call for appending following actions
			for (int i = 0; i < variantModelAction.getOutgoings().size(); ++i) {
				ActivityEdge edge = variantModelAction.getOutgoings().get(i);
				if (edge.getTarget() instanceof ActivityFinalNode) {
					finalNodes.add(originAction);
				} else {
					ActivityNode node = (ActivityNode) edge.getTarget();
					List<ActivityEdge> incoming = new ArrayList<>();
					incoming.add(originAction.getOutgoings().get(i));
					finalNodes.addAll(appendElementToBaseModel(activity, node, incoming, edge.getTarget().getOutgoings()));
				}
			}
		}
		return finalNodes;
	}
}