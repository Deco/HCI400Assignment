/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui.cluttered;

import hci400assignment.ApplicationCore;
import hci400assignment.gui.Card;
import hci400assignment.gui.CardGrid;
import hci400assignment.gui.ImagePanel;
import hci400assignment.gui.minimal.PreviewCard;
import hci400assignment.model.Item;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 * CLUTTERED!
 *
 * @author Deco
 */
public class RootPanel
  extends javax.swing.JPanel
{

    private List<PreviewCard> articleCardList;
    private final CardGrid cardGrid;

    /**
     * Creates new form RootPanel
     */
    public RootPanel()
      throws IOException
    {
        initComponents();

        articleCardList = new ArrayList<PreviewCard>();

        int cardWidthMin = 346;
        for(int i = 0; i < 20; i++) {
            PreviewCard c = new PreviewCard(new Item());
            articleCardList.add(c);
        }

        final List<PreviewCard> modelCardList = articleCardList;
        cardGrid = new CardGrid(new ListModel()
        {

            @Override
            public int getSize()
            {
                return modelCardList.size();
            }

            @Override
            public Card getElementAt(int i)
            {
                return modelCardList.get(i);
            }

            @Override
            public void addListDataListener(ListDataListener ll)
            {
                // 
            }

            @Override
            public void removeListDataListener(ListDataListener ll)
            {
                // 
            }
        });

        cardGrid.setBackgroundPanel(new ImagePanel(
          ImageIO.read(
            RootPanel.class.getResourceAsStream(
              "/hci400assignment/resources/dark-bg.png"
            )
          ),
          ImagePanel.Mode.TILE
        ));
        cardGrid.setCardWidthMin(cardWidthMin);

        contentRootPanel.add(cardGrid, java.awt.BorderLayout.CENTER);

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

        navToolBar = new javax.swing.JToolBar();
        navHomeButton = new javax.swing.JButton();
        navFriendsButton = new javax.swing.JButton();
        navSearchButton = new javax.swing.JButton();
        navAboutButton = new javax.swing.JButton();
        navAboutButton1 = new javax.swing.JButton();
        contentRootPanel = new javax.swing.JPanel();
        controlsBar1 = new hci400assignment.gui.ControlBar();

        setLayout(new java.awt.BorderLayout());

        navToolBar.setRollover(true);

        navHomeButton.setText("Home");
        navHomeButton.setFocusable(false);
        navHomeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navHomeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToolBar.add(navHomeButton);

        navFriendsButton.setText("Friends");
        navFriendsButton.setToolTipText("");
        navFriendsButton.setFocusable(false);
        navFriendsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navFriendsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToolBar.add(navFriendsButton);

        navSearchButton.setText("Search");
        navSearchButton.setFocusable(false);
        navSearchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navSearchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToolBar.add(navSearchButton);

        navAboutButton.setText("About");
        navAboutButton.setFocusable(false);
        navAboutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navAboutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navAboutButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                navAboutButtonActionPerformed(evt);
            }
        });
        navToolBar.add(navAboutButton);

        navAboutButton1.setText("Test FocusView");
        navAboutButton1.setFocusable(false);
        navAboutButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navAboutButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navAboutButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                navAboutButton1ActionPerformed(evt);
            }
        });
        navToolBar.add(navAboutButton1);

        add(navToolBar, java.awt.BorderLayout.NORTH);

        contentRootPanel.setLayout(new java.awt.BorderLayout());
        add(contentRootPanel, java.awt.BorderLayout.CENTER);
        add(controlsBar1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void navAboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navAboutButtonActionPerformed
        ApplicationCore.getInstance().showAboutWindow();
    }//GEN-LAST:event_navAboutButtonActionPerformed

    private void navAboutButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navAboutButton1ActionPerformed
        ApplicationCore.getInstance().showFocusView();
    }//GEN-LAST:event_navAboutButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentRootPanel;
    private hci400assignment.gui.ControlBar controlsBar1;
    private javax.swing.JButton navAboutButton;
    private javax.swing.JButton navAboutButton1;
    private javax.swing.JButton navFriendsButton;
    private javax.swing.JButton navHomeButton;
    private javax.swing.JButton navSearchButton;
    private javax.swing.JToolBar navToolBar;
    // End of variables declaration//GEN-END:variables
}
