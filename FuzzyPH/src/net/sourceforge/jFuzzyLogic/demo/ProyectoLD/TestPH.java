package net.sourceforge.jFuzzyLogic.demo.ProyectoLD;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class TestPH {

    public static void main(String[] a) {

        String nombreArchivo = "fcl/pH.fcl";
        FIS fis = FIS.load(nombreArchivo, true);
        if (fis == null) {
            System.out.println("No se pudo cargar el archivo.");
            return;
        }

        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);

        functionBlock.setVariable("Error_pH", 1);

        functionBlock.evaluate();

        Variable pH = functionBlock.getVariable("Control_pH");
        JFuzzyChart.get().chart(pH, pH.getDefuzzifier(), true);
        Gpr.debug("Min_M[Error_pH]: " + functionBlock.getVariable("Control_pH").getMembership("Min_M"));

        System.out.println(functionBlock);
        System.out.println("pH : " + functionBlock.getVariable("Control_pH").getValue());
    }
}
