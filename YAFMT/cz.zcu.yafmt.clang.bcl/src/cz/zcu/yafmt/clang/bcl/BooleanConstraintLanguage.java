package cz.zcu.yafmt.clang.bcl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Guice;
import com.google.inject.Injector;

import cz.zcu.yafmt.clang.ConstraintLanguage;
import cz.zcu.yafmt.clang.ConstraintLanguageException;
import cz.zcu.yafmt.clang.IEvaluator;
import cz.zcu.yafmt.clang.bcl.model.Expression;
import cz.zcu.yafmt.clang.bcl.parser.antlr.BooleanConstraintLanguageParser;

public class BooleanConstraintLanguage extends ConstraintLanguage {

    private static BooleanConstraintLanguageParser parser;

    public static BooleanConstraintLanguageParser getParser() {
        if(parser == null) {
            // Use dependency injection when creating parser.
            Injector injector = Guice.createInjector(new BooleanConstraintLanguageRuntimeModule());
            parser = injector.getInstance(BooleanConstraintLanguageParser.class);
        }
        return parser;
    }

    @Override
    public IEvaluator createEvaluator(String constraintValue) throws ConstraintLanguageException {
        try {
            IParseResult result = getParser().doParse(constraintValue);
            if(result.hasSyntaxErrors()) {
                String message = result.getSyntaxErrors().iterator().next().getSyntaxErrorMessage().getMessage();
                throw new ConstraintLanguageException(message);
            }

            EObject astRoot = result.getRootASTElement();
            if(!(astRoot instanceof Expression))
                throw new ConstraintLanguageException("Empty input");

            return new BooleanConstraintEvaluator(constraintValue, (Expression) astRoot);
        }
        catch(RuntimeException ex) {
            throw new ConstraintLanguageException("Unexpected error: " + ex.getMessage());
        }
    }

}
