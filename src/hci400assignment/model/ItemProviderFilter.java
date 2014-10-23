/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Declan White
 */
public class ItemProviderFilter
  implements ListModel, ListDataListener
{
    private ItemProvider source;
    private Filterer filterer;
    private final List<Item> itemList;
    private final List<ListDataListener> dataListenerList;

    public ItemProviderFilter(ItemProvider sourceIn, Filterer filtererIn)
    {
        source = sourceIn;
        filterer = filtererIn;
        itemList = new ArrayList<Item>();
        dataListenerList = new CopyOnWriteArrayList<ListDataListener>();
    }

    private void refilter()
    {
        int size;
        synchronized(itemList) {
            itemList.clear();
            for(int itemI = 0; itemI < source.getSize(); itemI++) {
                Item item = (Item)source.getElementAt(itemI);
                if(filterer.filter(item)) {
                    itemList.add(item);
                }
            }
            size = itemList.size();
        }

        ListDataEvent ev = new ListDataEvent(
          this, ListDataEvent.CONTENTS_CHANGED,
          0, size - 1);
        for(ListDataListener listener : dataListenerList) {
            listener.contentsChanged(ev);
        }
    }

    public ItemProvider getSource()
    {
        return source;
    }

    public void setSource(ItemProvider source)
    {
        this.source = source;
        refilter();
    }

    public Filterer getFilterer()
    {
        return filterer;
    }

    public void setFilterer(Filterer filterer)
    {
        this.filterer = filterer;
        refilter();
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
    public void contentsChanged(ListDataEvent lde)
    {
        refilter();
    }

    @Override
    public void intervalAdded(ListDataEvent lde)
    {
        refilter();
    }

    @Override
    public void intervalRemoved(ListDataEvent lde)
    {
        refilter();
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


    public static abstract class Filterer
    {
        public abstract boolean filter(Item item);
    }

    public static class TextFilterer
      extends Filterer
    {
        private final String searchText;

        public TextFilterer(String searchTextIn)
        {
            searchText = searchTextIn;
        }

        @Override
        public boolean filter(Item item)
        {
            if("".equals(searchText)) {
                return true;
            }
            String fullText = item.getTextDump();

            boolean wasFound = Pattern.compile(
              Pattern.quote(searchText),
              Pattern.CASE_INSENSITIVE
            ).matcher(fullText).find();

            return wasFound;
        }
    }
}
