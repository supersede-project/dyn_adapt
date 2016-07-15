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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAspectParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_EBOOLEAN", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'aspect'", "'{'", "'feature'", "','", "'advice'", "'pointcuts'", "'}'", "'compositions'", "'pointcut'", "'pattern'", "'role'", "'composition'", "'feature_enabled'", "'jointpointRole'", "'adviceRole'", "'action'", "'add'", "'delete'", "'replace'", "'associate'", "'.'"
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



    // $ANTLR start "entryRuleAspect"
    // InternalAspect.g:67:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalAspect.g:68:2: (iv_ruleAspect= ruleAspect EOF )
            // InternalAspect.g:69:2: iv_ruleAspect= ruleAspect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAspectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAspect=ruleAspect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAspect; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAspect"


    // $ANTLR start "ruleAspect"
    // InternalAspect.g:76:1: ruleAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= 'advice' ( ( ruleQualifiedName ) ) otherlv_8= ',' otherlv_9= 'pointcuts' otherlv_10= '{' ( (lv_pointcuts_11_0= rulePointcut ) ) (otherlv_12= ',' ( (lv_pointcuts_13_0= rulePointcut ) ) )* otherlv_14= '}' otherlv_15= ',' otherlv_16= 'compositions' otherlv_17= '{' ( (lv_compositions_18_0= ruleComposition ) ) (otherlv_19= ',' ( (lv_compositions_20_0= ruleComposition ) ) )* otherlv_21= '}' otherlv_22= '}' ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        EObject lv_pointcuts_11_0 = null;

        EObject lv_pointcuts_13_0 = null;

        EObject lv_compositions_18_0 = null;

        EObject lv_compositions_20_0 = null;


         enterRule(); 
            
        try {
            // InternalAspect.g:79:28: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= 'advice' ( ( ruleQualifiedName ) ) otherlv_8= ',' otherlv_9= 'pointcuts' otherlv_10= '{' ( (lv_pointcuts_11_0= rulePointcut ) ) (otherlv_12= ',' ( (lv_pointcuts_13_0= rulePointcut ) ) )* otherlv_14= '}' otherlv_15= ',' otherlv_16= 'compositions' otherlv_17= '{' ( (lv_compositions_18_0= ruleComposition ) ) (otherlv_19= ',' ( (lv_compositions_20_0= ruleComposition ) ) )* otherlv_21= '}' otherlv_22= '}' ) )
            // InternalAspect.g:80:1: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= 'advice' ( ( ruleQualifiedName ) ) otherlv_8= ',' otherlv_9= 'pointcuts' otherlv_10= '{' ( (lv_pointcuts_11_0= rulePointcut ) ) (otherlv_12= ',' ( (lv_pointcuts_13_0= rulePointcut ) ) )* otherlv_14= '}' otherlv_15= ',' otherlv_16= 'compositions' otherlv_17= '{' ( (lv_compositions_18_0= ruleComposition ) ) (otherlv_19= ',' ( (lv_compositions_20_0= ruleComposition ) ) )* otherlv_21= '}' otherlv_22= '}' )
            {
            // InternalAspect.g:80:1: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= 'advice' ( ( ruleQualifiedName ) ) otherlv_8= ',' otherlv_9= 'pointcuts' otherlv_10= '{' ( (lv_pointcuts_11_0= rulePointcut ) ) (otherlv_12= ',' ( (lv_pointcuts_13_0= rulePointcut ) ) )* otherlv_14= '}' otherlv_15= ',' otherlv_16= 'compositions' otherlv_17= '{' ( (lv_compositions_18_0= ruleComposition ) ) (otherlv_19= ',' ( (lv_compositions_20_0= ruleComposition ) ) )* otherlv_21= '}' otherlv_22= '}' )
            // InternalAspect.g:80:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= 'advice' ( ( ruleQualifiedName ) ) otherlv_8= ',' otherlv_9= 'pointcuts' otherlv_10= '{' ( (lv_pointcuts_11_0= rulePointcut ) ) (otherlv_12= ',' ( (lv_pointcuts_13_0= rulePointcut ) ) )* otherlv_14= '}' otherlv_15= ',' otherlv_16= 'compositions' otherlv_17= '{' ( (lv_compositions_18_0= ruleComposition ) ) (otherlv_19= ',' ( (lv_compositions_20_0= ruleComposition ) ) )* otherlv_21= '}' otherlv_22= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAspectAccess().getAspectKeyword_0());
                  
            }
            // InternalAspect.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalAspect.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // InternalAspect.g:85:1: (lv_name_1_0= RULE_ID )
            // InternalAspect.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAspectRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,14,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAspectAccess().getFeatureKeyword_3());
                  
            }
            // InternalAspect.g:110:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:111:1: ( ruleQualifiedName )
            {
            // InternalAspect.g:111:1: ( ruleQualifiedName )
            // InternalAspect.g:112:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAspectRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAspectAccess().getFeatureFeatureCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_6);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAspectAccess().getCommaKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,16,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAspectAccess().getAdviceKeyword_6());
                  
            }
            // InternalAspect.g:133:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:134:1: ( ruleQualifiedName )
            {
            // InternalAspect.g:134:1: ( ruleQualifiedName )
            // InternalAspect.g:135:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAspectRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAspectAccess().getAdviceModelCrossReference_7_0()); 
              	    
            }
            pushFollow(FOLLOW_6);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAspectAccess().getCommaKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAspectAccess().getPointcutsKeyword_9());
                  
            }
            otherlv_10=(Token)match(input,13,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_10());
                  
            }
            // InternalAspect.g:160:1: ( (lv_pointcuts_11_0= rulePointcut ) )
            // InternalAspect.g:161:1: (lv_pointcuts_11_0= rulePointcut )
            {
            // InternalAspect.g:161:1: (lv_pointcuts_11_0= rulePointcut )
            // InternalAspect.g:162:3: lv_pointcuts_11_0= rulePointcut
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_11_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
            lv_pointcuts_11_0=rulePointcut();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAspectRule());
              	        }
                     		add(
                     			current, 
                     			"pointcuts",
                      		lv_pointcuts_11_0, 
                      		"eu.supersede.dynadapt.dsl.Aspect.Pointcut");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalAspect.g:178:2: (otherlv_12= ',' ( (lv_pointcuts_13_0= rulePointcut ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalAspect.g:178:4: otherlv_12= ',' ( (lv_pointcuts_13_0= rulePointcut ) )
            	    {
            	    otherlv_12=(Token)match(input,15,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_12, grammarAccess.getAspectAccess().getCommaKeyword_12_0());
            	          
            	    }
            	    // InternalAspect.g:182:1: ( (lv_pointcuts_13_0= rulePointcut ) )
            	    // InternalAspect.g:183:1: (lv_pointcuts_13_0= rulePointcut )
            	    {
            	    // InternalAspect.g:183:1: (lv_pointcuts_13_0= rulePointcut )
            	    // InternalAspect.g:184:3: lv_pointcuts_13_0= rulePointcut
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAspectAccess().getPointcutsPointcutParserRuleCall_12_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_pointcuts_13_0=rulePointcut();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAspectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"pointcuts",
            	              		lv_pointcuts_13_0, 
            	              		"eu.supersede.dynadapt.dsl.Aspect.Pointcut");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_14=(Token)match(input,18,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_13());
                  
            }
            otherlv_15=(Token)match(input,15,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getAspectAccess().getCommaKeyword_14());
                  
            }
            otherlv_16=(Token)match(input,19,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getAspectAccess().getCompositionsKeyword_15());
                  
            }
            otherlv_17=(Token)match(input,13,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_17, grammarAccess.getAspectAccess().getLeftCurlyBracketKeyword_16());
                  
            }
            // InternalAspect.g:216:1: ( (lv_compositions_18_0= ruleComposition ) )
            // InternalAspect.g:217:1: (lv_compositions_18_0= ruleComposition )
            {
            // InternalAspect.g:217:1: (lv_compositions_18_0= ruleComposition )
            // InternalAspect.g:218:3: lv_compositions_18_0= ruleComposition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_17_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
            lv_compositions_18_0=ruleComposition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAspectRule());
              	        }
                     		add(
                     			current, 
                     			"compositions",
                      		lv_compositions_18_0, 
                      		"eu.supersede.dynadapt.dsl.Aspect.Composition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalAspect.g:234:2: (otherlv_19= ',' ( (lv_compositions_20_0= ruleComposition ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAspect.g:234:4: otherlv_19= ',' ( (lv_compositions_20_0= ruleComposition ) )
            	    {
            	    otherlv_19=(Token)match(input,15,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_19, grammarAccess.getAspectAccess().getCommaKeyword_18_0());
            	          
            	    }
            	    // InternalAspect.g:238:1: ( (lv_compositions_20_0= ruleComposition ) )
            	    // InternalAspect.g:239:1: (lv_compositions_20_0= ruleComposition )
            	    {
            	    // InternalAspect.g:239:1: (lv_compositions_20_0= ruleComposition )
            	    // InternalAspect.g:240:3: lv_compositions_20_0= ruleComposition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAspectAccess().getCompositionsCompositionParserRuleCall_18_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_compositions_20_0=ruleComposition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAspectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"compositions",
            	              		lv_compositions_20_0, 
            	              		"eu.supersede.dynadapt.dsl.Aspect.Composition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_21=(Token)match(input,18,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_21, grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_19());
                  
            }
            otherlv_22=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_22, grammarAccess.getAspectAccess().getRightCurlyBracketKeyword_20());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAspect"


    // $ANTLR start "entryRulePointcut"
    // InternalAspect.g:272:1: entryRulePointcut returns [EObject current=null] : iv_rulePointcut= rulePointcut EOF ;
    public final EObject entryRulePointcut() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointcut = null;


        try {
            // InternalAspect.g:273:2: (iv_rulePointcut= rulePointcut EOF )
            // InternalAspect.g:274:2: iv_rulePointcut= rulePointcut EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPointcutRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePointcut=rulePointcut();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePointcut; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointcut"


    // $ANTLR start "rulePointcut"
    // InternalAspect.g:281:1: rulePointcut returns [EObject current=null] : (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pattern' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= 'role' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' ) ;
    public final EObject rulePointcut() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // InternalAspect.g:284:28: ( (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pattern' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= 'role' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' ) )
            // InternalAspect.g:285:1: (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pattern' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= 'role' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' )
            {
            // InternalAspect.g:285:1: (otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pattern' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= 'role' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' )
            // InternalAspect.g:285:3: otherlv_0= 'pointcut' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pattern' ( ( ruleQualifiedName ) ) (otherlv_5= ',' otherlv_6= 'role' ( ( ruleQualifiedName ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPointcutAccess().getPointcutKeyword_0());
                  
            }
            // InternalAspect.g:289:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalAspect.g:290:1: (lv_name_1_0= RULE_ID )
            {
            // InternalAspect.g:290:1: (lv_name_1_0= RULE_ID )
            // InternalAspect.g:291:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getPointcutAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPointcutRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPointcutAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,21,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPointcutAccess().getPatternKeyword_3());
                  
            }
            // InternalAspect.g:315:1: ( ( ruleQualifiedName ) )
            // InternalAspect.g:316:1: ( ruleQualifiedName )
            {
            // InternalAspect.g:316:1: ( ruleQualifiedName )
            // InternalAspect.g:317:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPointcutRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPointcutAccess().getPatternPatternCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalAspect.g:330:2: (otherlv_5= ',' otherlv_6= 'role' ( ( ruleQualifiedName ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalAspect.g:330:4: otherlv_5= ',' otherlv_6= 'role' ( ( ruleQualifiedName ) )
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPointcutAccess().getCommaKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,22,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPointcutAccess().getRoleKeyword_5_1());
                          
                    }
                    // InternalAspect.g:338:1: ( ( ruleQualifiedName ) )
                    // InternalAspect.g:339:1: ( ruleQualifiedName )
                    {
                    // InternalAspect.g:339:1: ( ruleQualifiedName )
                    // InternalAspect.g:340:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPointcutRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPointcutAccess().getRoleStereotypeCrossReference_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getPointcutAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointcut"


    // $ANTLR start "entryRuleComposition"
    // InternalAspect.g:365:1: entryRuleComposition returns [EObject current=null] : iv_ruleComposition= ruleComposition EOF ;
    public final EObject entryRuleComposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComposition = null;


        try {
            // InternalAspect.g:366:2: (iv_ruleComposition= ruleComposition EOF )
            // InternalAspect.g:367:2: iv_ruleComposition= ruleComposition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompositionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComposition=ruleComposition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComposition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComposition"


    // $ANTLR start "ruleComposition"
    // InternalAspect.g:374:1: ruleComposition returns [EObject current=null] : (otherlv_0= 'composition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature_enabled' ( (lv_feature_enabled_4_0= RULE_EBOOLEAN ) ) (otherlv_5= ',' otherlv_6= 'jointpointRole' ( ( ruleQualifiedName ) ) )? (otherlv_8= ',' otherlv_9= 'adviceRole' ( ( ruleQualifiedName ) ) )? otherlv_11= ',' otherlv_12= 'action' ( (lv_action_13_0= ruleAction ) ) otherlv_14= '}' ) ;
    public final EObject ruleComposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_feature_enabled_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_action_13_0 = null;


         enterRule(); 
            
        try {
            // InternalAspect.g:377:28: ( (otherlv_0= 'composition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature_enabled' ( (lv_feature_enabled_4_0= RULE_EBOOLEAN ) ) (otherlv_5= ',' otherlv_6= 'jointpointRole' ( ( ruleQualifiedName ) ) )? (otherlv_8= ',' otherlv_9= 'adviceRole' ( ( ruleQualifiedName ) ) )? otherlv_11= ',' otherlv_12= 'action' ( (lv_action_13_0= ruleAction ) ) otherlv_14= '}' ) )
            // InternalAspect.g:378:1: (otherlv_0= 'composition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature_enabled' ( (lv_feature_enabled_4_0= RULE_EBOOLEAN ) ) (otherlv_5= ',' otherlv_6= 'jointpointRole' ( ( ruleQualifiedName ) ) )? (otherlv_8= ',' otherlv_9= 'adviceRole' ( ( ruleQualifiedName ) ) )? otherlv_11= ',' otherlv_12= 'action' ( (lv_action_13_0= ruleAction ) ) otherlv_14= '}' )
            {
            // InternalAspect.g:378:1: (otherlv_0= 'composition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature_enabled' ( (lv_feature_enabled_4_0= RULE_EBOOLEAN ) ) (otherlv_5= ',' otherlv_6= 'jointpointRole' ( ( ruleQualifiedName ) ) )? (otherlv_8= ',' otherlv_9= 'adviceRole' ( ( ruleQualifiedName ) ) )? otherlv_11= ',' otherlv_12= 'action' ( (lv_action_13_0= ruleAction ) ) otherlv_14= '}' )
            // InternalAspect.g:378:3: otherlv_0= 'composition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'feature_enabled' ( (lv_feature_enabled_4_0= RULE_EBOOLEAN ) ) (otherlv_5= ',' otherlv_6= 'jointpointRole' ( ( ruleQualifiedName ) ) )? (otherlv_8= ',' otherlv_9= 'adviceRole' ( ( ruleQualifiedName ) ) )? otherlv_11= ',' otherlv_12= 'action' ( (lv_action_13_0= ruleAction ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCompositionAccess().getCompositionKeyword_0());
                  
            }
            // InternalAspect.g:382:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalAspect.g:383:1: (lv_name_1_0= RULE_ID )
            {
            // InternalAspect.g:383:1: (lv_name_1_0= RULE_ID )
            // InternalAspect.g:384:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCompositionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.eclipse.xtext.common.Terminals.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCompositionAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,24,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCompositionAccess().getFeature_enabledKeyword_3());
                  
            }
            // InternalAspect.g:408:1: ( (lv_feature_enabled_4_0= RULE_EBOOLEAN ) )
            // InternalAspect.g:409:1: (lv_feature_enabled_4_0= RULE_EBOOLEAN )
            {
            // InternalAspect.g:409:1: (lv_feature_enabled_4_0= RULE_EBOOLEAN )
            // InternalAspect.g:410:3: lv_feature_enabled_4_0= RULE_EBOOLEAN
            {
            lv_feature_enabled_4_0=(Token)match(input,RULE_EBOOLEAN,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_feature_enabled_4_0, grammarAccess.getCompositionAccess().getFeature_enabledEBOOLEANTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCompositionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"feature_enabled",
                      		lv_feature_enabled_4_0, 
                      		"eu.supersede.dynadapt.dsl.Aspect.EBOOLEAN");
              	    
            }

            }


            }

            // InternalAspect.g:426:2: (otherlv_5= ',' otherlv_6= 'jointpointRole' ( ( ruleQualifiedName ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==25) ) {
                    alt4=1;
                }
            }
            switch (alt4) {
                case 1 :
                    // InternalAspect.g:426:4: otherlv_5= ',' otherlv_6= 'jointpointRole' ( ( ruleQualifiedName ) )
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCompositionAccess().getCommaKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,25,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCompositionAccess().getJointpointRoleKeyword_5_1());
                          
                    }
                    // InternalAspect.g:434:1: ( ( ruleQualifiedName ) )
                    // InternalAspect.g:435:1: ( ruleQualifiedName )
                    {
                    // InternalAspect.g:435:1: ( ruleQualifiedName )
                    // InternalAspect.g:436:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getCompositionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCompositionAccess().getJointpointRoleStereotypeCrossReference_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalAspect.g:449:4: (otherlv_8= ',' otherlv_9= 'adviceRole' ( ( ruleQualifiedName ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==26) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalAspect.g:449:6: otherlv_8= ',' otherlv_9= 'adviceRole' ( ( ruleQualifiedName ) )
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getCompositionAccess().getCommaKeyword_6_0());
                          
                    }
                    otherlv_9=(Token)match(input,26,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getCompositionAccess().getAdviceRoleKeyword_6_1());
                          
                    }
                    // InternalAspect.g:457:1: ( ( ruleQualifiedName ) )
                    // InternalAspect.g:458:1: ( ruleQualifiedName )
                    {
                    // InternalAspect.g:458:1: ( ruleQualifiedName )
                    // InternalAspect.g:459:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getCompositionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCompositionAccess().getAdviceStereotypeCrossReference_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,15,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getCompositionAccess().getCommaKeyword_7());
                  
            }
            otherlv_12=(Token)match(input,27,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getCompositionAccess().getActionKeyword_8());
                  
            }
            // InternalAspect.g:480:1: ( (lv_action_13_0= ruleAction ) )
            // InternalAspect.g:481:1: (lv_action_13_0= ruleAction )
            {
            // InternalAspect.g:481:1: (lv_action_13_0= ruleAction )
            // InternalAspect.g:482:3: lv_action_13_0= ruleAction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCompositionAccess().getActionActionParserRuleCall_9_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_action_13_0=ruleAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCompositionRule());
              	        }
                     		set(
                     			current, 
                     			"action",
                      		lv_action_13_0, 
                      		"eu.supersede.dynadapt.dsl.Aspect.Action");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_14=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getCompositionAccess().getRightCurlyBracketKeyword_10());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComposition"


    // $ANTLR start "entryRuleAction"
    // InternalAspect.g:510:1: entryRuleAction returns [String current=null] : iv_ruleAction= ruleAction EOF ;
    public final String entryRuleAction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAction = null;


        try {
            // InternalAspect.g:511:2: (iv_ruleAction= ruleAction EOF )
            // InternalAspect.g:512:2: iv_ruleAction= ruleAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAction.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalAspect.g:519:1: ruleAction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'add' | kw= 'delete' | kw= 'replace' | kw= 'associate' ) ;
    public final AntlrDatatypeRuleToken ruleAction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalAspect.g:522:28: ( (kw= 'add' | kw= 'delete' | kw= 'replace' | kw= 'associate' ) )
            // InternalAspect.g:523:1: (kw= 'add' | kw= 'delete' | kw= 'replace' | kw= 'associate' )
            {
            // InternalAspect.g:523:1: (kw= 'add' | kw= 'delete' | kw= 'replace' | kw= 'associate' )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt6=1;
                }
                break;
            case 29:
                {
                alt6=2;
                }
                break;
            case 30:
                {
                alt6=3;
                }
                break;
            case 31:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalAspect.g:524:2: kw= 'add'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getActionAccess().getAddKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalAspect.g:531:2: kw= 'delete'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getActionAccess().getDeleteKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalAspect.g:538:2: kw= 'replace'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getActionAccess().getReplaceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalAspect.g:545:2: kw= 'associate'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getActionAccess().getAssociateKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAspect.g:558:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAspect.g:559:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAspect.g:560:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalAspect.g:567:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalAspect.g:570:28: ( (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* ) )
            // InternalAspect.g:571:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            {
            // InternalAspect.g:571:1: (this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )* )
            // InternalAspect.g:571:6: this_ID_0= RULE_ID ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalAspect.g:578:1: ( ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) && (synpred1_InternalAspect())) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAspect.g:578:2: ( ( '.' )=>kw= '.' ) this_ID_2= RULE_ID
            	    {
            	    // InternalAspect.g:578:2: ( ( '.' )=>kw= '.' )
            	    // InternalAspect.g:578:3: ( '.' )=>kw= '.'
            	    {
            	    kw=(Token)match(input,32,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // $ANTLR start synpred1_InternalAspect
    public final void synpred1_InternalAspect_fragment() throws RecognitionException {   
        // InternalAspect.g:578:3: ( '.' )
        // InternalAspect.g:579:2: '.'
        {
        match(input,32,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalAspect

    // Delegated rules

    public final boolean synpred1_InternalAspect() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalAspect_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000002L});

}