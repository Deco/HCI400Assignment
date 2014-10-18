/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */

/*
 * ArticleCard.java
 *
 * Created on 15/10/2014, 4:36:46 PM
 */
package hci400assignment.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author 16142600
 */
public class ArticleCard
  extends Card
  implements ComponentListener
{
    private double aspectRatio;
    private double imageHeightPc;

    /**
     * Creates new form ArticleCard
     */
    public ArticleCard(double aspectRatioIn, double imageHeightPcIn)
    {
        initComponents();
        
        setMinimumSize(new Dimension(20, 20));
        
        setPreferredSize(new Dimension(20, 20));
        
        setImageHeightPc(imageHeightPcIn);
        setAspectRatio(aspectRatioIn);
        
        this.addComponentListener(this);
        
        articleImage.setMode(ImagePanel.Mode.FIT_MIN);
        try {
            articleImage.setImage(ImageIO.read(
              ArticleCard.class.getResourceAsStream(
                "/hci400assignment/resources/curtin-logo.jpg"
              )
            ));
        } catch(IOException ex) {
            System.err.println("meow");
            System.exit(-1);
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
        java.awt.GridBagConstraints gridBagConstraints;

        articleImage = new hci400assignment.gui.ImagePanel();
        articleText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(81, 81, 81));
        setLayout(new java.awt.GridBagLayout());

        articleImage.setName("articleImage"); // NOI18N
        articleImage.setLayout(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(articleImage, gridBagConstraints);

        articleText.setBackground(new java.awt.Color(51, 51, 51));
        articleText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        articleText.setForeground(new java.awt.Color(204, 204, 204));
        articleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        articleText.setText("Text Text Text Text Text Text Text Text");
        articleText.setName("articleText"); // NOI18N
        articleText.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(articleText, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hci400assignment.gui.ImagePanel articleImage;
    private javax.swing.JLabel articleText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentResized(ComponentEvent e)
    {
        if(getParent() != null) {
            Dimension size = getSize();
            Dimension preferredSize = getPreferredSize();
            Dimension newSize = new Dimension(
              preferredSize.width,
              (int)((double)size.width / aspectRatio)
            );
            setPreferredSize(newSize);

            Util.revalidate(getParent());
        }
    }
    
    @Override
    public void componentMoved(ComponentEvent e)
    {
        // 
    }
    
    @Override
    public void componentShown(ComponentEvent e)
    {
        // 
    }
    
    @Override
    public void componentHidden(ComponentEvent e)
    {
        // 
    }
    
    public double getAspectRatio()
    {
        return aspectRatio;
    }
    
    public void setAspectRatio(double aspectRatioIn)
    {
        aspectRatio = aspectRatioIn;
        componentResized(null);
    }
    
    public double getImageHeightPc()
    {
        return imageHeightPc;
    }
    
    public void setImageHeightPc(double imageHeightPcIn)
    {
        imageHeightPc = imageHeightPcIn;
        
        GridBagLayout layout = (GridBagLayout)getLayout();
        GridBagConstraints constraints = layout.getConstraints(articleImage);
        remove(articleImage);
        constraints.weighty = imageHeightPc;
        add(articleImage, constraints);
        
        constraints = layout.getConstraints(articleText);
        remove(articleText);
        constraints.weighty = 1.0 - imageHeightPc;
        add(articleText, constraints);
        
        revalidate();
    }
    
}