package cz.zcu.yafmt.clang;

import java.util.List;

/**
 * Result of evaluation of a feature configuration.
 * 
 * @author Jan Pikl
 */
public interface IEvaluationResult {

    /**
     * Returns <code>true</code> when the result is success.
     * 
     * @return <code>true</code> when the result is success
     */
    boolean isSuccess();

    /**
     * Returns error message describing why evaluation failed.
     * 
     * @return error message
     */
    String getErrorMessage();

    /**
     * Returns list of objects which caused evaluation to fail. For example,
     * list of features which should not be present in configuration. The
     * returned objects are visibly marked in feature model editor.
     * 
     * @return list of objects which caused evaluation to fail
     */
    List<Object> getProblemElements();

}
