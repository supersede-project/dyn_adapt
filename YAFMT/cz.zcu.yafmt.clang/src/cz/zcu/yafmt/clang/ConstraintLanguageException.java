package cz.zcu.yafmt.clang;

/**
 * Exception describing error during creation of {@link IEvaluationResult}.
 * 
 * @author Jan Pikl
 */
public class ConstraintLanguageException extends Exception {

    private static final long serialVersionUID = 4843523043184156094L;

    /**
     * Creates exception with the specified error message.
     * 
     * @param message
     *            the error message
     */
    public ConstraintLanguageException(String message) {
        super(message);
    }

    /**
     * Creates exception with the specified error message and cause.
     * 
     * @param message
     *            the error message
     * @param cause
     *            cause of the error
     */
    public ConstraintLanguageException(String message, Throwable cause) {
        super(message, cause);
    }

}
