/*
 * generated by Xtext
 */
grammar InternalAspect;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package eu.supersede.dynadapt.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package eu.supersede.dynadapt.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import eu.supersede.dynadapt.dsl.services.AspectGrammarAccess;

}

@parser::members {

 	private AspectGrammarAccess grammarAccess;
 	
    public InternalAspectParser(TokenStream input, AspectGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Aspect";	
   	}
   	
   	@Override
   	protected AspectGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleAspect
entryRuleAspect returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAspectRule()); }
	 iv_ruleAspect=ruleAspect 
	 { $current=$iv_ruleAspect.current; } 
	 EOF 
;

// Rule Aspect
ruleAspect returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='aspect' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAspectAccess().getAspectKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAspectRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2());
    }
	otherlv_3='feature' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getAspectAccess().getFeatureKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAspectRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getAspectAccess().getCommaKeyword_5_0());
    }
	otherlv_6='advice' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAspectAccess().getAdviceKeyword_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAspectRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAspectAccess().getAdviceModelCrossReference_5_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getAspectAccess().getCommaKeyword_6());
    }
	otherlv_9='pointcuts' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getAspectAccess().getPointcutsKeyword_7());
    }
	otherlv_10='{' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_8());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_9_0()); 
	    }
		lv_pointcuts_11_0=rulePointcut		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAspectRule());
	        }
       		add(
       			$current, 
       			"pointcuts",
        		lv_pointcuts_11_0, 
        		"eu.supersede.dynadapt.dsl.Aspect.Pointcut");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_12=',' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getAspectAccess().getCommaKeyword_10_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_10_1_0()); 
	    }
		lv_pointcuts_13_0=rulePointcut		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAspectRule());
	        }
       		add(
       			$current, 
       			"pointcuts",
        		lv_pointcuts_13_0, 
        		"eu.supersede.dynadapt.dsl.Aspect.Pointcut");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_14='}' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_11());
    }
	otherlv_15=',' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getAspectAccess().getCommaKeyword_12());
    }
	otherlv_16='compositions' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getAspectAccess().getCompositionsKeyword_13());
    }
	otherlv_17='{' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_14());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_15_0()); 
	    }
		lv_compositions_18_0=ruleComposition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAspectRule());
	        }
       		add(
       			$current, 
       			"compositions",
        		lv_compositions_18_0, 
        		"eu.supersede.dynadapt.dsl.Aspect.Composition");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_19=',' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getAspectAccess().getCommaKeyword_16_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_16_1_0()); 
	    }
		lv_compositions_20_0=ruleComposition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAspectRule());
	        }
       		add(
       			$current, 
       			"compositions",
        		lv_compositions_20_0, 
        		"eu.supersede.dynadapt.dsl.Aspect.Composition");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_21='}' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_17());
    }
	otherlv_22='}' 
    {
    	newLeafNode(otherlv_22, grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_18());
    }
)
;





// Entry rule entryRulePointcut
entryRulePointcut returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPointcutRule()); }
	 iv_rulePointcut=rulePointcut 
	 { $current=$iv_rulePointcut.current; } 
	 EOF 
;

// Rule Pointcut
rulePointcut returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='pointcut' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPointcutAccess().getPointcutKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getPointcutAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPointcutRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getPointcutAccess().getLeftCurlyBracketKeyword_2());
    }
	otherlv_3='pattern' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getPointcutAccess().getPatternKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPointcutRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getPointcutAccess().getCommaKeyword_5_0());
    }
	otherlv_6='role' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getPointcutAccess().getRoleKeyword_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPointcutRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_8='}' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getPointcutAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleComposition
entryRuleComposition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCompositionRule()); }
	 iv_ruleComposition=ruleComposition 
	 { $current=$iv_ruleComposition.current; } 
	 EOF 
;

// Rule Composition
ruleComposition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='composition' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getCompositionAccess().getCompositionKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCompositionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"org.eclipse.xtext.common.Terminals.ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_2());
    }
	otherlv_3='feature_enabled' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getCompositionAccess().getFeature_enabledKeyword_3());
    }
