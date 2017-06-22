package cz.zcu.yafmt.clang.bcl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import cz.zcu.yafmt.clang.bcl.model.Conjunction;
import cz.zcu.yafmt.clang.bcl.model.Disjunction;
import cz.zcu.yafmt.clang.bcl.model.Equation;
import cz.zcu.yafmt.clang.bcl.model.ExistsContextualExpression;
import cz.zcu.yafmt.clang.bcl.model.ForAllContextualExpression;
import cz.zcu.yafmt.clang.bcl.model.Implication;
import cz.zcu.yafmt.clang.bcl.model.ModelPackage;
import cz.zcu.yafmt.clang.bcl.model.Negation;
import cz.zcu.yafmt.clang.bcl.model.PrimaryExpression;
import cz.zcu.yafmt.clang.bcl.services.BooleanConstraintLanguageGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class BooleanConstraintLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private BooleanConstraintLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ModelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ModelPackage.CONJUNCTION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Conjunction(context, (Conjunction) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.DISJUNCTION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Disjunction(context, (Disjunction) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.EQUATION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Equation(context, (Equation) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.EXISTS_CONTEXTUAL_EXPRESSION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_ContextualExpression(context, (ExistsContextualExpression) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.FOR_ALL_CONTEXTUAL_EXPRESSION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_ContextualExpression(context, (ForAllContextualExpression) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.IMPLICATION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Implication(context, (Implication) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.NEGATION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_Negation(context, (Negation) semanticObject); 
					return; 
				}
				else break;
			case ModelPackage.PRIMARY_EXPRESSION:
				if(context == grammarAccess.getConjunctionRule() ||
				   context == grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getContextualExpressionRule() ||
				   context == grammarAccess.getDisjunctionRule() ||
				   context == grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0() ||
				   context == grammarAccess.getEquationRule() ||
				   context == grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getImplicationRule() ||
				   context == grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0() ||
				   context == grammarAccess.getNegationRule() ||
				   context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_PrimaryExpression(context, (PrimaryExpression) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (leftPart=Conjunction_Conjunction_1_0 rightPart=Negation)
	 */
	protected void sequence_Conjunction(EObject context, Conjunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.CONJUNCTION__LEFT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.CONJUNCTION__LEFT_PART));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.CONJUNCTION__RIGHT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.CONJUNCTION__RIGHT_PART));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0(), semanticObject.getLeftPart());
		feeder.accept(grammarAccess.getConjunctionAccess().getRightPartNegationParserRuleCall_1_2_0(), semanticObject.getRightPart());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (contextId=ID expression=Equation)
	 */
	protected void sequence_ContextualExpression(EObject context, ExistsContextualExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.EXISTS_CONTEXTUAL_EXPRESSION__CONTEXT_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.EXISTS_CONTEXTUAL_EXPRESSION__CONTEXT_ID));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.EXISTS_CONTEXTUAL_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.EXISTS_CONTEXTUAL_EXPRESSION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_1_2_0(), semanticObject.getContextId());
		feeder.accept(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_1_4_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (contextId=ID expression=Equation)
	 */
	protected void sequence_ContextualExpression(EObject context, ForAllContextualExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.FOR_ALL_CONTEXTUAL_EXPRESSION__CONTEXT_ID));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.FOR_ALL_CONTEXTUAL_EXPRESSION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0(), semanticObject.getContextId());
		feeder.accept(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_0_4_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftPart=Disjunction_Disjunction_1_0 rightPart=Conjunction)
	 */
	protected void sequence_Disjunction(EObject context, Disjunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.DISJUNCTION__LEFT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.DISJUNCTION__LEFT_PART));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.DISJUNCTION__RIGHT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.DISJUNCTION__RIGHT_PART));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0(), semanticObject.getLeftPart());
		feeder.accept(grammarAccess.getDisjunctionAccess().getRightPartConjunctionParserRuleCall_1_2_0(), semanticObject.getRightPart());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftPart=Equation_Equation_1_0 rightPart=Implication)
	 */
	protected void sequence_Equation(EObject context, Equation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.EQUATION__LEFT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.EQUATION__LEFT_PART));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.EQUATION__RIGHT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.EQUATION__RIGHT_PART));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0(), semanticObject.getLeftPart());
		feeder.accept(grammarAccess.getEquationAccess().getRightPartImplicationParserRuleCall_1_2_0(), semanticObject.getRightPart());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (leftPart=Implication_Implication_1_0 rightPart=Disjunction)
	 */
	protected void sequence_Implication(EObject context, Implication semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.IMPLICATION__LEFT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.IMPLICATION__LEFT_PART));
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.IMPLICATION__RIGHT_PART) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.IMPLICATION__RIGHT_PART));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0(), semanticObject.getLeftPart());
		feeder.accept(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0(), semanticObject.getRightPart());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expression=PrimaryExpression
	 */
	protected void sequence_Negation(EObject context, Negation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.NEGATION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.NEGATION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     featureId=ID
	 */
	protected void sequence_PrimaryExpression(EObject context, PrimaryExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ModelPackage.Literals.PRIMARY_EXPRESSION__FEATURE_ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModelPackage.Literals.PRIMARY_EXPRESSION__FEATURE_ID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0(), semanticObject.getFeatureId());
		feeder.finish();
	}
}
