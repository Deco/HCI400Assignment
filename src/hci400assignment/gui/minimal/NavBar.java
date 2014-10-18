/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui.minimal;

import hci400assignment.ApplicationCore;
import javax.swing.JOptionPane;

/**
 *
 * @author Declan White
 */
public class NavBar extends javax.swing.JPanel
{

    /**
     * Creates new form NavBar
     */
    public NavBar()
    {
        initComponents();
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

        navHomeButton = new javax.swing.JButton();
        navFriendsButton = new javax.swing.JButton();
        navSearchButton = new javax.swing.JButton();
        navAboutButton = new javax.swing.JButton();
        navAboutButton1 = new javax.swing.JButton();
        navFacebookButton = new javax.swing.JButton();
        navTwitterButton = new javax.swing.JButton();
        navRSSButton = new javax.swing.JButton();
        gapPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        navHomeButton.setText("Home");
        navHomeButton.setFocusable(false);
        navHomeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navHomeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        add(navHomeButton, gridBagConstraints);

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
        gridBagConstraints.weighty = 1.0;
        add(navFriendsButton, gridBagConstraints);

        navSearchButton.setText("Search");
        navSearchButton.setFocusable(false);
        navSearchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navSearchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        add(navSearchButton, gridBagConstraints);

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
        gridBagConstraints.weighty = 1.0;
        add(navAboutButton, gridBagConstraints);

        navAboutButton1.setText("Test FocusView");
        navAboutButton1.setFocusable(false);
        navAboutButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        gridBagConstraints.weighty = 1.0;
        add(navAboutButton1, gridBagConstraints);

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
        gridBagConstraints.weighty = 1.0;
        add(navFacebookButton, gridBagConstraints);

        navTwitterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hci400assignment/resources/SmallTwitter.png"))); // NOI18N
        navTwitterButton.setFocusable(false);
        navTwitterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navTwitterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navTwitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navTwitterButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 1.0;
        add(navTwitterButton, gridBagConstraints);

        navRSSButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hci400assignment/resources/SmallRSS.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(navRSSButton, gridBagConstraints);

        javax.swing.GroupLayout gapPanelLayout = new javax.swing.GroupLayout(gapPanel);
        gapPanel.setLayout(gapPanelLayout);
        gapPanelLayout.setHorizontalGroup(
            gapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gapPanelLayout.setVerticalGroup(
            gapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(gapPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void navAboutButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_navAboutButtonActionPerformed
    {//GEN-HEADEREND:event_navAboutButtonActionPerformed
        ApplicationCore.getInstance().showAboutWindow();
    }//GEN-LAST:event_navAboutButtonActionPerformed

    private void navAboutButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_navAboutButton1ActionPerformed
    {//GEN-HEADEREND:event_navAboutButton1ActionPerformed
        ApplicationCore.getInstance().showFocusView();
    }//GEN-LAST:event_navAboutButton1ActionPerformed

    private void navFacebookButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_navFacebookButtonActionPerformed
    {//GEN-HEADEREND:event_navFacebookButtonActionPerformed
        try
        {
            String URL = "https://www.facebook.com/";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_navFacebookButtonActionPerformed

    private void navTwitterButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_navTwitterButtonActionPerformed
    {//GEN-HEADEREND:event_navTwitterButtonActionPerformed
        try
        {
            String URL = "https://www.twitter.com/";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_navTwitterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gapPanel;
    private javax.swing.JButton navAboutButton;
    private javax.swing.JButton navAboutButton1;
    private javax.swing.JButton navFacebookButton;
    private javax.swing.JButton navFriendsButton;
    private javax.swing.JButton navHomeButton;
    private javax.swing.JButton navRSSButton;
    private javax.swing.JButton navSearchButton;
    private javax.swing.JButton navTwitterButton;
    // End of variables declaration//GEN-END:variables
}
