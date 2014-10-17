
/*
 * AboutBox.java
 *
 * Created on 15/10/2014, 2:52:14 PM
 */
package hci400assignment;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 16152939
 */
public class AboutBox extends javax.swing.JPanel
{
    /**
     * Creates new form AboutBox
     */
    public AboutBox()
    {
        initComponents();

//        ImageIcon icon =  (ImageIcon)jLabel1.getIcon();
//
        System.out.println(jLabel1.getWidth() + " " + jLabel1.getHeight());

//        Image i = icon.getImage().getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(),0);
//        icon.setImage(i);
//        jLabel1.setIcon(icon);
        //Get icon from label.
        //Turn it into image: icon.getScaledInstance
        //Set icon to label(image).
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

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new FancyLabel();

        setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Close");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(jButton1, gridBagConstraints);

        jLabel3.setText("<html>\n<center> This Program is a product of Team Placeholder<br>\nCreated in mid 2014. </center>\n\n<img src=\"file:/home/16142600/hci400/assignment/build/classes/hci400assignment/resources/curtin-logo.jpg\"></img>\n\n</html>");
        jLabel3.setName("jLabel3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(jLabel3, gridBagConstraints);

        jLabel2.setText("About Placeholder");
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabel1.setBackground(new java.awt.Color(225, 144, 64));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hci400assignment/resources/about.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        ApplicationCore.getInstance().hideAboutWindow();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
/*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    public static class FancyLabel
      extends JLabel
      implements ComponentListener
    {
        public FancyLabel()
        {
            super();

            addComponentListener(this);
        }

        public void componentResized(ComponentEvent e)
        {

            ImageIcon icon = (ImageIcon)getIcon();

            System.out.println(getWidth() + " " + getHeight());
            Image i = (new javax.swing.ImageIcon(getClass().getResource(
              "/hci400assignment/resources/about.png"))).getImage().
              getScaledInstance(getWidth(), getHeight(), 0);
            icon.setImage(i);
            setIcon(icon);
            repaint();
        }

        public void componentMoved(ComponentEvent e)
        {
            //
        }

        public void componentShown(ComponentEvent e)
        {
            //
        }

        public void componentHidden(ComponentEvent e)
        {
            //
        }
    }
}
