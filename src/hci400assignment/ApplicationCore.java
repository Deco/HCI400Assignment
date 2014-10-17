/*
 * Main.java
 */
package hci400assignment;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The main class of the application.
 */
public class ApplicationCore
{
    private static ApplicationCore singletonInstance = null;

    JFrame rootFrame;
    JPanel rootPanel;
    JFrame aboutFrame;
    JPanel aboutPanel;

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

    void launch() throws IOException
    {
        makeAboutWindow();
        makeRootWindow();

        showRootWindow();
    }

    void makeRootWindow() throws IOException
    {
        rootFrame = new JFrame("HCI400 Assignment");
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rootPanel = new RootPanel();
        rootPanel.setDoubleBuffered(true);

        rootFrame.getContentPane().add(rootPanel);
        rootFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int) (screenSize.getWidth() * 4.0 / 5.0),
          (int) (screenSize.getHeight() * 4.0 / 5.0));
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
        aboutFrame = new JFrame("About");
        aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        aboutPanel = new AboutBox();
        aboutPanel.setDoubleBuffered(true);
        aboutFrame.getContentPane().add(aboutPanel);

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

    void hideAboutWindow()
    {
        aboutFrame.setVisible(false);
    }
    /**
     * Main method launching the application.
     */
    public static void main(String[] args) throws IOException
    {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    ApplicationCore app = new ApplicationCore();
                    app.launch();
                } catch (IOException ex) {
                    System.err.println("Error: "+ex);
                    //System.exit(-1);
                }
            }
        });
    }
}
