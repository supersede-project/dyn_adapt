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
    // InternalAspect.g:54:1: entryRuleAspect : ruleAspect EOF ;
    public final void entryRuleAspect() throws RecognitionException {
        try {
            // InternalAspect.g:55:1: ( ruleAspect EOF )
            // InternalAspect.g:56:1: ruleAspect EOF
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
    // InternalAspect.g:63:1: ruleAspect : ( ( rule__Aspect__Group__0 ) ) ;
    public final void ruleAspect() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:67:2: ( ( ( rule__Aspect__Group__0 ) ) )
            // InternalAspect.g:68:2: ( ( rule__Aspect__Group__0 ) )
            {
            // InternalAspect.g:68:2: ( ( rule__Aspect__Group__0 ) )
            // InternalAspect.g:69:3: ( rule__Aspect__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup()); 
            }
            // InternalAspect.g:70:3: ( rule__Aspect__Group__0 )
            // InternalAspect.g:70:4: rule__Aspect__Group__0
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
    // InternalAspect.g:79:1: entryRulePointcut : rulePointcut EOF ;
    public final void entryRulePointcut() throws RecognitionException {
        try {
            // InternalAspect.g:80:1: ( rulePointcut EOF )
            // InternalAspect.g:81:1: rulePointcut EOF
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
    // InternalAspect.g:88:1: rulePointcut : ( ( rule__Pointcut__Group__0 ) ) ;
    public final void rulePointcut() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:92:2: ( ( ( rule__Pointcut__Group__0 ) ) )
            // InternalAspect.g:93:2: ( ( rule__Pointcut__Group__0 ) )
            {
            // InternalAspect.g:93:2: ( ( rule__Pointcut__Group__0 ) )
            // InternalAspect.g:94:3: ( rule__Pointcut__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getGroup()); 
            }
            // InternalAspect.g:95:3: ( rule__Pointcut__Group__0 )
            // InternalAspect.g:95:4: rule__Pointcut__Group__0
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
    // InternalAspect.g:104:1: entryRuleComposition : ruleComposition EOF ;
    public final void entryRuleComposition() throws RecognitionException {
        try {
            // InternalAspect.g:105:1: ( ruleComposition EOF )
            // InternalAspect.g:106:1: ruleComposition EOF
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
    // InternalAspect.g:113:1: ruleComposition : ( ( rule__Composition__Group__0 ) ) ;
    public final void ruleComposition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:117:2: ( ( ( rule__Composition__Group__0 ) ) )
            // InternalAspect.g:118:2: ( ( rule__Composition__Group__0 ) )
            {
            // InternalAspect.g:118:2: ( ( rule__Composition__Group__0 ) )
            // InternalAspect.g:119:3: ( rule__Composition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup()); 
            }
            // InternalAspect.g:120:3: ( rule__Composition__Group__0 )
            // InternalAspect.g:120:4: rule__Composition__Group__0
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
    // InternalAspect.g:129:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalAspect.g:130:1: ( ruleAction EOF )
            // InternalAspect.g:131:1: ruleAction EOF
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
    // InternalAspect.g:138:1: ruleAction : ( ( rule__Action__Alternatives ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:142:2: ( ( ( rule__Action__Alternatives ) ) )
            // InternalAspect.g:143:2: ( ( rule__Action__Alternatives ) )
            {
            // InternalAspect.g:143:2: ( ( rule__Action__Alternatives ) )
            // InternalAspect.g:144:3: ( rule__Action__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getActionAccess().getAlternatives()); 
            }
            // InternalAspect.g:145:3: ( rule__Action__Alternatives )
            // InternalAspect.g:145:4: rule__Action__Alternatives
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
    // InternalAspect.g:154:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalAspect.g:155:1: ( ruleQualifiedName EOF )
            // InternalAspect.g:156:1: ruleQualifiedName EOF
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
    // InternalAspect.g:163:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:167:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalAspect.g:168:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalAspect.g:168:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalAspect.g:169:3: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // InternalAspect.g:170:3: ( rule__QualifiedName__Group__0 )
            // InternalAspect.g:170:4: rule__QualifiedName__Group__0
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
    // InternalAspect.g:178:1: rule__Action__Alternatives : ( ( 'add' ) | ( 'delete' ) | ( 'replace' ) | ( 'associate' ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:182:1: ( ( 'add' ) | ( 'delete' ) | ( 'replace' ) | ( 'associate' ) )
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
                    // InternalAspect.g:183:2: ( 'add' )
                    {
                    // InternalAspect.g:183:2: ( 'add' )
                    // InternalAspect.g:184:3: 'add'
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
                    // InternalAspect.g:189:2: ( 'delete' )
                    {
                    // InternalAspect.g:189:2: ( 'delete' )
                    // InternalAspect.g:190:3: 'delete'
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
                    // InternalAspect.g:195:2: ( 'replace' )
                    {
                    // InternalAspect.g:195:2: ( 'replace' )
                    // InternalAspect.g:196:3: 'replace'
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
                    // InternalAspect.g:201:2: ( 'associate' )
                    {
                    // InternalAspect.g:201:2: ( 'associate' )
                    // InternalAspect.g:202:3: 'associate'
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
    // InternalAspect.g:211:1: rule__Aspect__Group__0 : rule__Aspect__Group__0__Impl rule__Aspect__Group__1 ;
    public final void rule__Aspect__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:215:1: ( rule__Aspect__Group__0__Impl rule__Aspect__Group__1 )
            // InternalAspect.g:216:2: rule__Aspect__Group__0__Impl rule__Aspect__Group__1
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
    // InternalAspect.g:223:1: rule__Aspect__Group__0__Impl : ( 'aspect' ) ;
    public final void rule__Aspect__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:227:1: ( ( 'aspect' ) )
            // InternalAspect.g:228:1: ( 'aspect' )
            {
            // InternalAspect.g:228:1: ( 'aspect' )
            // InternalAspect.g:229:2: 'aspect'
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
    // InternalAspect.g:238:1: rule__Aspect__Group__1 : rule__Aspect__Group__1__Impl rule__Aspect__Group__2 ;
    public final void rule__Aspect__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:242:1: ( rule__Aspect__Group__1__Impl rule__Aspect__Group__2 )
            // InternalAspect.g:243:2: rule__Aspect__Group__1__Impl rule__Aspect__Group__2
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
    // InternalAspect.g:250:1: rule__Aspect__Group__1__Impl : ( ( rule__Aspect__NameAssignment_1 ) ) ;
    public final void rule__Aspect__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:254:1: ( ( ( rule__Aspect__NameAssignment_1 ) ) )
            // InternalAspect.g:255:1: ( ( rule__Aspect__NameAssignment_1 ) )
            {
            // InternalAspect.g:255:1: ( ( rule__Aspect__NameAssignment_1 ) )
            // InternalAspect.g:256:2: ( rule__Aspect__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:257:2: ( rule__Aspect__NameAssignment_1 )
            // InternalAspect.g:257:3: rule__Aspect__NameAssignment_1
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
    // InternalAspect.g:265:1: rule__Aspect__Group__2 : rule__Aspect__Group__2__Impl rule__Aspect__Group__3 ;
    public final void rule__Aspect__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:269:1: ( rule__Aspect__Group__2__Impl rule__Aspect__Group__3 )
            // InternalAspect.g:270:2: rule__Aspect__Group__2__Impl rule__Aspect__Group__3
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
    // InternalAspect.g:277:1: rule__Aspect__Group__2__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:281:1: ( ( '{' ) )
            // InternalAspect.g:282:1: ( '{' )
            {
            // InternalAspect.g:282:1: ( '{' )
            // InternalAspect.g:283:2: '{'
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
    // InternalAspect.g:292:1: rule__Aspect__Group__3 : rule__Aspect__Group__3__Impl rule__Aspect__Group__4 ;
    public final void rule__Aspect__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:296:1: ( rule__Aspect__Group__3__Impl rule__Aspect__Group__4 )
            // InternalAspect.g:297:2: rule__Aspect__Group__3__Impl rule__Aspect__Group__4
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
    // InternalAspect.g:304:1: rule__Aspect__Group__3__Impl : ( 'feature' ) ;
    public final void rule__Aspect__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:308:1: ( ( 'feature' ) )
            // InternalAspect.g:309:1: ( 'feature' )
            {
            // InternalAspect.g:309:1: ( 'feature' )
            // InternalAspect.g:310:2: 'feature'
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
    // InternalAspect.g:319:1: rule__Aspect__Group__4 : rule__Aspect__Group__4__Impl rule__Aspect__Group__5 ;
    public final void rule__Aspect__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:323:1: ( rule__Aspect__Group__4__Impl rule__Aspect__Group__5 )
            // InternalAspect.g:324:2: rule__Aspect__Group__4__Impl rule__Aspect__Group__5
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
    // InternalAspect.g:331:1: rule__Aspect__Group__4__Impl : ( ( rule__Aspect__FeatureAssignment_4 ) ) ;
    public final void rule__Aspect__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:335:1: ( ( ( rule__Aspect__FeatureAssignment_4 ) ) )
            // InternalAspect.g:336:1: ( ( rule__Aspect__FeatureAssignment_4 ) )
            {
            // InternalAspect.g:336:1: ( ( rule__Aspect__FeatureAssignment_4 ) )
            // InternalAspect.g:337:2: ( rule__Aspect__FeatureAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureAssignment_4()); 
            }
            // InternalAspect.g:338:2: ( rule__Aspect__FeatureAssignment_4 )
            // InternalAspect.g:338:3: rule__Aspect__FeatureAssignment_4
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
    // InternalAspect.g:346:1: rule__Aspect__Group__5 : rule__Aspect__Group__5__Impl rule__Aspect__Group__6 ;
    public final void rule__Aspect__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:350:1: ( rule__Aspect__Group__5__Impl rule__Aspect__Group__6 )
            // InternalAspect.g:351:2: rule__Aspect__Group__5__Impl rule__Aspect__Group__6
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
    // InternalAspect.g:358:1: rule__Aspect__Group__5__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:362:1: ( ( ',' ) )
            // InternalAspect.g:363:1: ( ',' )
            {
            // InternalAspect.g:363:1: ( ',' )
            // InternalAspect.g:364:2: ','
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
    // InternalAspect.g:373:1: rule__Aspect__Group__6 : rule__Aspect__Group__6__Impl rule__Aspect__Group__7 ;
    public final void rule__Aspect__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:377:1: ( rule__Aspect__Group__6__Impl rule__Aspect__Group__7 )
            // InternalAspect.g:378:2: rule__Aspect__Group__6__Impl rule__Aspect__Group__7
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
    // InternalAspect.g:385:1: rule__Aspect__Group__6__Impl : ( 'advice' ) ;
    public final void rule__Aspect__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:389:1: ( ( 'advice' ) )
            // InternalAspect.g:390:1: ( 'advice' )
            {
            // InternalAspect.g:390:1: ( 'advice' )
            // InternalAspect.g:391:2: 'advice'
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
    // InternalAspect.g:400:1: rule__Aspect__Group__7 : rule__Aspect__Group__7__Impl rule__Aspect__Group__8 ;
    public final void rule__Aspect__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:404:1: ( rule__Aspect__Group__7__Impl rule__Aspect__Group__8 )
            // InternalAspect.g:405:2: rule__Aspect__Group__7__Impl rule__Aspect__Group__8
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
    // InternalAspect.g:412:1: rule__Aspect__Group__7__Impl : ( ( rule__Aspect__AdviceAssignment_7 ) ) ;
    public final void rule__Aspect__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:416:1: ( ( ( rule__Aspect__AdviceAssignment_7 ) ) )
            // InternalAspect.g:417:1: ( ( rule__Aspect__AdviceAssignment_7 ) )
            {
            // InternalAspect.g:417:1: ( ( rule__Aspect__AdviceAssignment_7 ) )
            // InternalAspect.g:418:2: ( rule__Aspect__AdviceAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceAssignment_7()); 
            }
            // InternalAspect.g:419:2: ( rule__Aspect__AdviceAssignment_7 )
            // InternalAspect.g:419:3: rule__Aspect__AdviceAssignment_7
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
    // InternalAspect.g:427:1: rule__Aspect__Group__8 : rule__Aspect__Group__8__Impl rule__Aspect__Group__9 ;
    public final void rule__Aspect__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:431:1: ( rule__Aspect__Group__8__Impl rule__Aspect__Group__9 )
            // InternalAspect.g:432:2: rule__Aspect__Group__8__Impl rule__Aspect__Group__9
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
    // InternalAspect.g:439:1: rule__Aspect__Group__8__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:443:1: ( ( ',' ) )
            // InternalAspect.g:444:1: ( ',' )
            {
            // InternalAspect.g:444:1: ( ',' )
            // InternalAspect.g:445:2: ','
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
    // InternalAspect.g:454:1: rule__Aspect__Group__9 : rule__Aspect__Group__9__Impl rule__Aspect__Group__10 ;
    public final void rule__Aspect__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:458:1: ( rule__Aspect__Group__9__Impl rule__Aspect__Group__10 )
            // InternalAspect.g:459:2: rule__Aspect__Group__9__Impl rule__Aspect__Group__10
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
    // InternalAspect.g:466:1: rule__Aspect__Group__9__Impl : ( 'pointcuts' ) ;
    public final void rule__Aspect__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:470:1: ( ( 'pointcuts' ) )
            // InternalAspect.g:471:1: ( 'pointcuts' )
            {
            // InternalAspect.g:471:1: ( 'pointcuts' )
            // InternalAspect.g:472:2: 'pointcuts'
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
    // InternalAspect.g:481:1: rule__Aspect__Group__10 : rule__Aspect__Group__10__Impl rule__Aspect__Group__11 ;
    public final void rule__Aspect__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:485:1: ( rule__Aspect__Group__10__Impl rule__Aspect__Group__11 )
            // InternalAspect.g:486:2: rule__Aspect__Group__10__Impl rule__Aspect__Group__11
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
    // InternalAspect.g:493:1: rule__Aspect__Group__10__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:497:1: ( ( '{' ) )
            // InternalAspect.g:498:1: ( '{' )
            {
            // InternalAspect.g:498:1: ( '{' )
            // InternalAspect.g:499:2: '{'
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
    // InternalAspect.g:508:1: rule__Aspect__Group__11 : rule__Aspect__Group__11__Impl rule__Aspect__Group__12 ;
    public final void rule__Aspect__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:512:1: ( rule__Aspect__Group__11__Impl rule__Aspect__Group__12 )
            // InternalAspect.g:513:2: rule__Aspect__Group__11__Impl rule__Aspect__Group__12
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
    // InternalAspect.g:520:1: rule__Aspect__Group__11__Impl : ( ( rule__Aspect__PointcutsAssignment_11 ) ) ;
    public final void rule__Aspect__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:524:1: ( ( ( rule__Aspect__PointcutsAssignment_11 ) ) )
            // InternalAspect.g:525:1: ( ( rule__Aspect__PointcutsAssignment_11 ) )
            {
            // InternalAspect.g:525:1: ( ( rule__Aspect__PointcutsAssignment_11 ) )
            // InternalAspect.g:526:2: ( rule__Aspect__PointcutsAssignment_11 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsAssignment_11()); 
            }
            // InternalAspect.g:527:2: ( rule__Aspect__PointcutsAssignment_11 )
            // InternalAspect.g:527:3: rule__Aspect__PointcutsAssignment_11
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
    // InternalAspect.g:535:1: rule__Aspect__Group__12 : rule__Aspect__Group__12__Impl rule__Aspect__Group__13 ;
    public final void rule__Aspect__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:539:1: ( rule__Aspect__Group__12__Impl rule__Aspect__Group__13 )
            // InternalAspect.g:540:2: rule__Aspect__Group__12__Impl rule__Aspect__Group__13
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
    // InternalAspect.g:547:1: rule__Aspect__Group__12__Impl : ( ( rule__Aspect__Group_12__0 )* ) ;
    public final void rule__Aspect__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:551:1: ( ( ( rule__Aspect__Group_12__0 )* ) )
            // InternalAspect.g:552:1: ( ( rule__Aspect__Group_12__0 )* )
            {
            // InternalAspect.g:552:1: ( ( rule__Aspect__Group_12__0 )* )
            // InternalAspect.g:553:2: ( rule__Aspect__Group_12__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup_12()); 
            }
            // InternalAspect.g:554:2: ( rule__Aspect__Group_12__0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAspect.g:554:3: rule__Aspect__Group_12__0
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
    // InternalAspect.g:562:1: rule__Aspect__Group__13 : rule__Aspect__Group__13__Impl rule__Aspect__Group__14 ;
    public final void rule__Aspect__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:566:1: ( rule__Aspect__Group__13__Impl rule__Aspect__Group__14 )
            // InternalAspect.g:567:2: rule__Aspect__Group__13__Impl rule__Aspect__Group__14
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
    // InternalAspect.g:574:1: rule__Aspect__Group__13__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:578:1: ( ( '}' ) )
            // InternalAspect.g:579:1: ( '}' )
            {
            // InternalAspect.g:579:1: ( '}' )
            // InternalAspect.g:580:2: '}'
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
    // InternalAspect.g:589:1: rule__Aspect__Group__14 : rule__Aspect__Group__14__Impl rule__Aspect__Group__15 ;
    public final void rule__Aspect__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:593:1: ( rule__Aspect__Group__14__Impl rule__Aspect__Group__15 )
            // InternalAspect.g:594:2: rule__Aspect__Group__14__Impl rule__Aspect__Group__15
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
    // InternalAspect.g:601:1: rule__Aspect__Group__14__Impl : ( ',' ) ;
    public final void rule__Aspect__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:605:1: ( ( ',' ) )
            // InternalAspect.g:606:1: ( ',' )
            {
            // InternalAspect.g:606:1: ( ',' )
            // InternalAspect.g:607:2: ','
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
    // InternalAspect.g:616:1: rule__Aspect__Group__15 : rule__Aspect__Group__15__Impl rule__Aspect__Group__16 ;
    public final void rule__Aspect__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:620:1: ( rule__Aspect__Group__15__Impl rule__Aspect__Group__16 )
            // InternalAspect.g:621:2: rule__Aspect__Group__15__Impl rule__Aspect__Group__16
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
    // InternalAspect.g:628:1: rule__Aspect__Group__15__Impl : ( 'compositions' ) ;
    public final void rule__Aspect__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:632:1: ( ( 'compositions' ) )
            // InternalAspect.g:633:1: ( 'compositions' )
            {
            // InternalAspect.g:633:1: ( 'compositions' )
            // InternalAspect.g:634:2: 'compositions'
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
    // InternalAspect.g:643:1: rule__Aspect__Group__16 : rule__Aspect__Group__16__Impl rule__Aspect__Group__17 ;
    public final void rule__Aspect__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:647:1: ( rule__Aspect__Group__16__Impl rule__Aspect__Group__17 )
            // InternalAspect.g:648:2: rule__Aspect__Group__16__Impl rule__Aspect__Group__17
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
    // InternalAspect.g:655:1: rule__Aspect__Group__16__Impl : ( '{' ) ;
    public final void rule__Aspect__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:659:1: ( ( '{' ) )
            // InternalAspect.g:660:1: ( '{' )
            {
            // InternalAspect.g:660:1: ( '{' )
            // InternalAspect.g:661:2: '{'
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
    // InternalAspect.g:670:1: rule__Aspect__Group__17 : rule__Aspect__Group__17__Impl rule__Aspect__Group__18 ;
    public final void rule__Aspect__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:674:1: ( rule__Aspect__Group__17__Impl rule__Aspect__Group__18 )
            // InternalAspect.g:675:2: rule__Aspect__Group__17__Impl rule__Aspect__Group__18
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
    // InternalAspect.g:682:1: rule__Aspect__Group__17__Impl : ( ( rule__Aspect__CompositionsAssignment_17 ) ) ;
    public final void rule__Aspect__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:686:1: ( ( ( rule__Aspect__CompositionsAssignment_17 ) ) )
            // InternalAspect.g:687:1: ( ( rule__Aspect__CompositionsAssignment_17 ) )
            {
            // InternalAspect.g:687:1: ( ( rule__Aspect__CompositionsAssignment_17 ) )
            // InternalAspect.g:688:2: ( rule__Aspect__CompositionsAssignment_17 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsAssignment_17()); 
            }
            // InternalAspect.g:689:2: ( rule__Aspect__CompositionsAssignment_17 )
            // InternalAspect.g:689:3: rule__Aspect__CompositionsAssignment_17
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
    // InternalAspect.g:697:1: rule__Aspect__Group__18 : rule__Aspect__Group__18__Impl rule__Aspect__Group__19 ;
    public final void rule__Aspect__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:701:1: ( rule__Aspect__Group__18__Impl rule__Aspect__Group__19 )
            // InternalAspect.g:702:2: rule__Aspect__Group__18__Impl rule__Aspect__Group__19
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
    // InternalAspect.g:709:1: rule__Aspect__Group__18__Impl : ( ( rule__Aspect__Group_18__0 )* ) ;
    public final void rule__Aspect__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:713:1: ( ( ( rule__Aspect__Group_18__0 )* ) )
            // InternalAspect.g:714:1: ( ( rule__Aspect__Group_18__0 )* )
            {
            // InternalAspect.g:714:1: ( ( rule__Aspect__Group_18__0 )* )
            // InternalAspect.g:715:2: ( rule__Aspect__Group_18__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getGroup_18()); 
            }
            // InternalAspect.g:716:2: ( rule__Aspect__Group_18__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAspect.g:716:3: rule__Aspect__Group_18__0
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
    // InternalAspect.g:724:1: rule__Aspect__Group__19 : rule__Aspect__Group__19__Impl rule__Aspect__Group__20 ;
    public final void rule__Aspect__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:728:1: ( rule__Aspect__Group__19__Impl rule__Aspect__Group__20 )
            // InternalAspect.g:729:2: rule__Aspect__Group__19__Impl rule__Aspect__Group__20
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
    // InternalAspect.g:736:1: rule__Aspect__Group__19__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:740:1: ( ( '}' ) )
            // InternalAspect.g:741:1: ( '}' )
            {
            // InternalAspect.g:741:1: ( '}' )
            // InternalAspect.g:742:2: '}'
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
    // InternalAspect.g:751:1: rule__Aspect__Group__20 : rule__Aspect__Group__20__Impl ;
    public final void rule__Aspect__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:755:1: ( rule__Aspect__Group__20__Impl )
            // InternalAspect.g:756:2: rule__Aspect__Group__20__Impl
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
    // InternalAspect.g:762:1: rule__Aspect__Group__20__Impl : ( '}' ) ;
    public final void rule__Aspect__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:766:1: ( ( '}' ) )
            // InternalAspect.g:767:1: ( '}' )
            {
            // InternalAspect.g:767:1: ( '}' )
            // InternalAspect.g:768:2: '}'
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
    // InternalAspect.g:778:1: rule__Aspect__Group_12__0 : rule__Aspect__Group_12__0__Impl rule__Aspect__Group_12__1 ;
    public final void rule__Aspect__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:782:1: ( rule__Aspect__Group_12__0__Impl rule__Aspect__Group_12__1 )
            // InternalAspect.g:783:2: rule__Aspect__Group_12__0__Impl rule__Aspect__Group_12__1
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
    // InternalAspect.g:790:1: rule__Aspect__Group_12__0__Impl : ( ',' ) ;
    public final void rule__Aspect__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:794:1: ( ( ',' ) )
            // InternalAspect.g:795:1: ( ',' )
            {
            // InternalAspect.g:795:1: ( ',' )
            // InternalAspect.g:796:2: ','
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
    // InternalAspect.g:805:1: rule__Aspect__Group_12__1 : rule__Aspect__Group_12__1__Impl ;
    public final void rule__Aspect__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:809:1: ( rule__Aspect__Group_12__1__Impl )
            // InternalAspect.g:810:2: rule__Aspect__Group_12__1__Impl
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
    // InternalAspect.g:816:1: rule__Aspect__Group_12__1__Impl : ( ( rule__Aspect__PointcutsAssignment_12_1 ) ) ;
    public final void rule__Aspect__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:820:1: ( ( ( rule__Aspect__PointcutsAssignment_12_1 ) ) )
            // InternalAspect.g:821:1: ( ( rule__Aspect__PointcutsAssignment_12_1 ) )
            {
            // InternalAspect.g:821:1: ( ( rule__Aspect__PointcutsAssignment_12_1 ) )
            // InternalAspect.g:822:2: ( rule__Aspect__PointcutsAssignment_12_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getPointcutsAssignment_12_1()); 
            }
            // InternalAspect.g:823:2: ( rule__Aspect__PointcutsAssignment_12_1 )
            // InternalAspect.g:823:3: rule__Aspect__PointcutsAssignment_12_1
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
    // InternalAspect.g:832:1: rule__Aspect__Group_18__0 : rule__Aspect__Group_18__0__Impl rule__Aspect__Group_18__1 ;
    public final void rule__Aspect__Group_18__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:836:1: ( rule__Aspect__Group_18__0__Impl rule__Aspect__Group_18__1 )
            // InternalAspect.g:837:2: rule__Aspect__Group_18__0__Impl rule__Aspect__Group_18__1
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
    // InternalAspect.g:844:1: rule__Aspect__Group_18__0__Impl : ( ',' ) ;
    public final void rule__Aspect__Group_18__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:848:1: ( ( ',' ) )
            // InternalAspect.g:849:1: ( ',' )
            {
            // InternalAspect.g:849:1: ( ',' )
            // InternalAspect.g:850:2: ','
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
    // InternalAspect.g:859:1: rule__Aspect__Group_18__1 : rule__Aspect__Group_18__1__Impl ;
    public final void rule__Aspect__Group_18__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:863:1: ( rule__Aspect__Group_18__1__Impl )
            // InternalAspect.g:864:2: rule__Aspect__Group_18__1__Impl
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
    // InternalAspect.g:870:1: rule__Aspect__Group_18__1__Impl : ( ( rule__Aspect__CompositionsAssignment_18_1 ) ) ;
    public final void rule__Aspect__Group_18__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:874:1: ( ( ( rule__Aspect__CompositionsAssignment_18_1 ) ) )
            // InternalAspect.g:875:1: ( ( rule__Aspect__CompositionsAssignment_18_1 ) )
            {
            // InternalAspect.g:875:1: ( ( rule__Aspect__CompositionsAssignment_18_1 ) )
            // InternalAspect.g:876:2: ( rule__Aspect__CompositionsAssignment_18_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getCompositionsAssignment_18_1()); 
            }
            // InternalAspect.g:877:2: ( rule__Aspect__CompositionsAssignment_18_1 )
            // InternalAspect.g:877:3: rule__Aspect__CompositionsAssignment_18_1
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
    // InternalAspect.g:886:1: rule__Pointcut__Group__0 : rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1 ;
    public final void rule__Pointcut__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:890:1: ( rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1 )
            // InternalAspect.g:891:2: rule__Pointcut__Group__0__Impl rule__Pointcut__Group__1
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
    // InternalAspect.g:898:1: rule__Pointcut__Group__0__Impl : ( 'pointcut' ) ;
    public final void rule__Pointcut__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:902:1: ( ( 'pointcut' ) )
            // InternalAspect.g:903:1: ( 'pointcut' )
            {
            // InternalAspect.g:903:1: ( 'pointcut' )
            // InternalAspect.g:904:2: 'pointcut'
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
    // InternalAspect.g:913:1: rule__Pointcut__Group__1 : rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2 ;
    public final void rule__Pointcut__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:917:1: ( rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2 )
            // InternalAspect.g:918:2: rule__Pointcut__Group__1__Impl rule__Pointcut__Group__2
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
    // InternalAspect.g:925:1: rule__Pointcut__Group__1__Impl : ( ( rule__Pointcut__NameAssignment_1 ) ) ;
    public final void rule__Pointcut__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:929:1: ( ( ( rule__Pointcut__NameAssignment_1 ) ) )
            // InternalAspect.g:930:1: ( ( rule__Pointcut__NameAssignment_1 ) )
            {
            // InternalAspect.g:930:1: ( ( rule__Pointcut__NameAssignment_1 ) )
            // InternalAspect.g:931:2: ( rule__Pointcut__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:932:2: ( rule__Pointcut__NameAssignment_1 )
            // InternalAspect.g:932:3: rule__Pointcut__NameAssignment_1
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
    // InternalAspect.g:940:1: rule__Pointcut__Group__2 : rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3 ;
    public final void rule__Pointcut__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:944:1: ( rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3 )
            // InternalAspect.g:945:2: rule__Pointcut__Group__2__Impl rule__Pointcut__Group__3
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
    // InternalAspect.g:952:1: rule__Pointcut__Group__2__Impl : ( '{' ) ;
    public final void rule__Pointcut__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:956:1: ( ( '{' ) )
            // InternalAspect.g:957:1: ( '{' )
            {
            // InternalAspect.g:957:1: ( '{' )
            // InternalAspect.g:958:2: '{'
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
    // InternalAspect.g:967:1: rule__Pointcut__Group__3 : rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4 ;
    public final void rule__Pointcut__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:971:1: ( rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4 )
            // InternalAspect.g:972:2: rule__Pointcut__Group__3__Impl rule__Pointcut__Group__4
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
    // InternalAspect.g:979:1: rule__Pointcut__Group__3__Impl : ( 'pattern' ) ;
    public final void rule__Pointcut__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:983:1: ( ( 'pattern' ) )
            // InternalAspect.g:984:1: ( 'pattern' )
            {
            // InternalAspect.g:984:1: ( 'pattern' )
            // InternalAspect.g:985:2: 'pattern'
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
    // InternalAspect.g:994:1: rule__Pointcut__Group__4 : rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5 ;
    public final void rule__Pointcut__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:998:1: ( rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5 )
            // InternalAspect.g:999:2: rule__Pointcut__Group__4__Impl rule__Pointcut__Group__5
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
    // InternalAspect.g:1006:1: rule__Pointcut__Group__4__Impl : ( ( rule__Pointcut__PatternAssignment_4 ) ) ;
    public final void rule__Pointcut__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1010:1: ( ( ( rule__Pointcut__PatternAssignment_4 ) ) )
            // InternalAspect.g:1011:1: ( ( rule__Pointcut__PatternAssignment_4 ) )
            {
            // InternalAspect.g:1011:1: ( ( rule__Pointcut__PatternAssignment_4 ) )
            // InternalAspect.g:1012:2: ( rule__Pointcut__PatternAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternAssignment_4()); 
            }
            // InternalAspect.g:1013:2: ( rule__Pointcut__PatternAssignment_4 )
            // InternalAspect.g:1013:3: rule__Pointcut__PatternAssignment_4
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
    // InternalAspect.g:1021:1: rule__Pointcut__Group__5 : rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6 ;
    public final void rule__Pointcut__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1025:1: ( rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6 )
            // InternalAspect.g:1026:2: rule__Pointcut__Group__5__Impl rule__Pointcut__Group__6
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
    // InternalAspect.g:1033:1: rule__Pointcut__Group__5__Impl : ( ( rule__Pointcut__Group_5__0 )? ) ;
    public final void rule__Pointcut__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1037:1: ( ( ( rule__Pointcut__Group_5__0 )? ) )
            // InternalAspect.g:1038:1: ( ( rule__Pointcut__Group_5__0 )? )
            {
            // InternalAspect.g:1038:1: ( ( rule__Pointcut__Group_5__0 )? )
            // InternalAspect.g:1039:2: ( rule__Pointcut__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getGroup_5()); 
            }
            // InternalAspect.g:1040:2: ( rule__Pointcut__Group_5__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalAspect.g:1040:3: rule__Pointcut__Group_5__0
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
    // InternalAspect.g:1048:1: rule__Pointcut__Group__6 : rule__Pointcut__Group__6__Impl ;
    public final void rule__Pointcut__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1052:1: ( rule__Pointcut__Group__6__Impl )
            // InternalAspect.g:1053:2: rule__Pointcut__Group__6__Impl
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
    // InternalAspect.g:1059:1: rule__Pointcut__Group__6__Impl : ( '}' ) ;
    public final void rule__Pointcut__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1063:1: ( ( '}' ) )
            // InternalAspect.g:1064:1: ( '}' )
            {
            // InternalAspect.g:1064:1: ( '}' )
            // InternalAspect.g:1065:2: '}'
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
    // InternalAspect.g:1075:1: rule__Pointcut__Group_5__0 : rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1 ;
    public final void rule__Pointcut__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1079:1: ( rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1 )
            // InternalAspect.g:1080:2: rule__Pointcut__Group_5__0__Impl rule__Pointcut__Group_5__1
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
    // InternalAspect.g:1087:1: rule__Pointcut__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Pointcut__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1091:1: ( ( ',' ) )
            // InternalAspect.g:1092:1: ( ',' )
            {
            // InternalAspect.g:1092:1: ( ',' )
            // InternalAspect.g:1093:2: ','
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
    // InternalAspect.g:1102:1: rule__Pointcut__Group_5__1 : rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2 ;
    public final void rule__Pointcut__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1106:1: ( rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2 )
            // InternalAspect.g:1107:2: rule__Pointcut__Group_5__1__Impl rule__Pointcut__Group_5__2
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
    // InternalAspect.g:1114:1: rule__Pointcut__Group_5__1__Impl : ( 'role' ) ;
    public final void rule__Pointcut__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1118:1: ( ( 'role' ) )
            // InternalAspect.g:1119:1: ( 'role' )
            {
            // InternalAspect.g:1119:1: ( 'role' )
            // InternalAspect.g:1120:2: 'role'
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
    // InternalAspect.g:1129:1: rule__Pointcut__Group_5__2 : rule__Pointcut__Group_5__2__Impl ;
    public final void rule__Pointcut__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1133:1: ( rule__Pointcut__Group_5__2__Impl )
            // InternalAspect.g:1134:2: rule__Pointcut__Group_5__2__Impl
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
    // InternalAspect.g:1140:1: rule__Pointcut__Group_5__2__Impl : ( ( rule__Pointcut__RoleAssignment_5_2 ) ) ;
    public final void rule__Pointcut__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1144:1: ( ( ( rule__Pointcut__RoleAssignment_5_2 ) ) )
            // InternalAspect.g:1145:1: ( ( rule__Pointcut__RoleAssignment_5_2 ) )
            {
            // InternalAspect.g:1145:1: ( ( rule__Pointcut__RoleAssignment_5_2 ) )
            // InternalAspect.g:1146:2: ( rule__Pointcut__RoleAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleAssignment_5_2()); 
            }
            // InternalAspect.g:1147:2: ( rule__Pointcut__RoleAssignment_5_2 )
            // InternalAspect.g:1147:3: rule__Pointcut__RoleAssignment_5_2
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
    // InternalAspect.g:1156:1: rule__Composition__Group__0 : rule__Composition__Group__0__Impl rule__Composition__Group__1 ;
    public final void rule__Composition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1160:1: ( rule__Composition__Group__0__Impl rule__Composition__Group__1 )
            // InternalAspect.g:1161:2: rule__Composition__Group__0__Impl rule__Composition__Group__1
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
    // InternalAspect.g:1168:1: rule__Composition__Group__0__Impl : ( 'composition' ) ;
    public final void rule__Composition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1172:1: ( ( 'composition' ) )
            // InternalAspect.g:1173:1: ( 'composition' )
            {
            // InternalAspect.g:1173:1: ( 'composition' )
            // InternalAspect.g:1174:2: 'composition'
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
    // InternalAspect.g:1183:1: rule__Composition__Group__1 : rule__Composition__Group__1__Impl rule__Composition__Group__2 ;
    public final void rule__Composition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1187:1: ( rule__Composition__Group__1__Impl rule__Composition__Group__2 )
            // InternalAspect.g:1188:2: rule__Composition__Group__1__Impl rule__Composition__Group__2
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
    // InternalAspect.g:1195:1: rule__Composition__Group__1__Impl : ( ( rule__Composition__NameAssignment_1 ) ) ;
    public final void rule__Composition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1199:1: ( ( ( rule__Composition__NameAssignment_1 ) ) )
            // InternalAspect.g:1200:1: ( ( rule__Composition__NameAssignment_1 ) )
            {
            // InternalAspect.g:1200:1: ( ( rule__Composition__NameAssignment_1 ) )
            // InternalAspect.g:1201:2: ( rule__Composition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getNameAssignment_1()); 
            }
            // InternalAspect.g:1202:2: ( rule__Composition__NameAssignment_1 )
            // InternalAspect.g:1202:3: rule__Composition__NameAssignment_1
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
    // InternalAspect.g:1210:1: rule__Composition__Group__2 : rule__Composition__Group__2__Impl rule__Composition__Group__3 ;
    public final void rule__Composition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1214:1: ( rule__Composition__Group__2__Impl rule__Composition__Group__3 )
            // InternalAspect.g:1215:2: rule__Composition__Group__2__Impl rule__Composition__Group__3
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
    // InternalAspect.g:1222:1: rule__Composition__Group__2__Impl : ( '{' ) ;
    public final void rule__Composition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1226:1: ( ( '{' ) )
            // InternalAspect.g:1227:1: ( '{' )
            {
            // InternalAspect.g:1227:1: ( '{' )
            // InternalAspect.g:1228:2: '{'
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
    // InternalAspect.g:1237:1: rule__Composition__Group__3 : rule__Composition__Group__3__Impl rule__Composition__Group__4 ;
    public final void rule__Composition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1241:1: ( rule__Composition__Group__3__Impl rule__Composition__Group__4 )
            // InternalAspect.g:1242:2: rule__Composition__Group__3__Impl rule__Composition__Group__4
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
    // InternalAspect.g:1249:1: rule__Composition__Group__3__Impl : ( 'feature_enabled' ) ;
    public final void rule__Composition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1253:1: ( ( 'feature_enabled' ) )
            // InternalAspect.g:1254:1: ( 'feature_enabled' )
            {
            // InternalAspect.g:1254:1: ( 'feature_enabled' )
            // InternalAspect.g:1255:2: 'feature_enabled'
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
    // InternalAspect.g:1264:1: rule__Composition__Group__4 : rule__Composition__Group__4__Impl rule__Composition__Group__5 ;
    public final void rule__Composition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1268:1: ( rule__Composition__Group__4__Impl rule__Composition__Group__5 )
            // InternalAspect.g:1269:2: rule__Composition__Group__4__Impl rule__Composition__Group__5
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
    // InternalAspect.g:1276:1: rule__Composition__Group__4__Impl : ( ( rule__Composition__Feature_enabledAssignment_4 ) ) ;
    public final void rule__Composition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1280:1: ( ( ( rule__Composition__Feature_enabledAssignment_4 ) ) )
            // InternalAspect.g:1281:1: ( ( rule__Composition__Feature_enabledAssignment_4 ) )
            {
            // InternalAspect.g:1281:1: ( ( rule__Composition__Feature_enabledAssignment_4 ) )
            // InternalAspect.g:1282:2: ( rule__Composition__Feature_enabledAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getFeature_enabledAssignment_4()); 
            }
            // InternalAspect.g:1283:2: ( rule__Composition__Feature_enabledAssignment_4 )
            // InternalAspect.g:1283:3: rule__Composition__Feature_enabledAssignment_4
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
    // InternalAspect.g:1291:1: rule__Composition__Group__5 : rule__Composition__Group__5__Impl rule__Composition__Group__6 ;
    public final void rule__Composition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1295:1: ( rule__Composition__Group__5__Impl rule__Composition__Group__6 )
            // InternalAspect.g:1296:2: rule__Composition__Group__5__Impl rule__Composition__Group__6
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
    // InternalAspect.g:1303:1: rule__Composition__Group__5__Impl : ( ( rule__Composition__Group_5__0 )? ) ;
    public final void rule__Composition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1307:1: ( ( ( rule__Composition__Group_5__0 )? ) )
            // InternalAspect.g:1308:1: ( ( rule__Composition__Group_5__0 )? )
            {
            // InternalAspect.g:1308:1: ( ( rule__Composition__Group_5__0 )? )
            // InternalAspect.g:1309:2: ( rule__Composition__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup_5()); 
            }
            // InternalAspect.g:1310:2: ( rule__Composition__Group_5__0 )?
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
                    // InternalAspect.g:1310:3: rule__Composition__Group_5__0
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
    // InternalAspect.g:1318:1: rule__Composition__Group__6 : rule__Composition__Group__6__Impl rule__Composition__Group__7 ;
    public final void rule__Composition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1322:1: ( rule__Composition__Group__6__Impl rule__Composition__Group__7 )
            // InternalAspect.g:1323:2: rule__Composition__Group__6__Impl rule__Composition__Group__7
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
    // InternalAspect.g:1330:1: rule__Composition__Group__6__Impl : ( ( rule__Composition__Group_6__0 )? ) ;
    public final void rule__Composition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1334:1: ( ( ( rule__Composition__Group_6__0 )? ) )
            // InternalAspect.g:1335:1: ( ( rule__Composition__Group_6__0 )? )
            {
            // InternalAspect.g:1335:1: ( ( rule__Composition__Group_6__0 )? )
            // InternalAspect.g:1336:2: ( rule__Composition__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getGroup_6()); 
            }
            // InternalAspect.g:1337:2: ( rule__Composition__Group_6__0 )?
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
                    // InternalAspect.g:1337:3: rule__Composition__Group_6__0
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
    // InternalAspect.g:1345:1: rule__Composition__Group__7 : rule__Composition__Group__7__Impl rule__Composition__Group__8 ;
    public final void rule__Composition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1349:1: ( rule__Composition__Group__7__Impl rule__Composition__Group__8 )
            // InternalAspect.g:1350:2: rule__Composition__Group__7__Impl rule__Composition__Group__8
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
    // InternalAspect.g:1357:1: rule__Composition__Group__7__Impl : ( ',' ) ;
    public final void rule__Composition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1361:1: ( ( ',' ) )
            // InternalAspect.g:1362:1: ( ',' )
            {
            // InternalAspect.g:1362:1: ( ',' )
            // InternalAspect.g:1363:2: ','
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
    // InternalAspect.g:1372:1: rule__Composition__Group__8 : rule__Composition__Group__8__Impl rule__Composition__Group__9 ;
    public final void rule__Composition__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1376:1: ( rule__Composition__Group__8__Impl rule__Composition__Group__9 )
            // InternalAspect.g:1377:2: rule__Composition__Group__8__Impl rule__Composition__Group__9
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
    // InternalAspect.g:1384:1: rule__Composition__Group__8__Impl : ( 'action' ) ;
    public final void rule__Composition__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1388:1: ( ( 'action' ) )
            // InternalAspect.g:1389:1: ( 'action' )
            {
            // InternalAspect.g:1389:1: ( 'action' )
            // InternalAspect.g:1390:2: 'action'
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
    // InternalAspect.g:1399:1: rule__Composition__Group__9 : rule__Composition__Group__9__Impl rule__Composition__Group__10 ;
    public final void rule__Composition__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1403:1: ( rule__Composition__Group__9__Impl rule__Composition__Group__10 )
            // InternalAspect.g:1404:2: rule__Composition__Group__9__Impl rule__Composition__Group__10
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
    // InternalAspect.g:1411:1: rule__Composition__Group__9__Impl : ( ( rule__Composition__ActionAssignment_9 ) ) ;
    public final void rule__Composition__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1415:1: ( ( ( rule__Composition__ActionAssignment_9 ) ) )
            // InternalAspect.g:1416:1: ( ( rule__Composition__ActionAssignment_9 ) )
            {
            // InternalAspect.g:1416:1: ( ( rule__Composition__ActionAssignment_9 ) )
            // InternalAspect.g:1417:2: ( rule__Composition__ActionAssignment_9 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getActionAssignment_9()); 
            }
            // InternalAspect.g:1418:2: ( rule__Composition__ActionAssignment_9 )
            // InternalAspect.g:1418:3: rule__Composition__ActionAssignment_9
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
    // InternalAspect.g:1426:1: rule__Composition__Group__10 : rule__Composition__Group__10__Impl ;
    public final void rule__Composition__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1430:1: ( rule__Composition__Group__10__Impl )
            // InternalAspect.g:1431:2: rule__Composition__Group__10__Impl
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
    // InternalAspect.g:1437:1: rule__Composition__Group__10__Impl : ( '}' ) ;
    public final void rule__Composition__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1441:1: ( ( '}' ) )
            // InternalAspect.g:1442:1: ( '}' )
            {
            // InternalAspect.g:1442:1: ( '}' )
            // InternalAspect.g:1443:2: '}'
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
    // InternalAspect.g:1453:1: rule__Composition__Group_5__0 : rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1 ;
    public final void rule__Composition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1457:1: ( rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1 )
            // InternalAspect.g:1458:2: rule__Composition__Group_5__0__Impl rule__Composition__Group_5__1
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
    // InternalAspect.g:1465:1: rule__Composition__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Composition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1469:1: ( ( ',' ) )
            // InternalAspect.g:1470:1: ( ',' )
            {
            // InternalAspect.g:1470:1: ( ',' )
            // InternalAspect.g:1471:2: ','
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
    // InternalAspect.g:1480:1: rule__Composition__Group_5__1 : rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2 ;
    public final void rule__Composition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1484:1: ( rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2 )
            // InternalAspect.g:1485:2: rule__Composition__Group_5__1__Impl rule__Composition__Group_5__2
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
    // InternalAspect.g:1492:1: rule__Composition__Group_5__1__Impl : ( 'jointpointRole' ) ;
    public final void rule__Composition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1496:1: ( ( 'jointpointRole' ) )
            // InternalAspect.g:1497:1: ( 'jointpointRole' )
            {
            // InternalAspect.g:1497:1: ( 'jointpointRole' )
            // InternalAspect.g:1498:2: 'jointpointRole'
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
    // InternalAspect.g:1507:1: rule__Composition__Group_5__2 : rule__Composition__Group_5__2__Impl ;
    public final void rule__Composition__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1511:1: ( rule__Composition__Group_5__2__Impl )
            // InternalAspect.g:1512:2: rule__Composition__Group_5__2__Impl
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
    // InternalAspect.g:1518:1: rule__Composition__Group_5__2__Impl : ( ( rule__Composition__JointpointRoleAssignment_5_2 ) ) ;
    public final void rule__Composition__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1522:1: ( ( ( rule__Composition__JointpointRoleAssignment_5_2 ) ) )
            // InternalAspect.g:1523:1: ( ( rule__Composition__JointpointRoleAssignment_5_2 ) )
            {
            // InternalAspect.g:1523:1: ( ( rule__Composition__JointpointRoleAssignment_5_2 ) )
            // InternalAspect.g:1524:2: ( rule__Composition__JointpointRoleAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleAssignment_5_2()); 
            }
            // InternalAspect.g:1525:2: ( rule__Composition__JointpointRoleAssignment_5_2 )
            // InternalAspect.g:1525:3: rule__Composition__JointpointRoleAssignment_5_2
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
    // InternalAspect.g:1534:1: rule__Composition__Group_6__0 : rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1 ;
    public final void rule__Composition__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1538:1: ( rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1 )
            // InternalAspect.g:1539:2: rule__Composition__Group_6__0__Impl rule__Composition__Group_6__1
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
    // InternalAspect.g:1546:1: rule__Composition__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Composition__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1550:1: ( ( ',' ) )
            // InternalAspect.g:1551:1: ( ',' )
            {
            // InternalAspect.g:1551:1: ( ',' )
            // InternalAspect.g:1552:2: ','
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
    // InternalAspect.g:1561:1: rule__Composition__Group_6__1 : rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2 ;
    public final void rule__Composition__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1565:1: ( rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2 )
            // InternalAspect.g:1566:2: rule__Composition__Group_6__1__Impl rule__Composition__Group_6__2
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
    // InternalAspect.g:1573:1: rule__Composition__Group_6__1__Impl : ( 'adviceRole' ) ;
    public final void rule__Composition__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1577:1: ( ( 'adviceRole' ) )
            // InternalAspect.g:1578:1: ( 'adviceRole' )
            {
            // InternalAspect.g:1578:1: ( 'adviceRole' )
            // InternalAspect.g:1579:2: 'adviceRole'
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
    // InternalAspect.g:1588:1: rule__Composition__Group_6__2 : rule__Composition__Group_6__2__Impl ;
    public final void rule__Composition__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1592:1: ( rule__Composition__Group_6__2__Impl )
            // InternalAspect.g:1593:2: rule__Composition__Group_6__2__Impl
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
    // InternalAspect.g:1599:1: rule__Composition__Group_6__2__Impl : ( ( rule__Composition__AdviceAssignment_6_2 ) ) ;
    public final void rule__Composition__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1603:1: ( ( ( rule__Composition__AdviceAssignment_6_2 ) ) )
            // InternalAspect.g:1604:1: ( ( rule__Composition__AdviceAssignment_6_2 ) )
            {
            // InternalAspect.g:1604:1: ( ( rule__Composition__AdviceAssignment_6_2 ) )
            // InternalAspect.g:1605:2: ( rule__Composition__AdviceAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceAssignment_6_2()); 
            }
            // InternalAspect.g:1606:2: ( rule__Composition__AdviceAssignment_6_2 )
            // InternalAspect.g:1606:3: rule__Composition__AdviceAssignment_6_2
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
    // InternalAspect.g:1615:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1619:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAspect.g:1620:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalAspect.g:1627:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1631:1: ( ( RULE_ID ) )
            // InternalAspect.g:1632:1: ( RULE_ID )
            {
            // InternalAspect.g:1632:1: ( RULE_ID )
            // InternalAspect.g:1633:2: RULE_ID
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
    // InternalAspect.g:1642:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1646:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAspect.g:1647:2: rule__QualifiedName__Group__1__Impl
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
    // InternalAspect.g:1653:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1657:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAspect.g:1658:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAspect.g:1658:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAspect.g:1659:2: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // InternalAspect.g:1660:2: ( rule__QualifiedName__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAspect.g:1660:3: rule__QualifiedName__Group_1__0
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
    // InternalAspect.g:1669:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1673:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAspect.g:1674:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalAspect.g:1681:1: rule__QualifiedName__Group_1__0__Impl : ( ( '.' ) ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1685:1: ( ( ( '.' ) ) )
            // InternalAspect.g:1686:1: ( ( '.' ) )
            {
            // InternalAspect.g:1686:1: ( ( '.' ) )
            // InternalAspect.g:1687:2: ( '.' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            // InternalAspect.g:1688:2: ( '.' )
            // InternalAspect.g:1688:3: '.'
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
    // InternalAspect.g:1696:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1700:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAspect.g:1701:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalAspect.g:1707:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1711:1: ( ( RULE_ID ) )
            // InternalAspect.g:1712:1: ( RULE_ID )
            {
            // InternalAspect.g:1712:1: ( RULE_ID )
            // InternalAspect.g:1713:2: RULE_ID
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
    // InternalAspect.g:1723:1: rule__Aspect__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Aspect__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1727:1: ( ( RULE_ID ) )
            // InternalAspect.g:1728:2: ( RULE_ID )
            {
            // InternalAspect.g:1728:2: ( RULE_ID )
            // InternalAspect.g:1729:3: RULE_ID
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
    // InternalAspect.g:1738:1: rule__Aspect__FeatureAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Aspect__FeatureAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1742:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:1743:2: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:1743:2: ( ( ruleQualifiedName ) )
            // InternalAspect.g:1744:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); 
            }
            // InternalAspect.g:1745:3: ( ruleQualifiedName )
            // InternalAspect.g:1746:4: ruleQualifiedName
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
    // InternalAspect.g:1757:1: rule__Aspect__AdviceAssignment_7 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Aspect__AdviceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1761:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:1762:2: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:1762:2: ( ( ruleQualifiedName ) )
            // InternalAspect.g:1763:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAspectAccess().getAdviceModelCrossReference_7_0()); 
            }
            // InternalAspect.g:1764:3: ( ruleQualifiedName )
            // InternalAspect.g:1765:4: ruleQualifiedName
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
    // InternalAspect.g:1776:1: rule__Aspect__PointcutsAssignment_11 : ( rulePointcut ) ;
    public final void rule__Aspect__PointcutsAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1780:1: ( ( rulePointcut ) )
            // InternalAspect.g:1781:2: ( rulePointcut )
            {
            // InternalAspect.g:1781:2: ( rulePointcut )
            // InternalAspect.g:1782:3: rulePointcut
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
    // InternalAspect.g:1791:1: rule__Aspect__PointcutsAssignment_12_1 : ( rulePointcut ) ;
    public final void rule__Aspect__PointcutsAssignment_12_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1795:1: ( ( rulePointcut ) )
            // InternalAspect.g:1796:2: ( rulePointcut )
            {
            // InternalAspect.g:1796:2: ( rulePointcut )
            // InternalAspect.g:1797:3: rulePointcut
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
    // InternalAspect.g:1806:1: rule__Aspect__CompositionsAssignment_17 : ( ruleComposition ) ;
    public final void rule__Aspect__CompositionsAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1810:1: ( ( ruleComposition ) )
            // InternalAspect.g:1811:2: ( ruleComposition )
            {
            // InternalAspect.g:1811:2: ( ruleComposition )
            // InternalAspect.g:1812:3: ruleComposition
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
    // InternalAspect.g:1821:1: rule__Aspect__CompositionsAssignment_18_1 : ( ruleComposition ) ;
    public final void rule__Aspect__CompositionsAssignment_18_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1825:1: ( ( ruleComposition ) )
            // InternalAspect.g:1826:2: ( ruleComposition )
            {
            // InternalAspect.g:1826:2: ( ruleComposition )
            // InternalAspect.g:1827:3: ruleComposition
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
    // InternalAspect.g:1836:1: rule__Pointcut__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Pointcut__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1840:1: ( ( RULE_ID ) )
            // InternalAspect.g:1841:2: ( RULE_ID )
            {
            // InternalAspect.g:1841:2: ( RULE_ID )
            // InternalAspect.g:1842:3: RULE_ID
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
    // InternalAspect.g:1851:1: rule__Pointcut__PatternAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Pointcut__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1855:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:1856:2: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:1856:2: ( ( ruleQualifiedName ) )
            // InternalAspect.g:1857:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); 
            }
            // InternalAspect.g:1858:3: ( ruleQualifiedName )
            // InternalAspect.g:1859:4: ruleQualifiedName
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
    // InternalAspect.g:1870:1: rule__Pointcut__RoleAssignment_5_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Pointcut__RoleAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1874:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:1875:2: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:1875:2: ( ( ruleQualifiedName ) )
            // InternalAspect.g:1876:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); 
            }
            // InternalAspect.g:1877:3: ( ruleQualifiedName )
            // InternalAspect.g:1878:4: ruleQualifiedName
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
    // InternalAspect.g:1889:1: rule__Composition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Composition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1893:1: ( ( RULE_ID ) )
            // InternalAspect.g:1894:2: ( RULE_ID )
            {
            // InternalAspect.g:1894:2: ( RULE_ID )
            // InternalAspect.g:1895:3: RULE_ID
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
    // InternalAspect.g:1904:1: rule__Composition__Feature_enabledAssignment_4 : ( RULE_EBOOLEAN ) ;
    public final void rule__Composition__Feature_enabledAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1908:1: ( ( RULE_EBOOLEAN ) )
            // InternalAspect.g:1909:2: ( RULE_EBOOLEAN )
            {
            // InternalAspect.g:1909:2: ( RULE_EBOOLEAN )
            // InternalAspect.g:1910:3: RULE_EBOOLEAN
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
    // InternalAspect.g:1919:1: rule__Composition__JointpointRoleAssignment_5_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Composition__JointpointRoleAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1923:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:1924:2: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:1924:2: ( ( ruleQualifiedName ) )
            // InternalAspect.g:1925:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); 
            }
            // InternalAspect.g:1926:3: ( ruleQualifiedName )
            // InternalAspect.g:1927:4: ruleQualifiedName
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
    // InternalAspect.g:1938:1: rule__Composition__AdviceAssignment_6_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Composition__AdviceAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1942:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAspect.g:1943:2: ( ( ruleQualifiedName ) )
            {
            // InternalAspect.g:1943:2: ( ( ruleQualifiedName ) )
            // InternalAspect.g:1944:3: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); 
            }
            // InternalAspect.g:1945:3: ( ruleQualifiedName )
            // InternalAspect.g:1946:4: ruleQualifiedName
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
    // InternalAspect.g:1957:1: rule__Composition__ActionAssignment_9 : ( ruleAction ) ;
    public final void rule__Composition__ActionAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAspect.g:1961:1: ( ( ruleAction ) )
            // InternalAspect.g:1962:2: ( ruleAction )
            {
            // InternalAspect.g:1962:2: ( ruleAction )
            // InternalAspect.g:1963:3: ruleAction
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