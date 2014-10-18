/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import hci400assignment.gui.FocusPanel;
import hci400assignment.gui.AboutBox;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 * The main class of the application.
 */
public class ApplicationCore
{
    private static final String synthStyleFilePath
      = "/hci400assignment/resources/style.xml";

    private static ApplicationCore singletonInstance = null;
    
    private ApplicationDataController dc;

    private JFrame rootFrame;
    private JPanel rootPanel;
    private JFrame aboutFrame;
    private JPanel aboutPanel;
    private JFrame focusFrame;
    private JPanel focusPanel;

    private SynthLookAndFeel laf;

    public ApplicationCore()
    {
        if(singletonInstance != null) {
            throw new IllegalStateException("Singleton!");
        }
        singletonInstance = this;
        
        dc = new ApplicationDataController();
    }

    public static ApplicationCore getInstance()
    {
        return singletonInstance;
    }

    private void launch()
      throws IOException, ParseException, UnsupportedLookAndFeelException
    {
        prepareResources();

        makeAboutWindow();
        makeRootWindow();
        makeFocusView();

        showRootWindow();
    }

    private void prepareResources()
      throws ParseException, IOException, UnsupportedLookAndFeelException
    {
        laf = new SynthLookAndFeel();
        URL synthStyleFileURL
          = ApplicationCore.class.getResource(synthStyleFilePath);

        laf.load(synthStyleFileURL);
        UIManager.setLookAndFeel(laf);
    }

    private void makeRootWindow() throws IOException
    {
        rootFrame = new JFrame("HCI400 Assignment");
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rootPanel = new hci400assignment.gui.cluttered.RootPanel();
        rootPanel.setDoubleBuffered(true);

        rootFrame.getContentPane().add(rootPanel);
        rootFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int)(screenSize.getWidth() * 4.0 / 5.0),
          (int)(screenSize.getHeight() * 4.0 / 5.0));
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

    public void showRootWindow()
    {
        rootFrame.setVisible(true);
        rootFrame.toFront();
        rootFrame.repaint();
    }

    private void makeAboutWindow()
    {
        aboutFrame = new JFrame("About");
        aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        aboutPanel = new AboutBox();
        aboutPanel.setDoubleBuffered(true);
        aboutFrame.getContentPane().add(aboutPanel);

        aboutFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int)(screenSize.getWidth() * 2.0 / 5.0),
          (int)(screenSize.getHeight() * 2.0 / 5.0));
        aboutFrame.setPreferredSize(frameSize);
        aboutFrame.setSize(frameSize);

        aboutFrame.setLocation(
          screenSize.width / 2 - aboutFrame.getSize().width / 2,
          screenSize.height / 2 - aboutFrame.getSize().height / 2);
    }

    public void showAboutWindow()
    {
        aboutFrame.setVisible(true);
        aboutFrame.toFront();
        aboutFrame.repaint();
    }

    public void hideAboutWindow()
    {
        aboutFrame.setVisible(false);
    }

    private void makeFocusView()
    {
        focusFrame = new JFrame("Focus View");
        focusFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        focusPanel = new FocusPanel();
        focusPanel.setDoubleBuffered(true);
        focusFrame.getContentPane().add(focusPanel);

        focusFrame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(
          (int)(screenSize.getWidth() * 2.0 / 5.0),
          (int)(screenSize.getHeight() * 2.0 / 5.0));
        focusFrame.setPreferredSize(frameSize);
        focusFrame.setSize(frameSize);

        focusFrame.setLocation(
          screenSize.width / 2 - focusFrame.getSize().width / 2,
          screenSize.height / 2 - focusFrame.getSize().height / 2);
    }

    public void showFocusView()
    {
        focusFrame.setVisible(true);
        focusFrame.toFront();
        focusFrame.repaint();
    }

    public void hideFocusView()
    {
        focusFrame.setVisible(false);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) throws IOException
    {
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                try {
                    ApplicationCore app = new ApplicationCore();
                    app.launch();
                } catch(Exception ex) {
//                    System.err.println("Error: " + ex);
                    ex.printStackTrace(new PrintStream(System.err));
                    System.exit(-1);
                }
            }
        });
    }
}
