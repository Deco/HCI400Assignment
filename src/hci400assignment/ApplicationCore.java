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
public class ApplicationCore
{
    private static ApplicationCore singletonInstance = null;

    JFrame rootFrame;
    JPanel rootPanel;
    JFrame aboutFrame;

    public ApplicationCore()
    {
        if(singletonInstance != null) {
            throw new IllegalStateException("Singleton!");
        }
        singletonInstance = this;
    }

    public static ApplicationCore getInstance()
    {
        return singletonInstance;
    }

    void launch()
    {
        makeAboutWindow();
        makeRootWindow();

        showRootWindow();
    }

    void makeRootWindow()
    {
        rootFrame = new JFrame("MP400 Assignment");
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rootPanel = new RootPanel();
        rootFrame.getContentPane().add(rootPanel);

        rootFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int) (screenSize.getWidth() * 3.0 / 5.0),
          (int) (screenSize.getHeight() * 3.0 / 5.0));
        rootFrame.setPreferredSize(frameSize);
        rootFrame.setSize(frameSize);
        rootFrame.setVisible(true);

        rootFrame.setLocation(
          screenSize.width / 2 - rootFrame.getSize().width / 2,
          screenSize.height / 2 - rootFrame.getSize().height / 2);

        rootFrame.toFront();
        rootFrame.repaint();
    }

    void showRootWindow()
    {
        rootFrame.setVisible(true);
        rootFrame.toFront();
        rootFrame.repaint();
    }

    void makeAboutWindow()
    {
        aboutFrame = new JFrame("MP400 Assignment");
        aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        rootPanel = new AboutBox();
        aboutFrame.getContentPane().add(rootPanel);

        aboutFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int) (screenSize.getWidth() * 2.0 / 5.0),
          (int) (screenSize.getHeight() * 2.0 / 5.0));
        aboutFrame.setPreferredSize(frameSize);
        aboutFrame.setSize(frameSize);

        aboutFrame.setLocation(
          screenSize.width / 2 - aboutFrame.getSize().width / 2,
          screenSize.height / 2 - aboutFrame.getSize().height / 2);
    }

    void showAboutWindow()
    {
        aboutFrame.setVisible(true);
        aboutFrame.toFront();
        aboutFrame.repaint();
        
    }

    public void closeAboutWindow()
    {
        aboutFrame.dispose();
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args)
    {
        ApplicationCore app = new ApplicationCore();
        app.launch();
    }
}
