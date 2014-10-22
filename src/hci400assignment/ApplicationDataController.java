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

    public ItemProvider getHomePreviewFeed()
    {
        ItemProvider itemProvider = new ItemProvider();
        fetchRSS(itemProvider, "http://www.engadget.com/rss.xml");
        fetchRSS(itemProvider, "http://www.fivedollarfinds.com/feed/");
        fetchRSS(itemProvider, "http://wtfevolution.tumblr.com/rss");

        return itemProvider;
    }

    public void fetchRSS(
      final ItemProvider provider,
      final String uriString
    )
    {
        Thread feedFetchThread = new Thread()
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
        };
        feedFetchThread.start();

    }
}
