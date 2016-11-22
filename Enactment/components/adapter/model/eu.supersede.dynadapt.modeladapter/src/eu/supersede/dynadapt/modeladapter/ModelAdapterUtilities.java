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
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;

class ModelAdapterUtilities{
	public static boolean checkSameRelationship(Relationship r1, Relationship r2) {
		for (int i = 0; i < r1.getRelatedElements().size(); ++i) {
			NamedElement e1 = (NamedElement) r1.getRelatedElements().get(i);
			boolean found = false;
			for (int j = 0; j < r2.getRelatedElements().size(); ++j) {
				NamedElement e2 = (NamedElement) r2.getRelatedElements().get(j);
				if (e1.getName().equals(e2.getName())) {
					found = true;
					break;
				}
			}
			if (!found)
				return false;
		}
		return true;
	}
	
	public static boolean modelContainsElement(NamedElement element, Model model) {
		TreeIterator<EObject> tree = model.eAllContents();
		while (tree.hasNext()) {
			EObject a = tree.next();
			if (a.eClass().getEStructuralFeature("name") != null) {
				Object name = a.eGet(a.eClass().getEStructuralFeature("name"));
				if (name != null) {
					if (name.toString().equals(element.getName()))
						return true;
				}
			}
		}
		return false;
	}
	
	public static List<NamedElement> getInstances(ClassImpl c, Model model) {
		List<NamedElement> instances = new ArrayList<>();
		TreeIterator<EObject> tree = model.eAllContents();
		while (tree.hasNext()) {
			EObject a = tree.next();
			if (a.eClass().getEStructuralFeature("classifier") != null) {
				EObjectResolvingEList eList = (EObjectResolvingEList) a
						.eGet(a.eClass().getEStructuralFeature("classifier"));
				if (eList != null && eList.size() > 0) {
					Classifier classifier = (Classifier) eList.get(0);
					if (classifier.getName().equals(c.getName()))
						instances.add((NamedElement) a);
				}
			}
		}
		return instances;
	}
	
	public static org.eclipse.uml2.uml.Package getPackageInModel(org.eclipse.uml2.uml.Package pack, Model model) {
		// Find in model the corresponding package (same package nested route, excepting for model name)
		String packageQName = pack.getQualifiedName();
		packageQName = packageQName.substring(packageQName.indexOf("::") + 2, packageQName.length());
		List<String> tokens = Arrays.asList(packageQName.split ("\\::")); //Immutable list
		List<String> packages = new ArrayList<>(tokens); //Mutable list
		if (packages.size() == 0){
			return null;
		}
		return getPackageInPackage (packages, model);
	}

	public static org.eclipse.uml2.uml.Package getPackageInPackage(List<String> packages, org.eclipse.uml2.uml.Package outerPackage) {
		if (packages.size() == 0){
			return outerPackage;
		}
		String packageName = packages.get(0);
		org.eclipse.uml2.uml.Package innerPackage = (org.eclipse.uml2.uml.Package) outerPackage.getPackagedElement(packageName);
		packages.remove(packageName);
		
		return getPackageInPackage (packages, innerPackage);
	}
	
	public static void addElementInPackage(PackageableElement element, org.eclipse.uml2.uml.Package pack) {
		pack.getPackagedElements().add (element);
	}
	
	public static PackageableElement getEquivalentElementInModel(PackageableElement element, Model model) {
		PackageableElement equivalentElement = null;
		org.eclipse.uml2.uml.Package pack = getPackageInModel(element.getNearestPackage(), model);
		if (pack!=null){
			equivalentElement = pack.getPackagedElement(element.getName());
		}
		return equivalentElement;
	}
	
	public static boolean slotsHasSameDefiningFeature(Slot slot1, Slot slot2) {
		return slot1.getDefiningFeature().getName().equals(slot2.getDefiningFeature().getName());
	}

	public static boolean slotsHasSameValue(Slot slot1, Slot slot2) {
		InstanceValue iv1 = (InstanceValue) slot1.getValues().get(0);
		InstanceValue iv2 = (InstanceValue) slot2.getValues().get(0);
		return iv1.getInstance().getName().equals(iv2.getInstance().getName());
	}
	
	public static boolean areSameElements(NamedElement e1, NamedElement e2) {
		boolean result = true;
		result = result && (e1.getClass().getSimpleName().equals(e1.getClass().getSimpleName()));
		result = result && (e1.getName().equals(e2.getName()));
		return result;
	}
	
	public static Element findElementByStereotype(Model model, Stereotype stereotype) {
		EList<Element> list = model.allOwnedElements();
		for (Element e : list) {
			if (e.isStereotypeApplied(stereotype)) {
				return e;
			}
		}
		return null;
	}
	
}
