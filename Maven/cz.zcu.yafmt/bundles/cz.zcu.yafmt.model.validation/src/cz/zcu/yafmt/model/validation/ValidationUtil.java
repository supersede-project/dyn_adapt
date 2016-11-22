package cz.zcu.yafmt.model.validation;

import static cz.zcu.yafmt.model.validation.Localization.getMessage;

import java.util.regex.Pattern;

public class ValidationUtil {
    
    public static void checkEmptyValue(String name, String value) throws Exception {
        if((value == null) || value.isEmpty())
            throw new Exception(getMessage("Errors_EmptyValue", name));
    }
    
    public static void checkIdValue(String name, String value) throws Exception {
        checkEmptyValue(name, value);
        if(!Pattern.matches("[a-zA-Z_][0-9a-zA-Z_]*", value))
            throw new Exception(getMessage("Errors_WrongIdFormat"));
    }
    
    public static void checkBounds(int lower, int upper) throws Exception {
        upper = (upper == -1) ? Integer.MAX_VALUE : upper;
        if(lower < 0)
            throw new Exception(getMessage("Errors_NegativeLowerBound"));
        if(upper < 1)
            throw new Exception(getMessage("Errors_NegativeUpperBound"));
        if(lower > upper)
            throw new Exception(getMessage("Errors_UpperLowerBoundMismatch"));
    }
    
}
