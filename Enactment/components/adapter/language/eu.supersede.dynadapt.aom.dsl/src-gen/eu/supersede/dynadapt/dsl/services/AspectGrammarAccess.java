/*
 * generated by Xtext
 */
package eu.supersede.dynadapt.dsl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class AspectGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class AspectElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.Aspect");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAspectKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cFeatureKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cFeatureAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cFeatureFeatureCrossReference_4_0 = (CrossReference)cFeatureAssignment_4.eContents().get(0);
		private final RuleCall cFeatureFeatureQualifiedNameParserRuleCall_4_0_1 = (RuleCall)cFeatureFeatureCrossReference_4_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCommaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cAdviceKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cAdviceAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cAdviceModelCrossReference_5_2_0 = (CrossReference)cAdviceAssignment_5_2.eContents().get(0);
		private final RuleCall cAdviceModelQualifiedNameParserRuleCall_5_2_0_1 = (RuleCall)cAdviceModelCrossReference_5_2_0.eContents().get(1);
		private final Keyword cCommaKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cPointcutsKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cLeftCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cPointcutsAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cPointcutsPointcutParserRuleCall_9_0 = (RuleCall)cPointcutsAssignment_9.eContents().get(0);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cCommaKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Assignment cPointcutsAssignment_10_1 = (Assignment)cGroup_10.eContents().get(1);
		private final RuleCall cPointcutsPointcutParserRuleCall_10_1_0 = (RuleCall)cPointcutsAssignment_10_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_11 = (Keyword)cGroup.eContents().get(11);
		private final Keyword cCommaKeyword_12 = (Keyword)cGroup.eContents().get(12);
		private final Keyword cCompositionsKeyword_13 = (Keyword)cGroup.eContents().get(13);
		private final Keyword cLeftCurlyBracketKeyword_14 = (Keyword)cGroup.eContents().get(14);
		private final Assignment cCompositionsAssignment_15 = (Assignment)cGroup.eContents().get(15);
		private final RuleCall cCompositionsCompositionParserRuleCall_15_0 = (RuleCall)cCompositionsAssignment_15.eContents().get(0);
		private final Group cGroup_16 = (Group)cGroup.eContents().get(16);
		private final Keyword cCommaKeyword_16_0 = (Keyword)cGroup_16.eContents().get(0);
		private final Assignment cCompositionsAssignment_16_1 = (Assignment)cGroup_16.eContents().get(1);
		private final RuleCall cCompositionsCompositionParserRuleCall_16_1_0 = (RuleCall)cCompositionsAssignment_16_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_17 = (Keyword)cGroup.eContents().get(17);
		private final Keyword cRightCurlyBracketKeyword_18 = (Keyword)cGroup.eContents().get(18);
		
		//Aspect:
		//	"aspect" name=ID "{"
		//	"feature" feature=[fm::Feature|QualifiedName] ("," "advice" advice=[uml::Model|QualifiedName])?
		//	"," "pointcuts" "{" pointcuts+=Pointcut ("," pointcuts+=Pointcut)* "}"
		//	"," "compositions" "{" compositions+=Composition ("," compositions+=Composition)* "}"
		//	"}";
		@Override public ParserRule getRule() { return rule; }

		//"aspect" name=ID "{" "feature" feature=[fm::Feature|QualifiedName] ("," "advice" advice=[uml::Model|QualifiedName])? ","
		//"pointcuts" "{" pointcuts+=Pointcut ("," pointcuts+=Pointcut)* "}" "," "compositions" "{" compositions+=Composition
		//("," compositions+=Composition)* "}" "}"
		public Group getGroup() { return cGroup; }

		//"aspect"
		public Keyword getAspectKeyword_0() { return cAspectKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//"feature"
		public Keyword getFeatureKeyword_3() { return cFeatureKeyword_3; }

		//feature=[fm::Feature|QualifiedName]
		public Assignment getFeatureAssignment_4() { return cFeatureAssignment_4; }

		//[fm::Feature|QualifiedName]
		public CrossReference getFeatureFeatureCrossReference_4_0() { return cFeatureFeatureCrossReference_4_0; }

		//QualifiedName
		public RuleCall getFeatureFeatureQualifiedNameParserRuleCall_4_0_1() { return cFeatureFeatureQualifiedNameParserRuleCall_4_0_1; }

		//("," "advice" advice=[uml::Model|QualifiedName])?
		public Group getGroup_5() { return cGroup_5; }

		//","
		public Keyword getCommaKeyword_5_0() { return cCommaKeyword_5_0; }

		//"advice"
		public Keyword getAdviceKeyword_5_1() { return cAdviceKeyword_5_1; }

		//advice=[uml::Model|QualifiedName]
		public Assignment getAdviceAssignment_5_2() { return cAdviceAssignment_5_2; }

		//[uml::Model|QualifiedName]
		public CrossReference getAdviceModelCrossReference_5_2_0() { return cAdviceModelCrossReference_5_2_0; }

		//QualifiedName
		public RuleCall getAdviceModelQualifiedNameParserRuleCall_5_2_0_1() { return cAdviceModelQualifiedNameParserRuleCall_5_2_0_1; }

		//","
		public Keyword getCommaKeyword_6() { return cCommaKeyword_6; }

		//"pointcuts"
		public Keyword getPointcutsKeyword_7() { return cPointcutsKeyword_7; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_8() { return cLeftCurlyBracketKeyword_8; }

		//pointcuts+=Pointcut
		public Assignment getPointcutsAssignment_9() { return cPointcutsAssignment_9; }

		//Pointcut
		public RuleCall getPointcutsPointcutParserRuleCall_9_0() { return cPointcutsPointcutParserRuleCall_9_0; }

		//("," pointcuts+=Pointcut)*
		public Group getGroup_10() { return cGroup_10; }

		//","
		public Keyword getCommaKeyword_10_0() { return cCommaKeyword_10_0; }

		//pointcuts+=Pointcut
		public Assignment getPointcutsAssignment_10_1() { return cPointcutsAssignment_10_1; }

		//Pointcut
		public RuleCall getPointcutsPointcutParserRuleCall_10_1_0() { return cPointcutsPointcutParserRuleCall_10_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_11() { return cRightCurlyBracketKeyword_11; }

		//","
		public Keyword getCommaKeyword_12() { return cCommaKeyword_12; }

		//"compositions"
		public Keyword getCompositionsKeyword_13() { return cCompositionsKeyword_13; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_14() { return cLeftCurlyBracketKeyword_14; }

		//compositions+=Composition
		public Assignment getCompositionsAssignment_15() { return cCompositionsAssignment_15; }

		//Composition
		public RuleCall getCompositionsCompositionParserRuleCall_15_0() { return cCompositionsCompositionParserRuleCall_15_0; }

		//("," compositions+=Composition)*
		public Group getGroup_16() { return cGroup_16; }

		//","
		public Keyword getCommaKeyword_16_0() { return cCommaKeyword_16_0; }

		//compositions+=Composition
		public Assignment getCompositionsAssignment_16_1() { return cCompositionsAssignment_16_1; }

		//Composition
		public RuleCall getCompositionsCompositionParserRuleCall_16_1_0() { return cCompositionsCompositionParserRuleCall_16_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_17() { return cRightCurlyBracketKeyword_17; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_18() { return cRightCurlyBracketKeyword_18; }
	}

	public class PointcutElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.Pointcut");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPointcutKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cPatternKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cPatternAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cPatternPatternCrossReference_4_0 = (CrossReference)cPatternAssignment_4.eContents().get(0);
		private final RuleCall cPatternPatternQualifiedNameParserRuleCall_4_0_1 = (RuleCall)cPatternPatternCrossReference_4_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCommaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cRoleKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cRoleAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cRoleStereotypeCrossReference_5_2_0 = (CrossReference)cRoleAssignment_5_2.eContents().get(0);
		private final RuleCall cRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1 = (RuleCall)cRoleStereotypeCrossReference_5_2_0.eContents().get(1);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Pointcut:
		//	"pointcut" name=ID "{"
		//	"pattern" pattern=[pattern::Pattern|QualifiedName] ("," "role" role=[uml::Stereotype|QualifiedName])?
		//	"}";
		@Override public ParserRule getRule() { return rule; }

		//"pointcut" name=ID "{" "pattern" pattern=[pattern::Pattern|QualifiedName] ("," "role"
		//role=[uml::Stereotype|QualifiedName])? "}"
		public Group getGroup() { return cGroup; }

		//"pointcut"
		public Keyword getPointcutKeyword_0() { return cPointcutKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//"pattern"
		public Keyword getPatternKeyword_3() { return cPatternKeyword_3; }

		//pattern=[pattern::Pattern|QualifiedName]
		public Assignment getPatternAssignment_4() { return cPatternAssignment_4; }

		//[pattern::Pattern|QualifiedName]
		public CrossReference getPatternPatternCrossReference_4_0() { return cPatternPatternCrossReference_4_0; }

		//QualifiedName
		public RuleCall getPatternPatternQualifiedNameParserRuleCall_4_0_1() { return cPatternPatternQualifiedNameParserRuleCall_4_0_1; }

		//("," "role" role=[uml::Stereotype|QualifiedName])?
		public Group getGroup_5() { return cGroup_5; }

		//","
		public Keyword getCommaKeyword_5_0() { return cCommaKeyword_5_0; }

		//"role"
		public Keyword getRoleKeyword_5_1() { return cRoleKeyword_5_1; }

		//role=[uml::Stereotype|QualifiedName]
		public Assignment getRoleAssignment_5_2() { return cRoleAssignment_5_2; }

		//[uml::Stereotype|QualifiedName]
		public CrossReference getRoleStereotypeCrossReference_5_2_0() { return cRoleStereotypeCrossReference_5_2_0; }

		//QualifiedName
		public RuleCall getRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1() { return cRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class CompositionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.Composition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCompositionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cFeature_enabledKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cFeature_enabledAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cFeature_enabledEBOOLEANTerminalRuleCall_4_0 = (RuleCall)cFeature_enabledAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cCommaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cJointpointRoleKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cJointpointRoleAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cJointpointRoleStereotypeCrossReference_5_2_0 = (CrossReference)cJointpointRoleAssignment_5_2.eContents().get(0);
		private final RuleCall cJointpointRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1 = (RuleCall)cJointpointRoleStereotypeCrossReference_5_2_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cCommaKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Keyword cAdviceRoleKeyword_6_1 = (Keyword)cGroup_6.eContents().get(1);
		private final Assignment cAdviceAssignment_6_2 = (Assignment)cGroup_6.eContents().get(2);
		private final CrossReference cAdviceStereotypeCrossReference_6_2_0 = (CrossReference)cAdviceAssignment_6_2.eContents().get(0);
		private final RuleCall cAdviceStereotypeQualifiedNameParserRuleCall_6_2_0_1 = (RuleCall)cAdviceStereotypeCrossReference_6_2_0.eContents().get(1);
		private final Keyword cCommaKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cActionKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cActionAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cActionActionOptionTypeParserRuleCall_9_0 = (RuleCall)cActionAssignment_9.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);
		
		//Composition:
		//	"composition" name=ID "{"
		//	"feature_enabled" feature_enabled=EBOOLEAN ("," "jointpointRole" jointpointRole=[uml::Stereotype|QualifiedName])? (","
		//	"adviceRole" advice=[uml::Stereotype|QualifiedName])?
		//	"," "action" action=ActionOptionType
		//	"}";
		@Override public ParserRule getRule() { return rule; }

		//"composition" name=ID "{" "feature_enabled" feature_enabled=EBOOLEAN ("," "jointpointRole"
		//jointpointRole=[uml::Stereotype|QualifiedName])? ("," "adviceRole" advice=[uml::Stereotype|QualifiedName])? ","
		//"action" action=ActionOptionType "}"
		public Group getGroup() { return cGroup; }

		//"composition"
		public Keyword getCompositionKeyword_0() { return cCompositionKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//"feature_enabled"
		public Keyword getFeature_enabledKeyword_3() { return cFeature_enabledKeyword_3; }

		//feature_enabled=EBOOLEAN
		public Assignment getFeature_enabledAssignment_4() { return cFeature_enabledAssignment_4; }

		//EBOOLEAN
		public RuleCall getFeature_enabledEBOOLEANTerminalRuleCall_4_0() { return cFeature_enabledEBOOLEANTerminalRuleCall_4_0; }

		//("," "jointpointRole" jointpointRole=[uml::Stereotype|QualifiedName])?
		public Group getGroup_5() { return cGroup_5; }

		//","
		public Keyword getCommaKeyword_5_0() { return cCommaKeyword_5_0; }

		//"jointpointRole"
		public Keyword getJointpointRoleKeyword_5_1() { return cJointpointRoleKeyword_5_1; }

		//jointpointRole=[uml::Stereotype|QualifiedName]
		public Assignment getJointpointRoleAssignment_5_2() { return cJointpointRoleAssignment_5_2; }

		//[uml::Stereotype|QualifiedName]
		public CrossReference getJointpointRoleStereotypeCrossReference_5_2_0() { return cJointpointRoleStereotypeCrossReference_5_2_0; }

		//QualifiedName
		public RuleCall getJointpointRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1() { return cJointpointRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1; }

		//("," "adviceRole" advice=[uml::Stereotype|QualifiedName])?
		public Group getGroup_6() { return cGroup_6; }

		//","
		public Keyword getCommaKeyword_6_0() { return cCommaKeyword_6_0; }

		//"adviceRole"
		public Keyword getAdviceRoleKeyword_6_1() { return cAdviceRoleKeyword_6_1; }

		//advice=[uml::Stereotype|QualifiedName]
		public Assignment getAdviceAssignment_6_2() { return cAdviceAssignment_6_2; }

		//[uml::Stereotype|QualifiedName]
		public CrossReference getAdviceStereotypeCrossReference_6_2_0() { return cAdviceStereotypeCrossReference_6_2_0; }

		//QualifiedName
		public RuleCall getAdviceStereotypeQualifiedNameParserRuleCall_6_2_0_1() { return cAdviceStereotypeQualifiedNameParserRuleCall_6_2_0_1; }

		//","
		public Keyword getCommaKeyword_7() { return cCommaKeyword_7; }

		//"action"
		public Keyword getActionKeyword_8() { return cActionKeyword_8; }

		//action=ActionOptionType
		public Assignment getActionAssignment_9() { return cActionAssignment_9; }

		//ActionOptionType
		public RuleCall getActionActionOptionTypeParserRuleCall_9_0() { return cActionActionOptionTypeParserRuleCall_9_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}

	public class ActionOptionTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.ActionOptionType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cActionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUpdateValueParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//ActionOptionType:
		//	Action | UpdateValue;
		@Override public ParserRule getRule() { return rule; }

		//Action | UpdateValue
		public Alternatives getAlternatives() { return cAlternatives; }

		//Action
		public RuleCall getActionParserRuleCall_0() { return cActionParserRuleCall_0; }

		//UpdateValue
		public RuleCall getUpdateValueParserRuleCall_1() { return cUpdateValueParserRuleCall_1; }
	}

	public class UpdateValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.UpdateValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cUpdateValueKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//UpdateValue:
		//	'update value' value=STRING;
		@Override public ParserRule getRule() { return rule; }

		//'update value' value=STRING
		public Group getGroup() { return cGroup; }

		//'update value'
		public Keyword getUpdateValueKeyword_0() { return cUpdateValueKeyword_0; }

		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}

	public class ActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.Action");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cADDAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Keyword cADDAddKeyword_0_0 = (Keyword)cADDAssignment_0.eContents().get(0);
		private final Assignment cDELETEAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cDELETEDeleteKeyword_1_0 = (Keyword)cDELETEAssignment_1.eContents().get(0);
		private final Assignment cREPLACEAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final Keyword cREPLACEReplaceKeyword_2_0 = (Keyword)cREPLACEAssignment_2.eContents().get(0);
		private final Assignment cUPDATEAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final Keyword cUPDATEUpdateKeyword_3_0 = (Keyword)cUPDATEAssignment_3.eContents().get(0);
		
		//Action:
		//	ADD='add' | DELETE='delete' | REPLACE='replace' | UPDATE='update';
		@Override public ParserRule getRule() { return rule; }

		//ADD='add' | DELETE='delete' | REPLACE='replace' | UPDATE='update'
		public Alternatives getAlternatives() { return cAlternatives; }

		//ADD='add'
		public Assignment getADDAssignment_0() { return cADDAssignment_0; }

		//'add'
		public Keyword getADDAddKeyword_0_0() { return cADDAddKeyword_0_0; }

		//DELETE='delete'
		public Assignment getDELETEAssignment_1() { return cDELETEAssignment_1; }

		//'delete'
		public Keyword getDELETEDeleteKeyword_1_0() { return cDELETEDeleteKeyword_1_0; }

		//REPLACE='replace'
		public Assignment getREPLACEAssignment_2() { return cREPLACEAssignment_2; }

		//'replace'
		public Keyword getREPLACEReplaceKeyword_2_0() { return cREPLACEReplaceKeyword_2_0; }

		//UPDATE='update'
		public Assignment getUPDATEAssignment_3() { return cUPDATEAssignment_3; }

		//'update'
		public Keyword getUPDATEUpdateKeyword_3_0() { return cUPDATEUpdateKeyword_3_0; }
	}

	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//	ID (=> '.' ID)*;
		@Override public ParserRule getRule() { return rule; }

		//ID (=> '.' ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//(=> '.' ID)*
		public Group getGroup_1() { return cGroup_1; }

		//=> '.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final AspectElements pAspect;
	private final PointcutElements pPointcut;
	private final CompositionElements pComposition;
	private final ActionOptionTypeElements pActionOptionType;
	private final UpdateValueElements pUpdateValue;
	private final ActionElements pAction;
	private final QualifiedNameElements pQualifiedName;
	private final TerminalRule tEBOOLEAN;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public AspectGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pAspect = new AspectElements();
		this.pPointcut = new PointcutElements();
		this.pComposition = new CompositionElements();
		this.pActionOptionType = new ActionOptionTypeElements();
		this.pUpdateValue = new UpdateValueElements();
		this.pAction = new ActionElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.tEBOOLEAN = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "eu.supersede.dynadapt.dsl.Aspect.EBOOLEAN");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("eu.supersede.dynadapt.dsl.Aspect".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Aspect:
	//	"aspect" name=ID "{"
	//	"feature" feature=[fm::Feature|QualifiedName] ("," "advice" advice=[uml::Model|QualifiedName])?
	//	"," "pointcuts" "{" pointcuts+=Pointcut ("," pointcuts+=Pointcut)* "}"
	//	"," "compositions" "{" compositions+=Composition ("," compositions+=Composition)* "}"
	//	"}";
	public AspectElements getAspectAccess() {
		return pAspect;
	}
	
	public ParserRule getAspectRule() {
		return getAspectAccess().getRule();
	}

	//Pointcut:
	//	"pointcut" name=ID "{"
	//	"pattern" pattern=[pattern::Pattern|QualifiedName] ("," "role" role=[uml::Stereotype|QualifiedName])?
	//	"}";
	public PointcutElements getPointcutAccess() {
		return pPointcut;
	}
	
	public ParserRule getPointcutRule() {
		return getPointcutAccess().getRule();
	}

	//Composition:
	//	"composition" name=ID "{"
	//	"feature_enabled" feature_enabled=EBOOLEAN ("," "jointpointRole" jointpointRole=[uml::Stereotype|QualifiedName])? (","
	//	"adviceRole" advice=[uml::Stereotype|QualifiedName])?
	//	"," "action" action=ActionOptionType
	//	"}";
	public CompositionElements getCompositionAccess() {
		return pComposition;
	}
	
	public ParserRule getCompositionRule() {
		return getCompositionAccess().getRule();
	}

	//ActionOptionType:
	//	Action | UpdateValue;
	public ActionOptionTypeElements getActionOptionTypeAccess() {
		return pActionOptionType;
	}
	
	public ParserRule getActionOptionTypeRule() {
		return getActionOptionTypeAccess().getRule();
	}

	//UpdateValue:
	//	'update value' value=STRING;
	public UpdateValueElements getUpdateValueAccess() {
		return pUpdateValue;
	}
	
	public ParserRule getUpdateValueRule() {
		return getUpdateValueAccess().getRule();
	}

	//Action:
	//	ADD='add' | DELETE='delete' | REPLACE='replace' | UPDATE='update';
	public ActionElements getActionAccess() {
		return pAction;
	}
	
	public ParserRule getActionRule() {
		return getActionAccess().getRule();
	}

	//QualifiedName:
	//	ID (=> '.' ID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//terminal EBOOLEAN returns ecore::EBooleanObject:
	//	'true' | 'false';
	public TerminalRule getEBOOLEANRule() {
		return tEBOOLEAN;
	} 

	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	'/ *'->'* /';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
