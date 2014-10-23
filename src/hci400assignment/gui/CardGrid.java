/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import hci400assignment.model.Item;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private int currentColumnCount;
    private Map<Object, Card> itemCardMap;

    /**
     * Creates new form CardGrid
     */
    public CardGrid(ListModel modelIn, CardFactory cardFactoryIn)
    {
        initComponents();

        gridScrollPane.getVerticalScrollBar().setUnitIncrement(24);

        cardFactory = cardFactoryIn;

        currentColumnCount = calculateColumnCount();

        itemCardMap = new HashMap<Object, Card>();

        setModel(modelIn);

        this.addComponentListener(this);
    }

    private int calculateColumnCount()
    {
        int viewportWidth = gridScrollPane.getViewport().getSize().width;
        int count = viewportWidth / (cardWidthMin + 2 * cardInset);
        return Math.max(1, count);
    }

    private int calculateRowCount()
    {
        return (int)Math.ceil((double)model.getSize() / currentColumnCount);
    }

    private int calculateInset()
    {
        return cardInset;
    }

    private void recreateCards()
    {
        itemCardMap.clear();
        relayoutCards(0);
    }

    private void relayoutCards(int startIndex)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.weightx = 1.0;
        constraints.weighty = 0.0;
        if(shouldCardsGrow) {
            constraints.fill = GridBagConstraints.HORIZONTAL;
        } else {
            constraints.fill = GridBagConstraints.NONE;
        }
        constraints.anchor = GridBagConstraints.CENTER;

        int inset = calculateInset();
        constraints.insets = new Insets(
          inset, // top
          inset, // left
          inset, // bottom
          inset // right
          );

        Set<Object> absentItemSet = new HashSet<Object>(itemCardMap.keySet());
        
        for(int itemI = startIndex; itemI < model.getSize(); itemI++) {
            Object item = model.getElementAt(itemI);
            Card card = itemCardMap.get(item);
            if(card == null) {
                card = cardFactory.construct(item);
                itemCardMap.put(item, card);
            } else {
                gridContentPanel.remove(card);
            }
            absentItemSet.remove(item);

            if(!shouldCardsGrow) {
                Dimension cardPreferredSize = card.getPreferredSize();
                Dimension cardNewSize = new Dimension(
                  cardWidthMin,
                  cardPreferredSize.height);
                card.setPreferredSize(cardNewSize);
                card.setSize(cardNewSize);
            }

            constraints.gridx = itemI % currentColumnCount;
            constraints.gridy = itemI / currentColumnCount;

            gridContentPanel.add(card, constraints);
            
            card.relayout();
        }
        for(Object item : absentItemSet) {
            itemCardMap.remove(item);
        }

        GUIUtil.revalidate(this);
        relayoutVoidPanel();
    }

    private void relayoutVoidPanel()
    {
        int rowCount = calculateRowCount();

        gridContentPanel.remove(tailVoidPanel);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = rowCount;
        constraints.gridx = 0;
        constraints.gridwidth = currentColumnCount;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(0, 0, 0, 0);
        gridContentPanel.add(tailVoidPanel, constraints);

        GUIUtil.revalidate(this);
    }

    @Override
    public void contentsChanged(ListDataEvent ev)
    {
        relayoutCards(0);
    }

    @Override
    public void intervalAdded(ListDataEvent ev)
    {
        relayoutCards(ev.getIndex0());
    }

    @Override
    public void intervalRemoved(ListDataEvent ev)
    {
        relayoutCards(ev.getIndex0());
    }

    @Override
    public void componentResized(ComponentEvent ce)
    {
        int newColumnCount = calculateColumnCount();
        System.out.println("CCC: " + currentColumnCount + " -> "
          + newColumnCount);
        if(currentColumnCount != newColumnCount) {
            currentColumnCount = newColumnCount;
            relayoutCards(0);
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

    public void setModel(ListModel modelIn)
    {
        if(model != null) {
            model.removeListDataListener(this);
        }
        model = modelIn;
        if(model != null) {
            model.addListDataListener(this);
        }
        recreateCards();
    }

    public int getCardWidthMin()
    {
        return cardWidthMin;
    }

    public void setCardWidthMin(int cardWidthMin)
    {
        this.cardWidthMin = cardWidthMin;
        relayoutCards(0);
    }

    public int getCardInset()
    {
        return cardInset;
    }

    public void setCardInset(int cardInset)
    {
        this.cardInset = cardInset;
        relayoutCards(0);
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
