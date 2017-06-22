package cz.zcu.yafmt.clang.bcl.ui.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalPriorities;

public class BooleanConstraintLanguageProposalPriorities extends ContentProposalPriorities {

    @Override
    public void adjustKeywordPriority(ICompletionProposal proposal, String prefix) {
        // Keywords go always first.
        adjustPriority(proposal, prefix, 2 * keywordPriority);
    }

}
