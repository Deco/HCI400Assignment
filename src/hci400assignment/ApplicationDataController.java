/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndImage;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import hci400assignment.model.Article;
import hci400assignment.model.Friend;
import hci400assignment.model.Item;
import hci400assignment.model.ItemProvider;
import hci400assignment.model.ItemProviderFilter;
import java.net.URL;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.ListModel;

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

    private ItemProvider homeProvider;
    private ItemProvider friendProvider;

    public ItemProvider getHomePreviewFeed()
    {
        if(homeProvider != null) {
            return homeProvider;
        }
        homeProvider = new ItemProvider();

        homeProvider.setSorter(new Comparator<Item>()
        {
            @Override
            public int compare(Item a, Item b)
            {
                Date dateA = ((Article)a).getPublishDate();
                Date dateB = ((Article)b).getPublishDate();
                return -dateA.compareTo(dateB);
            }
        });

        homeProvider.add(new Article());

        fetchRSS(homeProvider, "http://www.engadget.com/rss.xml");
        fetchRSS(homeProvider, "http://www.fivedollarfinds.com/feed/");
        fetchRSS(homeProvider, "http://wtfevolution.tumblr.com/rss");
        fetchRSS(homeProvider,
          "http://www.nasa.gov/rss/dyn/image_of_the_day.rss");

        return homeProvider;
    }

    public ItemProvider getFriendPreviewFeed()
    {
        if(friendProvider != null) {
            return friendProvider;
        }
        friendProvider = new ItemProvider();

        friendProvider.add(new Friend(
          "Rhys Davis", Util.randomDate(), "rhys.jpg"
        ));
        friendProvider.add(new Friend(
          "Liam Pilling", Util.randomDate(), "liam.jpg"
        ));
        friendProvider.add(new Friend(
          "Declan White", Util.randomDate(), "declan.jpg"
        ));
        friendProvider.add(new Friend(
          "Ashleah Grant", Util.randomDate(), "ash.png"
        ));
        friendProvider.add(new Friend(
          "Hamed Al-Hinai", Util.randomDate(), "hamed.jpg"
        ));
        friendProvider.add(new Friend(
          "David Jiang", Util.randomDate(), "david.jpg"
        ));

        return friendProvider;
    }

    public ItemProviderFilter getSearchPreviewFeed(ItemProvider... otherArray)
    {
        ItemProviderFilter searchProvider = new ItemProviderFilter(
          new ItemProviderFilter.TextFilterer(""),
          otherArray
        );
        return searchProvider;
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

                    String feedImageURL = null;
                    SyndImage feedImage = feed.getImage();
                    if(feedImage != null) {

                        feedImageURL = feedImage.getUrl();
                    }

                    for(SyndEntryImpl entry : entryList) {

                        Article article = new Article();
                        article.setTitle(entry.getTitle());
                        article.setAuthor(entry.getAuthor());
                        article.setPublishDate(entry.getPublishedDate());
                        article.setAvatar(feedImageURL);

                        List<SyndEnclosure> enclosureList
                          = (List<SyndEnclosure>)entry.getEnclosures();
                        for(SyndEnclosure enclosure : enclosureList) {
                            article.addEnclosure(
                              enclosure.getType(), enclosure.getUrl()
                            );
                        }

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
                    System.err.println("Could not fetch feed: " + uriString);
                    ex.printStackTrace(System.err);
                }
            }
        };
        feedFetchThread.start();

    }
}
