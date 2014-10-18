/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment.model;

import hci400assignment.gui.minimal.PreviewCard;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Declan White
 */
public class Item
{

    public Image getPreviewImage()
    {
        try {
            return ImageIO.read(PreviewCard.class.getResourceAsStream(
                "/hci400assignment/resources/curtin-logo.jpg"
              )
            );
        } catch(IOException ex) {
            System.err.println("meow "+ex);
            System.exit(-1);
        }
        return null;
    }

    public String getPreviewText()
    {
        return "Text text text!";
    }
    
}
