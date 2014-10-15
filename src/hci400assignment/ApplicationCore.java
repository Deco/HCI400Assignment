/*
 * Main.java
 */

package hci400assignment;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main class of the application.
 */
public class ApplicationCore {

    JFrame rootFrame;
    JPanel rootPanel;

    public ApplicationCore() {
        //
    }

    public void launch()
    {
        rootFrame = new JFrame("MP400 Assignment");
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rootPanel = new RootPanel();
        rootFrame.getContentPane().add(rootPanel);

        rootFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int)(screenSize.getWidth() * 3.0 / 5.0),
          (int)(screenSize.getHeight() * 3.0 / 5.0)
        );
        rootFrame.setPreferredSize(frameSize);
        rootFrame.setSize(frameSize);
        rootFrame.setVisible(true);

        rootFrame.setLocation(
          screenSize.width / 2 - rootFrame.getSize().width / 2,
          screenSize.height / 2 - rootFrame.getSize().height / 2
        );

        rootFrame.toFront();
        rootFrame.repaint();
    }

     public void showAboutBox()
    {
        rootFrame = new JFrame("MP400 Assignment");
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rootPanel = new AboutBox();
        rootFrame.getContentPane().add(rootPanel);

        rootFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int)(screenSize.getWidth() * 3.0 / 5.0),
          (int)(screenSize.getHeight() * 3.0 / 5.0)
        );
        rootFrame.setPreferredSize(frameSize);
        rootFrame.setSize(frameSize);
        rootFrame.setVisible(true);

        rootFrame.setLocation(
          screenSize.width / 2 - rootFrame.getSize().width / 2,
          screenSize.height / 2 - rootFrame.getSize().height / 2
        );

        rootFrame.toFront();
        rootFrame.repaint();
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        ApplicationCore app = new ApplicationCore();
//        app.launch();
        app.showAboutBox();
    }
}
