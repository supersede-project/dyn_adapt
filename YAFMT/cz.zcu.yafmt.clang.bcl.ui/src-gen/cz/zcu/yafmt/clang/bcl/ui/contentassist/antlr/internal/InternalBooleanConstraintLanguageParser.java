package cz.zcu.yafmt.clang.bcl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import cz.zcu.yafmt.clang.bcl.services.BooleanConstraintLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBooleanConstraintLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'forall'", "':'", "'exists'", "'equals'", "'implies'", "'or'", "'and'", "'not'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBooleanConstraintLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBooleanConstraintLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBooleanConstraintLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g"; }


     
     	private BooleanConstraintLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(BooleanConstraintLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleExpression"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:60:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:61:1: ( ruleExpression EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:62:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression61);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:69:1: ruleExpression : ( ruleContextualExpression ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:73:2: ( ( ruleContextualExpression ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:74:1: ( ruleContextualExpression )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:74:1: ( ruleContextualExpression )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:75:1: ruleContextualExpression
            {
             before(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall()); 
            pushFollow(FOLLOW_ruleContextualExpression_in_ruleExpression94);
            ruleContextualExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getContextualExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleContextualExpression"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:88:1: entryRuleContextualExpression : ruleContextualExpression EOF ;
    public final void entryRuleContextualExpression() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:89:1: ( ruleContextualExpression EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:90:1: ruleContextualExpression EOF
            {
             before(grammarAccess.getContextualExpressionRule()); 
            pushFollow(FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression120);
            ruleContextualExpression();

            state._fsp--;

             after(grammarAccess.getContextualExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextualExpression127); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContextualExpression"


    // $ANTLR start "ruleContextualExpression"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:97:1: ruleContextualExpression : ( ( rule__ContextualExpression__Alternatives ) ) ;
    public final void ruleContextualExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:101:2: ( ( ( rule__ContextualExpression__Alternatives ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Alternatives ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:102:1: ( ( rule__ContextualExpression__Alternatives ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:103:1: ( rule__ContextualExpression__Alternatives )
            {
             before(grammarAccess.getContextualExpressionAccess().getAlternatives()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:104:1: ( rule__ContextualExpression__Alternatives )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:104:2: rule__ContextualExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Alternatives_in_ruleContextualExpression153);
            rule__ContextualExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContextualExpression"


    // $ANTLR start "entryRuleEquation"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:116:1: entryRuleEquation : ruleEquation EOF ;
    public final void entryRuleEquation() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:117:1: ( ruleEquation EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:118:1: ruleEquation EOF
            {
             before(grammarAccess.getEquationRule()); 
            pushFollow(FOLLOW_ruleEquation_in_entryRuleEquation180);
            ruleEquation();

            state._fsp--;

             after(grammarAccess.getEquationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquation187); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEquation"


    // $ANTLR start "ruleEquation"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:125:1: ruleEquation : ( ( rule__Equation__Group__0 ) ) ;
    public final void ruleEquation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:129:2: ( ( ( rule__Equation__Group__0 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:130:1: ( ( rule__Equation__Group__0 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:130:1: ( ( rule__Equation__Group__0 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:131:1: ( rule__Equation__Group__0 )
            {
             before(grammarAccess.getEquationAccess().getGroup()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:132:1: ( rule__Equation__Group__0 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:132:2: rule__Equation__Group__0
            {
            pushFollow(FOLLOW_rule__Equation__Group__0_in_ruleEquation213);
            rule__Equation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEquationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquation"


    // $ANTLR start "entryRuleImplication"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:144:1: entryRuleImplication : ruleImplication EOF ;
    public final void entryRuleImplication() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:145:1: ( ruleImplication EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:146:1: ruleImplication EOF
            {
             before(grammarAccess.getImplicationRule()); 
            pushFollow(FOLLOW_ruleImplication_in_entryRuleImplication240);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getImplicationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplication247); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImplication"


    // $ANTLR start "ruleImplication"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:153:1: ruleImplication : ( ( rule__Implication__Group__0 ) ) ;
    public final void ruleImplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:157:2: ( ( ( rule__Implication__Group__0 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:158:1: ( ( rule__Implication__Group__0 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:158:1: ( ( rule__Implication__Group__0 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:159:1: ( rule__Implication__Group__0 )
            {
             before(grammarAccess.getImplicationAccess().getGroup()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:160:1: ( rule__Implication__Group__0 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:160:2: rule__Implication__Group__0
            {
            pushFollow(FOLLOW_rule__Implication__Group__0_in_ruleImplication273);
            rule__Implication__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImplicationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImplication"


    // $ANTLR start "entryRuleDisjunction"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:172:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:173:1: ( ruleDisjunction EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:174:1: ruleDisjunction EOF
            {
             before(grammarAccess.getDisjunctionRule()); 
            pushFollow(FOLLOW_ruleDisjunction_in_entryRuleDisjunction300);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisjunction307); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:181:1: ruleDisjunction : ( ( rule__Disjunction__Group__0 ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:185:2: ( ( ( rule__Disjunction__Group__0 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:186:1: ( ( rule__Disjunction__Group__0 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:186:1: ( ( rule__Disjunction__Group__0 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:187:1: ( rule__Disjunction__Group__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:188:1: ( rule__Disjunction__Group__0 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:188:2: rule__Disjunction__Group__0
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__0_in_ruleDisjunction333);
            rule__Disjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:200:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:201:1: ( ruleConjunction EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:202:1: ruleConjunction EOF
            {
             before(grammarAccess.getConjunctionRule()); 
            pushFollow(FOLLOW_ruleConjunction_in_entryRuleConjunction360);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getConjunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConjunction367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:209:1: ruleConjunction : ( ( rule__Conjunction__Group__0 ) ) ;
    public final void ruleConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:213:2: ( ( ( rule__Conjunction__Group__0 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:214:1: ( ( rule__Conjunction__Group__0 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:214:1: ( ( rule__Conjunction__Group__0 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:215:1: ( rule__Conjunction__Group__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:216:1: ( rule__Conjunction__Group__0 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:216:2: rule__Conjunction__Group__0
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__0_in_ruleConjunction393);
            rule__Conjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRuleNegation"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:228:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:229:1: ( ruleNegation EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:230:1: ruleNegation EOF
            {
             before(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation420);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:237:1: ruleNegation : ( ( rule__Negation__Alternatives ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:241:2: ( ( ( rule__Negation__Alternatives ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:242:1: ( ( rule__Negation__Alternatives ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:242:1: ( ( rule__Negation__Alternatives ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:243:1: ( rule__Negation__Alternatives )
            {
             before(grammarAccess.getNegationAccess().getAlternatives()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:244:1: ( rule__Negation__Alternatives )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:244:2: rule__Negation__Alternatives
            {
            pushFollow(FOLLOW_rule__Negation__Alternatives_in_ruleNegation453);
            rule__Negation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:256:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:257:1: ( rulePrimaryExpression EOF )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:258:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression480);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression487); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:265:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:269:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:270:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:270:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:271:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:272:1: ( rule__PrimaryExpression__Alternatives )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:272:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression513);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "rule__ContextualExpression__Alternatives"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:284:1: rule__ContextualExpression__Alternatives : ( ( ( rule__ContextualExpression__Group_0__0 ) ) | ( ( rule__ContextualExpression__Group_1__0 ) ) | ( ruleEquation ) );
    public final void rule__ContextualExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:288:1: ( ( ( rule__ContextualExpression__Group_0__0 ) ) | ( ( rule__ContextualExpression__Group_1__0 ) ) | ( ruleEquation ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case RULE_ID:
            case 18:
            case 19:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:289:1: ( ( rule__ContextualExpression__Group_0__0 ) )
                    {
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:289:1: ( ( rule__ContextualExpression__Group_0__0 ) )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:290:1: ( rule__ContextualExpression__Group_0__0 )
                    {
                     before(grammarAccess.getContextualExpressionAccess().getGroup_0()); 
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:291:1: ( rule__ContextualExpression__Group_0__0 )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:291:2: rule__ContextualExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ContextualExpression__Group_0__0_in_rule__ContextualExpression__Alternatives549);
                    rule__ContextualExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getContextualExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:295:6: ( ( rule__ContextualExpression__Group_1__0 ) )
                    {
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:295:6: ( ( rule__ContextualExpression__Group_1__0 ) )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:296:1: ( rule__ContextualExpression__Group_1__0 )
                    {
                     before(grammarAccess.getContextualExpressionAccess().getGroup_1()); 
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:297:1: ( rule__ContextualExpression__Group_1__0 )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:297:2: rule__ContextualExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ContextualExpression__Group_1__0_in_rule__ContextualExpression__Alternatives567);
                    rule__ContextualExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getContextualExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:301:6: ( ruleEquation )
                    {
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:301:6: ( ruleEquation )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:302:1: ruleEquation
                    {
                     before(grammarAccess.getContextualExpressionAccess().getEquationParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleEquation_in_rule__ContextualExpression__Alternatives585);
                    ruleEquation();

                    state._fsp--;

                     after(grammarAccess.getContextualExpressionAccess().getEquationParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Alternatives"


    // $ANTLR start "rule__Negation__Alternatives"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:312:1: rule__Negation__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:316:1: ( ( rulePrimaryExpression ) | ( ( rule__Negation__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||LA2_0==19) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:317:1: ( rulePrimaryExpression )
                    {
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:317:1: ( rulePrimaryExpression )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:318:1: rulePrimaryExpression
                    {
                     before(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__Alternatives617);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getNegationAccess().getPrimaryExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:323:6: ( ( rule__Negation__Group_1__0 ) )
                    {
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:323:6: ( ( rule__Negation__Group_1__0 ) )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:324:1: ( rule__Negation__Group_1__0 )
                    {
                     before(grammarAccess.getNegationAccess().getGroup_1()); 
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:325:1: ( rule__Negation__Group_1__0 )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:325:2: rule__Negation__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Negation__Group_1__0_in_rule__Negation__Alternatives634);
                    rule__Negation__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNegationAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Alternatives"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:334:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:338:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:339:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:339:1: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:340:1: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:341:1: ( rule__PrimaryExpression__Group_0__0 )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:341:2: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives667);
                    rule__PrimaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:345:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:345:6: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:346:1: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:347:1: ( rule__PrimaryExpression__Group_1__0 )
                    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:347:2: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives685);
                    rule__PrimaryExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__ContextualExpression__Group_0__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:358:1: rule__ContextualExpression__Group_0__0 : rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 ;
    public final void rule__ContextualExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:362:1: ( rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:363:2: rule__ContextualExpression__Group_0__0__Impl rule__ContextualExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__0__Impl_in_rule__ContextualExpression__Group_0__0716);
            rule__ContextualExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__1_in_rule__ContextualExpression__Group_0__0719);
            rule__ContextualExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__0"


    // $ANTLR start "rule__ContextualExpression__Group_0__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:370:1: rule__ContextualExpression__Group_0__0__Impl : ( 'forall' ) ;
    public final void rule__ContextualExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:374:1: ( ( 'forall' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:375:1: ( 'forall' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:375:1: ( 'forall' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:376:1: 'forall'
            {
             before(grammarAccess.getContextualExpressionAccess().getForallKeyword_0_0()); 
            match(input,11,FOLLOW_11_in_rule__ContextualExpression__Group_0__0__Impl747); 
             after(grammarAccess.getContextualExpressionAccess().getForallKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__0__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:389:1: rule__ContextualExpression__Group_0__1 : rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 ;
    public final void rule__ContextualExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:393:1: ( rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:394:2: rule__ContextualExpression__Group_0__1__Impl rule__ContextualExpression__Group_0__2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__1__Impl_in_rule__ContextualExpression__Group_0__1778);
            rule__ContextualExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__2_in_rule__ContextualExpression__Group_0__1781);
            rule__ContextualExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__1"


    // $ANTLR start "rule__ContextualExpression__Group_0__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:401:1: rule__ContextualExpression__Group_0__1__Impl : ( () ) ;
    public final void rule__ContextualExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:405:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:406:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:406:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:407:1: ()
            {
             before(grammarAccess.getContextualExpressionAccess().getForAllContextualExpressionAction_0_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:408:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:410:1: 
            {
            }

             after(grammarAccess.getContextualExpressionAccess().getForAllContextualExpressionAction_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__1__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:420:1: rule__ContextualExpression__Group_0__2 : rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 ;
    public final void rule__ContextualExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:424:1: ( rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:425:2: rule__ContextualExpression__Group_0__2__Impl rule__ContextualExpression__Group_0__3
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__2__Impl_in_rule__ContextualExpression__Group_0__2839);
            rule__ContextualExpression__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__3_in_rule__ContextualExpression__Group_0__2842);
            rule__ContextualExpression__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__2"


    // $ANTLR start "rule__ContextualExpression__Group_0__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:432:1: rule__ContextualExpression__Group_0__2__Impl : ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) ;
    public final void rule__ContextualExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:436:1: ( ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:437:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:437:1: ( ( rule__ContextualExpression__ContextIdAssignment_0_2 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:438:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:439:1: ( rule__ContextualExpression__ContextIdAssignment_0_2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:439:2: rule__ContextualExpression__ContextIdAssignment_0_2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ContextIdAssignment_0_2_in_rule__ContextualExpression__Group_0__2__Impl869);
            rule__ContextualExpression__ContextIdAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__2__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__3"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:449:1: rule__ContextualExpression__Group_0__3 : rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 ;
    public final void rule__ContextualExpression__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:453:1: ( rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:454:2: rule__ContextualExpression__Group_0__3__Impl rule__ContextualExpression__Group_0__4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__3__Impl_in_rule__ContextualExpression__Group_0__3899);
            rule__ContextualExpression__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__4_in_rule__ContextualExpression__Group_0__3902);
            rule__ContextualExpression__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__3"


    // $ANTLR start "rule__ContextualExpression__Group_0__3__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:461:1: rule__ContextualExpression__Group_0__3__Impl : ( ':' ) ;
    public final void rule__ContextualExpression__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:465:1: ( ( ':' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:466:1: ( ':' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:466:1: ( ':' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:467:1: ':'
            {
             before(grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3()); 
            match(input,12,FOLLOW_12_in_rule__ContextualExpression__Group_0__3__Impl930); 
             after(grammarAccess.getContextualExpressionAccess().getColonKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__3__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_0__4"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:480:1: rule__ContextualExpression__Group_0__4 : rule__ContextualExpression__Group_0__4__Impl ;
    public final void rule__ContextualExpression__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:484:1: ( rule__ContextualExpression__Group_0__4__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:485:2: rule__ContextualExpression__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_0__4__Impl_in_rule__ContextualExpression__Group_0__4961);
            rule__ContextualExpression__Group_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__4"


    // $ANTLR start "rule__ContextualExpression__Group_0__4__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:491:1: rule__ContextualExpression__Group_0__4__Impl : ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) ;
    public final void rule__ContextualExpression__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:495:1: ( ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:496:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:496:1: ( ( rule__ContextualExpression__ExpressionAssignment_0_4 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:497:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:498:1: ( rule__ContextualExpression__ExpressionAssignment_0_4 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:498:2: rule__ContextualExpression__ExpressionAssignment_0_4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ExpressionAssignment_0_4_in_rule__ContextualExpression__Group_0__4__Impl988);
            rule__ContextualExpression__ExpressionAssignment_0_4();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_0__4__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_1__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:518:1: rule__ContextualExpression__Group_1__0 : rule__ContextualExpression__Group_1__0__Impl rule__ContextualExpression__Group_1__1 ;
    public final void rule__ContextualExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:522:1: ( rule__ContextualExpression__Group_1__0__Impl rule__ContextualExpression__Group_1__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:523:2: rule__ContextualExpression__Group_1__0__Impl rule__ContextualExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__0__Impl_in_rule__ContextualExpression__Group_1__01028);
            rule__ContextualExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__1_in_rule__ContextualExpression__Group_1__01031);
            rule__ContextualExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__0"


    // $ANTLR start "rule__ContextualExpression__Group_1__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:530:1: rule__ContextualExpression__Group_1__0__Impl : ( 'exists' ) ;
    public final void rule__ContextualExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:534:1: ( ( 'exists' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:535:1: ( 'exists' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:535:1: ( 'exists' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:536:1: 'exists'
            {
             before(grammarAccess.getContextualExpressionAccess().getExistsKeyword_1_0()); 
            match(input,13,FOLLOW_13_in_rule__ContextualExpression__Group_1__0__Impl1059); 
             after(grammarAccess.getContextualExpressionAccess().getExistsKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__0__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_1__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:549:1: rule__ContextualExpression__Group_1__1 : rule__ContextualExpression__Group_1__1__Impl rule__ContextualExpression__Group_1__2 ;
    public final void rule__ContextualExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:553:1: ( rule__ContextualExpression__Group_1__1__Impl rule__ContextualExpression__Group_1__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:554:2: rule__ContextualExpression__Group_1__1__Impl rule__ContextualExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__1__Impl_in_rule__ContextualExpression__Group_1__11090);
            rule__ContextualExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__2_in_rule__ContextualExpression__Group_1__11093);
            rule__ContextualExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__1"


    // $ANTLR start "rule__ContextualExpression__Group_1__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:561:1: rule__ContextualExpression__Group_1__1__Impl : ( () ) ;
    public final void rule__ContextualExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:565:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:566:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:566:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:567:1: ()
            {
             before(grammarAccess.getContextualExpressionAccess().getExistsContextualExpressionAction_1_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:568:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:570:1: 
            {
            }

             after(grammarAccess.getContextualExpressionAccess().getExistsContextualExpressionAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__1__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_1__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:580:1: rule__ContextualExpression__Group_1__2 : rule__ContextualExpression__Group_1__2__Impl rule__ContextualExpression__Group_1__3 ;
    public final void rule__ContextualExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:584:1: ( rule__ContextualExpression__Group_1__2__Impl rule__ContextualExpression__Group_1__3 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:585:2: rule__ContextualExpression__Group_1__2__Impl rule__ContextualExpression__Group_1__3
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__2__Impl_in_rule__ContextualExpression__Group_1__21151);
            rule__ContextualExpression__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__3_in_rule__ContextualExpression__Group_1__21154);
            rule__ContextualExpression__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__2"


    // $ANTLR start "rule__ContextualExpression__Group_1__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:592:1: rule__ContextualExpression__Group_1__2__Impl : ( ( rule__ContextualExpression__ContextIdAssignment_1_2 ) ) ;
    public final void rule__ContextualExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:596:1: ( ( ( rule__ContextualExpression__ContextIdAssignment_1_2 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:597:1: ( ( rule__ContextualExpression__ContextIdAssignment_1_2 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:597:1: ( ( rule__ContextualExpression__ContextIdAssignment_1_2 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:598:1: ( rule__ContextualExpression__ContextIdAssignment_1_2 )
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_1_2()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:599:1: ( rule__ContextualExpression__ContextIdAssignment_1_2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:599:2: rule__ContextualExpression__ContextIdAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ContextIdAssignment_1_2_in_rule__ContextualExpression__Group_1__2__Impl1181);
            rule__ContextualExpression__ContextIdAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getContextIdAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_1__3"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:609:1: rule__ContextualExpression__Group_1__3 : rule__ContextualExpression__Group_1__3__Impl rule__ContextualExpression__Group_1__4 ;
    public final void rule__ContextualExpression__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:613:1: ( rule__ContextualExpression__Group_1__3__Impl rule__ContextualExpression__Group_1__4 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:614:2: rule__ContextualExpression__Group_1__3__Impl rule__ContextualExpression__Group_1__4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__3__Impl_in_rule__ContextualExpression__Group_1__31211);
            rule__ContextualExpression__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__4_in_rule__ContextualExpression__Group_1__31214);
            rule__ContextualExpression__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__3"


    // $ANTLR start "rule__ContextualExpression__Group_1__3__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:621:1: rule__ContextualExpression__Group_1__3__Impl : ( ':' ) ;
    public final void rule__ContextualExpression__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:625:1: ( ( ':' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:626:1: ( ':' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:626:1: ( ':' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:627:1: ':'
            {
             before(grammarAccess.getContextualExpressionAccess().getColonKeyword_1_3()); 
            match(input,12,FOLLOW_12_in_rule__ContextualExpression__Group_1__3__Impl1242); 
             after(grammarAccess.getContextualExpressionAccess().getColonKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__3__Impl"


    // $ANTLR start "rule__ContextualExpression__Group_1__4"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:640:1: rule__ContextualExpression__Group_1__4 : rule__ContextualExpression__Group_1__4__Impl ;
    public final void rule__ContextualExpression__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:644:1: ( rule__ContextualExpression__Group_1__4__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:645:2: rule__ContextualExpression__Group_1__4__Impl
            {
            pushFollow(FOLLOW_rule__ContextualExpression__Group_1__4__Impl_in_rule__ContextualExpression__Group_1__41273);
            rule__ContextualExpression__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__4"


    // $ANTLR start "rule__ContextualExpression__Group_1__4__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:651:1: rule__ContextualExpression__Group_1__4__Impl : ( ( rule__ContextualExpression__ExpressionAssignment_1_4 ) ) ;
    public final void rule__ContextualExpression__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:655:1: ( ( ( rule__ContextualExpression__ExpressionAssignment_1_4 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:656:1: ( ( rule__ContextualExpression__ExpressionAssignment_1_4 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:656:1: ( ( rule__ContextualExpression__ExpressionAssignment_1_4 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:657:1: ( rule__ContextualExpression__ExpressionAssignment_1_4 )
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_1_4()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:658:1: ( rule__ContextualExpression__ExpressionAssignment_1_4 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:658:2: rule__ContextualExpression__ExpressionAssignment_1_4
            {
            pushFollow(FOLLOW_rule__ContextualExpression__ExpressionAssignment_1_4_in_rule__ContextualExpression__Group_1__4__Impl1300);
            rule__ContextualExpression__ExpressionAssignment_1_4();

            state._fsp--;


            }

             after(grammarAccess.getContextualExpressionAccess().getExpressionAssignment_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__Group_1__4__Impl"


    // $ANTLR start "rule__Equation__Group__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:678:1: rule__Equation__Group__0 : rule__Equation__Group__0__Impl rule__Equation__Group__1 ;
    public final void rule__Equation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:682:1: ( rule__Equation__Group__0__Impl rule__Equation__Group__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:683:2: rule__Equation__Group__0__Impl rule__Equation__Group__1
            {
            pushFollow(FOLLOW_rule__Equation__Group__0__Impl_in_rule__Equation__Group__01340);
            rule__Equation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equation__Group__1_in_rule__Equation__Group__01343);
            rule__Equation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group__0"


    // $ANTLR start "rule__Equation__Group__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:690:1: rule__Equation__Group__0__Impl : ( ruleImplication ) ;
    public final void rule__Equation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:694:1: ( ( ruleImplication ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:695:1: ( ruleImplication )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:695:1: ( ruleImplication )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:696:1: ruleImplication
            {
             before(grammarAccess.getEquationAccess().getImplicationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleImplication_in_rule__Equation__Group__0__Impl1370);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getEquationAccess().getImplicationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group__0__Impl"


    // $ANTLR start "rule__Equation__Group__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:707:1: rule__Equation__Group__1 : rule__Equation__Group__1__Impl ;
    public final void rule__Equation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:711:1: ( rule__Equation__Group__1__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:712:2: rule__Equation__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Equation__Group__1__Impl_in_rule__Equation__Group__11399);
            rule__Equation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group__1"


    // $ANTLR start "rule__Equation__Group__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:718:1: rule__Equation__Group__1__Impl : ( ( rule__Equation__Group_1__0 )* ) ;
    public final void rule__Equation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:722:1: ( ( ( rule__Equation__Group_1__0 )* ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:723:1: ( ( rule__Equation__Group_1__0 )* )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:723:1: ( ( rule__Equation__Group_1__0 )* )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:724:1: ( rule__Equation__Group_1__0 )*
            {
             before(grammarAccess.getEquationAccess().getGroup_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:725:1: ( rule__Equation__Group_1__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:725:2: rule__Equation__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Equation__Group_1__0_in_rule__Equation__Group__1__Impl1426);
            	    rule__Equation__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getEquationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group__1__Impl"


    // $ANTLR start "rule__Equation__Group_1__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:739:1: rule__Equation__Group_1__0 : rule__Equation__Group_1__0__Impl rule__Equation__Group_1__1 ;
    public final void rule__Equation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:743:1: ( rule__Equation__Group_1__0__Impl rule__Equation__Group_1__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:744:2: rule__Equation__Group_1__0__Impl rule__Equation__Group_1__1
            {
            pushFollow(FOLLOW_rule__Equation__Group_1__0__Impl_in_rule__Equation__Group_1__01461);
            rule__Equation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equation__Group_1__1_in_rule__Equation__Group_1__01464);
            rule__Equation__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group_1__0"


    // $ANTLR start "rule__Equation__Group_1__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:751:1: rule__Equation__Group_1__0__Impl : ( () ) ;
    public final void rule__Equation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:755:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:756:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:756:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:757:1: ()
            {
             before(grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:758:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:760:1: 
            {
            }

             after(grammarAccess.getEquationAccess().getEquationLeftPartAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group_1__0__Impl"


    // $ANTLR start "rule__Equation__Group_1__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:770:1: rule__Equation__Group_1__1 : rule__Equation__Group_1__1__Impl rule__Equation__Group_1__2 ;
    public final void rule__Equation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:774:1: ( rule__Equation__Group_1__1__Impl rule__Equation__Group_1__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:775:2: rule__Equation__Group_1__1__Impl rule__Equation__Group_1__2
            {
            pushFollow(FOLLOW_rule__Equation__Group_1__1__Impl_in_rule__Equation__Group_1__11522);
            rule__Equation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equation__Group_1__2_in_rule__Equation__Group_1__11525);
            rule__Equation__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group_1__1"


    // $ANTLR start "rule__Equation__Group_1__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:782:1: rule__Equation__Group_1__1__Impl : ( 'equals' ) ;
    public final void rule__Equation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:786:1: ( ( 'equals' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:787:1: ( 'equals' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:787:1: ( 'equals' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:788:1: 'equals'
            {
             before(grammarAccess.getEquationAccess().getEqualsKeyword_1_1()); 
            match(input,14,FOLLOW_14_in_rule__Equation__Group_1__1__Impl1553); 
             after(grammarAccess.getEquationAccess().getEqualsKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group_1__1__Impl"


    // $ANTLR start "rule__Equation__Group_1__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:801:1: rule__Equation__Group_1__2 : rule__Equation__Group_1__2__Impl ;
    public final void rule__Equation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:805:1: ( rule__Equation__Group_1__2__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:806:2: rule__Equation__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Equation__Group_1__2__Impl_in_rule__Equation__Group_1__21584);
            rule__Equation__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group_1__2"


    // $ANTLR start "rule__Equation__Group_1__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:812:1: rule__Equation__Group_1__2__Impl : ( ( rule__Equation__RightPartAssignment_1_2 ) ) ;
    public final void rule__Equation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:816:1: ( ( ( rule__Equation__RightPartAssignment_1_2 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:817:1: ( ( rule__Equation__RightPartAssignment_1_2 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:817:1: ( ( rule__Equation__RightPartAssignment_1_2 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:818:1: ( rule__Equation__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getEquationAccess().getRightPartAssignment_1_2()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:819:1: ( rule__Equation__RightPartAssignment_1_2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:819:2: rule__Equation__RightPartAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Equation__RightPartAssignment_1_2_in_rule__Equation__Group_1__2__Impl1611);
            rule__Equation__RightPartAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEquationAccess().getRightPartAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__Group_1__2__Impl"


    // $ANTLR start "rule__Implication__Group__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:835:1: rule__Implication__Group__0 : rule__Implication__Group__0__Impl rule__Implication__Group__1 ;
    public final void rule__Implication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:839:1: ( rule__Implication__Group__0__Impl rule__Implication__Group__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:840:2: rule__Implication__Group__0__Impl rule__Implication__Group__1
            {
            pushFollow(FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01647);
            rule__Implication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01650);
            rule__Implication__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__0"


    // $ANTLR start "rule__Implication__Group__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:847:1: rule__Implication__Group__0__Impl : ( ruleDisjunction ) ;
    public final void rule__Implication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:851:1: ( ( ruleDisjunction ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:852:1: ( ruleDisjunction )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:852:1: ( ruleDisjunction )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:853:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1677);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__0__Impl"


    // $ANTLR start "rule__Implication__Group__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:864:1: rule__Implication__Group__1 : rule__Implication__Group__1__Impl ;
    public final void rule__Implication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:868:1: ( rule__Implication__Group__1__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:869:2: rule__Implication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11706);
            rule__Implication__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__1"


    // $ANTLR start "rule__Implication__Group__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:875:1: rule__Implication__Group__1__Impl : ( ( rule__Implication__Group_1__0 )* ) ;
    public final void rule__Implication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:879:1: ( ( ( rule__Implication__Group_1__0 )* ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:880:1: ( ( rule__Implication__Group_1__0 )* )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:880:1: ( ( rule__Implication__Group_1__0 )* )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:881:1: ( rule__Implication__Group_1__0 )*
            {
             before(grammarAccess.getImplicationAccess().getGroup_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:882:1: ( rule__Implication__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:882:2: rule__Implication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1733);
            	    rule__Implication__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getImplicationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__1__Impl"


    // $ANTLR start "rule__Implication__Group_1__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:896:1: rule__Implication__Group_1__0 : rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 ;
    public final void rule__Implication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:900:1: ( rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:901:2: rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01768);
            rule__Implication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01771);
            rule__Implication__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__0"


    // $ANTLR start "rule__Implication__Group_1__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:908:1: rule__Implication__Group_1__0__Impl : ( () ) ;
    public final void rule__Implication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:912:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:913:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:913:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:914:1: ()
            {
             before(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:915:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:917:1: 
            {
            }

             after(grammarAccess.getImplicationAccess().getImplicationLeftPartAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__0__Impl"


    // $ANTLR start "rule__Implication__Group_1__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:927:1: rule__Implication__Group_1__1 : rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 ;
    public final void rule__Implication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:931:1: ( rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:932:2: rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11829);
            rule__Implication__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11832);
            rule__Implication__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__1"


    // $ANTLR start "rule__Implication__Group_1__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:939:1: rule__Implication__Group_1__1__Impl : ( 'implies' ) ;
    public final void rule__Implication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:943:1: ( ( 'implies' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:944:1: ( 'implies' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:944:1: ( 'implies' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:945:1: 'implies'
            {
             before(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1()); 
            match(input,15,FOLLOW_15_in_rule__Implication__Group_1__1__Impl1860); 
             after(grammarAccess.getImplicationAccess().getImpliesKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__1__Impl"


    // $ANTLR start "rule__Implication__Group_1__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:958:1: rule__Implication__Group_1__2 : rule__Implication__Group_1__2__Impl ;
    public final void rule__Implication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:962:1: ( rule__Implication__Group_1__2__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:963:2: rule__Implication__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21891);
            rule__Implication__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__2"


    // $ANTLR start "rule__Implication__Group_1__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:969:1: rule__Implication__Group_1__2__Impl : ( ( rule__Implication__RightPartAssignment_1_2 ) ) ;
    public final void rule__Implication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:973:1: ( ( ( rule__Implication__RightPartAssignment_1_2 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:974:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:974:1: ( ( rule__Implication__RightPartAssignment_1_2 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:975:1: ( rule__Implication__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:976:1: ( rule__Implication__RightPartAssignment_1_2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:976:2: rule__Implication__RightPartAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1918);
            rule__Implication__RightPartAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getImplicationAccess().getRightPartAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__2__Impl"


    // $ANTLR start "rule__Disjunction__Group__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:992:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:996:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:997:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01954);
            rule__Disjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01957);
            rule__Disjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0"


    // $ANTLR start "rule__Disjunction__Group__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1004:1: rule__Disjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1008:1: ( ( ruleConjunction ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1009:1: ( ruleConjunction )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1009:1: ( ruleConjunction )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1010:1: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__Disjunction__Group__0__Impl1984);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0__Impl"


    // $ANTLR start "rule__Disjunction__Group__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1021:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1025:1: ( rule__Disjunction__Group__1__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1026:2: rule__Disjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__12013);
            rule__Disjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1"


    // $ANTLR start "rule__Disjunction__Group__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1032:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1036:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1037:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1037:1: ( ( rule__Disjunction__Group_1__0 )* )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1038:1: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1039:1: ( rule__Disjunction__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==16) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1039:2: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl2040);
            	    rule__Disjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getDisjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1053:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1057:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1058:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__02075);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__02078);
            rule__Disjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0"


    // $ANTLR start "rule__Disjunction__Group_1__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1065:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1069:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1070:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1070:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1071:1: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1072:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1074:1: 
            {
            }

             after(grammarAccess.getDisjunctionAccess().getDisjunctionLeftPartAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1084:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1088:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1089:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__12136);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__12139);
            rule__Disjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1"


    // $ANTLR start "rule__Disjunction__Group_1__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1096:1: rule__Disjunction__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1100:1: ( ( 'or' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1101:1: ( 'or' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1101:1: ( 'or' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1102:1: 'or'
            {
             before(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1()); 
            match(input,16,FOLLOW_16_in_rule__Disjunction__Group_1__1__Impl2167); 
             after(grammarAccess.getDisjunctionAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1115:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1119:1: ( rule__Disjunction__Group_1__2__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1120:2: rule__Disjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__22198);
            rule__Disjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2"


    // $ANTLR start "rule__Disjunction__Group_1__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1126:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__RightPartAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1130:1: ( ( ( rule__Disjunction__RightPartAssignment_1_2 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1131:1: ( ( rule__Disjunction__RightPartAssignment_1_2 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1131:1: ( ( rule__Disjunction__RightPartAssignment_1_2 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1132:1: ( rule__Disjunction__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getRightPartAssignment_1_2()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1133:1: ( rule__Disjunction__RightPartAssignment_1_2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1133:2: rule__Disjunction__RightPartAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Disjunction__RightPartAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl2225);
            rule__Disjunction__RightPartAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getRightPartAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Conjunction__Group__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1149:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1153:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1154:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02261);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02264);
            rule__Conjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0"


    // $ANTLR start "rule__Conjunction__Group__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1161:1: rule__Conjunction__Group__0__Impl : ( ruleNegation ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1165:1: ( ( ruleNegation ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1166:1: ( ruleNegation )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1166:1: ( ruleNegation )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1167:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2291);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getNegationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0__Impl"


    // $ANTLR start "rule__Conjunction__Group__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1178:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1182:1: ( rule__Conjunction__Group__1__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1183:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12320);
            rule__Conjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1"


    // $ANTLR start "rule__Conjunction__Group__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1189:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1193:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1194:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1194:1: ( ( rule__Conjunction__Group_1__0 )* )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1195:1: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1196:1: ( rule__Conjunction__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==17) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1196:2: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2347);
            	    rule__Conjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getConjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1210:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1214:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1215:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02382);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02385);
            rule__Conjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0"


    // $ANTLR start "rule__Conjunction__Group_1__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1222:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1226:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1227:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1227:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1228:1: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1229:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1231:1: 
            {
            }

             after(grammarAccess.getConjunctionAccess().getConjunctionLeftPartAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1241:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1245:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1246:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12443);
            rule__Conjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12446);
            rule__Conjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1"


    // $ANTLR start "rule__Conjunction__Group_1__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1253:1: rule__Conjunction__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1257:1: ( ( 'and' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1258:1: ( 'and' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1258:1: ( 'and' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1259:1: 'and'
            {
             before(grammarAccess.getConjunctionAccess().getAndKeyword_1_1()); 
            match(input,17,FOLLOW_17_in_rule__Conjunction__Group_1__1__Impl2474); 
             after(grammarAccess.getConjunctionAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1272:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1276:1: ( rule__Conjunction__Group_1__2__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1277:2: rule__Conjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22505);
            rule__Conjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2"


    // $ANTLR start "rule__Conjunction__Group_1__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1283:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__RightPartAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1287:1: ( ( ( rule__Conjunction__RightPartAssignment_1_2 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1288:1: ( ( rule__Conjunction__RightPartAssignment_1_2 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1288:1: ( ( rule__Conjunction__RightPartAssignment_1_2 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1289:1: ( rule__Conjunction__RightPartAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getRightPartAssignment_1_2()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1290:1: ( rule__Conjunction__RightPartAssignment_1_2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1290:2: rule__Conjunction__RightPartAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Conjunction__RightPartAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2532);
            rule__Conjunction__RightPartAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getRightPartAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Negation__Group_1__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1306:1: rule__Negation__Group_1__0 : rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 ;
    public final void rule__Negation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1310:1: ( rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1311:2: rule__Negation__Group_1__0__Impl rule__Negation__Group_1__1
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02568);
            rule__Negation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02571);
            rule__Negation__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__0"


    // $ANTLR start "rule__Negation__Group_1__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1318:1: rule__Negation__Group_1__0__Impl : ( 'not' ) ;
    public final void rule__Negation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1322:1: ( ( 'not' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1323:1: ( 'not' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1323:1: ( 'not' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1324:1: 'not'
            {
             before(grammarAccess.getNegationAccess().getNotKeyword_1_0()); 
            match(input,18,FOLLOW_18_in_rule__Negation__Group_1__0__Impl2599); 
             after(grammarAccess.getNegationAccess().getNotKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__0__Impl"


    // $ANTLR start "rule__Negation__Group_1__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1337:1: rule__Negation__Group_1__1 : rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 ;
    public final void rule__Negation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1341:1: ( rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1342:2: rule__Negation__Group_1__1__Impl rule__Negation__Group_1__2
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12630);
            rule__Negation__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12633);
            rule__Negation__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__1"


    // $ANTLR start "rule__Negation__Group_1__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1349:1: rule__Negation__Group_1__1__Impl : ( () ) ;
    public final void rule__Negation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1353:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1354:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1354:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1355:1: ()
            {
             before(grammarAccess.getNegationAccess().getNegationAction_1_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1356:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1358:1: 
            {
            }

             after(grammarAccess.getNegationAccess().getNegationAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__1__Impl"


    // $ANTLR start "rule__Negation__Group_1__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1368:1: rule__Negation__Group_1__2 : rule__Negation__Group_1__2__Impl ;
    public final void rule__Negation__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1372:1: ( rule__Negation__Group_1__2__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1373:2: rule__Negation__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22691);
            rule__Negation__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__2"


    // $ANTLR start "rule__Negation__Group_1__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1379:1: rule__Negation__Group_1__2__Impl : ( ( rule__Negation__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Negation__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1383:1: ( ( ( rule__Negation__ExpressionAssignment_1_2 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1384:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1384:1: ( ( rule__Negation__ExpressionAssignment_1_2 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1385:1: ( rule__Negation__ExpressionAssignment_1_2 )
            {
             before(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1386:1: ( rule__Negation__ExpressionAssignment_1_2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1386:2: rule__Negation__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2718);
            rule__Negation__ExpressionAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getExpressionAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group_1__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1402:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1406:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1407:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02754);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02757);
            rule__PrimaryExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1414:1: rule__PrimaryExpression__Group_0__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1418:1: ( ( () ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1419:1: ( () )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1419:1: ( () )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1420:1: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1421:1: ()
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1423:1: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1433:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1437:1: ( rule__PrimaryExpression__Group_0__1__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1438:2: rule__PrimaryExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12815);
            rule__PrimaryExpression__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1444:1: rule__PrimaryExpression__Group_0__1__Impl : ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1448:1: ( ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1449:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1449:1: ( ( rule__PrimaryExpression__FeatureIdAssignment_0_1 ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1450:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); 
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1451:1: ( rule__PrimaryExpression__FeatureIdAssignment_0_1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1451:2: rule__PrimaryExpression__FeatureIdAssignment_0_1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2842);
            rule__PrimaryExpression__FeatureIdAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getFeatureIdAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1465:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1469:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1470:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02876);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02879);
            rule__PrimaryExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1477:1: rule__PrimaryExpression__Group_1__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1481:1: ( ( '(' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1482:1: ( '(' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1482:1: ( '(' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1483:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,19,FOLLOW_19_in_rule__PrimaryExpression__Group_1__0__Impl2907); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1496:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1500:1: ( rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1501:2: rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12938);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12941);
            rule__PrimaryExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1508:1: rule__PrimaryExpression__Group_1__1__Impl : ( ruleExpression ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1512:1: ( ( ruleExpression ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1513:1: ( ruleExpression )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1513:1: ( ruleExpression )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1514:1: ruleExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2968);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1525:1: rule__PrimaryExpression__Group_1__2 : rule__PrimaryExpression__Group_1__2__Impl ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1529:1: ( rule__PrimaryExpression__Group_1__2__Impl )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1530:2: rule__PrimaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22997);
            rule__PrimaryExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__2"


    // $ANTLR start "rule__PrimaryExpression__Group_1__2__Impl"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1536:1: rule__PrimaryExpression__Group_1__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1540:1: ( ( ')' ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1541:1: ( ')' )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1541:1: ( ')' )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1542:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); 
            match(input,20,FOLLOW_20_in_rule__PrimaryExpression__Group_1__2__Impl3025); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ContextualExpression__ContextIdAssignment_0_2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1562:1: rule__ContextualExpression__ContextIdAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__ContextualExpression__ContextIdAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1566:1: ( ( RULE_ID ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1567:1: ( RULE_ID )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1567:1: ( RULE_ID )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1568:1: RULE_ID
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_23067); 
             after(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__ContextIdAssignment_0_2"


    // $ANTLR start "rule__ContextualExpression__ExpressionAssignment_0_4"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1577:1: rule__ContextualExpression__ExpressionAssignment_0_4 : ( ruleEquation ) ;
    public final void rule__ContextualExpression__ExpressionAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1581:1: ( ( ruleEquation ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1582:1: ( ruleEquation )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1582:1: ( ruleEquation )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1583:1: ruleEquation
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_ruleEquation_in_rule__ContextualExpression__ExpressionAssignment_0_43098);
            ruleEquation();

            state._fsp--;

             after(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__ExpressionAssignment_0_4"


    // $ANTLR start "rule__ContextualExpression__ContextIdAssignment_1_2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1592:1: rule__ContextualExpression__ContextIdAssignment_1_2 : ( RULE_ID ) ;
    public final void rule__ContextualExpression__ContextIdAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1596:1: ( ( RULE_ID ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1597:1: ( RULE_ID )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1597:1: ( RULE_ID )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1598:1: RULE_ID
            {
             before(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_1_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_1_23129); 
             after(grammarAccess.getContextualExpressionAccess().getContextIdIDTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__ContextIdAssignment_1_2"


    // $ANTLR start "rule__ContextualExpression__ExpressionAssignment_1_4"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1607:1: rule__ContextualExpression__ExpressionAssignment_1_4 : ( ruleEquation ) ;
    public final void rule__ContextualExpression__ExpressionAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1611:1: ( ( ruleEquation ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1612:1: ( ruleEquation )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1612:1: ( ruleEquation )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1613:1: ruleEquation
            {
             before(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_1_4_0()); 
            pushFollow(FOLLOW_ruleEquation_in_rule__ContextualExpression__ExpressionAssignment_1_43160);
            ruleEquation();

            state._fsp--;

             after(grammarAccess.getContextualExpressionAccess().getExpressionEquationParserRuleCall_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextualExpression__ExpressionAssignment_1_4"


    // $ANTLR start "rule__Equation__RightPartAssignment_1_2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1622:1: rule__Equation__RightPartAssignment_1_2 : ( ruleImplication ) ;
    public final void rule__Equation__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1626:1: ( ( ruleImplication ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1627:1: ( ruleImplication )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1627:1: ( ruleImplication )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1628:1: ruleImplication
            {
             before(grammarAccess.getEquationAccess().getRightPartImplicationParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleImplication_in_rule__Equation__RightPartAssignment_1_23191);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getEquationAccess().getRightPartImplicationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equation__RightPartAssignment_1_2"


    // $ANTLR start "rule__Implication__RightPartAssignment_1_2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1637:1: rule__Implication__RightPartAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__Implication__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1641:1: ( ( ruleDisjunction ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1642:1: ( ruleDisjunction )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1642:1: ( ruleDisjunction )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1643:1: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23222);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getImplicationAccess().getRightPartDisjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__RightPartAssignment_1_2"


    // $ANTLR start "rule__Disjunction__RightPartAssignment_1_2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1652:1: rule__Disjunction__RightPartAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__Disjunction__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1656:1: ( ( ruleConjunction ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1657:1: ( ruleConjunction )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1657:1: ( ruleConjunction )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1658:1: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getRightPartConjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleConjunction_in_rule__Disjunction__RightPartAssignment_1_23253);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getRightPartConjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__RightPartAssignment_1_2"


    // $ANTLR start "rule__Conjunction__RightPartAssignment_1_2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1667:1: rule__Conjunction__RightPartAssignment_1_2 : ( ruleNegation ) ;
    public final void rule__Conjunction__RightPartAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1671:1: ( ( ruleNegation ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1672:1: ( ruleNegation )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1672:1: ( ruleNegation )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1673:1: ruleNegation
            {
             before(grammarAccess.getConjunctionAccess().getRightPartNegationParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleNegation_in_rule__Conjunction__RightPartAssignment_1_23284);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getRightPartNegationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__RightPartAssignment_1_2"


    // $ANTLR start "rule__Negation__ExpressionAssignment_1_2"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1682:1: rule__Negation__ExpressionAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__Negation__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1686:1: ( ( rulePrimaryExpression ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1687:1: ( rulePrimaryExpression )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1687:1: ( rulePrimaryExpression )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1688:1: rulePrimaryExpression
            {
             before(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23315);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getNegationAccess().getExpressionPrimaryExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__ExpressionAssignment_1_2"


    // $ANTLR start "rule__PrimaryExpression__FeatureIdAssignment_0_1"
    // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1697:1: rule__PrimaryExpression__FeatureIdAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__PrimaryExpression__FeatureIdAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1701:1: ( ( RULE_ID ) )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1702:1: ( RULE_ID )
            {
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1702:1: ( RULE_ID )
            // ../cz.zcu.yafmt.clang.bcl.ui/src-gen/cz/zcu/yafmt/clang/bcl/ui/contentassist/antlr/internal/InternalBooleanConstraintLanguage.g:1703:1: RULE_ID
            {
             before(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_13346); 
             after(grammarAccess.getPrimaryExpressionAccess().getFeatureIdIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__FeatureIdAssignment_0_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_ruleExpression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextualExpression_in_entryRuleContextualExpression120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextualExpression127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Alternatives_in_ruleContextualExpression153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquation_in_entryRuleEquation180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquation187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equation__Group__0_in_ruleEquation213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_entryRuleImplication240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplication247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__0_in_ruleImplication273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_entryRuleDisjunction300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisjunction307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__0_in_ruleDisjunction333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_entryRuleConjunction360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConjunction367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0_in_ruleConjunction393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Alternatives_in_ruleNegation453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__0_in_rule__ContextualExpression__Alternatives549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__0_in_rule__ContextualExpression__Alternatives567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquation_in_rule__ContextualExpression__Alternatives585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__Alternatives617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0_in_rule__Negation__Alternatives634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0_in_rule__PrimaryExpression__Alternatives667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0_in_rule__PrimaryExpression__Alternatives685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__0__Impl_in_rule__ContextualExpression__Group_0__0716 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__1_in_rule__ContextualExpression__Group_0__0719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ContextualExpression__Group_0__0__Impl747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__1__Impl_in_rule__ContextualExpression__Group_0__1778 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__2_in_rule__ContextualExpression__Group_0__1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__2__Impl_in_rule__ContextualExpression__Group_0__2839 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__3_in_rule__ContextualExpression__Group_0__2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ContextIdAssignment_0_2_in_rule__ContextualExpression__Group_0__2__Impl869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__3__Impl_in_rule__ContextualExpression__Group_0__3899 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__4_in_rule__ContextualExpression__Group_0__3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ContextualExpression__Group_0__3__Impl930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_0__4__Impl_in_rule__ContextualExpression__Group_0__4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ExpressionAssignment_0_4_in_rule__ContextualExpression__Group_0__4__Impl988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__0__Impl_in_rule__ContextualExpression__Group_1__01028 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__1_in_rule__ContextualExpression__Group_1__01031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ContextualExpression__Group_1__0__Impl1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__1__Impl_in_rule__ContextualExpression__Group_1__11090 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__2_in_rule__ContextualExpression__Group_1__11093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__2__Impl_in_rule__ContextualExpression__Group_1__21151 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__3_in_rule__ContextualExpression__Group_1__21154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ContextIdAssignment_1_2_in_rule__ContextualExpression__Group_1__2__Impl1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__3__Impl_in_rule__ContextualExpression__Group_1__31211 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__4_in_rule__ContextualExpression__Group_1__31214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ContextualExpression__Group_1__3__Impl1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__Group_1__4__Impl_in_rule__ContextualExpression__Group_1__41273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextualExpression__ExpressionAssignment_1_4_in_rule__ContextualExpression__Group_1__4__Impl1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equation__Group__0__Impl_in_rule__Equation__Group__01340 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Equation__Group__1_in_rule__Equation__Group__01343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__Equation__Group__0__Impl1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equation__Group__1__Impl_in_rule__Equation__Group__11399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equation__Group_1__0_in_rule__Equation__Group__1__Impl1426 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__Equation__Group_1__0__Impl_in_rule__Equation__Group_1__01461 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Equation__Group_1__1_in_rule__Equation__Group_1__01464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equation__Group_1__1__Impl_in_rule__Equation__Group_1__11522 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__Equation__Group_1__2_in_rule__Equation__Group_1__11525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Equation__Group_1__1__Impl1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equation__Group_1__2__Impl_in_rule__Equation__Group_1__21584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equation__RightPartAssignment_1_2_in_rule__Equation__Group_1__2__Impl1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__0__Impl_in_rule__Implication__Group__01647 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Implication__Group__1_in_rule__Implication__Group__01650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__Group__0__Impl1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group__1__Impl_in_rule__Implication__Group__11706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0_in_rule__Implication__Group__1__Impl1733 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__0__Impl_in_rule__Implication__Group_1__01768 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1_in_rule__Implication__Group_1__01771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__1__Impl_in_rule__Implication__Group_1__11829 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2_in_rule__Implication__Group_1__11832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Implication__Group_1__1__Impl1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__Group_1__2__Impl_in_rule__Implication__Group_1__21891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Implication__RightPartAssignment_1_2_in_rule__Implication__Group_1__2__Impl1918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__0__Impl_in_rule__Disjunction__Group__01954 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1_in_rule__Disjunction__Group__01957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__Disjunction__Group__0__Impl1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group__1__Impl_in_rule__Disjunction__Group__12013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0_in_rule__Disjunction__Group__1__Impl2040 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__0__Impl_in_rule__Disjunction__Group_1__02075 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1_in_rule__Disjunction__Group_1__02078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__1__Impl_in_rule__Disjunction__Group_1__12136 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2_in_rule__Disjunction__Group_1__12139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Disjunction__Group_1__1__Impl2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__Group_1__2__Impl_in_rule__Disjunction__Group_1__22198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Disjunction__RightPartAssignment_1_2_in_rule__Disjunction__Group_1__2__Impl2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__0__Impl_in_rule__Conjunction__Group__02261 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1_in_rule__Conjunction__Group__02264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__Group__0__Impl2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group__1__Impl_in_rule__Conjunction__Group__12320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0_in_rule__Conjunction__Group__1__Impl2347 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__0__Impl_in_rule__Conjunction__Group_1__02382 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1_in_rule__Conjunction__Group_1__02385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__1__Impl_in_rule__Conjunction__Group_1__12443 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2_in_rule__Conjunction__Group_1__12446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Conjunction__Group_1__1__Impl2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__Group_1__2__Impl_in_rule__Conjunction__Group_1__22505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Conjunction__RightPartAssignment_1_2_in_rule__Conjunction__Group_1__2__Impl2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__0__Impl_in_rule__Negation__Group_1__02568 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1_in_rule__Negation__Group_1__02571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Negation__Group_1__0__Impl2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__1__Impl_in_rule__Negation__Group_1__12630 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2_in_rule__Negation__Group_1__12633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__Group_1__2__Impl_in_rule__Negation__Group_1__22691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Negation__ExpressionAssignment_1_2_in_rule__Negation__Group_1__2__Impl2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__0__Impl_in_rule__PrimaryExpression__Group_0__02754 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1_in_rule__PrimaryExpression__Group_0__02757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_0__1__Impl_in_rule__PrimaryExpression__Group_0__12815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__FeatureIdAssignment_0_1_in_rule__PrimaryExpression__Group_0__1__Impl2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__0__Impl_in_rule__PrimaryExpression__Group_1__02876 = new BitSet(new long[]{0x00000000000C2810L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1_in_rule__PrimaryExpression__Group_1__02879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PrimaryExpression__Group_1__0__Impl2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__1__Impl_in_rule__PrimaryExpression__Group_1__12938 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2_in_rule__PrimaryExpression__Group_1__12941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__PrimaryExpression__Group_1__1__Impl2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_1__2__Impl_in_rule__PrimaryExpression__Group_1__22997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PrimaryExpression__Group_1__2__Impl3025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_0_23067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquation_in_rule__ContextualExpression__ExpressionAssignment_0_43098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ContextualExpression__ContextIdAssignment_1_23129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquation_in_rule__ContextualExpression__ExpressionAssignment_1_43160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplication_in_rule__Equation__RightPartAssignment_1_23191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisjunction_in_rule__Implication__RightPartAssignment_1_23222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConjunction_in_rule__Disjunction__RightPartAssignment_1_23253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_rule__Conjunction__RightPartAssignment_1_23284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Negation__ExpressionAssignment_1_23315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryExpression__FeatureIdAssignment_0_13346 = new BitSet(new long[]{0x0000000000000002L});

}