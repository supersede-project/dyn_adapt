package cz.zcu.yafmt.clang;

/**
 * Main class of a constraint language extension.
 * 
 * @author Jan Pikl
 */
public interface IConstraintLanguage {

    /**
     * Creates evaluator representing the specified constraint. The returned
     * object is later used for evaluation of a feature configuration.
     * 
     * @param constraintValue
     *            value of a constraint (expression written in this language)
     * @return evaluator representing the specified constraint
     * @throws ConstraintLanguageException
     *             error occurred during evaluator creation
     */
    IEvaluator createEvaluator(String constraintValue) throws ConstraintLanguageException;

}
