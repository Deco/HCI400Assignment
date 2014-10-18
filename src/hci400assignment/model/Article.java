/*
 * Curtin University - Human Computer Interface 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author 16142600
 */
public class Article
{
    private Date publishDate;
    private String title;
    private String author;
    private String contentHTML;
    private Map<String, Object> resourceMap;

    public Article()
    {
        publishDate = new Date(2014, (int)(12 * Math.random()), (int)(20 * Math.
          random()));
        title = "Yay, swag!";
        author = "Paul Swaggins";
        contentHTML =
          "<html> Stuff and things and <b>more</b> stuff. <br/> Picture: <img src=\"http://i.imgur.com/sFEVfMB.jpg\"> <br/>Yay!";
        
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getContent()
    {
        return contentHTML;
    }

    public void setContent(String content)
    {
        this.contentHTML = content;
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
