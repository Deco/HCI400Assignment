/*
 * Curtin University - Human Computer Interface 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import hci400assignment.gui.minimal.MinimalPreviewCard;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author 16142600
 */
public class Article
  extends Item
{
    private Date publishDate;
    private String title;
    private String author;
    private Document contentDocument;
    private final List<Enclosure> enclosureList;

    public Article()
    {
        publishDate = new Date(100, 10, 30);//Util.randomDate();
        title = "Yay, swag!";
        author = "Paul Swaggins";
        contentDocument = Jsoup.parse(
          "<html> Stuff and things and <b>more</b> stuff."
          + "<br/> Picture:"
          //+ "<img src=\"http://i.imgur.com/sFEVfMB.jpg\">"
          + "<br/>Yay!"
        );
        enclosureList = new ArrayList<Enclosure>();
    }

    @Override
    public String getPreviewTitle()
    {
        return "<html>" + title;
    }

    @Override
    public String getPreviewText()
    {
        Document previewDocument = contentDocument.clone();
        previewDocument.select("img").remove();
        String text = previewDocument.text();
        text = text.substring(0, Math.min(300, text.length() - 1));
        return "<html>" + text;
    }

    private String getEnclosureImageURL()
    {
        for(Enclosure enclosure : enclosureList) {
            if(enclosure.type.startsWith("image")) {
                return enclosure.url;
            }
        }
        return null;
    }

    @Override
    public URL getPreviewImageURL()
    {
        String enclosureURL = getEnclosureImageURL();
        if(enclosureURL != null) {
            try {
                return new URL(enclosureURL);
            } catch(MalformedURLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        Elements imageElements = contentDocument.select("img");
        if(imageElements.size() > 0) {
            Element imageElement = imageElements.get(0);
            String src = imageElement.attr("abs:src");
            try {
                return new URL(src);
            } catch(MalformedURLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        return MinimalPreviewCard.class.getResource(
          "/hci400assignment/resources/curtin-logo.jpg"
        );
    }

    @Override
    public String getTextDump()
    {
        StringBuilder textDump = new StringBuilder();
        textDump.append(title);
        textDump.append(" ");
        textDump.append(author);
        textDump.append(" ");
        DateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
        textDump.append(df.format(publishDate));
        textDump.append(" ");
        textDump.append(contentDocument.text());
        return textDump.toString();
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getContentHTML()
    {
        return contentDocument.html();
    }

    public void setContentHTML(String contentHTML)
    {
        contentDocument = Jsoup.parse(contentHTML);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getPublishDate()
    {
        return publishDate;
    }

    public void setPublishDate(Date publishDate)
    {
        this.publishDate = publishDate;
    }

    public void addEnclosure(String type, String url)
    {
        enclosureList.add(new Enclosure(type, url));
    }

    public class Enclosure
    {
        public final String type;
        public final String url;

        public Enclosure(String type, String url)
        {
            this.type = type;
            this.url = url;
        }
    }
}
