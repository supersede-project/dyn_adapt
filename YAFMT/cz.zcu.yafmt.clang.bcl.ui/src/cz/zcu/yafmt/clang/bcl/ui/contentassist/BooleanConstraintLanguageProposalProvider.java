/*
 * generated by Xtext
 */
package cz.zcu.yafmt.clang.bcl.ui.contentassist;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import cz.zcu.yafmt.clang.bcl.ui.BooleanConstraintLanguageEditingSupport;
import cz.zcu.yafmt.clang.bcl.ui.BooleanConstraintLanguageEditingSupportPlugin;
import cz.zcu.yafmt.clang.bcl.ui.contentassist.AbstractBooleanConstraintLanguageProposalProvider;

/**
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on
 * how to customize content assistant
 */
public class BooleanConstraintLanguageProposalProvider extends AbstractBooleanConstraintLanguageProposalProvider {

    @Override
    public void complete_ID(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        // Do not propose the default values.
        // completePrimaryExpression_Value: Value - ID
        // completeContextualExpression_Context: Context - ID
    }

    @Override
    public void completeContextualExpression_ContextId(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeFeatureIdsProposal(context, acceptor);
    }

    @Override
    public void completePrimaryExpression_FeatureId(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        completeFeatureIdsProposal(context, acceptor);
    }

    private void completeFeatureIdsProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
        Image image = BooleanConstraintLanguageEditingSupportPlugin.getInstance().getImageRegistry().get("id.png");

        for(Map.Entry<String, String> entry: BooleanConstraintLanguageEditingSupport.getEditedFeatureModelIds().entrySet()) {
            String proposal = entry.getKey();
            String displayString = entry.getKey() + " - " + entry.getValue();
            acceptor.accept(createCompletionProposal(proposal, displayString, image, context));
        }
    }

}
