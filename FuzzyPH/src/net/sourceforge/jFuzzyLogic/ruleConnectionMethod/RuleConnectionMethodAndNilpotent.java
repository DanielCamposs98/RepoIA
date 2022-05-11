package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * <p>
 * Connection type: AND
 * Connection Method: Nilpotent minimum (if antecedent1 + antecedent2>1 then min(antecedent1,antecedent2), 0 otherwise)
 *
 * @author jan.caha@klikni.cz
 */
public class RuleConnectionMethodAndNilpotent extends RuleConnectionMethod {

    private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodAndNilpotent();

    private RuleConnectionMethodAndNilpotent() {
        super();
        name = "and";
    }

    public static RuleConnectionMethod get() {
        return ruleConnectionMethod;
    }

    @Override
    public double connect(double antecedent1, double antecedent2) {
        if ((antecedent1 + antecedent2) > 1) return Math.min(antecedent1, antecedent2);
        else return 0;
    }

    @Override
    public String toStringFcl() {
        return "AND: NIPMIN;";
    }
}
