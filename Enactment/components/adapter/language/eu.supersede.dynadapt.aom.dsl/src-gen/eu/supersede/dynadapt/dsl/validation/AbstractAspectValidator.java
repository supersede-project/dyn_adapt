/*
 * generated by Xtext
 */
package eu.supersede.dynadapt.dsl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractAspectValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(eu.supersede.dynadapt.dsl.aspect.AspectPackage.eINSTANCE);
		return result;
	}
}
