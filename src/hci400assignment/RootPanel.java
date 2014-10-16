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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdesktop.application.Action;

/**
 *
 * @author 16142600
 */
public class RootPanel extends javax.swing.JPanel
{

    /** Creates new form RootPanel */
    public RootPanel() throws IOException
    {
        initComponents();

        ((ImagePanel)contentPanel).setImage(ImageIO.read(
          RootPanel.class.getResourceAsStream(
          "/hci400assignment/resources/bg.png")));

        GridBagLayout innerLayout = (GridBagLayout)contentPanel.getLayout();
        GridBagConstraints innerConstraints = new GridBagConstraints();
        //contentPanel.setBackground(new Color(0, 220, 250));
        int max = 4;

        int inset = 20;
        innerConstraints.insets = new Insets(inset, inset, inset, inset);

        for(int i = 0; i < max; i++) {

            //innerConstraints.gridx = 0;
            innerConstraints.gridy = i + 1;
            innerConstraints.weightx = 1.0;
            innerConstraints.weighty = 0.0;
            innerConstraints.fill = GridBagConstraints.HORIZONTAL;
            innerConstraints.anchor = GridBagConstraints.NORTHWEST;

            innerConstraints.gridx = 0;
            ArticleCard c1 = new ArticleCard();
            innerLayout.setConstraints(c1, innerConstraints);
            contentPanel.add(c1);

            innerConstraints.gridx = 1;
            ArticleCard c2 = new ArticleCard();
            innerLayout.setConstraints(c2, innerConstraints);
            contentPanel.add(c2);

            innerConstraints.gridx = 2;
            ArticleCard c3 = new ArticleCard();
            innerLayout.setConstraints(c3, innerConstraints);
            contentPanel.add(c3);

        }

        JPanel innerVoidPanel = new JPanel()
        {

            @Override
            protected void paintComponent(Graphics g)
            {
                //super.paintComponent(g);
            }
        };
        //innerVoidPanel.setBackground(new Color(0, 250, 250));
        innerConstraints.gridy = max + 1;
        innerConstraints.gridx = 0;
        innerConstraints.gridwidth = 3;
        innerConstraints.weighty = 1.0;
        innerConstraints.fill = GridBagConstraints.BOTH;
        innerLayout.setConstraints(innerVoidPanel, innerConstraints);
        contentPanel.add(innerVoidPanel);

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
        contentScrollPane = new javax.swing.JScrollPane();
        contentPanel = new ImagePanel();
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
        contentRootPanel.setLayout(new java.awt.BorderLayout());

        contentScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentScrollPane.setName("contentScrollPane"); // NOI18N

        contentPanel.setName("contentPanel"); // NOI18N
        contentPanel.setLayout(new java.awt.GridBagLayout());
        contentScrollPane.setViewportView(contentPanel);

        contentRootPanel.add(contentScrollPane, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentRootPanel;
    private javax.swing.JScrollPane contentScrollPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton navAboutButton;
    private javax.swing.JButton navFriendsButton;
    private javax.swing.JButton navHomeButton;
    private javax.swing.JButton navSearchButton;
    private javax.swing.JToolBar navToolBar;
    // End of variables declaration//GEN-END:variables
}
