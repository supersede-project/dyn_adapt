package eu.supersede.dynadapt.model.compare;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

public class ModelCompareImpl implements ModelCompare{
	private final Logger log = LogManager.getLogger(this.getClass());
	
	@Override
	public Map<DiffType, Set<Element>> computeDifferencesBetweenModels(Model modelA, Model modelB) {
		// Compare models traversing elements from root model and comparing element QNames
		Set<Element> modelBDifferences = compareModels (modelA.getModel(), modelB.getModel());
		Set<Element> modelADifferences = compareModels (modelB.getModel(), modelA.getModel());
		
		//Reporting
		reportDifferences(modelADifferences, modelBDifferences);
		
		Map<DiffType,Set<Element>> differences = new HashMap<>();
		differences.put(DiffType.DiffInModelA, modelADifferences);
		differences.put(DiffType.DiffInModelB, modelBDifferences);
		
		return differences;
	}

	private void reportDifferences(Set<Element> inDifferences, Set<Element> outDifferences) {
		log.debug ("Differences in adapted model not occurring in original model");
		for (Element e: inDifferences){
			reportDifference(e);
		}
		
		log.debug ("Differences in original model not occurring in adapted model");
		for (Element e: outDifferences){
			reportDifference(e);
		}
	}

	private void reportDifference(Element e) {
		if (e instanceof Slot){
			Slot s = (Slot)e;
			log.debug ("\t Slot: " + s.getDefiningFeature().getName() + " of type: " + s.getDefiningFeature().getType().getName() + " with value " + getValueSpecificationValue (s.getValues().get(0)));
		}else if (e instanceof InstanceSpecification){
			InstanceSpecification ie = (InstanceSpecification)e;
			log.debug ("\t InstanceSpecification: " + ie.getName() + " of type: " + ie.getClassifiers().get(0).getName());
		}
	}
	
	private String getValueSpecificationValue(ValueSpecification ve) {
		if (ve instanceof InstanceValue){
			return ((InstanceValue)ve).getInstance().getName();
		}else if (ve instanceof LiteralString ){
			return ((LiteralString)ve).getValue();
		}else if (ve instanceof LiteralReal){
			return Double.toString(((LiteralReal)ve).getValue());
		}else if (ve instanceof LiteralInteger){
			return Integer.toString(((LiteralInteger)ve).getValue());
		}else{
			return "";
		}
	}

	private Set<Element> compareModels(Model modelA, Model modelB) {
		// Compare models traversing elements from root model and comparing element QNames
		Set<Element> diffElements = new LinkedHashSet<>();
		
		for (PackageableElement element: modelB.getPackagedElements()){
			diffElements.addAll (compareElementInAnotherModelContainer (element, (PackageableElement)modelA));
		}
		
		return diffElements;
	}

	private Collection<? extends Element> compareElementInAnotherModelContainer(NamedElement element,
			Element container) {
		Set<Element> diffElements = new LinkedHashSet<>();
		
		Element elementMatch = matchElementInContainer(element, container);
		
		log.debug ("Element: " + element.getName() + " of type: " + element.getClass() + (elementMatch!=null?" found ": " not found ") + " in model");
		
		if (elementMatch != null){
			for (Element child: element.getOwnedElements()){
				if (child instanceof NamedElement){
					diffElements.addAll (compareElementInAnotherModelContainer ((NamedElement) child, elementMatch));
				}else if (child instanceof Slot && elementMatch instanceof InstanceSpecification){
					diffElements.addAll (compareSlotInAnotherModelContainer ((Slot) child, (InstanceSpecification)elementMatch));
				}else{
					//FIXME Support comparison of not NamedElemnts
					log.debug("Compare element of type: " + child.getClass());
				}
			}
		}else{ //Found difference
			diffElements.add (element);
		}
		
		return diffElements;
	}

	private Collection<? extends Element> compareSlotInAnotherModelContainer(Slot slot,
			InstanceSpecification instance) {
		Set<Element> diffElements = new LinkedHashSet<>();
		
		Slot slotMatch = matchSlotInInstance(slot, instance);
		
		log.debug ("Slot " + slot.getDefiningFeature().getName() + (slotMatch!=null?" found ": " not found ") + " in instance: " + instance.getName());
		
		if (slotMatch == null){
			diffElements.add (slot);
		}
		
		return diffElements;
	}

