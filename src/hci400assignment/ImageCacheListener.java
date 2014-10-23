/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import java.awt.Image;

/**
 *
 * @author Declan White
 */
public interface ImageCacheListener
{

    public void imageReady(Image image);
    
    public void imageError();
    
}
