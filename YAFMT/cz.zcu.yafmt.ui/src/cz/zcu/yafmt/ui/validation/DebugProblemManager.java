package cz.zcu.yafmt.ui.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;


public class DebugProblemManager implements IProblemManager {

    @Override
    public void addProblems(Diagnostic diagnostic) {
        System.out.println("------------------------------------------");
        System.out.println(" Validation Results");
        System.out.println("------------------------------------------");
        writeResult(diagnostic, 0);
        System.out.println();
    }
    
    private void writeResult(Diagnostic diagnostic, int indent) {
        writeIndented("[" + getCodeName(diagnostic.getCode()) + "] " + diagnostic.getMessage(), indent);
        for(Diagnostic childDiagnostic: diagnostic.getChildren())
            writeResult(childDiagnostic, indent + 1);
    }
    
    private void writeIndented(String text, int indent) {
        for(int i = 0; i < indent; i++)
            System.out.print("    ");
        System.out.println(text);
    }

    private String getCodeName(int code) {
        switch(code) {
            case Diagnostic.CANCEL:
                return "CANCEL";
                
            case Diagnostic.ERROR:
                return "ERROR";
                
            case Diagnostic.INFO:
                return "INFO ";
                
            case Diagnostic.OK:
                return "OK   ";
                
            default:
                return "?????";
        }
    }
    
    @Override
    public List<String> getMessages(Object target) {
        return Collections.emptyList();
    }

    @Override
    public void clearProblems(Object target) {
    }

    @Override
    public void clearProblems() {
    }
    
}
