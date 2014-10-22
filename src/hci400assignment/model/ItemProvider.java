/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Declan White
 */
public class ItemProvider
  implements ListModel
{
    private List<Item> itemList;
    private List<ListDataListener> dataListenerList;

    public ItemProvider()
    {
        itemList = new ArrayList<Item>();
        dataListenerList = new ArrayList<ListDataListener>();
    }

    public ItemProvider(List<Item> itemListIn)
    {
        this();
        itemList.addAll(itemListIn);
    }

    public void add(Item item)
    {
        int index = itemList.size();
        add(index, item);
    }

    private void add(int index, Item item)
    {
        itemList.add(index, item);
        ListDataEvent ev = new ListDataEvent(
          this, ListDataEvent.INTERVAL_ADDED,
          index, index
        );
        for(ListDataListener listener : dataListenerList) {
            listener.intervalAdded(ev);
        }
    }

    public void remove(Item item)
    {
        int index = itemList.size();
        add(index, item);

        dataListenerList = new ArrayList<ListDataListener>();
    }

    @Override
    public int getSize()
    {
        return itemList.size();
    }

    @Override
    public Object getElementAt(int i)
    {
        return itemList.get(i);
    }

    @Override
    public void addListDataListener(ListDataListener listener)
    {
        dataListenerList.add(listener);
    }

    @Override
    public void removeListDataListener(ListDataListener listener)
    {
        dataListenerList.remove(listener);
    }

}
