/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui.cluttered;

import hci400assignment.ApplicationCore;
import hci400assignment.gui.Card;
import hci400assignment.gui.CardGrid;
import hci400assignment.gui.ImagePanel;
import hci400assignment.gui.RootPanel;
import hci400assignment.gui.minimal.MinimalPreviewCard;
import hci400assignment.model.Item;
import java.util.List;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * CLUTTERED!
 *
 * @author Deco
 */
public class ClutteredRootPanel
  extends RootPanel
{

    private List<ClutteredPreviewCard> articleCardList;
    private final CardGrid cardGrid;

    /**
     * Creates new form RootPanel
     */
    public ClutteredRootPanel()
      throws IOException
    {
        initComponents();
        int cardWidthMin = 346;

        cardGrid = new CardGrid(
          ApplicationCore.getInstance().getDataController().getHomePreviewFeed(),
          new MinimalPreviewCard.Factory()
        );

        cardGrid.setBackgroundPanel(new ImagePanel(
          ImageIO.read(ClutteredRootPanel.class.getResourceAsStream(
              "/hci400assignment/resources/dark-bg.png"
            )
          ),
          ImagePanel.Mode.TILE
        ));
        cardGrid.setCardWidthMin(cardWidthMin);

        contentRootPanel.add(cardGrid, java.awt.BorderLayout.CENTER);

    }

    @Override
    public void focusItem(Item item)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showHomeScreen()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showFriendsScreen()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showSearchScreen()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showSettingsWindow()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        navBar = new hci400assignment.gui.cluttered.ClutteredNavBar();
        contentRootPanel = new javax.swing.JPanel();
        controlsBar1 = new hci400assignment.gui.ControlBar();

        setLayout(new java.awt.BorderLayout());
        add(navBar, java.awt.BorderLayout.NORTH);

        contentRootPanel.setLayout(new java.awt.BorderLayout());
        add(contentRootPanel, java.awt.BorderLayout.CENTER);
        add(controlsBar1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentRootPanel;
    private hci400assignment.gui.ControlBar controlsBar1;
    private hci400assignment.gui.cluttered.ClutteredNavBar navBar;
    // End of variables declaration//GEN-END:variables

}
