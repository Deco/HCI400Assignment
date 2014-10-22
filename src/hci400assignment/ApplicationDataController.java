/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import hci400assignment.model.Article;
import hci400assignment.model.Item;
import hci400assignment.model.ItemProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Declan White
 */
public class ApplicationDataController
{
    static {
        {
            System.setProperty("http.agent", "Mozilla/5.0");
        }
    }

    public CardProvider getHomePreviewFeed()
    {
        ItemProvider itemProvider = new ItemProvider();
        fetchRSS(itemProvider, "http://www.engadget.com/rss.xml");
        fetchRSS(itemProvider, "http://www.fivedollarfinds.com/feed/");
        fetchRSS(itemProvider, "http://wtfevolution.tumblr.com/rss");

        return new CardProvider(itemProvider);
    }

    public void fetchRSS(
      final ItemProvider provider,
      final String uriString
    )
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    URL url = new URL(uriString);
                    SyndFeedInput input = new SyndFeedInput();
                    SyndFeed feed = input.build(new XmlReader(url));

                    List<SyndEntryImpl> entryList
                      = (List<SyndEntryImpl>)feed.getEntries();

                    for(SyndEntryImpl entry : entryList) {

                        Article article = new Article();
                        article.setTitle(entry.getTitle());
                        article.setAuthor(entry.getAuthor());

                        StringBuilder contentHTMLBuilder = new StringBuilder();

                        List<SyndContentImpl> contentList
                          = (List<SyndContentImpl>)entry.getContents();

                        if(contentList.isEmpty()) {
                            contentHTMLBuilder.append(
                              entry.getDescription().getValue()
                            );
                        } else {
                            for(SyndContentImpl content : contentList) {
                                contentHTMLBuilder.append(
                                  content.getValue()
                                );
                                contentHTMLBuilder.append("<br/><hr/><br/>");
                            }
                        }

                        article.setContentHTML(contentHTMLBuilder.toString());

                        provider.add(article);
                    }
                } catch(Exception ex) {
                    System.err.println("Could not fetch feed.");
                    ex.printStackTrace(System.err);
                    System.exit(-1);
                }
            }
        });

    }

    public class CardProvider
      implements ListModel, ListDataListener
    {
        private final ItemProvider itemProvider;
        private List<ListDataListener> dataListenerList;

        private CardProvider(ItemProvider itemProviderIn)
        {
            itemProvider = itemProviderIn;
        }

        @Override
        public int getSize()
        {
            return itemProvider.getSize();
        }

        @Override
        public void contentsChanged(ListDataEvent event)
        {
            ListDataEvent propagatedEvent = new ListDataEvent(
              this, ListDataEvent.CONTENTS_CHANGED,
              event.getIndex0(), event.getIndex1()
            );
            for(ListDataListener listener : dataListenerList) {
                listener.intervalAdded(propagatedEvent);
            }
        }

        @Override
        public void intervalAdded(ListDataEvent event)
        {
            ListDataEvent propagatedEvent = new ListDataEvent(
              this, ListDataEvent.INTERVAL_ADDED,
              event.getIndex0(), event.getIndex1()
            );
            for(ListDataListener listener : dataListenerList) {
                listener.intervalAdded(propagatedEvent);
            }
        }

        @Override
        public void intervalRemoved(ListDataEvent event)
        {
            ListDataEvent propagatedEvent = new ListDataEvent(
              this, ListDataEvent.INTERVAL_REMOVED,
              event.getIndex0(), event.getIndex1()
            );
            for(ListDataListener listener : dataListenerList) {
                listener.intervalAdded(propagatedEvent);
            }
        }

        @Override
        public Object getElementAt(int i)
        {
            return itemProvider.getElementAt(i);
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
}
