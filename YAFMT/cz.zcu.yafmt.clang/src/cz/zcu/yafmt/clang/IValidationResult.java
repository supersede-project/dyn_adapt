package cz.zcu.yafmt.clang;

/**
 * Result of validation of a constraint.
 * 
 * @author Jan Pikl
 */
public interface IValidationResult {

    /**
     * Returns <code>true</code> when the result is success.
     * 
     * @return <code>true</code> when the result is success
     */
    boolean isSuccess();

    /**
     * Returns error message describing why validation failed.
     * 
     * @return error message
     */
    String getErrorMessage();

}
