package net.sourceforge.jFuzzyLogic.plot;

import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Paints the JFreeChart
 */
public class PanelPaintGraph extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFreeChart chart;

    public PanelPaintGraph(JFreeChart chart) {
        this.chart = chart;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (chart != null) {
            Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
            chart.draw((Graphics2D) g, rect);
        }
    }

}
