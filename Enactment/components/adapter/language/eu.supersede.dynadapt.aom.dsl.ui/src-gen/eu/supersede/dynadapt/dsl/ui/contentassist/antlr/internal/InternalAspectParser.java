package eu.supersede.dynadapt.dsl.ui.contentassist.antlr.internal; 

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
import eu.supersede.dynadapt.dsl.services.AspectGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAspectParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_EBOOLEAN", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'aspect'", "'{'", "'feature'", "','", "'pointcuts'", "'}'", "'compositions'", "'advice'", "'pointcut'", "'pattern'", "'role'", "'composition'", "'feature_enabled'", "'action'", "'jointpointRole'", "'adviceRole'", "'update value'", "'.'", "'add'", "'delete'", "'replace'", "'update'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_EBOOLEAN=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalAspectParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAspectParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAspectParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAspect.g"; }


     
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




    // $ANTLR start "entryRuleAspect"
    // InternalAspect.g:61:1: entryRuleAspect : ruleAspect EOF ;
    public final void entryRuleAspect() throws RecognitionException {
        try {
            // InternalAspect.g:62:1: ( ruleAspect EOF )
            // InternalAspect.g:63:1: ruleAspect EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAspect();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAspect"


    // $ANTLR start "ruleAspect"
    // InternalAspect.g:70:1: ruleAspect : ( ( rule__Aspect__Group__0 ) ) ;
    public final void ruleAspect() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:74:2: ( ( ( rule__Aspect__Group__0 ) ) )
            // InternalAspect.g:75:1: ( ( rule__Aspect__Group__0 ) )
            {
            // InternalAspect.g:75:1: ( ( rule__Aspect__Group__0 ) )
            // InternalAspect.g:76:1: ( rule__Aspect__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup()); 
            }
            // InternalAspect.g:77:1: ( rule__Aspect__Group__0 )
            // InternalAspect.g:77:2: rule__Aspect__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleAspect"


    // $ANTLR start "entryRulePointcut"
    // InternalAspect.g:89:1: entryRulePointcut : rulePointcut EOF ;
    public final void entryRulePointcut() throws RecognitionException {
        try {
            // InternalAspect.g:90:1: ( rulePointcut EOF )
            // InternalAspect.g:91:1: rulePointcut EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePointcut();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePointcut"


    // $ANTLR start "rulePointcut"
    // InternalAspect.g:98:1: rulePointcut : ( ( rule__Pointcut__Group__0 ) ) ;
    public final void rulePointcut() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:102:2: ( ( ( rule__Pointcut__Group__0 ) ) )
            // InternalAspect.g:103:1: ( ( rule__Pointcut__Group__0 ) )
            {
            // InternalAspect.g:103:1: ( ( rule__Pointcut__Group__0 ) )
            // InternalAspect.g:104:1: ( rule__Pointcut__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getGroup()); 
            }
            // InternalAspect.g:105:1: ( rule__Pointcut__Group__0 )
            // InternalAspect.g:105:2: rule__Pointcut__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getGroup()); 
            }

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
    // $ANTLR end "rulePointcut"


    // $ANTLR start "entryRuleComposition"
    // InternalAspect.g:117:1: entryRuleComposition : ruleComposition EOF ;
    public final void entryRuleComposition() throws RecognitionException {
        try {
            // InternalAspect.g:118:1: ( ruleComposition EOF )
            // InternalAspect.g:119:1: ruleComposition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleComposition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleComposition"


    // $ANTLR start "ruleComposition"
    // InternalAspect.g:126:1: ruleComposition : ( ( rule__Composition__Group__0 ) ) ;
    public final void ruleComposition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:130:2: ( ( ( rule__Composition__Group__0 ) ) )
            // InternalAspect.g:131:1: ( ( rule__Composition__Group__0 ) )
            {
            // InternalAspect.g:131:1: ( ( rule__Composition__Group__0 ) )
            // InternalAspect.g:132:1: ( rule__Composition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup()); 
            }
            // InternalAspect.g:133:1: ( rule__Composition__Group__0 )
            // InternalAspect.g:133:2: rule__Composition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Composition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleComposition"


    // $ANTLR start "entryRuleActionOptionType"
    // InternalAspect.g:145:1: entryRuleActionOptionType : ruleActionOptionType EOF ;
    public final void entryRuleActionOptionType() throws RecognitionException {
        try {
            // InternalAspect.g:146:1: ( ruleActionOptionType EOF )
            // InternalAspect.g:147:1: ruleActionOptionType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionOptionTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleActionOptionType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionOptionTypeRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleActionOptionType"


    // $ANTLR start "ruleActionOptionType"
    // InternalAspect.g:154:1: ruleActionOptionType : ( ( rule__ActionOptionType__Alternatives ) ) ;
    public final void ruleActionOptionType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:158:2: ( ( ( rule__ActionOptionType__Alternatives ) ) )
            // InternalAspect.g:159:1: ( ( rule__ActionOptionType__Alternatives ) )
            {
            // InternalAspect.g:159:1: ( ( rule__ActionOptionType__Alternatives ) )
            // InternalAspect.g:160:1: ( rule__ActionOptionType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionOptionTypeAccess().getAlternatives()); 
            }
            // InternalAspect.g:161:1: ( rule__ActionOptionType__Alternatives )
            // InternalAspect.g:161:2: rule__ActionOptionType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ActionOptionType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionOptionTypeAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleActionOptionType"


    // $ANTLR start "entryRuleUpdateValue"
    // InternalAspect.g:173:1: entryRuleUpdateValue : ruleUpdateValue EOF ;
    public final void entryRuleUpdateValue() throws RecognitionException {
        try {
            // InternalAspect.g:174:1: ( ruleUpdateValue EOF )
            // InternalAspect.g:175:1: ruleUpdateValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateValueRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleUpdateValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateValueRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleUpdateValue"


    // $ANTLR start "ruleUpdateValue"
    // InternalAspect.g:182:1: ruleUpdateValue : ( ( rule__UpdateValue__Group__0 ) ) ;
    public final void ruleUpdateValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:186:2: ( ( ( rule__UpdateValue__Group__0 ) ) )
            // InternalAspect.g:187:1: ( ( rule__UpdateValue__Group__0 ) )
            {
            // InternalAspect.g:187:1: ( ( rule__UpdateValue__Group__0 ) )
            // InternalAspect.g:188:1: ( rule__UpdateValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateValueAccess().getGroup()); 
            }
            // InternalAspect.g:189:1: ( rule__UpdateValue__Group__0 )
            // InternalAspect.g:189:2: rule__UpdateValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UpdateValue__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateValueAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleUpdateValue"


    // $ANTLR start "entryRuleAction"
    // InternalAspect.g:201:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalAspect.g:202:1: ( ruleAction EOF )
            // InternalAspect.g:203:1: ruleAction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalAspect.g:210:1: ruleAction : ( ( rule__Action__Alternatives ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:214:2: ( ( ( rule__Action__Alternatives ) ) )
            // InternalAspect.g:215:1: ( ( rule__Action__Alternatives ) )
            {
            // InternalAspect.g:215:1: ( ( rule__Action__Alternatives ) )
            // InternalAspect.g:216:1: ( rule__Action__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getAlternatives()); 
            }
            // InternalAspect.g:217:1: ( rule__Action__Alternatives )
            // InternalAspect.g:217:2: rule__Action__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Action__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAspect.g:229:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalAspect.g:230:1: ( ruleQualifiedName EOF )
            // InternalAspect.g:231:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalAspect.g:238:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:242:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalAspect.g:243:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalAspect.g:243:1: ( ( rule__QualifiedName__Group__0 ) )
            // InternalAspect.g:244:1: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalAspect.g:245:1: ( rule__QualifiedName__Group__0 )
            // InternalAspect.g:245:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__ActionOptionType__Alternatives"
    // InternalAspect.g:257:1: rule__ActionOptionType__Alternatives : ( ( ruleAction ) | ( ruleUpdateValue ) );
    public final void rule__ActionOptionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:261:1: ( ( ruleAction ) | ( ruleUpdateValue ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=30 && LA1_0<=33)) ) {
                alt1=1;
            }
            else if ( (LA1_0==28) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalAspect.g:262:1: ( ruleAction )
                    {
                    // InternalAspect.g:262:1: ( ruleAction )
                    // InternalAspect.g:263:1: ruleAction
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionOptionTypeAccess().getActionParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleAction();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionOptionTypeAccess().getActionParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAspect.g:268:6: ( ruleUpdateValue )
                    {
                    // InternalAspect.g:268:6: ( ruleUpdateValue )
                    // InternalAspect.g:269:1: ruleUpdateValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionOptionTypeAccess().getUpdateValueParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleUpdateValue();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionOptionTypeAccess().getUpdateValueParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__ActionOptionType__Alternatives"


    // $ANTLR start "rule__Action__Alternatives"
    // InternalAspect.g:279:1: rule__Action__Alternatives : ( ( ( rule__Action__ADDAssignment_0 ) ) | ( ( rule__Action__DELETEAssignment_1 ) ) | ( ( rule__Action__REPLACEAssignment_2 ) ) | ( ( rule__Action__UPDATEAssignment_3 ) ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:283:1: ( ( ( rule__Action__ADDAssignment_0 ) ) | ( ( rule__Action__DELETEAssignment_1 ) ) | ( ( rule__Action__REPLACEAssignment_2 ) ) | ( ( rule__Action__UPDATEAssignment_3 ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt2=1;
                }
                break;
            case 31:
                {
                alt2=2;
                }
                break;
            case 32:
                {
                alt2=3;
                }
                break;
            case 33:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalAspect.g:284:1: ( ( rule__Action__ADDAssignment_0 ) )
                    {
                    // InternalAspect.g:284:1: ( ( rule__Action__ADDAssignment_0 ) )
                    // InternalAspect.g:285:1: ( rule__Action__ADDAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getADDAssignment_0()); 
                    }
                    // InternalAspect.g:286:1: ( rule__Action__ADDAssignment_0 )
                    // InternalAspect.g:286:2: rule__Action__ADDAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__ADDAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getADDAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAspect.g:290:6: ( ( rule__Action__DELETEAssignment_1 ) )
                    {
                    // InternalAspect.g:290:6: ( ( rule__Action__DELETEAssignment_1 ) )
                    // InternalAspect.g:291:1: ( rule__Action__DELETEAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getDELETEAssignment_1()); 
                    }
                    // InternalAspect.g:292:1: ( rule__Action__DELETEAssignment_1 )
                    // InternalAspect.g:292:2: rule__Action__DELETEAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__DELETEAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getDELETEAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAspect.g:296:6: ( ( rule__Action__REPLACEAssignment_2 ) )
                    {
                    // InternalAspect.g:296:6: ( ( rule__Action__REPLACEAssignment_2 ) )
                    // InternalAspect.g:297:1: ( rule__Action__REPLACEAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getREPLACEAssignment_2()); 
                    }
                    // InternalAspect.g:298:1: ( rule__Action__REPLACEAssignment_2 )
                    // InternalAspect.g:298:2: rule__Action__REPLACEAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__REPLACEAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getREPLACEAssignment_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAspect.g:302:6: ( ( rule__Action__UPDATEAssignment_3 ) )
                    {
                    // InternalAspect.g:302:6: ( ( rule__Action__UPDATEAssignment_3 ) )
                    // InternalAspect.g:303:1: ( rule__Action__UPDATEAssignment_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getUPDATEAssignment_3()); 
                    }
                    // InternalAspect.g:304:1: ( rule__Action__UPDATEAssignment_3 )
                    // InternalAspect.g:304:2: rule__Action__UPDATEAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Action__UPDATEAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getUPDATEAssignment_3()); 
                    }

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
    // $ANTLR end "rule__Action__Alternatives"


    // $ANTLR start "rule__Aspect__Group__0"
    // InternalAspect.g:315:1: rule__Aspect__Group__0 : rule__Aspect__Group__0__Impl rule__Aspect__Group__1 ;
    public final void rule__Aspect__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:319:1: ( rule__Aspect__Group__0__Impl rule__Aspect__Group__1 )
            // InternalAspect.g:320:2: rule__Aspect__Group__0__Impl rule__Aspect__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Aspect__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__0"


    // $ANTLR start "rule__Aspect__Group__0__Impl"
    // InternalAspect.g:327:1: rule__Aspect__Group__0__Impl : ( 'aspect' ) ;
    public final void rule__Aspect__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:331:1: ( ( 'aspect' ) )
            // InternalAspect.g:332:1: ( 'aspect' )
            {
            // InternalAspect.g:332:1: ( 'aspect' )
            // InternalAspect.g:333:1: 'aspect'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAspectKeyword_0()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAspectKeyword_0()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__0__Impl"


    // $ANTLR start "rule__Aspect__Group__1"
    // InternalAspect.g:346:1: rule__Aspect__Group__1 : rule__Aspect__Group__1__Impl rule__Aspect__Group__2 ;
    public final void rule__Aspect__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:350:1: ( rule__Aspect__Group__1__Impl rule__Aspect__Group__2 )
            // InternalAspect.g:351:2: rule__Aspect__Group__1__Impl rule__Aspect__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Aspect__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__1"


    // $ANTLR start "rule__Aspect__Group__1__Impl"
    // InternalAspect.g:358:1: rule__Aspect__Group__1__Impl : ( ( rule__Aspect__NameAssignment_1 ) ) ;
    public final void rule__Aspect__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:362:1: ( ( ( rule__Aspect__NameAssignment_1 ) ) )
            // InternalAspect.g:363:1: ( ( rule__Aspect__NameAssignment_1 ) )
            {
            // InternalAspect.g:363:1: ( ( rule__Aspect__NameAssignment_1 ) )
            // InternalAspect.g:364:1: ( rule__Aspect__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:365:1: ( rule__Aspect__NameAssignment_1 )
            // InternalAspect.g:365:2: rule__Aspect__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getNameAssignment_1()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__1__Impl"


    // $ANTLR start "rule__Aspect__Group__2"
    // InternalAspect.g:375:1: rule__Aspect__Group__2 : rule__Aspect__Group__2__Impl rule__Aspect__Group__3 ;
    public final void rule__Aspect__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:379:1: ( rule__Aspect__Group__2__Impl rule__Aspect__Group__3 )
            // InternalAspect.g:380:2: rule__Aspect__Group__2__Impl rule__Aspect__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Aspect__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__2"


    // $ANTLR start "rule__Aspect__Group__2__Impl"
    // InternalAspect.g:387:1: rule__Aspect__Group__2__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:391:1: ( ( '{' ) )
            // InternalAspect.g:392:1: ( '{' )
            {
            // InternalAspect.g:392:1: ( '{' )
            // InternalAspect.g:393:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,13,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__2__Impl"


    // $ANTLR start "rule__Aspect__Group__3"
    // InternalAspect.g:406:1: rule__Aspect__Group__3 : rule__Aspect__Group__3__Impl rule__Aspect__Group__4 ;
    public final void rule__Aspect__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:410:1: ( rule__Aspect__Group__3__Impl rule__Aspect__Group__4 )
            // InternalAspect.g:411:2: rule__Aspect__Group__3__Impl rule__Aspect__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Aspect__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__3"


    // $ANTLR start "rule__Aspect__Group__3__Impl"
    // InternalAspect.g:418:1: rule__Aspect__Group__3__Impl : ( 'feature' ) ;
    public final void rule__Aspect__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:422:1: ( ( 'feature' ) )
            // InternalAspect.g:423:1: ( 'feature' )
            {
            // InternalAspect.g:423:1: ( 'feature' )
            // InternalAspect.g:424:1: 'feature'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureKeyword_3()); 
            }
            match(input,14,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getFeatureKeyword_3()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__3__Impl"


    // $ANTLR start "rule__Aspect__Group__4"
    // InternalAspect.g:437:1: rule__Aspect__Group__4 : rule__Aspect__Group__4__Impl rule__Aspect__Group__5 ;
    public final void rule__Aspect__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:441:1: ( rule__Aspect__Group__4__Impl rule__Aspect__Group__5 )
            // InternalAspect.g:442:2: rule__Aspect__Group__4__Impl rule__Aspect__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__Aspect__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__4"


    // $ANTLR start "rule__Aspect__Group__4__Impl"
    // InternalAspect.g:449:1: rule__Aspect__Group__4__Impl : ( ( rule__Aspect__FeatureAssignment_4 ) ) ;
    public final void rule__Aspect__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:453:1: ( ( ( rule__Aspect__FeatureAssignment_4 ) ) )
            // InternalAspect.g:454:1: ( ( rule__Aspect__FeatureAssignment_4 ) )
            {
            // InternalAspect.g:454:1: ( ( rule__Aspect__FeatureAssignment_4 ) )
            // InternalAspect.g:455:1: ( rule__Aspect__FeatureAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureAssignment_4()); 
            }
            // InternalAspect.g:456:1: ( rule__Aspect__FeatureAssignment_4 )
            // InternalAspect.g:456:2: rule__Aspect__FeatureAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__FeatureAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getFeatureAssignment_4()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__4__Impl"


    // $ANTLR start "rule__Aspect__Group__5"
    // InternalAspect.g:466:1: rule__Aspect__Group__5 : rule__Aspect__Group__5__Impl rule__Aspect__Group__6 ;
    public final void rule__Aspect__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:470:1: ( rule__Aspect__Group__5__Impl rule__Aspect__Group__6 )
            // InternalAspect.g:471:2: rule__Aspect__Group__5__Impl rule__Aspect__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__Aspect__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__6();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__5"


    // $ANTLR start "rule__Aspect__Group__5__Impl"
    // InternalAspect.g:478:1: rule__Aspect__Group__5__Impl : ( ( rule__Aspect__Group_5__0 )? ) ;
    public final void rule__Aspect__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:482:1: ( ( ( rule__Aspect__Group_5__0 )? ) )
            // InternalAspect.g:483:1: ( ( rule__Aspect__Group_5__0 )? )
            {
            // InternalAspect.g:483:1: ( ( rule__Aspect__Group_5__0 )? )
            // InternalAspect.g:484:1: ( rule__Aspect__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup_5()); 
            }
            // InternalAspect.g:485:1: ( rule__Aspect__Group_5__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==19) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // InternalAspect.g:485:2: rule__Aspect__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Aspect__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getGroup_5()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__5__Impl"


    // $ANTLR start "rule__Aspect__Group__6"
    // InternalAspect.g:495:1: rule__Aspect__Group__6 : rule__Aspect__Group__6__Impl rule__Aspect__Group__7 ;
    public final void rule__Aspect__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:499:1: ( rule__Aspect__Group__6__Impl rule__Aspect__Group__7 )
            // InternalAspect.g:500:2: rule__Aspect__Group__6__Impl rule__Aspect__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__Aspect__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__7();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__6"


    // $ANTLR start "rule__Aspect__Group__6__Impl"
    // InternalAspect.g:507:1: rule__Aspect__Group__6__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:511:1: ( ( ',' ) )
            // InternalAspect.g:512:1: ( ',' )
            {
            // InternalAspect.g:512:1: ( ',' )
            // InternalAspect.g:513:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_6()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_6()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__6__Impl"


    // $ANTLR start "rule__Aspect__Group__7"
    // InternalAspect.g:526:1: rule__Aspect__Group__7 : rule__Aspect__Group__7__Impl rule__Aspect__Group__8 ;
    public final void rule__Aspect__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:530:1: ( rule__Aspect__Group__7__Impl rule__Aspect__Group__8 )
            // InternalAspect.g:531:2: rule__Aspect__Group__7__Impl rule__Aspect__Group__8
            {
            pushFollow(FOLLOW_4);
            rule__Aspect__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__8();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__7"


    // $ANTLR start "rule__Aspect__Group__7__Impl"
    // InternalAspect.g:538:1: rule__Aspect__Group__7__Impl : ( 'pointcuts' ) ;
    public final void rule__Aspect__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:542:1: ( ( 'pointcuts' ) )
            // InternalAspect.g:543:1: ( 'pointcuts' )
            {
            // InternalAspect.g:543:1: ( 'pointcuts' )
            // InternalAspect.g:544:1: 'pointcuts'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsKeyword_7()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsKeyword_7()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__7__Impl"


    // $ANTLR start "rule__Aspect__Group__8"
    // InternalAspect.g:557:1: rule__Aspect__Group__8 : rule__Aspect__Group__8__Impl rule__Aspect__Group__9 ;
    public final void rule__Aspect__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:561:1: ( rule__Aspect__Group__8__Impl rule__Aspect__Group__9 )
            // InternalAspect.g:562:2: rule__Aspect__Group__8__Impl rule__Aspect__Group__9
            {
            pushFollow(FOLLOW_8);
            rule__Aspect__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__9();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__8"


    // $ANTLR start "rule__Aspect__Group__8__Impl"
    // InternalAspect.g:569:1: rule__Aspect__Group__8__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:573:1: ( ( '{' ) )
            // InternalAspect.g:574:1: ( '{' )
            {
            // InternalAspect.g:574:1: ( '{' )
            // InternalAspect.g:575:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_8()); 
            }
            match(input,13,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_8()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__8__Impl"


    // $ANTLR start "rule__Aspect__Group__9"
    // InternalAspect.g:588:1: rule__Aspect__Group__9 : rule__Aspect__Group__9__Impl rule__Aspect__Group__10 ;
    public final void rule__Aspect__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:592:1: ( rule__Aspect__Group__9__Impl rule__Aspect__Group__10 )
            // InternalAspect.g:593:2: rule__Aspect__Group__9__Impl rule__Aspect__Group__10
            {
            pushFollow(FOLLOW_9);
            rule__Aspect__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__10();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__9"


    // $ANTLR start "rule__Aspect__Group__9__Impl"
    // InternalAspect.g:600:1: rule__Aspect__Group__9__Impl : ( ( rule__Aspect__PointcutsAssignment_9 ) ) ;
    public final void rule__Aspect__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:604:1: ( ( ( rule__Aspect__PointcutsAssignment_9 ) ) )
            // InternalAspect.g:605:1: ( ( rule__Aspect__PointcutsAssignment_9 ) )
            {
            // InternalAspect.g:605:1: ( ( rule__Aspect__PointcutsAssignment_9 ) )
            // InternalAspect.g:606:1: ( rule__Aspect__PointcutsAssignment_9 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsAssignment_9()); 
            }
            // InternalAspect.g:607:1: ( rule__Aspect__PointcutsAssignment_9 )
            // InternalAspect.g:607:2: rule__Aspect__PointcutsAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__PointcutsAssignment_9();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsAssignment_9()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__9__Impl"


    // $ANTLR start "rule__Aspect__Group__10"
    // InternalAspect.g:617:1: rule__Aspect__Group__10 : rule__Aspect__Group__10__Impl rule__Aspect__Group__11 ;
    public final void rule__Aspect__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:621:1: ( rule__Aspect__Group__10__Impl rule__Aspect__Group__11 )
            // InternalAspect.g:622:2: rule__Aspect__Group__10__Impl rule__Aspect__Group__11
            {
            pushFollow(FOLLOW_9);
            rule__Aspect__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__11();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__10"


    // $ANTLR start "rule__Aspect__Group__10__Impl"
    // InternalAspect.g:629:1: rule__Aspect__Group__10__Impl : ( ( rule__Aspect__Group_10__0 )* ) ;
    public final void rule__Aspect__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:633:1: ( ( ( rule__Aspect__Group_10__0 )* ) )
            // InternalAspect.g:634:1: ( ( rule__Aspect__Group_10__0 )* )
            {
            // InternalAspect.g:634:1: ( ( rule__Aspect__Group_10__0 )* )
            // InternalAspect.g:635:1: ( rule__Aspect__Group_10__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup_10()); 
            }
            // InternalAspect.g:636:1: ( rule__Aspect__Group_10__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAspect.g:636:2: rule__Aspect__Group_10__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Aspect__Group_10__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getGroup_10()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__10__Impl"


    // $ANTLR start "rule__Aspect__Group__11"
    // InternalAspect.g:646:1: rule__Aspect__Group__11 : rule__Aspect__Group__11__Impl rule__Aspect__Group__12 ;
    public final void rule__Aspect__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:650:1: ( rule__Aspect__Group__11__Impl rule__Aspect__Group__12 )
            // InternalAspect.g:651:2: rule__Aspect__Group__11__Impl rule__Aspect__Group__12
            {
            pushFollow(FOLLOW_6);
            rule__Aspect__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__12();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__11"


    // $ANTLR start "rule__Aspect__Group__11__Impl"
    // InternalAspect.g:658:1: rule__Aspect__Group__11__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:662:1: ( ( '}' ) )
            // InternalAspect.g:663:1: ( '}' )
            {
            // InternalAspect.g:663:1: ( '}' )
            // InternalAspect.g:664:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_11()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_11()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__11__Impl"


    // $ANTLR start "rule__Aspect__Group__12"
    // InternalAspect.g:677:1: rule__Aspect__Group__12 : rule__Aspect__Group__12__Impl rule__Aspect__Group__13 ;
    public final void rule__Aspect__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:681:1: ( rule__Aspect__Group__12__Impl rule__Aspect__Group__13 )
            // InternalAspect.g:682:2: rule__Aspect__Group__12__Impl rule__Aspect__Group__13
            {
            pushFollow(FOLLOW_11);
            rule__Aspect__Group__12__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__13();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__12"


    // $ANTLR start "rule__Aspect__Group__12__Impl"
    // InternalAspect.g:689:1: rule__Aspect__Group__12__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:693:1: ( ( ',' ) )
            // InternalAspect.g:694:1: ( ',' )
            {
            // InternalAspect.g:694:1: ( ',' )
            // InternalAspect.g:695:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_12()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_12()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__12__Impl"


    // $ANTLR start "rule__Aspect__Group__13"
    // InternalAspect.g:708:1: rule__Aspect__Group__13 : rule__Aspect__Group__13__Impl rule__Aspect__Group__14 ;
    public final void rule__Aspect__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:712:1: ( rule__Aspect__Group__13__Impl rule__Aspect__Group__14 )
            // InternalAspect.g:713:2: rule__Aspect__Group__13__Impl rule__Aspect__Group__14
            {
            pushFollow(FOLLOW_4);
            rule__Aspect__Group__13__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__14();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__13"


    // $ANTLR start "rule__Aspect__Group__13__Impl"
    // InternalAspect.g:720:1: rule__Aspect__Group__13__Impl : ( 'compositions' ) ;
    public final void rule__Aspect__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:724:1: ( ( 'compositions' ) )
            // InternalAspect.g:725:1: ( 'compositions' )
            {
            // InternalAspect.g:725:1: ( 'compositions' )
            // InternalAspect.g:726:1: 'compositions'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsKeyword_13()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsKeyword_13()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__13__Impl"


    // $ANTLR start "rule__Aspect__Group__14"
    // InternalAspect.g:739:1: rule__Aspect__Group__14 : rule__Aspect__Group__14__Impl rule__Aspect__Group__15 ;
    public final void rule__Aspect__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:743:1: ( rule__Aspect__Group__14__Impl rule__Aspect__Group__15 )
            // InternalAspect.g:744:2: rule__Aspect__Group__14__Impl rule__Aspect__Group__15
            {
            pushFollow(FOLLOW_12);
            rule__Aspect__Group__14__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__15();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__14"


    // $ANTLR start "rule__Aspect__Group__14__Impl"
    // InternalAspect.g:751:1: rule__Aspect__Group__14__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:755:1: ( ( '{' ) )
            // InternalAspect.g:756:1: ( '{' )
            {
            // InternalAspect.g:756:1: ( '{' )
            // InternalAspect.g:757:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_14()); 
            }
            match(input,13,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_14()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__14__Impl"


    // $ANTLR start "rule__Aspect__Group__15"
    // InternalAspect.g:770:1: rule__Aspect__Group__15 : rule__Aspect__Group__15__Impl rule__Aspect__Group__16 ;
    public final void rule__Aspect__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:774:1: ( rule__Aspect__Group__15__Impl rule__Aspect__Group__16 )
            // InternalAspect.g:775:2: rule__Aspect__Group__15__Impl rule__Aspect__Group__16
            {
            pushFollow(FOLLOW_9);
            rule__Aspect__Group__15__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__16();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__15"


    // $ANTLR start "rule__Aspect__Group__15__Impl"
    // InternalAspect.g:782:1: rule__Aspect__Group__15__Impl : ( ( rule__Aspect__CompositionsAssignment_15 ) ) ;
    public final void rule__Aspect__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:786:1: ( ( ( rule__Aspect__CompositionsAssignment_15 ) ) )
            // InternalAspect.g:787:1: ( ( rule__Aspect__CompositionsAssignment_15 ) )
            {
            // InternalAspect.g:787:1: ( ( rule__Aspect__CompositionsAssignment_15 ) )
            // InternalAspect.g:788:1: ( rule__Aspect__CompositionsAssignment_15 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsAssignment_15()); 
            }
            // InternalAspect.g:789:1: ( rule__Aspect__CompositionsAssignment_15 )
            // InternalAspect.g:789:2: rule__Aspect__CompositionsAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__CompositionsAssignment_15();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsAssignment_15()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__15__Impl"


    // $ANTLR start "rule__Aspect__Group__16"
    // InternalAspect.g:799:1: rule__Aspect__Group__16 : rule__Aspect__Group__16__Impl rule__Aspect__Group__17 ;
    public final void rule__Aspect__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:803:1: ( rule__Aspect__Group__16__Impl rule__Aspect__Group__17 )
            // InternalAspect.g:804:2: rule__Aspect__Group__16__Impl rule__Aspect__Group__17
            {
            pushFollow(FOLLOW_9);
            rule__Aspect__Group__16__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__17();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__16"


    // $ANTLR start "rule__Aspect__Group__16__Impl"
    // InternalAspect.g:811:1: rule__Aspect__Group__16__Impl : ( ( rule__Aspect__Group_16__0 )* ) ;
    public final void rule__Aspect__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:815:1: ( ( ( rule__Aspect__Group_16__0 )* ) )
            // InternalAspect.g:816:1: ( ( rule__Aspect__Group_16__0 )* )
            {
            // InternalAspect.g:816:1: ( ( rule__Aspect__Group_16__0 )* )
            // InternalAspect.g:817:1: ( rule__Aspect__Group_16__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup_16()); 
            }
            // InternalAspect.g:818:1: ( rule__Aspect__Group_16__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalAspect.g:818:2: rule__Aspect__Group_16__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Aspect__Group_16__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getGroup_16()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__16__Impl"


    // $ANTLR start "rule__Aspect__Group__17"
    // InternalAspect.g:828:1: rule__Aspect__Group__17 : rule__Aspect__Group__17__Impl rule__Aspect__Group__18 ;
    public final void rule__Aspect__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:832:1: ( rule__Aspect__Group__17__Impl rule__Aspect__Group__18 )
            // InternalAspect.g:833:2: rule__Aspect__Group__17__Impl rule__Aspect__Group__18
            {
            pushFollow(FOLLOW_13);
            rule__Aspect__Group__17__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__18();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__17"


    // $ANTLR start "rule__Aspect__Group__17__Impl"
    // InternalAspect.g:840:1: rule__Aspect__Group__17__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:844:1: ( ( '}' ) )
            // InternalAspect.g:845:1: ( '}' )
            {
            // InternalAspect.g:845:1: ( '}' )
            // InternalAspect.g:846:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_17()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_17()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__17__Impl"


    // $ANTLR start "rule__Aspect__Group__18"
    // InternalAspect.g:859:1: rule__Aspect__Group__18 : rule__Aspect__Group__18__Impl ;
    public final void rule__Aspect__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:863:1: ( rule__Aspect__Group__18__Impl )
            // InternalAspect.g:864:2: rule__Aspect__Group__18__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__18__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group__18"


    // $ANTLR start "rule__Aspect__Group__18__Impl"
    // InternalAspect.g:870:1: rule__Aspect__Group__18__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:874:1: ( ( '}' ) )
            // InternalAspect.g:875:1: ( '}' )
            {
            // InternalAspect.g:875:1: ( '}' )
            // InternalAspect.g:876:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_18()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_18()); 
            }

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
    // $ANTLR end "rule__Aspect__Group__18__Impl"


    // $ANTLR start "rule__Aspect__Group_5__0"
    // InternalAspect.g:927:1: rule__Aspect__Group_5__0 : rule__Aspect__Group_5__0__Impl rule__Aspect__Group_5__1 ;
    public final void rule__Aspect__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:931:1: ( rule__Aspect__Group_5__0__Impl rule__Aspect__Group_5__1 )
            // InternalAspect.g:932:2: rule__Aspect__Group_5__0__Impl rule__Aspect__Group_5__1
            {
            pushFollow(FOLLOW_14);
            rule__Aspect__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group_5__0"


    // $ANTLR start "rule__Aspect__Group_5__0__Impl"
    // InternalAspect.g:939:1: rule__Aspect__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Aspect__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:943:1: ( ( ',' ) )
            // InternalAspect.g:944:1: ( ',' )
            {
            // InternalAspect.g:944:1: ( ',' )
            // InternalAspect.g:945:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_5_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_5_0()); 
            }

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
    // $ANTLR end "rule__Aspect__Group_5__0__Impl"


    // $ANTLR start "rule__Aspect__Group_5__1"
    // InternalAspect.g:958:1: rule__Aspect__Group_5__1 : rule__Aspect__Group_5__1__Impl rule__Aspect__Group_5__2 ;
    public final void rule__Aspect__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:962:1: ( rule__Aspect__Group_5__1__Impl rule__Aspect__Group_5__2 )
            // InternalAspect.g:963:2: rule__Aspect__Group_5__1__Impl rule__Aspect__Group_5__2
            {
            pushFollow(FOLLOW_3);
            rule__Aspect__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group_5__1"


    // $ANTLR start "rule__Aspect__Group_5__1__Impl"
    // InternalAspect.g:970:1: rule__Aspect__Group_5__1__Impl : ( 'advice' ) ;
    public final void rule__Aspect__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:974:1: ( ( 'advice' ) )
            // InternalAspect.g:975:1: ( 'advice' )
            {
            // InternalAspect.g:975:1: ( 'advice' )
            // InternalAspect.g:976:1: 'advice'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceKeyword_5_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceKeyword_5_1()); 
            }

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
    // $ANTLR end "rule__Aspect__Group_5__1__Impl"


    // $ANTLR start "rule__Aspect__Group_5__2"
    // InternalAspect.g:989:1: rule__Aspect__Group_5__2 : rule__Aspect__Group_5__2__Impl ;
    public final void rule__Aspect__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:993:1: ( rule__Aspect__Group_5__2__Impl )
            // InternalAspect.g:994:2: rule__Aspect__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group_5__2"


    // $ANTLR start "rule__Aspect__Group_5__2__Impl"
    // InternalAspect.g:1000:1: rule__Aspect__Group_5__2__Impl : ( ( rule__Aspect__AdviceAssignment_5_2 ) ) ;
    public final void rule__Aspect__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1004:1: ( ( ( rule__Aspect__AdviceAssignment_5_2 ) ) )
            // InternalAspect.g:1005:1: ( ( rule__Aspect__AdviceAssignment_5_2 ) )
            {
            // InternalAspect.g:1005:1: ( ( rule__Aspect__AdviceAssignment_5_2 ) )
            // InternalAspect.g:1006:1: ( rule__Aspect__AdviceAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceAssignment_5_2()); 
            }
            // InternalAspect.g:1007:1: ( rule__Aspect__AdviceAssignment_5_2 )
            // InternalAspect.g:1007:2: rule__Aspect__AdviceAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__AdviceAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceAssignment_5_2()); 
            }

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
    // $ANTLR end "rule__Aspect__Group_5__2__Impl"


    // $ANTLR start "rule__Aspect__Group_10__0"
    // InternalAspect.g:1023:1: rule__Aspect__Group_10__0 : rule__Aspect__Group_10__0__Impl rule__Aspect__Group_10__1 ;
    public final void rule__Aspect__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1027:1: ( rule__Aspect__Group_10__0__Impl rule__Aspect__Group_10__1 )
            // InternalAspect.g:1028:2: rule__Aspect__Group_10__0__Impl rule__Aspect__Group_10__1
            {
            pushFollow(FOLLOW_8);
            rule__Aspect__Group_10__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_10__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group_10__0"


    // $ANTLR start "rule__Aspect__Group_10__0__Impl"
    // InternalAspect.g:1035:1: rule__Aspect__Group_10__0__Impl : ( ',' ) ;
    public final void rule__Aspect__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1039:1: ( ( ',' ) )
            // InternalAspect.g:1040:1: ( ',' )
            {
            // InternalAspect.g:1040:1: ( ',' )
            // InternalAspect.g:1041:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_10_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_10_0()); 
            }

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
    // $ANTLR end "rule__Aspect__Group_10__0__Impl"


    // $ANTLR start "rule__Aspect__Group_10__1"
    // InternalAspect.g:1054:1: rule__Aspect__Group_10__1 : rule__Aspect__Group_10__1__Impl ;
    public final void rule__Aspect__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1058:1: ( rule__Aspect__Group_10__1__Impl )
            // InternalAspect.g:1059:2: rule__Aspect__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_10__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group_10__1"


    // $ANTLR start "rule__Aspect__Group_10__1__Impl"
    // InternalAspect.g:1065:1: rule__Aspect__Group_10__1__Impl : ( ( rule__Aspect__PointcutsAssignment_10_1 ) ) ;
    public final void rule__Aspect__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1069:1: ( ( ( rule__Aspect__PointcutsAssignment_10_1 ) ) )
            // InternalAspect.g:1070:1: ( ( rule__Aspect__PointcutsAssignment_10_1 ) )
            {
            // InternalAspect.g:1070:1: ( ( rule__Aspect__PointcutsAssignment_10_1 ) )
            // InternalAspect.g:1071:1: ( rule__Aspect__PointcutsAssignment_10_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsAssignment_10_1()); 
            }
            // InternalAspect.g:1072:1: ( rule__Aspect__PointcutsAssignment_10_1 )
            // InternalAspect.g:1072:2: rule__Aspect__PointcutsAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__PointcutsAssignment_10_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsAssignment_10_1()); 
            }

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
    // $ANTLR end "rule__Aspect__Group_10__1__Impl"


    // $ANTLR start "rule__Aspect__Group_16__0"
    // InternalAspect.g:1086:1: rule__Aspect__Group_16__0 : rule__Aspect__Group_16__0__Impl rule__Aspect__Group_16__1 ;
    public final void rule__Aspect__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1090:1: ( rule__Aspect__Group_16__0__Impl rule__Aspect__Group_16__1 )
            // InternalAspect.g:1091:2: rule__Aspect__Group_16__0__Impl rule__Aspect__Group_16__1
            {
            pushFollow(FOLLOW_12);
            rule__Aspect__Group_16__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_16__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group_16__0"


    // $ANTLR start "rule__Aspect__Group_16__0__Impl"
    // InternalAspect.g:1098:1: rule__Aspect__Group_16__0__Impl : ( ',' ) ;
    public final void rule__Aspect__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1102:1: ( ( ',' ) )
            // InternalAspect.g:1103:1: ( ',' )
            {
            // InternalAspect.g:1103:1: ( ',' )
            // InternalAspect.g:1104:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_16_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_16_0()); 
            }

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
    // $ANTLR end "rule__Aspect__Group_16__0__Impl"


    // $ANTLR start "rule__Aspect__Group_16__1"
    // InternalAspect.g:1117:1: rule__Aspect__Group_16__1 : rule__Aspect__Group_16__1__Impl ;
    public final void rule__Aspect__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1121:1: ( rule__Aspect__Group_16__1__Impl )
            // InternalAspect.g:1122:2: rule__Aspect__Group_16__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_16__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Aspect__Group_16__1"


    // $ANTLR start "rule__Aspect__Group_16__1__Impl"
    // InternalAspect.g:1128:1: rule__Aspect__Group_16__1__Impl : ( ( rule__Aspect__CompositionsAssignment_16_1 ) ) ;
    public final void rule__Aspect__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1132:1: ( ( ( rule__Aspect__CompositionsAssignment_16_1 ) ) )
            // InternalAspect.g:1133:1: ( ( rule__Aspect__CompositionsAssignment_16_1 ) )
            {
            // InternalAspect.g:1133:1: ( ( rule__Aspect__CompositionsAssignment_16_1 ) )
            // InternalAspect.g:1134:1: ( rule__Aspect__CompositionsAssignment_16_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsAssignment_16_1()); 
            }
            // InternalAspect.g:1135:1: ( rule__Aspect__CompositionsAssignment_16_1 )
            // InternalAspect.g:1135:2: rule__Aspect__CompositionsAssignment_16_1
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__CompositionsAssignment_16_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsAssignment_16_1()); 
            }

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
    // $ANTLR end "rule__Aspect__Group_16__1__Impl"


    // $ANTLR start "rule__Pointcut__Group__0"
    // InternalAspect.g:1149:1: rule__Pointcut__Group__0 : rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1 ;
    public final void rule__Pointcut__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1153:1: ( rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1 )
            // InternalAspect.g:1154:2: rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Pointcut__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group__0"


    // $ANTLR start "rule__Pointcut__Group__0__Impl"
    // InternalAspect.g:1161:1: rule__Pointcut__Group__0__Impl : ( 'pointcut' ) ;
    public final void rule__Pointcut__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1165:1: ( ( 'pointcut' ) )
            // InternalAspect.g:1166:1: ( 'pointcut' )
            {
            // InternalAspect.g:1166:1: ( 'pointcut' )
            // InternalAspect.g:1167:1: 'pointcut'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPointcutKeyword_0()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getPointcutKeyword_0()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group__0__Impl"


    // $ANTLR start "rule__Pointcut__Group__1"
    // InternalAspect.g:1180:1: rule__Pointcut__Group__1 : rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2 ;
    public final void rule__Pointcut__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1184:1: ( rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2 )
            // InternalAspect.g:1185:2: rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Pointcut__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group__1"


    // $ANTLR start "rule__Pointcut__Group__1__Impl"
    // InternalAspect.g:1192:1: rule__Pointcut__Group__1__Impl : ( ( rule__Pointcut__NameAssignment_1 ) ) ;
    public final void rule__Pointcut__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1196:1: ( ( ( rule__Pointcut__NameAssignment_1 ) ) )
            // InternalAspect.g:1197:1: ( ( rule__Pointcut__NameAssignment_1 ) )
            {
            // InternalAspect.g:1197:1: ( ( rule__Pointcut__NameAssignment_1 ) )
            // InternalAspect.g:1198:1: ( rule__Pointcut__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:1199:1: ( rule__Pointcut__NameAssignment_1 )
            // InternalAspect.g:1199:2: rule__Pointcut__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Pointcut__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getNameAssignment_1()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group__1__Impl"


    // $ANTLR start "rule__Pointcut__Group__2"
    // InternalAspect.g:1209:1: rule__Pointcut__Group__2 : rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3 ;
    public final void rule__Pointcut__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1213:1: ( rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3 )
            // InternalAspect.g:1214:2: rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3
            {
            pushFollow(FOLLOW_15);
            rule__Pointcut__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group__2"


    // $ANTLR start "rule__Pointcut__Group__2__Impl"
    // InternalAspect.g:1221:1: rule__Pointcut__Group__2__Impl : ( '{' ) ;
    public final void rule__Pointcut__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1225:1: ( ( '{' ) )
            // InternalAspect.g:1226:1: ( '{' )
            {
            // InternalAspect.g:1226:1: ( '{' )
            // InternalAspect.g:1227:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,13,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group__2__Impl"


    // $ANTLR start "rule__Pointcut__Group__3"
    // InternalAspect.g:1240:1: rule__Pointcut__Group__3 : rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4 ;
    public final void rule__Pointcut__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1244:1: ( rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4 )
            // InternalAspect.g:1245:2: rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Pointcut__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group__3"


    // $ANTLR start "rule__Pointcut__Group__3__Impl"
    // InternalAspect.g:1252:1: rule__Pointcut__Group__3__Impl : ( 'pattern' ) ;
    public final void rule__Pointcut__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1256:1: ( ( 'pattern' ) )
            // InternalAspect.g:1257:1: ( 'pattern' )
            {
            // InternalAspect.g:1257:1: ( 'pattern' )
            // InternalAspect.g:1258:1: 'pattern'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternKeyword_3()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getPatternKeyword_3()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group__3__Impl"


    // $ANTLR start "rule__Pointcut__Group__4"
    // InternalAspect.g:1271:1: rule__Pointcut__Group__4 : rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5 ;
    public final void rule__Pointcut__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1275:1: ( rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5 )
            // InternalAspect.g:1276:2: rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Pointcut__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group__4"


    // $ANTLR start "rule__Pointcut__Group__4__Impl"
    // InternalAspect.g:1283:1: rule__Pointcut__Group__4__Impl : ( ( rule__Pointcut__PatternAssignment_4 ) ) ;
    public final void rule__Pointcut__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1287:1: ( ( ( rule__Pointcut__PatternAssignment_4 ) ) )
            // InternalAspect.g:1288:1: ( ( rule__Pointcut__PatternAssignment_4 ) )
            {
            // InternalAspect.g:1288:1: ( ( rule__Pointcut__PatternAssignment_4 ) )
            // InternalAspect.g:1289:1: ( rule__Pointcut__PatternAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternAssignment_4()); 
            }
            // InternalAspect.g:1290:1: ( rule__Pointcut__PatternAssignment_4 )
            // InternalAspect.g:1290:2: rule__Pointcut__PatternAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Pointcut__PatternAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getPatternAssignment_4()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group__4__Impl"


    // $ANTLR start "rule__Pointcut__Group__5"
    // InternalAspect.g:1300:1: rule__Pointcut__Group__5 : rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6 ;
    public final void rule__Pointcut__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1304:1: ( rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6 )
            // InternalAspect.g:1305:2: rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Pointcut__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__6();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group__5"


    // $ANTLR start "rule__Pointcut__Group__5__Impl"
    // InternalAspect.g:1312:1: rule__Pointcut__Group__5__Impl : ( ( rule__Pointcut__Group_5__0 )? ) ;
    public final void rule__Pointcut__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1316:1: ( ( ( rule__Pointcut__Group_5__0 )? ) )
            // InternalAspect.g:1317:1: ( ( rule__Pointcut__Group_5__0 )? )
            {
            // InternalAspect.g:1317:1: ( ( rule__Pointcut__Group_5__0 )? )
            // InternalAspect.g:1318:1: ( rule__Pointcut__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getGroup_5()); 
            }
            // InternalAspect.g:1319:1: ( rule__Pointcut__Group_5__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAspect.g:1319:2: rule__Pointcut__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Pointcut__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getGroup_5()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group__5__Impl"


    // $ANTLR start "rule__Pointcut__Group__6"
    // InternalAspect.g:1329:1: rule__Pointcut__Group__6 : rule__Pointcut__Group__6__Impl ;
    public final void rule__Pointcut__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1333:1: ( rule__Pointcut__Group__6__Impl )
            // InternalAspect.g:1334:2: rule__Pointcut__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group__6"


    // $ANTLR start "rule__Pointcut__Group__6__Impl"
    // InternalAspect.g:1340:1: rule__Pointcut__Group__6__Impl : ( '}' ) ;
    public final void rule__Pointcut__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1344:1: ( ( '}' ) )
            // InternalAspect.g:1345:1: ( '}' )
            {
            // InternalAspect.g:1345:1: ( '}' )
            // InternalAspect.g:1346:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getRightCurlyBracketKeyword_6()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group__6__Impl"


    // $ANTLR start "rule__Pointcut__Group_5__0"
    // InternalAspect.g:1373:1: rule__Pointcut__Group_5__0 : rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1 ;
    public final void rule__Pointcut__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1377:1: ( rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1 )
            // InternalAspect.g:1378:2: rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1
            {
            pushFollow(FOLLOW_16);
            rule__Pointcut__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group_5__0"


    // $ANTLR start "rule__Pointcut__Group_5__0__Impl"
    // InternalAspect.g:1385:1: rule__Pointcut__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Pointcut__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1389:1: ( ( ',' ) )
            // InternalAspect.g:1390:1: ( ',' )
            {
            // InternalAspect.g:1390:1: ( ',' )
            // InternalAspect.g:1391:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getCommaKeyword_5_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getCommaKeyword_5_0()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group_5__0__Impl"


    // $ANTLR start "rule__Pointcut__Group_5__1"
    // InternalAspect.g:1404:1: rule__Pointcut__Group_5__1 : rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2 ;
    public final void rule__Pointcut__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1408:1: ( rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2 )
            // InternalAspect.g:1409:2: rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2
            {
            pushFollow(FOLLOW_3);
            rule__Pointcut__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group_5__1"


    // $ANTLR start "rule__Pointcut__Group_5__1__Impl"
    // InternalAspect.g:1416:1: rule__Pointcut__Group_5__1__Impl : ( 'role' ) ;
    public final void rule__Pointcut__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1420:1: ( ( 'role' ) )
            // InternalAspect.g:1421:1: ( 'role' )
            {
            // InternalAspect.g:1421:1: ( 'role' )
            // InternalAspect.g:1422:1: 'role'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleKeyword_5_1()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getRoleKeyword_5_1()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group_5__1__Impl"


    // $ANTLR start "rule__Pointcut__Group_5__2"
    // InternalAspect.g:1435:1: rule__Pointcut__Group_5__2 : rule__Pointcut__Group_5__2__Impl ;
    public final void rule__Pointcut__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1439:1: ( rule__Pointcut__Group_5__2__Impl )
            // InternalAspect.g:1440:2: rule__Pointcut__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Pointcut__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Pointcut__Group_5__2"


    // $ANTLR start "rule__Pointcut__Group_5__2__Impl"
    // InternalAspect.g:1446:1: rule__Pointcut__Group_5__2__Impl : ( ( rule__Pointcut__RoleAssignment_5_2 ) ) ;
    public final void rule__Pointcut__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1450:1: ( ( ( rule__Pointcut__RoleAssignment_5_2 ) ) )
            // InternalAspect.g:1451:1: ( ( rule__Pointcut__RoleAssignment_5_2 ) )
            {
            // InternalAspect.g:1451:1: ( ( rule__Pointcut__RoleAssignment_5_2 ) )
            // InternalAspect.g:1452:1: ( rule__Pointcut__RoleAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleAssignment_5_2()); 
            }
            // InternalAspect.g:1453:1: ( rule__Pointcut__RoleAssignment_5_2 )
            // InternalAspect.g:1453:2: rule__Pointcut__RoleAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__Pointcut__RoleAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getRoleAssignment_5_2()); 
            }

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
    // $ANTLR end "rule__Pointcut__Group_5__2__Impl"


    // $ANTLR start "rule__Composition__Group__0"
    // InternalAspect.g:1469:1: rule__Composition__Group__0 : rule__Composition__Group__0__Impl rule__Composition__Group__1 ;
    public final void rule__Composition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1473:1: ( rule__Composition__Group__0__Impl rule__Composition__Group__1 )
            // InternalAspect.g:1474:2: rule__Composition__Group__0__Impl rule__Composition__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Composition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__0"


    // $ANTLR start "rule__Composition__Group__0__Impl"
    // InternalAspect.g:1481:1: rule__Composition__Group__0__Impl : ( 'composition' ) ;
    public final void rule__Composition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1485:1: ( ( 'composition' ) )
            // InternalAspect.g:1486:1: ( 'composition' )
            {
            // InternalAspect.g:1486:1: ( 'composition' )
            // InternalAspect.g:1487:1: 'composition'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCompositionKeyword_0()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getCompositionKeyword_0()); 
            }

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
    // $ANTLR end "rule__Composition__Group__0__Impl"


    // $ANTLR start "rule__Composition__Group__1"
    // InternalAspect.g:1500:1: rule__Composition__Group__1 : rule__Composition__Group__1__Impl rule__Composition__Group__2 ;
    public final void rule__Composition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1504:1: ( rule__Composition__Group__1__Impl rule__Composition__Group__2 )
            // InternalAspect.g:1505:2: rule__Composition__Group__1__Impl rule__Composition__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Composition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__1"


    // $ANTLR start "rule__Composition__Group__1__Impl"
    // InternalAspect.g:1512:1: rule__Composition__Group__1__Impl : ( ( rule__Composition__NameAssignment_1 ) ) ;
    public final void rule__Composition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1516:1: ( ( ( rule__Composition__NameAssignment_1 ) ) )
            // InternalAspect.g:1517:1: ( ( rule__Composition__NameAssignment_1 ) )
            {
            // InternalAspect.g:1517:1: ( ( rule__Composition__NameAssignment_1 ) )
            // InternalAspect.g:1518:1: ( rule__Composition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:1519:1: ( rule__Composition__NameAssignment_1 )
            // InternalAspect.g:1519:2: rule__Composition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Composition__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getNameAssignment_1()); 
            }

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
    // $ANTLR end "rule__Composition__Group__1__Impl"


    // $ANTLR start "rule__Composition__Group__2"
    // InternalAspect.g:1529:1: rule__Composition__Group__2 : rule__Composition__Group__2__Impl rule__Composition__Group__3 ;
    public final void rule__Composition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1533:1: ( rule__Composition__Group__2__Impl rule__Composition__Group__3 )
            // InternalAspect.g:1534:2: rule__Composition__Group__2__Impl rule__Composition__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__Composition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__2"


    // $ANTLR start "rule__Composition__Group__2__Impl"
    // InternalAspect.g:1541:1: rule__Composition__Group__2__Impl : ( '{' ) ;
    public final void rule__Composition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1545:1: ( ( '{' ) )
            // InternalAspect.g:1546:1: ( '{' )
            {
            // InternalAspect.g:1546:1: ( '{' )
            // InternalAspect.g:1547:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,13,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__Composition__Group__2__Impl"


    // $ANTLR start "rule__Composition__Group__3"
    // InternalAspect.g:1560:1: rule__Composition__Group__3 : rule__Composition__Group__3__Impl rule__Composition__Group__4 ;
    public final void rule__Composition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1564:1: ( rule__Composition__Group__3__Impl rule__Composition__Group__4 )
            // InternalAspect.g:1565:2: rule__Composition__Group__3__Impl rule__Composition__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__Composition__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__3"


    // $ANTLR start "rule__Composition__Group__3__Impl"
    // InternalAspect.g:1572:1: rule__Composition__Group__3__Impl : ( 'feature_enabled' ) ;
    public final void rule__Composition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1576:1: ( ( 'feature_enabled' ) )
            // InternalAspect.g:1577:1: ( 'feature_enabled' )
            {
            // InternalAspect.g:1577:1: ( 'feature_enabled' )
            // InternalAspect.g:1578:1: 'feature_enabled'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getFeature_enabledKeyword_3()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getFeature_enabledKeyword_3()); 
            }

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
    // $ANTLR end "rule__Composition__Group__3__Impl"


    // $ANTLR start "rule__Composition__Group__4"
    // InternalAspect.g:1591:1: rule__Composition__Group__4 : rule__Composition__Group__4__Impl rule__Composition__Group__5 ;
    public final void rule__Composition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1595:1: ( rule__Composition__Group__4__Impl rule__Composition__Group__5 )
            // InternalAspect.g:1596:2: rule__Composition__Group__4__Impl rule__Composition__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__Composition__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__4"


    // $ANTLR start "rule__Composition__Group__4__Impl"
    // InternalAspect.g:1603:1: rule__Composition__Group__4__Impl : ( ( rule__Composition__Feature_enabledAssignment_4 ) ) ;
    public final void rule__Composition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1607:1: ( ( ( rule__Composition__Feature_enabledAssignment_4 ) ) )
            // InternalAspect.g:1608:1: ( ( rule__Composition__Feature_enabledAssignment_4 ) )
            {
            // InternalAspect.g:1608:1: ( ( rule__Composition__Feature_enabledAssignment_4 ) )
            // InternalAspect.g:1609:1: ( rule__Composition__Feature_enabledAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getFeature_enabledAssignment_4()); 
            }
            // InternalAspect.g:1610:1: ( rule__Composition__Feature_enabledAssignment_4 )
            // InternalAspect.g:1610:2: rule__Composition__Feature_enabledAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Composition__Feature_enabledAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getFeature_enabledAssignment_4()); 
            }

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
    // $ANTLR end "rule__Composition__Group__4__Impl"


    // $ANTLR start "rule__Composition__Group__5"
    // InternalAspect.g:1620:1: rule__Composition__Group__5 : rule__Composition__Group__5__Impl rule__Composition__Group__6 ;
    public final void rule__Composition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1624:1: ( rule__Composition__Group__5__Impl rule__Composition__Group__6 )
            // InternalAspect.g:1625:2: rule__Composition__Group__5__Impl rule__Composition__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__Composition__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__6();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__5"


    // $ANTLR start "rule__Composition__Group__5__Impl"
    // InternalAspect.g:1632:1: rule__Composition__Group__5__Impl : ( ( rule__Composition__Group_5__0 )? ) ;
    public final void rule__Composition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1636:1: ( ( ( rule__Composition__Group_5__0 )? ) )
            // InternalAspect.g:1637:1: ( ( rule__Composition__Group_5__0 )? )
            {
            // InternalAspect.g:1637:1: ( ( rule__Composition__Group_5__0 )? )
            // InternalAspect.g:1638:1: ( rule__Composition__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup_5()); 
            }
            // InternalAspect.g:1639:1: ( rule__Composition__Group_5__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==26) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalAspect.g:1639:2: rule__Composition__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Composition__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getGroup_5()); 
            }

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
    // $ANTLR end "rule__Composition__Group__5__Impl"


    // $ANTLR start "rule__Composition__Group__6"
    // InternalAspect.g:1649:1: rule__Composition__Group__6 : rule__Composition__Group__6__Impl rule__Composition__Group__7 ;
    public final void rule__Composition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1653:1: ( rule__Composition__Group__6__Impl rule__Composition__Group__7 )
            // InternalAspect.g:1654:2: rule__Composition__Group__6__Impl rule__Composition__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__Composition__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__7();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__6"


    // $ANTLR start "rule__Composition__Group__6__Impl"
    // InternalAspect.g:1661:1: rule__Composition__Group__6__Impl : ( ( rule__Composition__Group_6__0 )? ) ;
    public final void rule__Composition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1665:1: ( ( ( rule__Composition__Group_6__0 )? ) )
            // InternalAspect.g:1666:1: ( ( rule__Composition__Group_6__0 )? )
            {
            // InternalAspect.g:1666:1: ( ( rule__Composition__Group_6__0 )? )
            // InternalAspect.g:1667:1: ( rule__Composition__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup_6()); 
            }
            // InternalAspect.g:1668:1: ( rule__Composition__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==27) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // InternalAspect.g:1668:2: rule__Composition__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Composition__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getGroup_6()); 
            }

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
    // $ANTLR end "rule__Composition__Group__6__Impl"


    // $ANTLR start "rule__Composition__Group__7"
    // InternalAspect.g:1678:1: rule__Composition__Group__7 : rule__Composition__Group__7__Impl rule__Composition__Group__8 ;
    public final void rule__Composition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1682:1: ( rule__Composition__Group__7__Impl rule__Composition__Group__8 )
            // InternalAspect.g:1683:2: rule__Composition__Group__7__Impl rule__Composition__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__Composition__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__8();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__7"


    // $ANTLR start "rule__Composition__Group__7__Impl"
    // InternalAspect.g:1690:1: rule__Composition__Group__7__Impl : ( ',' ) ;
    public final void rule__Composition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1694:1: ( ( ',' ) )
            // InternalAspect.g:1695:1: ( ',' )
            {
            // InternalAspect.g:1695:1: ( ',' )
            // InternalAspect.g:1696:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCommaKeyword_7()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getCommaKeyword_7()); 
            }

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
    // $ANTLR end "rule__Composition__Group__7__Impl"


    // $ANTLR start "rule__Composition__Group__8"
    // InternalAspect.g:1709:1: rule__Composition__Group__8 : rule__Composition__Group__8__Impl rule__Composition__Group__9 ;
    public final void rule__Composition__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1713:1: ( rule__Composition__Group__8__Impl rule__Composition__Group__9 )
            // InternalAspect.g:1714:2: rule__Composition__Group__8__Impl rule__Composition__Group__9
            {
            pushFollow(FOLLOW_20);
            rule__Composition__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__9();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__8"


    // $ANTLR start "rule__Composition__Group__8__Impl"
    // InternalAspect.g:1721:1: rule__Composition__Group__8__Impl : ( 'action' ) ;
    public final void rule__Composition__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1725:1: ( ( 'action' ) )
            // InternalAspect.g:1726:1: ( 'action' )
            {
            // InternalAspect.g:1726:1: ( 'action' )
            // InternalAspect.g:1727:1: 'action'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getActionKeyword_8()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getActionKeyword_8()); 
            }

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
    // $ANTLR end "rule__Composition__Group__8__Impl"


    // $ANTLR start "rule__Composition__Group__9"
    // InternalAspect.g:1740:1: rule__Composition__Group__9 : rule__Composition__Group__9__Impl rule__Composition__Group__10 ;
    public final void rule__Composition__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1744:1: ( rule__Composition__Group__9__Impl rule__Composition__Group__10 )
            // InternalAspect.g:1745:2: rule__Composition__Group__9__Impl rule__Composition__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__Composition__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group__10();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__9"


    // $ANTLR start "rule__Composition__Group__9__Impl"
    // InternalAspect.g:1752:1: rule__Composition__Group__9__Impl : ( ( rule__Composition__ActionAssignment_9 ) ) ;
    public final void rule__Composition__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1756:1: ( ( ( rule__Composition__ActionAssignment_9 ) ) )
            // InternalAspect.g:1757:1: ( ( rule__Composition__ActionAssignment_9 ) )
            {
            // InternalAspect.g:1757:1: ( ( rule__Composition__ActionAssignment_9 ) )
            // InternalAspect.g:1758:1: ( rule__Composition__ActionAssignment_9 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getActionAssignment_9()); 
            }
            // InternalAspect.g:1759:1: ( rule__Composition__ActionAssignment_9 )
            // InternalAspect.g:1759:2: rule__Composition__ActionAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Composition__ActionAssignment_9();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getActionAssignment_9()); 
            }

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
    // $ANTLR end "rule__Composition__Group__9__Impl"


    // $ANTLR start "rule__Composition__Group__10"
    // InternalAspect.g:1769:1: rule__Composition__Group__10 : rule__Composition__Group__10__Impl ;
    public final void rule__Composition__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1773:1: ( rule__Composition__Group__10__Impl )
            // InternalAspect.g:1774:2: rule__Composition__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composition__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group__10"


    // $ANTLR start "rule__Composition__Group__10__Impl"
    // InternalAspect.g:1780:1: rule__Composition__Group__10__Impl : ( '}' ) ;
    public final void rule__Composition__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1784:1: ( ( '}' ) )
            // InternalAspect.g:1785:1: ( '}' )
            {
            // InternalAspect.g:1785:1: ( '}' )
            // InternalAspect.g:1786:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_10()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_10()); 
            }

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
    // $ANTLR end "rule__Composition__Group__10__Impl"


    // $ANTLR start "rule__Composition__Group_5__0"
    // InternalAspect.g:1821:1: rule__Composition__Group_5__0 : rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1 ;
    public final void rule__Composition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1825:1: ( rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1 )
            // InternalAspect.g:1826:2: rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1
            {
            pushFollow(FOLLOW_21);
            rule__Composition__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group_5__0"


    // $ANTLR start "rule__Composition__Group_5__0__Impl"
    // InternalAspect.g:1833:1: rule__Composition__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Composition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1837:1: ( ( ',' ) )
            // InternalAspect.g:1838:1: ( ',' )
            {
            // InternalAspect.g:1838:1: ( ',' )
            // InternalAspect.g:1839:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCommaKeyword_5_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getCommaKeyword_5_0()); 
            }

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
    // $ANTLR end "rule__Composition__Group_5__0__Impl"


    // $ANTLR start "rule__Composition__Group_5__1"
    // InternalAspect.g:1852:1: rule__Composition__Group_5__1 : rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2 ;
    public final void rule__Composition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1856:1: ( rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2 )
            // InternalAspect.g:1857:2: rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2
            {
            pushFollow(FOLLOW_3);
            rule__Composition__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group_5__1"


    // $ANTLR start "rule__Composition__Group_5__1__Impl"
    // InternalAspect.g:1864:1: rule__Composition__Group_5__1__Impl : ( 'jointpointRole' ) ;
    public final void rule__Composition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1868:1: ( ( 'jointpointRole' ) )
            // InternalAspect.g:1869:1: ( 'jointpointRole' )
            {
            // InternalAspect.g:1869:1: ( 'jointpointRole' )
            // InternalAspect.g:1870:1: 'jointpointRole'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleKeyword_5_1()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getJointpointRoleKeyword_5_1()); 
            }

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
    // $ANTLR end "rule__Composition__Group_5__1__Impl"


    // $ANTLR start "rule__Composition__Group_5__2"
    // InternalAspect.g:1883:1: rule__Composition__Group_5__2 : rule__Composition__Group_5__2__Impl ;
    public final void rule__Composition__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1887:1: ( rule__Composition__Group_5__2__Impl )
            // InternalAspect.g:1888:2: rule__Composition__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composition__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group_5__2"


    // $ANTLR start "rule__Composition__Group_5__2__Impl"
    // InternalAspect.g:1894:1: rule__Composition__Group_5__2__Impl : ( ( rule__Composition__JointpointRoleAssignment_5_2 ) ) ;
    public final void rule__Composition__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1898:1: ( ( ( rule__Composition__JointpointRoleAssignment_5_2 ) ) )
            // InternalAspect.g:1899:1: ( ( rule__Composition__JointpointRoleAssignment_5_2 ) )
            {
            // InternalAspect.g:1899:1: ( ( rule__Composition__JointpointRoleAssignment_5_2 ) )
            // InternalAspect.g:1900:1: ( rule__Composition__JointpointRoleAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleAssignment_5_2()); 
            }
            // InternalAspect.g:1901:1: ( rule__Composition__JointpointRoleAssignment_5_2 )
            // InternalAspect.g:1901:2: rule__Composition__JointpointRoleAssignment_5_2
            {
            pushFollow(FOLLOW_2);
            rule__Composition__JointpointRoleAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getJointpointRoleAssignment_5_2()); 
            }

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
    // $ANTLR end "rule__Composition__Group_5__2__Impl"


    // $ANTLR start "rule__Composition__Group_6__0"
    // InternalAspect.g:1917:1: rule__Composition__Group_6__0 : rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1 ;
    public final void rule__Composition__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1921:1: ( rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1 )
            // InternalAspect.g:1922:2: rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1
            {
            pushFollow(FOLLOW_22);
            rule__Composition__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group_6__0"


    // $ANTLR start "rule__Composition__Group_6__0__Impl"
    // InternalAspect.g:1929:1: rule__Composition__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Composition__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1933:1: ( ( ',' ) )
            // InternalAspect.g:1934:1: ( ',' )
            {
            // InternalAspect.g:1934:1: ( ',' )
            // InternalAspect.g:1935:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCommaKeyword_6_0()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getCommaKeyword_6_0()); 
            }

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
    // $ANTLR end "rule__Composition__Group_6__0__Impl"


    // $ANTLR start "rule__Composition__Group_6__1"
    // InternalAspect.g:1948:1: rule__Composition__Group_6__1 : rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2 ;
    public final void rule__Composition__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1952:1: ( rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2 )
            // InternalAspect.g:1953:2: rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2
            {
            pushFollow(FOLLOW_3);
            rule__Composition__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Composition__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group_6__1"


    // $ANTLR start "rule__Composition__Group_6__1__Impl"
    // InternalAspect.g:1960:1: rule__Composition__Group_6__1__Impl : ( 'adviceRole' ) ;
    public final void rule__Composition__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1964:1: ( ( 'adviceRole' ) )
            // InternalAspect.g:1965:1: ( 'adviceRole' )
            {
            // InternalAspect.g:1965:1: ( 'adviceRole' )
            // InternalAspect.g:1966:1: 'adviceRole'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceRoleKeyword_6_1()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getAdviceRoleKeyword_6_1()); 
            }

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
    // $ANTLR end "rule__Composition__Group_6__1__Impl"


    // $ANTLR start "rule__Composition__Group_6__2"
    // InternalAspect.g:1979:1: rule__Composition__Group_6__2 : rule__Composition__Group_6__2__Impl ;
    public final void rule__Composition__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1983:1: ( rule__Composition__Group_6__2__Impl )
            // InternalAspect.g:1984:2: rule__Composition__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Composition__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Composition__Group_6__2"


    // $ANTLR start "rule__Composition__Group_6__2__Impl"
    // InternalAspect.g:1990:1: rule__Composition__Group_6__2__Impl : ( ( rule__Composition__AdviceAssignment_6_2 ) ) ;
    public final void rule__Composition__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1994:1: ( ( ( rule__Composition__AdviceAssignment_6_2 ) ) )
            // InternalAspect.g:1995:1: ( ( rule__Composition__AdviceAssignment_6_2 ) )
            {
            // InternalAspect.g:1995:1: ( ( rule__Composition__AdviceAssignment_6_2 ) )
            // InternalAspect.g:1996:1: ( rule__Composition__AdviceAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceAssignment_6_2()); 
            }
            // InternalAspect.g:1997:1: ( rule__Composition__AdviceAssignment_6_2 )
            // InternalAspect.g:1997:2: rule__Composition__AdviceAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__Composition__AdviceAssignment_6_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getAdviceAssignment_6_2()); 
            }

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
    // $ANTLR end "rule__Composition__Group_6__2__Impl"


    // $ANTLR start "rule__UpdateValue__Group__0"
    // InternalAspect.g:2013:1: rule__UpdateValue__Group__0 : rule__UpdateValue__Group__0__Impl rule__UpdateValue__Group__1 ;
    public final void rule__UpdateValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2017:1: ( rule__UpdateValue__Group__0__Impl rule__UpdateValue__Group__1 )
            // InternalAspect.g:2018:2: rule__UpdateValue__Group__0__Impl rule__UpdateValue__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__UpdateValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__UpdateValue__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__UpdateValue__Group__0"


    // $ANTLR start "rule__UpdateValue__Group__0__Impl"
    // InternalAspect.g:2025:1: rule__UpdateValue__Group__0__Impl : ( 'update value' ) ;
    public final void rule__UpdateValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2029:1: ( ( 'update value' ) )
            // InternalAspect.g:2030:1: ( 'update value' )
            {
            // InternalAspect.g:2030:1: ( 'update value' )
            // InternalAspect.g:2031:1: 'update value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateValueAccess().getUpdateValueKeyword_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateValueAccess().getUpdateValueKeyword_0()); 
            }

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
    // $ANTLR end "rule__UpdateValue__Group__0__Impl"


    // $ANTLR start "rule__UpdateValue__Group__1"
    // InternalAspect.g:2044:1: rule__UpdateValue__Group__1 : rule__UpdateValue__Group__1__Impl ;
    public final void rule__UpdateValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2048:1: ( rule__UpdateValue__Group__1__Impl )
            // InternalAspect.g:2049:2: rule__UpdateValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UpdateValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__UpdateValue__Group__1"


    // $ANTLR start "rule__UpdateValue__Group__1__Impl"
    // InternalAspect.g:2055:1: rule__UpdateValue__Group__1__Impl : ( ( rule__UpdateValue__ValueAssignment_1 ) ) ;
    public final void rule__UpdateValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2059:1: ( ( ( rule__UpdateValue__ValueAssignment_1 ) ) )
            // InternalAspect.g:2060:1: ( ( rule__UpdateValue__ValueAssignment_1 ) )
            {
            // InternalAspect.g:2060:1: ( ( rule__UpdateValue__ValueAssignment_1 ) )
            // InternalAspect.g:2061:1: ( rule__UpdateValue__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateValueAccess().getValueAssignment_1()); 
            }
            // InternalAspect.g:2062:1: ( rule__UpdateValue__ValueAssignment_1 )
            // InternalAspect.g:2062:2: rule__UpdateValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UpdateValue__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateValueAccess().getValueAssignment_1()); 
            }

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
    // $ANTLR end "rule__UpdateValue__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalAspect.g:2076:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2080:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAspect.g:2081:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalAspect.g:2088:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2092:1: ( ( RULE_ID ) )
            // InternalAspect.g:2093:1: ( RULE_ID )
            {
            // InternalAspect.g:2093:1: ( RULE_ID )
            // InternalAspect.g:2094:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }

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
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalAspect.g:2105:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2109:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAspect.g:2110:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalAspect.g:2116:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2120:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAspect.g:2121:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAspect.g:2121:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAspect.g:2122:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalAspect.g:2123:1: ( rule__QualifiedName__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==29) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAspect.g:2123:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalAspect.g:2137:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2141:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAspect.g:2142:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_3);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalAspect.g:2149:1: rule__QualifiedName__Group_1__0__Impl : ( ( '.' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2153:1: ( ( ( '.' ) ) )
            // InternalAspect.g:2154:1: ( ( '.' ) )
            {
            // InternalAspect.g:2154:1: ( ( '.' ) )
            // InternalAspect.g:2155:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            // InternalAspect.g:2156:1: ( '.' )
            // InternalAspect.g:2157:2: '.'
            {
            match(input,29,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

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
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalAspect.g:2168:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2172:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAspect.g:2173:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalAspect.g:2179:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2183:1: ( ( RULE_ID ) )
            // InternalAspect.g:2184:1: ( RULE_ID )
            {
            // InternalAspect.g:2184:1: ( RULE_ID )
            // InternalAspect.g:2185:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }

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
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Aspect__NameAssignment_1"
    // InternalAspect.g:2201:1: rule__Aspect__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Aspect__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2205:1: ( ( RULE_ID ) )
            // InternalAspect.g:2206:1: ( RULE_ID )
            {
            // InternalAspect.g:2206:1: ( RULE_ID )
            // InternalAspect.g:2207:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__Aspect__NameAssignment_1"


    // $ANTLR start "rule__Aspect__FeatureAssignment_4"
    // InternalAspect.g:2216:1: rule__Aspect__FeatureAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Aspect__FeatureAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2220:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2221:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2221:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2222:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); 
            }
            // InternalAspect.g:2223:1: ( ruleQualifiedName )
            // InternalAspect.g:2224:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureFeatureQualifiedNameParserRuleCall_4_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getFeatureFeatureQualifiedNameParserRuleCall_4_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); 
            }

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
    // $ANTLR end "rule__Aspect__FeatureAssignment_4"


    // $ANTLR start "rule__Aspect__AdviceAssignment_5_2"
    // InternalAspect.g:2235:1: rule__Aspect__AdviceAssignment_5_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Aspect__AdviceAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2239:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2240:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2240:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2241:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceModelCrossReference_5_2_0()); 
            }
            // InternalAspect.g:2242:1: ( ruleQualifiedName )
            // InternalAspect.g:2243:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceModelQualifiedNameParserRuleCall_5_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceModelQualifiedNameParserRuleCall_5_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceModelCrossReference_5_2_0()); 
            }

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
    // $ANTLR end "rule__Aspect__AdviceAssignment_5_2"


    // $ANTLR start "rule__Aspect__PointcutsAssignment_9"
    // InternalAspect.g:2254:1: rule__Aspect__PointcutsAssignment_9 : ( rulePointcut ) ;
    public final void rule__Aspect__PointcutsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2258:1: ( ( rulePointcut ) )
            // InternalAspect.g:2259:1: ( rulePointcut )
            {
            // InternalAspect.g:2259:1: ( rulePointcut )
            // InternalAspect.g:2260:1: rulePointcut
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_9_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePointcut();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_9_0()); 
            }

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
    // $ANTLR end "rule__Aspect__PointcutsAssignment_9"


    // $ANTLR start "rule__Aspect__PointcutsAssignment_10_1"
    // InternalAspect.g:2269:1: rule__Aspect__PointcutsAssignment_10_1 : ( rulePointcut ) ;
    public final void rule__Aspect__PointcutsAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2273:1: ( ( rulePointcut ) )
            // InternalAspect.g:2274:1: ( rulePointcut )
            {
            // InternalAspect.g:2274:1: ( rulePointcut )
            // InternalAspect.g:2275:1: rulePointcut
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_10_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePointcut();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_10_1_0()); 
            }

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
    // $ANTLR end "rule__Aspect__PointcutsAssignment_10_1"


    // $ANTLR start "rule__Aspect__CompositionsAssignment_15"
    // InternalAspect.g:2284:1: rule__Aspect__CompositionsAssignment_15 : ( ruleComposition ) ;
    public final void rule__Aspect__CompositionsAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2288:1: ( ( ruleComposition ) )
            // InternalAspect.g:2289:1: ( ruleComposition )
            {
            // InternalAspect.g:2289:1: ( ruleComposition )
            // InternalAspect.g:2290:1: ruleComposition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_15_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComposition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_15_0()); 
            }

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
    // $ANTLR end "rule__Aspect__CompositionsAssignment_15"


    // $ANTLR start "rule__Aspect__CompositionsAssignment_16_1"
    // InternalAspect.g:2299:1: rule__Aspect__CompositionsAssignment_16_1 : ( ruleComposition ) ;
    public final void rule__Aspect__CompositionsAssignment_16_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2303:1: ( ( ruleComposition ) )
            // InternalAspect.g:2304:1: ( ruleComposition )
            {
            // InternalAspect.g:2304:1: ( ruleComposition )
            // InternalAspect.g:2305:1: ruleComposition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_16_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComposition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_16_1_0()); 
            }

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
    // $ANTLR end "rule__Aspect__CompositionsAssignment_16_1"


    // $ANTLR start "rule__Pointcut__NameAssignment_1"
    // InternalAspect.g:2314:1: rule__Pointcut__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Pointcut__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2318:1: ( ( RULE_ID ) )
            // InternalAspect.g:2319:1: ( RULE_ID )
            {
            // InternalAspect.g:2319:1: ( RULE_ID )
            // InternalAspect.g:2320:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getNameIDTerminalRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__Pointcut__NameAssignment_1"


    // $ANTLR start "rule__Pointcut__PatternAssignment_4"
    // InternalAspect.g:2329:1: rule__Pointcut__PatternAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Pointcut__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2333:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2334:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2334:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2335:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); 
            }
            // InternalAspect.g:2336:1: ( ruleQualifiedName )
            // InternalAspect.g:2337:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternPatternQualifiedNameParserRuleCall_4_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getPatternPatternQualifiedNameParserRuleCall_4_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); 
            }

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
    // $ANTLR end "rule__Pointcut__PatternAssignment_4"


    // $ANTLR start "rule__Pointcut__RoleAssignment_5_2"
    // InternalAspect.g:2348:1: rule__Pointcut__RoleAssignment_5_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Pointcut__RoleAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2352:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2353:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2353:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2354:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); 
            }
            // InternalAspect.g:2355:1: ( ruleQualifiedName )
            // InternalAspect.g:2356:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); 
            }

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
    // $ANTLR end "rule__Pointcut__RoleAssignment_5_2"


    // $ANTLR start "rule__Composition__NameAssignment_1"
    // InternalAspect.g:2367:1: rule__Composition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Composition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2371:1: ( ( RULE_ID ) )
            // InternalAspect.g:2372:1: ( RULE_ID )
            {
            // InternalAspect.g:2372:1: ( RULE_ID )
            // InternalAspect.g:2373:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__Composition__NameAssignment_1"


    // $ANTLR start "rule__Composition__Feature_enabledAssignment_4"
    // InternalAspect.g:2382:1: rule__Composition__Feature_enabledAssignment_4 : ( RULE_EBOOLEAN ) ;
    public final void rule__Composition__Feature_enabledAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2386:1: ( ( RULE_EBOOLEAN ) )
            // InternalAspect.g:2387:1: ( RULE_EBOOLEAN )
            {
            // InternalAspect.g:2387:1: ( RULE_EBOOLEAN )
            // InternalAspect.g:2388:1: RULE_EBOOLEAN
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getFeature_enabledEBOOLEANTerminalRuleCall_4_0()); 
            }
            match(input,RULE_EBOOLEAN,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getFeature_enabledEBOOLEANTerminalRuleCall_4_0()); 
            }

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
    // $ANTLR end "rule__Composition__Feature_enabledAssignment_4"


    // $ANTLR start "rule__Composition__JointpointRoleAssignment_5_2"
    // InternalAspect.g:2397:1: rule__Composition__JointpointRoleAssignment_5_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Composition__JointpointRoleAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2401:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2402:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2402:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2403:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); 
            }
            // InternalAspect.g:2404:1: ( ruleQualifiedName )
            // InternalAspect.g:2405:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeQualifiedNameParserRuleCall_5_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); 
            }

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
    // $ANTLR end "rule__Composition__JointpointRoleAssignment_5_2"


    // $ANTLR start "rule__Composition__AdviceAssignment_6_2"
    // InternalAspect.g:2416:1: rule__Composition__AdviceAssignment_6_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Composition__AdviceAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2420:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2421:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2421:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2422:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); 
            }
            // InternalAspect.g:2423:1: ( ruleQualifiedName )
            // InternalAspect.g:2424:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceStereotypeQualifiedNameParserRuleCall_6_2_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getAdviceStereotypeQualifiedNameParserRuleCall_6_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); 
            }

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
    // $ANTLR end "rule__Composition__AdviceAssignment_6_2"


    // $ANTLR start "rule__Composition__ActionAssignment_9"
    // InternalAspect.g:2435:1: rule__Composition__ActionAssignment_9 : ( ruleActionOptionType ) ;
    public final void rule__Composition__ActionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2439:1: ( ( ruleActionOptionType ) )
            // InternalAspect.g:2440:1: ( ruleActionOptionType )
            {
            // InternalAspect.g:2440:1: ( ruleActionOptionType )
            // InternalAspect.g:2441:1: ruleActionOptionType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getActionActionOptionTypeParserRuleCall_9_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleActionOptionType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getActionActionOptionTypeParserRuleCall_9_0()); 
            }

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
    // $ANTLR end "rule__Composition__ActionAssignment_9"


    // $ANTLR start "rule__UpdateValue__ValueAssignment_1"
    // InternalAspect.g:2450:1: rule__UpdateValue__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__UpdateValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2454:1: ( ( RULE_STRING ) )
            // InternalAspect.g:2455:1: ( RULE_STRING )
            {
            // InternalAspect.g:2455:1: ( RULE_STRING )
            // InternalAspect.g:2456:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateValueAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateValueAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__UpdateValue__ValueAssignment_1"


    // $ANTLR start "rule__Action__ADDAssignment_0"
    // InternalAspect.g:2465:1: rule__Action__ADDAssignment_0 : ( ( 'add' ) ) ;
    public final void rule__Action__ADDAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2469:1: ( ( ( 'add' ) ) )
            // InternalAspect.g:2470:1: ( ( 'add' ) )
            {
            // InternalAspect.g:2470:1: ( ( 'add' ) )
            // InternalAspect.g:2471:1: ( 'add' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getADDAddKeyword_0_0()); 
            }
            // InternalAspect.g:2472:1: ( 'add' )
            // InternalAspect.g:2473:1: 'add'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getADDAddKeyword_0_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getADDAddKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getADDAddKeyword_0_0()); 
            }

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
    // $ANTLR end "rule__Action__ADDAssignment_0"


    // $ANTLR start "rule__Action__DELETEAssignment_1"
    // InternalAspect.g:2488:1: rule__Action__DELETEAssignment_1 : ( ( 'delete' ) ) ;
    public final void rule__Action__DELETEAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2492:1: ( ( ( 'delete' ) ) )
            // InternalAspect.g:2493:1: ( ( 'delete' ) )
            {
            // InternalAspect.g:2493:1: ( ( 'delete' ) )
            // InternalAspect.g:2494:1: ( 'delete' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getDELETEDeleteKeyword_1_0()); 
            }
            // InternalAspect.g:2495:1: ( 'delete' )
            // InternalAspect.g:2496:1: 'delete'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getDELETEDeleteKeyword_1_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getDELETEDeleteKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getDELETEDeleteKeyword_1_0()); 
            }

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
    // $ANTLR end "rule__Action__DELETEAssignment_1"


    // $ANTLR start "rule__Action__REPLACEAssignment_2"
    // InternalAspect.g:2511:1: rule__Action__REPLACEAssignment_2 : ( ( 'replace' ) ) ;
    public final void rule__Action__REPLACEAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2515:1: ( ( ( 'replace' ) ) )
            // InternalAspect.g:2516:1: ( ( 'replace' ) )
            {
            // InternalAspect.g:2516:1: ( ( 'replace' ) )
            // InternalAspect.g:2517:1: ( 'replace' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getREPLACEReplaceKeyword_2_0()); 
            }
            // InternalAspect.g:2518:1: ( 'replace' )
            // InternalAspect.g:2519:1: 'replace'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getREPLACEReplaceKeyword_2_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getREPLACEReplaceKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getREPLACEReplaceKeyword_2_0()); 
            }

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
    // $ANTLR end "rule__Action__REPLACEAssignment_2"


    // $ANTLR start "rule__Action__UPDATEAssignment_3"
    // InternalAspect.g:2534:1: rule__Action__UPDATEAssignment_3 : ( ( 'update' ) ) ;
    public final void rule__Action__UPDATEAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2538:1: ( ( ( 'update' ) ) )
            // InternalAspect.g:2539:1: ( ( 'update' ) )
            {
            // InternalAspect.g:2539:1: ( ( 'update' ) )
            // InternalAspect.g:2540:1: ( 'update' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getUPDATEUpdateKeyword_3_0()); 
            }
            // InternalAspect.g:2541:1: ( 'update' )
            // InternalAspect.g:2542:1: 'update'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getUPDATEUpdateKeyword_3_0()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getUPDATEUpdateKeyword_3_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getActionAccess().getUPDATEUpdateKeyword_3_0()); 
            }

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
    // $ANTLR end "rule__Action__UPDATEAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000003D0000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000002L});

}