(
(
		lv_feature_enabled_4_0=RULE_EBOOLEAN
		{
			newLeafNode(lv_feature_enabled_4_0, grammarAccess.getCompositionAccess().getFeature_enabledEBOOLEANTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCompositionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"feature_enabled",
        		lv_feature_enabled_4_0, 
        		"eu.supersede.dynadapt.dsl.Aspect.EBOOLEAN");
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getCompositionAccess().getCommaKeyword_5_0());
    }
	otherlv_6='jointpointRole' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getCompositionAccess().getJointpointRoleKeyword_5_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCompositionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getCompositionAccess().getCommaKeyword_6_0());
    }
	otherlv_9='adviceRole' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getCompositionAccess().getAdviceRoleKeyword_6_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCompositionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?	otherlv_11=',' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getCompositionAccess().getCommaKeyword_7());
    }
	otherlv_12='action' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getCompositionAccess().getActionKeyword_8());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getCompositionAccess().getActionActionOptionTypeParserRuleCall_9_0()); 
	    }
		lv_action_13_0=ruleActionOptionType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCompositionRule());
	        }
       		set(
       			$current, 
       			"action",
        		lv_action_13_0, 
        		"eu.supersede.dynadapt.dsl.Aspect.ActionOptionType");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_14='}' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_10());
    }
)
;





// Entry rule entryRuleActionOptionType
entryRuleActionOptionType returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getActionOptionTypeRule()); }
	 iv_ruleActionOptionType=ruleActionOptionType 
	 { $current=$iv_ruleActionOptionType.current; } 
	 EOF 
;

// Rule ActionOptionType
ruleActionOptionType returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getActionOptionTypeAccess().getActionParserRuleCall_0()); 
    }
    this_Action_0=ruleAction
    { 
        $current = $this_Action_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getActionOptionTypeAccess().getUpdateValueParserRuleCall_1()); 
    }
    this_UpdateValue_1=ruleUpdateValue
    { 
        $current = $this_UpdateValue_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleUpdateValue
entryRuleUpdateValue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUpdateValueRule()); }
	 iv_ruleUpdateValue=ruleUpdateValue 
	 { $current=$iv_ruleUpdateValue.current; } 
	 EOF 
;

// Rule UpdateValue
ruleUpdateValue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='update value' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getUpdateValueAccess().getUpdateValueKeyword_0());
    }
(
(
		lv_value_1_0=RULE_STRING
		{
			newLeafNode(lv_value_1_0, grammarAccess.getUpdateValueAccess().getValueSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUpdateValueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_1_0, 
        		"org.eclipse.xtext.common.Terminals.STRING");
	    }

)
))
;





// Entry rule entryRuleAction
entryRuleAction returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getActionRule()); }
	 iv_ruleAction=ruleAction 
	 { $current=$iv_ruleAction.current; } 
	 EOF 
;

// Rule Action
ruleAction returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_ADD_0_0=	'add' 
    {
        newLeafNode(lv_ADD_0_0, grammarAccess.getActionAccess().getADDAddKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getActionRule());
	        }
       		setWithLastConsumed($current, "ADD", lv_ADD_0_0, "add");
	    }

)
)
    |(
(
		lv_DELETE_1_0=	'delete' 
    {
        newLeafNode(lv_DELETE_1_0, grammarAccess.getActionAccess().getDELETEDeleteKeyword_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getActionRule());
	        }
       		setWithLastConsumed($current, "DELETE", lv_DELETE_1_0, "delete");
	    }

)
)
    |(
(
		lv_REPLACE_2_0=	'replace' 
    {
        newLeafNode(lv_REPLACE_2_0, grammarAccess.getActionAccess().getREPLACEReplaceKeyword_2_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getActionRule());
	        }
       		setWithLastConsumed($current, "REPLACE", lv_REPLACE_2_0, "replace");
	    }

)
)
    |(
(
		lv_UPDATE_3_0=	'update' 
    {
        newLeafNode(lv_UPDATE_3_0, grammarAccess.getActionAccess().getUPDATEUpdateKeyword_3_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getActionRule());
	        }
       		setWithLastConsumed($current, "UPDATE", lv_UPDATE_3_0, "update");
	    }

)
))
;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(((
	'.' 
)=>
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
)    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





RULE_EBOOLEAN : ('true'|'false');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


