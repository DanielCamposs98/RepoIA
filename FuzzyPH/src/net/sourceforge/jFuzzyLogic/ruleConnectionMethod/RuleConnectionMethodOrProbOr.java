package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * <p>
 * Connection type: OR
 * Connection Method: Probabilistic OR
 *
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodOrProbOr extends RuleConnectionMethod {

    private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrProbOr();

    private RuleConnectionMethodOrProbOr() {
        super();
        name = "or";
    }

    public static RuleConnectionMethod get() {
        return ruleConnectionMethod;
    }

    @Override
    public double connect(double antecedent1, double antecedent2) {
        return (antecedent1 + antecedent2 - antecedent1 * antecedent2);
    }

    @Override
    public String toStringFcl() {
        return "OR: ASUM;";
    }
}
