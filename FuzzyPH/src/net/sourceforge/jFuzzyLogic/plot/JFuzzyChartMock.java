package net.sourceforge.jFuzzyLogic.plot;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Charts variables, membership functions, function blocks, etc.
 * <p>
 * Stub class to avoid including jFreeCharts in minimal libraries
 * <p>
 * Code provided by: Carmelo (cswi)
 */
public class JFuzzyChartMock extends JFuzzyChart {

    protected JFuzzyChartMock() {
    }

    @Override
    public void chart(Defuzzifier def, String title, boolean showIt) {
    }

    @Override
    public void chart(FIS fis) {
    }

    @Override
    public void chart(FunctionBlock fb) {
    }

    @Override
    public void chart(LinguisticTerm lt, boolean showIt) {
    }

    @Override
    public void chart(MembershipFunction mf, String title, boolean showIt) {
    }

    @Override
    public void chart(Variable var, boolean showIt) {
    }

    @Override
    public void chart(Variable var, Defuzzifier defuzzifier, boolean showIt) {
    }

    @Override
    public void draw(Graphics2D g, Rectangle2D rect, Variable var) {
    }

}
