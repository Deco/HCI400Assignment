/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import hci400assignment.ApplicationCore;
import hci400assignment.gui.ArticleCard;
import hci400assignment.gui.Card;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Deco
 */
public class RootPanel extends javax.swing.JPanel
{

    private List<ArticleCard> articleCardList;
    private final CardGrid cardGrid;

    /**
     * Creates new form RootPanel
     */
    public RootPanel() throws IOException
    {
        initComponents();

        articleCardList = new ArrayList<ArticleCard>();

        double aspectRatio = 0.74;
        double imageHeightPc = 0.61;
        int cardWidthMin = 346;
        for(int i = 0; i < 40; i++) {
            ArticleCard c = new ArticleCard(aspectRatio, imageHeightPc);
            articleCardList.add(c);
        }

        final List<ArticleCard> modelCardList = articleCardList;
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
              "/hci400assignment/resources/bg.png"
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
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        contentRootPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        navHomeButton = new javax.swing.JButton();
        navFriendsButton = new javax.swing.JButton();
        navSearchButton = new javax.swing.JButton();
        navAboutButton = new javax.swing.JButton();
        navAboutButton1 = new javax.swing.JButton();
        navFacebookButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        controlsBar1 = new hci400assignment.gui.ControlBar();

        setLayout(new java.awt.BorderLayout());

        contentRootPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        navHomeButton.setText("Home");
        navHomeButton.setFocusable(false);
        navHomeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navHomeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(navHomeButton, gridBagConstraints);

        navFriendsButton.setText("Friends");
        navFriendsButton.setToolTipText("");
        navFriendsButton.setFocusable(false);
        navFriendsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navFriendsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(navFriendsButton, gridBagConstraints);

        navSearchButton.setText("Search");
        navSearchButton.setFocusable(false);
        navSearchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navSearchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(navSearchButton, gridBagConstraints);

        navAboutButton.setText("About");
        navAboutButton.setFocusable(false);
        navAboutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navAboutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navAboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navAboutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(navAboutButton, gridBagConstraints);

        navAboutButton1.setText("Test FocusView");
        navAboutButton1.setFocusable(false);
        navAboutButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navAboutButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navAboutButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navAboutButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navAboutButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(navAboutButton1, gridBagConstraints);

        navFacebookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hci400assignment/resources/SmallFB.png"))); // NOI18N
        navFacebookButton.setFocusable(false);
        navFacebookButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navFacebookButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navFacebookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navFacebookButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(navFacebookButton, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hci400assignment/resources/SmallTwitter.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanel1.add(jButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jButton2, gridBagConstraints);

        contentRootPanel.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        add(contentRootPanel, java.awt.BorderLayout.CENTER);
        add(controlsBar1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void navAboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navAboutButtonActionPerformed
        ApplicationCore.getInstance().showAboutWindow();
    }//GEN-LAST:event_navAboutButtonActionPerformed

    private void navAboutButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navAboutButton1ActionPerformed
       ApplicationCore.getInstance().showFocusView();
    }//GEN-LAST:event_navAboutButton1ActionPerformed

    private void navFacebookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navFacebookButtonActionPerformed
       try {
           String URL = "https://www.facebook.com/";
           java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
       }
       catch(Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }


    }//GEN-LAST:event_navFacebookButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
           String URL = "https://www.twitter.com/";
           java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
       }
       catch(Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentRootPanel;
    private hci400assignment.gui.ControlBar controlsBar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton navAboutButton;
    private javax.swing.JButton navAboutButton1;
    private javax.swing.JButton navFacebookButton;
    private javax.swing.JButton navFriendsButton;
    private javax.swing.JButton navHomeButton;
    private javax.swing.JButton navSearchButton;
    // End of variables declaration//GEN-END:variables
}
