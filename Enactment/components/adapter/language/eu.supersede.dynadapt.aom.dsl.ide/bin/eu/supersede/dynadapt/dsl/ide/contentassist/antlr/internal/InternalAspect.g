/*
 * generated by Xtext 2.9.1
 */
grammar InternalAspect;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@lexer::header {
package eu.supersede.dynadapt.dsl.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package eu.supersede.dynadapt.dsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import eu.supersede.dynadapt.dsl.services.AspectGrammarAccess;

}
@parser::members {
	private AspectGrammarAccess grammarAccess;

	public void setGrammarAccess(AspectGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleAspect
entryRuleAspect
:
{ before(grammarAccess.getAspectRule()); }
	 ruleAspect
{ after(grammarAccess.getAspectRule()); } 
	 EOF 
;

// Rule Aspect
ruleAspect 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAspectAccess().getGroup()); }
		(rule__Aspect__Group__0)
		{ after(grammarAccess.getAspectAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePointcut
entryRulePointcut
:
{ before(grammarAccess.getPointcutRule()); }
	 rulePointcut
{ after(grammarAccess.getPointcutRule()); } 
	 EOF 
;

// Rule Pointcut
rulePointcut 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPointcutAccess().getGroup()); }
		(rule__Pointcut__Group__0)
		{ after(grammarAccess.getPointcutAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleComposition
entryRuleComposition
:
{ before(grammarAccess.getCompositionRule()); }
	 ruleComposition
{ after(grammarAccess.getCompositionRule()); } 
	 EOF 
;

// Rule Composition
ruleComposition 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getCompositionAccess().getGroup()); }
		(rule__Composition__Group__0)
		{ after(grammarAccess.getCompositionAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAction
entryRuleAction
:
{ before(grammarAccess.getActionRule()); }
	 ruleAction
{ after(grammarAccess.getActionRule()); } 
	 EOF 
;

// Rule Action
ruleAction 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getActionAccess().getAlternatives()); }
		(rule__Action__Alternatives)
		{ after(grammarAccess.getActionAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
		(rule__QualifiedName__Group__0)
		{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Action__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getActionAccess().getAddKeyword_0()); }
		'add'
		{ after(grammarAccess.getActionAccess().getAddKeyword_0()); }
	)
	|
	(
		{ before(grammarAccess.getActionAccess().getDeleteKeyword_1()); }
		'delete'
		{ after(grammarAccess.getActionAccess().getDeleteKeyword_1()); }
	)
	|
	(
		{ before(grammarAccess.getActionAccess().getReplaceKeyword_2()); }
		'replace'
		{ after(grammarAccess.getActionAccess().getReplaceKeyword_2()); }
	)
	|
	(
		{ before(grammarAccess.getActionAccess().getAssociateKeyword_3()); }
		'associate'
		{ after(grammarAccess.getActionAccess().getAssociateKeyword_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__0__Impl
	rule__Aspect__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getAspectKeyword_0()); }
	'aspect'
	{ after(grammarAccess.getAspectAccess().getAspectKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__1__Impl
	rule__Aspect__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getNameAssignment_1()); }
	(rule__Aspect__NameAssignment_1)
	{ after(grammarAccess.getAspectAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__2__Impl
	rule__Aspect__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__3__Impl
	rule__Aspect__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getFeatureKeyword_3()); }
	'feature'
	{ after(grammarAccess.getAspectAccess().getFeatureKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__4__Impl
	rule__Aspect__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getFeatureAssignment_4()); }
	(rule__Aspect__FeatureAssignment_4)
	{ after(grammarAccess.getAspectAccess().getFeatureAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__5__Impl
	rule__Aspect__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCommaKeyword_5()); }
	','
	{ after(grammarAccess.getAspectAccess().getCommaKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__6__Impl
	rule__Aspect__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getAdviceKeyword_6()); }
	'advice'
	{ after(grammarAccess.getAspectAccess().getAdviceKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__7__Impl
	rule__Aspect__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getAdviceAssignment_7()); }
	(rule__Aspect__AdviceAssignment_7)
	{ after(grammarAccess.getAspectAccess().getAdviceAssignment_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__8__Impl
	rule__Aspect__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCommaKeyword_8()); }
	','
	{ after(grammarAccess.getAspectAccess().getCommaKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__9__Impl
	rule__Aspect__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getPointcutsKeyword_9()); }
	'pointcuts'
	{ after(grammarAccess.getAspectAccess().getPointcutsKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__10__Impl
	rule__Aspect__Group__11
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_10()); }
	'{'
	{ after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__11
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__11__Impl
	rule__Aspect__Group__12
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__11__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getPointcutsAssignment_11()); }
	(rule__Aspect__PointcutsAssignment_11)
	{ after(grammarAccess.getAspectAccess().getPointcutsAssignment_11()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__12
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__12__Impl
	rule__Aspect__Group__13
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__12__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getGroup_12()); }
	(rule__Aspect__Group_12__0)*
	{ after(grammarAccess.getAspectAccess().getGroup_12()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__13
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__13__Impl
	rule__Aspect__Group__14
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__13__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_13()); }
	'}'
	{ after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_13()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__14
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__14__Impl
	rule__Aspect__Group__15
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__14__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCommaKeyword_14()); }
	','
	{ after(grammarAccess.getAspectAccess().getCommaKeyword_14()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__15
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__15__Impl
	rule__Aspect__Group__16
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__15__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCompositionsKeyword_15()); }
	'compositions'
	{ after(grammarAccess.getAspectAccess().getCompositionsKeyword_15()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__16
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__16__Impl
	rule__Aspect__Group__17
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__16__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_16()); }
	'{'
	{ after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_16()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__17
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__17__Impl
	rule__Aspect__Group__18
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__17__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCompositionsAssignment_17()); }
	(rule__Aspect__CompositionsAssignment_17)
	{ after(grammarAccess.getAspectAccess().getCompositionsAssignment_17()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__18
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__18__Impl
	rule__Aspect__Group__19
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__18__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getGroup_18()); }
	(rule__Aspect__Group_18__0)*
	{ after(grammarAccess.getAspectAccess().getGroup_18()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__19
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__19__Impl
	rule__Aspect__Group__20
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__19__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_19()); }
	'}'
	{ after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_19()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__20
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group__20__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group__20__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_20()); }
	'}'
	{ after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_20()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__Group_12__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_12__0__Impl
	rule__Aspect__Group_12__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_12__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCommaKeyword_12_0()); }
	','
	{ after(grammarAccess.getAspectAccess().getCommaKeyword_12_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_12__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_12__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getPointcutsAssignment_12_1()); }
	(rule__Aspect__PointcutsAssignment_12_1)
	{ after(grammarAccess.getAspectAccess().getPointcutsAssignment_12_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__Group_18__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_18__0__Impl
	rule__Aspect__Group_18__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_18__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCommaKeyword_18_0()); }
	','
	{ after(grammarAccess.getAspectAccess().getCommaKeyword_18_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_18__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Aspect__Group_18__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__Group_18__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getAspectAccess().getCompositionsAssignment_18_1()); }
	(rule__Aspect__CompositionsAssignment_18_1)
	{ after(grammarAccess.getAspectAccess().getCompositionsAssignment_18_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Pointcut__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group__0__Impl
	rule__Pointcut__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getPointcutKeyword_0()); }
	'pointcut'
	{ after(grammarAccess.getPointcutAccess().getPointcutKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group__1__Impl
	rule__Pointcut__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getNameAssignment_1()); }
	(rule__Pointcut__NameAssignment_1)
	{ after(grammarAccess.getPointcutAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group__2__Impl
	rule__Pointcut__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getPointcutAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group__3__Impl
	rule__Pointcut__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getPatternKeyword_3()); }
	'pattern'
	{ after(grammarAccess.getPointcutAccess().getPatternKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group__4__Impl
	rule__Pointcut__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getPatternAssignment_4()); }
	(rule__Pointcut__PatternAssignment_4)
	{ after(grammarAccess.getPointcutAccess().getPatternAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group__5__Impl
	rule__Pointcut__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getGroup_5()); }
	(rule__Pointcut__Group_5__0)?
	{ after(grammarAccess.getPointcutAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getRightCurlyBracketKeyword_6()); }
	'}'
	{ after(grammarAccess.getPointcutAccess().getRightCurlyBracketKeyword_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Pointcut__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group_5__0__Impl
	rule__Pointcut__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getCommaKeyword_5_0()); }
	','
	{ after(grammarAccess.getPointcutAccess().getCommaKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group_5__1__Impl
	rule__Pointcut__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getRoleKeyword_5_1()); }
	'role'
	{ after(grammarAccess.getPointcutAccess().getRoleKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Pointcut__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPointcutAccess().getRoleAssignment_5_2()); }
	(rule__Pointcut__RoleAssignment_5_2)
	{ after(grammarAccess.getPointcutAccess().getRoleAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Composition__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__0__Impl
	rule__Composition__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getCompositionKeyword_0()); }
	'composition'
	{ after(grammarAccess.getCompositionAccess().getCompositionKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__1__Impl
	rule__Composition__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getNameAssignment_1()); }
	(rule__Composition__NameAssignment_1)
	{ after(grammarAccess.getCompositionAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__2__Impl
	rule__Composition__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__3__Impl
	rule__Composition__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getFeature_enabledKeyword_3()); }
	'feature_enabled'
	{ after(grammarAccess.getCompositionAccess().getFeature_enabledKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__4__Impl
	rule__Composition__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getFeature_enabledAssignment_4()); }
	(rule__Composition__Feature_enabledAssignment_4)
	{ after(grammarAccess.getCompositionAccess().getFeature_enabledAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__5__Impl
	rule__Composition__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getGroup_5()); }
	(rule__Composition__Group_5__0)?
	{ after(grammarAccess.getCompositionAccess().getGroup_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__6__Impl
	rule__Composition__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getGroup_6()); }
	(rule__Composition__Group_6__0)?
	{ after(grammarAccess.getCompositionAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__7__Impl
	rule__Composition__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getCommaKeyword_7()); }
	','
	{ after(grammarAccess.getCompositionAccess().getCommaKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__8__Impl
	rule__Composition__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getActionKeyword_8()); }
	'action'
	{ after(grammarAccess.getCompositionAccess().getActionKeyword_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__9__Impl
	rule__Composition__Group__10
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getActionAssignment_9()); }
	(rule__Composition__ActionAssignment_9)
	{ after(grammarAccess.getCompositionAccess().getActionAssignment_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__10
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group__10__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group__10__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_10()); }
	'}'
	{ after(grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_10()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Composition__Group_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group_5__0__Impl
	rule__Composition__Group_5__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getCommaKeyword_5_0()); }
	','
	{ after(grammarAccess.getCompositionAccess().getCommaKeyword_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_5__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group_5__1__Impl
	rule__Composition__Group_5__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_5__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getJointpointRoleKeyword_5_1()); }
	'jointpointRole'
	{ after(grammarAccess.getCompositionAccess().getJointpointRoleKeyword_5_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_5__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group_5__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_5__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getJointpointRoleAssignment_5_2()); }
	(rule__Composition__JointpointRoleAssignment_5_2)
	{ after(grammarAccess.getCompositionAccess().getJointpointRoleAssignment_5_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Composition__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group_6__0__Impl
	rule__Composition__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getCommaKeyword_6_0()); }
	','
	{ after(grammarAccess.getCompositionAccess().getCommaKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group_6__1__Impl
	rule__Composition__Group_6__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getAdviceRoleKeyword_6_1()); }
	'adviceRole'
	{ after(grammarAccess.getCompositionAccess().getAdviceRoleKeyword_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_6__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Composition__Group_6__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Group_6__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getCompositionAccess().getAdviceAssignment_6_2()); }
	(rule__Composition__AdviceAssignment_6_2)
	{ after(grammarAccess.getCompositionAccess().getAdviceAssignment_6_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
	{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
	(rule__QualifiedName__Group_1__0)*
	{ after(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__0__Impl
	rule__QualifiedName__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
	('.')
	{ after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
	{ after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Aspect__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__FeatureAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); }
		(
			{ before(grammarAccess.getAspectAccess().getFeatureFeatureQualifiedNameParserRuleCall_4_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getAspectAccess().getFeatureFeatureQualifiedNameParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__AdviceAssignment_7
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getAdviceModelCrossReference_7_0()); }
		(
			{ before(grammarAccess.getAspectAccess().getAdviceModelQualifiedNameParserRuleCall_7_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getAspectAccess().getAdviceModelQualifiedNameParserRuleCall_7_0_1()); }
		)
		{ after(grammarAccess.getAspectAccess().getAdviceModelCrossReference_7_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__PointcutsAssignment_11
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_11_0()); }
		rulePointcut
		{ after(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_11_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__PointcutsAssignment_12_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_12_1_0()); }
		rulePointcut
		{ after(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_12_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__CompositionsAssignment_17
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_17_0()); }
		ruleComposition
		{ after(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_17_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Aspect__CompositionsAssignment_18_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_18_1_0()); }
		ruleComposition
		{ after(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_18_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPointcutAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getPointcutAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__PatternAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); }
		(
			{ before(grammarAccess.getPointcutAccess().getPatternPatternQualifiedNameParserRuleCall_4_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getPointcutAccess().getPatternPatternQualifiedNameParserRuleCall_4_0_1()); }
		)
		{ after(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Pointcut__RoleAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); }
		(
			{ before(grammarAccess.getPointcutAccess().getRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getPointcutAccess().getRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); }
		)
		{ after(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__Feature_enabledAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCompositionAccess().getFeature_enabledEBOOLEANTerminalRuleCall_4_0()); }
		RULE_EBOOLEAN
		{ after(grammarAccess.getCompositionAccess().getFeature_enabledEBOOLEANTerminalRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__JointpointRoleAssignment_5_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); }
		(
			{ before(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); }
		)
		{ after(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__AdviceAssignment_6_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); }
		(
			{ before(grammarAccess.getCompositionAccess().getAdviceStereotypeQualifiedNameParserRuleCall_6_2_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getCompositionAccess().getAdviceStereotypeQualifiedNameParserRuleCall_6_2_0_1()); }
		)
		{ after(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Composition__ActionAssignment_9
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getCompositionAccess().getActionActionParserRuleCall_9_0()); }
		ruleAction
		{ after(grammarAccess.getCompositionAccess().getActionActionParserRuleCall_9_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_EBOOLEAN : ('true'|'false');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
