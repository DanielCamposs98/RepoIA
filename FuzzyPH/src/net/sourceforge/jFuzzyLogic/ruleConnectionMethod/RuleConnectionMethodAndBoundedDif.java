package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * <p>
 * Connection type: AND
 * Connection Method: Bounded difference
 *
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodAndBoundedDif extends RuleConnectionMethod {

    private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodAndBoundedDif();

    private RuleConnectionMethodAndBoundedDif() {
        super();
        name = "and";
    }

    public static RuleConnectionMethod get() {
        return ruleConnectionMethod;
    }

    @Override
    public double connect(double antecedent1, double antecedent2) {
        return Math.max(0, antecedent1 + antecedent2 - 1);
    }

    @Override
    public String toStringFcl() {
        return "AND : BDIFF;";
    }
}
