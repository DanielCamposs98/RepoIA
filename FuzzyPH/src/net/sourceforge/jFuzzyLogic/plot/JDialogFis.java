package net.sourceforge.jFuzzyLogic.plot;

import net.sourceforge.jFuzzyLogic.FIS;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog window where you can see all variables
 */
public class JDialogFis extends JDialog {

    private static final long serialVersionUID = 1L;

    JPanel panel;

    public JDialogFis(FIS fis) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        init(fis, screenSize.width, screenSize.height);
    }

    public JDialogFis(FIS fis, int width, int height) {
        super();
        init(fis, width, height);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void init(FIS fis, int width, int height) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // The program may still run when the window is closed (that's why we don't use JFrame.EXIT_ON_CLOSE)
        BoxLayout layout = new BoxLayout(getContentPane(), 0);
        getContentPane().setLayout(layout);
        pack();
        panel = new JPanelFis(fis);
        setSize(width, height);
        setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
