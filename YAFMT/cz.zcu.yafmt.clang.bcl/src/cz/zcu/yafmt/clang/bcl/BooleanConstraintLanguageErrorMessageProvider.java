package cz.zcu.yafmt.clang.bcl;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;

public class BooleanConstraintLanguageErrorMessageProvider implements ISyntaxErrorMessageProvider {

    @Override
    public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
        // TODO better error messages.
        return new SyntaxErrorMessage(context.getDefaultMessage(), Diagnostic.SYNTAX_DIAGNOSTIC);
    }
    @Override
    public SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context) {
        // TODO better error messages.
        return new SyntaxErrorMessage(context.getDefaultMessage(), Diagnostic.SYNTAX_DIAGNOSTIC);
    }

}
