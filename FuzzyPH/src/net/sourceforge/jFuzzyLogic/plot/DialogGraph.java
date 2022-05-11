package net.sourceforge.jFuzzyLogic.plot;

import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog windows where you can see a graph
 * <p>
 * Code provided by: Carmelo (cswi)
 */
public class DialogGraph extends JDialog {

    private static final long serialVersionUID = 1L;
    public static int DEFAULT_HEIGHT = 250;
    public static int DEFAULT_WIDTH = 425;
    public static int posx = 0;
    public static int posy = 0;
    PanelPaintGraph panel;

    private DialogGraph(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public static DialogGraph execute(JFreeChart chart) {
        return execute(chart, posx, posy, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static DialogGraph execute(JFreeChart chart, int width, int height) {
        return execute(chart, posx, posy, width, height);
    }

    public static DialogGraph execute(JFreeChart chart, int posx, int posy, int width, int height) {
        if (chart == null) return null;

        DialogGraph dg = new DialogGraph(null, false);
        dg.panel = new PanelPaintGraph(chart);
        dg.setSize(width, height);
        dg.setLocation(posx, posy);
        dg.setLayout(new BorderLayout());
        dg.getContentPane().add(dg.panel, BorderLayout.CENTER);
        dg.setVisible(true);
        nextPosition(width, height);
        return dg;
    }

    /**
     * Prepare coordinates for next plot
     *
     * @param sizex
     * @param sizey
     */
    public static void nextPosition(int sizex, int sizey) {
        // Screen size, to be able to position the plots automatically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Positions for next plot
        posx += sizex;
        if ((posx + sizex) > screenSize.width) { // Out of screen?
            posx = 0;
            posy += sizey;
        }

        if ((posy + sizey) > screenSize.height) { // Out of screen?
            posx = 0;
            posy = 0;
        }

    }

    public PanelPaintGraph getPanel() {
        return panel;
    }

    public void setPanel(PanelPaintGraph panel) {
        this.panel = panel;
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        BoxLayout layout = new BoxLayout(getContentPane(), 0);
        getContentPane().setLayout(layout);
        pack();
    }

}
