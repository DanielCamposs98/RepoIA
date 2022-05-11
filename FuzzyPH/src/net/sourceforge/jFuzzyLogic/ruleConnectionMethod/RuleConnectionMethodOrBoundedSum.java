package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * <p>
 * Connection type: OR
 * Connection Method: Bounded sum
 *
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodOrBoundedSum extends RuleConnectionMethod {

    private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrBoundedSum();

    private RuleConnectionMethodOrBoundedSum() {
        super();
        name = "or";
    }

    public static RuleConnectionMethod get() {
        return ruleConnectionMethod;
    }

    @Override
    public double connect(double antecedent1, double antecedent2) {
        return Math.min(1, antecedent1 + antecedent2);
    }

    @Override
    public String toStringFcl() {
        return "OR: BSUM;";
    }
}
