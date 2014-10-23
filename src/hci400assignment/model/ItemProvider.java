/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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
    protected final List<Item> itemList;
    protected final List<ListDataListener> dataListenerList;
    protected Comparator<Item> sorter;

    public ItemProvider()
    {
        itemList = new ArrayList<Item>();
        dataListenerList = new CopyOnWriteArrayList<ListDataListener>();
    }

    public ItemProvider(List<Item> itemListIn)
    {
        this();
        itemList.addAll(itemListIn);
    }

    public void add(Item newItem)
    {
        int size;
        synchronized(itemList) {
            size = itemList.size();
        }
        if(sorter == null) {
            int index = size;
            add(index, newItem);
            return;
        }

        synchronized(itemList) {
            itemList.add(newItem);
            Collections.sort(itemList, sorter);
            size = itemList.size();
        }
        ListDataEvent ev = new ListDataEvent(
          this, ListDataEvent.CONTENTS_CHANGED,
          0, size - 1);
        for(ListDataListener listener : dataListenerList) {
            listener.contentsChanged(ev);
        }

//        int index = 0;
//        for(; index < itemList.size(); index++) {
//            Item item = itemList.get(index);
//            int diff = sorter.compare(newItem, item);
//            if(diff > -1) {
//                break;
//            }
//        }
//        itemList.add(index, newItem);
//        ListDataEvent ev = new ListDataEvent(
//          this, ListDataEvent.INTERVAL_ADDED,
//          index, index
//        );
//        for(ListDataListener listener : dataListenerList) {
//            listener.intervalAdded(ev);
//        }
    }

    private void add(int index, Item newItem)
    {
        if(sorter != null) {
            throw new IllegalStateException(
              "Cannot insert to a specific index of a sorted ItemProvider");
        }
        synchronized(itemList) {
            itemList.add(index, newItem);
        }
        ListDataEvent ev = new ListDataEvent(
          this, ListDataEvent.INTERVAL_ADDED,
          index, index);
        for(ListDataListener listener : dataListenerList) {
            listener.intervalAdded(ev);
        }
    }

    public void remove(Item item)
    {
        throw new UnsupportedOperationException("NYI");
    }

    public Comparator<Item> getSorter()
    {
        return sorter;
    }

    public void setSorter(Comparator<Item> sorterIn)
    {
        sorter = sorterIn;
        if(sorter == null) {
            return;
        }

        int size;
        synchronized(itemList) {
            Collections.sort(itemList, sorter);
            size = itemList.size();
        }

        ListDataEvent ev = new ListDataEvent(
          this, ListDataEvent.CONTENTS_CHANGED,
          0, size - 1);
        for(ListDataListener listener : dataListenerList) {
            listener.contentsChanged(ev);
        }
    }

    @Override
    public int getSize()
    {
        synchronized(itemList) {
            return itemList.size();
        }
    }

    @Override
    public Object getElementAt(int i)
    {
        synchronized(itemList) {
            return itemList.get(i);
        }
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
