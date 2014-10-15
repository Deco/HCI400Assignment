/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RootPanel.java
 *
 * Created on 15/10/2014, 2:33:31 PM
 */
package hci400assignment;

import org.jdesktop.application.Action;

/**
 *
 * @author 16142600
 */
public class RootPanel extends javax.swing.JPanel
{

    /** Creates new form RootPanel */
    public RootPanel()
    {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        articleCard1 = new hci400assignment.ArticleCard();
        articleCard2 = new hci400assignment.ArticleCard();
        articleCard3 = new hci400assignment.ArticleCard();
        navToolBar = new javax.swing.JToolBar();
        navHomeButton = new javax.swing.JButton();
        navFriendsButton = new javax.swing.JButton();
        navSearchButton = new javax.swing.JButton();
        navAboutButton = new javax.swing.JButton();
        contentRootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        articleCard1.setName("articleCard1"); // NOI18N

        javax.swing.GroupLayout articleCard1Layout = new javax.swing.GroupLayout(articleCard1);
        articleCard1.setLayout(articleCard1Layout);
        articleCard1Layout.setHorizontalGroup(
            articleCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        articleCard1Layout.setVerticalGroup(
            articleCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        articleCard2.setName("articleCard2"); // NOI18N

        javax.swing.GroupLayout articleCard2Layout = new javax.swing.GroupLayout(articleCard2);
        articleCard2.setLayout(articleCard2Layout);
        articleCard2Layout.setHorizontalGroup(
            articleCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );
        articleCard2Layout.setVerticalGroup(
            articleCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        articleCard3.setName("articleCard3"); // NOI18N

        javax.swing.GroupLayout articleCard3Layout = new javax.swing.GroupLayout(articleCard3);
        articleCard3.setLayout(articleCard3Layout);
        articleCard3Layout.setHorizontalGroup(
            articleCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        articleCard3Layout.setVerticalGroup(
            articleCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        navToolBar.setRollover(true);
        navToolBar.setName("navToolBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(RootPanel.class);
        navHomeButton.setText(resourceMap.getString("navHomeButton.text")); // NOI18N
        navHomeButton.setFocusable(false);
        navHomeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navHomeButton.setName("navHomeButton"); // NOI18N
        navHomeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToolBar.add(navHomeButton);

        navFriendsButton.setText(resourceMap.getString("navFriendsButton.text")); // NOI18N
        navFriendsButton.setName("navFriendsButton"); // NOI18N
        navToolBar.add(navFriendsButton);

        navSearchButton.setText(resourceMap.getString("navSearchButton.text")); // NOI18N
        navSearchButton.setFocusable(false);
        navSearchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navSearchButton.setName("navSearchButton"); // NOI18N
        navSearchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToolBar.add(navSearchButton);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(RootPanel.class, this);
        navAboutButton.setAction(actionMap.get("navAboutButtonPressed")); // NOI18N
        navAboutButton.setText(resourceMap.getString("navAboutButton.text")); // NOI18N
        navAboutButton.setFocusable(false);
        navAboutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navAboutButton.setName("navAboutButton"); // NOI18N
        navAboutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navToolBar.add(navAboutButton);

        add(navToolBar, java.awt.BorderLayout.NORTH);

        contentRootPanel.setName("contentRootPanel"); // NOI18N
        contentRootPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(0, 3));

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel1.add(jLabel4);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        jPanel1.add(jLabel5);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        jPanel1.add(jLabel6);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        jPanel1.add(jLabel7);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        jPanel1.add(jLabel8);

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        jPanel1.add(jLabel9);

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N
        jPanel1.add(jLabel10);

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N
        jPanel1.add(jLabel11);

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N
        jPanel1.add(jLabel12);

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N
        jPanel1.add(jLabel13);

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N
        jPanel1.add(jLabel14);

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N
        jPanel1.add(jLabel15);

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N
        jPanel1.add(jLabel16);

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N
        jPanel1.add(jLabel17);

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N
        jPanel1.add(jLabel18);

        jScrollPane1.setViewportView(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        contentRootPanel.add(jScrollPane1, gridBagConstraints);

        add(contentRootPanel, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        add(jToolBar1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void navAboutButtonPressed()
    {
        ApplicationCore.getInstance().showAboutWindow();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hci400assignment.ArticleCard articleCard1;
    private hci400assignment.ArticleCard articleCard2;
    private hci400assignment.ArticleCard articleCard3;
    private javax.swing.JPanel contentRootPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton navAboutButton;
    private javax.swing.JButton navFriendsButton;
    private javax.swing.JButton navHomeButton;
    private javax.swing.JButton navSearchButton;
    private javax.swing.JToolBar navToolBar;
    // End of variables declaration//GEN-END:variables
}
