/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui.minimal;

import hci400assignment.ApplicationCore;
import hci400assignment.ApplicationDataController;
import hci400assignment.gui.CardGrid;
import hci400assignment.gui.ImagePanel;
import hci400assignment.gui.RootPanel;
import hci400assignment.gui.SettingsPanel;
import hci400assignment.model.Item;
import hci400assignment.model.ItemProviderFilter;
import java.awt.CardLayout;
import java.awt.Image;
import java.util.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * MINIMAL!
 *
 * @author Deco
 */
public class MinimalRootPanel
  extends RootPanel
{

    private List<MinimalPreviewCard> articleCardList;
    private final CardGrid homeGrid;
    private final CardGrid friendsGrid;
    private final CardGrid searchGrid;
    private final MinimalFocusPanel focusPanel;

    private String prevScreenStr = "homeGrid";
    private final ItemProviderFilter searchProvider;

    /**
     * Creates new form RootPanel
     */
    public MinimalRootPanel() throws IOException
    {
        initComponents();

        int cardWidthMin = 330;

        ApplicationDataController dc
          = ApplicationCore.getInstance().getDataController();

        Image bgImage = ImageIO.read(
          MinimalRootPanel.class.getResourceAsStream(
            "/hci400assignment/resources/bg.png"
          )
        );

        homeGrid = new CardGrid(
          dc.getHomePreviewFeed(),
          new MinimalPreviewCard.Factory()
        );
        homeGrid.setBackgroundPanel(new ImagePanel(
          bgImage,
          ImagePanel.Mode.TILE
        ));
        homeGrid.setCardWidthMin(cardWidthMin);
        contentRootPanel.add(homeGrid, "homeGrid");

        friendsGrid = new CardGrid(
          dc.getFriendPreviewFeed(),
          new MinimalPreviewCard.Factory()
        );
        friendsGrid.setBackgroundPanel(new ImagePanel(
          bgImage,
          ImagePanel.Mode.TILE
        ));
        friendsGrid.setCardWidthMin(cardWidthMin);
        contentRootPanel.add(friendsGrid, "friendsGrid");

        searchProvider = dc.getSearchPreviewFeed(
          dc.getHomePreviewFeed(),
          dc.getFriendPreviewFeed()
        );
        searchGrid = new CardGrid(
          searchProvider,
          new MinimalPreviewCard.Factory()
        );
        searchGrid.setPreamblePanel(new MinimalSearchPanel());
        searchGrid.setBackgroundPanel(new ImagePanel(
          bgImage,
          ImagePanel.Mode.TILE
        ));
        searchGrid.setCardWidthMin(cardWidthMin);
        contentRootPanel.add(searchGrid, "searchGrid");

        focusPanel = new MinimalFocusPanel();
        contentRootPanel.add(focusPanel, "focusPanel");

        showHomeScreen();
    }

    @Override
    public void focusItem(Item item)
    {
        focusPanel.setItem(item);

        CardLayout cardLayout = (CardLayout)contentRootPanel.getLayout();
        cardLayout.show(contentRootPanel, "focusPanel");
    }

    @Override
    public void showHomeScreen()
    {
        CardLayout cardLayout = (CardLayout)contentRootPanel.getLayout();
        cardLayout.show(contentRootPanel, "homeGrid");
        prevScreenStr = "homeGrid";
        navBar.setUnderlinedButton("home");
    }

    @Override
    public void showFriendsScreen()
    {
        CardLayout cardLayout = (CardLayout)contentRootPanel.getLayout();
        cardLayout.show(contentRootPanel, "friendsGrid");
        prevScreenStr = "friendsGrid";
        navBar.setUnderlinedButton("friends");
    }

    @Override
    public void showSearchScreen()
    {
        CardLayout cardLayout = (CardLayout)contentRootPanel.getLayout();
        cardLayout.show(contentRootPanel, "searchGrid");
        prevScreenStr = "searchGrid";
        navBar.setUnderlinedButton("search");
    }

    @Override
    public void setSearchText(String text)
    {
        searchProvider.setFilterer(new ItemProviderFilter.TextFilterer(text));
    }

    @Override
    public JPanel getSettingsPanel()
    {
        LookAndFeel previousLF = UIManager.getLookAndFeel();
        SettingsPanel settingsPanel = null;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            settingsPanel = new SettingsPanel();
            UIManager.setLookAndFeel(previousLF);
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(MinimalRootPanel.class.getName()).
              log(Level.SEVERE, null, ex);
        } catch(InstantiationException ex) {
            Logger.getLogger(MinimalRootPanel.class.getName()).
              log(Level.SEVERE, null, ex);
        } catch(IllegalAccessException ex) {
            Logger.getLogger(MinimalRootPanel.class.getName()).
              log(Level.SEVERE, null, ex);
        } catch(UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MinimalRootPanel.class.getName()).
              log(Level.SEVERE, null, ex);
        }
        return settingsPanel;
    }

    @Override
    public void goBack()
    {
        if("homeGrid".equals(prevScreenStr)) {
            showHomeScreen();
        } else if("friendsGrid".equals(prevScreenStr)) {
            showFriendsScreen();
        } else if("searchGrid".equals(prevScreenStr)) {
            showSearchScreen();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        navBar = new hci400assignment.gui.minimal.MinimalNavBar();
        contentRootPanel = new javax.swing.JPanel();
        controlsBar1 = new hci400assignment.gui.minimal.MinimalControlBar();

        setLayout(new java.awt.BorderLayout());
        add(navBar, java.awt.BorderLayout.NORTH);

        contentRootPanel.setLayout(new java.awt.CardLayout());
        add(contentRootPanel, java.awt.BorderLayout.CENTER);
        add(controlsBar1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentRootPanel;
    private hci400assignment.gui.minimal.MinimalControlBar controlsBar1;
    private hci400assignment.gui.minimal.MinimalNavBar navBar;
    // End of variables declaration//GEN-END:variables

}
