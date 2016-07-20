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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_EBOOLEAN", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'add'", "'delete'", "'replace'", "'associate'", "'aspect'", "'{'", "'feature'", "','", "'advice'", "'pointcuts'", "'}'", "'compositions'", "'pointcut'", "'pattern'", "'role'", "'composition'", "'feature_enabled'", "'action'", "'jointpointRole'", "'adviceRole'", "'.'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
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
    public static final int RULE_INT=6;
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


    // $ANTLR start "entryRuleAction"
    // InternalAspect.g:145:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalAspect.g:146:1: ( ruleAction EOF )
            // InternalAspect.g:147:1: ruleAction EOF
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
    // InternalAspect.g:154:1: ruleAction : ( ( rule__Action__Alternatives ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:158:2: ( ( ( rule__Action__Alternatives ) ) )
            // InternalAspect.g:159:1: ( ( rule__Action__Alternatives ) )
            {
            // InternalAspect.g:159:1: ( ( rule__Action__Alternatives ) )
            // InternalAspect.g:160:1: ( rule__Action__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getAlternatives()); 
            }
            // InternalAspect.g:161:1: ( rule__Action__Alternatives )
            // InternalAspect.g:161:2: rule__Action__Alternatives
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
    // InternalAspect.g:173:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalAspect.g:174:1: ( ruleQualifiedName EOF )
            // InternalAspect.g:175:1: ruleQualifiedName EOF
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
    // InternalAspect.g:182:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:186:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalAspect.g:187:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalAspect.g:187:1: ( ( rule__QualifiedName__Group__0 ) )
            // InternalAspect.g:188:1: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalAspect.g:189:1: ( rule__QualifiedName__Group__0 )
            // InternalAspect.g:189:2: rule__QualifiedName__Group__0
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


    // $ANTLR start "rule__Action__Alternatives"
    // InternalAspect.g:201:1: rule__Action__Alternatives : ( ( 'add' ) | ( 'delete' ) | ( 'replace' ) | ( 'associate' ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:205:1: ( ( 'add' ) | ( 'delete' ) | ( 'replace' ) | ( 'associate' ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 15:
                {
                alt1=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalAspect.g:206:1: ( 'add' )
                    {
                    // InternalAspect.g:206:1: ( 'add' )
                    // InternalAspect.g:207:1: 'add'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getAddKeyword_0()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getAddKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalAspect.g:214:6: ( 'delete' )
                    {
                    // InternalAspect.g:214:6: ( 'delete' )
                    // InternalAspect.g:215:1: 'delete'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getDeleteKeyword_1()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getDeleteKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalAspect.g:222:6: ( 'replace' )
                    {
                    // InternalAspect.g:222:6: ( 'replace' )
                    // InternalAspect.g:223:1: 'replace'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getReplaceKeyword_2()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getReplaceKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalAspect.g:230:6: ( 'associate' )
                    {
                    // InternalAspect.g:230:6: ( 'associate' )
                    // InternalAspect.g:231:1: 'associate'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getActionAccess().getAssociateKeyword_3()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getActionAccess().getAssociateKeyword_3()); 
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
    // InternalAspect.g:245:1: rule__Aspect__Group__0 : rule__Aspect__Group__0__Impl rule__Aspect__Group__1 ;
    public final void rule__Aspect__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:249:1: ( rule__Aspect__Group__0__Impl rule__Aspect__Group__1 )
            // InternalAspect.g:250:2: rule__Aspect__Group__0__Impl rule__Aspect__Group__1
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
    // InternalAspect.g:257:1: rule__Aspect__Group__0__Impl : ( 'aspect' ) ;
    public final void rule__Aspect__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:261:1: ( ( 'aspect' ) )
            // InternalAspect.g:262:1: ( 'aspect' )
            {
            // InternalAspect.g:262:1: ( 'aspect' )
            // InternalAspect.g:263:1: 'aspect'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAspectKeyword_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:276:1: rule__Aspect__Group__1 : rule__Aspect__Group__1__Impl rule__Aspect__Group__2 ;
    public final void rule__Aspect__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:280:1: ( rule__Aspect__Group__1__Impl rule__Aspect__Group__2 )
            // InternalAspect.g:281:2: rule__Aspect__Group__1__Impl rule__Aspect__Group__2
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
    // InternalAspect.g:288:1: rule__Aspect__Group__1__Impl : ( ( rule__Aspect__NameAssignment_1 ) ) ;
    public final void rule__Aspect__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:292:1: ( ( ( rule__Aspect__NameAssignment_1 ) ) )
            // InternalAspect.g:293:1: ( ( rule__Aspect__NameAssignment_1 ) )
            {
            // InternalAspect.g:293:1: ( ( rule__Aspect__NameAssignment_1 ) )
            // InternalAspect.g:294:1: ( rule__Aspect__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:295:1: ( rule__Aspect__NameAssignment_1 )
            // InternalAspect.g:295:2: rule__Aspect__NameAssignment_1
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
    // InternalAspect.g:305:1: rule__Aspect__Group__2 : rule__Aspect__Group__2__Impl rule__Aspect__Group__3 ;
    public final void rule__Aspect__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:309:1: ( rule__Aspect__Group__2__Impl rule__Aspect__Group__3 )
            // InternalAspect.g:310:2: rule__Aspect__Group__2__Impl rule__Aspect__Group__3
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
    // InternalAspect.g:317:1: rule__Aspect__Group__2__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:321:1: ( ( '{' ) )
            // InternalAspect.g:322:1: ( '{' )
            {
            // InternalAspect.g:322:1: ( '{' )
            // InternalAspect.g:323:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:336:1: rule__Aspect__Group__3 : rule__Aspect__Group__3__Impl rule__Aspect__Group__4 ;
    public final void rule__Aspect__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:340:1: ( rule__Aspect__Group__3__Impl rule__Aspect__Group__4 )
            // InternalAspect.g:341:2: rule__Aspect__Group__3__Impl rule__Aspect__Group__4
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
    // InternalAspect.g:348:1: rule__Aspect__Group__3__Impl : ( 'feature' ) ;
    public final void rule__Aspect__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:352:1: ( ( 'feature' ) )
            // InternalAspect.g:353:1: ( 'feature' )
            {
            // InternalAspect.g:353:1: ( 'feature' )
            // InternalAspect.g:354:1: 'feature'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureKeyword_3()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:367:1: rule__Aspect__Group__4 : rule__Aspect__Group__4__Impl rule__Aspect__Group__5 ;
    public final void rule__Aspect__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:371:1: ( rule__Aspect__Group__4__Impl rule__Aspect__Group__5 )
            // InternalAspect.g:372:2: rule__Aspect__Group__4__Impl rule__Aspect__Group__5
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
    // InternalAspect.g:379:1: rule__Aspect__Group__4__Impl : ( ( rule__Aspect__FeatureAssignment_4 ) ) ;
    public final void rule__Aspect__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:383:1: ( ( ( rule__Aspect__FeatureAssignment_4 ) ) )
            // InternalAspect.g:384:1: ( ( rule__Aspect__FeatureAssignment_4 ) )
            {
            // InternalAspect.g:384:1: ( ( rule__Aspect__FeatureAssignment_4 ) )
            // InternalAspect.g:385:1: ( rule__Aspect__FeatureAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureAssignment_4()); 
            }
            // InternalAspect.g:386:1: ( rule__Aspect__FeatureAssignment_4 )
            // InternalAspect.g:386:2: rule__Aspect__FeatureAssignment_4
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
    // InternalAspect.g:396:1: rule__Aspect__Group__5 : rule__Aspect__Group__5__Impl rule__Aspect__Group__6 ;
    public final void rule__Aspect__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:400:1: ( rule__Aspect__Group__5__Impl rule__Aspect__Group__6 )
            // InternalAspect.g:401:2: rule__Aspect__Group__5__Impl rule__Aspect__Group__6
            {
            pushFollow(FOLLOW_7);
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
    // InternalAspect.g:408:1: rule__Aspect__Group__5__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:412:1: ( ( ',' ) )
            // InternalAspect.g:413:1: ( ',' )
            {
            // InternalAspect.g:413:1: ( ',' )
            // InternalAspect.g:414:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_5()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_5()); 
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
    // InternalAspect.g:427:1: rule__Aspect__Group__6 : rule__Aspect__Group__6__Impl rule__Aspect__Group__7 ;
    public final void rule__Aspect__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:431:1: ( rule__Aspect__Group__6__Impl rule__Aspect__Group__7 )
            // InternalAspect.g:432:2: rule__Aspect__Group__6__Impl rule__Aspect__Group__7
            {
            pushFollow(FOLLOW_3);
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
    // InternalAspect.g:439:1: rule__Aspect__Group__6__Impl : ( 'advice' ) ;
    public final void rule__Aspect__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:443:1: ( ( 'advice' ) )
            // InternalAspect.g:444:1: ( 'advice' )
            {
            // InternalAspect.g:444:1: ( 'advice' )
            // InternalAspect.g:445:1: 'advice'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceKeyword_6()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceKeyword_6()); 
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
    // InternalAspect.g:458:1: rule__Aspect__Group__7 : rule__Aspect__Group__7__Impl rule__Aspect__Group__8 ;
    public final void rule__Aspect__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:462:1: ( rule__Aspect__Group__7__Impl rule__Aspect__Group__8 )
            // InternalAspect.g:463:2: rule__Aspect__Group__7__Impl rule__Aspect__Group__8
            {
            pushFollow(FOLLOW_6);
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
    // InternalAspect.g:470:1: rule__Aspect__Group__7__Impl : ( ( rule__Aspect__AdviceAssignment_7 ) ) ;
    public final void rule__Aspect__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:474:1: ( ( ( rule__Aspect__AdviceAssignment_7 ) ) )
            // InternalAspect.g:475:1: ( ( rule__Aspect__AdviceAssignment_7 ) )
            {
            // InternalAspect.g:475:1: ( ( rule__Aspect__AdviceAssignment_7 ) )
            // InternalAspect.g:476:1: ( rule__Aspect__AdviceAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceAssignment_7()); 
            }
            // InternalAspect.g:477:1: ( rule__Aspect__AdviceAssignment_7 )
            // InternalAspect.g:477:2: rule__Aspect__AdviceAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__AdviceAssignment_7();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceAssignment_7()); 
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
    // InternalAspect.g:487:1: rule__Aspect__Group__8 : rule__Aspect__Group__8__Impl rule__Aspect__Group__9 ;
    public final void rule__Aspect__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:491:1: ( rule__Aspect__Group__8__Impl rule__Aspect__Group__9 )
            // InternalAspect.g:492:2: rule__Aspect__Group__8__Impl rule__Aspect__Group__9
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
    // InternalAspect.g:499:1: rule__Aspect__Group__8__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:503:1: ( ( ',' ) )
            // InternalAspect.g:504:1: ( ',' )
            {
            // InternalAspect.g:504:1: ( ',' )
            // InternalAspect.g:505:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_8()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_8()); 
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
    // InternalAspect.g:518:1: rule__Aspect__Group__9 : rule__Aspect__Group__9__Impl rule__Aspect__Group__10 ;
    public final void rule__Aspect__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:522:1: ( rule__Aspect__Group__9__Impl rule__Aspect__Group__10 )
            // InternalAspect.g:523:2: rule__Aspect__Group__9__Impl rule__Aspect__Group__10
            {
            pushFollow(FOLLOW_4);
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
    // InternalAspect.g:530:1: rule__Aspect__Group__9__Impl : ( 'pointcuts' ) ;
    public final void rule__Aspect__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:534:1: ( ( 'pointcuts' ) )
            // InternalAspect.g:535:1: ( 'pointcuts' )
            {
            // InternalAspect.g:535:1: ( 'pointcuts' )
            // InternalAspect.g:536:1: 'pointcuts'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsKeyword_9()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsKeyword_9()); 
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
    // InternalAspect.g:549:1: rule__Aspect__Group__10 : rule__Aspect__Group__10__Impl rule__Aspect__Group__11 ;
    public final void rule__Aspect__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:553:1: ( rule__Aspect__Group__10__Impl rule__Aspect__Group__11 )
            // InternalAspect.g:554:2: rule__Aspect__Group__10__Impl rule__Aspect__Group__11
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
    // InternalAspect.g:561:1: rule__Aspect__Group__10__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:565:1: ( ( '{' ) )
            // InternalAspect.g:566:1: ( '{' )
            {
            // InternalAspect.g:566:1: ( '{' )
            // InternalAspect.g:567:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_10()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_10()); 
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
    // InternalAspect.g:580:1: rule__Aspect__Group__11 : rule__Aspect__Group__11__Impl rule__Aspect__Group__12 ;
    public final void rule__Aspect__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:584:1: ( rule__Aspect__Group__11__Impl rule__Aspect__Group__12 )
            // InternalAspect.g:585:2: rule__Aspect__Group__11__Impl rule__Aspect__Group__12
            {
            pushFollow(FOLLOW_10);
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
    // InternalAspect.g:592:1: rule__Aspect__Group__11__Impl : ( ( rule__Aspect__PointcutsAssignment_11 ) ) ;
    public final void rule__Aspect__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:596:1: ( ( ( rule__Aspect__PointcutsAssignment_11 ) ) )
            // InternalAspect.g:597:1: ( ( rule__Aspect__PointcutsAssignment_11 ) )
            {
            // InternalAspect.g:597:1: ( ( rule__Aspect__PointcutsAssignment_11 ) )
            // InternalAspect.g:598:1: ( rule__Aspect__PointcutsAssignment_11 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsAssignment_11()); 
            }
            // InternalAspect.g:599:1: ( rule__Aspect__PointcutsAssignment_11 )
            // InternalAspect.g:599:2: rule__Aspect__PointcutsAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__PointcutsAssignment_11();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsAssignment_11()); 
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
    // InternalAspect.g:609:1: rule__Aspect__Group__12 : rule__Aspect__Group__12__Impl rule__Aspect__Group__13 ;
    public final void rule__Aspect__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:613:1: ( rule__Aspect__Group__12__Impl rule__Aspect__Group__13 )
            // InternalAspect.g:614:2: rule__Aspect__Group__12__Impl rule__Aspect__Group__13
            {
            pushFollow(FOLLOW_10);
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
    // InternalAspect.g:621:1: rule__Aspect__Group__12__Impl : ( ( rule__Aspect__Group_12__0 )* ) ;
    public final void rule__Aspect__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:625:1: ( ( ( rule__Aspect__Group_12__0 )* ) )
            // InternalAspect.g:626:1: ( ( rule__Aspect__Group_12__0 )* )
            {
            // InternalAspect.g:626:1: ( ( rule__Aspect__Group_12__0 )* )
            // InternalAspect.g:627:1: ( rule__Aspect__Group_12__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup_12()); 
            }
            // InternalAspect.g:628:1: ( rule__Aspect__Group_12__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAspect.g:628:2: rule__Aspect__Group_12__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Aspect__Group_12__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getGroup_12()); 
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
    // InternalAspect.g:638:1: rule__Aspect__Group__13 : rule__Aspect__Group__13__Impl rule__Aspect__Group__14 ;
    public final void rule__Aspect__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:642:1: ( rule__Aspect__Group__13__Impl rule__Aspect__Group__14 )
            // InternalAspect.g:643:2: rule__Aspect__Group__13__Impl rule__Aspect__Group__14
            {
            pushFollow(FOLLOW_6);
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
    // InternalAspect.g:650:1: rule__Aspect__Group__13__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:654:1: ( ( '}' ) )
            // InternalAspect.g:655:1: ( '}' )
            {
            // InternalAspect.g:655:1: ( '}' )
            // InternalAspect.g:656:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_13()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_13()); 
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
    // InternalAspect.g:669:1: rule__Aspect__Group__14 : rule__Aspect__Group__14__Impl rule__Aspect__Group__15 ;
    public final void rule__Aspect__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:673:1: ( rule__Aspect__Group__14__Impl rule__Aspect__Group__15 )
            // InternalAspect.g:674:2: rule__Aspect__Group__14__Impl rule__Aspect__Group__15
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
    // InternalAspect.g:681:1: rule__Aspect__Group__14__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:685:1: ( ( ',' ) )
            // InternalAspect.g:686:1: ( ',' )
            {
            // InternalAspect.g:686:1: ( ',' )
            // InternalAspect.g:687:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_14()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_14()); 
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
    // InternalAspect.g:700:1: rule__Aspect__Group__15 : rule__Aspect__Group__15__Impl rule__Aspect__Group__16 ;
    public final void rule__Aspect__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:704:1: ( rule__Aspect__Group__15__Impl rule__Aspect__Group__16 )
            // InternalAspect.g:705:2: rule__Aspect__Group__15__Impl rule__Aspect__Group__16
            {
            pushFollow(FOLLOW_4);
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
    // InternalAspect.g:712:1: rule__Aspect__Group__15__Impl : ( 'compositions' ) ;
    public final void rule__Aspect__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:716:1: ( ( 'compositions' ) )
            // InternalAspect.g:717:1: ( 'compositions' )
            {
            // InternalAspect.g:717:1: ( 'compositions' )
            // InternalAspect.g:718:1: 'compositions'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsKeyword_15()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsKeyword_15()); 
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
    // InternalAspect.g:731:1: rule__Aspect__Group__16 : rule__Aspect__Group__16__Impl rule__Aspect__Group__17 ;
    public final void rule__Aspect__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:735:1: ( rule__Aspect__Group__16__Impl rule__Aspect__Group__17 )
            // InternalAspect.g:736:2: rule__Aspect__Group__16__Impl rule__Aspect__Group__17
            {
            pushFollow(FOLLOW_13);
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
    // InternalAspect.g:743:1: rule__Aspect__Group__16__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:747:1: ( ( '{' ) )
            // InternalAspect.g:748:1: ( '{' )
            {
            // InternalAspect.g:748:1: ( '{' )
            // InternalAspect.g:749:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_16()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_16()); 
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
    // InternalAspect.g:762:1: rule__Aspect__Group__17 : rule__Aspect__Group__17__Impl rule__Aspect__Group__18 ;
    public final void rule__Aspect__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:766:1: ( rule__Aspect__Group__17__Impl rule__Aspect__Group__18 )
            // InternalAspect.g:767:2: rule__Aspect__Group__17__Impl rule__Aspect__Group__18
            {
            pushFollow(FOLLOW_10);
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
    // InternalAspect.g:774:1: rule__Aspect__Group__17__Impl : ( ( rule__Aspect__CompositionsAssignment_17 ) ) ;
    public final void rule__Aspect__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:778:1: ( ( ( rule__Aspect__CompositionsAssignment_17 ) ) )
            // InternalAspect.g:779:1: ( ( rule__Aspect__CompositionsAssignment_17 ) )
            {
            // InternalAspect.g:779:1: ( ( rule__Aspect__CompositionsAssignment_17 ) )
            // InternalAspect.g:780:1: ( rule__Aspect__CompositionsAssignment_17 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsAssignment_17()); 
            }
            // InternalAspect.g:781:1: ( rule__Aspect__CompositionsAssignment_17 )
            // InternalAspect.g:781:2: rule__Aspect__CompositionsAssignment_17
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__CompositionsAssignment_17();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsAssignment_17()); 
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
    // InternalAspect.g:791:1: rule__Aspect__Group__18 : rule__Aspect__Group__18__Impl rule__Aspect__Group__19 ;
    public final void rule__Aspect__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:795:1: ( rule__Aspect__Group__18__Impl rule__Aspect__Group__19 )
            // InternalAspect.g:796:2: rule__Aspect__Group__18__Impl rule__Aspect__Group__19
            {
            pushFollow(FOLLOW_10);
            rule__Aspect__Group__18__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__19();

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
    // InternalAspect.g:803:1: rule__Aspect__Group__18__Impl : ( ( rule__Aspect__Group_18__0 )* ) ;
    public final void rule__Aspect__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:807:1: ( ( ( rule__Aspect__Group_18__0 )* ) )
            // InternalAspect.g:808:1: ( ( rule__Aspect__Group_18__0 )* )
            {
            // InternalAspect.g:808:1: ( ( rule__Aspect__Group_18__0 )* )
            // InternalAspect.g:809:1: ( rule__Aspect__Group_18__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup_18()); 
            }
            // InternalAspect.g:810:1: ( rule__Aspect__Group_18__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAspect.g:810:2: rule__Aspect__Group_18__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Aspect__Group_18__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getGroup_18()); 
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


    // $ANTLR start "rule__Aspect__Group__19"
    // InternalAspect.g:820:1: rule__Aspect__Group__19 : rule__Aspect__Group__19__Impl rule__Aspect__Group__20 ;
    public final void rule__Aspect__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:824:1: ( rule__Aspect__Group__19__Impl rule__Aspect__Group__20 )
            // InternalAspect.g:825:2: rule__Aspect__Group__19__Impl rule__Aspect__Group__20
            {
            pushFollow(FOLLOW_14);
            rule__Aspect__Group__19__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__20();

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
    // $ANTLR end "rule__Aspect__Group__19"


    // $ANTLR start "rule__Aspect__Group__19__Impl"
    // InternalAspect.g:832:1: rule__Aspect__Group__19__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:836:1: ( ( '}' ) )
            // InternalAspect.g:837:1: ( '}' )
            {
            // InternalAspect.g:837:1: ( '}' )
            // InternalAspect.g:838:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_19()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_19()); 
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
    // $ANTLR end "rule__Aspect__Group__19__Impl"


    // $ANTLR start "rule__Aspect__Group__20"
    // InternalAspect.g:851:1: rule__Aspect__Group__20 : rule__Aspect__Group__20__Impl ;
    public final void rule__Aspect__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:855:1: ( rule__Aspect__Group__20__Impl )
            // InternalAspect.g:856:2: rule__Aspect__Group__20__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group__20__Impl();

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
    // $ANTLR end "rule__Aspect__Group__20"


    // $ANTLR start "rule__Aspect__Group__20__Impl"
    // InternalAspect.g:862:1: rule__Aspect__Group__20__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:866:1: ( ( '}' ) )
            // InternalAspect.g:867:1: ( '}' )
            {
            // InternalAspect.g:867:1: ( '}' )
            // InternalAspect.g:868:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_20()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_20()); 
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
    // $ANTLR end "rule__Aspect__Group__20__Impl"


    // $ANTLR start "rule__Aspect__Group_12__0"
    // InternalAspect.g:923:1: rule__Aspect__Group_12__0 : rule__Aspect__Group_12__0__Impl rule__Aspect__Group_12__1 ;
    public final void rule__Aspect__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:927:1: ( rule__Aspect__Group_12__0__Impl rule__Aspect__Group_12__1 )
            // InternalAspect.g:928:2: rule__Aspect__Group_12__0__Impl rule__Aspect__Group_12__1
            {
            pushFollow(FOLLOW_9);
            rule__Aspect__Group_12__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_12__1();

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
    // $ANTLR end "rule__Aspect__Group_12__0"


    // $ANTLR start "rule__Aspect__Group_12__0__Impl"
    // InternalAspect.g:935:1: rule__Aspect__Group_12__0__Impl : ( ',' ) ;
    public final void rule__Aspect__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:939:1: ( ( ',' ) )
            // InternalAspect.g:940:1: ( ',' )
            {
            // InternalAspect.g:940:1: ( ',' )
            // InternalAspect.g:941:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_12_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_12_0()); 
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
    // $ANTLR end "rule__Aspect__Group_12__0__Impl"


    // $ANTLR start "rule__Aspect__Group_12__1"
    // InternalAspect.g:954:1: rule__Aspect__Group_12__1 : rule__Aspect__Group_12__1__Impl ;
    public final void rule__Aspect__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:958:1: ( rule__Aspect__Group_12__1__Impl )
            // InternalAspect.g:959:2: rule__Aspect__Group_12__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_12__1__Impl();

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
    // $ANTLR end "rule__Aspect__Group_12__1"


    // $ANTLR start "rule__Aspect__Group_12__1__Impl"
    // InternalAspect.g:965:1: rule__Aspect__Group_12__1__Impl : ( ( rule__Aspect__PointcutsAssignment_12_1 ) ) ;
    public final void rule__Aspect__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:969:1: ( ( ( rule__Aspect__PointcutsAssignment_12_1 ) ) )
            // InternalAspect.g:970:1: ( ( rule__Aspect__PointcutsAssignment_12_1 ) )
            {
            // InternalAspect.g:970:1: ( ( rule__Aspect__PointcutsAssignment_12_1 ) )
            // InternalAspect.g:971:1: ( rule__Aspect__PointcutsAssignment_12_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsAssignment_12_1()); 
            }
            // InternalAspect.g:972:1: ( rule__Aspect__PointcutsAssignment_12_1 )
            // InternalAspect.g:972:2: rule__Aspect__PointcutsAssignment_12_1
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__PointcutsAssignment_12_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsAssignment_12_1()); 
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
    // $ANTLR end "rule__Aspect__Group_12__1__Impl"


    // $ANTLR start "rule__Aspect__Group_18__0"
    // InternalAspect.g:986:1: rule__Aspect__Group_18__0 : rule__Aspect__Group_18__0__Impl rule__Aspect__Group_18__1 ;
    public final void rule__Aspect__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:990:1: ( rule__Aspect__Group_18__0__Impl rule__Aspect__Group_18__1 )
            // InternalAspect.g:991:2: rule__Aspect__Group_18__0__Impl rule__Aspect__Group_18__1
            {
            pushFollow(FOLLOW_13);
            rule__Aspect__Group_18__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_18__1();

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
    // $ANTLR end "rule__Aspect__Group_18__0"


    // $ANTLR start "rule__Aspect__Group_18__0__Impl"
    // InternalAspect.g:998:1: rule__Aspect__Group_18__0__Impl : ( ',' ) ;
    public final void rule__Aspect__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1002:1: ( ( ',' ) )
            // InternalAspect.g:1003:1: ( ',' )
            {
            // InternalAspect.g:1003:1: ( ',' )
            // InternalAspect.g:1004:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCommaKeyword_18_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCommaKeyword_18_0()); 
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
    // $ANTLR end "rule__Aspect__Group_18__0__Impl"


    // $ANTLR start "rule__Aspect__Group_18__1"
    // InternalAspect.g:1017:1: rule__Aspect__Group_18__1 : rule__Aspect__Group_18__1__Impl ;
    public final void rule__Aspect__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1021:1: ( rule__Aspect__Group_18__1__Impl )
            // InternalAspect.g:1022:2: rule__Aspect__Group_18__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__Group_18__1__Impl();

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
    // $ANTLR end "rule__Aspect__Group_18__1"


    // $ANTLR start "rule__Aspect__Group_18__1__Impl"
    // InternalAspect.g:1028:1: rule__Aspect__Group_18__1__Impl : ( ( rule__Aspect__CompositionsAssignment_18_1 ) ) ;
    public final void rule__Aspect__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1032:1: ( ( ( rule__Aspect__CompositionsAssignment_18_1 ) ) )
            // InternalAspect.g:1033:1: ( ( rule__Aspect__CompositionsAssignment_18_1 ) )
            {
            // InternalAspect.g:1033:1: ( ( rule__Aspect__CompositionsAssignment_18_1 ) )
            // InternalAspect.g:1034:1: ( rule__Aspect__CompositionsAssignment_18_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsAssignment_18_1()); 
            }
            // InternalAspect.g:1035:1: ( rule__Aspect__CompositionsAssignment_18_1 )
            // InternalAspect.g:1035:2: rule__Aspect__CompositionsAssignment_18_1
            {
            pushFollow(FOLLOW_2);
            rule__Aspect__CompositionsAssignment_18_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsAssignment_18_1()); 
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
    // $ANTLR end "rule__Aspect__Group_18__1__Impl"


    // $ANTLR start "rule__Pointcut__Group__0"
    // InternalAspect.g:1049:1: rule__Pointcut__Group__0 : rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1 ;
    public final void rule__Pointcut__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1053:1: ( rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1 )
            // InternalAspect.g:1054:2: rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1
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
    // InternalAspect.g:1061:1: rule__Pointcut__Group__0__Impl : ( 'pointcut' ) ;
    public final void rule__Pointcut__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1065:1: ( ( 'pointcut' ) )
            // InternalAspect.g:1066:1: ( 'pointcut' )
            {
            // InternalAspect.g:1066:1: ( 'pointcut' )
            // InternalAspect.g:1067:1: 'pointcut'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPointcutKeyword_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1080:1: rule__Pointcut__Group__1 : rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2 ;
    public final void rule__Pointcut__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1084:1: ( rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2 )
            // InternalAspect.g:1085:2: rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2
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
    // InternalAspect.g:1092:1: rule__Pointcut__Group__1__Impl : ( ( rule__Pointcut__NameAssignment_1 ) ) ;
    public final void rule__Pointcut__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1096:1: ( ( ( rule__Pointcut__NameAssignment_1 ) ) )
            // InternalAspect.g:1097:1: ( ( rule__Pointcut__NameAssignment_1 ) )
            {
            // InternalAspect.g:1097:1: ( ( rule__Pointcut__NameAssignment_1 ) )
            // InternalAspect.g:1098:1: ( rule__Pointcut__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:1099:1: ( rule__Pointcut__NameAssignment_1 )
            // InternalAspect.g:1099:2: rule__Pointcut__NameAssignment_1
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
    // InternalAspect.g:1109:1: rule__Pointcut__Group__2 : rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3 ;
    public final void rule__Pointcut__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1113:1: ( rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3 )
            // InternalAspect.g:1114:2: rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3
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
    // InternalAspect.g:1121:1: rule__Pointcut__Group__2__Impl : ( '{' ) ;
    public final void rule__Pointcut__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1125:1: ( ( '{' ) )
            // InternalAspect.g:1126:1: ( '{' )
            {
            // InternalAspect.g:1126:1: ( '{' )
            // InternalAspect.g:1127:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1140:1: rule__Pointcut__Group__3 : rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4 ;
    public final void rule__Pointcut__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1144:1: ( rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4 )
            // InternalAspect.g:1145:2: rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4
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
    // InternalAspect.g:1152:1: rule__Pointcut__Group__3__Impl : ( 'pattern' ) ;
    public final void rule__Pointcut__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1156:1: ( ( 'pattern' ) )
            // InternalAspect.g:1157:1: ( 'pattern' )
            {
            // InternalAspect.g:1157:1: ( 'pattern' )
            // InternalAspect.g:1158:1: 'pattern'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternKeyword_3()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1171:1: rule__Pointcut__Group__4 : rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5 ;
    public final void rule__Pointcut__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1175:1: ( rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5 )
            // InternalAspect.g:1176:2: rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5
            {
            pushFollow(FOLLOW_10);
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
    // InternalAspect.g:1183:1: rule__Pointcut__Group__4__Impl : ( ( rule__Pointcut__PatternAssignment_4 ) ) ;
    public final void rule__Pointcut__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1187:1: ( ( ( rule__Pointcut__PatternAssignment_4 ) ) )
            // InternalAspect.g:1188:1: ( ( rule__Pointcut__PatternAssignment_4 ) )
            {
            // InternalAspect.g:1188:1: ( ( rule__Pointcut__PatternAssignment_4 ) )
            // InternalAspect.g:1189:1: ( rule__Pointcut__PatternAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternAssignment_4()); 
            }
            // InternalAspect.g:1190:1: ( rule__Pointcut__PatternAssignment_4 )
            // InternalAspect.g:1190:2: rule__Pointcut__PatternAssignment_4
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
    // InternalAspect.g:1200:1: rule__Pointcut__Group__5 : rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6 ;
    public final void rule__Pointcut__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1204:1: ( rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6 )
            // InternalAspect.g:1205:2: rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6
            {
            pushFollow(FOLLOW_10);
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
    // InternalAspect.g:1212:1: rule__Pointcut__Group__5__Impl : ( ( rule__Pointcut__Group_5__0 )? ) ;
    public final void rule__Pointcut__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1216:1: ( ( ( rule__Pointcut__Group_5__0 )? ) )
            // InternalAspect.g:1217:1: ( ( rule__Pointcut__Group_5__0 )? )
            {
            // InternalAspect.g:1217:1: ( ( rule__Pointcut__Group_5__0 )? )
            // InternalAspect.g:1218:1: ( rule__Pointcut__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getGroup_5()); 
            }
            // InternalAspect.g:1219:1: ( rule__Pointcut__Group_5__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalAspect.g:1219:2: rule__Pointcut__Group_5__0
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
    // InternalAspect.g:1229:1: rule__Pointcut__Group__6 : rule__Pointcut__Group__6__Impl ;
    public final void rule__Pointcut__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1233:1: ( rule__Pointcut__Group__6__Impl )
            // InternalAspect.g:1234:2: rule__Pointcut__Group__6__Impl
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
    // InternalAspect.g:1240:1: rule__Pointcut__Group__6__Impl : ( '}' ) ;
    public final void rule__Pointcut__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1244:1: ( ( '}' ) )
            // InternalAspect.g:1245:1: ( '}' )
            {
            // InternalAspect.g:1245:1: ( '}' )
            // InternalAspect.g:1246:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1273:1: rule__Pointcut__Group_5__0 : rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1 ;
    public final void rule__Pointcut__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1277:1: ( rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1 )
            // InternalAspect.g:1278:2: rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1
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
    // InternalAspect.g:1285:1: rule__Pointcut__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Pointcut__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1289:1: ( ( ',' ) )
            // InternalAspect.g:1290:1: ( ',' )
            {
            // InternalAspect.g:1290:1: ( ',' )
            // InternalAspect.g:1291:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getCommaKeyword_5_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1304:1: rule__Pointcut__Group_5__1 : rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2 ;
    public final void rule__Pointcut__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1308:1: ( rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2 )
            // InternalAspect.g:1309:2: rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2
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
    // InternalAspect.g:1316:1: rule__Pointcut__Group_5__1__Impl : ( 'role' ) ;
    public final void rule__Pointcut__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1320:1: ( ( 'role' ) )
            // InternalAspect.g:1321:1: ( 'role' )
            {
            // InternalAspect.g:1321:1: ( 'role' )
            // InternalAspect.g:1322:1: 'role'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleKeyword_5_1()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1335:1: rule__Pointcut__Group_5__2 : rule__Pointcut__Group_5__2__Impl ;
    public final void rule__Pointcut__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1339:1: ( rule__Pointcut__Group_5__2__Impl )
            // InternalAspect.g:1340:2: rule__Pointcut__Group_5__2__Impl
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
    // InternalAspect.g:1346:1: rule__Pointcut__Group_5__2__Impl : ( ( rule__Pointcut__RoleAssignment_5_2 ) ) ;
    public final void rule__Pointcut__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1350:1: ( ( ( rule__Pointcut__RoleAssignment_5_2 ) ) )
            // InternalAspect.g:1351:1: ( ( rule__Pointcut__RoleAssignment_5_2 ) )
            {
            // InternalAspect.g:1351:1: ( ( rule__Pointcut__RoleAssignment_5_2 ) )
            // InternalAspect.g:1352:1: ( rule__Pointcut__RoleAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleAssignment_5_2()); 
            }
            // InternalAspect.g:1353:1: ( rule__Pointcut__RoleAssignment_5_2 )
            // InternalAspect.g:1353:2: rule__Pointcut__RoleAssignment_5_2
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
    // InternalAspect.g:1369:1: rule__Composition__Group__0 : rule__Composition__Group__0__Impl rule__Composition__Group__1 ;
    public final void rule__Composition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1373:1: ( rule__Composition__Group__0__Impl rule__Composition__Group__1 )
            // InternalAspect.g:1374:2: rule__Composition__Group__0__Impl rule__Composition__Group__1
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
    // InternalAspect.g:1381:1: rule__Composition__Group__0__Impl : ( 'composition' ) ;
    public final void rule__Composition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1385:1: ( ( 'composition' ) )
            // InternalAspect.g:1386:1: ( 'composition' )
            {
            // InternalAspect.g:1386:1: ( 'composition' )
            // InternalAspect.g:1387:1: 'composition'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCompositionKeyword_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1400:1: rule__Composition__Group__1 : rule__Composition__Group__1__Impl rule__Composition__Group__2 ;
    public final void rule__Composition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1404:1: ( rule__Composition__Group__1__Impl rule__Composition__Group__2 )
            // InternalAspect.g:1405:2: rule__Composition__Group__1__Impl rule__Composition__Group__2
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
    // InternalAspect.g:1412:1: rule__Composition__Group__1__Impl : ( ( rule__Composition__NameAssignment_1 ) ) ;
    public final void rule__Composition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1416:1: ( ( ( rule__Composition__NameAssignment_1 ) ) )
            // InternalAspect.g:1417:1: ( ( rule__Composition__NameAssignment_1 ) )
            {
            // InternalAspect.g:1417:1: ( ( rule__Composition__NameAssignment_1 ) )
            // InternalAspect.g:1418:1: ( rule__Composition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:1419:1: ( rule__Composition__NameAssignment_1 )
            // InternalAspect.g:1419:2: rule__Composition__NameAssignment_1
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
    // InternalAspect.g:1429:1: rule__Composition__Group__2 : rule__Composition__Group__2__Impl rule__Composition__Group__3 ;
    public final void rule__Composition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1433:1: ( rule__Composition__Group__2__Impl rule__Composition__Group__3 )
            // InternalAspect.g:1434:2: rule__Composition__Group__2__Impl rule__Composition__Group__3
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
    // InternalAspect.g:1441:1: rule__Composition__Group__2__Impl : ( '{' ) ;
    public final void rule__Composition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1445:1: ( ( '{' ) )
            // InternalAspect.g:1446:1: ( '{' )
            {
            // InternalAspect.g:1446:1: ( '{' )
            // InternalAspect.g:1447:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1460:1: rule__Composition__Group__3 : rule__Composition__Group__3__Impl rule__Composition__Group__4 ;
    public final void rule__Composition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1464:1: ( rule__Composition__Group__3__Impl rule__Composition__Group__4 )
            // InternalAspect.g:1465:2: rule__Composition__Group__3__Impl rule__Composition__Group__4
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
    // InternalAspect.g:1472:1: rule__Composition__Group__3__Impl : ( 'feature_enabled' ) ;
    public final void rule__Composition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1476:1: ( ( 'feature_enabled' ) )
            // InternalAspect.g:1477:1: ( 'feature_enabled' )
            {
            // InternalAspect.g:1477:1: ( 'feature_enabled' )
            // InternalAspect.g:1478:1: 'feature_enabled'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getFeature_enabledKeyword_3()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1491:1: rule__Composition__Group__4 : rule__Composition__Group__4__Impl rule__Composition__Group__5 ;
    public final void rule__Composition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1495:1: ( rule__Composition__Group__4__Impl rule__Composition__Group__5 )
            // InternalAspect.g:1496:2: rule__Composition__Group__4__Impl rule__Composition__Group__5
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
    // InternalAspect.g:1503:1: rule__Composition__Group__4__Impl : ( ( rule__Composition__Feature_enabledAssignment_4 ) ) ;
    public final void rule__Composition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1507:1: ( ( ( rule__Composition__Feature_enabledAssignment_4 ) ) )
            // InternalAspect.g:1508:1: ( ( rule__Composition__Feature_enabledAssignment_4 ) )
            {
            // InternalAspect.g:1508:1: ( ( rule__Composition__Feature_enabledAssignment_4 ) )
            // InternalAspect.g:1509:1: ( rule__Composition__Feature_enabledAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getFeature_enabledAssignment_4()); 
            }
            // InternalAspect.g:1510:1: ( rule__Composition__Feature_enabledAssignment_4 )
            // InternalAspect.g:1510:2: rule__Composition__Feature_enabledAssignment_4
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
    // InternalAspect.g:1520:1: rule__Composition__Group__5 : rule__Composition__Group__5__Impl rule__Composition__Group__6 ;
    public final void rule__Composition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1524:1: ( rule__Composition__Group__5__Impl rule__Composition__Group__6 )
            // InternalAspect.g:1525:2: rule__Composition__Group__5__Impl rule__Composition__Group__6
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
    // InternalAspect.g:1532:1: rule__Composition__Group__5__Impl : ( ( rule__Composition__Group_5__0 )? ) ;
    public final void rule__Composition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1536:1: ( ( ( rule__Composition__Group_5__0 )? ) )
            // InternalAspect.g:1537:1: ( ( rule__Composition__Group_5__0 )? )
            {
            // InternalAspect.g:1537:1: ( ( rule__Composition__Group_5__0 )? )
            // InternalAspect.g:1538:1: ( rule__Composition__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup_5()); 
            }
            // InternalAspect.g:1539:1: ( rule__Composition__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==30) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalAspect.g:1539:2: rule__Composition__Group_5__0
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
    // InternalAspect.g:1549:1: rule__Composition__Group__6 : rule__Composition__Group__6__Impl rule__Composition__Group__7 ;
    public final void rule__Composition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1553:1: ( rule__Composition__Group__6__Impl rule__Composition__Group__7 )
            // InternalAspect.g:1554:2: rule__Composition__Group__6__Impl rule__Composition__Group__7
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
    // InternalAspect.g:1561:1: rule__Composition__Group__6__Impl : ( ( rule__Composition__Group_6__0 )? ) ;
    public final void rule__Composition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1565:1: ( ( ( rule__Composition__Group_6__0 )? ) )
            // InternalAspect.g:1566:1: ( ( rule__Composition__Group_6__0 )? )
            {
            // InternalAspect.g:1566:1: ( ( rule__Composition__Group_6__0 )? )
            // InternalAspect.g:1567:1: ( rule__Composition__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup_6()); 
            }
            // InternalAspect.g:1568:1: ( rule__Composition__Group_6__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==31) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // InternalAspect.g:1568:2: rule__Composition__Group_6__0
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
    // InternalAspect.g:1578:1: rule__Composition__Group__7 : rule__Composition__Group__7__Impl rule__Composition__Group__8 ;
    public final void rule__Composition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1582:1: ( rule__Composition__Group__7__Impl rule__Composition__Group__8 )
            // InternalAspect.g:1583:2: rule__Composition__Group__7__Impl rule__Composition__Group__8
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
    // InternalAspect.g:1590:1: rule__Composition__Group__7__Impl : ( ',' ) ;
    public final void rule__Composition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1594:1: ( ( ',' ) )
            // InternalAspect.g:1595:1: ( ',' )
            {
            // InternalAspect.g:1595:1: ( ',' )
            // InternalAspect.g:1596:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCommaKeyword_7()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1609:1: rule__Composition__Group__8 : rule__Composition__Group__8__Impl rule__Composition__Group__9 ;
    public final void rule__Composition__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1613:1: ( rule__Composition__Group__8__Impl rule__Composition__Group__9 )
            // InternalAspect.g:1614:2: rule__Composition__Group__8__Impl rule__Composition__Group__9
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
    // InternalAspect.g:1621:1: rule__Composition__Group__8__Impl : ( 'action' ) ;
    public final void rule__Composition__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1625:1: ( ( 'action' ) )
            // InternalAspect.g:1626:1: ( 'action' )
            {
            // InternalAspect.g:1626:1: ( 'action' )
            // InternalAspect.g:1627:1: 'action'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getActionKeyword_8()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1640:1: rule__Composition__Group__9 : rule__Composition__Group__9__Impl rule__Composition__Group__10 ;
    public final void rule__Composition__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1644:1: ( rule__Composition__Group__9__Impl rule__Composition__Group__10 )
            // InternalAspect.g:1645:2: rule__Composition__Group__9__Impl rule__Composition__Group__10
            {
            pushFollow(FOLLOW_14);
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
    // InternalAspect.g:1652:1: rule__Composition__Group__9__Impl : ( ( rule__Composition__ActionAssignment_9 ) ) ;
    public final void rule__Composition__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1656:1: ( ( ( rule__Composition__ActionAssignment_9 ) ) )
            // InternalAspect.g:1657:1: ( ( rule__Composition__ActionAssignment_9 ) )
            {
            // InternalAspect.g:1657:1: ( ( rule__Composition__ActionAssignment_9 ) )
            // InternalAspect.g:1658:1: ( rule__Composition__ActionAssignment_9 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getActionAssignment_9()); 
            }
            // InternalAspect.g:1659:1: ( rule__Composition__ActionAssignment_9 )
            // InternalAspect.g:1659:2: rule__Composition__ActionAssignment_9
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
    // InternalAspect.g:1669:1: rule__Composition__Group__10 : rule__Composition__Group__10__Impl ;
    public final void rule__Composition__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1673:1: ( rule__Composition__Group__10__Impl )
            // InternalAspect.g:1674:2: rule__Composition__Group__10__Impl
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
    // InternalAspect.g:1680:1: rule__Composition__Group__10__Impl : ( '}' ) ;
    public final void rule__Composition__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1684:1: ( ( '}' ) )
            // InternalAspect.g:1685:1: ( '}' )
            {
            // InternalAspect.g:1685:1: ( '}' )
            // InternalAspect.g:1686:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_10()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1721:1: rule__Composition__Group_5__0 : rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1 ;
    public final void rule__Composition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1725:1: ( rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1 )
            // InternalAspect.g:1726:2: rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1
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
    // InternalAspect.g:1733:1: rule__Composition__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Composition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1737:1: ( ( ',' ) )
            // InternalAspect.g:1738:1: ( ',' )
            {
            // InternalAspect.g:1738:1: ( ',' )
            // InternalAspect.g:1739:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCommaKeyword_5_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1752:1: rule__Composition__Group_5__1 : rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2 ;
    public final void rule__Composition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1756:1: ( rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2 )
            // InternalAspect.g:1757:2: rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2
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
    // InternalAspect.g:1764:1: rule__Composition__Group_5__1__Impl : ( 'jointpointRole' ) ;
    public final void rule__Composition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1768:1: ( ( 'jointpointRole' ) )
            // InternalAspect.g:1769:1: ( 'jointpointRole' )
            {
            // InternalAspect.g:1769:1: ( 'jointpointRole' )
            // InternalAspect.g:1770:1: 'jointpointRole'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleKeyword_5_1()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1783:1: rule__Composition__Group_5__2 : rule__Composition__Group_5__2__Impl ;
    public final void rule__Composition__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1787:1: ( rule__Composition__Group_5__2__Impl )
            // InternalAspect.g:1788:2: rule__Composition__Group_5__2__Impl
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
    // InternalAspect.g:1794:1: rule__Composition__Group_5__2__Impl : ( ( rule__Composition__JointpointRoleAssignment_5_2 ) ) ;
    public final void rule__Composition__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1798:1: ( ( ( rule__Composition__JointpointRoleAssignment_5_2 ) ) )
            // InternalAspect.g:1799:1: ( ( rule__Composition__JointpointRoleAssignment_5_2 ) )
            {
            // InternalAspect.g:1799:1: ( ( rule__Composition__JointpointRoleAssignment_5_2 ) )
            // InternalAspect.g:1800:1: ( rule__Composition__JointpointRoleAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleAssignment_5_2()); 
            }
            // InternalAspect.g:1801:1: ( rule__Composition__JointpointRoleAssignment_5_2 )
            // InternalAspect.g:1801:2: rule__Composition__JointpointRoleAssignment_5_2
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
    // InternalAspect.g:1817:1: rule__Composition__Group_6__0 : rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1 ;
    public final void rule__Composition__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1821:1: ( rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1 )
            // InternalAspect.g:1822:2: rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1
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
    // InternalAspect.g:1829:1: rule__Composition__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Composition__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1833:1: ( ( ',' ) )
            // InternalAspect.g:1834:1: ( ',' )
            {
            // InternalAspect.g:1834:1: ( ',' )
            // InternalAspect.g:1835:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getCommaKeyword_6_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1848:1: rule__Composition__Group_6__1 : rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2 ;
    public final void rule__Composition__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1852:1: ( rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2 )
            // InternalAspect.g:1853:2: rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2
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
    // InternalAspect.g:1860:1: rule__Composition__Group_6__1__Impl : ( 'adviceRole' ) ;
    public final void rule__Composition__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1864:1: ( ( 'adviceRole' ) )
            // InternalAspect.g:1865:1: ( 'adviceRole' )
            {
            // InternalAspect.g:1865:1: ( 'adviceRole' )
            // InternalAspect.g:1866:1: 'adviceRole'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceRoleKeyword_6_1()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalAspect.g:1879:1: rule__Composition__Group_6__2 : rule__Composition__Group_6__2__Impl ;
    public final void rule__Composition__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1883:1: ( rule__Composition__Group_6__2__Impl )
            // InternalAspect.g:1884:2: rule__Composition__Group_6__2__Impl
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
    // InternalAspect.g:1890:1: rule__Composition__Group_6__2__Impl : ( ( rule__Composition__AdviceAssignment_6_2 ) ) ;
    public final void rule__Composition__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1894:1: ( ( ( rule__Composition__AdviceAssignment_6_2 ) ) )
            // InternalAspect.g:1895:1: ( ( rule__Composition__AdviceAssignment_6_2 ) )
            {
            // InternalAspect.g:1895:1: ( ( rule__Composition__AdviceAssignment_6_2 ) )
            // InternalAspect.g:1896:1: ( rule__Composition__AdviceAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceAssignment_6_2()); 
            }
            // InternalAspect.g:1897:1: ( rule__Composition__AdviceAssignment_6_2 )
            // InternalAspect.g:1897:2: rule__Composition__AdviceAssignment_6_2
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalAspect.g:1913:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1917:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAspect.g:1918:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAspect.g:1925:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1929:1: ( ( RULE_ID ) )
            // InternalAspect.g:1930:1: ( RULE_ID )
            {
            // InternalAspect.g:1930:1: ( RULE_ID )
            // InternalAspect.g:1931:1: RULE_ID
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
    // InternalAspect.g:1942:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1946:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAspect.g:1947:2: rule__QualifiedName__Group__1__Impl
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
    // InternalAspect.g:1953:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1957:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAspect.g:1958:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAspect.g:1958:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAspect.g:1959:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalAspect.g:1960:1: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAspect.g:1960:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalAspect.g:1974:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1978:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAspect.g:1979:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalAspect.g:1986:1: rule__QualifiedName__Group_1__0__Impl : ( ( '.' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:1990:1: ( ( ( '.' ) ) )
            // InternalAspect.g:1991:1: ( ( '.' ) )
            {
            // InternalAspect.g:1991:1: ( ( '.' ) )
            // InternalAspect.g:1992:1: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            // InternalAspect.g:1993:1: ( '.' )
            // InternalAspect.g:1994:2: '.'
            {
            match(input,32,FOLLOW_2); if (state.failed) return ;

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
    // InternalAspect.g:2005:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2009:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAspect.g:2010:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalAspect.g:2016:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2020:1: ( ( RULE_ID ) )
            // InternalAspect.g:2021:1: ( RULE_ID )
            {
            // InternalAspect.g:2021:1: ( RULE_ID )
            // InternalAspect.g:2022:1: RULE_ID
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
    // InternalAspect.g:2038:1: rule__Aspect__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Aspect__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2042:1: ( ( RULE_ID ) )
            // InternalAspect.g:2043:1: ( RULE_ID )
            {
            // InternalAspect.g:2043:1: ( RULE_ID )
            // InternalAspect.g:2044:1: RULE_ID
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
    // InternalAspect.g:2053:1: rule__Aspect__FeatureAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Aspect__FeatureAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2057:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2058:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2058:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2059:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); 
            }
            // InternalAspect.g:2060:1: ( ruleQualifiedName )
            // InternalAspect.g:2061:1: ruleQualifiedName
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


    // $ANTLR start "rule__Aspect__AdviceAssignment_7"
    // InternalAspect.g:2072:1: rule__Aspect__AdviceAssignment_7 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Aspect__AdviceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2076:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2077:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2077:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2078:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceModelCrossReference_7_0()); 
            }
            // InternalAspect.g:2079:1: ( ruleQualifiedName )
            // InternalAspect.g:2080:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceModelQualifiedNameParserRuleCall_7_0_1()); 
            }
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceModelQualifiedNameParserRuleCall_7_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getAdviceModelCrossReference_7_0()); 
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
    // $ANTLR end "rule__Aspect__AdviceAssignment_7"


    // $ANTLR start "rule__Aspect__PointcutsAssignment_11"
    // InternalAspect.g:2091:1: rule__Aspect__PointcutsAssignment_11 : ( rulePointcut ) ;
    public final void rule__Aspect__PointcutsAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2095:1: ( ( rulePointcut ) )
            // InternalAspect.g:2096:1: ( rulePointcut )
            {
            // InternalAspect.g:2096:1: ( rulePointcut )
            // InternalAspect.g:2097:1: rulePointcut
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_11_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePointcut();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_11_0()); 
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
    // $ANTLR end "rule__Aspect__PointcutsAssignment_11"


    // $ANTLR start "rule__Aspect__PointcutsAssignment_12_1"
    // InternalAspect.g:2106:1: rule__Aspect__PointcutsAssignment_12_1 : ( rulePointcut ) ;
    public final void rule__Aspect__PointcutsAssignment_12_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2110:1: ( ( rulePointcut ) )
            // InternalAspect.g:2111:1: ( rulePointcut )
            {
            // InternalAspect.g:2111:1: ( rulePointcut )
            // InternalAspect.g:2112:1: rulePointcut
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_12_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePointcut();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_12_1_0()); 
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
    // $ANTLR end "rule__Aspect__PointcutsAssignment_12_1"


    // $ANTLR start "rule__Aspect__CompositionsAssignment_17"
    // InternalAspect.g:2121:1: rule__Aspect__CompositionsAssignment_17 : ( ruleComposition ) ;
    public final void rule__Aspect__CompositionsAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2125:1: ( ( ruleComposition ) )
            // InternalAspect.g:2126:1: ( ruleComposition )
            {
            // InternalAspect.g:2126:1: ( ruleComposition )
            // InternalAspect.g:2127:1: ruleComposition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_17_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComposition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_17_0()); 
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
    // $ANTLR end "rule__Aspect__CompositionsAssignment_17"


    // $ANTLR start "rule__Aspect__CompositionsAssignment_18_1"
    // InternalAspect.g:2136:1: rule__Aspect__CompositionsAssignment_18_1 : ( ruleComposition ) ;
    public final void rule__Aspect__CompositionsAssignment_18_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2140:1: ( ( ruleComposition ) )
            // InternalAspect.g:2141:1: ( ruleComposition )
            {
            // InternalAspect.g:2141:1: ( ruleComposition )
            // InternalAspect.g:2142:1: ruleComposition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_18_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleComposition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_18_1_0()); 
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
    // $ANTLR end "rule__Aspect__CompositionsAssignment_18_1"


    // $ANTLR start "rule__Pointcut__NameAssignment_1"
    // InternalAspect.g:2151:1: rule__Pointcut__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Pointcut__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2155:1: ( ( RULE_ID ) )
            // InternalAspect.g:2156:1: ( RULE_ID )
            {
            // InternalAspect.g:2156:1: ( RULE_ID )
            // InternalAspect.g:2157:1: RULE_ID
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
    // InternalAspect.g:2166:1: rule__Pointcut__PatternAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Pointcut__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2170:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2171:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2171:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2172:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); 
            }
            // InternalAspect.g:2173:1: ( ruleQualifiedName )
            // InternalAspect.g:2174:1: ruleQualifiedName
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
    // InternalAspect.g:2185:1: rule__Pointcut__RoleAssignment_5_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Pointcut__RoleAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2189:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2190:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2190:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2191:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); 
            }
            // InternalAspect.g:2192:1: ( ruleQualifiedName )
            // InternalAspect.g:2193:1: ruleQualifiedName
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
    // InternalAspect.g:2204:1: rule__Composition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Composition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2208:1: ( ( RULE_ID ) )
            // InternalAspect.g:2209:1: ( RULE_ID )
            {
            // InternalAspect.g:2209:1: ( RULE_ID )
            // InternalAspect.g:2210:1: RULE_ID
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
    // InternalAspect.g:2219:1: rule__Composition__Feature_enabledAssignment_4 : ( RULE_EBOOLEAN ) ;
    public final void rule__Composition__Feature_enabledAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2223:1: ( ( RULE_EBOOLEAN ) )
            // InternalAspect.g:2224:1: ( RULE_EBOOLEAN )
            {
            // InternalAspect.g:2224:1: ( RULE_EBOOLEAN )
            // InternalAspect.g:2225:1: RULE_EBOOLEAN
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
    // InternalAspect.g:2234:1: rule__Composition__JointpointRoleAssignment_5_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Composition__JointpointRoleAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2238:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2239:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2239:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2240:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); 
            }
            // InternalAspect.g:2241:1: ( ruleQualifiedName )
            // InternalAspect.g:2242:1: ruleQualifiedName
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
    // InternalAspect.g:2253:1: rule__Composition__AdviceAssignment_6_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Composition__AdviceAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2257:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:2258:1: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:2258:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:2259:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); 
            }
            // InternalAspect.g:2260:1: ( ruleQualifiedName )
            // InternalAspect.g:2261:1: ruleQualifiedName
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
    // InternalAspect.g:2272:1: rule__Composition__ActionAssignment_9 : ( ruleAction ) ;
    public final void rule__Composition__ActionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalAspect.g:2276:1: ( ( ruleAction ) )
            // InternalAspect.g:2277:1: ( ruleAction )
            {
            // InternalAspect.g:2277:1: ( ruleAction )
            // InternalAspect.g:2278:1: ruleAction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getActionActionParserRuleCall_9_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompositionAccess().getActionActionParserRuleCall_9_0()); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000000F000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000002L});

}