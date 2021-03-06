/*
 * generated by Xtext
 */
package eu.supersede.dynadapt.dsl.serializer;

import com.google.inject.Inject;
import eu.supersede.dynadapt.dsl.aspect.Aspect;
import eu.supersede.dynadapt.dsl.aspect.AspectPackage;
import eu.supersede.dynadapt.dsl.aspect.Composition;
import eu.supersede.dynadapt.dsl.aspect.Pointcut;
import eu.supersede.dynadapt.dsl.aspect.UpdateValue;
import eu.supersede.dynadapt.dsl.services.AspectGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class AspectSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AspectGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AspectPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AspectPackage.ACTION:
				sequence_Action(context, (eu.supersede.dynadapt.dsl.aspect.Action) semanticObject); 
				return; 
			case AspectPackage.ASPECT:
				sequence_Aspect(context, (Aspect) semanticObject); 
				return; 
			case AspectPackage.COMPOSITION:
				sequence_Composition(context, (Composition) semanticObject); 
				return; 
			case AspectPackage.POINTCUT:
				sequence_Pointcut(context, (Pointcut) semanticObject); 
				return; 
			case AspectPackage.UPDATE_VALUE:
				sequence_UpdateValue(context, (UpdateValue) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ActionOptionType returns Action
	 *     Action returns Action
	 *
	 * Constraint:
	 *     (ADD='add' | DELETE='delete' | REPLACE='replace' | UPDATE='update')
	 */
	protected void sequence_Action(ISerializationContext context, eu.supersede.dynadapt.dsl.aspect.Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Aspect returns Aspect
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         feature=[Feature|QualifiedName] 
	 *         advice=[Model|QualifiedName]? 
	 *         pointcuts+=Pointcut 
	 *         pointcuts+=Pointcut* 
	 *         compositions+=Composition 
	 *         compositions+=Composition*
	 *     )
	 */
	protected void sequence_Aspect(ISerializationContext context, Aspect semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Composition returns Composition
	 *
	 * Constraint:
	 *     (name=ID feature_enabled=EBOOLEAN jointpointRole=[Stereotype|QualifiedName]? advice=[Stereotype|QualifiedName]? action=ActionOptionType)
	 */
	protected void sequence_Composition(ISerializationContext context, Composition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Pointcut returns Pointcut
	 *
	 * Constraint:
	 *     (name=ID pattern=[Pattern|QualifiedName] role=[Stereotype|QualifiedName]?)
	 */
	protected void sequence_Pointcut(ISerializationContext context, Pointcut semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ActionOptionType returns UpdateValue
	 *     UpdateValue returns UpdateValue
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_UpdateValue(ISerializationContext context, UpdateValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AspectPackage.Literals.UPDATE_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AspectPackage.Literals.UPDATE_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUpdateValueAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
}
