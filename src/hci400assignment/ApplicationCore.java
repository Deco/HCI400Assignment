/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import hci400assignment.gui.AboutBox;
import hci400assignment.gui.RootPanel;
import hci400assignment.gui.cluttered.ClutteredRootPanel;
import hci400assignment.gui.minimal.MinimalRootPanel;
import hci400assignment.model.Item;
import java.awt.CardLayout;
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

    private MinimalRootPanel minimalRootPanel;
    private ClutteredRootPanel clutteredRootPanel;

    private JFrame rootFrame;
    private RootPanel currentRootPanel;

    private JFrame aboutFrame;
    private JPanel aboutPanel;

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

    public ApplicationDataController getDataController()
    {
        return dc;
    }
    
    private void launch()
      throws IOException, ParseException, UnsupportedLookAndFeelException
    {
        prepareResources();

        makeRootPanels();
        makeRootWindow();
        makeAboutWindow();

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

    private void makeRootPanels() throws IOException
    {
        minimalRootPanel = new MinimalRootPanel();

        clutteredRootPanel = new ClutteredRootPanel();

        currentRootPanel = minimalRootPanel;
    }

    private void makeRootWindow() throws IOException
    {
        rootFrame = new JFrame("HCI400 Assignment");
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout layout = new CardLayout();
        rootFrame.getContentPane().setLayout(layout);
        rootFrame.getContentPane().add(minimalRootPanel, "minimal");
        rootFrame.getContentPane().add(clutteredRootPanel, "cluttered");
        updateDesign();
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
    
    private void updateDesign()
    {
        CardLayout layout = (CardLayout)rootFrame.getContentPane().getLayout();
        if(currentRootPanel == minimalRootPanel) {
            layout.first(rootFrame.getContentPane());
            rootFrame.setTitle("HCI400 — Group 11 — Minimalistic");
        } else if(currentRootPanel == clutteredRootPanel) {
            layout.last(rootFrame.getContentPane());
            rootFrame.setTitle("HCI400 — Group 11 — Cluttered");
        } else {
            throw new IllegalStateException("wat!?!?!?");
        }
    }

    public void switchDesign()
    {
        if(currentRootPanel == minimalRootPanel) {
            currentRootPanel = clutteredRootPanel;
        } else if(currentRootPanel == clutteredRootPanel) {
            currentRootPanel = minimalRootPanel;
        } else {
            throw new IllegalStateException("wat!?!?!?");
        }
        updateDesign();
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

    public void showRootWindow()
    {
        rootFrame.setVisible(true);
        rootFrame.toFront();
        rootFrame.repaint();
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

    public void focusItem(Item item)
    {
        currentRootPanel.focusItem(item);
    }

    public void showHomeScreen()
    {
        currentRootPanel.showHomeScreen();
    }

    public void showFriendsScreen()
    {
        currentRootPanel.showFriendsScreen();
    }

    public void showSearchScreen()
    {
        currentRootPanel.showSearchScreen();
    }

    public void setSearchText(String text)
    {
        dc.setSearchText(text);
    }

    public void showSettingsWindow()
    {
        currentRootPanel.showSettingsWindow();
    }
}
