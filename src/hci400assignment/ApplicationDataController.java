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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Declan White
 */
public class ApplicationDataController
{
    static {{
      System.setProperty("http.agent", "Mozilla/5.0");  
    }}
    
    public CardProvider getHomePreviewFeed()
    {
//        return new CardProvider(fetchRSS("http://www.engadget.com/rss.xml"));
        return new CardProvider(fetchRSS("http://www.fivedollarfinds.com/feed/"));
//        return new CardProvider(fetchRSS("http://wtfevolution.tumblr.com/rss"));
    }
    
    public List<Item> fetchRSS(String uriString)
    {
        List<Item> articleList = new ArrayList<Item>();
        
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
                    contentHTMLBuilder.append(entry.getDescription().getValue());
                } else {
                    for(SyndContentImpl content : contentList) {
                        contentHTMLBuilder.append(content.getValue());
                        contentHTMLBuilder.append("<br/><hr/><br/>");
                    }
                }
                
                article.setContentHTML(contentHTMLBuilder.toString());
                
                articleList.add(article);
            }
            
        } catch(Exception ex) {
            System.err.println("Could not fetch feed.");
            ex.printStackTrace(System.err);
            System.exit(-1);
        }
        
        return articleList;
    }
    
    public class CardProvider
      implements ListModel
    {
        
        private final List<Item> itemList;

        private CardProvider(List<Item> itemListIn)
        {
            itemList = new ArrayList<Item>(itemListIn);
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
        public void addListDataListener(ListDataListener ll)
        {
            // TODO
        }

        @Override
        public void removeListDataListener(ListDataListener ll)
        {
            // TODO
        }

    }
}
