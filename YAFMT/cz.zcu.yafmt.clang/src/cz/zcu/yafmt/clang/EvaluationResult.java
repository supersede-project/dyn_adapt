package cz.zcu.yafmt.clang;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic implementation of the {@link IEvaluationResult}.
 * 
 * @author Jan Pikl
 */
public class EvaluationResult implements IEvaluationResult {

    /**
     * Shared instance of success result.
     */
    public static final IEvaluationResult SUCCESS_RESULT = new EvaluationResult();

    /** Error message. */
    private String errorMessage;
    
    /** List of problem elements. */
    private List<Object> problemElements = new ArrayList<Object>();

    /**
     * Creates success result.
     */
    public EvaluationResult() {
        this(null);
    }

    /**
     * Creates failure result with the specified error message.
     * 
     * @param errorMessage
     *            the error message
     */
    public EvaluationResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSuccess() {
        return (errorMessage == null) && problemElements.isEmpty();
    }

    /**
     * Sets error message for this result, marking it as failure.
     * 
     * @param errorMessage the error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * {@inheritDoc} 
     * The returned list can be modified.
     */
    @Override
    public List<Object> getProblemElements() {
        return problemElements;
    }

}
