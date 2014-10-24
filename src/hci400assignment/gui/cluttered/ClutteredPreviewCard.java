/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui.cluttered;

import hci400assignment.ApplicationCore;
import hci400assignment.gui.Card;
import hci400assignment.gui.CardFactory;
import hci400assignment.gui.GUIUtil;
import hci400assignment.gui.ImagePanel;
import hci400assignment.gui.ItemCard;
import hci400assignment.model.Item;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 *
 * @author 16142600
 */
public class ClutteredPreviewCard
  extends ItemCard
{

    private double imageHeightPc;

    public ClutteredPreviewCard(Item itemIn)
    {
        super();

        initComponents();

        articleImagePanel.setMode(ImagePanel.Mode.FIT_MAX);

        Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        articleImagePanel.setCursor(handCursor);
        articleTitleLabel.setCursor(handCursor);

        setItem(itemIn);
    }

    @Override
    protected void updateContent()
    {
        URL previewImageURL = item.getPreviewImageURL();
        if(previewImageURL != null) {
            articleImagePanel.setImage(previewImageURL);
        } else {
            Image previewImage = item.getPreviewImage();
            if(previewImage != null) {
                articleImagePanel.setImage(previewImage);
            }
        }
        articleTitleLabel.setText(item.getPreviewTitle());
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        ApplicationCore.getInstance().focusItem(item);
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
        java.awt.GridBagConstraints gridBagConstraints;

        articleImagePanel = new hci400assignment.gui.ImagePanel();
        articleTitlePanel = new javax.swing.JPanel();
        articleTitleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(81, 81, 81));
        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 34, 34)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51))));
        setName("minimal_preview"); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        articleImagePanel.setName("minimal_preview_image"); // NOI18N
        articleImagePanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                articleImagePanelMouseClicked(evt);
            }
        });
        articleImagePanel.setLayout(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        add(articleImagePanel, gridBagConstraints);

        articleTitlePanel.setBackground(new java.awt.Color(42, 42, 42));
        articleTitlePanel.setName("minimal_preview_title_bg"); // NOI18N
        articleTitlePanel.setLayout(new java.awt.GridBagLayout());

        articleTitleLabel.setBackground(new java.awt.Color(46, 46, 46));
        articleTitleLabel.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        articleTitleLabel.setForeground(new java.awt.Color(204, 204, 204));
        articleTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        articleTitleLabel.setText("<html>Title");
        articleTitleLabel.setToolTipText("");
        articleTitleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        articleTitleLabel.setName("minimal_preview_title"); // NOI18N
        articleTitleLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                articleTitleLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 4, 12);
        articleTitlePanel.add(articleTitleLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(articleTitlePanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void articleTitleLabelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_articleTitleLabelMouseClicked
    {//GEN-HEADEREND:event_articleTitleLabelMouseClicked
        ApplicationCore.getInstance().focusItem(item);
    }//GEN-LAST:event_articleTitleLabelMouseClicked

    private void articleImagePanelMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_articleImagePanelMouseClicked
    {//GEN-HEADEREND:event_articleImagePanelMouseClicked
        ApplicationCore.getInstance().focusItem(item);
    }//GEN-LAST:event_articleImagePanelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hci400assignment.gui.ImagePanel articleImagePanel;
    private javax.swing.JLabel articleTitleLabel;
    private javax.swing.JPanel articleTitlePanel;
    // End of variables declaration//GEN-END:variables

    public static class Factory implements CardFactory
    {
        @Override
        public Card construct(Object content)
        {
            Item item = (Item)content;
            return new ClutteredPreviewCard(item);
        }
    }

}
