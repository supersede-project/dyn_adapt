package cz.zcu.yafmt.clang;

/**
 * Basic implementation of the {@link IValidationResult}.
 * 
 * @author Jan Pikl
 */
public class ValidationResult implements IValidationResult {

    /**
     * Shared instance of success result.
     */
    public static final IValidationResult SUCCESS_RESULT = new ValidationResult();

    /** Error message. */
    private String errorMessage;

    /**
     * Creates success result.
     */
    public ValidationResult() {
        this(null);
    }
    
    /**
     * Creates failure result with the specified error message.
     * 
     * @param errorMessage
     *            the error message
     */
    public ValidationResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSuccess() {
        return errorMessage == null;
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

}
