package cz.zcu.yafmt.clang.bcl.ui.highlight;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;

public class BooleanConstraintLanguageHighlighting extends DefaultHighlightingConfiguration {

    @Override
    public void configure(IHighlightingConfigurationAcceptor acceptor) {
        // Copied from superclass, because overriding defaultTextStyle() is more complicated.
        acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle());
        acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Punctuation character", punctuationTextStyle());
        acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
        acceptor.acceptDefaultHighlighting(STRING_ID, "String", stringTextStyle());
        acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
        acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", stringTextStyle()); // Highlight IDs as strings.
        acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Invalid Symbol", errorTextStyle());
    }

}
