package eu.supersede.dynadapt.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAspectLexer extends Lexer {
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

    public InternalAspectLexer() {;} 
    public InternalAspectLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAspectLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalAspect.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:11:7: ( 'aspect' )
            // InternalAspect.g:11:9: 'aspect'
            {
            match("aspect"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:12:7: ( '{' )
            // InternalAspect.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:13:7: ( 'feature' )
            // InternalAspect.g:13:9: 'feature'
            {
            match("feature"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:14:7: ( ',' )
            // InternalAspect.g:14:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:15:7: ( 'advice' )
            // InternalAspect.g:15:9: 'advice'
            {
            match("advice"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:16:7: ( 'pointcuts' )
            // InternalAspect.g:16:9: 'pointcuts'
            {
            match("pointcuts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:17:7: ( '}' )
            // InternalAspect.g:17:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:18:7: ( 'compositions' )
            // InternalAspect.g:18:9: 'compositions'
            {
            match("compositions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:19:7: ( 'pointcut' )
            // InternalAspect.g:19:9: 'pointcut'
            {
            match("pointcut"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:20:7: ( 'pattern' )
            // InternalAspect.g:20:9: 'pattern'
            {
            match("pattern"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:21:7: ( 'role' )
            // InternalAspect.g:21:9: 'role'
            {
            match("role"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:22:7: ( 'composition' )
            // InternalAspect.g:22:9: 'composition'
            {
            match("composition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:23:7: ( 'feature_enabled' )
            // InternalAspect.g:23:9: 'feature_enabled'
            {
            match("feature_enabled"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:24:7: ( 'jointpointRole' )
            // InternalAspect.g:24:9: 'jointpointRole'
            {
            match("jointpointRole"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:25:7: ( 'adviceRole' )
            // InternalAspect.g:25:9: 'adviceRole'
            {
            match("adviceRole"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:26:7: ( 'action' )
            // InternalAspect.g:26:9: 'action'
            {
            match("action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:27:7: ( 'add' )
            // InternalAspect.g:27:9: 'add'
            {
            match("add"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:28:7: ( 'delete' )
            // InternalAspect.g:28:9: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:29:7: ( 'replace' )
            // InternalAspect.g:29:9: 'replace'
            {
            match("replace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:30:7: ( 'associate' )
            // InternalAspect.g:30:9: 'associate'
            {
            match("associate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:31:7: ( '.' )
            // InternalAspect.g:31:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "RULE_EBOOLEAN"
    public final void mRULE_EBOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_EBOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:600:15: ( ( 'true' | 'false' ) )
            // InternalAspect.g:600:17: ( 'true' | 'false' )
            {
            // InternalAspect.g:600:17: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalAspect.g:600:18: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalAspect.g:600:25: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EBOOLEAN"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:602:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalAspect.g:602:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalAspect.g:602:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalAspect.g:602:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalAspect.g:602:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAspect.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:604:10: ( ( '0' .. '9' )+ )
            // InternalAspect.g:604:12: ( '0' .. '9' )+
            {
            // InternalAspect.g:604:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAspect.g:604:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:606:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalAspect.g:606:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalAspect.g:606:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalAspect.g:606:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalAspect.g:606:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalAspect.g:606:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalAspect.g:606:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalAspect.g:606:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalAspect.g:606:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalAspect.g:606:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalAspect.g:606:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:608:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalAspect.g:608:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalAspect.g:608:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalAspect.g:608:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:610:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalAspect.g:610:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalAspect.g:610:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAspect.g:610:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalAspect.g:610:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAspect.g:610:41: ( '\\r' )? '\\n'
                    {
                    // InternalAspect.g:610:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalAspect.g:610:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:612:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalAspect.g:612:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalAspect.g:612:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAspect.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAspect.g:614:16: ( . )
            // InternalAspect.g:614:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalAspect.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | RULE_EBOOLEAN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=29;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalAspect.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalAspect.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalAspect.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalAspect.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalAspect.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalAspect.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalAspect.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalAspect.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalAspect.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalAspect.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalAspect.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // InternalAspect.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // InternalAspect.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // InternalAspect.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // InternalAspect.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // InternalAspect.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // InternalAspect.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // InternalAspect.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // InternalAspect.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // InternalAspect.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // InternalAspect.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // InternalAspect.g:1:136: RULE_EBOOLEAN
                {
                mRULE_EBOOLEAN(); 

                }
                break;
            case 23 :
                // InternalAspect.g:1:150: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 24 :
                // InternalAspect.g:1:158: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 25 :
                // InternalAspect.g:1:167: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 26 :
                // InternalAspect.g:1:179: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 27 :
                // InternalAspect.g:1:195: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 28 :
                // InternalAspect.g:1:211: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 29 :
                // InternalAspect.g:1:219: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\1\30\1\uffff\1\30\1\uffff\1\30\1\uffff\4\30\1\uffff\1\30\1\24\2\uffff\3\24\2\uffff\3\30\2\uffff\2\30\1\uffff\2\30\1\uffff\5\30\1\uffff\1\30\5\uffff\3\30\1\76\16\30\1\uffff\6\30\1\123\3\30\1\127\5\30\1\127\3\30\1\uffff\3\30\1\uffff\1\143\1\30\1\146\1\147\6\30\1\156\1\uffff\2\30\2\uffff\1\162\1\30\1\164\1\30\1\166\1\30\1\uffff\3\30\1\uffff\1\174\1\uffff\1\30\1\uffff\1\30\1\177\2\30\1\u0082\1\uffff\2\30\1\uffff\1\u0085\1\30\1\uffff\2\30\1\uffff\1\30\1\u008b\2\30\1\u008e\1\uffff\2\30\1\uffff\2\30\1\u0093\1\u0094\2\uffff";
    static final String DFA13_eofS =
        "\u0095\uffff";
    static final String DFA13_minS =
        "\1\0\1\143\1\uffff\1\141\1\uffff\1\141\1\uffff\1\157\1\145\1\157\1\145\1\uffff\1\162\1\101\2\uffff\2\0\1\52\2\uffff\1\160\1\144\1\164\2\uffff\1\141\1\154\1\uffff\1\151\1\164\1\uffff\1\155\1\154\1\160\1\151\1\154\1\uffff\1\165\5\uffff\1\145\1\157\1\151\1\60\1\151\1\164\1\163\1\156\1\164\1\160\1\145\1\154\1\156\2\145\3\143\1\uffff\1\157\1\165\1\145\1\164\1\145\1\157\1\60\1\141\2\164\1\60\1\164\1\151\1\145\1\156\1\162\1\60\1\143\1\162\1\163\1\uffff\1\143\1\160\1\145\1\uffff\1\60\1\141\2\60\1\145\1\165\1\156\1\151\1\145\1\157\1\60\1\uffff\1\164\1\157\2\uffff\1\60\1\164\1\60\1\164\1\60\1\151\1\uffff\1\145\1\154\1\145\1\uffff\1\60\1\uffff\1\151\1\uffff\1\156\1\60\1\145\1\156\1\60\1\uffff\1\157\1\164\1\uffff\1\60\1\141\1\uffff\1\156\1\122\1\uffff\1\142\1\60\1\157\1\154\1\60\1\uffff\1\154\1\145\1\uffff\1\145\1\144\2\60\2\uffff";
    static final String DFA13_maxS =
        "\1\uffff\1\163\1\uffff\1\145\1\uffff\1\157\1\uffff\3\157\1\145\1\uffff\1\162\1\172\2\uffff\2\uffff\1\57\2\uffff\1\163\1\166\1\164\2\uffff\1\141\1\154\1\uffff\1\151\1\164\1\uffff\1\155\1\154\1\160\1\151\1\154\1\uffff\1\165\5\uffff\1\145\1\157\1\151\1\172\1\151\1\164\1\163\1\156\1\164\1\160\1\145\1\154\1\156\2\145\3\143\1\uffff\1\157\1\165\1\145\1\164\1\145\1\157\1\172\1\141\2\164\1\172\1\164\1\151\1\145\1\156\1\162\1\172\1\143\1\162\1\163\1\uffff\1\143\1\160\1\145\1\uffff\1\172\1\141\2\172\1\145\1\165\1\156\1\151\1\145\1\157\1\172\1\uffff\1\164\1\157\2\uffff\1\172\1\164\1\172\1\164\1\172\1\151\1\uffff\1\145\1\154\1\145\1\uffff\1\172\1\uffff\1\151\1\uffff\1\156\1\172\1\145\1\156\1\172\1\uffff\1\157\1\164\1\uffff\1\172\1\141\1\uffff\1\156\1\122\1\uffff\1\142\1\172\1\157\1\154\1\172\1\uffff\1\154\1\145\1\uffff\1\145\1\144\2\172\2\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\uffff\1\7\4\uffff\1\25\2\uffff\1\27\1\30\3\uffff\1\34\1\35\3\uffff\1\27\1\2\2\uffff\1\4\2\uffff\1\7\5\uffff\1\25\1\uffff\1\30\1\31\1\32\1\33\1\34\22\uffff\1\21\24\uffff\1\13\3\uffff\1\26\13\uffff\1\1\2\uffff\1\5\1\20\6\uffff\1\22\3\uffff\1\3\1\uffff\1\12\1\uffff\1\23\5\uffff\1\11\2\uffff\1\24\2\uffff\1\6\2\uffff\1\17\5\uffff\1\14\2\uffff\1\10\4\uffff\1\16\1\15";
    static final String DFA13_specialS =
        "\1\0\17\uffff\1\2\1\1\u0083\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\24\2\23\2\24\1\23\22\24\1\23\1\24\1\20\4\24\1\21\4\24\1\4\1\24\1\13\1\22\12\17\7\24\32\16\3\24\1\15\1\16\1\24\1\1\1\16\1\7\1\12\1\16\1\3\3\16\1\11\5\16\1\5\1\16\1\10\1\16\1\14\6\16\1\2\1\24\1\6\uff82\24",
            "\1\27\1\26\16\uffff\1\25",
            "",
            "\1\33\3\uffff\1\32",
            "",
            "\1\36\15\uffff\1\35",
            "",
            "\1\40",
            "\1\42\11\uffff\1\41",
            "\1\43",
            "\1\44",
            "",
            "\1\46",
            "\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "",
            "\0\50",
            "\0\50",
            "\1\51\4\uffff\1\52",
            "",
            "",
            "\1\54\2\uffff\1\55",
            "\1\57\21\uffff\1\56",
            "\1\60",
            "",
            "",
            "\1\61",
            "\1\62",
            "",
            "\1\63",
            "\1\64",
            "",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "\1\72",
            "",
            "",
            "",
            "",
            "",
            "\1\73",
            "\1\74",
            "\1\75",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\124",
            "\1\125",
            "\1\126",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\140",
            "\1\141",
            "\1\142",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\144",
            "\12\30\7\uffff\21\30\1\145\10\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\1\157",
            "\1\160",
            "",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\161\1\uffff\32\30",
            "\1\163",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\165",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\167",
            "",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\22\30\1\173\7\30",
            "",
            "\1\175",
            "",
            "\1\176",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\u0080",
            "\1\u0081",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\1\u0083",
            "\1\u0084",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "",
            "\1\u0089",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\22\30\1\u008a\7\30",
            "\1\u008c",
            "\1\u008d",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            "\1\u008f",
            "\1\u0090",
            "",
            "\1\u0091",
            "\1\u0092",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | RULE_EBOOLEAN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='a') ) {s = 1;}

                        else if ( (LA13_0=='{') ) {s = 2;}

                        else if ( (LA13_0=='f') ) {s = 3;}

                        else if ( (LA13_0==',') ) {s = 4;}

                        else if ( (LA13_0=='p') ) {s = 5;}

                        else if ( (LA13_0=='}') ) {s = 6;}

                        else if ( (LA13_0=='c') ) {s = 7;}

                        else if ( (LA13_0=='r') ) {s = 8;}

                        else if ( (LA13_0=='j') ) {s = 9;}

                        else if ( (LA13_0=='d') ) {s = 10;}

                        else if ( (LA13_0=='.') ) {s = 11;}

                        else if ( (LA13_0=='t') ) {s = 12;}

                        else if ( (LA13_0=='^') ) {s = 13;}

                        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||LA13_0=='b'||LA13_0=='e'||(LA13_0>='g' && LA13_0<='i')||(LA13_0>='k' && LA13_0<='o')||LA13_0=='q'||LA13_0=='s'||(LA13_0>='u' && LA13_0<='z')) ) {s = 14;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 15;}

                        else if ( (LA13_0=='\"') ) {s = 16;}

                        else if ( (LA13_0=='\'') ) {s = 17;}

                        else if ( (LA13_0=='/') ) {s = 18;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 19;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='+')||LA13_0=='-'||(LA13_0>=':' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {s = 20;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_17 = input.LA(1);

                        s = -1;
                        if ( ((LA13_17>='\u0000' && LA13_17<='\uFFFF')) ) {s = 40;}

                        else s = 20;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_16 = input.LA(1);

                        s = -1;
                        if ( ((LA13_16>='\u0000' && LA13_16<='\uFFFF')) ) {s = 40;}

                        else s = 20;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}