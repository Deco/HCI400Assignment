/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */

/*
 * ArticleCard.java
 *
 * Created on 15/10/2014, 4:36:46 PM
 */
package hci400assignment.gui.cluttered;

import hci400assignment.gui.Card;
import hci400assignment.model.Item;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author 16142600
 */
public class PreviewCard
  extends Card
{
    public static final double DEFAULT_IMAGE_HEIGHT_PC = 0.61;

    private Item item;

    private double imageHeightPc;

    public PreviewCard(Item itemIn)
    {
        super();

        initComponents();

        setItem(itemIn);

        setImageHeightPc(DEFAULT_IMAGE_HEIGHT_PC);
    }

    private void updateContent()
    {
        articleImagePanel.setImage(item.getPreviewImage());
        articleSnippetLabel.setText(item.getPreviewText());
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
        updateContent();
    }

    public double getImageHeightPc()
    {
        return imageHeightPc;
    }

    public void setImageHeightPc(double imageHeightPcIn)
    {
        imageHeightPc = imageHeightPcIn;

        GridBagLayout layout = (GridBagLayout)getLayout();
        GridBagConstraints constraints = layout.
          getConstraints(articleImagePanel);
        remove(articleImagePanel);
        constraints.weighty = imageHeightPc;
        add(articleImagePanel, constraints);

        constraints = layout.getConstraints(articleSnippetLabel);
        remove(articleSnippetLabel);
        constraints.weighty = 1.0 - imageHeightPc;
        add(articleSnippetLabel, constraints);

        revalidate();
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
        articleSnippetLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(81, 81, 81));
        setLayout(new java.awt.GridBagLayout());

        articleImagePanel.setName("articleImagePanel"); // NOI18N
        articleImagePanel.setLayout(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(articleImagePanel, gridBagConstraints);

        articleSnippetLabel.setBackground(new java.awt.Color(51, 51, 51));
        articleSnippetLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        articleSnippetLabel.setForeground(new java.awt.Color(204, 204, 204));
        articleSnippetLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        articleSnippetLabel.setText("Text Text Text Text Text Text Text Text");
        articleSnippetLabel.setName("articleSnippetLabel"); // NOI18N
        articleSnippetLabel.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(articleSnippetLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hci400assignment.gui.ImagePanel articleImagePanel;
    private javax.swing.JLabel articleSnippetLabel;
    // End of variables declaration//GEN-END:variables

}
