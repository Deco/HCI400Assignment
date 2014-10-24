/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui.cluttered;

import hci400assignment.ApplicationCore;
import hci400assignment.gui.HintTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Declan White
 */
public class ClutteredSearchPanel
  extends javax.swing.JPanel
{

    /**
     * Creates new form SearchPanel
     */
    public ClutteredSearchPanel()
    {
        initComponents();
        ((HintTextField)searchTextField).setHintText("Enter search text...");
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

        leftPaddingPanel = new javax.swing.JPanel();
        searchTextField = new HintTextField();
        rightPaddingPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout leftPaddingPanelLayout = new javax.swing.GroupLayout(leftPaddingPanel);
        leftPaddingPanel.setLayout(leftPaddingPanelLayout);
        leftPaddingPanelLayout.setHorizontalGroup(
            leftPaddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        leftPaddingPanelLayout.setVerticalGroup(
            leftPaddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(leftPaddingPanel, gridBagConstraints);

        searchTextField.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTextField.setMaximumSize(new java.awt.Dimension(600, 50));
        searchTextField.setMinimumSize(new java.awt.Dimension(250, 19));
        searchTextField.setPreferredSize(new java.awt.Dimension(600, 30));
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                searchTextFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 10, 25);
        add(searchTextField, gridBagConstraints);

        javax.swing.GroupLayout rightPaddingPanelLayout = new javax.swing.GroupLayout(rightPaddingPanel);
        rightPaddingPanel.setLayout(rightPaddingPanelLayout);
        rightPaddingPanelLayout.setHorizontalGroup(
            rightPaddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rightPaddingPanelLayout.setVerticalGroup(
            rightPaddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(rightPaddingPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_searchTextFieldKeyTyped
    {//GEN-HEADEREND:event_searchTextFieldKeyTyped
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                String text = searchTextField.getText();
//                System.out.println(text);
                ApplicationCore.getInstance().setSearchText(text);
            }
        });
    }//GEN-LAST:event_searchTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel leftPaddingPanel;
    private javax.swing.JPanel rightPaddingPanel;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
