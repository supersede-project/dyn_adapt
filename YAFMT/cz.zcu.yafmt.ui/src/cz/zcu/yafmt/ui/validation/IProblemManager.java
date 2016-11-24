package cz.zcu.yafmt.ui.validation;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;


public interface IProblemManager {
    
    void addProblems(Diagnostic diagnostic);
    
    List<String> getMessages(Object target);
    
    void clearProblems(Object target);
    
    void clearProblems();
    
}
