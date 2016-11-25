package cz.zcu.yafmt.clang.sample;

import cz.zcu.yafmt.clang.ConstraintLanguage;
import cz.zcu.yafmt.clang.ConstraintLanguageException;
import cz.zcu.yafmt.clang.IEvaluator;

/**
 * Example implementation of the constraint language extension point. This constraint
 * language supports only <i>require</i> and <i>mutual exclusion</i> types of constraints.
 * Its grammar is <code>featureID ('require' | 'mutex-with') featureID</code>.
 * 
 * @author Jan Pikl
 */
public class SampleConstraintLanguage extends ConstraintLanguage {

    /**
     * {@inheritDoc}
     */
    @Override
    public IEvaluator createEvaluator(String constraintValue) throws ConstraintLanguageException {
        // Check if we got any value.
        if(constraintValue == null)
            throw new ConstraintLanguageException("Missing first operand.");
        
        // Check if the first operand is present.
        String[] parts = constraintValue.split("\\s+");
        if((parts == null) || parts.length < 1 || (parts[0] == null) || parts[0].trim().isEmpty())
            throw new ConstraintLanguageException("Missing first operand.");
        
        // Check if there is an operator
        if(parts.length == 1)
            throw new ConstraintLanguageException("Missing operator.");
        
        // Check if the operator is valid.
        Operator operator;
        if("requires".equals(parts[1]))
            operator = Operator.REQUIRES;
        else if("mutex-with".equals(parts[1]))
            operator = Operator.MUTEX_WITH;
        else
            throw new ConstraintLanguageException("Operator must be 'requires' or 'mutex-with'.");
        
        // Check if the second operand is present.
        if(parts.length == 2)
            throw new ConstraintLanguageException("Missing second operand.");
        
        // Check the rest of the constraint.
        if(parts.length > 3)
            throw new ConstraintLanguageException("Unnecessary input at the end.");
        
        // Create evaluator.
        return new SampleEvaluator(parts[0], parts[2], operator);
    }

}
