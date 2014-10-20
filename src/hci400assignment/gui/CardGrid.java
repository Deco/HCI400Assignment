/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Declan White
 */
public class CardGrid
  extends javax.swing.JPanel
  implements ListDataListener, ComponentListener
{
    private ListModel model;
    private CardFactory cardFactory;
    private int cardWidthMin = 400;
    private int cardInset = 22;
    private boolean shouldCardsGrow = false;

    private final JPanel tailVoidPanel = new VoidPanel();
    private int columnCount;

    /**
     * Creates new form CardGrid
     */
    public CardGrid(ListModel modelIn, CardFactory cardFactoryIn)
    {
        initComponents();

        gridScrollPane.getVerticalScrollBar().setUnitIncrement(24);

        cardFactory = cardFactoryIn;
        setModel(modelIn);

        this.addComponentListener(this);
    }

    private int calculateColumnCount()
    {
        int viewportWidth = gridScrollPane.getViewport().getSize().width;
        int count = viewportWidth / (cardWidthMin + 2 * cardInset);
        return Math.max(1, count);
    }

    private int calculateInset()
    {
//
//        if(shouldCardsGrow) {
//            return cardInset;
//        } else {
//            double fullCellWidth = getWidth() / columnCount;
//            double cardWidth = cardWidthMin;
//            double inset = (fullCellWidth - cardWidth) / 2.0;
//            System.out.println("III: " + inset);
//            return (int)inset;
//        }
        return cardInset;
    }

    private void populateGrid()
    {
        gridContentPanel.removeAll();

        columnCount = 1;
        int rowCount = 0;
        GridBagConstraints constraints = new GridBagConstraints();

        if(model != null) {
            constraints.weightx = 1.0;
            constraints.weighty = 0.0;
            if(shouldCardsGrow) {
                constraints.fill = GridBagConstraints.HORIZONTAL;
            } else {
                constraints.fill = GridBagConstraints.NONE;
            }
            constraints.anchor = GridBagConstraints.CENTER;

            int cardCount = model.getSize();
            columnCount = calculateColumnCount();
            rowCount = (int)Math.ceil((double)cardCount / columnCount);

            int inset = calculateInset();
            constraints.insets = new Insets(
              inset, // top
              inset, // left
              inset, // bottom
              inset// right
            );

            for(int cardI = 0; cardI < cardCount; cardI++) {
                Object cardContent = model.getElementAt(cardI);
                Card card = cardFactory.construct(cardContent);

                if(!shouldCardsGrow) {
                    Dimension cardPreferredSize = card.getPreferredSize();
                    Dimension cardNewSize = new Dimension(
                      cardWidthMin,
                      cardPreferredSize.height
                    );
                    card.setPreferredSize(cardNewSize);
                    card.setSize(cardNewSize);
                }

                constraints.gridx = cardI % columnCount;
                constraints.gridy = cardI / columnCount;

                gridContentPanel.add(card, constraints);
            }
        }
        constraints.gridy = rowCount;
        constraints.gridx = 0;
        constraints.gridwidth = columnCount;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(0, 0, 0, 0);
        gridContentPanel.add(tailVoidPanel, constraints);

        revalidate();
    }

    @Override
    public void contentsChanged(ListDataEvent ev)
    {
        populateGrid();
    }

    @Override
    public void intervalAdded(ListDataEvent ev)
    {
        contentsChanged(ev);
    }

    @Override
    public void intervalRemoved(ListDataEvent ev)
    {
        contentsChanged(ev);
    }

    @Override
    public void componentResized(ComponentEvent ce)
    {
        int newColumnCount = calculateColumnCount();
        if(columnCount != newColumnCount) {
            populateGrid();
        }
    }

    @Override
    public void componentMoved(ComponentEvent ce)
    {
        // 
    }

    @Override
    public void componentShown(ComponentEvent ce)
    {
        // 
    }

    @Override
    public void componentHidden(ComponentEvent ce)
    {
        // 
    }

    public ListModel getModel()
    {
        return model;
    }

    public void setModel(ListModel model)
    {
        this.model = model;
        populateGrid();
    }

    public int getCardWidthMin()
    {
        return cardWidthMin;
    }

    public void setCardWidthMin(int cardWidthMin)
    {
        this.cardWidthMin = cardWidthMin;
        populateGrid();
    }

    public int getCardInset()
    {
        return cardInset;
    }

    public void setCardInset(int cardInset)
    {
        this.cardInset = cardInset;
        populateGrid();
    }

    public JPanel getBackgroundPanel()
    {
        return backgroundPanel;
    }

    public void setBackgroundPanel(JPanel backgroundPanelIn)
    {
        if(backgroundPanel != null) {
            gridViewPanel.remove(backgroundPanel);
        }
        backgroundPanel = backgroundPanelIn;
        if(backgroundPanel != null) {
            gridViewPanel.add(backgroundPanel);
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

        gridScrollPane = new javax.swing.JScrollPane();
        gridViewPanel = new javax.swing.JPanel();
        gridContentPanel = new VoidPanel();
        backgroundPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        gridScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gridScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gridViewPanel.setLayout(new javax.swing.OverlayLayout(gridViewPanel));

        gridContentPanel.setOpaque(false);
        gridContentPanel.setLayout(new java.awt.GridBagLayout());
        gridViewPanel.add(gridContentPanel);

        backgroundPanel.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridViewPanel.add(backgroundPanel);

        gridScrollPane.setViewportView(gridViewPanel);

        add(gridScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel gridContentPanel;
    private javax.swing.JScrollPane gridScrollPane;
    private javax.swing.JPanel gridViewPanel;
    // End of variables declaration//GEN-END:variables

    private class VoidPanel
      extends JPanel
    {

        @Override
        protected void paintComponent(Graphics g)
        {
            //super.paintComponent(g);
        }

    }

}