	private Slot matchSlotInInstance(Slot slot, InstanceSpecification instance) {
		Slot found = null;
		for (Slot child: instance.getSlots()){
			if (compareSlot (slot, child)){
				found = child;
				break;
			}
		}
		return found;
	}

	private boolean compareSlot(Slot slot, Slot child) {
		boolean result = false;
		result = compareQName(slot.getDefiningFeature(), child.getDefiningFeature());
		result = result && compareQName(slot.getDefiningFeature().getType(), child.getDefiningFeature().getType());
		result = result && (slot.getValues().size() == child.getValues().size());
		if (slot.getValues().size()>0){
			result = result && compareValues (slot.getValues().get(0), child.getValues().get(0));
		}
		
		return result;
	}

	private boolean compareValues(ValueSpecification iv1, ValueSpecification iv2) {
		if (iv1 instanceof InstanceValue && iv2 instanceof InstanceValue){
			return compareQName(((InstanceValue)iv1).getInstance(), ((InstanceValue)iv2).getInstance());
		}else if (iv1 instanceof LiteralString && iv2 instanceof LiteralString){
			return ((LiteralString)iv1).getValue().equals(((LiteralString)iv2).getValue());
		}else if (iv1 instanceof LiteralReal && iv2 instanceof LiteralReal){
			return ((LiteralReal)iv1).getValue() == (((LiteralReal)iv2).getValue());
		}else if (iv1 instanceof LiteralInteger && iv2 instanceof LiteralInteger){
			return ((LiteralInteger)iv1).getValue() == (((LiteralInteger)iv2).getValue());
		}else{
			return false;
		}
	}

	private Element matchElementInContainer(NamedElement element, Element container) {
		Element found = null;
		for (Element child: container.getOwnedElements()){
			if (child.getClass() != element.getClass()){
				//Disjoint types
				continue;
			}
			if (element instanceof Manifestation){
				log.debug("Required to match a manifestation");
				if (areEquivalentManifestations ((Manifestation)element, (Manifestation)child)){
					found = child;
					break;
				}
					
			}else if (child instanceof NamedElement){
				NamedElement namedChild = (NamedElement) child;
				if (element.getQualifiedName()==null || namedChild.getQualifiedName()==null){
					log.debug ("Trying to match namedElement with a null qualified name. " 
						+ "Element type: " + element.getClass()
						+ "Child type: " + namedChild.getClass());
					continue;
				}
				if (compareQName (element, namedChild)){
					found = child;
					break;
				}
			}
		}
		return found;
	}
	
	private boolean compareQName (NamedElement e1, NamedElement e2){
		String e1QName = e1.getQualifiedName();
		String e2QName = e2.getQualifiedName();
		
		//Compare attributes with no QName (e.g. associations)
		if (e1QName == null && e1 instanceof Property){
			Property p1 = (Property) e1;
			e1QName = p1.getType().getQualifiedName() + "::" + p1.getName();
		}
		
		if (e2QName == null && e2 instanceof Property){
			Property p2 = (Property) e2;
			e2QName = p2.getType().getQualifiedName() + "::" + p2.getName();
		}
		
		if (e1QName != null)
			if (e1QName.indexOf("::") >= 0)
				e1QName = e1QName.substring(e1QName.indexOf("::") + 2);
		if (e2QName != null)
			if (e2QName.indexOf("::") >= 0)
				e2QName = e2QName.substring(e2QName.indexOf("::") + 2);
		
		return e1QName.equals(e2QName);
	}

	private boolean areEquivalentManifestations(Manifestation element, Manifestation child) {
		boolean result = false;
		
		//Comparing suppliers
		if (element.getSuppliers().size() == child.getSuppliers().size() && element.getSuppliers().size()>0){
			result = compareQName(element.getSuppliers().get(0), child.getSuppliers().get(0));
		}
		
		//Comparing clients
		if (element.getClients().size() == child.getClients().size() && element.getClients().size()>0){
			result = result && compareQName(element.getClients().get(0), child.getClients().get(0));
		}
		
		//Comparing utilized element
		if (element.getUtilizedElement()!=null && child.getUtilizedElement()!=null){
			result = result && compareQName(element.getUtilizedElement(), child.getUtilizedElement());
		}
		
		return result;
	}

}
