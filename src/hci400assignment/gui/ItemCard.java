/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.gui;

import hci400assignment.model.Item;

/**
 *
 * @author Declan White
 */
public abstract class ItemCard
    extends Card
{
    protected Item item;

    public ItemCard()
    {
        super();
    }

    public ItemCard(Item itemIn)
    {
        super();

        setItem(itemIn);
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

    protected abstract void updateContent();
}
