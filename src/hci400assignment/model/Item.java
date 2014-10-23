/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import hci400assignment.gui.minimal.MinimalPreviewCard;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Declan White
 */
public abstract class Item
{

    public abstract String getPreviewTitle();

    public abstract String getPreviewText();

    public abstract URL getPreviewImageURL();

    public Image getPreviewImage()
    {
        try {
            return ImageIO.read(getPreviewImageURL());
        } catch(IOException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }

    public abstract String getTextDump();

}
