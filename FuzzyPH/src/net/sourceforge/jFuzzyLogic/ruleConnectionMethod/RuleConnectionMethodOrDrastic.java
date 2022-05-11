package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * <p>
 * Connection type: OR
 * Connection Method: Drastic t-conorm (antecedent2 if antecedent1 = 0, antecedent1 if antecedent2 = 0, 1 otherwise)
 *
 * @author jan.caha@klikni.cz
 */
public class RuleConnectionMethodOrDrastic extends RuleConnectionMethod {

    private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrDrastic();

    private RuleConnectionMethodOrDrastic() {
        super();
        name = "or";
    }

    public static RuleConnectionMethod get() {
        return ruleConnectionMethod;
    }

    @Override
    public double connect(double antecedent1, double antecedent2) {
        if (antecedent1 == 0) return antecedent2;
        else if (antecedent2 == 0) return antecedent1;
        else return 1;
    }

    @Override
    public String toStringFcl() {
        return "OR : DMAX;";
    }
}
