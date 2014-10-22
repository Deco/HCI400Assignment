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
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Map<String, Object> resourceMap;

    public Article()
    {
        publishDate = new Date(2014, (int)(12 * Math.random()), (int)(20 * Math.
          random()));
        title = "Yay, swag!";
        author = "Paul Swaggins";
        contentDocument = Jsoup.parse(
          "<html> Stuff and things and <b>more</b> stuff."
          + "<br/> Picture:"
          + "<img src=\"http://i.imgur.com/sFEVfMB.jpg\">"
          + "<br/>Yay!"
        );

    }

    public Image getPreviewImage()
    {
        try {
            return ImageIO.read(getPreviewImageURL());
        } catch(IOException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }

    @Override
    public URL getPreviewImageURL()
    {
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

    public String getPreviewText()
    {
        Document previewDocument = contentDocument.clone();
        previewDocument.select("img").remove();
        return previewDocument.html();
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
}
