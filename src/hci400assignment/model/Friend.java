/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Declan White
 */
public class Friend
  extends Item
{
    private String name;
    private Date friendshipDate;
    private URL avatarURL;

    public Friend(String nameIn, Date dateIn, String avatarURLIn)
    {
        name = nameIn;
        friendshipDate = dateIn;
        avatarURL = Friend.class.getResource(
          "/hci400assignment/resources/friendavatars/" + avatarURLIn
        );
    }

    @Override
    public String getPreviewTitle()
    {
        return name;
    }

    @Override
    public String getPreviewText()
    {
        DateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
        return "<html>" + "Friends since: "
          + df.format(friendshipDate);
    }

    @Override
    public URL getPreviewImageURL()
    {
        return avatarURL;
    }

    @Override
    public String getTextDump()
    {
        StringBuilder textDump = new StringBuilder();
        textDump.append(name);
        textDump.append(" ");
        DateFormat df = new SimpleDateFormat("dd MMMM, yyyy");
        textDump.append(df.format(friendshipDate));
        return textDump.toString();
    }

}
