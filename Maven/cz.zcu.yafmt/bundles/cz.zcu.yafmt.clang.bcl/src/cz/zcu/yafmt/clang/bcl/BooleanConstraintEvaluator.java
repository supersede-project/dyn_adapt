package cz.zcu.yafmt.clang.bcl;

import java.util.HashSet;
import java.util.Set;

import cz.zcu.yafmt.clang.EvaluationResult;
import cz.zcu.yafmt.clang.Evaluator;
import cz.zcu.yafmt.clang.IEvaluationResult;
import cz.zcu.yafmt.clang.bcl.model.Expression;
import cz.zcu.yafmt.model.fc.FeatureConfiguration;
import cz.zcu.yafmt.model.fc.Selection;

public class BooleanConstraintEvaluator extends Evaluator {

    private String originalValue;
    private Expression expression;

    public BooleanConstraintEvaluator(String originalValue, Expression expression) {
        this.originalValue = originalValue;
        this.expression = expression;
    }

    @Override
    protected Set<String> getAffectedFeatureIds() {
        Set<String> ids = new HashSet<String>();
        expression.retrieveFeatureIds(ids);
        return ids;
    }

    @Override
    public IEvaluationResult evaluate(FeatureConfiguration featureConfig) {
        Set<Selection> problemSelections = new HashSet<Selection>();
        if(expression.evaluate(featureConfig, featureConfig.getRoot(), problemSelections, true))
            return EvaluationResult.SUCCESS_RESULT;
        
        EvaluationResult result = new EvaluationResult();
        result.setErrorMessage(originalValue + " is violated.");
        result.getProblemElements().addAll(problemSelections);
        return result; 
    }

}
